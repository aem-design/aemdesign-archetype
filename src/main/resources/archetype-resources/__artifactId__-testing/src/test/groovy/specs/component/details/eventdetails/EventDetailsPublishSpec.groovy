#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.details.eventdetails


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class EventDetailsPublishSpec extends ComponentSpec {

    String pathPage = "component/details/event-details"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/event_details"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Event Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}event-details1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Should have sample heading"
        assert ${symbol_dollar}("${symbol_dollar}selector h1").text().trim().toLowerCase().equals("Event Details".toLowerCase())

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text().trim() == "Event to showcase all events"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.card-subtitle").text().trim() == "Mon 1 October to Fri 5 October"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.card-date").text().trim() == "9AM to 9AM"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Hidden in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Hidden "() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Event Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}event-details2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Component should be empty"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").isEmpty() == true

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Formatting in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Formatting "() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Event Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}event-details3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Should have sample heading"
        assert ${symbol_dollar}("${symbol_dollar}selector h1").text().trim().toLowerCase().equals("Event Details".toLowerCase())

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text().trim() == "Event to showcase all events"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.card-subtitle").text().trim() == "Mon 1 October to Fri 5 October"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.card-date").text().trim() == "9AM to 9AM"


        where:
        viewport << getViewPorts()
    }


    def "Event Details: Default metadata added to page"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Event Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}event-details"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Page has metadata field og:title"
        assert ${symbol_dollar}("meta[property='og:title']").attr("content").equals("Event Details")

        and: "Page has metadata field og:type"
        assert ${symbol_dollar}("meta[property='og:type']").attr("content").equals("article")

        and: "Page has metadata field og:image"
        assert ${symbol_dollar}("meta[property='og:image']").attr("content").contains("event-details.thumb.")

        and: "Page has metadata field og:url"
        assert ${symbol_dollar}("meta[property='og:url']").attr("content").contains("details/event-details.html")

        and: "Page has canonical link"
        assert ${symbol_dollar}("link[rel='canonical']").attr("href").contains("details/event-details.html")

    }


}
