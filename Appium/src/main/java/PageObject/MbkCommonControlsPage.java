package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class MbkCommonControlsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement text_box_coupon_code;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private AndroidElement button_apply_coupon;

    @AndroidFindBy(id = "back_button")
    private AndroidElement button_up_2;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement button_up;

    @AndroidFindBy(id = "base_icon_close")
    private AndroidElement cross_icon;


    @AndroidFindBy(id = "base_icon_back")
    private AndroidElement arrow_back;

    @AndroidFindBy(id = "btn_have_promo")
    private AndroidElement label_have_a_promo_code;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Enter Promo Code']/following::android.widget.EditText")
    private AndroidElement textbox_promo_code;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@index = '0']/android.widget.ImageView[@index = '1']")
    private AndroidElement cross_ct_overlay;

    @AndroidFindBy(id = "close_button")
    private AndroidElement ratings_cross_icon;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_refer_and_earn;

    @AndroidFindBy(id = "cross_button")
    private AndroidElement cross_button;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/close_button")
    private AndroidElement gullak_cross_button;

    @AndroidFindBy(id = "navigation_home")
    private AndroidElement navigate_home;


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


    public void clickOnSuccessPageCross() throws InterruptedException {
         if (Element.isElementPresent(driver,By.id("base_icon_back"))){
             Element.selectElement(driver, arrow_back, "base_icon_back");
         }

         else

            {

                Element.selectElement(driver, cross_icon, "base_icon_close");
            }


    }

    public void clickOnSuccessPageBackbutton() {

        Element.selectElement(driver, arrow_back, "Click on back button on Recharge Postpid succuss screen");

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

    public void clickOnGullakCross() {

        Element.selectElement(driver, gullak_cross_button, "Cross Icon");

    }

    public void clickOnGetInstantLoanBottonSheetCross() throws InterruptedException {

        Element.selectElement(driver, cross_button, "Cross Icon");

    }

    public void clickOnNavigateHome() throws InterruptedException {

        Element.selectElement(driver, navigate_home, "Navigate Back to home");

    }


}