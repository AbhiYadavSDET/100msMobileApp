package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"History\"]")
    private IOSElement history;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]")
//    private IOSElement historyDescription;
//
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[5]")
//    private IOSElement historyAmount;
//
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[3]")
//    private IOSElement historyStatus;

    public HistoryPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickHistory(){
        Elements.click(driver, history,"Click on history");
    }

//    public boolean isHistoryDesciptionPresent() throws InterruptedException {
//        return Elements.isElementPresent(driver, historyDescription);
//    }
//
//    public String getDescription() throws InterruptedException {
//        return Elements.getText(driver, historyDescription, "History Description");
//    }
//
//    public String getAmount() throws InterruptedException {
//        return Elements.getText(driver, historyAmount, "History Amount");
//    }
//
//    public String getStatus() throws InterruptedException {
//        return Elements.getText(driver, historyStatus, "History Status");
//    }
}
