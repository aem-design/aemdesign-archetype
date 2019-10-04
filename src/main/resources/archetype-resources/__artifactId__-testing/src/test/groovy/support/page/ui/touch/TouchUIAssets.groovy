#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.touch

class TouchUIAssets extends TouchUI {

    static url = "/assets.html"

    static expectedTitle = "AEM Assets"

    static at = { waitFor(10) { title.startsWith(expectedTitle) } }

    static content = {
        pageContent(required: true) { module PageContentModule }

        image { index -> ${symbol_dollar}(".image") }

        pageContentItems(wait: true) { moduleList PageContentRow, ${symbol_dollar}(".foundation-collection-item") }

        pageContentLoaded(required: true, wait: true) { ${symbol_dollar}("img") }
    }

    TouchUIAssets() {
        super()
    }
}
