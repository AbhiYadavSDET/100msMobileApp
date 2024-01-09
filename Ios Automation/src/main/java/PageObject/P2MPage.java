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
    private IOSElement SonuQrAlbumSelect;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
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

    public void clickOnRecentMerchant() {
        Elements.selectElement(driver, recent_merchant, "click on Recent Merchant");
    }

    public void clickOnGallery() {
        Elements.selectElement(driver, galleryCta, "click on gallery");
    }


    public boolean checkAllowPermissionForGallery() throws InterruptedException {
        return Elements.isElementPresent(driver, photosPermissionNative);
    }
    public void allowPermissionAllow() {
        Elements.selectElement(driver, photosPermissionNativeAllowAllCta, "Permission : Allow");
    }

    public void clickOnSonuQrCodeGallery() {
        Elements.selectElement(driver, albumTabSelector, "Selecting Album Tab");
        Elements.selectElement(driver,SonuQrAlbumSelect,"Selecting Sonu QR Album");
        Elements.selectElement(driver,selectAvailableImageInAlbum,"Selecting Photo in Album");
    }

    public void clickOnMBKQrCodeGallery() {
        Elements.selectElement(driver, albumTabSelector, "Selecting Album Tab");
        Elements.selectElement(driver,MobikwikQrAlbumSelect,"Selecting Sonu QR Album");
        Elements.selectElement(driver,selectAvailableImageInAlbum,"Selecting Photo in Album");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, amountField, amount, "Amount");
    }

    public void clickOnContinue() {
        Elements.selectElement(driver, continueCtaAmountPage, "Continue");
    }

    public void clickConfirmPayment() {
        Elements.waitForElementToVisibleOnPage(driver,ctaConfirmPayment, 2);
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
        return Elements.isElementPresent(driver, backButton);
    }

    public void clickBackButton() {
        Elements.selectElement(driver, backButton, "Close Icon");
    }

}
