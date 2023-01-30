package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
//import utils.Elements;

import java.io.IOException;

public class AddMoneyPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "btn_add_money")
    private AndroidElement add_Money;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement button_add;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'More payment options']")
    private AndroidElement more_payment_options;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'INDUSIND BANK LTD.']")
    private AndroidElement select_indusind_bank;

    @AndroidFindBy(xpath = "//*[@text = 'CVV']")
    private AndroidElement enter_CVV;

    @AndroidFindBy(id = "btn_add_money")
    private AndroidElement pay;



    public AddMoneyPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Add Money Page*****");
    }


    public void clickOnAddMoney() throws InterruptedException {
        Elements.selectElement(driver, add_Money, "Add Money Button");
    }
    public void clickOnAdd() throws InterruptedException {
        Elements.selectElement(driver, button_add, "Continue Button");
    }

    public void selectBank() throws InterruptedException {
        Elements.selectElement(driver, select_bank, "Select Bank ");
    }

    public void selectMorePaymentOptions() throws InterruptedException {
        Elements.selectElement(driver, more_payment_options,"Select More Payment Options");
    }

    public void clickOnIndusindBank() throws InterruptedException {
        Elements.selectElement(driver, select_indusind_bank, "Select Indusind Bank");
    }

    public void clickOnPay() throws InterruptedException {
        Elements.selectElement(driver, pay, "Pay Now Button");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Elements.enterToElement(driver, enter_amount, amount, "Enter Amount");
    }

    public void enterCVV(String CVV) throws InterruptedException {
        Elements.enterToElement(driver, enter_CVV , CVV, "Enter CVV");
    }


}
