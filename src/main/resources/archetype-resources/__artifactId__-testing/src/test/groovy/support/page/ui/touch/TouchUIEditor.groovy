#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.touch

class TouchUIEditor extends TouchUI {

    static url = "/editor.html"

    static expectedTitle = "AEM Editor"

    static PAGE_FRAME_CONTENT = "ContentFrame"

    static at = {
        waitFor(10) {
            !${symbol_dollar}("${symbol_pound}SidePanel").isEmpty() && !${symbol_dollar}("${symbol_pound}Content").isEmpty()
        }
    }

    static content = {
        pageContent(required: true) { module PageContentModule }

        //image { index -> ${symbol_dollar}(".image") }

        // Active Item
        // foundation-collection-item coral-ColumnView-item is-active

        //pageContentItems(wait: true) { moduleList PageContentRow, ${symbol_dollar}(".coral-ColumnView-column.is-active")}

        //project { module  Article }
    }

    TouchUIEditor() {
        super()
    }

//    TouchUIEditor(String pageTitle) {
//        if (pageTitle != null && !pageTitle.isEmpty()) {
//            expectedTitle = pageTitle
//        }
//    }

    def waitForPageContent() {
        return waitFor {
            return ${symbol_dollar}("${symbol_pound}Content")
        }
    }
}

