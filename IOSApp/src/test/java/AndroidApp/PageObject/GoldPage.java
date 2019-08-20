package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

public class GoldPage {

    IOSDriver driver;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/buy_gold_button_registered_price")
    private IOSElement button_buy_gold;

    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text='₹']")
    private IOSElement text_box_buy_in_rupees;


    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text='gm']")
    private IOSElement text_box_buy_in_gram;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/buy_now_button")
    private IOSElement cta_buy_now;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/have_a_promo_text")
    private IOSElement have_promo_code;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/edit_text_mket")
    private IOSElement text_box_coupon_code;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private IOSElement button_apply_coupon;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_gold_action")
    private IOSElement cta_make_payment;

    @iOSXCUITFindBy(id = "base_icon_close")
    private IOSElement cross_icon;

    public GoldPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Gold Page*****");
    }

    public void clickOnBuyGold() {
        Element.selectElement(driver, button_buy_gold, "Buy Gold Button");
    }

    public void enterAmount() {
        Element.enterText(driver, text_box_buy_in_rupees, "1", "Enter Amount For Gold");

    }

    public void clickBuyNowCta() {
        Element.selectElement(driver, cta_buy_now, "Click on Buy Now.");
    }

    public void applyPromoCode() {
        Element.selectElement(driver, have_promo_code, "Have a promo code");
        Element.enterText(driver, text_box_coupon_code, "TSTAUGL", "Enter Promo Code");
        Element.selectElement(driver, button_apply_coupon, "Click on Apply Button");
    }

    public void clickOnMakePaymentCta() {
        Element.selectElement(driver, cta_make_payment, "Click on Make Payment");

    }
    //Add Security Pin

    public FiveStarRatingPage clickOnSuccessPageCross() {

        Element.selectElement(driver, cross_icon, "base_icon_close");
        return new FiveStarRatingPage(driver);

    }


}
