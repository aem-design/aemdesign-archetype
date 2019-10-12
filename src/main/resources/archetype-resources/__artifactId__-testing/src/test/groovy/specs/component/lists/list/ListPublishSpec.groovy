#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.list

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/list"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("List: Default variant using Default badge in ${symbol_pound}viewport.label")
    def "List: Default variant using Default badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}list1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.first").size() == 1

        and: "Has last item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.last").size() == 1

        and: "Has three plain items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.item").size() == 3

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("List: Pages with no Details in ${symbol_pound}viewport.label")
    def "List: Pages with no Details"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}list7"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five items of page missing details"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .page-missing-details").size() == 5

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @IgnoreRest
    @Unroll("List: Pages search with By Tags in ${symbol_pound}viewport.label")
    def "List: Pages search with By Tags"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}list8"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two items in the list"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 2

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @IgnoreRest
    @Unroll("List: Pages search with By Tags with Tags not Specified in ${symbol_pound}viewport.label")
    def "List: Pages search with By Tags with Tags not Specified"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}list9"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Has zero items in the list"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 0

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
