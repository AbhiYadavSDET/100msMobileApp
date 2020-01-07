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

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/transfer_money_btn")
    private AndroidElement via_Wallet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank']")
    private AndroidElement wallet_to_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '167795709569']")
    private AndroidElement bank;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/edt_txt_transfer_amount")
    private AndroidElement amount_box;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Make payment']")
    private AndroidElement confirm;

    String success_text = "android.widget.TextView[@text = 'Money sent successfully']";

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/beneficiary_name")
    private AndroidElement textbox_beneficiary_name;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/account_number")
    private AndroidElement textbox_account_no;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/ifsc_code")
    private AndroidElement textbox_ifsc;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/continue_button")
    private AndroidElement cta_continue;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/base_title")
    private AndroidElement label_success_message;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/txt_cn_value")
    private AndroidElement label_account_no;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/txt_amount_value")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/continue_btn")
    private AndroidElement cta_submit_otp;


    public ImpsPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Imps Page*****");
    }

    public void clickOnViaWallet() throws InterruptedException {
        Element.selectElement(driver, via_Wallet, "Via Wallet on home page");
    }

    public void clickOnWalletToBank() throws InterruptedException {
        Element.selectElement(driver, wallet_to_bank, "Wallet to bank");
    }

    public void clickOnBank() throws InterruptedException {
        Element.selectElement(driver, bank, "Bank Account");
    }

    public void sendAmount(String amount) throws InterruptedException {
        Element.enterText(driver, amount_box, amount, "Transfer amount");
    }

    public void clickOnContinue() throws InterruptedException {
        Element.selectElement(driver, continueButton, "Bank Account");
    }

    public void clickOnConfirm() throws InterruptedException {
        Element.selectElement(driver, confirm, "Bank Account");
    }

    public void clickOnCtaContinue() throws InterruptedException {
        Element.selectElement(driver, cta_continue, "Cta Continue");
    }


    public By returnLocator() throws InterruptedException {
        return By.xpath(success_text);
    }

    public void enterBeneficiaryName(String name) {
        Element.enterText(driver, textbox_beneficiary_name, name, "Beneficiary Name");
    }

    public void enterAccountNo(String account) {
        Element.enterText(driver, textbox_account_no, account, "Account No");
    }

    public void enterIfsc(String ifsc) {
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

}
