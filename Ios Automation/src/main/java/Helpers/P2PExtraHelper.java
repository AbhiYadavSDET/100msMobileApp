package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.P2PExtraPage;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.TouchAction;
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

        // Skip the daily SIP Reminder on XTRA Dashboard
        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();

        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
        Log.info("Portfolio Value : " + portfolioValue);

        //Swipe Up the screen
        Screen.swipeUp(driver);
        Screen.swipeUp(driver);

        //Click on the Refer widget
        p2PExtraPage.clickReferWidget();

        //Click OK on Access your contacts popup
        p2PExtraPage.clickAllowContactPermission();

        Thread.sleep(1000);
        if(p2PExtraPage.checkPopup()){
            p2PExtraPage.clickOKFromPopup();
        }

//        //Click on Earnings Table
//        p2PExtraPage.clickEarningsTable();
//
//        //Click on back button
//        p2PExtraPage.clickBackBtn();

        String actualTitle = p2PExtraPage.getReferPageTitle();
        Log.info(actualTitle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Refer & Earn Flow", false, false, true);


    }




    public void withdraw(String amount, String expAmount, String expTitle, String expErrorMainTitle, String expErrorTitle, String expErrorAmount) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        homePage.clicktXtra();

        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();


        // Click on Withdraw button of Flexi
        p2PExtraPage.clickWithdrawCta();

        //Check One time Withdrawl Bottomsheet
        if(p2PExtraPage.checkOneTimeWithdrawBottomsheet()) {
            p2PExtraPage.clickGotItCta();
            if(p2PExtraPage.checkBankHolidayBottomsheet()) p2PExtraPage.clickGotItCta();
        }

        //Enter Amount
        p2PExtraPage.enterAmount(amount);

        Thread.sleep(2000);

        // Click on Withdraw button
        p2PExtraPage.clickWithdrawBtn();

        // Click on Confirm button
        p2PExtraPage.clickConfirmBtn();

        //Checking pending withdrawal request bottom sheet
        if (p2PExtraPage.checkWithdrawlInProgressBottomsheet()) {

            String actualErrorMainTitle = p2PExtraPage.getErrorTitleText();

            Log.info("You have already one pending withdrawal request");
            Log.info("ERROR_TITLE : " + actualErrorMainTitle);

            p2PExtraPage.clickGotItOnInprogressCta();

            mbReporter.verifyEqualsWithLogging(actualErrorMainTitle,expErrorMainTitle,"Withdrawl in Progress Bottomsheet ", false,true);

        } else {

            Log.info("You have successfully placed withdrawal request");

            String actualTitle = p2PExtraPage.getSuccessTitle();

            mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title On Success Page", false, false,true);

        }

    }




    public void setDefaultBankAccountFlow(String expSubTitle) throws InterruptedException, IOException {

        // Click on xtra icon on home page.
        homePage.clicktXtra();

        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();

        Screen.swipeUp(driver);

        if(p2PExtraPage.checkSettingOptn())
        {
            Screen.swipeUp(driver);
        }

        p2PExtraPage.clickSettingOptn();



    }








}
