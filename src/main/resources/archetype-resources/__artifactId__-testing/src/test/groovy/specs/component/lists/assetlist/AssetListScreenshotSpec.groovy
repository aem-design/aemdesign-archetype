#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.assetlist

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class AssetListScreenshotSpec extends ComponentSpec {

    String pathPage = "component/lists/asset-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/assetlist"

    def setupSpec() {
        loginAsAdmin()
    }



    @Unroll("Appearance of Component with Default variant and Static List in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and List of Children"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist1"

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


    @Unroll("Appearance of Component with Default variant and Static List with Image Option Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Static List with Image Option Rendition"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist2"

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


    @Unroll("Appearance of Component with Default variant and Static List with Image Option Adaptive in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Static List with Image Option Adaptive"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist3"

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



    @Unroll("Appearance of Component with Default variant and Static List with Multiple Images in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Static List with Multiple Images"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist4"

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


    @Unroll("Appearance of Component with Default variant and Child List in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Child List"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist5"

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


    @Unroll("Appearance of Component with Default variant and Descendants List in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Descendants List"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist6"

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


    @Unroll("Appearance of Component with Default variant and Static List with Multiple Asset Types in ${symbol_pound}viewport.label")
    def "Appearance of Component with Default variant and Static List with Multiple Asset Types"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}assetlist7"

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
