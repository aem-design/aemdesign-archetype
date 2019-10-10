/*module: navtoggler */

export default () => {
  $(document).ready( () => {
      let $navToggler = $('[data-modules="navtoggler"]');
      let $navBar = $('div[component].navbar-nav ul');
      let $menuItems = $('div[component].navbar-nav ul > li');

      $navToggler.click(() => {
        $navToggler.toggleClass('collapsed');
        $navBar.slideToggle();
      });

      $menuItems.click(() => {
        if($navToggler.hasClass('collapsed')) {
          $navToggler.removeClass('collapsed');
          $navBar.slideUp();
        }
      });
  });
}
