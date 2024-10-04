package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class P2PPage {


    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All Services']")
    private IOSElement allServicesButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Wallet to Wallet']")
    private IOSElement p2pButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value ='Enter 10 digit mobile number']")
    private IOSElement mobileNoTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private IOSElement amountTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Now']")
    private IOSElement transferNowCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile number']/preceding::XCUIElementTypeStaticText[3]")
    private IOSElement successScreenStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile number']/preceding::XCUIElementTypeStaticText[2]")
    private IOSElement successScreenAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile number']/preceding::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenReceiverName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile number']/following::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenReceiverMobileNo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Mode']/following::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenPaymentMode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Activate Now']")
    private IOSElement successScreenZipCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile number']/preceding::XCUIElementTypeStaticText[5]")
    private IOSElement successScreenBackButton;

    // --------------------------------------------------


    public P2PPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickAllServices() throws InterruptedException {
        Elements.selectElement(driver, allServicesButton, "All Services");
        Thread.sleep(2000);
    }

    public void clickP2PButton() throws InterruptedException {
//        Elements.scrollToElement(driver,p2pButton, "checkP2PButton");
        Elements.selectElement(driver, p2pButton, "P2P Button");
    }

    public boolean checkP2PButton() throws InterruptedException {
       return Elements.isElementPresent(driver, p2pButton, "checkP2PButton");
    }

    public void enterMobileNo(String mobileNo) {
        Elements.enterToElement(driver, mobileNoTextBox, mobileNo, "Mobile No.");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, amountTextBox, amount, "Amount");
    }

    public void clickTransferNowCta() {
        Elements.selectElement(driver, transferNowCta, "Transfer Now Cta");
    }

    // Success Screen methods
    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, successScreenStatus, "Status");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, successScreenAmount, "Amount");
    }

    public String getReceiverName() throws InterruptedException {
        return Elements.getText(driver, successScreenReceiverName, "Receiver Name");
    }

    public String getReceiverMobileNumber() throws InterruptedException {
        return Elements.getText(driver, successScreenReceiverMobileNo, "Receiver Mobile No.");
    }

    public String getPaymentMode() throws InterruptedException {
        return Elements.getText(driver, successScreenPaymentMode, "Payment Mode");
    }

    public Boolean isZipWidgetPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, successScreenZipCta, "isZipWidgetPresent");
    }

    public void clickBackButton() {
        Elements.selectElement(driver, successScreenBackButton, "Select Back button");
    }


}
