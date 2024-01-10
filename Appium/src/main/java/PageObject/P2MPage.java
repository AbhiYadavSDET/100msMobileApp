package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class P2MPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.mobikwik_new.debug:id/navigation_zip\"]/android.widget.FrameLayout/android.widget.ImageView")
    private AndroidElement scanQrButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement permissionWhileUsingApp;

    @AndroidFindBy(id = "permission_allow_one_time_button")
    private AndroidElement permissionThisTime;

    @AndroidFindBy(id = "permission_deny_button")
    private AndroidElement permissionDeny;

    @AndroidFindBy(id = "btn_continue")
    private AndroidElement ctaEnable;

    @AndroidFindBy(id = "merchant_code")
    private AndroidElement merchantCodeTextBoxForClick;

//    com.android.packageinstaller:id/permission_allow_button
//    com.android.permissioncontroller:id/permission_allow_button
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement permissionAllow;

    @AndroidFindBy(id = "search_edittext")
    private AndroidElement merchantCodeTextBox;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'BLF001']")
    private AndroidElement selectMerchant;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement amountTextBox;

    @AndroidFindBy(id = "btn_submit")
    private AndroidElement ctaContinue;

    @AndroidFindBy(id = "cta")
    private AndroidElement ctaConfirmPayment;

    @AndroidFindBy(id = "status")
    private AndroidElement successScreenStatus;

    @AndroidFindBy(id = "amount")
    private AndroidElement successScreenAmount;

    @AndroidFindBy(id = "name")
    private AndroidElement successScreenReceiverName;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Merchant Name']/following-sibling::android.widget.TextView")
    private AndroidElement successScreenMerchantName;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Merchant Code']/following-sibling::android.widget.TextView")
    private AndroidElement successScreenMerchantCode;

    @AndroidFindBy(id = "cta")
    private AndroidElement successScreenZipCta;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement successScreenUpButton;

    @AndroidFindBy(id = "back_icon")
    private AndroidElement upButtom;

    @AndroidFindBy(id = "close_button")
    private AndroidElement backButton;

    @AndroidFindBy(id = "add_account_button")
    public AndroidElement upiBottomSheetCta;

    @AndroidFindBy(id = "text_gallery")
    public AndroidElement text_gallery;

    @AndroidFindBy(id = "name_initial_text_view")
    public AndroidElement recent_merchant;

    @AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
    private AndroidElement mobikwik_qr;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'SonuQr.jpg']")
    private AndroidElement sonu_qr;

    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    public AndroidElement qr_code;

    @AndroidFindBy(id = "cta_otp_totp")
    public AndroidElement offline_payment_code;

    @AndroidFindBy(id = "nearby_stores")
    public AndroidElement nearby_stores;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Current location']")
    public AndroidElement current_location_title;

    @AndroidFindBy(id = "currentLocation")
    public AndroidElement store_by_address;

    @AndroidFindBy(id = "mkab_title")
    public AndroidElement pay_at_store_title;

    @AndroidFindBy(id = "instructionText")
    public AndroidElement instruction_text;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]")
    public AndroidElement galleryQrCode;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[2]")
    public AndroidElement galleryMbkQrCode;

    @AndroidFindBy(id = "close_button")
    private AndroidElement back_btn;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/title")
    private AndroidElement detail_bottomsheet;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/edit_text")
    private AndroidElement number_entry_field;


    public P2MPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickScanQR() {
        Elements.selectElement(driver, scanQrButton, "Scan any QR");
    }

    public void allowPermissionWhileUsingApp() {
        Elements.selectElement(driver, permissionWhileUsingApp, "Permission : While using app");
    }

    public void allowPermissionAllow() {
        Elements.selectElement(driver, permissionAllow, "Permission : Allow");
    }

    public void clickEnableButton() {
        Elements.selectElement(driver, ctaEnable, "Enable");
    }

    public void clickMerchantCodeTextBox() {
        Elements.selectElement(driver, merchantCodeTextBoxForClick, "Merchant Code Text Box");
    }

    public void enterMerchantCode(String merchantCode) {
        Elements.enterToElement(driver, merchantCodeTextBox, merchantCode, "Merchant Code");
    }

    public void selectMerchant() {
        Elements.selectElement(driver, selectMerchant, "Merchant");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, amountTextBox, amount, "Amount");
    }

    public void clickOnContinue() {
        Elements.selectElement(driver, ctaContinue, "Continue");
    }

    public void clickConfirmPayment() {
        Elements.selectElement(driver, ctaConfirmPayment, "Confirm Payment");
    }

    public void clickUpButton() {
        Elements.selectElement(driver, upButtom, "Up Button");
    }

    public void clickBackButton() {
        Elements.selectElement(driver, backButton, "Close Icon");
    }

    public void clickOnGallery() {
        Elements.selectElement(driver, text_gallery, "click on gallery");
    }

    public void clickOnRecentMerchant() {
        Elements.selectElement(driver, recent_merchant, "click on Recent Merchant");
    }

    public void clickOnMobikwikQRCode() {
        Elements.selectElement(driver, mobikwik_qr, "click on Mobikwik QR Code");
    }

    public void clickOnSonuQRCode() {
        Elements.selectElement(driver, sonu_qr, "click on Sonu QR Code");
    }

    public void clickOnQRCode() {
        Elements.selectElement(driver, qr_code, "click on QR Code");
    }

    public void clickOnOfflinePaymentCode() { Elements.selectElement(driver, offline_payment_code, "click on Offline Payment Code"); }

    public void clickOnNearbyStores() {
        Elements.selectElement(driver, nearby_stores, "click on Nearby Stores");
    }

    // Success Screen methods
    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, successScreenStatus, "Status");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, successScreenAmount, "Amount");
    }

    public String getReceiverName() throws InterruptedException {
        return Elements.getText(driver, successScreenReceiverName, "Receiver Name");
    }

    public String getMerchantName() throws InterruptedException {
        return Elements.getText(driver, successScreenMerchantName, "Merchant Name");
    }

    public String getMerchantCode() throws InterruptedException {
        return Elements.getText(driver, successScreenMerchantCode, "Merchant Code");
    }

    public String getZipCtaText() throws InterruptedException {
        return Elements.getText(driver, successScreenZipCta, "Zip Cta Text");
    }

    public String getCurrentLocationTitle() throws InterruptedException {
        return Elements.getText(driver, current_location_title, "Current Location Title");
    }

    public String getStoreByAddress() throws InterruptedException {
        return Elements.getText(driver, store_by_address, "Store By Address");
    }

    public String getPayAtStoreTitle() throws InterruptedException {
        return Elements.getText(driver, pay_at_store_title, "Pay At Store Title");
    }

    public String getInstructionText() throws InterruptedException {
        return Elements.getText(driver, instruction_text, "Instruction Text");
    }

    public boolean checkWhileUsingAppPermission() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionWhileUsingApp);
    }
    public boolean checkAllowPermission() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllow);
    }

    public void clickOnSonuQrCodeGallery() {
        Elements.selectElement(driver, galleryQrCode, "click on Sonu QR code from Gallery");
    }

    public void clickOnMBKQrCodeGallery() {
        Elements.selectElement(driver, galleryMbkQrCode, "click on Mbk QR code from Gallery");
    }

    public boolean checkAllowPermissionForGallery() throws InterruptedException {
        return Elements.isElementPresent(driver, permissionAllow);
    }

    public boolean checkBackButton() throws InterruptedException {
        return Elements.isElementPresent(driver, back_btn);
    }

    public boolean checkEnterDetailsBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, detail_bottomsheet);
    }

    public void enterPhoneNumber(String MobileNumber) {
        Elements.enterToElement(driver, number_entry_field, MobileNumber, "Enter Mobile Number");
    }


}
