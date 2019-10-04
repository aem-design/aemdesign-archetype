#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.touch

class TouchUITags extends TouchUI {

    static url = "/aem/tags.html"

    static expectedTitle = "AEM Tags"

    static at = { waitFor(10) { title.startsWith(expectedTitle) } }

    static content = {
        pageContent(required: true) { module PageContentModule }

        //image { index -> ${symbol_dollar}(".image") }

        // Active Item
        // foundation-collection-item coral-ColumnView-item is-active

        //pageContentItems(wait: true) { moduleList PageContentRow, ${symbol_dollar}(".coral-ColumnView-column.is-active")}

        //project { module  Article }
    }


    TouchUITags() {
        super()
    }

}

