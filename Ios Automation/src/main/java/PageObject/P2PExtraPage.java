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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Withdraw\"]")
    private IOSElement withdraw_cta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Only one Withdrawal Request at a time\"]")
    private IOSElement one_time_withdraw_bottomsheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Got it\"]")
    private IOSElement gotIt_cta;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[1]")
    private IOSElement amountField;

    @iOSXCUITFindBy(id = "Withdraw")
    private IOSElement withdraw_btn;



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

    public boolean checkSkipReminder() throws InterruptedException {
       return Elements.isElementPresent(driver, cta_click);
    }

    public String getPortfolioValue() throws InterruptedException {
        return Elements.getText(driver, portfolio_value, "Get Portfolio Value");
    }

    public void clickWithdrawCta() throws InterruptedException {
        Elements.click(driver, withdraw_cta, "Click on Withdraw FLEXI");
    }

    public boolean checkOneTimeWithdrawBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, one_time_withdraw_bottomsheet);
    }

    public void clickGotItCta() throws InterruptedException {
        Elements.click(driver, gotIt_cta, "Click on Got It Cta");
    }

    public void enterAmount(String amount) { Elements.enterToElement(driver, amountField, amount , "Enter amount : 1");   }

    public void clickWithdrawBtn() throws InterruptedException {
        Elements.click(driver, withdraw_btn, "Click on Withdraw Button");
    }




}
