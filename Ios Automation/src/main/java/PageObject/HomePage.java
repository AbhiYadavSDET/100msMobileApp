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

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Recharge & Bills\"])[1]")
    private IOSElement rechargeAndPayBills;

    @iOSXCUITFindBy(id = "Xtra")
    private IOSElement xtra_icon;

    @iOSXCUITFindBy(id = "Pay Rent")
    private IOSElement payRent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private IOSElement profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pay Now\"]")
     private IOSElement billReminderBottomSheet;

    @iOSXCUITFindBy(id = "UPI Transfer")
    private IOSElement upiTransfer;

    @iOSXCUITFindBy(id = "Scan any QR")
    private IOSElement scanQR;


    @iOSXCUITFindBy(id = "Wallet to Bank")
    private IOSElement imps;

    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isFloatingWidgitPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, floating_widgit, "isFloatingWidgitPresent");
    }

    public boolean isBillReminderPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, billReminderBottomSheet, "isBillReminderPresent");
    }




    public void closeFloatingWidgit() {
        Elements.click(driver, floating_widgit ,"Floating Widgit");
    }

    public void clickOnOffers() {
        Elements.click(driver, offers,"Offers");
    }

    public void clicktXtra() throws InterruptedException {
        Elements.click(driver, xtra_icon, "Tap on xtra icon");
    }

    public boolean isXtraIconPresent() throws InterruptedException {
       return Elements.isElementPresent(driver, xtra_icon, "isXtraIconPresent");
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
    public void clickUpiTransfer() {
        Elements.click(driver, upiTransfer,"Click on UPI Transfer");
    }

    public void clickOnScanQR() {
        Elements.click(driver, scanQR,"Click on Scan QR");
    }

    public void clickOnIMPS() { Elements.click(driver, imps, "Click on IMPS"); }

    public IOSElement getImps() {
        return imps;
    }

}
