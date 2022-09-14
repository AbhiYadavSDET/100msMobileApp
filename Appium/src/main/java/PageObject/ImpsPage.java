package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class ImpsPage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank']")
    private AndroidElement wallet_to_bank;

    @AndroidFindBy(id="btn_new_transfer")
    private AndroidElement new_transfer_cta;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement amount_box;

    @AndroidFindBy(id = "btn_pin_submit")
    private AndroidElement continueButtonArrow;

    @AndroidFindBy(id = "cta")
    private AndroidElement pay_amount_cta;

    String success_text = "android.widget.TextView[@text = 'Money sent successfully']";

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Beneficiary Name']")
    private AndroidElement textbox_beneficiary_name;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Account Number']")
    private AndroidElement textbox_account_no;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'IFSC Code']")
    private AndroidElement textbox_ifsc;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement cta_continue;

    @AndroidFindBy(id = "base_title")
    private AndroidElement label_success_message;

    @AndroidFindBy(id = "upi_id")
    private AndroidElement label_account_no;

    @AndroidFindBy(id = "amount")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "continue_btn")
    private AndroidElement cta_submit_otp;

    //Lakshay's Entries-

    @AndroidFindBy(id = "radio_upi")
    private AndroidElement upi_radio_button;

    @AndroidFindBy(id="edit_text")
    private AndroidElement virtual_private_address;

    @AndroidFindBy(id = "btn_new_transfer")
    private AndroidElement new_transfer_button;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement upi_continue_button;

    @AndroidFindBy(id = "btn_pin_5")
    private AndroidElement button_5;

    @AndroidFindBy(id = "btn_pin_0")
    private AndroidElement button_0;

    @AndroidFindBy(id = "btn_pin_submit")
    private AndroidElement amount_submit_button;

    @AndroidFindBy(id = "cta")
    private AndroidElement continue_cta;

    @AndroidFindBy(id = "upi_id")
    private AndroidElement label_vpa;

    @AndroidFindBy(id = "iv_close")
    private AndroidElement referral_close;

    @AndroidFindBy(id = "base_icon_back")
    private AndroidElement back_button;

    @AndroidFindBy(id="convenience_fee_amount")
    private AndroidElement imps_fee;

    public ImpsPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Imps Page*****");
    }


    public void clickOnWalletToBank() throws InterruptedException {
        Element.selectElement(driver, wallet_to_bank, "Wallet to bank cta on Home page");
    }

    public void clickOnTransfertoANewAccount() throws InterruptedException {
        Element.selectElement(driver, new_transfer_cta, "Wallet to bank cta on Home page");
    }

    public void sendAmount(String amount) throws InterruptedException {
        Element.enterText(driver, amount_box, amount, "Transfer amount");
    }

    public void clickOnContinueArrow() throws InterruptedException {
        Element.selectElement(driver, continueButtonArrow, "Continue Arrow Tap");
    }

    public void clickOnConfirm() throws InterruptedException {
        Element.selectElement(driver, pay_amount_cta, "Pay amount cta");
    }

    public String getPayAmountCtaText() throws InterruptedException {
        return Element.getText(driver, pay_amount_cta, "Pay amount cta Text");
    }




    public void clickOnCtaContinue() throws InterruptedException {
        Element.selectElement(driver, cta_continue, "Cta Continue");
    }


    public By returnLocator() throws InterruptedException {
        return By.xpath(success_text);
    }

    public void enterBeneficiaryName(String name) {
        Element.selectElement(driver, textbox_beneficiary_name, "Beneficiary Name");
        Element.enterText(driver, textbox_beneficiary_name, name, "Beneficiary Name");
    }

    public void enterAccountNo(String account) {
        Element.selectElement(driver, textbox_account_no, "Account No");
        Element.enterText(driver, textbox_account_no, account, "Account No");
    }

    public void enterIfsc(String ifsc) {
        Element.selectElement(driver, textbox_ifsc, "Account No");
        Element.enterText(driver, textbox_ifsc, ifsc, "IFSC");
    }

    public String getSuccessMessage() {
        return Element.getText(driver, label_success_message, "Success Message");
    }

    public String getSuccessPageAccountNo() {
        return Element.getText(driver, label_account_no, "Success Page | Account No");
    }

    public String getSuccessSuccessPageAmount() {
        return Element.getText(driver, label_amount, "Success Page | Amount");
    }

    public void clickOnSubmitOtp() throws InterruptedException {
        Element.selectElement(driver, cta_submit_otp, "Submit OTP");
    }
    //Lakshay's Entries-

    public void selectUPIRadioButton() throws InterruptedException{
        Element.selectElement(driver, upi_radio_button, "UPI Radio Button");
    }

    public void enterVPA(String vpa)  {
        //Element.selectElement(driver, virtual_private_address, "UPI ID");
        Element.enterText(driver, virtual_private_address, vpa, "UPI ID");
    }

    public void clickTransferToNewAccount() throws InterruptedException {
        Element.selectElement(driver, new_transfer_button, "Transfer to New Account");
    }

    public void clickUPIContinueButton() throws InterruptedException
    {
        Element.selectElement(driver, upi_continue_button, "Continue Button of UPI");
    }

    public void clickButton5() throws InterruptedException{
        Element.selectElement(driver, button_5, "Button 5 on Screen");
    }

    public void clickButton0() throws InterruptedException{
        Element.selectElement(driver, button_0, "Button 0 on Screen");
    }

    public void clickAmountSubmitButton() throws InterruptedException{
        Element.selectElement(driver, amount_submit_button, "Amount Submit Button");
    }

    public void clickPay() throws InterruptedException{
        Element.selectElement(driver, continue_cta, "Pay Button");
    }

    public String getSuccessPageVPA() {
        return Element.getText(driver, label_vpa, "Success Page | VPA");
    }

    public void closeReferralDialogBox() throws InterruptedException{
        Element.selectElement(driver, referral_close, "Close Referral Dialog Box");
    }

    public void clickBackButton() throws InterruptedException{
        Element.selectElement(driver, back_button, "Click on Back Button");
    }
    public String getConvFee() throws InterruptedException{
        return Element.getText(driver, imps_fee, "Get IMPS Fee");
    }


}
