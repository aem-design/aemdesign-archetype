$(() => {

  // Resize fix, polls every 100 milliseconds until the CSS has been loaded and then triggers a
  // global resize event to prevent weird layout issues.
  const header = document.querySelector('.brand-header')

  if (header) {
    let itv = setInterval(() => {
      if (window.getComputedStyle(header).position === 'fixed') {
        clearInterval(itv)
        $(window).trigger('resize')
      }
    }, 100)
  }

})

// HMR (Hot Module Replacement)
if (module.hot) {
  // module.hot.accept()
}
