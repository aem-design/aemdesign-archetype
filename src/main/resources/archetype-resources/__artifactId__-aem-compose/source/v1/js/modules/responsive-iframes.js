export default () => {
  $(document).ready( () => {
    let $responsiveIframes = $('div[component].media-responsive iframe');
    let $window = $(window);

    if($responsiveIframes.length) {
      let setIframesHeight = () => {
        $responsiveIframes.each( (_, iframe)  => {
          let $iframe = $(iframe);
          let width = $iframe.width();
          let height = width / 1.77; //16:9
          $iframe.height(height);
        });
      };

      $window.resize();

      setTimeout(() => {
        setIframesHeight();
      } ,200);

      $window.resize( () => {
        setIframesHeight();
      })
    }
  });
}
