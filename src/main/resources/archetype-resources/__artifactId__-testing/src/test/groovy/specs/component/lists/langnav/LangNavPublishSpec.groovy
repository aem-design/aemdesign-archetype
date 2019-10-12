#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.langnav


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class LangNavPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/language-navigation"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/langnav"

    def setupSpec() {
        loginAsAdmin()
    }


    @Unroll("Lang Nav: Default with Languages Available in ${symbol_pound}viewport.label")
    def "Lang Nav: Default with Languages Available"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Language Navigation"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}langnav1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 2

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").firstElement().getAttribute("textContent").trim().contains("EN")

        and: "Has last item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").lastElement().getAttribute("textContent").trim().contains("RU")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Lang Nav: Default with Languages Not Available in ${symbol_pound}viewport.label")
    def "Lang Nav: Default with Languages Not Available"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Language Navigation" > "One Language"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}langnav1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/language-navigation/one-language.html")

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 1

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").firstElement().getAttribute("textContent").trim().contains("EN")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }



    @Unroll("Lang Nav: Default with Languages Not Available and Showing Language Root ${symbol_pound}viewport.label")
    def "Lang Nav: Default with Languages Not Available and Showing Language Root"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Language Navigation" > "One Language"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}langnav2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/language-navigation/one-language.html")

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 2

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").firstElement().getAttribute("textContent").trim().contains("EN")

        and: "Has last item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").lastElement().getAttribute("textContent").trim().contains("Russian")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()

    }


}
