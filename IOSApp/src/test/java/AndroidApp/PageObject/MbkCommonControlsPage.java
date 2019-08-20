package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MbkCommonControlsPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/have_a_promo_text")
    private IOSElement have_promo_code;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/edit_text_mket")
    private IOSElement text_box_coupon_code;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private IOSElement button_apply_coupon;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/back_button")
    private IOSElement button_up_2;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/mkab_icon_1")
    private IOSElement button_up;

    @iOSXCUITFindBy(id = "base_icon_close")
    private IOSElement cross_icon;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btn_have_promo")
    private IOSElement label_have_a_promo_code;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Enter Promo Code']/following::android.widget.EditText")
    private IOSElement textbox_promo_code;

    @iOSXCUITFindBy(xpath = "//android.widget.RelativeLayout[@index = '0']/android.widget.ImageView[@index = '1']")
    private IOSElement cross_ct_overlay;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/close_button")
    private IOSElement ratings_cross_icon;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cta")
    private IOSElement cta_refer_and_earn;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cross_button")
    private IOSElement cross_button;


    public MbkCommonControlsPage(IOSDriver driver) throws IOException {
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

    public void clickOnUpButton2() {
        Element.selectElement(driver, button_up_2, "Up button");
    }

    public void clickOnHavePromoCode() {
        Element.selectElement(driver, label_have_a_promo_code, "Have a promo code");
    }

    public void applyRechargePromoCode(String promoCode) {
        Element.selectElement(driver, have_promo_code, "Have a promo code");
        Element.enterText(driver, text_box_coupon_code, promoCode, "Promo Code");
        Element.selectElement(driver, button_apply_coupon, "Apply Button");
    }


    public void clickOnSuccessPageCross() {

        Element.selectElement(driver, cross_icon, "base_icon_close");

    }

    public void enterPromoCode(String code) {

        Element.enterText(driver, textbox_promo_code, code, "Promo code");

    }

    public void clickOnApplyButton() {

        Element.selectElement(driver, button_apply_coupon, "Apply Button");

    }

    public void clickOnCtOverLayCross() {

        Element.selectElement(driver, cross_ct_overlay, "CT Overlay Cross");

    }

    public void clickOnCross() {

        Element.selectElement(driver, ratings_cross_icon, "Cross Icon");

    }

    public void clickOnReferAndEarnBottonSheetCross() {

        Element.selectElement(driver, cross_button, "Cross Icon");

    }


}
