#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.common.staticinclude

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class StaticIncludePublishSpec extends ComponentSpec {

    String pathPage = "component/common/staticinclude"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/staticinclude"
    String pageSelectors = ""

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Common" > "Static Include"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = ".staticinclude.aem-GridColumn"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The page should have Static Include content"
        assert ${symbol_dollar}("${symbol_dollar}selector div").text().trim().equals("Static Include")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The page should have Static Include content")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

}
