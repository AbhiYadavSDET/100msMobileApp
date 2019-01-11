package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

public class PermissionPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.android.packageinstaller:id/dialog_container")
    private AndroidElement popup_permission;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private AndroidElement permission_deny;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement permission_allow;


    public PermissionPage(AndroidDriver driver) {
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

    public void clickOnPermissionAllow() {
        Element.selectElement(driver, permission_allow, "Permission Allow");
    }
}
