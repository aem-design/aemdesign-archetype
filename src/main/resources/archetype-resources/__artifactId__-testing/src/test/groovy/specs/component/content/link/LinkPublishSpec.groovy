#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.link


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class LinkPublishSpec extends ComponentSpec {

    String pathPage = "component/content/link"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/link"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: 'The page hierarchy is created as "Components" > "Content" > "Link"'
        def selector = "${symbol_pound}link1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample component text"
        assert ${symbol_dollar}(selector).text().trim() == "Link: Default"
        report("Should have sample component text")

        and: "Should have video-play module tag"
        assert ${symbol_dollar}(selector).attr("data-modules") == "play-video"
        report("Should have sample component text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Button in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Button"() {

        given: 'The page hierarchy is created as "Components" > "Content" > "Link"'
        def selector = "${symbol_pound}link2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample component text"
        assert ${symbol_dollar}(selector).text().trim() == "Link: Button"
        report("Should have sample component text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default no Label in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default no Label"() {

        given: 'The page hierarchy is created as "Components" > "Content" > "Link"'
        def selector = "${symbol_pound}link3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample component text"
        assert ${symbol_dollar}(selector).text().trim() == "Link"
        report("Should have sample component text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default with Analytics in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Analytics"() {

        given: 'The page hierarchy is created as "Components" > "Content" > "Link"'
        def selector = "${symbol_pound}link6"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample component text"
        assert ${symbol_dollar}(selector).text().trim() == "Link"
        report("Should have sample component text")

        and: "Should have analytics attribute: data-layer-event"
        assert ${symbol_dollar}(selector).attr("data-layer-event") == "site interaction"

        and: "Should have analytics attribute: data-layer-linktype"
        assert ${symbol_dollar}(selector).attr("data-layer-linktype") == "link"

        and: "Should have analytics attribute: data-layer-linklocation"
        assert ${symbol_dollar}(selector).attr("data-layer-linklocation") == "link page"

        and: "Should have analytics attribute: data-layer-linkdescription"
        assert ${symbol_dollar}(selector).attr("data-layer-linkdescription") == "link description"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Button with Analytics in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Button with Analytics"() {

        given: 'The page hierarchy is created as "Components" > "Content" > "Link"'
        def selector = "${symbol_pound}link7"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample component text"
        assert ${symbol_dollar}(selector).text().trim() == "Link"
        report("Should have sample component text")

        and: "Should have analytics attribute: data-layer-event"
        assert ${symbol_dollar}(selector).attr("data-layer-event") == "site interaction"

        and: "Should have analytics attribute: data-layer-linktype"
        assert ${symbol_dollar}(selector).attr("data-layer-linktype") == "button"

        and: "Should have analytics attribute: data-layer-linklocation"
        assert ${symbol_dollar}(selector).attr("data-layer-linklocation") == "link page"

        and: "Should have analytics attribute: data-layer-linkdescription"
        assert ${symbol_dollar}(selector).attr("data-layer-linkdescription") == "link description"

        where:
        viewport << getViewPorts()
    }


}
