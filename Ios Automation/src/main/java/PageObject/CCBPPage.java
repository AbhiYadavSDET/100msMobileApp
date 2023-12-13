package PageObject;

import Utils.Elements;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

public class CCBPPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]")
    private IOSElement ccbpHomeBottomSheet;


    public CCBPPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isCCBPHomeBottomSheetShown() throws InterruptedException {
        return Elements.isElementPresent(driver, ccbpHomeBottomSheet);
    }

}
