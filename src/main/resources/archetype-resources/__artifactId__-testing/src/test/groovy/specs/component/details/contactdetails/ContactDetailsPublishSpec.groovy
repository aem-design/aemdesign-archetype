#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.details.contactdetails


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContactDetailsPublishSpec extends ComponentSpec {

    String pathPage = "component/details/contact-details"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/contactdetails"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component variant Default without included components in ${symbol_pound}viewport.label")
    def "Functionality of Component variant Default without included components"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Contact Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contact-details1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        and: "Has Image with Alt Title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt").trim() == "Author: Max Barrass"

        and: "Has Image with Page Image as Thumbnail from Uploaded Image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/content/${contentFolderName}-showcase/au/en/component/details/contact-details.thumb.319.319.png")

        and: "Has Title line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text().trim() == "Author: Max Barrass"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text().trim() == "Founder for AEM.Design max.barrass@gmail.com"

        and: "Has Description has field jobTitle"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=jobTitle]").text().trim() == "Founder"

        and: "Has Description has field employee"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=employee]").text().trim() == "AEM.Design"

        and: "Has Description has field email"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=email]").text().trim() == "max.barrass@gmail.com"


        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component variant Default Blank without included components in ${symbol_pound}viewport.label")
    def "Functionality of Component variant Default Blank without included components"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Contact Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contact-details2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        and: "Has Image with Alt Title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt").trim() == "Contact Details"

        and: "Has Image with Page Image as Thumbnail"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/content/${contentFolderName}-showcase/au/en/component/details/contact-details.thumb.319.319.png")

        and: "Has Title line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text().trim() == "Contact Details"

        and: "Has Description should be empty"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text().isEmpty()

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component variant Hidden in ${symbol_pound}viewport.label")
    def "Functionality of Component variant Default Hidden"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Contact Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contact-details3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Component should have no content"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").text() == ""

        where:
        viewport << getViewPorts()
    }

    def "Contact Details: Default metadata added to page"() {

        given: '>the page hierarchy is created as "Components" > "Details" > "Contact Details"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contact-details"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Page has metadata field og:title"
        assert ${symbol_dollar}("meta[property='og:title']").attr("content").equals("Contact Details")

        and: "Page has metadata field og:type"
        assert ${symbol_dollar}("meta[property='og:type']").attr("content").equals("article")

        and: "Page has metadata field og:image"
        assert ${symbol_dollar}("meta[property='og:image']").attr("content").contains("contact-details.thumb.")

        and: "Page has metadata field og:url"
        assert ${symbol_dollar}("meta[property='og:url']").attr("content").contains("details/contact-details.html")

        and: "Page has canonical link"
        assert ${symbol_dollar}("link[rel='canonical']").attr("href").contains("details/contact-details.html")

    }


}
