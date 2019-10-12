#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.taglist

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class TagListScreenshotSpec extends ComponentSpec {

    String pathPage = "component/lists/tag-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/taglist"

    def setupSpec() {
        loginAsAdmin()
    }



    @Unroll("Appearance of Component with Default variant and List of Children in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and List of Children"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist2"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }


    @Unroll("Appearance of Component with Default variant and List of Descendants in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and List of Descendants"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist3"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }


    @Unroll("Appearance of Component with Default variant and Fixed List in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Fixed List"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist4"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }



    @Unroll("Appearance of Component with Options List variant and List of Children in ${symbol_pound}viewport.label")
    def "Appearance of Component with Options List variant and List of Children"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist6"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }


    @Unroll("Appearance of Component with Options List variant and List of Descendants in ${symbol_pound}viewport.label")
    def "Appearance of Component with Options List variant and List of Descendants"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist7"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }


    @Unroll("Appearance of Component with Options List variant and Fixed List in ${symbol_pound}viewport.label")
    def "Appearance of Component with Options List variant and Fixed List"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist8"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: "It should match the ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height reference image."
        designRef(selector)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()


    }


}
