#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.lists.pagelist

import org.apache.commons.io.IOUtils
import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class PageListPublishFeedTestSpec extends ComponentSpec {

    String pathPage = "component/lists/page-list"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "au/en"
    String componentPath = "jcr:content/article/par/pagelist"

    def setupSpec() {
        loginAsAdmin()
    }

    def "Page List: RSS Feed"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist9"

        when: "I download the feed file"
        def downloadSHA1 = downloadContent("/content/${contentFolderName}-showcase/au/en/component/lists/page-list/_jcr_content/article/par/contentblock9/par/pagelist.rss")
        def feedContent = IOUtils.toString(new InputStreamReader(downloadSHA1))

        then: "The feed file should have title tag"
        assert feedContent.contains("<title>Page List</title>")

        and: "The feed file should have ttl tag"
        assert feedContent.contains("<ttl>1800</ttl>")


    }

    def "Page List: Atom Feed"() {

        given: '>the page hierarchy is created as "Components" > "Lists" > "Page List"'
        and: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}pagelist10"

        when: "I download the feed file"
        def downloadSHA1 = downloadContent("/content/${contentFolderName}-showcase/au/en/component/lists/page-list/_jcr_content/article/par/contentblock10/par/pagelist.feed")
        def feedContent = IOUtils.toString(new InputStreamReader(downloadSHA1))

        then: "The page should have title tag"
        assert feedContent.contains("<title type=${symbol_escape}"html${symbol_escape}">Page List</title>")


    }

}
