#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.pagedescription

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageDescriptionPublishSpec extends ComponentSpec {

    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String pathPage = "component/content/pagedescription"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagedescription"


    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Properties Description"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagedescription1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().equalsIgnoreCase("Page Properties Description")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Override in ${symbol_pound}viewport.label")
    def "Functionality of Component with Override"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Description"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagedescription2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().equalsIgnoreCase("Override of Page Description")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }


}
