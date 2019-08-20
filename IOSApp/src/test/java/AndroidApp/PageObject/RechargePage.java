package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RechargePage {

    IOSDriver driver;


    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text = 'Enter Mobile Number']")
    private IOSElement textbox_mobile_no;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'L']")
    private IOSElement link_drop_down;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Vodafone']")
    private IOSElement label_vodafone;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Haryana']")
    private IOSElement label_haryana;

    //@iOSXCUITFindBy(id = "com.mobikwik_new:id/edit_text_mket")
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Amount (in X)']/following::android.widget.TextView[@text = 'Enter any amount']")
    //@iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Amount (in ₹)'/following::android.widget.TextView[@text = 'Enter any amount']")
    public IOSElement textbox_enter_amount;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/amount_field")
    private IOSElement textbox_enter_amount2;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/actionbar_continue_button")
    private IOSElement button_continue;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cta")
    private IOSElement cta_continue;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Postpaid']")
    private IOSElement postPaid;

    // Success screen

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Connection Number']/following::android.widget.TextView[1]")
    private IOSElement label_connection_no;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Category']/following::android.widget.TextView[1]")
    private IOSElement label_category;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Operator']/following::android.widget.TextView[1]")
    private IOSElement label_operator;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/amount_value")
    private IOSElement label_amount;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/total_amount_value")
    private IOSElement label_total_payment;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/base_title")
    private IOSElement label_success_page_status;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/recharge_button")
    private IOSElement cta_continue2;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/content_root")
    public IOSElement popup;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/title_text")
    public IOSElement popup_error;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/body_text")
    public IOSElement popup_text;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/close_button")
    public IOSElement popup_cross;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/view_bill_text")
    public IOSElement viewBillText;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'z']/following::android.widget.EditText[1]")
    public IOSElement textbox_enter_dth_amount;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/connection_detail_button_recharge")
    public IOSElement button_dth_continue;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_promo_result_desc")
    public IOSElement label_promo_code_text;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'More']")
    public IOSElement label_more;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'BP Number']/following::android.widget.EditText[1]")
    public IOSElement textbox_bp_number;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/connection_detail_textView_name")
    public IOSElement label_success_screen_operator;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/connection_detail_textView_company")
    public IOSElement label_success_screen_number;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/fixed_amount_value")
    public IOSElement label_success_screen_amount;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Telephone Number (Without STD Code)']/following::android.widget.EditText[1]")
    public IOSElement textbox_telephone_no;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Telephone Number (Without STD Code)']/following::android.widget.EditText[2]")
    public IOSElement textbox_can;

    public RechargePage(IOSDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Recharge Page*****");
    }


    // New

    public void enterMobileNo(String cell) throws InterruptedException {
        Element.enterText(driver, textbox_mobile_no, cell, "Mobile No");
    }

    public void clickOnDropDown() throws InterruptedException {
        Element.selectElement(driver, link_drop_down, "Drop down");
    }

    public void clickOnPostPaid() throws InterruptedException {
        Element.selectElement(driver, postPaid, "Postpaid");
    }

    public void selectOperator() throws InterruptedException {
        Element.selectElement(driver, label_vodafone, "Operator");
    }

    public void selectOperator(String operator) throws InterruptedException {
        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
        IOSElement IOSElement = new Element(driver).findElement(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"));
        Element.selectElement(driver, IOSElement, "Operator");
    }

    public void selectCircle() throws InterruptedException {
        Element.selectElement(driver, label_haryana, "Circle");
    }

    public void selectAmount() throws InterruptedException {
        Element.selectElement(driver, textbox_enter_amount, "Select Amount");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_enter_amount2, amount, "Enter Amount");
    }

    public void clickOnContinue() throws InterruptedException {
        Element.selectElement(driver, button_continue, "Button Continue");
    }

    public void clickOnCtaCotinue() throws InterruptedException {
        Element.selectElement(driver, cta_continue, "CTA Continue");
    }

    public void clickOnCtaContinue2() throws InterruptedException {
        Element.selectElement(driver, cta_continue2, "CTA Continue");
    }

    public void clickOnDthContinueCta() throws InterruptedException {
        Element.selectElement(driver, button_dth_continue, "CTA Continue");
    }

    public String getSuccessPageConnectionNo() throws InterruptedException {
        return Element.getText(driver, label_connection_no, "Success Screen | Verify Connection No");
    }

    public String getSuccessPageCategory() throws InterruptedException {
        return Element.getText(driver, label_category, "Success Screen | Verify Category");
    }

    public String getSuccessPageOperator() throws InterruptedException {
        return Element.getText(driver, label_operator, "Success Screen | Verify Operator");
    }

    public String getSuccessPageAmount() throws InterruptedException {
        return Element.getText(driver, label_amount, "Success Screen | Verify Amount");
    }

    public String getSuccessPageTotalPayment() throws InterruptedException {
        return Element.getText(driver, label_total_payment, "Success Screen | Verify Total Payment Amount");
    }

    public String getSuccessPageStatus() throws InterruptedException {
        return Element.getText(driver, label_success_page_status, "Success Screen | Verify Status");
    }

    public String getPopupError() throws InterruptedException {
        return Element.getText(driver, popup_error, "Popup | Verify error");
    }

    public String getPopupText() throws InterruptedException {
        return Element.getText(driver, popup_text, "Popup | Verify text");
    }

    public void clickOnPopupCross() throws InterruptedException {
        Element.selectElement(driver, popup_cross, "Popup | Cross");
    }

    public String getViewBillText() throws InterruptedException {
        return Element.getText(driver, viewBillText, "View Bill | Verify text");
    }

    public void enterDthAmount(String amount) throws InterruptedException {
        Element.enterText(driver, textbox_enter_dth_amount, amount, "Enter Amount");
    }

    public String getPromoCodeTextOnSuccessScreen() throws InterruptedException {
        return Element.getText(driver, label_promo_code_text, "Success Screen | Verify promo text");
    }

    public String getSuccessScreenOperator() throws InterruptedException {
        return Element.getText(driver, label_success_screen_operator, "Success Screen | Verify Operator");
    }

    public String getSuccessScreenNumber() throws InterruptedException {
        return Element.getText(driver, label_success_screen_number, "Success Screen | Verify Number");
    }

    public String getSuccessScreenAmount() throws InterruptedException {
        return Element.getText(driver, label_success_screen_amount, "Success Screen | Verify Amount");
    }

    public void enterBpNumber(String number) throws InterruptedException {
        Element.enterText(driver, textbox_bp_number, number, "Enter Number");
    }

    public void enterTelephoneNumber(String telephoneNo) throws InterruptedException {
        Element.enterText(driver, textbox_telephone_no, telephoneNo, "Enter Telephone Number");
    }


    public void enterCanNumber(String can) throws InterruptedException {
        Element.enterText(driver, textbox_can, can, "Enter can");
    }


}
