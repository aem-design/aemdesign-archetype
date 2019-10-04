#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.pageauthor

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageAuthorPublishSpec extends ComponentSpec {

    String pathPage = "component/content/pageauthor"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/pageauthor"


    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Author"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pageauthor1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Administrator")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Author"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pageauthor2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Administrator")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default with Override in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Override"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Author"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pageauthor3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Author Full Name")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Simple with Override in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Override"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Page Author"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pageauthor4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample text"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Author Full Name")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        where:
        viewport << getViewPorts()
    }


}
