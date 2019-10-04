#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.ui.touch

import spock.lang.Ignore
import support.page.ui.touch.TouchUIProjects
import spock.lang.Stepwise
import support.AuthorSpec

@Stepwise
@Ignore
class TouchUIProjectsSpec extends AuthorSpec {

    def setupSpec() {
        loginAsAdmin()
    }

    static final String PATH_PROJECT = '/content/projects/${contentFolderName}'

    def "Should see if there is a Project"() {
        given: "I navigate to Touch UI Projects Page"
        to TouchUIProjects

        when: "I am on the Touch UI Projects Page"
        at TouchUIProjects

        then: "See if there is a Project"
        assert page.find(".foundation-collection-item[data-foundation-collection-item-id='${symbol_dollar}{PATH_PROJECT}']")
                .find(".foundation-collection-item-title", text: "We.Retail")
    }


}
