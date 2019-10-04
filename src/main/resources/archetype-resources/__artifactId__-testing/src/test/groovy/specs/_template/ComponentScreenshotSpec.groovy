#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs._template

import spock.lang.IgnoreIf
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

//TODO: remove this for real components
@IgnoreIf({ System.properties.getProperty("geb.env") != "template" })
@Stepwise
class ComponentScreenshotSpec extends ComponentSpec {

    String pathPage = "component/content/text"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/text"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}default"

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
//
//    @Unroll("Appearance of Component Variant: Simple in ${symbol_pound}viewport.label")
//    def "Appearance of Component Variant: Simple"() {
//
//        given: '>I am in the component showcase page'
//        and: '>the component is on the showcase page'
//        def selector = "${symbol_pound}default"
//
//        when: 'I am in the component showcase page'
//        setWindowSize(viewport)
//        waitForAuthorPreviewPage()
//
//        then: 'The component should appear on the page'
//        def component = waitForComponent(selector)
//
//        then: 'It should match the small viewport reference image.'
//        designRef(selector)
//
//        where:
//        viewport << getViewPorts()
//
//    }


}
