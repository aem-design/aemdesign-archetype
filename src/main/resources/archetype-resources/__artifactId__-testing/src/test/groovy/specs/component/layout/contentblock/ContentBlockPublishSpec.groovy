#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.contentblock


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContentBlockPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/contentblock"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Default"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default Container in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default Container"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Default Container"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Float Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Float Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Float Section"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Description List Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Description List Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock4"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Description List Section"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Field Set Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Field Set Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock5"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample title text'
        assert ${symbol_dollar}(selector + " .legend").text().trim() == "Variant: Field Set Section"

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Field Set Section"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Advanced Plain Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Advanced Plain Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock6"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Advanced Plain Section"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Advanced Section with Links in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Advanced Section with Links"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock7"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Advanced Section with Links"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Section with Background in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Section with Background"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock8"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Section with Background"

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").contains(".png")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Section with Background Video in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Section with Background Video"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock9"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").size() > 0

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").contains(".png")

        and: 'Section should have video tag with video rendition'
        assert ${symbol_dollar}("${symbol_dollar}{selector} source").firstElement().getAttribute("src").contains(".flv")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Parsys in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Parsys"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock10"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Parsys"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Child Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Child Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock11"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample child sections'
        assert ${symbol_dollar}(selector + " .childsection").size() == 3

        when: 'I click first child section button'
        clickOnElement(${symbol_dollar}("${symbol_pound}contentblock11a-heading button").firstElement())
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: 'Fist child section content should be expanded'
        waitFor { ${symbol_dollar}("${symbol_pound}contentblock11a-content.show") }
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Section with Background using Image Option using Manual MediaQuery with Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Section with Background using Image Option using Manual MediaQuery with Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblock12"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Style element should use custom rendition'
        assert ${symbol_dollar}("${symbol_pound}background-contentblock12").getAttribute("innerHTML").indexOf("aem-design-logo.png") > 0

        where:
        viewport << getViewPorts()
    }

}
