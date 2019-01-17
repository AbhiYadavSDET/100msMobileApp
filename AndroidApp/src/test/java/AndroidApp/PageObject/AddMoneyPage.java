package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

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

    @AndroidFindBy(id = "com.mobikwik_new:id/mkab_title")
    public AndroidElement label_make_payment;

    @AndroidFindBy(id = "com.mobikwik_new:id/horizontal_button_2")
    public AndroidElement button_yes;

    @AndroidFindBy(id = "com.mobikwik_new:id/horizontal_button_1")
    public AndroidElement button_no;

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

    public void clickOnYesButton() throws InterruptedException {
        Element.selectElement(driver, button_yes, "Yes");
    }

    public void clickOnNoButton() throws InterruptedException {
        Element.selectElement(driver, button_no, "No");
    }


}
