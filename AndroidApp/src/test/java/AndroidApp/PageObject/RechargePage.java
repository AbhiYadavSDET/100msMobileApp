package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RechargePage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Enter Mobile Number']")
    private AndroidElement textbox_mobile_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'L']")
    private AndroidElement link_drop_down;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Vodafone']")
    private AndroidElement label_vodafone;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Haryana']")
    private AndroidElement label_haryana;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Enter any amount']")
    private AndroidElement textbox_enter_amount;

    @AndroidFindBy(id = "com.mobikwik_new:id/amount_field")
    private AndroidElement textbox_enter_amount2;

    @AndroidFindBy(id = "com.mobikwik_new:id/actual_continue")
    private AndroidElement button_continue;

    @AndroidFindBy(id = "com.mobikwik_new:id/cta")
    private AndroidElement cta_continue;

    // Success screen

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Connection Number']/following::android.widget.TextView[1]")
    private AndroidElement label_connection_no;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Category']/following::android.widget.TextView[1]")
    private AndroidElement label_category;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Operator']/following::android.widget.TextView[1]")
    private AndroidElement label_operator;

    @AndroidFindBy(id = "com.mobikwik_new:id/amount_value")
    private AndroidElement label_amount;

    @AndroidFindBy(id = "com.mobikwik_new:id/total_amount_value")
    private AndroidElement label_total_payment;

    @AndroidFindBy(id = "com.mobikwik_new:id/base_title")
    private AndroidElement label_success_page_status;

    @AndroidFindBy(id = "com.mobikwik_new:id/recharge_button")
    private AndroidElement cta_continue2;

    @AndroidFindBy(id = "com.mobikwik_new:id/content_root")
    public AndroidElement popup;

    @AndroidFindBy(id = "com.mobikwik_new:id/title_text")
    public AndroidElement popup_error;

    @AndroidFindBy(id = "com.mobikwik_new:id/body_text")
    public AndroidElement popup_text;

    @AndroidFindBy(id = "com.mobikwik_new:id/close_button")
    public AndroidElement popup_cross;

    @AndroidFindBy(id = "com.mobikwik_new:id/view_bill_text")
    public AndroidElement viewBillText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'z']/following::android.widget.EditText[1]")
    public AndroidElement textbox_enter_dth_amount;

    @AndroidFindBy(id = "com.mobikwik_new:id/connection_detail_button_recharge")
    public AndroidElement button_dth_continue;


    public RechargePage(AndroidDriver driver) throws IOException {
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

    public void selectOperator() throws InterruptedException {
        Element.selectElement(driver, label_vodafone, "Operator");
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

}
