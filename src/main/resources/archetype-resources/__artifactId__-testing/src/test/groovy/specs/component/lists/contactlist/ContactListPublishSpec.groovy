#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.contactlist

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ContactListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/contact-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/contactlist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with Default variant using Default badge in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant using Default badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul.list > li").size() == 6

        and: "Has first item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.first").text().trim() == "Contact1"

        and: "Has last item"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li.last").text().trim() == "Contact6"

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Card Action with Icon, Title, Category and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component with Card Action with Icon, Title, Category and Description"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul.list > li").size() == 2

        and: "Has card title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").size() == 2

        and: "Has card tags"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-category").size() == 2

        and: "Has card description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").size() == 2

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Card Action with Image, Title, Category and Description in ${symbol_pound}viewport.label")
    def "Functionality of Component with Card Action with Image, Title, Category and Description"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul.list > li").size() == 2

        and: "Has card has image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").size() == 2

        and: "Has card title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").size() == 2

        and: "Has card tags"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-category").size() == 2

        and: "Has card description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").size() == 2

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Card with Icon, Title, Category, Description and Action in ${symbol_pound}viewport.label")
    def "Functionality of Component with Card with Icon, Title, Category, Description and Action"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist4"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul.list > li").size() == 2

        and: "Has card title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").size() == 2

        and: "Has card tags"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-category").size() == 2

        and: "Has card description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").size() == 2

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component with Card with Image, Title, Category, Description and Action in ${symbol_pound}viewport.label")
    def "Functionality of Component with Card with Image, Title, Category, Description and Action"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist5"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has two list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} ul.list > li").size() == 2

        and: "Has card has image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} img").size() == 2

        and: "Has card title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-title").size() == 2

        and: "Has card tags"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-category").size() == 2

        and: "Has card description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-text").size() == 2

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    //${symbol_pound}contactlist6 is in ContactListPaginationPublishSpec

    @Unroll("Functionality of Component with Card with Image, Title, Category, Description and Email Action Format in ${symbol_pound}viewport.label")
    def "Functionality of Component with Card with Image, Title, Category, Description and Email Action Format"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Contact List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}contactlist7"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has card description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card-link").getAt(0).getAttribute("href").contains("mailto:")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
