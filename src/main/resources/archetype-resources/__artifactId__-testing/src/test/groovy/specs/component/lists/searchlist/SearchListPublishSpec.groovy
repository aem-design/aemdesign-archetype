#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.searchlist

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class SearchListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/search-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock2/par/searchlist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Search List Component Variant: Default without Query in ${symbol_pound}viewport.label")
    def "Functionality of Search List Component Variant: Default without Query"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Search List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}searchlist1"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should be empty and contain default text"
        assert ${symbol_dollar}(selector).children().size() == 1 &&  ${symbol_dollar}(selector).children().text().contains("Invalid query given!")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Search List Component Default with Query in ${symbol_pound}viewport.label")
    def "Functionality of Search List Component Default with Query"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Search List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}searchlist1"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"
        def query_string = "q=fulltext%3Dtime%0D%0Agroup.p.or%3Dtrue%0D%0Agroup.1_group.path%3D%2Fcontent%2F${contentFolderName}-showcase%2Fen%2Fcomponent%2Flists%2Fsearch-list%0D%0Agroup.1_group.type%3Dcq%3APage%0D%0Agroup.1_group.property%3D%40jcr%3Acontent%2FhideInNav%0D%0Agroup.1_group.property.operation%3Dexists%0D%0Agroup.1_group.property.value%3Dfalse%0D%0Agroup.2_group.path%3D%2Fcontent%2F${contentFolderName}-showcase%2Fen%2Fcomponent%2Flists%2Fsearch-list%0D%0Agroup.2_group.type%3Ddam%3AAsset"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPageWithQuery(language, query_string)

        printDebug("URL", driver.currentUrl)

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should contain results"
        assert ${symbol_dollar}(selector).find(".results").children().size() > 0

        where:
        viewport << getViewPorts()
    }
}
