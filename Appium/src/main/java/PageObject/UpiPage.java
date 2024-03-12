package PageObject;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import Utils.Element;
import Utils.Elements;

import java.io.IOException;

public class UpiPage {

    AndroidDriver driver;



    @AndroidFindBy(id = "search_upi")
    private AndroidElement cta_enter_upi_id;

    @AndroidFindBy(id = "search_upi")
    private AndroidElement enter_upi_id_or_number;

    @AndroidFindBy(id = "send_money")
    private AndroidElement result_upi_id;

    @AndroidFindBy(id="transfer_to")
    private AndroidElement transfer_to;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "messageEditText")
    private AndroidElement enter_message;


    @AndroidFindBy(id = "setup_message")
    private AndroidElement setup_message;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_confirm_payment;


    @AndroidFindBy(id = "status")
    private AndroidElement payment_succes_message;


    @AndroidFindBy(id = "amount")
    private AndroidElement amount_paid;

    @AndroidFindBy(id = "name")
    private AndroidElement receiver_name;

    @AndroidFindBy(id = "transfer_bank_account")
    private AndroidElement radio_button_to_bank_account;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private AndroidElement enter_beneficiary_name;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private AndroidElement enter_account_number;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private AndroidElement enter_ifsc;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement cta_confirm_bank_details;

    @AndroidFindBy(id = "back_icon")
    private AndroidElement click_on_cross;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Additional verification required']")
    private AndroidElement TwoFA_page_displayed;

    @AndroidFindBy(id="continue_button")
    private AndroidElement TwoFA_page_cta;

    @AndroidFindBy(id = "continue_button")
    private AndroidElement cta_start_upi_setup;











