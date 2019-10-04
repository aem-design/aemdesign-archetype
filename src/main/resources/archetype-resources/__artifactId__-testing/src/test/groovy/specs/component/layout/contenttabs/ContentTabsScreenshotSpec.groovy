#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.contenttabs

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContentTabsScreenshotSpec extends ComponentSpec {

    String pathPage = "component/layout/contenttabs"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock/par/contenttabs"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component List of Children Pages in ${symbol_pound}viewport.label")
    def "Appearance of Component with List of Children Pages"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs1"

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

    @Unroll("Appearance of Component with List of Static Pages in ${symbol_pound}viewport.label")
    def "Appearance of Component with List of Static Pages"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs2"

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

    @Unroll("Appearance of Component Empty in ${symbol_pound}viewport.label")
    def "Appearance of Component Empty"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs3"

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

    @Unroll("Appearance of Component Variant: Render List of Children Pages in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Render with List of Children Pages"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs4"

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
