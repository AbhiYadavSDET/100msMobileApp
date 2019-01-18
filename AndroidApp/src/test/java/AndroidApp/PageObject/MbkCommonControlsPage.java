package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MbkCommonControlsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new:id/have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "com.mobikwik_new:id/edit_text_mket")
    private AndroidElement text_box_coupon_code;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private AndroidElement button_apply_coupon;

    @AndroidFindBy(xpath = "//*[@text='w']")
    private AndroidElement button_up;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement cross_icon;


    public MbkCommonControlsPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void applyPromoCode(String promoCode) {
        Element.selectElement(driver, have_promo_code, "Have a promo code");
        Element.enterText(driver, text_box_coupon_code, promoCode, "Promo Code");
        Element.selectElement(driver, button_apply_coupon, "Apply Button");
    }

    public void clickOnUpButton() {
        Element.selectElement(driver, button_up, "Up button");
    }


    public void clickOnSuccessPageCross() {

        Element.selectElement(driver, cross_icon, "base_icon_close");

    }


}
