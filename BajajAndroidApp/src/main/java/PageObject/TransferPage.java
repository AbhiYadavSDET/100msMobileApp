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

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/search_edittext")
    private AndroidElement textbox_search;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/image_tse")
    private AndroidElement image_merchant;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/edt_txt_transfer_amount")
    private AndroidElement enter_amount;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/btn_p2p_action")
    private AndroidElement cta_confirm_transfer;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/base_title")
    private AndroidElement label_success_page_status;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/amount_value")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/total_amount_value")
    private AndroidElement label_total_payment;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/txt_info")
    private AndroidElement label_success_screen_name;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/txt_cn_value")
    private AndroidElement label_success_screen_number;


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

    public String getSuccessPageName() throws InterruptedException {
        return Element.getText(driver, label_success_screen_name, "Success page name");
    }

    public String getSuccessPageNumber() throws InterruptedException {
        return Element.getText(driver, label_success_screen_number, "Success page Code");
    }


}
