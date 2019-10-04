#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.download

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class DownloadPublishSpec extends ComponentSpec {

    String pathPage = "component/content/download"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/download"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "When asset is downloaded it matches repository asset file signature"
        assert verifyAssetDownload(${symbol_dollar}(selector).firstElement().getAttribute("href"))

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Licensed Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").text().trim() == "© 2017 Creator Contributor Copyright Image Owner Copyright Owner"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Licensed Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Licensed Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Licensed Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").text().trim() == "© 2017 Creator Contributor Copyright Image Owner Copyright Owner"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Licensed Image in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Licensed Image"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Licensed Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} span").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Licensed Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Licensed Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").text().trim() == "© 2017 Creator Contributor Copyright Image Owner Copyright Owner"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default without Authored Content in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default without Authored Content"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download7"
        def selectorContainer = "${symbol_pound}contentblock7 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have a placehoder image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .cq-placeholder").attr("data-emptytext") == "Download"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Title and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Title and Description"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Can override non-Licensed Image Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Title and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Title and Description"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Can override non-Licensed Image Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Can override non-Licensed Image Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Can override non-Licensed Image Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Title and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Title and Description"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Can override non-Licensed Image Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Can override non-Licensed Image Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Can override non-Licensed Image Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Simple with Thumbnail Icon in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Thumbnail Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download11"
        def selectorContainer = "${symbol_pound}contentblock11 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Thumbnail Icon in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Thumbnail Icon"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Download"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}download12"
        def selectorContainer = "${symbol_pound}contentblock12 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Has sample icon line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} span.card-icon").size() != 0

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition Icon"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Uses Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href"))

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Thumbnail using Asset DAM Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Thumbnail using Asset DAM Rendition"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Uses Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href"))

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Thumbnail using Thumbnail DAM Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Thumbnail using Thumbnail DAM Rendition"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Does not use Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href")) == false

        and: "Uses Thumbnail Asset Rendition"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(".thumbnail.")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Thumbnail using Thumbnail DAM Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Thumbnail using Thumbnail DAM Rendition"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Does not use Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href")) == false

        and: "Uses Thumbnail Asset Rendition"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(".thumbnail.")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Custom Thumbnail Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Custom Thumbnail Rendition"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Does not use Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href")) == false

        and: "Uses Thumbnail Asset Rendition"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/thumbnail.img.jpeg")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Card with Custom Thumbnail Rendition in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Card with Custom Thumbnail Rendition"() {

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

        and: "All images have loaded"
        waitForImagesToLoad2(${symbol_dollar}("img"))

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Does not use Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href")) == false

        and: "Uses Thumbnail Asset Rendition"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/thumbnail.img.jpeg")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-info").text().contains("jpeg file")

        and: "Has button line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .btn").text().toLowerCase() == "Download".toLowerCase()

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Width Set in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Width Set Icon"() {

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

        and: "All images have loaded"
        waitForImagesToLoad2(${symbol_dollar}("img"))

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Uses Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href"))

        and: "Thumbnail has width specified"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("thumbnailwidth").equals("50")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Height Set in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Simple with Thumbnail using Asset DAM Rendition and Height Set Icon"() {

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

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("Asset Title")
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have sample content")

        and: "Uses Asset Rendition as thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains(${symbol_dollar}("${symbol_dollar}{selector}").attr("href"))

        and: "Thumbnail has height specified"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("thumbnailheight").equals("50")

        and: "Has title line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text() == "Asset Title"

        and: "Has description line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text() == "Asset Description"

        and: "Has info line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.info").text().contains("jpeg file")

        and: "Has license line"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .license").isEmpty()

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
