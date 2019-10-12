#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.details.locationdetails


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class LocationDetailsPublishSpec extends ComponentSpec {

    String pathPage = "component/details/location-details"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/locationdetails"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Location Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}location-details1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should have sample heading"
        assert ${symbol_dollar}("${symbol_dollar}selector h1").text().trim().toLowerCase().contains("Location Detail 1".toLowerCase())

        and: "Should have data attribute latitude"
        assert ${symbol_dollar}(selector).attr("data-latitude") == "10.0"

        and: "Should have data attribute latitude"
        assert ${symbol_dollar}(selector).attr("data-longitude") == "12.0"

        and: "Should have data attribute latitude"
        assert ${symbol_dollar}(selector).attr("data-pages") != ""

        where:
        viewport << getViewPorts()
    }



    @Unroll("Functionality of Component Variant: Hidden in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Hidden "() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Location Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}location-details2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Component should be hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector}[hidden]").size() == 1

        where:
        viewport << getViewPorts()
    }
}
