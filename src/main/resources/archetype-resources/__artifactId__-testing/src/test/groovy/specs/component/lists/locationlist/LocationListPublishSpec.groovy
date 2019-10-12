#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.locationlist

import spock.lang.IgnoreRest
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class LocationListPublishSpec extends ComponentSpec {

    String pathPage = "component/lists/location-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/contentblock1/par/locationlist"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Location List: Default variant using Default badge in ${symbol_pound}viewport.label")
    def "Location List: Default variant using Default badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Location List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}locationlist1"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} li").size() == 6

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Location List: Map Data in ${symbol_pound}viewport.label")
    def "Location List: Map Data"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Location List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}locationlist2"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has five features items"
        assert js.exec(" return locationlist2.features.length == 6;")

        and: "Map has been created"
        assert js.exec(" return AEMDESIGN.components.locationlist.googleMapInstances[${symbol_escape}${symbol_dollar}(${symbol_escape}"${symbol_pound}locationlist2${symbol_escape}").data(${symbol_escape}"map-index${symbol_escape}")]?true:false;")

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


    @IgnoreRest
    @Unroll("Location List: Card with Image, Title, Category, Description and Action badge in ${symbol_pound}viewport.label")
    def "Location List: Card with Image, Title, Category, Description and Action badge"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Location List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}locationlist3"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)
        takeScreenshot(${symbol_dollar}(selector).firstElement(), "The component should be on the page")

        and: "Has six list items"
        assert ${symbol_dollar}("${symbol_dollar}{selector} > div > ul > li").size() == 6

        and: "With image"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card img").size() == 6

        and: "With Title"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card .card-title").size() == 6

        and: "With Category"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card .tags").size() == 6

        and: "With Description"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card .card-text").size() == 6

        and: "And Action"
        assert ${symbol_dollar}("${symbol_dollar}{selector} .card .card-action").size() == 6

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

}