////////////////////////////////



    @AndroidFindBy(id = "header_text")
    private AndroidElement text_header_upi_setup;

    @AndroidFindBy(id = "qr_image")
    private AndroidElement qr_image;

    @AndroidFindBy(id = "upi_id_text")
    private AndroidElement upi_id;

    @AndroidFindBy(id = "send_money_title")
    private AndroidElement cta_send_money;
    @AndroidFindBy(id = "confirm_button")
    private AndroidElement cta_confirm_upi;

    @AndroidFindBy(id = "view_transaction_limit")
    private AndroidElement get_transaction_limit;

    @AndroidFindBy(id = "touch_outside")
    private AndroidElement click_outside;

    //Request Money Flow
    @AndroidFindBy(id = "request_money_title")
    private AndroidElement cta_request_money;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_confirm_request;


    //Check Balance Flow
    @AndroidFindBy(id = "back_button")
    private AndroidElement back_button;

    //Setup UPI

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement enter_bank_name;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_bank_from_list;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Select the phone number linked with your Kotak Mahindra Bank Account. An SMS will be triggered from the number to verify your bank account.']")
    private AndroidElement sim_select_view;

    @AndroidFindBy(id = "sim1_button")
    private AndroidElement select_sim_1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Create New VPA']")
    private AndroidElement header_create_vpa;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement enter_vpa;

    @AndroidFindBy(id = "submit_button")
    private AndroidElement submit_vpa;

    @AndroidFindBy(id = "upi_id_text")
    private AndroidElement get_upi_id;

    @AndroidFindBy(id = "back_to_home")
    private AndroidElement upi_setup_success_back_to_home_cta;






    public UpiPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****UPI Page*****");
    }


    public void selectEnterUPI() throws InterruptedException {
        Element.selectElement(driver, cta_enter_upi_id, "Click on Enter UPI ID");
    }

    public void enterUpiId(String upiId) throws InterruptedException {
        Element.enterText(driver, enter_upi_id_or_number, upiId, "Enter UPI ID");
    }

    public void selectResultUpi() throws InterruptedException {
        Element.waitForVisibility(driver, result_upi_id);
         Element.selectElement(driver, result_upi_id, "Select UPI in search");
    }

    public String getAmountPageTransferTo() throws InterruptedException {
        return Element.getText(driver,transfer_to , "Get Amount Page Transfer To");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void enterMessage(String message) throws InterruptedException {
        Element.enterText(driver, enter_message, message, "Enter Message");
    }

    public Boolean isSetupMessageDisplayed() throws InterruptedException {
        return Elements.isElementPresent(driver,setup_message);
    }

    public void clickOnConfirmPayment() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_payment, "Click on Confirm Payment");
    }

    public Boolean is2FAPageDisplayed() throws InterruptedException {
        return Elements.isElementPresent(driver,TwoFA_page_displayed);
    }

    public void clickOnContinue2FAPage() throws InterruptedException {
        Element.selectElement(driver, TwoFA_page_cta, "Click on Continue on 2FA Page");
    }

    public String getPaymentSuccessMessage() throws InterruptedException {
        return Element.getText(driver, payment_succes_message, "Get Success Message");
    }

    public String getAmountPaid() throws InterruptedException {
        return Element.getText(driver, amount_paid, "Get Amount Paid");
    }

    public String getReceiverName() throws InterruptedException {
        return Element.getText(driver, receiver_name, "Get Receiver Name");
    }

    public void selectTransfertoBank() throws InterruptedException {
        Element.selectElement(driver, radio_button_to_bank_account, "Select radio button to Bank");
    }

    public void enterBeneficiaryName(String beneficiaryName) throws InterruptedException {
        Element.waitForVisibility(driver,enter_beneficiary_name);
        Element.enterText(driver, enter_beneficiary_name, beneficiaryName, "Enter Beneficiary Name");
    }

    public void enterAccountNumber(String accountNumber) throws InterruptedException {
        Element.enterText(driver, enter_account_number, accountNumber, "Enter Account Number");
    }

    public void enterIfsc(String ifsc) throws InterruptedException {
        Element.enterText(driver, enter_ifsc, ifsc, "Enter IFSC");
    }

    public void clickConfirmBankDetails() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_bank_details, "Confrim Bank details");
    }

    public void returnToHomePage() throws InterruptedException {
        Element.selectElement(driver, click_on_cross, "Click on Cross");
    }

    public void clickOnUpiSetupCta() throws InterruptedException {
        Element.selectElement(driver, cta_start_upi_setup, "Permission Consent Page Continue CTA");
    }










    //////////////////////////////////////////////



    public String verifySetupPopUp(String amount) throws InterruptedException {
        return Element.getText(driver, text_header_upi_setup, "Get Header Text");
    }

    public void clickSendMoney() throws InterruptedException {
        Element.selectElement(driver, cta_send_money, "Click on Send Money");
    }

    public void clickConfrimUpi() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_upi, "Click on Confirm UPI");
    }



    public void clickRequestMoney() throws InterruptedException {
        Element.selectElement(driver, cta_request_money, "Click on Request Money");
    }

    public void clickOnConfirmRequest() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_request, "Click on Confirm Request");
    }

    public HomePage clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, "Click on Back Button");
        return new HomePage(driver);
    }

    public void enterBankName(String bankName) throws InterruptedException {
        Element.enterText(driver, enter_bank_name, bankName, "Enter Bank Name");
    }

    public void selectBankFromList() throws InterruptedException {
        Element.selectElement(driver, select_bank_from_list, "Select Bank from List");
    }

    public void selectSim1() throws InterruptedException {
        Element.selectElement(driver, select_sim_1, "Select Sim 1");
    }

    public void enterVpa(String enterVpa) throws InterruptedException {
        Element.enterText(driver, enter_vpa, enterVpa, "Enter Random VPA");
    }

    public void submitVpa() throws InterruptedException {
        Element.selectElement(driver, submit_vpa, "Submit VPA");
    }

    public String upiIdGenerated() throws InterruptedException {
        return Element.getText(driver, get_upi_id, "Get Upi Id generated");
    }

    public HomePage clickBackToHomeFromSetupSuccess() throws InterruptedException {
        Element.selectElement(driver, upi_setup_success_back_to_home_cta, "Click Back tom Home");
        return new HomePage(driver);
    }




}
