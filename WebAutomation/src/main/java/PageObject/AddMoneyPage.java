package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMoneyPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder = 'Enter Amount']")
    private WebElement textbox_amount;

    @FindBy(xpath = "//span[text() = 'Continue']")
    private WebElement cta_continue;

    @FindBy(xpath = "//div[@class='tbvtl ft15 aftrbrdr posrel']//a[1]")
    private WebElement tab_debit_cards;

    @FindBy(xpath = "//div[@class='tbvtl ft15 aftrbrdr posrel']//a[2]")
    private WebElement tab_credit_cards;

    @FindBy(xpath = "//a[text() = 'Net Banking']")
    private WebElement label_netbanking;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent ICICI']")
    public WebElement label_ICICI_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent HDF']")
    public WebElement label_HDFC_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent CITIBK']")
    public WebElement label_CITI_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent AXIS']")
    public WebElement label_AXIS_bank;

    @FindBy(xpath = "//mat-radio-button[@class = 'dpInBLockMid mat-radio-button mat-accent PNB']")
    public WebElement label_PNB_bank;

    @FindBy(xpath = "//span[text() = 'Proceed to Pay']")
    public WebElement button_proceed_to_pay;

    @FindBy(xpath = "//button[text() = ' New Debit / Credit Card']")
    public WebElement button_new_card;

    @FindBy(xpath = "//input[@id = 'cardNo']")
    public WebElement combobox_card_no;

    @FindBy(xpath = "//label[text() = 'Expiry Month']/following::input[@type = 'text'][2]")
    public WebElement combobox_expiry_month;

    @FindBy(xpath = "//label[text() = 'Expiry Year']/following::input[@type = 'text'][2]")
    public WebElement combobox_expiry_year;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    public WebElement textbox_cvv;

    @FindBy(xpath = "//span[contains(text(),'Proceed to Pay')]")
    public WebElement button_proceed_to_pay_2;

    @FindBy(xpath = "//label[text() = 'Expiry Month']/following::span[@class = 'ng-arrow-wrapper'][1]")
    private WebElement arrow_expiry_month;

    @FindBy(id="expiryMonth")
    private WebElement label_mm;

    @FindBy(id= "expiryYear")
    private WebElement label_yy;


    @FindBy(xpath = "//ng-select[@formcontrolname='expiryMonth']")
    private WebElement select_mm;

    @FindBy(xpath = "//label[text() = 'Expiry Year']/following::span[@class = 'ng-arrow-wrapper'][1]")
    private WebElement arrow_expiry_year;

    @FindBy(xpath = "//label[text() = 'e-Secure Password']")
    private WebElement link_e_secure_password;

    @FindBy(xpath = "//button[@id = 'continue']")
    private WebElement cta_bankpage_continue;




