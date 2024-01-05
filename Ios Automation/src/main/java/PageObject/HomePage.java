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

    @iOSXCUITFindBy(id = "All Services")
    private IOSElement allServices;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"M\"]")
    private IOSElement floating_widgit;

    @iOSXCUITFindBy(id = "Recharge & Pay Bills")
    private IOSElement rechargeAndPayBills;

    @iOSXCUITFindBy(id = "Xtra")
    private IOSElement xtra_icon;

    @iOSXCUITFindBy(id = "Pay Rent")
    private IOSElement payRent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private IOSElement profile;

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

    public void clickAllServices() {
        Elements.click(driver, allServices,"Click on All Services");
    }

    public void clickProfile() {
        Elements.click(driver, profile,"Click on Profile");
    }

    public void clickOnpayRent() { Elements.click(driver, payRent, "Click on Pay rent option");   }

    public IOSElement getPayRent() {
        return payRent;
    }

}
