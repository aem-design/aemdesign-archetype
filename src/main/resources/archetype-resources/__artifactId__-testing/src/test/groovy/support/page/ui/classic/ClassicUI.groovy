#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package support.page.ui.classic

import com.google.common.base.Predicate
import geb.Module
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import support.page.AuthorPage

/**
 * Generic Classic UI Functions
 */

class ClassicUI extends AuthorPage {

    static url = "/cf${symbol_pound}"

    static at = {
        waitFor {
            js.exec("return (window.CQ?true:false)")
        }
    }

    static content = {

        Editor(wait: true, required: true) { module Editor }
    }

    def waitForSidekick() {
        waitFor {
            ${symbol_dollar}("${symbol_pound}cq-sk")
        }

    }

    def waitForCQToLoad() {
        return waitFor {
            return js.exec("return (window.CQ?true:false)&&(window.CQ.WCM.getContentFinder()?true:false)&&(window.CQ.WCM.getContentFinder().getContentWindow()?true:false)&&(window.CQ.WCM.getContentFinder().getContentWindow().CQ.utils.WCM?true:false)")
        }

    }

    public void pause() {
        js.exec """
           (function() {
               window.__gebPaused = true;
               var div = document.createElement("div");
               div.setAttribute('style', "${symbol_escape}${symbol_escape}
                   position: absolute; top: 0px;${symbol_escape}${symbol_escape}
                   z-index: 3000;${symbol_escape}${symbol_escape}
                   padding: 10px;${symbol_escape}${symbol_escape}
                   background-color: red;${symbol_escape}${symbol_escape}
                   border: 2px solid black;${symbol_escape}${symbol_escape}
                   border-radius: 2px;${symbol_escape}${symbol_escape}
                   text-align: center;${symbol_escape}${symbol_escape}
               ");

               var button = document.createElement("button");
               button.innerHTML = "Unpause Geb";
               button.onclick = function() {
                   window.__gebPaused = false;
               }
               button.setAttribute("style", "${symbol_escape}${symbol_escape}
                   font-weight: bold;${symbol_escape}${symbol_escape}
               ");

               div.appendChild(button);
               document.getElementsByTagName("body")[0].appendChild(div);
           })();
       """

        waitFor(10) { !js.__gebPaused }
    }


    def waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new Predicate<WebDriver>() {
            public boolean apply(WebDriver driver) {

                println("WAITING")
                return ((JavascriptExecutor) driver).executeScript("return (window.CQ?true:false)&&(window.CQ.WCM.getContentFinder()?true:false)&&(window.CQ.WCM.getContentFinder().getContentWindow()?true:false)&&(window.CQ.WCM.getContentFinder().getContentWindow().CQ.utils.WCM?true:false)");

            }
        }
        )
    }
}

class PageContentModule extends Module {
    static base = { ${symbol_dollar}("${symbol_pound}CQ") }
    static content = {
        container(wait: true) { ${symbol_dollar}("${symbol_pound}CQ") }
    }
}

class Editor extends Module {
    static base = { ${symbol_dollar}("${symbol_pound}CQ") } //CQ.WCM.getContentFinder().getContentWindow()
    static content = {

        container(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}CQ") }
        sidekick(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}cq-sk") }
        contentFinder(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}cq-cf-west") }
        sideBySide(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}cq-cf-east") }
        pageContent(wait: true, required: true) { ${symbol_dollar}("${symbol_pound}cq-cf-framewrapper") }

    }

    def Window(String action) {
        return Window(action, false)
    }

    def Window(String action, boolean doReturn) {
        String returnPrefix = ""
        if (doReturn) {
            returnPrefix = "return "
        }
        String baseScript = "CQ.WCM.getContentFinder().getContentWindow()"
        String execScript = returnPrefix + baseScript + action

        println("ClassicUI Window: " + execScript)

        String result = js.exec(execScript)
        println("ClassicUI Result: " + result)
        if (doReturn) {
            println("ClassicUI Return: " + result)
            return result
        } else {
            println("ClassicUI Return: auto true")
            return true
        }

    }

