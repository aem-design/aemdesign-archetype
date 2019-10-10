import '@fancyapps/fancybox'

export default () => {
  let $fancyboxes = $('[class*="fancybox-"]');
  if($fancyboxes.length > 0) {
      console.info('Fancybox has loaded.');
      $fancyboxes.attr('data-fancybox', '');

      $('[data-fancybox]').fancybox({
        afterShow: function( instance, current ) {
          let $element = $(this.opts.$orig[0]);
          let size_class = $element.attr('class').split(' ').filter( item => item.split('fancybox-').length === 2 ).pop();
          $('.fancybox-container').find('.fancybox-content').addClass(size_class);
        }
      });
  }
}
