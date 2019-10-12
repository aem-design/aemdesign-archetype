#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.widgets.sharebutton


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ShareButtonPublishSpec extends ComponentSpec {

    String pathPage = "component/widgets/sharebutton"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/sharebutton"


    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default loads non-inline elements in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default loads non-inline elements"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}sharebutton1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Add this modules have been loaded"
        waitFor(15, 0.1) { js.exec("return window.addthis?true:false;") }

        and: "Should have add this loaded"
        assert js.exec("return window.addthis?true:false;")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Inline with Share Tool Box in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Inline with Share Tool Box"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}atstbx"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have embeded component"
        assert ${symbol_dollar}(selector).size() > 0
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have embeded component")

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Inline with Follow Tool Box in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Inline with Follow Tool Box"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}atftbx"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have embeded component"
        assert ${symbol_dollar}(selector).size() > 0
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have embeded component")

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Inline with Tip Jar in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Inline with Tip Jar"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}attj"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have embeded component"
        assert ${symbol_dollar}(selector).size() > 0
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have embeded component")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Inline with Related Posts in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Inline with Related Posts"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = ".at4-recommendedbox-outer-container"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have embeded component"
        assert ${symbol_dollar}(selector).size() > 0

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image6"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have embeded component"
        assert ${symbol_dollar}(selector).size() > 0
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have embeded component")

        where:
        viewport << getViewPorts()
    }

}
