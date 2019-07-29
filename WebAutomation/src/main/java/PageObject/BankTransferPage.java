package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankTransferPage {

    WebDriver driver;


    @FindBy(xpath = "//h1[text()= 'Transfer Money To Bank']")
    private WebElement load_bank_transfer;

    @FindBy(xpath="//input[@id='accName']")
    private WebElement enter_account_name;

    @FindBy(xpath="//input[@id='accNum']")
    private WebElement enter_account_number;


    @FindBy(xpath="//input[@id='ifsc']")
    private WebElement enter_ifsc;

    @FindBy(xpath="//input[@id='amount']")
    private WebElement enter_amount;


    @FindBy(xpath = "//span[@class= 'tgreydark spleft6 dpInBLockMid']")
    private WebElement processing_fee;

    @FindBy(xpath="//span[text() ='Go']")
    private WebElement button_go;

    @FindBy(xpath="//span[text() ='Send Money']")
    private WebElement button_send_money;


    @FindBy(xpath="//input[@placeholder = 'Enter OTP']")
    private WebElement enter_otp;


    @FindBy(xpath="//span[text() ='Submit OTP']")
    private WebElement button_submit_otp;


//Success Page

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']")
    private WebElement tick_icon;

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']/following::div[1]")
    private WebElement label_trx_status;


    @FindBy(xpath = "//div[text() = 'Account Number']/following::div[1]")
    private  WebElement account_number;


    @FindBy(xpath = "//div[text() = 'Amount']/following::div[1]")
    private  WebElement amount_bank_transfer;


    public BankTransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, load_bank_transfer);
        Config.logComment("*****On Bank Transfer Page*****");
    }


    public void enterAccountName(String accountName){
        Element.enterText(driver, enter_account_name,accountName,"Enter Account Name");
    }

    public void enterAccountNumber(String accountNumber){
        Element.enterText(driver, enter_account_number,accountNumber,"Enter Account Number");
    }

    public void enterIfsc(String ifsc){
        Element.enterText(driver, enter_ifsc,ifsc,"Enter IFSC");
    }

    public void enterAmount(String amount){
        Element.enterText(driver, enter_amount,amount,"Enter amount to Transfer");
    }

    public void clickGo(){
        Element.selectElement(driver,button_go, "Submit Details");
    }

    public void clickSendMoney(){
        Element.selectElement(driver,button_send_money, "Confirm Sending Money");
    }

    public void enterOtp() {

        Element.selectElement(driver, enter_otp, "Enter OTP");
    }

    public void clickSubmitOtp() {
        Element.selectElement(driver, button_submit_otp, "Submit OTP");
    }

    //Success Page

    public void waitForTickIcon() {
        Element.waitForVisibility(driver, tick_icon, "Tick Icon");
    }

    public String getTrxStatus() {
        return Element.getText(driver, label_trx_status, "TRX Status");
    }

    public String getAmountPaid() {
        return Element.getText(driver, amount_bank_transfer, "Amount paid").replace("₹ ", "");
    }


}