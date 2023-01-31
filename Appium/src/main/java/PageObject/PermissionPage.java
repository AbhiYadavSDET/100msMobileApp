package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import Utils.Element;

public class PermissionPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.android.packageinstaller:id/dialog_container")
    private AndroidElement popup_permission;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private AndroidElement permission_deny;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private AndroidElement permission_deny_v2;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement permission_allow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permission_allow_v2;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
    private AndroidElement permission_always_allow_v2;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private AndroidElement cancel_popup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permission_always_allow_v3;

    @AndroidFindBy (xpath="//android.widget.Button[@text= 'While using the app']")
    private AndroidElement permission_while_using_app;

    @AndroidFindBy(id = "permission_allow_foreground_only_button")
    private AndroidElement checkLocationAccess;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permissionAllowLocation;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowContacts;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowMessages;





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
    public void clickOnPermissionDenyV2() {
        Element.selectElement(driver, permission_deny_v2, "Permission Deny");
    }

    public void clickOnCancelHint() {
        Element.selectElement(driver, cancel_popup, "Cancel Popup");
    }

    public void clickOnPermissionAllow() {
        Element.selectElement(driver, permission_allow, "Permission Allow");
    }

    public void clickOnPermissionAllowV2() {
        Element.selectElement(driver, permission_allow_v2, "Permission Allow");
    }

    public void clickOnPermissionAlwaysAllowV2() {
        Element.selectElement(driver, permission_always_allow_v2, "Permission Always Allow");
    }

    public void clickOnPermissionAlwaysAllowV3() {
        Element.selectElement(driver, permission_always_allow_v3, "Permission Allow While Using the App");
    }


    public void clickLocationAccess(){
        Elements.selectElement(driver,checkLocationAccess,"Click allow location");
    }

    public boolean isPermissionLocationPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowLocation);
    }

    public boolean isPermissionContactsPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowContacts);
    }

    public boolean isPermissionMessagePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllowMessages);
    }

    public void allowPermissionLocation() {
        Elements.selectElement(driver, permissionAllowLocation, "Permission Location");
    }

    public void allowPermissionContacts() {
        Elements.selectElement(driver, permissionAllowContacts, "Permission Contacts");
    }

    public void allowPermissionMessage() {
        Elements.selectElement(driver, permissionAllowMessages, "Permission Message");
    }
}
