package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.P2MPage;

import java.io.IOException;
import java.util.HashMap;

public class P2MHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    P2MPage p2mPage;
    PermissionHelper permissionHelper;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public P2MHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }


    public void p2mSendMoney(String merchantCode, String amount, String securityPin, String successPageStatus, String successPageName) throws InterruptedException, IOException, JSONException {
        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        p2mPage = homePage.clickOnButtonPayToMerchant();

        permissionHelper.permissionAllow();

        p2mPage.clickOnLabelEnterMerchantCode();

        permissionHelper.permissionAllow();

        p2mPage.enterMerchantCode(merchantCode);

        Thread.sleep(3000);

        p2mPage.clickOnMerchantCodeFromList();

        p2mPage.enterAmount(amount);

        p2mPage.clickOnCtaConfirmTransfer();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        // Assertion on the success screen
        String actualSuccessScreenStatus = p2mPage.getSuccessPageStatus();
        String actualSuccessScreenName = p2mPage.getSuccessPageName();
        String actualSuccessScreenCode = p2mPage.getSuccessPageCode();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, successPageStatus, "Success Screen | Verify Status", false, false);
        //mbReporter.verifyEqualsWithLogging(actualSuccessScreenName.toUpperCase(), successPageName.toUpperCase(), "Success Screen | Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenCode.toLowerCase(), merchantCode.toLowerCase(), "Success Screen | Verify Code", false, false);

        // Test
        Thread.sleep(5000);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

    }


}
