#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.widgets.onlinemedia

import spock.lang.Ignore
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class OnlineMediaPublishSpec extends ComponentSpec {

    String pathPage = "component/widgets/onlinemedia"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/onlinemedia"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Functionality of Component Variant: Default in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default"() {

        given: '>the page hierarchy is created as "Components" > "Widgets" > "OnlineMedia"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}onlinemedia1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        report("The component should be on the page")

        and: "Should have default media provider"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaprovider").contains("default")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default with YouTube in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with YouTube"() {

        given: '>the page hierarchy is created as "Components" > "Widgets" > "OnlineMedia"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}onlinemedia2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have default media provider"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaprovider").contains("youtube")

        and: "Should have media id"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaid").contains("tL46xeIV5mc")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Ignore
    @Unroll("Functionality of Component Variant: Default with Kaltura in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with Kaltura"() {

        given: '>the page hierarchy is created as "Components" > "Widgets" > "OnlineMedia"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}onlinemedia3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")


        and: "Should have default media provider"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaprovider").contains("kaltura")

        and: "Should have media id"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaid").contains("1_lph7zzb1")

        and: "Should have media title"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediatitle").contains("kaltura video")

        and: "Should have media partner id"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediapartnerid").contains("_691292")

        and: "Should have media player id"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("data-mediaplayerid").contains("20499062")

        and: "Should have set width"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("width").toInteger() == 1000

        and: "Should have set height"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("height").toInteger() == 850

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Ignore
    @Unroll("Functionality of Component Variant: IFrame with Youtube Video in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: IFrame with Youtube Video"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Online Media"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}onlinemedia4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should have sample src set"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("src").contains("//www.youtube.com/embed/Dk7h22mRYHQ")

        and: "Should have boolean attribute"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("allowfullscreen")

        and: "Should have class modifier 'embed-responsive'"
        assert ${symbol_dollar}(selector).hasClass("embed-responsive")

        and: "Should have schema itemtype='http://schema.org/VideoObject'"
        assert ${symbol_dollar}(selector).getAttribute("itemtype").equals("http://schema.org/VideoObject")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: IFrame with Vimeo Video in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: IFrame with Vimeo Video"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Online Media"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}onlinemedia5"
        def selectorContainer = "${symbol_pound}contentblock5 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should have sample src set"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").attr("src").contains("//player.vimeo.com/video/8733915")

        and: "Should have class modifier 'embed-responsive'"
        assert ${symbol_dollar}(selector).hasClass("embed-responsive")

        where:
        viewport << getViewPorts()
    }




}
