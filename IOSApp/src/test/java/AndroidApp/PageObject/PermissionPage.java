package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

public class PermissionPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "com.android.packageinstaller:id/dialog_container")
    private IOSElement popup_permission;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private IOSElement permission_deny;

    @iOSXCUITFindBy(id = "Allow")
    private IOSElement permission_allow;

    @iOSXCUITFindBy(id = "com.google.android.gms:id/cancel")
    private IOSElement cancel_popup;


    public PermissionPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Permission Page*****");
    }

    public void clickOnPermissionDeny() {
        Element.selectElement(driver, permission_deny, "Permission Deny");
    }

    public void clickOnCancelHint() {
        Element.selectElement(driver, cancel_popup, "Cancel Popup");
    }

    public void clickOnPermissionAllow() {
        Element.selectElement(driver, permission_allow, "Permission Allow");
    }
}
