#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.pagelist

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/page-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/pagelist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Page List: Default variant using Default badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Default badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.first").text().trim() == "Page1"

        and: "Has last item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.last").text().trim() == "Page5"

        and: "Has three plain items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.item").size() == 3

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default variant using Icon badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Icon badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 3

        and: "Has icon as contents"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li i").size() == 3

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default variant using Image badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Image badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        and: "Has image as contents"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li img").size() == 5

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default variant using Card badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Card badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        and: "Has card as contents"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li .card").size() == 5

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Page List: Default variant using Horizontal badge in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Horizontal badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist5"
        def selectorContainer = "${symbol_pound}contentblock5 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 3

        and: "Has card as contents"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li .card").size() == 3

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Page List: Default Empty in ${symbol_pound}viewport.label")
    def "Page List: Default Empty"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist6"
        def selectorContainer = "${symbol_pound}contentblock6 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Has no content"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .content > child").isEmpty() == true

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Badge: Card with Image, Title, Description and Action in ${symbol_pound}viewport.label")
    def "Badge: Card with Image, Title, Description and Action"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist29"
        def selectorContainer = "${symbol_pound}contentblock29 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 2

        and: "Has image in first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} > div > ul > li.first > div > div.card-img-top > img").attr("alt") == "Page1"

        and: "Has title in first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} > div > ul > li.first > div > div.card-body > h3").text() == "Page1"

        and: "Has description in first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} > div > ul > li.first > div > div.card-body > div.card-text").text() == "Page with Licensed Page Image, with non-Licensed Secondary Image and with Background non-Licensed Image"

        and: "Has call to action in first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} > div > ul > li.first > div > div.card-body > div > a").text().toUpperCase() == "BUTTON TEXT"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default variant using Card badge with List Split every 2 in ${symbol_pound}viewport.label")
    def "Page List: Default variant using Card badge with List Split every 2"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist30"
        def selectorContainer = "${symbol_pound}contentblock30 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has three lists"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul").size() == 3

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 5

        and: "First list has two items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul").getAt(0).find("li").size() == 2

        and: "Second list has two items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul").getAt(1).find("li").size() == 2

        and: "Third list has one items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul").getAt(2).find("li").size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default with Thumbnail Override in ${symbol_pound}viewport.label")
    def "Page List: Default with Thumbnail Override"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist31"
        def selectorContainer = "${symbol_pound}contentblock31 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 3

        and: "Last item should have thumbnail override from list"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li img").getAt(0).attr("src").contains("/cablecar.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Last item should have thumbnail override from list")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Default without Thumbnail Override in ${symbol_pound}viewport.label")
    def "Page List: Default without Thumbnail Override"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist32"
        def selectorContainer = "${symbol_pound}contentblock32 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 3

        and: "Last item should have thumbnail override from page details"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li img").getAt(0).attr("src").contains("/city2.jpg/")
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "Last item should have thumbnail override from page details")


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Pages with Analytics ${symbol_pound}viewport.label")
    def "Page List: Pages with Analytics"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist33"
        def selectorContainer = "${symbol_pound}contentblock33 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "First page link should have attribute: data-layer-track"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-track").equals("true")

        and: "First page link should have attribute: data-layer-label"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-label").equals("link")

        and: "First page link should have attribute: data-layer-location"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-location").equals("pagelist")


        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    def "Page List: Pages with Title and Description Trim"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist34"
        def selectorContainer = "${symbol_pound}contentblock34 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Page Title Should be trimmed"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li .card-title").getAt(0).text().equals("Pag...")

        and: "Page Description Should be trimmed"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li .card-text").getAt(0).text().equals("Page with ..more")

    }

    @Unroll("Page List: Pages with Analytics Track Only ${symbol_pound}viewport.label")
    def "Page List: Pages with Analytics Track Only"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist35"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "First page link should have attribute: data-layer-track"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-track").equals("true")

        and: "First page link should have attribute: data-layer-label"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-label").equals("badge Link Description")

        and: "First page link should have attribute: data-layer-location"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(0).attr("data-layer-location").equals("")

        and: "Second page link should have attribute: data-layer-track"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(1).attr("data-layer-track").equals("true")

        and: "Second page link should have attribute: data-layer-label"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(1).attr("data-layer-label").equals("Badge Link")

        and: "Third page link should have attribute: data-layer-track"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(2).attr("data-layer-track").equals("true")

        and: "Third page link should have attribute: data-layer-label"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul li a").getAt(2).attr("data-layer-label").equals("Page3")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Page List: Pages with no Details in ${symbol_pound}viewport.label")
    def "Page List: Pages with no Details"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist36"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five items of page missing details"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .page-missing-details").size() == 5

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

}
