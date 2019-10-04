#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.link

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class LinkScreenshotSpec extends ComponentSpec {

    String pathPage = "component/content/link"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/link"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>I am in the component showcase page'
        def selector = "${symbol_pound}link1"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Button in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Button"() {

        given: '>I am in the component showcase page'
        def selector = "${symbol_pound}link2"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Default no Label in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default no Label"() {

        given: '>I am in the component showcase page'
        def selector = "${symbol_pound}link3"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Prototype Example in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Prototype Example"() {

        given: '>I am in the component showcase page'
        def selector = "${symbol_pound}contentblock4 .contents"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

}
