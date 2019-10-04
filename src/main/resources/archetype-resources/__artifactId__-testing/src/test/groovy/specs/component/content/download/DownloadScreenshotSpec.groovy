#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.download

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class DownloadScreenshotSpec extends ComponentSpec {

    String pathPage = "component/content/download"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/download"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Simple in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Card in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Default with Licensed Image  in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Licensed Image "() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Simple with Licensed Image  in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Licensed Image "() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download5"
        def selectorContainer = "${symbol_pound}contentblock5 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Card with Licensed Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download6"
        def selectorContainer = "${symbol_pound}contentblock6 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Default with Title and Description in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Title and Description"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download8"
        def selectorContainer = "${symbol_pound}contentblock8 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Simple with Title and Description in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Title and Description"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download9"
        def selectorContainer = "${symbol_pound}contentblock9 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Card with Title and Description in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Title and Description"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download10"
        def selectorContainer = "${symbol_pound}contentblock10 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Simple with Thumbnail Icon in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Thumbnail Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download11"
        def selectorContainer = "${symbol_pound}contentblock11 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        and: "All images have loaded"
        waitForImagesToLoad2(${symbol_dollar}("img"))

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Appearance of Component Variant: Card with Thumbnail Icon in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Thumbnail Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download12"
        def selectorContainer = "${symbol_pound}contentblock12 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        and: "All images have loaded"
        waitForImagesToLoad2(${symbol_dollar}("img"))

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition Icon in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download13"
        def selectorContainer = "${symbol_pound}contentblock13 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Card with Thumbnail using Asset DAM Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Thumbnail using Asset DAM Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download14"
        def selectorContainer = "${symbol_pound}contentblock14 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Simple with Thumbnail using Thumbnail DAM Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Thumbnail using Thumbnail DAM Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download15"
        def selectorContainer = "${symbol_pound}contentblock15 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Card with Thumbnail using Thumbnail DAM Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Thumbnail using Thumbnail DAM Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download16"
        def selectorContainer = "${symbol_pound}contentblock16 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Simple with Custom Thumbnail Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Custom Thumbnail Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download17"
        def selectorContainer = "${symbol_pound}contentblock17 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Card with Custom Thumbnail Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Custom Thumbnail Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download18"
        def selectorContainer = "${symbol_pound}contentblock18 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Width Set Icon in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Width Set Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download19"
        def selectorContainer = "${symbol_pound}contentblock19 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Height Set Icon in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Height Set Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download20"
        def selectorContainer = "${symbol_pound}contentblock20 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selectorContainer)

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
