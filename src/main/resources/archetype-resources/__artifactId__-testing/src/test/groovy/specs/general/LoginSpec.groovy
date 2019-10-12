#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.general

import spock.lang.Ignore
import support.page.AdminLoginPage
import support.page.ui.touch.TouchUI
import support.page.ui.touch.TouchUIHome
import spock.lang.Stepwise
import spock.lang.Unroll
import support.FunctionalSpec

@Stepwise
@Ignore
class LoginSpec extends FunctionalSpec {

    String pageElement = "body .background"

    @Unroll("Should be able to see login page in ${symbol_pound}viewport.label")
    def "Should be able to see login page"() {
        when: "I am on the Admin Login page"
        setWindowSize(viewport)
        to AdminLoginPage

        then: "The page should match the design reference"
        ${symbol_dollar}(pageElement).allElements().eachWithIndex { element, index ->
            designReference(element)
        }

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()

    }

    @Unroll("Should not log in with wrong username and password in ${symbol_pound}viewport.label")
    def "Should not log in with wrong username and password"() {
        given: "I am on the Admin Login page"
        setWindowSize(viewport)
        to AdminLoginPage

        when: "I enter the wrong username and password"
        login("blah", "blah")

        then: "I should see an error message"
        assert ${symbol_dollar}("${symbol_pound}error").text().trim() == "User name and password do not match"

        then: "The page should match the design reference"
        ${symbol_dollar}(pageElement).allElements().eachWithIndex { element, index ->
            designReference(element)
        }

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }

    @Unroll("Should log in with valid username and password in ${symbol_pound}viewport.label")
    def "Should log in with valid username and password"() {
        given: "I am on the Admin Login page"
        setWindowSize(viewport.label)
        to AdminLoginPage

        when: "I enter the wrong username and password"
        login("admin", "admin")

        then: "I should see AEM Start Page"
        at TouchUIHome

        then: "The page should match the design reference"
        ${symbol_dollar}(TouchUI.elements.DOCUMENT_BODY).allElements().eachWithIndex { element, index ->
            designReference(element)
        }

        where: "Browser size width: ${symbol_pound}viewport.width and height: ${symbol_pound}viewport.height"
        viewport << getViewPorts()
    }


}
