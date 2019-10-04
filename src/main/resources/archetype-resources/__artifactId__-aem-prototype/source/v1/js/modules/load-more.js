import { LOAD_MORE_CLASS } from '../utilities/constants'

/**
 * Removes the load more button from the list so users can't load in empty pages
 * that don't contain any list items.
 *
 * @param {Element} list The DOM element for the list
 */
const removeLoadMoreButtonFromList = list => {
  const button = list.querySelector(`.${LOAD_MORE_CLASS}`)

  if (button) {
    list.removeChild(button)
  }
}

/**
 * Appends the new items to the parent list.
 *
 * @param {Element} list  The DOM element for the list
 * @param {Array}   items An collection of DOM elements to append to the list
 */
const appendLoadedItemsToList = (list, items) => {
  const listElement = list.querySelector('ul')
  const totalPages  = parseInt(list.dataset.totalPages, 10)

  // Correct the classes for the items
  const listitems = items.map((item, index) => {
    // Remove the 'first' or 'last' class from the item and add 'item' to it
    //
    // NOTE: It might seem redundant calling `remove` twice but this is to ensure support
    // for Internet Explorer 11 and below which don't support multiple parameters.
    item.classList.add('item')
    item.classList.remove('first')

    // Add or remove the class 'last' depending on if it's the last item
    item.classList[index === items.length - 1 ? 'add' : 'remove']('last')

    return item
  })

  // Before appending the new items, we need to alter the last item in the list
  // by removing the 'last' class and replacing it with 'item'
  const lastItem = listElement.querySelector('li.last')

  if (lastItem) {
    lastItem.classList.remove('last')
    lastItem.classList.add('item')
  }

  // Now... at the new items
  listitems.forEach(item => listElement.appendChild(item))

  // Increment the current page for the list
  list.currentPage = list.currentPage + 1

  // Do we need to hide the load more button?
  if (list.currentPage - 1 === totalPages) {
    removeLoadMoreButtonFromList(list)
  }
}

/**
 * Requests the partial content for list to append to the current list.
 *
 * @param {Element} list The DOM element for the list
 */
const requestNextPageForList = list => {
  const contentUrl     = list.dataset.contentUrl
  const queryParameter = list.dataset.contentStart

  // Make the request to get the next page of content
  $.get(`${contentUrl}?${queryParameter}=${list.currentPage + 1}`).done(data => {
    const html      = $(data).get(0)
    const listItems = [ ...html.querySelectorAll('li') ]

    // Append the items to the list if there are any, otherwise remove the load more
    // button since no more content is coming through.
    if (listItems.length) {
      appendLoadedItemsToList(list, listItems)
    } else {
      removeLoadMoreButtonFromList(list)
    }
  })
}

/**
 * Bind a click event to the load more button.
 *
 * @param {Element} list   The DOM element for the list
 * @param {Element} button The load more element
 */
const bindLoadMoreEventListener = (list, button) => {
  button.addEventListener('click', e => {
    e.preventDefault()

    // Get the next set of results
    requestNextPageForList(list)
  })
}

/**
 * Creates a load more button and appends it to the list.
 *
 * @param {Element} list The DOM element for the list
 */
const appendLoadMoreToList = list => {
  const button = document.createElement('button')
  button.setAttribute('class', `btn btn-primary ${LOAD_MORE_CLASS}`)
  button.innerText = 'Load more'

  // Bind a click event to the button
  bindLoadMoreEventListener(list, button)

  // Append the button
  list.insertAdjacentElement('beforeend', button)
}

export default () => {
  // Find all of the lists
  const lists = [ ...document.querySelectorAll('[data-has-pages="true"]') ]

  if (lists.length) {
    console.info('Setting any page lists up with pagingation!')

    lists.forEach(list => {
      // Create the load more button
      appendLoadMoreToList(list)

      // Set the starting point for the load more functionality
      list.currentPage = 0
    })
  }
}
