#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Dimension
import spock.lang.Shared
import support.page.AEMPage
import support.page.PublishPage
import support.page.ui.classic.ClassicUIEditor
import support.page.ui.touch.TouchUIEditor

abstract class ComponentSpec extends FunctionalSpec {

    @Shared
    def String componentPath
    @Shared
    def String pageHeading
    @Shared
    def String componentName
    @Shared
    def String componentSelector
    @Shared
    def String componentScreenshotNamePrefix
    @Shared
    def String componentDocs
    @Shared
    def String pageExtension = ".html"

    @Shared
    def String pageSelectors = ""

    @Shared
    def String pathPage
    @Shared
    def String pathSite
    @Shared
    def String language

    def setupSpec() {
    }

    def compileComponentPath() {
        return "/${symbol_dollar}{pathSite}/${symbol_dollar}{language}/${symbol_dollar}{pathPage}/${symbol_dollar}{componentPath}"
    }

    def compileComponentScreenshotFileNamePath(Integer width, Integer height) {
        return compileComponentScreenshotFileNamePath("", width, height, "")
    }

    def compileComponentScreenshotFileNamePath(Integer width, Integer height, String ext) {
        return compileComponentScreenshotFileNamePath("", width, height, ext)
    }

    def compileComponentScreenshotFileNamePath2(String componentInstance, Integer width, Integer height, String ext) {
//        if (ext.isEmpty()) {
//            ext = ".png"
//        }
        if (componentInstance.isEmpty()) {
            componentInstance = "default"
        }
        return (String[])["${symbol_dollar}{pathSite}/${symbol_dollar}{language}/${symbol_dollar}{pathPage}","${symbol_dollar}{componentPath}-${symbol_dollar}{componentInstance}${symbol_dollar}{ext}"]
    }

    def compileComponentScreenshotFileNamePath(String componentInstance, Integer width, Integer height, String ext) {
        if (ext.isEmpty()) {
            ext = ".png"
        }
        if (componentInstance.isEmpty()) {
            componentInstance = "default"
        }
        return "${symbol_dollar}{pathSite}/${symbol_dollar}{language}/${symbol_dollar}{pathPage}/${symbol_dollar}{componentPath}-${symbol_dollar}{componentInstance}${symbol_dollar}{ext}"
    }

    def waitForClassicUIPage(String inLanguage) {
        if (StringUtils.isEmpty(inLanguage)) {
            inLanguage = language
        }
        def page = to ClassicUIEditor, page.AEMPage.toLanguage(pathSite, inLanguage, pathPage + pageSelectors + pageExtension)
        page.waitForSidekick()
        return page
    }

    def waitForTouchUIPage(String inLanguage) {
        return waitForTouchUIPage(inLanguage, null)
    }

    def waitForTouchUIPage(String inLanguage, String pageTitle) {
        if (StringUtils.isEmpty(inLanguage)) {
            inLanguage = language
        }
        //printDebug("URL", [page.AEMPage.toLanguage(pathSite,inLanguage,pathPage + pageExtension)])

        def page = to TouchUIEditor, page.AEMPage.toLanguage(pathSite, inLanguage, pathPage + pageSelectors + pageExtension)
        page.waitForPageContent()
//        waitForDocumentReady()
        return page
    }

    def waitForAuthorPreviewPage(String inLanguage) {

        if (StringUtils.isEmpty(inLanguage)) {
            inLanguage = language
        }
        String url = page.AEMPage.toMode(page.AEMPage.toLanguage(pathSite, inLanguage, pathPage + pageSelectors + pageExtension), AEMPage.WCMMODE.DISABLED)
        printDebug("URL", [url, driver.manage().window().getSize()])
//        System.out.println("Loading Page: "+url)
        def page = to PublishPage, url
        at PublishPage
        waitForDocumentReady()
        return page
    }

    def waitForAuthorPreviewPageUrl(String pageUrl) {

        //remove first slash
        if (pageUrl.startsWith("/")) {
            pageUrl = pageUrl.replaceFirst("/","")
        }

        String url = page.AEMPage.toMode(pageUrl, AEMPage.WCMMODE.DISABLED)
        printDebug("URL", [url, driver.manage().window().getSize()])
//        System.out.println("Loading Page: "+url)
        def page = to PublishPage, url
        at PublishPage
        waitForDocumentReady()
        return page
    }


