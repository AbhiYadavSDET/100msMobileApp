package PageObject;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class TransferPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter 10 digit mobile number']")
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

    @AndroidFindBy(id = "txt_amount_value")
    private AndroidElement label_success_screen_amount;

    @AndroidFindBy(id = "txt_cn_value")
    private AndroidElement label_success_screen_number;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Payment Mode']")
    private AndroidElement label_add_money_payment_page;


    public TransferPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****TransferPage Page*****");
    }


    public void clickOnLabelEnterMobileNumber() throws InterruptedException {
        Element.selectElement(driver, label_enter_mobile_number, "Click on Mobile Number");
    }


    public void enterMobileNumber(String mobileNumber) throws InterruptedException {
        Element.enterText(driver, label_enter_mobile_number, mobileNumber, "Enter Mobile Number");
        Thread.sleep(4000);
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void clickOnCtaConfirmTransfer() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_transfer, "Click on Cta Transfer Now");
    }


    public String getSuccessPageStatus() throws InterruptedException {
        return Element.getText(driver, label_success_page_status, "Success page Status");
    }

    public String getSuccessPageAmount() throws InterruptedException {
        return Element.getText(driver, label_success_screen_amount, "Success page Amount");
    }

    public String getSuccessPageNumber() throws InterruptedException {
        return Element.getText(driver, label_success_screen_number, "Success page Code");
    }

    public String getAddMoneyPageTitle() throws InterruptedException {
        return Element.getText(driver, label_add_money_payment_page, "Fetching Page title");
    }


}
