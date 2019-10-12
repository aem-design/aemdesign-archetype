#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.media.audio

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class AudioPublishSpec extends ComponentSpec {

    String pathPage = "component/media/audio"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/audio"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Functionality of Component Variant: Default with Audio Source in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Audio Source"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Audio"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}audio1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        report("The component should be on the page")

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} audio source").attr("src").contains("/recit.mp3")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Should have sample content loaded"
        assert ${symbol_dollar}("${symbol_dollar}{selector} audio").firstElement().getAttribute("readyState") == "4"

        and: "Should have sample content not playing"
        assert js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}"${symbol_dollar}{selector} audio${symbol_escape}")[0].paused == true;")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with Video Source in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Video Source"() {

        given: '>the page hierarchy is created as "Components" > "Media" > "Audio"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}audio2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        report("The component should be on the page")

        and: "Should have sample content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} audio source").attr("src").contains("/FishTank.mp4")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        and: "Should have sample content loaded"
        assert ${symbol_dollar}("${symbol_dollar}{selector} audio").firstElement().getAttribute("readyState") == "4"

        and: "Should have sample content not  playing"
        assert js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}"${symbol_dollar}{selector} audio${symbol_escape}")[0].paused == true;")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
