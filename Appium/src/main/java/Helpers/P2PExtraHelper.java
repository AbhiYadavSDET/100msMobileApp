package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.P2PExtraPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;


public class P2PExtraHelper {

    AndroidDriver driver;
    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    Screen screen;
    Element element;
    MBReporter mbReporter;
    MbkCommonControlsPage mbkCommonControlsPage;


    public P2PExtraHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        p2PExtraPage = new P2PExtraPage(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);

    }

    public void withdraw(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();


        if(mbkCommonControlsPage.isWhitePopUpPresent()){ mbkCommonControlsPage.closeWhitePopUp(); }

        // Click on Got it to remove referral bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
//        String investedAmount = p2PExtraPage.getInvestedAmount();
//        String earnedAmount = p2PExtraPage.getEarnedAmount();
        String perDayEarning = p2PExtraPage.getPerDayEarning();

        Log.info("Portfolio Value : " + portfolioValue);
//        Log.info("Invested Amount : " + investedAmount);
//        Log.info("Earned Amount : " + earnedAmount);
        Log.info("Per Day Earning : " + perDayEarning);

        // Click on withdraw on Xtra main page.
        p2PExtraPage.selectWithdraw();

        // Click on Got it to remove one time withdrawal bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on Got it to remove bank holiday bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Enter amount on withdrawal amount page.
        p2PExtraPage.enterAmount(amount);

        //Click on withdraw on withdrawal amount page.
        p2PExtraPage.selectWithdrawOnWithdrawAmount();

        //Click on withdraw on bottom sheet.
        p2PExtraPage.selectWithdrawOnBottomSheet();

        // Checking pending withdrawal request bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()){

            Log.info("You allready have pending withdrawal request");

        }

        else{

            // Verification on the Success Screen
            String actualAmount = p2PExtraPage.getWithdrawalAmount();
            String actualStatus = p2PExtraPage.getWithdrawalStatus();

            // Display the values
            Log.info("Withdrawal amount : " + actualAmount);
            Log.info("Withdrawal status : " + actualStatus);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(actualAmount, expAmount, "Verify Withdrawal amount", false,false,true);
            mbReporter.verifyEqualsWithLogging(actualStatus, expStatus, "Verify Withdrawal status", false,false,true);

        }


    }

}