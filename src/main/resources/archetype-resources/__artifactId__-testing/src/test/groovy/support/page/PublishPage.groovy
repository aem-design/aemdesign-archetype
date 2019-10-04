#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page

import geb.Module

class PublishPage extends AEMPage {

    static url = ""

    static at = {

    }

    static content = {
        pageContent(required: true) { module PageContentModule }
    }

    PublishPage() {
        super()
    }

}

class PageContentModule extends Module {
    static base = { ${symbol_dollar}("${symbol_pound}main") }
    static content = {

    }

}
