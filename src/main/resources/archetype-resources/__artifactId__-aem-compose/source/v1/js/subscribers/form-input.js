import {
  EVENT_TYPE_CLICK,
  EVENT_TYPE_KEYDOWN,
  EVENT_TYPE_KEYUP,
} from '../utilities/constants'

/**
 * Handles the behaviour of the input field when a user is typing.
 *
 * @param  {jQuery}  $target The target element object
 * @param  {jQuery}  $input  The input element object
 * @param  {Object}  event   The event object
 * @return {Boolean}
 */
function handleInputFieldUserInput($target, $input, event) {
  const value = $input.val()

  // Handle the submission of the input when the enter key is pressed
  if (event.keyCode === 13) {
    console.info('[Form Input] User pressed the enter key on the input field')
    return true
  }

  // Toggle the clear button depending on whether the input has a value
  $input.next()[`${value.length ? 'add' : 'remove'}Class`]('active')

  return false
}

/**
 * Handles the behaviour of when the clear button is clicked.
 *
 * @param  {jQuery}  $target The target element object
 * @param  {jQuery}  $input  The input element object
 * @param  {Object}  event   The event object
 * @return {Boolean}
 */
function handleClearInputButton($target, $input, event) {
  // Clear the input field
  $input.val('')

  // Hide the clear button
  $target.removeClass('active')

  // Focus on the input field again
  $input.get(0).focus()

  return true
}

export default (event, originalEvent, type) => {
  const $target = $(originalEvent.target)

  let $input           = $target
  let callbackFunction = null
  let preventDefault   = false

  // Is the target an input field? If so detect key events and toggle the clear button
  if ($input.is(':text') && (type === EVENT_TYPE_KEYDOWN || type === EVENT_TYPE_KEYUP)) {
    console.info('[Form Input] Text input found', $input)
    callbackFunction = handleInputFieldUserInput

  // Basic clear which searches for a previous sibling that is the input type. Also checks to ensure
  // the triggered event was for a click.
  } else if (
    ($input = $target.prev('input[type=text]')).length === 1 &&
    type === EVENT_TYPE_CLICK
  ) {
    console.log(originalEvent)
    console.info('[Form Input] Input field found next to the target!', $input)
    callbackFunction = handleClearInputButton
  }

  // Was an action defined?
  if (typeof callbackFunction === 'function') {
    preventDefault = callbackFunction($target, $input, originalEvent)
  } else {
    console.warn('[Form Input] Unable to determine the context for the trigger:', type)
  }

  // Prevent the default submit action
  if (preventDefault) {
    // originalEvent.stopImmediatePropagation()
    originalEvent.preventDefault()
  }
}
