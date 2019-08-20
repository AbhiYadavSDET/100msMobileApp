package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;

import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.ImpsPage;
import test.java.AndroidApp.PageObject.P2MPage;

import java.io.IOException;
import java.util.HashMap;

public class ImpsHelper {

    IOSDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    P2MPage p2mPage;
    PermissionHelper permissionHelper;
    ImpsPage impsPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public ImpsHelper(IOSDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new ImpsPage(driver);

    }


    public void verifyImps(String accountName, String accountNo, String ifsc, String amount) throws InterruptedException, IOException, JSONException {
        //driver.navigate().back();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        impsPage.clickOnViaWallet();

        impsPage.clickOnWalletToBank();

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUpLess(driver);


        // Enter the bank details
        impsPage.enterBeneficiaryName(accountName);
        impsPage.enterAccountNo(accountNo);
        impsPage.enterIfsc(ifsc);


        impsPage.clickOnCtaContinue();

        impsPage.sendAmount(amount);
        Thread.sleep(5000);

        impsPage.clickOnContinue();

        impsPage.clickOnConfirm();

        mbkCommonControlsHelper.handleSecurityPin("123456");
        Thread.sleep(5000);

        // Enter the OTP
        Log.info("Enter the OTP");
        Thread.sleep(30000);

        //Assertion on the success page
        //fetch the values
        String actualMessage = impsPage.getSuccessMessage();
        String actualAccountNo = impsPage.getSuccessPageAccountNo();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        mbReporter.verifyEqualsWithLogging(actualMessage, "Money sent successfully", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAccountNo, accountNo, "Success Page | Account No", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "X50.0", "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

    }


}
