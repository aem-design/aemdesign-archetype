#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.pagedate

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageDatePublishSpec extends ComponentSpec {

    String pathPage = "component/content/pagedate"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/pagedate"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Text"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagedate1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample rich text"
        assert ${symbol_dollar}(selector).text().trim().startsWith("February 21, 2018")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample page date")

        and: "Should have attribute datetime"
        assert ${symbol_dollar}(selector).attr("datetime").trim().equals("2018-02-21")

        where:
        viewport << getViewPorts()
    }



}
