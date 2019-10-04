// Inject the Sass into the page
import '../scss/styleguide.scss'
import '../scss/app.scss'

// Core modules...
import Carousels from './modules/carousel'
import ParallaxImage from './modules/parallaximage'
import LoadMore from './modules/load-more'
import Subscribers from './modules/subscribers'
import NavToggler from './modules/navtoggler'
import FancyBox from './modules/fancybox'
import ResponsiveIframes from './modules/responsive-iframes'
import EmbedMedia from './modules/embedMedia'

import {
  TOPIC_HIDE_SUGGESTIONS,
} from './utilities/constants'

import { isAuthorEditMode } from './utilities/aem'

// Begin the app...
$(() => {

  // Remove the 300ms delay using FastClick
  /* global FastClick */
  FastClick.attach(document.body)

  // Listen for clicks on the body
  $(document.body).on('click', e => {
    const $suggestions = $('.suggestions')
    const $target      = $(e.target)

    if ($suggestions.length && !$target.is('.suggestions') && !$target.parents('.suggestions').length) {
      PubSub.publish(TOPIC_HIDE_SUGGESTIONS)
    }
  })

  // Load more functionality for page lists
  LoadMore()

  // Carousel functionality for anything, this dynamically loads slick carousel
  // to reduce the weight of the page.
  Carousels()

  // Bind the pub/sub event subscribers
  Subscribers()

  // Brand header
  ParallaxImage()

  NavToggler();

  FancyBox();

  ResponsiveIframes();

  EmbedMedia();

  // 'object-fit' polyfill for unsupported browsers
  /* global ObjectFitImages */
  ObjectFitImages()

  // Open all the 'collapse' elements on the page when in author
  if (isAuthorEditMode()) {
    $('.collapse[data-parent]').collapse('dispose')
  }

  //Hide event card's parent when hidden modifier is set to event list.
  $('.eventlist[component].hidden .card.finished').parent().hide();

  //Add tab index -1 to past events.
  $('.card.finished .btn').attr('tabindex', '-1');


  // Disable parallax effect on touch screen.
  let $pagesParallax = $('[component].bg-parallax');
  if( 'ontouchstart' in document.documentElement && $(window).width() < 992 ) {
    $pagesParallax.addClass('bg-scroll');
    console.log('Parallax disabled')
  }


})

// HMR (Hot Module Replacement)
if (module.hot) {
  module.hot.accept()
}

if(navigator.userAgent.match(/Trident\/7\./)) {
  document.body.addEventListener("mousewheel", function() {
    event.preventDefault();
    let wd = event.wheelDelta;
    let csp = window.pageYOffset;
    window.scrollTo(0, csp - wd);
  });
}
