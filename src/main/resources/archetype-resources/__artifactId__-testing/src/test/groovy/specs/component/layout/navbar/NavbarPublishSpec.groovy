#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.navbar

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class NavbarPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/navbar"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/navbar"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component in ${symbol_pound}viewport.label")
    def "Functionality of Component"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Navbar"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}plainnavbar"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Navbar Content"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample rich text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Background in ${symbol_pound}viewport.label")
    def "Functionality of Component with Background"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Navbar"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}navbarwithbackground"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Navbar Content with Background"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample rich text")

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").contains(".png")

        where:
        viewport << getViewPorts()
    }


}
