package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TransferPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text = 'Enter 10 digit mobile number']")
    private IOSElement label_enter_mobile_number;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/search_edittext")
    private IOSElement textbox_search;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/image_tse")
    private IOSElement image_merchant;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/edt_txt_transfer_amount")
    private IOSElement enter_amount;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_p2p_action")
    private IOSElement cta_confirm_transfer;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/base_title")
    private IOSElement label_success_page_status;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/amount_value")
    private IOSElement label_amount;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/total_amount_value")
    private IOSElement label_total_payment;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_info")
    private IOSElement label_success_screen_name;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_cn_value")
    private IOSElement label_success_screen_number;


    public TransferPage(IOSDriver driver) throws IOException {
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
