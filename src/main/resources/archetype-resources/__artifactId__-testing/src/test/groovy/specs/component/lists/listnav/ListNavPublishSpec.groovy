#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.listnav


import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ListNavPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/list-nav"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/listnav"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with Default variant and Child List in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant and Child List"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List Nav"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}listnav1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Should have next link"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page2")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    def "Functionality of Component Inherited in Footer"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List Nav"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}listnavDescendants"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Descendants list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Looping Descendants with Badge list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .first .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1.html")

        then: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Static list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Static list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page1.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        and: "Static list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Static list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page2")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page1/page1.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page1/page2.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page1")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")


        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page2.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1 > Page2")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")


        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page2/page1.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")



        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page2/page2.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page1")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")



        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page3.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page2 > Page2")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")




        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page1/page3/page1.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")

        and: "Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page2")

        and: "Static list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")

        and: "Looping Descendants list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .next").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page2")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3")

        and: "Looping Descendants with Badge list should point to next element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .next .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page2")




        when: "I navigate to next page"
        waitForAuthorPreviewPageUrl("content/${contentFolderName}-showcase/au/en/component/lists/list-nav/pages/page2.html")

        then: "Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendants .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")

        and: "Static list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavStatic .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page1")

        and: "Looping Descendants list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .previous").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")

        and: "Looping Descendants list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoop .first").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

        and: "Looping Descendants with Badge list should point to previous element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .previous .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1 > Page3 > Page1")

        and: "Looping Descendants with Badge list should point to first element in list"
        assert ${symbol_dollar}("${symbol_pound}listnavDescendantsLoopBadge .first .card-link").firstElement().getAttribute("textContent").trim().contains("List Nav > Pages > Page1")

    }


}