    def waitForAuthorPreviewPageWithQuery(String inLanguage, String requestQuery) {
        if (StringUtils.isEmpty(inLanguage)) {
            inLanguage = language
        }
        String queryString = ""
        if (StringUtils.isNotEmpty(requestQuery)) {
            queryString = "&${symbol_dollar}requestQuery"
        }
        String url = page.AEMPage.toMode(
                    page.AEMPage.toLanguage(pathSite, inLanguage, pathPage + pageExtension),
                    AEMPage.WCMMODE.DISABLED)

        url = "${symbol_dollar}url${symbol_dollar}queryString"

        printDebug("LOADING PAGE:",url)

        def page = to PublishPage, url
        at PublishPage
        waitForDocumentReady()
        return page
    }


    def waitForTouchUIComponentOverlay(componentSelector) {

        String componentDataPath = "/" + page.AEMPage.toLanguage(pathSite, language, pathPage.concat("/").concat(componentPath))
        String componentDataPathSelector = "[data-path='" + componentDataPath + "']"
        printDebug("OVERLAY PATH", [componentDataPath])
        printDebug("OVERLAY SELECTOR", [componentDataPathSelector])

        return waitFor {
            if (find(componentDataPathSelector)) {
                return ${symbol_dollar}(componentDataPathSelector)
            }
        }
    }

    def waitForComponent(componentSelector) {
        return waitFor {
            if (!find(componentSelector).isEmpty()) {
                return ${symbol_dollar}(componentSelector)
            }
        }
    }

    def waitForComponent() {
        waitFor {
            if (!componentSelector.isEmpty()) {
                ${symbol_dollar}(componentSelector)
            }
        }
    }

    def waitForJs(String script) {
        return waitForJs(script, 30)
    }

    def waitForJs(String script, Integer wait) {
        return waitFor(wait) {
            return js.exec(""" return ${symbol_dollar}{script} """)
        }
    }

    //designRefFull("fullscreen","")
    def designRefFull(selector,prefix) {
        def size = getWindowViewPort()
        return designReferenceFull(compileComponentScreenshotFileNamePath2(prefix + selector + size + "-" + "0", size.width, size.height, ""))
    }

    def designRef(String selector) {
        return designRef(selector, "")
    }

    def designRef(String selector, String prefix) {
        def size = getWindowWidthName();
        size = size.length() == 0 ? "" : "-" + size
        def resultCompare = true

//        printDebug("DESIGN REF", [selector,prefix,size])

        ${symbol_dollar}(selector).allElements().eachWithIndex { e, i ->
            Dimension d = e.getSize()
            def currentResultCompare = designReference(e, compileComponentScreenshotFileNamePath(prefix + selector + size + "-" + i, d.width, d.height, ".png"))
            if (resultCompare && !currentResultCompare) {
                resultCompare = currentResultCompare
            }
        }
//        printDebug("COMPARE RETURN2",resultCompare)
        if (!resultCompare) {
            throw new Error("Design reference does not match current layout.")
        }
        return resultCompare
    }


    def verifyComponent(div, instance) {
//        println("Testing: verifyComponent for ${symbol_dollar}{instance}")
        div.allElements().eachWithIndex { element, index ->
            Integer width = element.getSize().width
            Integer height = element.getSize().height
            if (width > 0 && height > 0) {
                componentPath = instance;
                assert designReference(element, compileComponentScreenshotFileNamePath(width, height, ".png"))
            } else {
                System.err.println("Skip this element [" + instance + "] width: ${symbol_dollar}{width}, height: ${symbol_dollar}{height}");
            }

        }
    }

    def compareInnerTextIgnoreCase(selector, innerText) {
        return ${symbol_dollar}("${symbol_dollar}selector").firstElement().getAttribute("innerText").compareToIgnoreCase("${symbol_dollar}innerText") == 0
    }

    def compareInnerTextContains(selector, innerText) {
        return ${symbol_dollar}("${symbol_dollar}selector").firstElement().getAttribute("innerText").contains("${symbol_dollar}innerText")
    }

}
