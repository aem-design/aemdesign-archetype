// import get from 'lodash/get'
// import isNil from 'lodash/isNil'
// import omitBy from 'lodash/omitBy'
// import 'owl.carousel'

// /**
//  * Page list configuration.
//  * @type {Object}
//  */
// const pageListConfiguration = {}

// /**
//  * Binds OwlCarousel carousel to given element.
//  *
//  * @param {Element} element An element to bind OwlCarousel to
//  * @param {Object}  options Custom options for this carousel
//  */
// const bindSlickToElement = (element, options = {}) => {
//   const $parent = $(element);
//   const $component = $parent.closest('[data-modules*="carousel"]');
//   let $slideNbr = $component.is('[class*="slide-"]')
//                     ? $component.attr('class').split(' ')
//                       .filter( item => item.includes('slide-') )
//                       .pop().split('-').pop()
//                     : 3;
//   $slideNbr = parseInt($slideNbr);



//   if (module.hot && $parent.hasClass('owl-loaded')) {
//     // Destory the current instance
//     $parent.owlCarousel('destroy')
//   } else {
//     // Add the OwlCarousel classes
//     $parent.addClass('owl-carousel owl-theme')

//     // Unwrap the LI elements from around the content within them.
//     $parent.children().each((_, item) => {
//       $(item).children().unwrap()
//     })
//   }

//   if($slideNbr !== 1) { // 3 slides per row ( default )
//     $parent.owlCarousel(omitBy({
//       center       : get(options, 'center', true),
//       itemElement  : get(options, 'itemElement', null),
//       items        : get(options, 'items', 1),
//       loop         : get(options, 'loop', true),
//       margin       : get(options, 'margin', 1),
//       mouseDrag    : get(options, 'mouseDrag', true),
//       nav          : get(options, 'nav', true),
//       slideBy      : get(options, 'slideBy', 1),
//       stageElement : get(options, 'stageElement', null),
//       stagePadding : get(options, 'stagePadding', 0),

//       responsive: {
//         0: omitBy({
//           stagePadding: get(options, 'breakpoint.0.stagePadding', 0),
//         }, isNil),

//         640: omitBy({
//           items        : get(options, 'breakpoint.640.items', 1),
//           stagePadding : get(options, 'breakpoint.640.stagePadding', 0),
//         }, isNil),

//         768: omitBy({
//           center  : get(options, 'breakpoint.768.center', false),
//           items   : get(options, 'breakpoint.768.items', 2),
//           slideBy : get(options, 'breakpoint.768.slideBy', 1),
//         }, isNil),

//         1400: omitBy({
//           center  : get(options, 'breakpoint.1400.center', false),
//           items   : get(options, 'breakpoint.1400.items', 3),
//           slideBy : get(options, 'breakpoint.1400.slideBy', 1),
//         }, isNil),
//       },
//     }, isNil))
//   }else{ // 1 slide per row
//     $parent.owlCarousel(omitBy({
//       center       : get(options, 'center', true),
//       itemElement  : get(options, 'itemElement', null),
//       items        : get(options, 'items', 1),
//       loop         : get(options, 'loop', true),
//       margin       : get(options, 'margin', 3),
//       mouseDrag    : get(options, 'mouseDrag', true),
//       nav          : get(options, 'nav', true),
//       slideBy      : get(options, 'slideBy', 1),
//       stageElement : get(options, 'stageElement', null),
//       stagePadding : get(options, 'stagePadding', 0)
//     }, isNil))
//   }

//   if($parent.find('.owl-stage-outer').length === 0) {
//     $parent.find('.owl-stage').wrap('<div class="owl-stage-outer"></div>');
//     $parent.find('.owl-prev, .owl-next').wrapAll('<div class="owl-nav"></div>');
//   }

//   //Set IFrame depending of providers Youtube or Kaltura
//   let $videos = $parent.find('.owl-item .card.video');

//   // Kaltura videos
//   let playerId  = 32783592;
//   let partnerId = 811441;

//   if($videos.length) {
//     $videos.each( (_, video)  => {
//       let $video = $(video);
//       let videoId = $video.find('a[title]').attr('title');
//       let hasKaltura = $video.hasClass('video-kaltura');
//       if (hasKaltura) {
//         $video.html(`<iframe src="https://cdnapisec.kaltura.com/p/${partnerId}/sp/${partnerId}00/embedIframeJs/uiconf_id/${playerId}/partner_id/${partnerId}?iframeembed=true&playerId=kaltura_player&entry_id=${videoId}" allowfullscreen></iframe>`);
//       } else {
//         $video.html(`<iframe src="https://www.youtube.com/embed/${videoId}" allowfullscreen></iframe>`);
//       }
//     });
//   }


//   // Add analytics data attributes
//   $parent.find('.owl-prev')
//     .attr('data-layer-event', 'site interaction')
//     .attr('data-layer-linktype', 'link')
//     .attr('data-layer-linklocation', 'pagelist')
//     .attr('data-layer-linkdescription', 'carousel left');

//   $parent.find('.owl-next')
//     .attr('data-layer-event', 'site interaction')
//     .attr('data-layer-linktype', 'link')
//     .attr('data-layer-linklocation', 'pagelist')
//     .attr('data-layer-linkdescription', 'carousel right');
// }

export default () => {
//   const carousels = [ ...document.querySelectorAll('[data-modules*="carousel"]') ]

//   if (carousels.length) {
//     // Initalise the carousels
//     carousels.forEach(carousel => {
//       switch (true) {
//         case carousel.classList.contains('pagelist'):
//           bindSlickToElement(carousel.querySelector('ul'), pageListConfiguration)
//           break

//         default:
//           console.warn('Carousel definition not defined for:', carousel)
//       }
//     })
//   }
}
