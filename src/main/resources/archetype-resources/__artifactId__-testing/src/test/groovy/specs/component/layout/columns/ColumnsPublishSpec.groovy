#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.columns

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ColumnsPublishSpec extends ComponentSpec {

    String pathPage = "component/layout/columns"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/colctrl"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component Variant: Default using 1 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 1 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl1"
        def selectorContainer = "${symbol_pound}contentblock1 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 1 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 1
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 1 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default using 2 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 2 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl2"
        def selectorContainer = "${symbol_pound}contentblock2 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 2 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 2
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 2 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default using 3 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 3 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl3"
        def selectorContainer = "${symbol_pound}contentblock3 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 3 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 3
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 3 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        and: "Column 3 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].find(".text").text().trim() == "Column 3"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default using 4 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 4 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl4"
        def selectorContainer = "${symbol_pound}contentblock4 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 4 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 4
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 4 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        and: "Column 3 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].find(".text").text().trim() == "Column 3"

        and: "Column 4 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[3].find(".text").text().trim() == "Column 4"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default using 5 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 5 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl5"
        def selectorContainer = "${symbol_pound}contentblock5 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 5 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 5
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 5 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        and: "Column 3 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].find(".text").text().trim() == "Column 3"

        and: "Column 4 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[3].find(".text").text().trim() == "Column 4"

        and: "Column 5 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[4].find(".text").text().trim() == "Column 5"

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component Variant: Default using 6 Column Layout in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default using 6 Column Layout"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl6"
        def selectorContainer = "${symbol_pound}contentblock6 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 6 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 6
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 6 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        and: "Column 3 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].find(".text").text().trim() == "Column 3"

        and: "Column 4 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[3].find(".text").text().trim() == "Column 4"

        and: "Column 5 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[4].find(".text").text().trim() == "Column 5"

        and: "Column 6 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[5].find(".text").text().trim() == "Column 6"

        where:
        viewport << getViewPorts()
    }


    @Unroll("Functionality of Component Variant: Default with 5 Column Layout Varied Width in ${symbol_pound}viewport.label")
    def "Functionality of Component Variant: Default with 5 Column Layout Varied Width"() {

        given: '>the page hierarchy is created as "Components" > "Content" > "Columns"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl7"
        def selectorContainer = "${symbol_pound}contentblock7 .contents"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 5 column"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm").size() == 5
        takeScreenshot(${symbol_dollar}(selectorContainer).firstElement(), "Should have 5 column")

        and: "Column 1 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].find(".text").text().trim() == "Column 1"

        and: "Column 1 should have custom width"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[0].attr("class").contains("col-md-2")


        and: "Column 2 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].find(".text").text().trim() == "Column 2"

        and: "Column 2 should have custom width"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[1].attr("class").contains("col-md-3")


        and: "Column 3 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].find(".text").text().trim() == "Column 3"

        and: "Column 3 should have custom width"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[2].attr("class").contains("col-md-2")


        and: "Column 4 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[3].find(".text").text().trim() == "Column 4"

        and: "Column 4 should have custom width"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[3].attr("class").contains("col-md-3")


        and: "Column 5 should have sample content"
        ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[4].find(".text").text().trim() == "Column 5"

        and: "Column 5 should have custom width"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .row .col-sm")[4].attr("class").contains("col-md-2")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of ColCtrl with 2 Column Multi Breakpoints MD and LG (3,9 and 9,3) in ${symbol_pound}viewport.label")
    def "Functionality of ColCtrl with 2 Column Multi Breakpoints MD and LG (3,9 and 9,3)"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Content Block > ColCtrl"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}colctrl9"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: "Should have 2 columns"
        assert ${symbol_dollar}(selector + " > .parsys_column .col-sm").size() == 2

        and: "First item should match the structure and contain classes col-md-3 col-lg-9"
        assert ${symbol_dollar}(selector + " > div > div").getAt(0).attr("class").contains("col-md-3 col-lg-9")

        and: "Second item should match the structure and contain classes col-md-9 col-lg-3"
        assert ${symbol_dollar}(selector + " > div > div").getAt(1).attr("class").contains("col-md-9 col-lg-3")

        where:
        viewport << getViewPorts()
    }
}
