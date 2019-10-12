#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.pagetitle

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageTitlePublishSpec extends ComponentSpec {

    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String pathPage = "component/content/pagetitle"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagetitle"


    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Title"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagetitle1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().equalsIgnoreCase("Page Title")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component: Override Title in ${symbol_pound}viewport.label")
    def "Functionality of Component: Override Title"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Title"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagetitle2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().equalsIgnoreCase("Override of Page Title")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample text")

        where:
        viewport << getViewPorts()
    }


}
