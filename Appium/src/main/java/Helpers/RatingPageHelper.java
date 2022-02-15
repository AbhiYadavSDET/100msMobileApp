package Helpers;
/*
import PageObject.FiveStarRatingPage;
import PageObject.GoldPage;
import PageObject.HomePage;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import utils.Config;
import utils.Screen;
import utils.TestDataReader;

import java.io.IOException;
import java.util.HashMap;

public class RatingPageHelper {

    AndroidDriver driver;
    HomePage homePage;
    TouchAction touchAction;
    public static HashMap<String, String> map;
    GoldPage goldPage;
    FiveStarRatingPage fiveStarRatingPage;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    public RatingPageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        touchAction = new TouchAction(driver);

        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }

    public void ratingGold(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);
        homePage.clickOnCrossButton();

        // Swipe the homescreen up
        Thread.sleep(2000);
        new Screen(driver).swipeUp();

        homePage.clickInvestmentAndInsuranceLayout();
        goldPage = homePage.clickGoldIcon();
        Thread.sleep(3000);

        goldPage.clickOnBuyGold();

        goldPage.enterAmount("1");

        goldPage.clickBuyNowCta();

        mbkCommonControlsHelper.applyPromoCodeGold(map.get("coupon"));

        goldPage.clickOnMakePaymentCta();

        mbkCommonControlsHelper.handleSecurityPin(LoginHelper.map.get("securityPin"));
        Thread.sleep(3000);

        FiveStarRatingPage fiveStarRatingPage = new FiveStarRatingPage(driver);
        boolean status1 = fiveStarRatingPage.isRatingPopUpDisplayed();

        if (status1) {
            // Assert for the 5 stars to be displayed
            mbReporter.verifyEqualsWithLogging(status1, status1, "Verify Rating Pop Up is Displayed before cross icon", false, false);
            fiveStarRatingPage.clickOnMaybeLater();
        } else {

            fiveStarRatingPage = goldPage.clickOnSuccessPageCross();

            boolean status2 = fiveStarRatingPage.isRatingPopUpDisplayed();

            if (status2) {
                // Assert for the 5 stars to be displayed
                mbReporter.verifyEqualsWithLogging(status2, status2, "Verify Rating Pop Up is Displayed after cross icon", false, false);
                fiveStarRatingPage.clickOnMaybeLater();
            }
        }
    }


    public void fetchDataFromSheet(int rownum) {
        map = new HashMap<String, String>();
        TestDataReader testData = Config.getCachedTestDataReaderObject("rating");
        map.put("description", testData.GetData(rownum, "description"));
        map.put("amount", testData.GetData(rownum, "amount"));
        map.put("coupon", testData.GetData(rownum, "coupon"));

    }


}


 */