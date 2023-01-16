package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ZipPage {


    AndroidDriver driver;

    @AndroidFindBy(id = "navigation_zip")
    private AndroidElement zipButton;

    @AndroidFindBy(id = "btn_activate")
    private AndroidElement cta;

    @AndroidFindBy(id = "button_accept")
    private AndroidElement buttonAllow;

    @AndroidFindBy(id = "button_skip")
    private AndroidElement buttonNotNow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permissionAllowLocation;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowContacts;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllowMessages;

    @AndroidFindBy(id = "mkab_title")
    private AndroidElement title;

    @AndroidFindBy(id = "tv_label")
    private AndroidElement label;


    public ZipPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickZipIcon() {
        Elements.selectElement(driver, zipButton, "Zip Icon");
    }

    public void clickCtaActivate() {
        Elements.selectElement(driver, cta, "Cta Activate");
    }

    public void clickNotNow() {
        Elements.selectElement(driver, buttonNotNow, "Not Now");
    }

    public boolean isClickAllowPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, buttonAllow);
    }

    public void clickAllow() {
        Elements.selectElement(driver, buttonAllow, "Allow");
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

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getLabel() throws InterruptedException {
        return Elements.getText(driver, label, "Label");
    }



}
