#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.details.pagedetails


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageDetailsPublishSpec extends ComponentSpec {

    String pathPage = "component/details/page-details"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagedetails"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with Excluded Components in ${symbol_pound}viewport.label")
    def "Functionality of Component with Excluded Components"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component with Background and Included Components in ${symbol_pound}viewport.label")
    def "Functionality of Component with Background and Included Components"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").indexOf("/content/dam/${contentFolderName}-showcase/en/components/media/image/city2.jpg") > 0

        and: "Has Breadcrumb visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb").isEmpty() == false

        and: "Has Toolbar has sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ol.breadcrumb li").first().text().trim() == "${artifactTitle} Showcase"

        and: "Has Toolbar visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == false

        and: "Has Toolbar has sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ${symbol_pound}text_in_toolbar").text().trim() == "Text in Toolbar"

        and: "Has Parsys visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == false

        and: "Has Parsys has sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ${symbol_pound}text_in_parsys").text().trim() == "Text in Parsys"


        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Hidden Variant in ${symbol_pound}viewport.label")
    def "Functionality of Component with Hidden Variant"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details3"
        def selectorContainer = "${symbol_pound}contentblock3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Background and Inherited Toolbar in ${symbol_pound}viewport.label")
    def "Functionality of Component with Background and Inherited Toolbar"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").indexOf("/content/dam/${contentFolderName}-showcase/en/components/media/image/city2.jpg") > 0

        and: "Has Breadcrumb visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb").isEmpty() == false

        and: "Has Toolbar has sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb li").first().text().trim() == "${artifactTitle} Showcase"

        and: "Has Toolbar visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == false

        and: "Has Toolbar has sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ${symbol_pound}text_in_parent_toolbar").text().trim() == "Text in Parent Toolbar"

        and: "Has Parsys visible"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == false

        and: "Has Custom Title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ${symbol_pound}text_in_parsys").text().trim() == "Text in Parsys"

        and: "Has Custom Description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} header h1").text().trim() == "Page Title 4"
        assert ${symbol_dollar}("${symbol_dollar}{selector} header .description").text().trim() == "Custom Description"


        where:
        viewport << getViewPorts()
    }


    @Unroll("Page Details: Default without included components and hidden Description in ${symbol_pound}viewport.label")
    def "Page Details: Default without included components and hidden Description"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details5"
        def selectorContainer = "${symbol_pound}contentblock5"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        and: "Has Description hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .description").isEmpty() == true

        and: "Has Title showing"
        assert ${symbol_dollar}("${symbol_dollar}{selector} h1").isEmpty() == false

        where:
        viewport << getViewPorts()
    }

    @Unroll("Page Details: Default without included components and hidden Title and Description in ${symbol_pound}viewport.label")
    def "Page Details: Default without included components and hidden Title and Description"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details6"
        def selectorContainer = "${symbol_pound}contentblock6"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} nav.breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        and: "Has Description hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .description").isEmpty() == true

        and: "Has Description hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .description").isEmpty() == true

        and: "Has Title showing"
        assert ${symbol_dollar}("${symbol_dollar}{selector} h1").isEmpty() == true

        where:
        viewport << getViewPorts()
    }

    def "Page Details: Default metadata added to page"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Page Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}page-details"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Page has metadata field og:title"
        assert ${symbol_dollar}("meta[property='og:title']").attr("content").equals("Page Details")

        and: "Page has metadata field og:type"
        assert ${symbol_dollar}("meta[property='og:type']").attr("content").equals("article")

        and: "Page has metadata field og:image"
        assert ${symbol_dollar}("meta[property='og:image']").attr("content").contains("page-details.thumb.")

        and: "Page has metadata field og:url"
        assert ${symbol_dollar}("meta[property='og:url']").attr("content").contains("details/page-details.html")

        and: "Page has canonical link"
        assert ${symbol_dollar}("link[rel='canonical']").attr("href").contains("details/page-details.html")

    }

}
