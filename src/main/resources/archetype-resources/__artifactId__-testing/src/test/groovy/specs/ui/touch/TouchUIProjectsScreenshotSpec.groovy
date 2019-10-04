#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.ui.touch

import spock.lang.Ignore
import support.page.ui.touch.TouchUI
import support.page.ui.touch.TouchUIProjects
import spock.lang.Stepwise
import spock.lang.Unroll
import support.AuthorSpec

@Stepwise
@Ignore
class TouchUIProjectsScreenshotSpec extends AuthorSpec {

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Default Project screen should match reference design reference in ${symbol_pound}viewport.label")
    def "Default Project screen should match reference design reference"() {
        given: "I am on the Projects Page"
        setWindowSize(viewport.label)
        to TouchUIProjects

        when: "I am on the Projects Page"
        at TouchUIProjects
        waitForImagesToLoad(page.pageContentLoaded)

        then: "The page should match the design reference"
        ${symbol_dollar}(TouchUI.elements.DOCUMENT_BODY).allElements().eachWithIndex { element, index ->
            designReference(element)
        }

        where:
        viewport << getViewPorts()

    }

}
