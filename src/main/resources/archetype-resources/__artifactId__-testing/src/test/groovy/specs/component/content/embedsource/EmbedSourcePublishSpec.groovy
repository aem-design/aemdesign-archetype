#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.content.embedsource

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class EmbedSourcePublishSpec extends ComponentSpec {

    String pathPage = "component/content/embedsource"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/embedsource"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "EmbedSource"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}embedsource1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have sample content"
        assert ${symbol_dollar}(selector).text().trim().startsWith("visible text changed with embeded css")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: 'Custom embed style should apply to element'
        ${symbol_dollar}("${symbol_dollar}{selector} .embed.custom.style").jquery.css("color") == "rgb(255, 0, 0)"

        and: 'Custom embed script should apply to element'
        ${symbol_dollar}("${symbol_dollar}{selector} .embed.custom.js.hidden").css("display") == "block"


        where:
        viewport << getViewPorts()
    }


}
