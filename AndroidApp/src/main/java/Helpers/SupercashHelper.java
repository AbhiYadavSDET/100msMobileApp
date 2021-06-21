package Helpers;

import PageObject.HomePage;
import PageObject.SupercashStatementPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class SupercashHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    SupercashStatementPage supercashStatementPage;
    public static HashMap<String, String> supercashBalance;

    public SupercashHelper(AndroidDriver driver) throws InterruptedException, IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        supercashStatementPage = new SupercashStatementPage(driver);
    }

    public void verifySupercash() throws InterruptedException, IOException, JSONException{
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        supercashBalance =  mbkCommonControlsHelper.getBalance();
        Double actualBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(supercashBalance, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Thread.sleep(5000);
        supercashStatementPage.clickWalletButton();
        supercashStatementPage.clickStatementButton();


        Thread.sleep(3000);
        //Storing supercash balance in a variable (from supercash page)
        String str = supercashStatementPage.getPointsBalance();
        String substr = str.substring(2);
        double supercash = Double.parseDouble(substr) * 100;

        Thread.sleep(3000);
        supercashStatementPage.switchToHistoryTab();
        screen.swipeUpLess(driver);

        supercashStatementPage.switchToSummaryTab();
        screen.swipeUpMedium(driver);

        supercashStatementPage.clickOnFAQ();
        driver.navigate().back();

        supercashStatementPage.clickOnRedeemButton();
        screen.swipeUpMedium(driver);
        supercashStatementPage.clickOnOfferButton();
        driver.navigate().back();


        //Assertions

        mbReporter.verifyEqualsWithLogging(actualBalance, supercash, "Supercash is same on both pages", false, false);

    }
}