//Indusind Page handling

    @FindBy(xpath = "//img[@src= 'https://banking-assets.s3.ap-south-1.amazonaws.com/cipher/images/indusind-logo-credit.svg']")
    public WebElement indusInd_logo;

    @FindBy(xpath = "//input[@value = 'Submit']")
    private WebElement cta_bankpage_submit;

    @FindBy(xpath = "//input[@name = 'pin']")
    private WebElement textbox_bankpage_otp;

    //Payazapp Handling
    @FindBy(xpath = "//img[@alt= 'PayZapp secure PIN']")
    public WebElement payzapp_logo;

    @FindBy(xpath = "//input[@id= 'txtPasswordtoDisplay']")
    private WebElement textbox_payzapp_pin;

    @FindBy(xpath = "//input[@id= 'cmdSubmit']")
    private WebElement cta_payzapp_submit;





    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2 tribg']/following::div[1]/p")
    private WebElement label_trx_status;

    @FindBy(xpath = "//div[@class = 'col-md-6 ft15 tright fw600']")
    private WebElement label_total_amount_paid;

    @FindBy(xpath = "//span[text() = '4363 XXXX XXXX 4460']")
    private WebElement label_saved_card;

    @FindBy(xpath = "//span[text() = '4363 XXXX XXXX 4460']/following::input[1]")
    private WebElement taxtbos_saved_card_cvv;

    @FindBy(xpath = "//span[text() = '4363 XXXX XXXX 4460']/following::span[text() = 'Pay Now'][1]")
    private WebElement cta_pay_now;

    // Coupon codes

    @FindBy(xpath = "//a[text() = 'Apply a Coupon Code']")
    private WebElement label_apply_a_coupon;

    @FindBy(xpath = "//input[@formcontrolname='couponInput']")
    private WebElement textbox_coupon;

    @FindBy(xpath = "//button[text() = 'Apply']")
    private WebElement label_apply;

    @FindBy(xpath = "//p[@class = 'tgreen spbottom4 fw600']")
    private WebElement label_coupon_code_text;


    public AddMoneyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, textbox_amount);
        Config.logComment("*****On Insurance Page*****");
    }

    public void clickOnDebitOrCreditCards(String type) {
        if(type.equalsIgnoreCase("debit")) {
            Element.selectElement(driver, tab_debit_cards, "Debit cards");
        }else {
            Element.selectElement(driver, tab_credit_cards, "Credit cards");
        }
    }

    public void clickOnNetbanking() {
        Element.selectElement(driver, label_netbanking, "Netbanking");
    }

    public void clickOnCtaContinue() {
        Element.selectElement(driver, cta_continue, "Continue");
    }

    public void enterAmount(String amount) {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

    public void selectIcici() {
        Element.selectElement(driver, label_ICICI_bank, "ICICI");
    }

    public void selectHdfc() {
        Element.selectElement(driver, label_HDFC_bank, "HDFC");
    }

    public void selectPnb() {
        Element.selectElement(driver, label_PNB_bank, "PNB");
    }

    public void selectCiti() {
        Element.selectElement(driver, label_CITI_bank, "Citi");
    }

    public void selectAxis() {
        Element.selectElement(driver, label_AXIS_bank, "Axis");
    }

    public void clickOnProceedToPay() {
        Element.selectElement(driver, button_proceed_to_pay, "Proceed to Pay");
    }

    public void clickOnProceedToPay2() {
        Element.selectElement(driver, button_proceed_to_pay_2, "Proceed to Pay");
    }

    public void enterCardNo(String cardNo) {
        Element.enterText(driver, combobox_card_no, cardNo, "Card No");
    }

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2 tribg']")
    private WebElement tick_icon;


    public void clickOnNewCard() {
        Element.selectElement(driver, button_new_card, "New Card");
    }

    public void enterExpiryMonth() throws InterruptedException {
        Element.selectElement(driver, arrow_expiry_month, "Arrow Month");
        Thread.sleep(2000);
    }

    public void enterExpiryYear() {

        Element.selectElement(driver, arrow_expiry_year, "Arrow Year");
        Browser.wait(driver, 2);

    }

    public void enterCvv(String cvv) {
        Element.selectElement(driver, textbox_cvv,"Select CVV Box");
        Element.enterText(driver, textbox_cvv, cvv, "Cvv");
    }

    public void enterSavedCardCvv(String cvv) {
        Element.enterText(driver, taxtbos_saved_card_cvv, cvv, "Cvv");
    }

    public void clickOnBankPageSecurePassword() throws InterruptedException {
        Element.selectElement(driver, link_e_secure_password, "Bank Page Secure Password");
    }

    public void clickOnBankPageContinueButton() throws InterruptedException {
        Element.selectElement(driver, cta_bankpage_continue, "Bank Page Continue Button");
    }





    public String getTrxStatus() {
        return Element.getText(driver, label_trx_status, "TRX Status");
    }

    public String getTotalAmountPaid() {
        return Element.getText(driver, label_total_amount_paid, "Total Amount paid").replace("₹ ", "");
    }

    public void waitForTickIcon() {
        Element.waitForVisibility(driver, tick_icon, "Tick Icon");
    }

    public void clickOnSavedCard() {
        Element.selectElement(driver, label_saved_card, "Saved Card");
    }

    public void clickOnPayNow() {
        Element.selectElement(driver, cta_pay_now, "Pay Now");
    }

    public void clickOnApply() {
        Element.selectElement(driver, label_apply, "Apply");
    }

    public void clickOnApplyACouponCode() {
        Element.selectElement(driver, label_apply_a_coupon, "Apply a coupon");
    }

    public void enterCoupon(String coupon) throws InterruptedException {
        Element.enterText(driver, textbox_coupon, coupon, "Coupon Value");
    }

    public String getCouponCodeText() {
        return Element.getText(driver, label_coupon_code_text, "Coupon code text");
    }

    //Payzapp Methods


    public void enterPayzappPin(String password) throws InterruptedException {
        Element.enterText(driver, textbox_payzapp_pin, password, "Bank page Pin Entered-Payzapp");
    }

    public void clickOnPayzappPageSubmitButton() throws InterruptedException {
        Element.selectElement(driver, cta_payzapp_submit, "Bank Page Submit Button-Payzapp");
    }

    //Indusind Method

    public void clickOnIndusIndBankPageSubmitButton() throws InterruptedException {
        Element.selectElement(driver, cta_bankpage_submit, "Indusind Bank Page Submit Button");
    }

    public void enterIndusIndBankPageOtp(String otp) throws InterruptedException {
        Element.enterText(driver, textbox_bankpage_otp, otp, "Indusind Bank page Password");
    }

}








