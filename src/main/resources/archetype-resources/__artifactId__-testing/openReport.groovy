#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
def openReport(file) {
    System.println("Trying to open report: ${symbol_dollar}{file.getPath()}")

    if (!file.isFile()) {
        System.err.println("Report file not found: ${symbol_dollar}{file.getPath()}")
        //return true
    } else {
        def url = "file://${symbol_dollar}{file.canonicalPath}"
        System.println("Opening report: ${symbol_dollar}{url}")
        java.awt.Desktop.desktop.browse url.toURI()
    }

}


if (!System.properties.containsKey("skipOpenReport")) {

    try {
        String reportDir = System.properties.getProperty("project.buildDirectory", "local-chrome")
        File fileHtml = new File("./${symbol_dollar}reportDir/generated-docs/html/summary.html")

        openReport(fileHtml)

        File filePdf = new File("./${symbol_dollar}reportDir/generated-docs/pdf/summary.pdf")
        openReport(filePdf)


    } catch (Throwable t) {
        t.printStackTrace()
        return false
    }
} else {
    System.println("Skipping opening report")
}


return true;
