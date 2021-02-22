#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.media.image

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ImagePublishSpec extends ComponentSpec {

    String pathPage = "component/media/image"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/image"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city3.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Only in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Only"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city3.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/city3.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "1280",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} img")
                .getAttribute("src")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Title and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city3.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city1.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Only with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Only with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city1.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/city1.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "1280",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Licensed Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").text() == "Licensed Asset Description"

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").text().trim() == "2017 Creator Contributor Copyright Image Owner Copyright Owner"


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Title and Description with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description with Licensed Image"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image8"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city1.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure figcaption").text() == "Licensed Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure .description")[0].getAttribute("innerText").equals("Licensed Asset Description")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure .license")[0].getAttribute("innerText").trim() == "2017 Creator Contributor Copyright Image Owner Copyright Owner"


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default Empty in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default Empty"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image9"
        def selectorContainer = "${symbol_pound}contentblock9 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should be empty"
        assert ${symbol_dollar}(selector).children().size() == 0

        and: "Should have empty attribute"
        assert ${symbol_dollar}(selector + "[empty]").size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Overrides in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Overrides"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("title") == "Can override Image Title"

        and: "Has overridden alt"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt") == "Can override Image Headline"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Image Only with Overrides in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Only with Overrides"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("title") == "Can override Image Title"

        and: "Has overridden alt"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt") == "Can override Image Headline"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Card with Overrides in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Overrides"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "1280",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has overridden title with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Can override Image Title"

        and: "Has overridden description with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").text() == "Can override Image Description"

        and: "Has image with overridden title with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("title") == "Can override Image Title"

        and: "Has image with overridden alt with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt") == "Can override Image Headline"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Title and Description with Overrides in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description with Overrides"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has title line with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure figcaption").text() == "Can override Image Title"

        and: "Has description line with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure .description")[0].getAttribute("innerText") == "Can override Image Description"

        and: "Has image with overridden title with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("title") == "Can override Image Title"

        and: "Has image with overridden alt with overridden title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt") == "Can override Image Headline"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Only Empty in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Only Empty"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image14"
        def selectorContainer = "${symbol_pound}contentblock14 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should be empty"
        assert ${symbol_dollar}(selector).children().size() == 0

        and: "Should have empty attribute"
        assert ${symbol_dollar}(selector + "[empty]").size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Card Empty in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card Empty"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image15"
        def selectorContainer = "${symbol_pound}contentblock15 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should be empty"
        assert ${symbol_dollar}(selector).children().size() == 0

        and: "Should have empty attribute"
        assert ${symbol_dollar}(selector + "[empty]").size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Image Title and Description Empty in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description Empty"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Image"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}image16"
        def selectorContainer = "${symbol_pound}contentblock16 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should be empty"
        assert ${symbol_dollar}(selector).children().size() == 0

        and: "Should have empty attribute"
        assert ${symbol_dollar}(selector + "[empty]").size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Rendition"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/city3.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "319",
                "MD"  : "319",
                "LG"  : "319",
                "XLG" : "319",
                "XXLG": "319"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} img")
                .getAttribute("src")
                .contains(
                expectSizes.get(viewport.label)
        )

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Image Title and Description with Asset Metadata in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description with Asset Metadata"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "319",
                "SM"  : "1280",
                "MD"  : "1280",
                "LG"  : "1280",
                "XLG" : "1280",
                "XXLG": "1280"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure figcaption").text() == "Asset Title"

        and: "Has description line embedded in Asset"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure div.description")[0].getAttribute("innerText") == "Asset Description";

        and: "Has no license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").size() == 0


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Image Title and Description with Adaptive Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Image Title and Description with Adaptive Image"() {

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

        and: "Should be using sample image as source"
        assert ${symbol_dollar}(selector).attr("data-analytics-filename").endsWith("/city2.jpg")

        and: "Should be rendering sample image using current resource"
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img").attr("src").contains("/city2")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "480",
                "SM"  : "640",
                "MD"  : "1024",
                "LG"  : "1440",
                "XLG" : "1920",
                "XXLG": "2048"
        ]
        assert ${symbol_dollar}("${symbol_dollar}{selector} picture img")
                .getAttribute("currentSrc")
                .contains(
                expectSizes.get(viewport.label)
        )

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure figcaption").text() == "Asset Title"

        and: "Has description line embedded in Asset"
        assert ${symbol_dollar}("${symbol_dollar}{selector} figure div.description")[0].getAttribute("innerText") == "Asset Description"

        and: "Has no license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").size() == 0


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default with Generated Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Generated Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(".img.jpeg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Adaptive Image Sizing in ${symbol_pound}viewport.label")
    def "Functionality of Adaptive Image Sizing"() {

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


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "480",
                "SM"  : "640",
                "MD"  : "1024",
                "LG"  : "1440",
                "XLG" : "1920",
                "XXLG": "2048"
        ]
        def imgUrl = ${symbol_dollar}("${symbol_dollar}{selector} picture img").getAttribute("currentSrc")
        assert imgUrl.contains(expectSizes.get(viewport.label))
//         assert expectSizes.get(viewport.label) ==  getImageWidth(imgUrl).toString()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Default Variant with Image Option - Manual MediaQuery with Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Default Variant with Image Option - Manual MediaQuery with Rendition"() {

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


        and: "Image dimension should match media query"
        def expectSizes = [
                "XS"  : "1280",
                "SM"  : "1280",
                "MD"  : "aem-design-logo",
                "LG"  : "aem-design-logo",
                "XLG" : "aem-design-logo",
                "XXLG": "aem-design-logo"
        ]
        def imgUrl = ${symbol_dollar}("${symbol_dollar}{selector} picture img").getAttribute("currentSrc")
        assert imgUrl.contains(expectSizes.get(viewport.label))
//         assert expectSizes.get(viewport.label) ==  getImageWidth(imgUrl).toString()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

}
