package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;
//import utils.Element;

import java.io.IOException;

public class AddMoneyPage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter Amount']")
    private AndroidElement textbox_amount;

    @AndroidFindBy(id = "btnContinue")
    private AndroidElement button_continue;

    @AndroidFindBy(xpath = "//*[@text = 'Select Payment Mode']")
    public AndroidElement label_select_payment_mode;

    @AndroidFindBy(xpath = "//*[@text = 'Net Banking']")
    public AndroidElement label_netbanking;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '+ Add New Debit card']")
    public AndroidElement label_new_debit_card;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '+ Add New Credit card']")
    public AndroidElement label_new_credit_card;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '+ Add New Debit / Credit card']")
    public AndroidElement label_new_debit_credit_card;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Enter your 16 digit card number']")
    public AndroidElement label_new_user_debit_credit_card;


    @AndroidFindBy(id = "mkab_title")
    public AndroidElement label_make_payment;

    @AndroidFindBy(id = "horizontal_button_2")
    public AndroidElement button_yes;

    @AndroidFindBy(id = "horizontal_button_1")
    public AndroidElement button_no;

    //Enter card details
    @AndroidFindBy(id = "editText_card_number")
    public AndroidElement textbox_card_no;

    @AndroidFindBy(id = "editText_saved_card_expiry")
    private AndroidElement text_box_expiry;

    @AndroidFindBy(id = "editText_cvv")
    private AndroidElement text_box_cvv;

    @AndroidFindBy(id = "btn_add_money")
    public AndroidElement cta_pay_now_new;

    @AndroidFindBy(id = "txtPasswordtoDisplay")
    private AndroidElement textbox_bankpage_password;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'Submit']")
    private AndroidElement cta_bankpage_submit;

    @AndroidFindBy(id = "status")
    private AndroidElement label_success_page_status_1;

    @AndroidFindBy(id = "amount")
    private AndroidElement label_success_page_status_2;

    @AndroidFindBy(id = "name")
    private AndroidElement label_success_page_status_3;

//    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@index ='0']")
//    private AndroidElement label_success_page_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='right'][1]")
//    @AndroidFindBy(xpath = "*/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private AndroidElement label_success_page_wallet_balance;
    //Add Money Via UPI

    @AndroidFindBy(id = "upi_logo")
    private AndroidElement select_upi_for_add_money;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_upi_bank;

    @AndroidFindBy(id = "start_button")
    private AndroidElement restore_upi;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'More payment options']")
    private AndroidElement more_payment_options;


    public AddMoneyPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Add Money Page*****");
    }


    public void clickOnAmountTextBox() throws InterruptedException {
        Element.selectElement(driver, textbox_amount, "Amount Text Box");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_amount, amount, "Amount");
    }

    public void clickOnContinueButton() throws InterruptedException {
        Element.selectElement(driver, button_continue, "Continue Button");
    }

    public void clickOnNetbanking() throws InterruptedException {
        Element.selectElement(driver, label_netbanking, "Netbanking");
    }

    public void clickOnNewDebitCreditCard() throws InterruptedException {
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = '+ Add New Debit card']"))){
            Element.selectElement(driver, label_new_debit_card, "Select New Debit Card Flow");
        } else {
            Element.selectElement(driver, label_new_debit_credit_card, "Select New Debit / Credit Card Flow");
        }
    }

    public void clickOnNoCardsDebitCreditCardFlow() throws InterruptedException {
        Element.selectElement(driver, label_new_user_debit_credit_card, "No Saved Cards user , New Debit/Credit card flow");
    }

    public void enterCardDetails(String cardNo, String expiryMonthYear, String cvv) throws InterruptedException {

        enterCardNo(cardNo);
        enterExpiry(expiryMonthYear);
        enterCvv(cvv);
    }

//    public void clickOnSavedCardsFlow() throws InterruptedException {
//        Element.selectElement(driver, label_new_user_debit_credit_card, " Saved Cards user , Saved card flow");
//    }


    public void clickOnYesButton() throws InterruptedException {
        Element.selectElement(driver, button_yes, "Yes");
    }

    public void clickOnNoButton() throws InterruptedException {
        Element.selectElement(driver, button_no, "No");
    }

    public void enterCardNo(String cardNo) throws InterruptedException {

            Element.enterText(driver, textbox_card_no, cardNo, "New Card No Flow | Enter Card Number");
    }

    public void enterExpiry(String expiry) throws InterruptedException {

        Element.enterText(driver, text_box_expiry, expiry, "New Card No Flow | Enter Card Expiry");

    }

    public void enterCvv(String cvv) throws InterruptedException {

        Element.enterText(driver, text_box_cvv, cvv, "New Card No Flow | Enter Card CVV");

    }

    public void clickOnPayNow() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("btn_add_money"))) {
            Element.selectElement(driver, cta_pay_now_new, "Pay Now Button");
        }
    }

    public void clickOnBankPageSecurePassword() throws InterruptedException {
        Element.waitForVisibility(driver, By.xpath("//android.widget.Button[@text= 'Submit']"));
//        Thread.sleep(4000);
        Log.info("Bank Page Loaded");

        if (Element.isElementPresent(driver, By.id("txtPasswordtoDisplay"))) {
            Log.info("E-secure password option 1");
            Element.selectElement(driver, textbox_bankpage_password, "Select Bank Page Secure Pin Field");

        }
    }

    public void enterBankPagePassword(String pin) throws InterruptedException {
        Element.enterText(driver, textbox_bankpage_password, pin, "Enter Txn Pin");
    }

    public void clickOnBankPageSubmitButton() throws InterruptedException {
        Element.selectElement(driver, cta_bankpage_submit, "Bank Page Submit Button");
    }

    public String getSuccessPageStatus() throws InterruptedException {
        String a=Element.getText(driver, label_success_page_status_1, "Success page status Part 1");
        String b=Element.getText(driver, label_success_page_status_2, "Success page status Part 2");
        String c=Element.getText(driver, label_success_page_status_3, "Success page status Part 3");

        String output=a+" "+b+" "+c;
        return output;
    }

//    public String getSuccessPageText() throws InterruptedException {
//        return Element.getText(driver, label_success_page_text, "Success page text");
//    }

    public String getSuccessPageWalletBalance() throws InterruptedException {
        return Element.getText(driver, label_success_page_wallet_balance, "Success page Wallet Balance");
    }

    public void chooseUpiOption() throws InterruptedException {
        Element.selectElement(driver, select_upi_for_add_money, "Choose Upi for Add Money");
    }

    public void restoreUpi() throws InterruptedException {
        Element.selectElement(driver, restore_upi, " Restore Upi Account");
    }


    public void chooseUpiBank() throws InterruptedException {
        Element.selectElement(driver, select_upi_bank, "Choose Upi for Add Money");
    }

    public void chooseMoreOptions() throws InterruptedException {
        Element.selectElement(driver, more_payment_options, "Choose More Payment Options for Add Money in Recommandation Bottom Sheet");
    }




}
