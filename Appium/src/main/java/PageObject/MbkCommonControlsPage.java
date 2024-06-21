package PageObject;

import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class MbkCommonControlsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "have_a_promo_text")
    private AndroidElement have_promo_code;

    @AndroidFindBy(id = "radio_button_sc")
    private AndroidElement clickApplySupercash;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement text_box_coupon_code;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    private AndroidElement button_apply_coupon;

    @AndroidFindBy(id = "back_button")
    private AndroidElement button_up_2;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement button_up;

    @AndroidFindBy(id = "close_icon")
    private AndroidElement cross_icon;


    @AndroidFindBy(id = "back_icon")
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

    @AndroidFindBy(id = "ic_close")
    private AndroidElement loan_dialogue_cross;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/close_button")
    private AndroidElement gullak_cross_button;

    @AndroidFindBy(id = "navigation_home")
    private AndroidElement navigate_home;

    @AndroidFindBy(xpath = "//android.widget.Button[text()='See All']")
    private AndroidElement details_text;

    @AndroidFindBy(id = "i_agree")
    private AndroidElement insurance_check_cta;

    @AndroidFindBy(id = "ic_close")
    private AndroidElement floating_widget_cross_button;

    @AndroidFindBy(id = "tv_do_not_want_benefits")
    private AndroidElement dont_want_security;

    @AndroidFindBy(id = "close_button")
    private AndroidElement add_money_BottomSheet;

    @AndroidFindBy(id = "android:id/alertTitle")
    private AndroidElement white_pop_up;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement close_pop_up;

    //2FA

    @AndroidFindBy(id="btn_verify")
    private AndroidElement verify_number_cta;

    @AndroidFindBy(id="tv_title")
    private AndroidElement twoFA_page_title;

    @AndroidFindBy(id="tv_sub_title")
    private AndroidElement twoFA_page_subtitle;

    @AndroidFindBy(id="tv_note")
    private AndroidElement twoFA_page_description;

    //permission sms (permission_allow_button)

    @AndroidFindBy(id="progress_bar")
    private AndroidElement twoFA_page_sms_verification_bottomsheet;

    @AndroidFindBy(id="cl_error_note")
    private AndroidElement twoFA_page_sms_verification_failure_bottomsheet;

    @AndroidFindBy(id="tv_btn_retry")
    private AndroidElement twoFA_page_sms_verification_retry_cta;









    public MbkCommonControlsPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);


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
        if (promoCode.contains("Apply Supercash")) {
            Element.selectElement(driver, have_promo_code, "Have a promo code");
            Element.selectElement(driver, clickApplySupercash, "Apply Supercash");
        } else {
            Element.selectElement(driver, have_promo_code, "Have a promo code");
            Element.enterText(driver, text_box_coupon_code, promoCode, "Promo Code");
            Element.selectElement(driver, button_apply_coupon, "Apply Button");
        }
    }


    public void clickOnSuccessPageCross() throws InterruptedException {
        if (Element.isElementPresent(driver, By.id("back_icon"))) {
            Element.selectElement(driver, arrow_back, "Tap on Cross");
        } else {
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

    public void clickOnLoanDialogueCross() {

        Element.selectElement(driver, loan_dialogue_cross, "Close Loan Dialogue");

    }

    public void clickOnGetInstantLoanBottonSheetCross() throws InterruptedException {

        Element.selectElement(driver, cross_button, "Cross Icon");

    }

    public void clickOnNavigateHome() throws InterruptedException {

        Element.selectElement(driver, navigate_home, "Navigate Back to home");

    }

    public void clickOnSeeAll() {
        Element.selectElement(driver, details_text, "See All Balance");
    }


    public void uncheckInsuranceCheckBox() throws InterruptedException {
        Element.waitForVisibility(driver, insurance_check_cta);
        if (Elements.isElementEnabled(driver, insurance_check_cta)) {
            Element.selectElement(driver, insurance_check_cta, "Insurance cta");
        }
    }

    public void closeFloatingWidget() {
        Element.selectElement(driver, floating_widget_cross_button, "Closing Floating Widget");

    }

    public void closeSecurityBottomSheet() {
        Element.selectElement(driver, dont_want_security, "Closing Setup Security Bottom sheet - I dont want to add Security");

    }

    public void closeAddmoneyBottomSheet() {
        Element.selectElement(driver, add_money_BottomSheet, "Close Add Money Bottom Sheet");
    }

    public boolean isWhitePopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, white_pop_up);
    }

    public void closeWhitePopUp() {
        Element.selectElement(driver, close_pop_up, "Close Pop Up");
    }





    public void clickVerifyNumberCta() {
        Element.selectElement(driver, verify_number_cta, "Click on Verify number Cta");

    }

    public String get2FAPageTile() {
        return Element.getText(driver, twoFA_page_title, "Fetch 2FA Page Title");
    }

    public String get2FAPageSubTile() {
        return Element.getText(driver, twoFA_page_subtitle, "Fetch 2FA Page SubTitle");
    }

    public String get2FAPageNoteDescription() {
        return Element.getText(driver, twoFA_page_description, "Fetch 2FA Page Note Description");
    }


    //permission sms (permission_allow_button)

    public Boolean isSmsVerificationInProgress() throws InterruptedException {
       return Elements.isElementPresent(driver,twoFA_page_sms_verification_bottomsheet );
    }

    public Boolean isSmsVerificationFailed() throws InterruptedException {
        return Elements.isElementPresent(driver,twoFA_page_sms_verification_failure_bottomsheet );
    }


    public void clickRetryNumberVerificationCta() {
        Element.selectElement(driver, twoFA_page_sms_verification_retry_cta, "Click on Retry Cta");

    }











}
