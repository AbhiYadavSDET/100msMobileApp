package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class P2PPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'All Services']")
    private AndroidElement allServicesButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Wallet to Wallet transfer']")
    private AndroidElement p2pButton;

    @AndroidFindBy(xpath = "//*/android.widget.EditText[@text = 'Enter 10 digit mobile number']")
    private AndroidElement mobileNoTextBox;

    @AndroidFindBy(id = "edt_txt_transfer_amount")
    private AndroidElement amountTextBox;

    @AndroidFindBy(id = "btn_p2p_action")
    private AndroidElement transferNowCta;

    @AndroidFindBy(id = "status")
    private AndroidElement successScreenStatus;

    @AndroidFindBy(id = "amount")
    private AndroidElement successScreenAmount;

    @AndroidFindBy(id = "name")
    private AndroidElement successScreenReceiverName;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/advantages_text")
    private AndroidElement kyc_page_title;

    @AndroidFindBy(id = "Navigate up")
    private AndroidElement kyc_page_back_btn;

    @AndroidFindBy(id="com.mobikwik_new.debug:id/vertical_button_2")
    private AndroidElement no_thanks_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Mobile Number']/following-sibling::android.widget.TextView")

    private AndroidElement successScreenReceiverMobileNo;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Payment Mode']/following-sibling::android.widget.TextView")
    private AndroidElement successScreenPaymentMode;

    @AndroidFindBy(id = "cta")
    private AndroidElement successScreenZipCta;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement successScreenUpButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mobikwik_new.debug:id/text\" and @text=\"Scan any QR\"]")
    private AndroidElement scanAnyQrBtn;

    // --------------------------------------------------


    public P2PPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickAllServices() {
        Elements.selectElement(driver, allServicesButton, "All Services");
    }

    public void clickP2PButton() {
        Elements.selectElement(driver, p2pButton, "P2P Button");
    }

    public boolean checkP2PButton() throws InterruptedException {
       return Elements.isElementPresent(driver, p2pButton);
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

    public Boolean checkStatus() throws InterruptedException {
        return Elements.isElementPresent(driver, successScreenStatus);
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

    public String getZipCtaText() throws InterruptedException {
        return Elements.getText(driver, successScreenZipCta, "Zip Cta Text");
    }

    public void clickScanQrOptn() {
        Elements.selectElement(driver, scanAnyQrBtn, "Click on Scan Any QR");
    }

    public void clickBackBtnOnKycPage() {
        Elements.selectElement(driver, kyc_page_back_btn, "Click on back button on Complete KYC Page");
    }

    public Boolean checkKycPageOpened() throws InterruptedException {
        return Elements.isElementPresent(driver, kyc_page_title);
    }

    public void clickOnNoBtn() {
        Elements.selectElement(driver, no_thanks_cta, "Click on No,Thanks Btn");
    }



}
