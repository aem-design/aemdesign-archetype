#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.details.contactdetails

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContactDetailsDAMPublishSpec extends ComponentSpec {

    String pathPage = "component/details/contact-details/contact-details1"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/contactdetails"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component variant Default using DAM Asset as Page Image in ${symbol_pound}viewport.label")
    def "Functionality of Component variant Default using DAM Asset as Page Image"() {

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
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "The component should be on the page")

        and: "Has Breadcrumb hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .breadcrumb").isEmpty() == true

        and: "Has Toolbar hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .navbar").isEmpty() == true

        and: "Has Parsys hidden"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .text").isEmpty() == true

        and: "Has Image with Alt Title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("alt").trim() == "97236996"

        and: "Has Image with Page Image as Thumbnail from Asset Image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").attr("src").contains("/content/dam/${contentFolderName}-showcase/en/common/images/abstract.jpg/_jcr_content/renditions/cq5dam.thumbnail.319.319.png")

        and: "Has Title line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.title").text().trim() == "Author: Max Barrass"

        and: "Has Description line with content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description").text().trim() == "Adobe Practice lead for Isobar max.barrass@isobar.com"

        and: "Has Description has field jobTitle"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=jobTitle]").text().trim() == "Adobe Practice lead"

        and: "Has Description has field employee"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=employee]").text().trim() == "Isobar"

        and: "Has Description has field email"
        assert ${symbol_dollar}("${symbol_dollar}{selector} div.description [itemprop=email]").text().trim() == "max.barrass@isobar.com"


        where:
        viewport << getViewPorts()
    }


}
