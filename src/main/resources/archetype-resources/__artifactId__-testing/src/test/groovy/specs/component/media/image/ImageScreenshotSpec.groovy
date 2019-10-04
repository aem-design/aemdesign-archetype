#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.media.image


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ImageScreenshotSpec extends ComponentSpec {

    String pathPage = "component/media/image"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/image"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image1"
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


    @Unroll("Appearance of Component Variant: Image Only in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Only"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image2"
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

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image3"
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

    @Unroll("Appearance of Component Variant: Image Title and Description in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Title and Description"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image4"
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


    @Unroll("Appearance of Component Variant: Default with Licensed Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image5"
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

    @Unroll("Appearance of Component Variant: Image Only with Licensed Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Only with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image6"
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

    @Unroll("Appearance of Component Variant: Card with Licensed Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image7"
        def selectorContainer = "${symbol_pound}contentblock7 .contents"

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


    @Unroll("Appearance of Component Variant: Image Title and Description with Licensed Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Title and Description with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image8"
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

//    @Unroll("Appearance of Component Variant: Default Empty in ${symbol_pound}viewport.label")
//    def "Appearance of Component Variant: Default Empty"() {
//
//        given:  '>the page hierarchy is created as "Components" > "Media" > "Image"'
//        and:    '>I am in the component showcase page'
//        and:    '>the component is on the showcase page'
//        def selector = "${symbol_pound}image9"
//        def selectorContainer = "${symbol_pound}contentblock9 .contents"
//
//        when: "I am on the component showcase page"
//        setWindowSize(viewport)
//        waitForAuthorPreviewPage()
//
//        then: "The component should be on the page"
//        def component = waitForComponent(selector)
//
//        then: 'It should match the small viewport reference image.'
//        designRef(selectorContainer)
//
//        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
//        viewport << getViewPorts()
//    }


    @Unroll("Appearance of Component Variant: Default with Overrides in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Overrides"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image10"
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


    @Unroll("Appearance of Component Variant: Image Only with Overrides in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Only with Overrides"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image11"
        def selectorContainer = "${symbol_pound}contentblock11 .contents"

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


    @Unroll("Appearance of Component Variant: Card with Overrides in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Card with Overrides"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image12"
        def selectorContainer = "${symbol_pound}contentblock12 .contents"

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

    @Unroll("Appearance of Component Variant: Image Title and Description with Overrides in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Title and Description with Overrides"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image13"
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

//    @Unroll("Appearance of Component Variant: Image Only Empty in ${symbol_pound}viewport.label")
//    def "Appearance of Component Variant: Image Only Empty"() {
//
//        given:  '>the page hierarchy is created as "Components" > "Media" > "Image"'
//        and:    '>I am in the component showcase page'
//        and:    '>the component is on the showcase page'
//        def selector = "${symbol_pound}image14"
//        def selectorContainer = "${symbol_pound}contentblock14 .contents"
//
//        when: "I am on the component showcase page"
//        setWindowSize(viewport)
//        waitForAuthorPreviewPage()
//
//        then: "The component should be on the page"
//        def component = waitForComponent(selector)
//
//        then: 'It should match the small viewport reference image.'
//        designRef(selectorContainer)
//
//        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
//        viewport << getViewPorts()
//    }

//    @Unroll("Appearance of Component Variant: Card Empty in ${symbol_pound}viewport.label")
//    def "Appearance of Component Variant: Card Empty"() {
//
//        given:  '>the page hierarchy is created as "Components" > "Media" > "Image"'
//        and:    '>I am in the component showcase page'
//        and:    '>the component is on the showcase page'
//        def selector = "${symbol_pound}image15"
//        def selectorContainer = "${symbol_pound}contentblock15 .contents"
//
//        when: "I am on the component showcase page"
//        setWindowSize(viewport)
//        waitForAuthorPreviewPage()
//
//        then: "The component should be on the page"
//        def component = waitForComponent(selector)
//
//        then: 'It should match the small viewport reference image.'
//        designRef(selectorContainer)
//
//        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
//        viewport << getViewPorts()
//    }

//    @Unroll("Appearance of Component Variant: Image Title and Description Empty in ${symbol_pound}viewport.label")
//    def "Appearance of Component Variant: Image Title and Description Empty"() {
//
//        given:  '>the page hierarchy is created as "Components" > "Media" > "Image"'
//        and:    '>I am in the component showcase page'
//        and:    '>the component is on the showcase page'
//        def selector = "${symbol_pound}image16"
//        def selectorContainer = "${symbol_pound}contentblock16 .contents"
//
//        when: "I am on the component showcase page"
//        setWindowSize(viewport)
//        waitForAuthorPreviewPage()
//
//        then: "The component should be on the page"
//        def component = waitForComponent(selector)
//
//        then: 'It should match the small viewport reference image.'
//        designRef(selectorContainer)
//
//        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
//        viewport << getViewPorts()
//    }


    @Unroll("Appearance of Component Variant: Default with Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image17"
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


    @Unroll("Appearance of Component Variant: Image Title and Description with Asset Metadata in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Title and Description with Asset Metadata"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image18"
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


    @Unroll("Appearance of Component Variant: Image Title and Description with Adaptive Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image Title and Description with Adaptive Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image19"
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


    @Unroll("Appearance of Component Variant: Default with Generated Image in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Generated Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image20"
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


    @Unroll("Appearance of Component Variant: Image and Descripton in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Image and Descripton "() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image21"
        def selectorContainer = "${symbol_pound}contentblock21 .contents"

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


    @Unroll("Appearance of Component Variant: Default with Image Option - Manual MediaQuery with Rendition in ${symbol_pound}viewport.label")
    def "Appearance of Component Variant: Default with Image Option - Manual MediaQuery with Rendition"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image24"
        def selectorContainer = "${symbol_pound}contentblock24 .contents"

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
