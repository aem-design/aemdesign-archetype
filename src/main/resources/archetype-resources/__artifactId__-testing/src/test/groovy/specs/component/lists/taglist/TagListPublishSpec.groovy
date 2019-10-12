#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.taglist

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class TagListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/tag-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/taglist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component with Default variant and no content in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant  and no content"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Component does not have any content"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").children().size() == 0

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Default variant and List of Children in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant and List of Children"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 10 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 10

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Default variant and List of Descendants in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant and List of Descendants"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 19 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 19

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Default variant and Fixed List in ${symbol_pound}viewport.label")
    def "Functionality of Component with Default variant and Fixed List"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist4"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 3 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 3

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component with Options List variant and no content in ${symbol_pound}viewport.label")
    def "Functionality of Component with Options List variant  and no content"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist5"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Component only has an empty option"
        assert ${symbol_dollar}("${symbol_dollar}{selector}").children().size() == 1

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Options List variant and List of Children in ${symbol_pound}viewport.label")
    def "Functionality of Component with Options List variant and List of Children"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist6"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 10 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} option").size() == 11

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Options List variant and List of Descendants in ${symbol_pound}viewport.label")
    def "Functionality of Component with Options List variant and List of Descendants"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist7"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 19 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} option").size() == 20

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Options List variant and Fixed List in ${symbol_pound}viewport.label")
    def "Functionality of Component with Options List variant and Fixed List"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Tag List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}taglist8"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has 3 list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} option").size() == 4

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
