package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;

public class TransactionHistoryPage {
    AndroidDriver driver;

    public String txn_list = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout";

    @AndroidFindBy(id = "com.mobikwik_new:id/btnVerfiySignUp")
    public AndroidElement CTA_text;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    public AndroidElement first_element_in_list;

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_txn_id")
    public AndroidElement txn_id;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='+ X6']")
    public AndroidElement add_money_transaction_value_6;

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_txn_product")
    public AndroidElement invoice_page;

    @AndroidFindBy(id = "com.mobikwik_new:id/refund_cta")
    public AndroidElement refund_cta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Money Available in your wallet can be used wherever Mobikwik is accepted at Merchant (Online/Offline) including Recharges and Bill Payments.']")
    public AndroidElement refund_cofirm_pop_up;

    @AndroidFindBy(id = "com.mobikwik_new:id/vertical_button_1")
    public AndroidElement cta_initiate_refund;

    //Refund Success Page

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Refund Initiated']")
    public AndroidElement refund_success_title;

    @AndroidFindBy(id = "com.mobikwik_new:id/refund_status_title")
    public AndroidElement refund_success_message;

    @AndroidFindBy(id = "com.mobikwik_new:id/base_icon_close")
    public AndroidElement cross_refund_success_page;

    @AndroidFindBy(id = "com.mobikwik_new:id/amount_text")
    public AndroidElement amount_refunded;

    public TransactionHistoryPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        Log.info("*****Transaction History Page*****");
    }

    public int getListSize() throws InterruptedException {
        return Element.findElements(driver, By.xpath(txn_list)).size();
    }

    public String getCTAText() throws InterruptedException {
        return Element.getText(driver, CTA_text, "Get CTA text").toString();
    }

    public void clickOnFirstElementInTheList() throws InterruptedException {
        Element.selectElement(driver, first_element_in_list, "First Element");
    }

    public String getTrxId() throws InterruptedException {
        return Element.getText(driver, txn_id, "Get CTA text").replace("Order ID: ", "");
    }

    public void clickOnAddMoneyTransactionOfSixRupees() throws InterruptedException {

        Element.selectElement(driver, add_money_transaction_value_6, "Click on Add Money Transaction of 6 Rs");
    }

    public void clickOnRefundCta() throws InterruptedException {
        Element.selectElement(driver, refund_cta, "Click on Refund Cta");
    }

    public void clickOnIntiateRefundCta() throws InterruptedException {
        Element.selectElement(driver, cta_initiate_refund, "Click on Intiate Refund cta");
    }

    public String getRefundMessage() throws InterruptedException {
        return Element.getText(driver, refund_success_message, "Get refund Success message");
    }

    public void navigateBackToHome() throws InterruptedException {
        Element.selectElement(driver, cross_refund_success_page, "Navigate Back to Home");
    }

    public String getAmountRefunded() throws InterruptedException{
        return Element.getText(driver, amount_refunded, "Amount Refunded");
    }



}
