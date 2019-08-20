package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AddMoneyPage {

    IOSDriver driver;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add Money']/following::XCUIElementTypeTextField")
    private IOSElement textbox_amount;

    @iOSXCUITFindBy(id = "Continue")
    private IOSElement button_continue;

    @iOSXCUITFindBy(id = "Select Payment Mode")
    public IOSElement label_select_payment_mode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Net Banking']/following::XCUIElementTypeButton[1]")
    public IOSElement label_netbanking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='New Debit/Credit Cards']/following::XCUIElementTypeButton[1]")
    public IOSElement label_new_debit_credit_card;

    @iOSXCUITFindBy(xpath = "//*[@text = 'Debit or Credit Card']")
    public IOSElement label_debit_credit_card;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Payment Gateway']")
    public IOSElement label_make_payment;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/horizontal_button_2")
    public IOSElement button_yes;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/horizontal_button_1")
    public IOSElement button_no;

    //Enter card details
    @iOSXCUITFindBy(xpath = "//*[@text = 'Debit or Credit Card']/following::android.widget.EditText[1]")
    public IOSElement textbox_card_no_new;
    //Enter card details
    @iOSXCUITFindBy(xpath = "//*[@text = 'Card Number']/following::android.widget.EditText[1]")
    public IOSElement textbox_card_no;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Card Expiry']/following::android.widget.EditText[1]")
    private IOSElement textbox_expiry;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]")
    private IOSElement textbox_cvv;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_add_money")
    public IOSElement cta_pay_now;
    @iOSXCUITFindBy(id = "com.mobikwik_new:id/new_card_btn_pay")
    public IOSElement cta_pay_now_new;

    @iOSXCUITFindBy(xpath = "//android.widget.RadioButton[@content-desc = 'e-Secure Password']")
    private IOSElement link_e_secure_password_1;

    @iOSXCUITFindBy(xpath = "//android.widget.RadioButton[@text = 'e-Secure Password']")
    private IOSElement link_e_secure_password_2;

    @iOSXCUITFindBy(xpath = "//android.widget.Button")
    private IOSElement cta_bankpage_continue;

    @iOSXCUITFindBy(xpath = "//android.widget.EditText")
    private IOSElement textbox_bankpage_password;

    @iOSXCUITFindBy(xpath = "//android.widget.Button")
    private IOSElement cta_bankpage_submit;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/base_title")
    private IOSElement label_success_page_status;

    @iOSXCUITFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@index ='0']")
    private IOSElement label_success_page_text;

    @iOSXCUITFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@index ='1']")
    private IOSElement label_success_page_wallet_balance;


    public AddMoneyPage(IOSDriver driver) throws IOException {
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
        if (Element.isElementPresent(driver, By.id("com.mobikwik_new:id/new_card_btn_pay"))) {
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
}
