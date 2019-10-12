#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.widgets.sharebutton

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ShareButtonScreenshotSpec extends ComponentSpec {

    String pathPage = "component/widgets/sharebutton"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/sharebutton"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component Variant: Inline with Share Tool Box in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Inline with Share Tool Box"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}atstbx"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        and: "Add this modules have been loaded"
        waitFor(15, 0.1) { js.exec("return window.addthis?true:false;") }

        and: "Should have add this loaded"
        assert js.exec("return window.addthis?true:false;")

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Inline with Follow Tool Box in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Inline with Follow Tool Box"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}atstbx"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        and: "Add this modules have been loaded"
        waitFor(15, 0.1) { js.exec("return window.addthis?true:false;") }

        and: "Should have add this loaded"
        assert js.exec("return window.addthis?true:false;")

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef("${symbol_pound}atftbx")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()

    }

    @Unroll("Appearance of Component Variant: Inline with Tip Jar in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Inline with Tip Jar"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}attj"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        and: "Add this modules have been loaded"
        waitFor(15, 0.1) { js.exec("return window.addthis?true:false;") }

        and: "Should have add this loaded"
        assert js.exec("return window.addthis?true:false;")

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()

    }
}
