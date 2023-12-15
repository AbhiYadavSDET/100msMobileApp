package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
    private IOSElement allow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Later\"]")
    private IOSElement later;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow While Using App\"]")
    private IOSElement allowWhileUsingApp;


    public PermissionPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isPermissionPopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, allow);
    }

    public boolean isEnablePasscodePopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, later);
    }

    public void clickOnAllow() {
        Elements.click(driver, allow ,"Allow Button");
    }

    public void clickOnLater() {
        Elements.click(driver, later ,"Later Button");
    }

    public void clickAllowWhileUsingApp() { Elements.selectElement(driver, allowWhileUsingApp, "Click Allow while using app Button");}
}