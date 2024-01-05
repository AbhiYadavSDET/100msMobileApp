package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class P2MPage {


    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Scan any QR']")
    private IOSElement scanQrButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='“MobiKwik” Would Like to Access the Camera']")
    private IOSElement cameraPermissionNative;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private IOSElement cameraPermissionNativeOkCta;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Enable']")
    private IOSElement enablePermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enable Camera Access']")
    private IOSElement cameraPermissionUI;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Gallery']")
    private IOSElement galleryCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='“MobiKwik” Would Like to Access Your Photos']")
    private IOSElement photosPermissionNative;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow Access to All Photos']")
    private IOSElement photosPermissionNativeAllowAllCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Albums']")
    private IOSElement albumTabSelector;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SonuQr']")
    private IOSElement sonuQrAlbumSelect;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
    private IOSElement selectAvailableImageInAlbum;




    public P2MPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickScanQR() {
        Elements.selectElement(driver, scanQrButton, "Scan any QR");
    }

    public boolean checkIfCameraPermissionNeeded() throws InterruptedException {
        return Elements.isElementPresent(driver, cameraPermissionNative);
    }

    public void allowPermissionWhileUsingApp() {
        Elements.selectElement(driver, cameraPermissionNativeOkCta, "Permission : Enabled");
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




}
