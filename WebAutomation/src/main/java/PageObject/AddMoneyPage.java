package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
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

    @FindBy(xpath = "//a[text() = 'Debit / Credit Cards']")
    private WebElement label_debit_credit_cards;

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

    @FindBy(xpath = "//button[text() = 'New Debit / Credit Card']")
    public WebElement button_new_card;

    @FindBy(xpath = "//input[@id = 'cardNo']")
    public WebElement combobox_card_no;

    @FindBy(xpath = "//label[text() = 'Expiry Month']/following::input[@type = 'text'][2]")
    public WebElement combobox_expiry_month;

    @FindBy(xpath = "//label[text() = 'Expiry Year']/following::input[@type = 'text'][2]")
    public WebElement combobox_expiry_year;

    @FindBy(xpath = "//label[text() = 'CVV']/following::input[3]")
    public WebElement textbox_cvv;

    @FindBy(xpath = "//span[contains(text(),'Proceed to Pay')]")
    public WebElement button_proceed_to_pay_2;

    @FindBy(xpath = "//label[text() = 'Expiry Month']/following::span[@class = 'ng-arrow-wrapper'][1]")
    private WebElement arrow_expiry_month;

    @FindBy(xpath = "//span[text()='12']")
    private WebElement label_mm;

    @FindBy(xpath = "//span[text()='2022']")
    private WebElement label_yy;


    @FindBy(xpath = "//ng-select[@formcontrolname='expiryMonth']")
    private WebElement select_mm;

    @FindBy(xpath = "//label[text() = 'Expiry Year']/following::span[@class = 'ng-arrow-wrapper'][1]")
    private WebElement arrow_expiry_year;

    @FindBy(xpath = "//label[text() = 'e-Secure Password']")
    private WebElement link_e_secure_password;

    @FindBy(xpath = "//button[@id = 'continue']")
    private WebElement cta_bankpage_continue;

    @FindBy(xpath = "//input[@name = 'pin']")
    private WebElement textbox_bankpage_password;

    @FindBy(xpath = "//input[@value = 'Submit']")
    private WebElement cta_bankpage_submit;

    @FindBy(xpath = "//img[@id='banklogo']")
    public WebElement indusInd_logo;

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']/following::div[1]")
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

    public void clickOnDebitCards() {
        Element.selectElement(driver, label_debit_credit_cards, "Debit/Credit cards");
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

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']")
    private WebElement tick_icon;


    public void clickOnNewCard() {
        Element.selectElement(driver, button_new_card, "New Card");
    }

    public void enterExpiryMonth() {

        Element.selectElement(driver, arrow_expiry_month, "Arrow");
        Browser.wait(driver, 2);
        Element.selectElement(driver, label_mm, "Expiry Month");

    }

    public void enterExpiryYear() {

        Element.selectElement(driver, arrow_expiry_year, "Arrow");
        Browser.wait(driver, 2);
        Element.selectElement(driver, label_yy, "Expiry Year");
    }

    public void enterCvv(String cvv) {
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

    public void enterBankPagePassword(String password) throws InterruptedException {
        Element.enterText(driver, textbox_bankpage_password, password, "Bank page Password");
    }

    public void clickOnBankPageSubmitButton() throws InterruptedException {
        Element.selectElement(driver, cta_bankpage_submit, "Bank Page Submit Button");
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
}








