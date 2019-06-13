package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ImpsPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Via Wallet']")
    private AndroidElement via_Wallet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Wallet to Bank']")
    private AndroidElement wallet_to_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '167795709569']")
    private AndroidElement bank;

    @AndroidFindBy(id = "com.mobikwik_new:id/edt_txt_transfer_amount")
    private AndroidElement amount_box;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Continue']")
    private AndroidElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Confirm']")
    private AndroidElement confirm;

    String success_text = "android.widget.TextView[@text = 'Money sent successfully']";

    public ImpsPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Imps Page*****");
    }

    public void clickOnViaWallet() throws InterruptedException{
        Element.selectElement(driver, via_Wallet, "Via Wallet on home page");
    }

    public void clickOnWalletToBank() throws InterruptedException{
        Element.selectElement(driver, wallet_to_bank, "Wallet to bank");
    }

    public void clickOnBank() throws InterruptedException{
        Element.selectElement(driver, bank, "Bank Account");
    }

    public void sendAmount() throws InterruptedException{
        Element.enterText(driver, amount_box, "50", "Transfer amount");
    }

    public void clickOnContinue() throws InterruptedException{
        Element.selectElement(driver, continueButton, "Bank Account");
    }

    public void clickOnConfirm() throws InterruptedException{
        Element.selectElement(driver, confirm, "Bank Account");
    }


    public By returnLocator() throws InterruptedException{
        return By.xpath(success_text);
    }














}
