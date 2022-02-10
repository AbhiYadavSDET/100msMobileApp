package Helpers;

import PageObject.HomePage;
import PageObject.MutualFundPage;
import PageObject.WalletBalancePage;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class MutualFundsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    MutualFundPage mutualFundPage;
    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;
    WalletBalancePage walletBalancePage;


    public MutualFundsHelper(AndroidDriver driver) throws IOException {
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        this.driver = driver;
    }

    public void mutualFundsVerification() throws InterruptedException, IOException, JSONException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        // Swipe the homescreen up
        Thread.sleep(2000);

        homePage.clickInvestmentAndInsuranceLayout();
        mutualFundPage = homePage.clickMutualFunds();
        Element.waitForVisibility(driver, By.id("tv_title"));



        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Wealth Portfolios']"))){

            mutualFundPage.clickOnWealthPortfolios();
            String actualLabelText= mutualFundPage.getLabelText();
            mbReporter.verifyEqualsWithLogging(actualLabelText, "Recommended wealth portfolios for you", "Wealth Postfolio Page opened.", false, false);
            mutualFundPage.clickOnBackButton();

            Thread.sleep(1000);

            mutualFundPage.clickOnKwikSave();
            String actualTitleText= mutualFundPage.getTitleText();
            mbReporter.verifyEqualsWithLogging(actualTitleText, "Why Kwik Save is good for you", "Kwik Save Page opened.", false, false);
            mutualFundPage.clickOnBackButton();

            Thread.sleep(1000);

            mutualFundPage.clickOnMonthlySip();
            String actualRiskBaseTitle= mutualFundPage.getRiskBaseTitle();
            mbReporter.verifyEqualsWithLogging(actualRiskBaseTitle, "My investment approach is:", "Star a SIP Page opened.", false, false);
            mutualFundPage.clickOnBackButton();

            Thread.sleep(1000);

            mutualFundPage.clickOnOneTimeInvestment();
            String actualTitleLumpsumInvestmentPage= mutualFundPage.getHeaderTitleText();
            mbReporter.verifyEqualsWithLogging(actualTitleLumpsumInvestmentPage, "Invest One-Time", "Invest One-Time Page opened.", false, false);
            mutualFundPage.clickOnBackButton();

            Thread.sleep(1000);

            mutualFundPage.clickOnElssMutualFunds();
            String actualTitleElssPage= mutualFundPage.getHeaderTitleText();
            mbReporter.verifyEqualsWithLogging(actualTitleElssPage, "Top ELSS Funds", "ELSS Page opened.", false, false);
            mutualFundPage.clickOnBackButton();

            Thread.sleep(1000);


            mutualFundPage.clickOnBackButton();

            mbkCommonControlsHelper.dismissAllOnHomePage(driver);

            homePage.closeInvestmentsBottomSheet();


        }else {

            boolean isVisible = false;
            // Check for the 1st element
            if (mutualFundPage.isViewAllFunds()) {
                isVisible = true;
            }
            // Check for the 2nd element
            if (mutualFundPage.isVisibleGrowthImage()) {
                isVisible = true;
            }

            // Verify by putting assertion
              mbReporter.verifyEqualsWithLogging(isVisible, true, "Verify if the Element is present", false, false);

              mutualFundPage.clickOnBackButton();

              mbkCommonControlsHelper.dismissAllOnHomePage(driver);

              homePage.closeInvestmentsBottomSheet();

        }

    }

}