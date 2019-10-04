#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.uniquepages._sample

import geb.spock.GebReportingSpec
import spock.lang.IgnoreIf
import spock.lang.Stepwise

@Stepwise
@IgnoreIf({ System.properties.getProperty("geb.env") != "sample" })
class SampleSpec extends GebReportingSpec {

    static url = "https://google.com"

    static at = {
        waitFor(30) { ${symbol_dollar}("body") }
    }



    def "Google is online"() {
        given: "we are on google page"
        def selector = "body"

        expect: "body element should not be empty"
        assert !${symbol_dollar}(selector).isEmpty()
    }

}
