package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ZipPage {


    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/navigation_zip")
    private AndroidElement zipButton;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/btn_activate")
    private AndroidElement cta;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement buttonAllow;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/button_skip")
    private AndroidElement buttonSkip;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permissionAllow1;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllow2;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/mkab_title")
    private AndroidElement title;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/tv_label")
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

    public void clickAllow() {
        Elements.selectElement(driver, buttonAllow, "Allow");
    }

    public void allowPermission1() {
        Elements.selectElement(driver, permissionAllow1, "Permission 1");
    }

    public void allowPermission2() {
        Elements.selectElement(driver, permissionAllow2, "Permission 2");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getLabel() throws InterruptedException {
        return Elements.getText(driver, label, "Label");
    }

}
