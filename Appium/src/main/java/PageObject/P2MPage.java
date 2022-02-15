package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;

public class P2MPage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Enter Mobile Number or Merchant Code']")
    private AndroidElement label_enter_mobile_number;

    @AndroidFindBy(id = "search_edittext")
    private AndroidElement textbox_search;

    @AndroidFindBy(id = "image_tse")
    private AndroidElement image_merchant;

    @AndroidFindBy(id = "edt_txt_transfer_amount")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "btn_p2p_action")
    private AndroidElement cta_confirm_transfer;

    @AndroidFindBy(id = "base_title")
    private AndroidElement label_success_page_status;

    @AndroidFindBy(id = "amount_value")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "total_amount_value")
    private AndroidElement label_total_payment;

    @AndroidFindBy(id = "txt_info")
    private AndroidElement label_success_screen_name;

    @AndroidFindBy(id = "txt_cn_value")
    private AndroidElement label_success_screen_code;


    public P2MPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****P2M Page*****");
    }

/*
    public void clickOnLabelEnterMerchantCode() throws InterruptedException {
        Element.selectElement(driver, label_enter_mobile_number, "Click on Merchant Code");
    }

    public void enterMerchantCode(String merchantCode) throws InterruptedException {
        Element.enterText(driver, textbox_search, merchantCode, "Enter Merchant Code");
    }

    public void clickOnMerchantCodeFromList() throws InterruptedException {
        Element.selectElement(driver, image_merchant, "Click on Merchant Code from List");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void clickOnCtaConfirmTransfer() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_transfer, "Click on Cta Confirm Transfer");
    }

    public String getSuccessPageStatus() throws InterruptedException {
        return Element.getText(driver, label_success_page_status, "Success page Status");
    }

    public String getSuccessPageName() throws InterruptedException {
        return Element.getText(driver, label_success_screen_name, "Success page name");
    }

    public String getSuccessPageCode() throws InterruptedException {
        return Element.getText(driver, label_success_screen_code, "Success page Code");
    }

 */


}
