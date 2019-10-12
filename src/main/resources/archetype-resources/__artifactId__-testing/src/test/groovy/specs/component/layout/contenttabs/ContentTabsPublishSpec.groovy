#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.contenttabs

import org.junit.Ignore
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContentTabsPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/contenttabs"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock/par/contenttabs"


    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with List of Children Pages in ${symbol_pound}viewport.label")
    def "Functionality of Component with List of Children Pages"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentTabs"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Should have sample content")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "First tab should be active"
        assert ${symbol_dollar}(selector + " .nav-link.active").text().trim() == "Tab Page Content 1"

        and: "Tab breadcrumb should match current page"
        assert ${symbol_dollar}(selector + "_page1 .breadcrumb li.active").getAt(0).text().trim() == "Content Tabs"

        and: "Tab contents page title should match current page"
        assert ${symbol_dollar}(selector + "_page1 .pagetitle")[0].getAttribute("innerText").trim() == "Content Tabs"

        and: "Tab contents page tags should only have one tag"
        assert ${symbol_dollar}(selector + "_page1 .pagetags li").size() == 1

        when: "I select second tab"
        ${symbol_dollar}(selector + " .nav-link").getAt(1).click()

        then: "Second tab content show be visible"
        assert ${symbol_dollar}(selector + " .nav-link.active").text().trim() == "Tab Page Content 2"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Second tab content show be visible")

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component with List of Static Pages in ${symbol_pound}viewport.label")
    def "Functionality of Component with List of Static Pages"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentTabs"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "First tab should be active"
        assert ${symbol_dollar}(selector + " .nav-link.active").text().trim() == "Content Block"

        when: "I select second tab"
        ${symbol_dollar}(selector + " .nav.nav-tabs").find("li").getAt(1).find("a").getAt(0).click()

        then: "Second tab content show be visible"
        assert ${symbol_dollar}(selector + " .nav-link.active").text().trim() == "Content Block Lock"
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Second tab content show be visible")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Empty in ${symbol_pound}viewport.label")
    def "Functionality of Component Empty"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "ContentTabs"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contenttabs3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .nav-link.active").text().trim() == "Empty"

        where:
        viewport << getViewPorts()
    }

}
