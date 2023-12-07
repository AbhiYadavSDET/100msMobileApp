package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
public class P2PExtraPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Xtra")
    private IOSElement xtra_icon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get started\"]")
    private IOSElement cta_invest;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
    private IOSElement cta_click;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    private IOSElement portfolio_value;


    public P2PExtraPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectGetStarted() throws InterruptedException {
        Elements.click(driver, cta_invest, "Get Started cta");
    }

    public void selectSkipReminder() throws InterruptedException {
        Elements.click(driver, cta_click ,"Click on SKIP on Daily SIP Reminder");
    }

    public String getPortfolioValue() throws InterruptedException {
        return Elements.getText(driver, portfolio_value, "Get Portfolio Value");
    }

}
