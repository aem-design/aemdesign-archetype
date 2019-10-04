#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.article

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class ArticlePublishSpec extends ComponentSpec {

    String pathPage = "component/layout/article"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/article"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Functionality of Component in ${symbol_pound}viewport.label")
    def "Functionality of Component"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Article"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}plainarticle"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Article Content"
        report("Should have sample rich text")

        where:
        viewport << getViewPorts()
    }

    @Unroll("Functionality of Component with Background in ${symbol_pound}viewport.label")
    def "Functionality of Component with Background"() {

        given: '>the page hierarchy is created as "Components" > "Layout" > "Article"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}articlewithbackground"

        when: "I am on the component showcase page"
        setWindowSize(viewport)
        waitForAuthorPreviewPage()
        report("I am on the component showcase page")

        then: "The component should be on the page"
        def component = waitForComponent(selector)

        and: 'Should have sample rich text'
        assert ${symbol_dollar}(selector + " .text[component]").text().trim() == "Article Content with Background"

        and: 'Section should have a background image'
        assert ${symbol_dollar}(selector).css("background-image").contains(".png")

        where:
        viewport << getViewPorts()
    }


}
