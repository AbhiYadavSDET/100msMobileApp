package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import Utils.Element;

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

    @AndroidFindBy(id = "title")
    private AndroidElement label_success_message;


    @AndroidFindBy(id = "right")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "continue_btn")
    private AndroidElement cta_submit_otp;

    @AndroidFindBy(id="convenience_fee_amount")
    private AndroidElement imps_fee;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'XXXXXXXX2680']")
    private AndroidElement saved_Bank_account;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = '9414065033@ikwik']")
    private AndroidElement saved_vpa;

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

    public String getSuccessSuccessPageAmount() {
        return Element.getText(driver, label_amount, "Success Page | Amount");
    }

    public String getConvFee() throws InterruptedException{
        return Element.getText(driver, imps_fee, "Get IMPS Fee");
    }


    public void selectFromRecentTransfers(String input) {
        if(input.equalsIgnoreCase("vpa")){
            Element.selectElement(driver, saved_vpa, "Select Saved Vpa from Recent Transfers");
        }else{
            Element.selectElement(driver, saved_Bank_account, "Select Saved Bank account from Recent Transfers");
        }
    }

}
