package test.java.AndroidApp.Helpers;

import UITestFramework.MBKCommonControls;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Config;
import main.java.utils.TestDataReader;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.FiveStarRatingPage;
import test.java.AndroidApp.PageObject.GoldPage;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.util.HashMap;

public class RatingPageHelper {

    AndroidDriver driver;
    HomePage homePage;
    public static HashMap<String, String> map;
    GoldPage goldPage;
    FiveStarRatingPage fiveStarRatingPage;
    MBReporter mbReporter;
    MBKCommonControls mbkCommonControls;

    public RatingPageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControls = new MBKCommonControls(driver);
    }

    public void ratingGold(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        goldPage = homePage.clickGoldIcon();

        goldPage.clickOnBuyGold();

        goldPage.enterAmount();

        goldPage.clickOnBuyGold();

        goldPage.applyPromoCode();

        goldPage.clickOnMakePaymentCta();

        mbkCommonControls.handleSecurityPin("121212");
        Thread.sleep(3000);

        fiveStarRatingPage = goldPage.clickOnSuccessPageCross();

        boolean status = fiveStarRatingPage.isRatingPopUpDisplayed();

        mbReporter.verifyTrue(status, "Verify if Rating Pop Up is Displayed", false, false);

        if (status) {
            fiveStarRatingPage.clickOnMaybeLater();
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
