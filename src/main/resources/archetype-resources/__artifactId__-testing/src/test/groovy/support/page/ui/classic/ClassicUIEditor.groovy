#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.classic

class ClassicUIEditor extends ClassicUI {

    static url = "/cf${symbol_pound}"

    static expectedTitle = "AEM Content Finder"

    static at = {
        waitFor {
            js.exec("return (window.CQ?true:false)")
        }
    }

    static content = {

        container(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}CQ") }

        pageContent(wait: true) { module PageContentModule }

        currentWindow(wait: true) { module CurrentWindow }


    }

    ClassicUIEditor() {
        super()
    }
}
