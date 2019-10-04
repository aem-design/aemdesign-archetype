#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support

import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import groovy.json.JsonOutput

/**
 * Extracts all information gathered as JSON to a file which is later processed
 * by the plugin.
 */
class ReportListener implements ReportingListener {

    def report = [tests: [], reports: []]
    def reportDataFileName = "gebReportInfo.json"

//    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
//        reportFiles.each {
//            printDebug("ATTACHMENT",it.absolutePath)
////            println "{${symbol_escape}"ATTACHMENT${symbol_escape}":${symbol_escape}"${symbol_dollar}it.absolutePath${symbol_escape}"}"
//        }
//    }


    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {

        this.writeReportResource(reportState.browser.config.reportsDir.path.toString(),
                reportState.browser.reportGroup.toString(),
                reportState.browser.driver.currentUrl.toString(),
                reportState.browser.page.toString(),
                reportState.label.toString(),
                reportFiles
        )
    }

    void writeReportResource(String reportDir, String reportGroup, String currentUrl, String className, String label, List<File> reportFiles) {
        def out = new File(reportDir, reportDataFileName)

        def labelFirstPart = label.split('(-)',3)
        def labelSecondPart = labelFirstPart[2].split('(-)(?!.*-)')

//        println("labelFirstPart: ${symbol_dollar}{labelFirstPart}")
//        println("labelSecondPart: ${symbol_dollar}{labelSecondPart}")

        def testNum = labelFirstPart[0]
        def reportNum =  labelFirstPart[1]
        def testLabel =  labelSecondPart[0]
        def reportLabel = labelSecondPart[1]

//        println("label: ${symbol_dollar}{label}")
//        println("label split: testNum=${symbol_dollar}{testNum}, reportNum=${symbol_dollar}{reportNum}, testLabel=${symbol_dollar}{testLabel}, reportLabel=${symbol_dollar}{reportLabel}")

        //re-escape dashes
//        testLabel = testLabel.replaceAll('--', '-')
//        reportLabel = reportLabel.replaceAll('--', '-')

//        println("label split fix: testLabel=${symbol_dollar}{testLabel}, reportLabel=${symbol_dollar}{reportLabel}")

        def res = [
                spec: [
                        label: reportGroup,
                        test : [
                                num   : (testNum),
                                label : testLabel,
                                report: [
                                        time : new Date().time,
                                        num  : reportNum,
                                        label: reportLabel,
                                        url  : currentUrl,
                                        page : className,
                                        files: reportFiles.collect { it.absolutePath }
                                ]
                        ]
                ]
        ]

        out << JsonOutput.toJson(res) + "${symbol_escape}n"
    }

}
