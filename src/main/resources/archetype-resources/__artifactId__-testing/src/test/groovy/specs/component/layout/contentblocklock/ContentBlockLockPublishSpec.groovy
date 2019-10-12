#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.contentblocklock

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContentBlockLockPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/contentblocklock"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Section Locked"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Container in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Container"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Container Unlocked"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Float Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Float Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock3"

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

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock4"

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

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock5"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample title text'
        assert ${symbol_dollar}(selector + " .legend").text().trim() == "Field Set Section"

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Variant: Field Set Section"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Advanced Plain Section in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Advanced Plain Section"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock6"

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

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock7"

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

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentBlockLock"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contentblocklock8"

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


}
