#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.text

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class TextScreenshotSpec extends ComponentSpec {

    String pathPage = "component/content/text"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/text"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}text1"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Simple in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}text2"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where:
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Prototype Example in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Prototype Example"() {

        given: '>I am in the component showcase page'
        def selector = "${symbol_pound}text3"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where:
        viewport << getViewPorts()

    }



}
