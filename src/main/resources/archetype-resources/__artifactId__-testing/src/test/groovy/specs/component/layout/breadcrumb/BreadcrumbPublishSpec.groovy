#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.breadcrumb

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class BreadcrumbPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/breadcrumb"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/breadcrumb"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component in ${symbol_pound}viewport.label")
    def "Functionality of Component"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Breadcrumb"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}breadcrumb1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: 'There should be a HREF value associated with Components link'
        ${symbol_dollar}(selector + " a[href='/content/${contentFolderName}-showcase/en/component.html']", text: "Components")

        and: 'There should be a HREF value associated with Layout link'
        ${symbol_dollar}(selector + " a[href='/content/${contentFolderName}-showcase/en/component/layout.html']", text: "Layout")

        and: 'There should be a HREF value associated with Breadcrumb link'
        ${symbol_dollar}(selector + " li.active span", text: "Breadcrumb")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Changed Start Level in ${symbol_pound}viewport.label")
    def "Functionality of Component with Changed Start Level"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Breadcrumb"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}breadcrumb2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: 'First link should be Layout'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(0).text().trim() == "Layout"

        and: 'Last link should be Breadcrumb'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(${symbol_dollar}("${symbol_dollar}selector li").size()-1).text().trim() == "Breadcrumb"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Changed Start Level and End Level in ${symbol_pound}viewport.label")
    def "Functionality of Component with Changed Start Level and End Level"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Breadcrumb"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}breadcrumb3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: 'First link should be Components'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(0).text().trim() == "Components"

        and: 'Last link should be Layout'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(${symbol_dollar}("${symbol_dollar}selector li").size()-1).text().trim() == "Layout"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Show hidden in ${symbol_pound}viewport.label")
    def "Functionality of Component with Show hidden"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Breadcrumb"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}breadcrumb4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: 'First link should be English'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(0).text().trim() == "English"

        and: 'Last link should be Layout'
        assert ${symbol_dollar}("${symbol_dollar}selector li").getAt(${symbol_dollar}("${symbol_dollar}selector li").size()-1).text().trim() == "Layout"

        where:
        viewport << getViewPorts()
    }

}
