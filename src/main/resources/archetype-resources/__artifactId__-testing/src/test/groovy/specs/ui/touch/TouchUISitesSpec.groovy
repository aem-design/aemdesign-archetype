#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.ui.touch

import spock.lang.Ignore
import support.page.ui.touch.TouchUISites
import spock.lang.Stepwise
import support.AuthorSpec

@Stepwise
@Ignore
class TouchUISitesSpec extends AuthorSpec {

    def setupSpec() {
        loginAsAdmin()
    }

    static final String PATH_SITE = '/content/${contentFolderName}'

    def "Should see if there is a Site"() {
        given: "I navigate to Touch UI Sites"
        to TouchUISites

        when: "I am on the Sites Page"
        at TouchUISites

        then: "I should see if there is a Site Item"
        assert page.find(".foundation-collection-item[data-foundation-collection-item-id='${symbol_dollar}{PATH_SITE}']") != null

    }


}
