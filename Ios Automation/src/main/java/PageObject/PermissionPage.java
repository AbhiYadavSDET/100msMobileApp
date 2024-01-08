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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    private IOSElement zipBottomSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"“MobiKwik” Would Like to Access Your Contacts\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]")
    private IOSElement contactPermissionPopup;

    @iOSXCUITFindBy(id = "OK")
    private IOSElement allowContactPermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"“MobiKwik” Would Like to Access the Camera\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]")
    private IOSElement cameraPermissionPopup;

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

    public boolean isZipBottomSheetShown() throws InterruptedException {
        return Elements.isElementPresent(driver, zipBottomSheet);
    }

    public void clickAllowContactPermission() { Elements.click(driver, allowContactPermission,"Click OK on contact permission popup"); }

    public boolean isContactsPermissionPopupPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, contactPermissionPopup);
    }

    public boolean isCameraPermissionPopupPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, cameraPermissionPopup);
    }

    public void clickAllowCameraPermission() { Elements.click(driver, allowContactPermission,"Click OK on camera permission popup"); }

}
