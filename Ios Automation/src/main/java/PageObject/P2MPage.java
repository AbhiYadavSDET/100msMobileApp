package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class P2MPage {


    IOSDriver driver;

    @iOSXCUITFindBy(id = "Tab-Center-Part")
    private IOSElement scanQrButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='“MobiKwik” Would Like to Access the Camera']")
    private IOSElement cameraPermissionNative;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private IOSElement cameraPermissionNativeOkCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'location')][1]")
    private IOSElement locationPermissionNativePresent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow While Using App']")
    private IOSElement locationPermissionNativeAllowWhileUsingAppCta;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Enable']")
    private IOSElement enablePermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enable Camera Access']")
    private IOSElement cameraPermissionUI;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Gallery']")
    private IOSElement galleryCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow Full Access']")
    private IOSElement photosPermissionNative;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow Full Access']")
    private IOSElement photosPermissionNativeAllowAllCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Albums']")
    private IOSElement albumTabSelector;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SonuQr']")
    private IOSElement SonuQrAlbumSelect;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,'Photo')]")
    private IOSElement selectAvailableImageInAlbum;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='MobikwikQr']")
    private IOSElement MobikwikQrAlbumSelect;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private IOSElement amountField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private IOSElement continueCtaAmountPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm Payment']")
    private IOSElement ctaConfirmPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You Paid']")
    private IOSElement successScreenStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You Paid']/following::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Merchant Name']/following::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenMerchantName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Merchant Code']/following::XCUIElementTypeStaticText[1]")
    private IOSElement successScreenMerchantCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconShare']/preceding::XCUIElementTypeButton")
    private IOSElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private IOSElement recent_merchant;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Show nearby stores']")
    private IOSElement nearby_stores;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Offline payment code']")
    private IOSElement offline_payment_code;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Current Location')]")
    private IOSElement current_location_title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private IOSElement store_by_address;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
    private IOSElement pay_at_store_title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private IOSElement instruction_text;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Enter details')]")
    private IOSElement enterNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Delivery Person Ph No']")
    private IOSElement deliveryPersonPhNo;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Confirm Payment'])[2]")
    private IOSElement confirmPayment;





    public P2MPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickScanQR() {
        Elements.selectElement(driver, scanQrButton, "Scan any QR");
    }

    public boolean checkIfCameraPermissionNeeded() throws InterruptedException {
        return Elements.isElementPresent(driver, cameraPermissionNative, "checkIfCameraPermissionNeeded");
    }

    public void allowPermissionWhileUsingApp() {
        Elements.selectElement(driver, cameraPermissionNativeOkCta, "Permission : Enabled");
    }

    public boolean checkIfLocationPermissionNeeded() throws InterruptedException {
        return Elements.isElementPresent(driver, locationPermissionNativePresent, "checkIfLocationPermissionNeeded");
    }
    public void allowLocationPermissionWhileUsingApp() {
        Elements.selectElement(driver, locationPermissionNativeAllowWhileUsingAppCta, "Allow While using app for Location Permission");
    }

    public void clickOnRecentMerchant() {
        Elements.selectElement(driver, recent_merchant, "click on Recent Merchant");
    }

    public void clickOnGallery() {
        Elements.selectElement(driver, galleryCta, "click on gallery");
    }


    public boolean checkAllowPermissionForGallery() throws InterruptedException {
        return Elements.isElementPresent(driver, photosPermissionNative, "checkAllowPermissionForGallery");
    }
    public void allowPermissionAllow() {
        Elements.selectElement(driver, photosPermissionNativeAllowAllCta, "Permission : Allow");
    }

    public void clickOnSonuQrCodeGallery() throws InterruptedException {
        Elements.selectElement(driver, albumTabSelector, "Selecting Album Tab");
        Thread.sleep(1000);
        Elements.selectElement(driver,SonuQrAlbumSelect,"Selecting Sonu QR Album");
        Thread.sleep(1000);
        Elements.selectElement(driver,selectAvailableImageInAlbum,"Selecting Photo in Album");
    }

    public void clickOnMBKQrCodeGallery() throws InterruptedException {
        Elements.selectElement(driver, albumTabSelector, "Selecting Album Tab");
        Thread.sleep(1000);
        Elements.selectElement(driver,MobikwikQrAlbumSelect,"Selecting Mobikwik QR Album");
        Thread.sleep(1000);
        Elements.selectElement(driver,selectAvailableImageInAlbum,"Selecting Photo in Album");
    }

    public void enterAmount(String amount) {
        Elements.waitForElementToVisibleOnPage(driver, amountField, 4, "enterAmount");
        Elements.selectElement(driver, (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeButton[@name='"+amount+"']")),"Select Amount from Keyboard");
    }

    public void clickOnContinue() throws InterruptedException {
        if(Elements.isElementEnabled(driver, continueCtaAmountPage, "continueCtaAmountPage")){
            Elements.selectElement(driver, continueCtaAmountPage, "Continue");
        }else {
            Thread.sleep(2000);
            Elements.selectElement(driver, continueCtaAmountPage, "Continue");
        }

    }

    public void clickConfirmPayment() {
        Elements.waitForElementToVisibleOnPage(driver,ctaConfirmPayment, 2, "clickConfirmPayment");
        Elements.selectElement(driver, ctaConfirmPayment, "Confirm Payment");
    }

    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, successScreenStatus, "Status");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, successScreenAmount, "Amount");
    }


    public String getMerchantName() throws InterruptedException {
        return Elements.getText(driver, successScreenMerchantName, "Merchant Name");
    }

    public String getMerchantCode() throws InterruptedException {
        return Elements.getText(driver, successScreenMerchantCode, "Merchant Code");
    }

    public boolean checkBackButton() throws InterruptedException {
        return Elements.isElementPresent(driver, backButton, "checkBackButton");
    }

    public void clickBackButton() {
        Elements.selectElement(driver, backButton, "Close Icon");
    }

    public void clickOnNearbyStores() {
        Elements.selectElement(driver, nearby_stores, "click on Nearby Stores");
    }

    public void clickOnOfflinePaymentCode() {
        Elements.selectElement(driver, offline_payment_code, "click on Offline Payment Code");
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

    public boolean isEnterDetailsBottomSheetPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, enterNumber, "isEnterDetailsBottomSheetPresent");
    }

    public void clickDeliveryPersonPhNoField(){
        Elements.click(driver, deliveryPersonPhNo,"Click on delivery person ph no. field");
    }

    public void enterPhoneNo(String number){
        Elements.enterToElement(driver, deliveryPersonPhNo, number, "Enter delivery person ph no.");
    }

    public void clickOnConfirmPaymentButton(){
        Elements.click(driver, confirmPayment,"Click on confirm payment");
    }

}
