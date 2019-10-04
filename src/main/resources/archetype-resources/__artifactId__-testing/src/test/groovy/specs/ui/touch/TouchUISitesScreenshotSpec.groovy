#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.ui.touch

import spock.lang.Ignore
import support.page.ui.touch.TouchUI
import support.page.ui.touch.TouchUISites
import spock.lang.Stepwise
import spock.lang.Unroll
import support.AuthorSpec

@Stepwise
@Ignore
class TouchUISitesScreenshotSpec extends AuthorSpec {

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Default Sites screen should match reference design reference in ${symbol_pound}viewport.label")
    def "Default Sites screen should match reference design reference"() {
        given: "I am on the Sites Page"
        setWindowSize(viewport)
        to TouchUISites

        when: "I am on the Sites Page"
        at TouchUISites
        waitForImagesToLoad(page.pageContentLoaded)

        then: "The page should match the design reference"
        ${symbol_dollar}(TouchUI.elements.DOCUMENT_BODY).allElements().eachWithIndex { element, index ->
            designReference(element)
        }

        where:
        viewport << getViewPorts()

    }

}
