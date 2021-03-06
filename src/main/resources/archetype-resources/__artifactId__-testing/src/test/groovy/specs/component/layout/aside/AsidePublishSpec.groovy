#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.aside

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class AsidePublishSpec extends ComponentSpec {

    String pathPage = "component/layout/aside"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/aside"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component in ${symbol_pound}viewport.label")
    def "Functionality of Component"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Aside"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}plainaside"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Aside Content"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample rich text")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Background in ${symbol_pound}viewport.label")
    def "Functionality of Component with Background"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Aside"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}asidewithbackground"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Aside Content with Background"

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").contains(".png")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
