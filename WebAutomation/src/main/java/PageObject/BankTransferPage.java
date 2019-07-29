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

    //input[@id='accName']

    //input[@id='accNum']

    //input[@id='ifsc']

    //add delay so that available balance can be updated greater than 0.



    //input[@id='amount']

    //span[text() ='Go']





    //span[text() ='Send Money']




    //input[@placeholder = 'Enter OTP']

    //span[text() ='Submit OTP']


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