    def Editables(String action) {
        return Editables(action, false)
    }

    def Editables(String action, boolean doReturn) {
        String returnPrefix = ""
        if (doReturn) {
            returnPrefix = "return "
        }
        String baseScript = "return CQ.WCM.getContentFinder().getContentWindow().CQ.utils.WCM.getEditables()"
        String execScript = returnPrefix + baseScript + action

        println("Editables: " + execScript)

        String result = js.exec(execScript)
        if (doReturn) {
            return result
        } else {
            return true
        }

    }

    def Editable(String action, String path) {

        String baseScript = ".CQ.utils.WCM.getEditable('" + path + "')"
        String execScript = baseScript + action

        //  println("Editable: "+execScript)

        return Window(execScript)

    }

    def Editable(String action, String path, boolean doReturn) {

        String baseScript = ".CQ.utils.WCM.getEditable('" + path + "')"
        String execScript = baseScript + action

        //  println("Editable: "+execScript)

        return Window(execScript, doReturn)

    }

    def addComponent(String path, String componentPart) {

        return Editable(".createParagraph(CQ.WCM.getContentFinder().getContentWindow().CQ.utils.WCM.getComponentList().allComponents['" + componentPart + "'])", path + "/*")

    }

    def removeComponent(String path) {
        return Editable(".removeParagraph()", path)

    }

    def okDialog(String path) {
        return Editable(".dialogs.EDIT.ok()", path)
    }

    def closeDialog(String path) {
        return Editable(".dialogs.EDIT.close()", path)
    }

    def isDialogHidden(String path) {
        return Editable(".dialogs.EDIT.hidden", path, true)
    }

    def dismissDialog(String dialogTitle, String button) {

        if (button == "Yes") {
            return Window(".CQ.Ext.Msg.getDialog(${symbol_escape}"" + dialogTitle + "${symbol_escape}").buttons[1].handler()")
        } else if (button == "Ok") {
            return Window(".CQ.Ext.Msg.getDialog(${symbol_escape}"" + dialogTitle + "${symbol_escape}").buttons[0].handler()")
        }
        return false;

    }

    def dropAsset(String path, String fieldName, String assetPath) {
        return Editable(".dialogs.EDIT.form.findField(${symbol_escape}"" + fieldName + "${symbol_escape}").handleDrop({${symbol_escape}"records${symbol_escape}":[{get:function() {return '" + assetPath + "'}}],${symbol_escape}"single${symbol_escape}":true})", path)
    }

    def setDialogValue(String path, String fieldId, String value) {
        return Editable(".dialogs.EDIT.form.findField(${symbol_escape}"" + fieldId + "${symbol_escape}").setValue('" + value + "')", path)
    }

    def showDialog(String path) {
        return Editable(".showDialog(CQ.WCM.getContentFinder().getContentWindow().CQ.utils.WCM.getEditable('" + path + "'))", path)
    }

    def execDialog(String path, String action) {
        //CQ.utils.WCM.getDialogs()["editdialog-/content/${contentFolderName}-showcase/en/component/layout/contentblocklock/jcr:content/article/par/contentblocklock1"].find("name","permissionCheckTabAccessCheck")
        return Window(".CQ.utils.WCM.getDialogs()['editdialog-" + path + "']" + action, true)
    }

    def toDesignMode() {
        js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}".cq-sidekick-design${symbol_escape}").click()")
    }

    def toEditMode() {
        js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}".cq-sidekick-edit${symbol_escape}").click()")
        js.exec("return ${symbol_escape}${symbol_dollar}(${symbol_escape}".cq-sidekick-reload${symbol_escape}").click()")
    }

    def checkComponentRender(String path) {
        return Editable(".rendered", path)
    }

}

