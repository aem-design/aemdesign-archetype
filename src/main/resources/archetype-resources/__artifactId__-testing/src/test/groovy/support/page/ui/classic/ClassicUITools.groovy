#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.classic

class ClassicUITools extends ClassicUI {

    static url = "/miscadmin"

    static expectedTitle = "AEM Tools"

    static at = { waitFor(30) { title.startsWith(expectedTitle) } }

    static content = {


    }

    ClassicUITools() {
        super()
    }
}
