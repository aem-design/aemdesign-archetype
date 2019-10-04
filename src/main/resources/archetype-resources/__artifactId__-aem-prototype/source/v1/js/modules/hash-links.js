export default () => {
  const hashLinks = [...document.querySelectorAll('[href*="#"]')]

  if (hashLinks.length) {
    hashLinks.forEach(hashLink => {
      // Only take control of links that have a valid hash value
      if (hashLink.hash && hashLink.hash.length) {
        hashLink.addEventListener('click', e => {
          e.preventDefault()

          const target = document.querySelector(e.target.hash)
          const offset = target.getBoundingClientRect()

          // Scroll to the position on the page
          window.scrollTo(0, offset.top - 50)
        })
      }
    })
  }
}
