package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Offers")
    private IOSElement offers;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"M\"]")
    private IOSElement floating_widgit;

    @iOSXCUITFindBy(id = "Recharge & Pay Bills")
    private IOSElement rechargeAndPayBills;

    @iOSXCUITFindBy(id = "Xtra")
    private IOSElement xtra_icon;

    @iOSXCUITFindBy(id = "Credit Card Payment")
    private IOSElement creditCardPayment;

    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isFloatingWidgitPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, floating_widgit);
    }

    public void closeFloatingWidgit() {
        Elements.click(driver, floating_widgit ,"Flowting Widgit");
    }

    public void clickOnOffers() {
        Elements.click(driver, offers,"Offers");
    }

    public void clicktXtra() throws InterruptedException {
        Elements.click(driver, xtra_icon, "Tap on xtra icon");
    }

    public void clickRechargeAndPayBills() {
        Elements.click(driver, rechargeAndPayBills,"Click on Recharge & Pay Bills");
    }

    public void clickCreditCardPayment() {
        Elements.click(driver, creditCardPayment,"Click on Credit card payment");
    }
}
