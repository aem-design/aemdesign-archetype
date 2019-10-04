#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.classic

class ClassicUITags extends ClassicUI {

    static url = "/tagging"

    static expectedTitle = "AEM Tagging"

    static at = { waitFor(30) { title.startsWith(expectedTitle) } }

    static content = {


    }

    ClassicUITags() {
        super()
    }
}
