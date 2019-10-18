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

public class TransactionHistoryPage {
    AndroidDriver driver;

    public String txn_list = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout";

    @AndroidFindBy(id = "com.mobikwik_new:id/btnVerfiySignUp")
    public AndroidElement CTA_text;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    public AndroidElement first_element_in_list;

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_txn_id")
    public AndroidElement txn_id;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text='+ X6']")
    public AndroidElement add_money_transaction;

    @AndroidFindBy(id= "com.mobikwik_new:id/txt_txn_product")
    public AndroidElement invoice_page;

    @AndroidFindBy(id= "com.mobikwik_new:id/refund_cta")
    public AndroidElement refund_cta;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text= 'Money Available in your wallet can be used wherever Mobikwik is accepted at Merchant (Online/Offline) including Recharges and Bill Payments.']")
    public AndroidElement refund_cofirm_pop_up;

    @AndroidFindBy(id= "com.mobikwik_new:id/vertical_button_1")
    public AndroidElement cta_initiate_refund;

    //Refund Success Page

    @AndroidFindBy(xpath= "//android.widget.TextView[@text= 'Refund Initiated']")
    public AndroidElement refund_success_title;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text= 'MobiKwik has initiated the refund to the respective financial instrument (Bank Account/Cards/UPI) used while adding Money. This would take 3 to 7 business days (Excluding Saturdays and Sundays).']")
    public AndroidElement refund_success_message;

    



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

}
