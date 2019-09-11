package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;

public class UpiPage {

    AndroidDriver driver;


//    @AndroidFindBy(id = "com.mobikwik_new.debug:id/start_button")
@AndroidFindBy(id = "com.mobikwik_new:id/start_button")
    private AndroidElement cta_start_upi_setup;

    //As per RBI guidelines, below permissions are mandatory to enable UPI.
//    @AndroidFindBy(id = "com.mobikwik_new.debug:id/header_text")
    @AndroidFindBy(id = "com.mobikwik_new:id/header_text")
    private AndroidElement text_header_upi_setup;

    //UPI Home Page
//    @AndroidFindBy(id ="com.mobikwik_new.debug:id/qr_image")
    @AndroidFindBy(id ="com.mobikwik_new:id/qr_image")
    private AndroidElement qr_image;

//    @AndroidFindBy(id ="com.mobikwik_new.debug:id/upi_id_text")
@AndroidFindBy(id ="com.mobikwik_new:id/upi_id_text")
    private AndroidElement upi_id;

//    @AndroidFindBy(id ="com.mobikwik_new.debug:id/send_money_title")
@AndroidFindBy(id ="com.mobikwik_new:id/send_money_title")
    private AndroidElement cta_send_money;

    //Send Money Page
//    @AndroidFindBy (id ="com.mobikwik_new.debug:id/pay_to_account")
    @AndroidFindBy (id ="com.mobikwik_new:id/pay_to_account")
    private AndroidElement radio_button_to_bank_account;

//    @AndroidFindBy(id ="com.mobikwik_new.debug:id/edit_field")
@AndroidFindBy(id ="com.mobikwik_new:id/edit_field")
    private AndroidElement cta_enter_upi_id;

    //Send money via UPI Flow
//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/search_edittext")
    @AndroidFindBy(id= "com.mobikwik_new:id/search_edittext")
    private AndroidElement enter_upi_id_or_number;

//    @AndroidFindBy(id ="com.mobikwik_new.debug:id/confirm_button")
@AndroidFindBy(id ="com.mobikwik_new:id/confirm_button")
    private AndroidElement cta_confirm_upi;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/vpa")
@AndroidFindBy(id= "com.mobikwik_new:id/vpa")
    private AndroidElement result_upi_id;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/amount_field")
@AndroidFindBy(id= "com.mobikwik_new:id/amount_field")
    private AndroidElement enter_amount;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/messageEditText")
@AndroidFindBy(id= "com.mobikwik_new:id/messageEditText")
    private AndroidElement enter_message;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/view_transaction_limit")
@AndroidFindBy(id= "com.mobikwik_new:id/view_transaction_limit")
    private AndroidElement get_transaction_limit;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/touch_outside")
@AndroidFindBy(id= "com.mobikwik_new:id/touch_outside")
    private AndroidElement click_outside;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/cta")
@AndroidFindBy(id= "com.mobikwik_new:id/cta")
    private AndroidElement cta_confirm_payment;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/payment_success_msg")
@AndroidFindBy(id= "com.mobikwik_new:id/payment_success_msg")
    private AndroidElement payment_succes_message;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/amount")
@AndroidFindBy(id= "com.mobikwik_new:id/amount")
    private AndroidElement amount_paid;

//    @AndroidFindBy(id= "com.mobikwik_new.debug:id/base_icon_close")
@AndroidFindBy(id= "com.mobikwik_new:id/base_icon_close")
    private  AndroidElement click_on_cross;

//Send To Bank Flow

    @AndroidFindBy(id= "com.mobikwik_new:id/beneficiary_name")
    private AndroidElement enter_beneficiary_name;

    @AndroidFindBy(id= "com.mobikwik_new:id/account_number")
    private AndroidElement enter_account_number;

    @AndroidFindBy(id= "com.mobikwik_new:id/ifsc_code")
    private AndroidElement enter_ifsc;

    @AndroidFindBy(id= "com.mobikwik_new:id/continue_button")
    private AndroidElement cta_confirm_bank_details;


    //Request Money Flow
    @AndroidFindBy(id ="com.mobikwik_new:id/request_money_title")
    private AndroidElement cta_request_money;

    @AndroidFindBy(id= "com.mobikwik_new:id/cta")
    private AndroidElement cta_confirm_request;



    public UpiPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****UPI Page*****");
    }


    public void clickOnUpiSetupCta() throws InterruptedException {
        Element.selectElement(driver, cta_start_upi_setup, "Start UPI Setup");
    }

    public String verifySetupPopUp(String amount) throws InterruptedException {
        return Element.getText(driver,text_header_upi_setup, "Get Header Text");
    }

    public void clickSendMoney() throws InterruptedException {
        Element.selectElement(driver, cta_send_money, "Click on Send Money");
    }

    public void selectTransfertoBank() throws InterruptedException{
        Element.selectElement(driver, radio_button_to_bank_account, "Select radio button to Bank");
    }

    public void selectEnterUPI() throws InterruptedException{
        Element.selectElement(driver, cta_enter_upi_id, "Click on Enter UPI ID");
    }

    public void enterUpiId(String upiId) throws InterruptedException{
        Element.enterText(driver,enter_upi_id_or_number, upiId, "Enter UPI ID");
    }

    public void clickConfrimUpi() throws InterruptedException{
        Element.selectElement(driver, cta_confirm_upi, "Click on Confirm UPI");
    }

    public String getResultUpi() throws InterruptedException{
        return Element.getText(driver, result_upi_id, " Get UPI on search");
    }

    public void enterAmount(String amount) throws InterruptedException{
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void enterMessage(String message) throws InterruptedException{
        Element.enterText(driver, enter_message, message, "Enter Message");
    }


    public void clickOnConfirmPayment() throws InterruptedException{
        Element.selectElement(driver, cta_confirm_payment, "Click on Confirm Payment");
    }

    public String getPaymentSuccessMessage() throws InterruptedException{
        return Element.getText(driver, payment_succes_message, "Get Success Message");
    }

    public String getAmountPaid() throws InterruptedException{
        return Element.getText(driver, amount_paid, "Get Amount Paid");
    }

    public void returnToHomePage() throws InterruptedException{
        Element.selectElement(driver, click_on_cross, "Click on Cross");
    }

    public void enterBeneficiaryName(String beneficiaryName) throws InterruptedException{
        Element.enterText(driver, enter_beneficiary_name, beneficiaryName, "Enter Beneficiary Name");
    }

    public void enterAccountNumber(String accountNumber) throws InterruptedException{
        Element.enterText(driver, enter_account_number, accountNumber, "Enter Account Number");
    }

    public void enterIfsc(String ifsc) throws InterruptedException{
        Element.enterText(driver, enter_ifsc, ifsc, "Enter IFSC");
    }

    public void clickConfirmBankDetails() throws InterruptedException{
        Element.selectElement(driver, cta_confirm_bank_details, "Confrim Bank details");
    }

    public void clickRequestMoney() throws InterruptedException {
        Element.selectElement(driver, cta_request_money, "Click on Request Money");
    }

    public void clickOnConfirmRequest() throws InterruptedException{
        Element.selectElement(driver, cta_confirm_request, "Click on Confirm Request");
    }

}
