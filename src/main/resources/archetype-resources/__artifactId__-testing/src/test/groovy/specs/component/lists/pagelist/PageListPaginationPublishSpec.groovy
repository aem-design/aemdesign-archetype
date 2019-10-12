#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.pagelist

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageListPaginationPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/page-list/pagination"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagelist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with Default variant and Horizontal Badge in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant and Horizontal Badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List" > "Pagination"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has one list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 1

        and: "Only next link exists on first page, without previous link"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        assert ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next").isDisplayed()
        assert !${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .previous").isDisplayed()

        and: "Has pagination details"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .pagination .current").text().trim() == "1"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on first page")

        and: "Can select page 2"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next > a").click()
        assert ${symbol_dollar}("${symbol_dollar}{selector} .pagination .current").text().trim() == "2"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on second page")

        and: "Can select page 3"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next > a").click()
        assert ${symbol_dollar}("${symbol_dollar}{selector} .pagination .current").text().trim() == "3"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on third page")

        and: "Can select page 4"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next > a").click()
        assert ${symbol_dollar}("${symbol_dollar}{selector} .pagination .current").text().trim() == "4"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on forth page")

        and: "Can select page 5"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next > a").click()
        assert ${symbol_dollar}("${symbol_dollar}{selector} .pagination .current").text().trim() == "5"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on fifth page")

        and: "Only previous link exists on last page, without next link"
        scrollIntoView(${symbol_dollar}("${symbol_dollar}{selector} .pagination").firstElement())
        assert !${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .next").isDisplayed()
        assert ${symbol_dollar}("${symbol_dollar}{selector} > .pagination > .previous").isDisplayed()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }
}
