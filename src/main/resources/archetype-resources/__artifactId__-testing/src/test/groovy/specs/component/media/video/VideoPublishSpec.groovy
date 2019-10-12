#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.media.video

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class VideoPublishSpec extends ComponentSpec {

    String pathPage = "component/media/video"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/video"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Video"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}video1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        report("The component should be on the page")

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} video source").attr("src").contains("/FishTank.mp4")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Should have sample content loaded"
        assert ${symbol_dollar}("${symbol_dollar}{selector} video").firstElement().getAttribute("readyState") == "4"

        and: "Should have sample content playing"
        assert js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}"${symbol_dollar}{selector} video${symbol_escape}")[0].paused == false;")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
