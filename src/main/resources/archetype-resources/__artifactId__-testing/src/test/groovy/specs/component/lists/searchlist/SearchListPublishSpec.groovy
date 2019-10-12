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
    String language = "au/en"
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

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Search List Component Default with Query in ${symbol_pound}viewport.label")
    def "Functionality of Search List Component Default with Query"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Search List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}searchlist1"
        def stringQuery = "fulltext=city${symbol_escape}n" +
                "group.p.or=true${symbol_escape}n" +
                "group.1_group.path=/content/${contentFolderName}-showcase/au/en/component/lists/search-list${symbol_escape}n" +
                "group.1_group.type=cq:Page${symbol_escape}n" +
                "group.1_group.property=@jcr:content/hideInNav${symbol_escape}n" +
                "group.1_group.property.operation=exists${symbol_escape}n" +
                "group.1_group.property.value=false${symbol_escape}n" +
                "group.2_group.path=/content/dam/${contentFolderName}-showcase${symbol_escape}n" +
                "group.2_group.type=dam:Asset${symbol_escape}n" +
                "orderby=path"

        def query_string = "q=" + URLEncoder.encode(stringQuery, "UTF-8")

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPageWithQuery(language, query_string)

        printDebug("URL", driver.currentUrl)

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should contain results"
        assert ${symbol_dollar}(selector).find(".results").children().size() > 0

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }
}
