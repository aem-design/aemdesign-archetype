#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.pagedescription

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageDescriptionScreenshotSpec extends ComponentSpec {

    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String pathPage = "component/content/pagedescription"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagedescription"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagedescription1"

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

    @Unroll("Appearance of Component with Override in ${symbol_pound}viewport.label")
    def "Appearance of Component with Override"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagedescription2"

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
