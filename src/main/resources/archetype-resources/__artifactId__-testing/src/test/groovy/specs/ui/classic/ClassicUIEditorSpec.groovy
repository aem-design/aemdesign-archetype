#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.ui.classic

import spock.lang.Ignore
import spock.lang.Stepwise
import support.ComponentSpec

@Stepwise
//@IgnoreIf({ System.properties.getProperty("geb.env") != "local" })
@Ignore
class ClassicUIEditorSpec extends ComponentSpec {

    String pathPage = "en.html"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"


    def setupSpec() {
        loginAsAdmin()
    }


    def "Should be able to edit EN Page"() {

        when: "I logged in and EN Page in Classic UI"
        waitForClassicUIPage()

        then: "I should see Component ready to be edited"
        println("Test started ")
        println(page.title)
        println(page.properties)
        println("Read Editables")
        println(page.Editor.Editables("['/content/${contentFolderName}-showcase/au/en/jcr:content/article'].dialog"))
        println("End of Test")

    }


}
