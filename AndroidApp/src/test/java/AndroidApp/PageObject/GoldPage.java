package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GoldPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "com.mobikwik_new:id/buy_gold_button_registered")
    private AndroidElement button_buy_gold;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='₹']")
    private AndroidElement text_box_buy_in_rupees;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='gm']")
    private AndroidElement text_box_buy_in_gram;

    @AndroidFindBy(id = "com.mobikwik_new:id/buy_now_button")
    private AndroidElement cta_buy_now;

    @AndroidFindBy(id = "com.mobikwik_new:id/have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "com.mobikwik_new:id/edit_text_mket")
    private AndroidElement text_box_coupon_code;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private AndroidElement button_apply_coupon;


    @AndroidFindBy(id = "com.mobikwik_new:id/btn_gold_actiont")
    private AndroidElement cta_make_payment;



    public GoldPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Gold Page*****");
    }


}
