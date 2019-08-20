package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ImpsPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Via Wallet']")
    private IOSElement via_Wallet;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank']")
    private IOSElement wallet_to_bank;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = '167795709569']")
    private IOSElement bank;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/edt_txt_transfer_amount")
    private IOSElement amount_box;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text = 'Continue']")
    private IOSElement continueButton;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text = 'Confirm']")
    private IOSElement confirm;

    String success_text = "android.widget.TextView[@text = 'Money sent successfully']";

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/beneficiary_name")
    private IOSElement textbox_beneficiary_name;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/account_number")
    private IOSElement textbox_account_no;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/ifsc_code")
    private IOSElement textbox_ifsc;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/continue_button")
    private IOSElement cta_continue;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/base_title")
    private IOSElement label_success_message;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_cn_value")
    private IOSElement label_account_no;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_amount_value")
    private IOSElement label_amount;


    public ImpsPage(IOSDriver driver) throws IOException {

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

}
