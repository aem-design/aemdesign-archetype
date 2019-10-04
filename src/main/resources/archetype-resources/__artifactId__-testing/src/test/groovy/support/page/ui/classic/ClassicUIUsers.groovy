#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.classic

class ClassicUIUsers extends ClassicUI {

    static url = "/useradmin"

    static expectedTitle = "AEM Security"

    static at = { waitFor(30) { title.startsWith(expectedTitle) } }

    static content = {


    }

    ClassicUIUsers() {
        super()
    }
}
