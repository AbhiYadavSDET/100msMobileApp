package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.P2PExtraPage;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PExtraHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    MBReporter mbReporter;


    public P2PExtraHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        p2PExtraPage = new P2PExtraPage(driver);

    }

    public void newUserFlow(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("Expected Title : " + expTitle);

        // Click on xtra icon on home page.
        homePage.clicktXtra();

        // Click on Got it to remove referral bottom sheet.
        // Thread.sleep(1000);
        // if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Get Started button on XTRA Pitch Page
        p2PExtraPage.selectGetStarted();
//
//        //For NON-KYCED User Flow
//        if (p2PExtraPage.isKYCBottomSheetPresent()) {
//
//            String Kyc_status_title = p2PExtraPage.getKycBottomsheetTitle();
//            Log.info("KYC STATUS : " + Kyc_status_title);
//
//            // Add the assertions
//            mbReporter.verifyEqualsWithLogging(Kyc_status_title, expTitle, "Verify New User Flow", false, false, true);
//
//            //Click Proceed button on Complete KYC bottomsheet
//            //p2PExtraPage.selectProceedKYC();
//
//        }

    }



    public void referAndEarnFlow(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("Refer & Earn Flow");

        // Click on xtra icon on home page.
        homePage.clicktXtra();
//        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
//            mbkCommonControlsPage.closeWhitePopUp();
//        }
        // Click on Got it to remove referral bottom sheet.
        // if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        // Skip the daily SIP Reminder on XTRA Dashboard
        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();



        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
        Log.info("Portfolio Value : " + portfolioValue);




//        // If notification alerts are present, then swipe up
//        if (p2PExtraPage.checkNotificationAlert() || p2PExtraPage.checkInvestContainer()) screen.swipeUpMedium(driver);
//
//        //Swipe till Refer & Earn Widget
//        screen.swipeUpMore(driver);
//
//        // Check for more swipe if not visible
//        if (!p2PExtraPage.checkReferralWidget()) screen.swipeUpLess(driver);
//
//        // Click on Refer & earn Widget on XTRA dashboard
//        p2PExtraPage.clickReferAndEarnWidget();
//
//        //Swipe up complete on Total Earnings Page
//        screen.swipeUpMore(driver);
//
//        // Click on Earnings table
//        p2PExtraPage.clickEarningsTable();
//
//        //Swipe up complete on Referrals Page
//        screen.swipeUpMore(driver);
//
//        //Select Back button
//        p2PExtraPage.selectBackBtn();
//
//        String check_know_more_optn = p2PExtraPage.getKnowMoreOptn();
//
//        Log.info("Text Check :" + check_know_more_optn);
//
//        // Add the assertions
//        mbReporter.verifyEqualsWithLogging(check_know_more_optn, expTitle, "Verify Refer & Earn Flow", false, false, true);


    }


    public void withdraw(String amount, String expAmount, String expStatus, String expErrorMainTitle, String expErrorTitle, String expErrorAmount) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        homePage.clicktXtra();

        // Click on Withdraw button of Flexi
        p2PExtraPage.clickWithdrawCta();

        //Check One time Withdrawl Bottomsheet
        if(p2PExtraPage.checkOneTimeWithdrawBottomsheet()) p2PExtraPage.clickGotItCta();

        //Enter Amount
        p2PExtraPage.enterAmount(amount);

        // Click on Withdraw button
        p2PExtraPage.clickWithdrawBtn();

       // mbReporter.verifyEqualsWithLogging();


    }








}
