package Helpers;

import PageObject.AmexPage;
import PageObject.HomePage;
import PageObject.SideDrawerPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.*;

import java.io.IOException;
import java.util.HashMap;

public class AmexHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    SideDrawerPage sideDrawerPage;
    AmexPage amexPage;


    public AmexHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        amexPage=new AmexPage(driver);

    }



    public void validateAmexFlow() throws IOException, InterruptedException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (Element.isElementPresent(driver, By.id("tx_add_money"))) {

            sideDrawerPage = homePage.clickHamburgerIcon();

            amexPage=sideDrawerPage.clickOnAmexPage();

            Element.waitForVisibility(driver, By.id("img_card_front"));

            mbReporter.verifyTrueWithLogging(amexPage.getNameOnCard(), "Is Name on Card Visible", false, false);

            String actualOfferText= amexPage.getOfferText();

            mbReporter.verifyEqualsWithLogging(actualOfferText, "Earn 1% SuperCash on every transaction","Are offers Visible", false, false);

            amexPage.selectAmexCard();

            String actualOtpText= amexPage.getOtpText();

            mbReporter.verifyEqualsWithLogging(actualOtpText, "Tap card to view OTP and card details","Is Otp Widget Loaded", false, false);

            amexPage.selectTransactionHistory();

            boolean trxHistory=Element.isElementPresent(driver, By.id("recycler_view"));

            mbReporter.verifyTrueWithLogging(trxHistory, "Trx History Opened", false, false);

            amexPage.closeDropdown();

            amexPage.clickOnBackButton();




        }
    }
}
