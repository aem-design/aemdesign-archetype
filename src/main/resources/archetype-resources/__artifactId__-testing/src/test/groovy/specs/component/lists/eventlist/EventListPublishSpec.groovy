#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.eventlist


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class EventListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/event-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/eventlist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Page List: Default variant using Default badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Default badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Event List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}eventlist1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        where:
        viewport << getViewPorts()
    }

}
