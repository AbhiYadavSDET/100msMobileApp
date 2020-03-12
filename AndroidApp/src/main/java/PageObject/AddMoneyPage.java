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

public class AddMoneyPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement textbox_amount;

    @AndroidFindBy(id = "btnContinue")
    private AndroidElement button_continue;

    @AndroidFindBy(xpath = "//*[@text = 'Select Payment Mode']")
    public AndroidElement label_select_payment_mode;

    @AndroidFindBy(xpath = "//*[@text = 'Net Banking']")
    public AndroidElement label_netbanking;

    @AndroidFindBy(xpath = "//*[@text = 'New Debit/Credit Card']")
    public AndroidElement label_new_debit_credit_card;

    @AndroidFindBy(xpath = "//*[@text = 'Debit or Credit Card']")
    public AndroidElement label_debit_credit_card;

    @AndroidFindBy(id = "mkab_title")
    public AndroidElement label_make_payment;

    @AndroidFindBy(id = "horizontal_button_2")
    public AndroidElement button_yes;

    @AndroidFindBy(id = "horizontal_button_1")
    public AndroidElement button_no;

    //Enter card details
    @AndroidFindBy(xpath = "//*[@text = 'Debit or Credit Card']/following::android.widget.EditText[1]")
    public AndroidElement textbox_card_no_new;
    //Enter card details
    @AndroidFindBy(xpath = "//*[@text = 'Card Number']/following::android.widget.EditText[1]")
    public AndroidElement textbox_card_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Card Expiry']/following::android.widget.EditText[1]")
    private AndroidElement textbox_expiry;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]")
    private AndroidElement textbox_cvv;

    @AndroidFindBy(id = "btn_add_money")
    public AndroidElement cta_pay_now;
    @AndroidFindBy(id = "new_card_btn_pay")
    public AndroidElement cta_pay_now_new;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc = 'e-Secure Password']")
    private AndroidElement link_e_secure_password_1;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text = 'e-Secure Password']")
    private AndroidElement link_e_secure_password_2;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private AndroidElement cta_bankpage_continue;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private AndroidElement textbox_bankpage_password;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private AndroidElement cta_bankpage_submit;

    @AndroidFindBy(id = "base_title")
    private AndroidElement label_success_page_status;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@index ='0']")
    private AndroidElement label_success_page_text;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@index ='1']")
    private AndroidElement label_success_page_wallet_balance;

    //Add Money Via UPI

    @AndroidFindBy(id = "upi_logo")
    private AndroidElement select_upi_for_add_money;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_upi_bank;

    @AndroidFindBy(id = "start_button")
    private AndroidElement restore_upi;


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
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Debit or Credit Card']"))) {
            Element.selectElement(driver, label_debit_credit_card, "Debit/Credit card");
        } else {
            Element.selectElement(driver, label_new_debit_credit_card, "New Debit or Credit card");
        }
    }

    public void clickOnDebitCreditCard() throws InterruptedException {
        Element.selectElement(driver, label_debit_credit_card, "Debit/Credit card");
    }


    public void clickOnYesButton() throws InterruptedException {
        Element.selectElement(driver, button_yes, "Yes");
    }

    public void clickOnNoButton() throws InterruptedException {
        Element.selectElement(driver, button_no, "No");
    }

    public void enterCardNo(String cardNo) throws InterruptedException {
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Debit or Credit Card']"))) {
            Element.enterText(driver, textbox_card_no_new, cardNo, "Card No");
        } else {
            Element.enterText(driver, textbox_card_no, cardNo, "Card No");
        }
    }

    public void enterExpiry(String expiry) throws InterruptedException {
        Element.enterText(driver, textbox_expiry, expiry, "Expiry");
    }

    public void enterCvv(String cvv) throws InterruptedException {
        Element.enterText(driver, textbox_cvv, cvv, "CVV");
    }

    public void clickOnPayNow() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("new_card_btn_pay"))) {
            Element.selectElement(driver, cta_pay_now_new, "Pay Now Button");

        } else {
            Element.selectElement(driver, cta_pay_now, "Pay Now Button");

        }
    }

    public void clickOnBankPageSecurePassword() throws InterruptedException {
        if (Element.isElementPresent(driver, By.xpath("//android.widget.RadioButton[@text = 'e-Secure Password']"))) {
            Element.selectElement(driver, link_e_secure_password_2, "Bank Page Secure Password");
        } else {
            Element.selectElement(driver, link_e_secure_password_1, "Bank Page Secure Password");
        }
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

    public String getSuccessPageStatus() throws InterruptedException {
        return Element.getText(driver, label_success_page_status, "Success page status");
    }

    public String getSuccessPageText() throws InterruptedException {
        return Element.getText(driver, label_success_page_text, "Success page text");
    }

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

}
