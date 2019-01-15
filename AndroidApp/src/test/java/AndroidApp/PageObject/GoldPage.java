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


    @AndroidFindBy(id = "com.mobikwik_new:id/btn_gold_action")
    private AndroidElement cta_make_payment;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement cross_icon;

    public GoldPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Gold Page*****");
    }
    public void clickOnBuyGold(){
        Element.selectElement(driver, button_buy_gold, "Buy Gold Button");
    }

    public void enterAmount(){
        Element.enterText(driver, text_box_buy_in_rupees, "1", "Enter Amount For Gold");

    }

    public void clickBuyNowCta(){
        Element.selectElement(driver, cta_buy_now, "Click on Buy Now.");
    }

    public void applyPromoCode(){
        Element.selectElement(driver, have_promo_code, "Have a promo code");
        Element.enterText(driver, text_box_coupon_code, "TSTAUGL", "Enter Promo Code");
        Element.selectElement(driver, button_apply_coupon, "Click on Apply Button");
    }

    public void clickOnMakePaymentCta(){
        Element.selectElement(driver, cta_make_payment, "Click on Make Payment");

    }
    //Add Security Pin

    public FiveStarRatingPage clickOnSuccessPageCross(){

        Element.selectElement(driver, cross_icon, "base_icon_close");
        return new FiveStarRatingPage(driver);

    }




}
