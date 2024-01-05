package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.P2PExtraPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
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
        mbReporter = new MBReporter(driver);

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
        Thread.sleep(1000);
        p2PExtraPage.selectGetStarted();

    }



    public void referAndEarnFlow(String expTitle) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("Refer & Earn Flow");

        if(homePage.isXtraIconPresent()) {
            // Click on xtra icon on home page.
            homePage.clicktXtra();
        }
        else {
            homePage.clickAllServices();

            Screen.swipeUp(driver);
            // Click on xtra icon under All services
            p2PExtraPage.clickOnXtraIcon();
        }

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

        p2PExtraPage.clickKnowMoreOptn();
        String actualTitle = p2PExtraPage.getReferPageTitle();
        Log.info("TITLE : "+ actualTitle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Refer & Earn Flow", false, false, true);

    }




    public void withdraw(String amount, String expAmount, String expTitle, String expErrorMainTitle, String expErrorTitle, String expErrorAmount) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        if(homePage.isXtraIconPresent()) {
            // Click on xtra icon on home page.
            homePage.clicktXtra();
        }
        else {
            homePage.clickAllServices();

            Screen.swipeUp(driver);
            // Click on xtra icon under All services
            p2PExtraPage.clickOnXtraIcon();
        }
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

            mbReporter.verifyEqualsWithLogging(actualErrorMainTitle,expErrorTitle,"Withdrawl in Progress Bottomsheet ", false,true);

        } else {

            Log.info("You have successfully placed withdrawal request");

            String actualTitle = p2PExtraPage.getSuccessTitle();

            mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title On Success Page", false, false,true);

        }

    }




    public void setDefaultBankAccountFlow(String expSubTitle, String expectedNomineeName) throws InterruptedException, IOException {

        if(homePage.isXtraIconPresent()) {
            // Click on xtra icon on home page.
            homePage.clicktXtra();
        }
        else {
            homePage.clickAllServices();

            Screen.swipeUp(driver);
            // Click on xtra icon under All services
            p2PExtraPage.clickOnXtraIcon();
        }

        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();

        Screen.swipeUp(driver);

        if(p2PExtraPage.checkSettingOptn())
        {
            Screen.swipeUp(driver);
        }

        p2PExtraPage.clickSettingOptn();

        p2PExtraPage.clickNomineeOptn();

        String actualNomineeName = p2PExtraPage.getNomineeName();
        Log.info(actualNomineeName);

        mbReporter.verifyEqualsWithLogging(actualNomineeName, expectedNomineeName, "Verify Title On Success Page", false, false,true);



    }




    public void investInFlexi(String expTitle) throws InterruptedException, IOException {


        if(homePage.isXtraIconPresent()) {
            // Click on xtra icon on home page.
            homePage.clicktXtra();
        }
        else {
            homePage.clickAllServices();

            Screen.swipeUp(driver);
            // Click on xtra icon under All services
            p2PExtraPage.clickOnXtraIcon();
        }
        // Click on Skip button
        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();

        // Click on Invest More Button
        p2PExtraPage.clickInvestMoreBtn();

        // Click on Invest Now
        p2PExtraPage.clickInvestNowBtn();

        // Click on NetBanking
        while(!p2PExtraPage.checkNetBankingOptn()){
            Thread.sleep(1000);
        }

        p2PExtraPage.clickNetBanking();

        // Click on Axis Bank
        p2PExtraPage.clickAxisBankOptn();

        // Click on Allow While Using App option if present
        Thread.sleep(2000);

//        while(!p2PExtraPage.checkLocationpopup()){
//            Thread.sleep(1000);
//
//            if(p2PExtraPage.checkLocationpopup()){
//
//                p2PExtraPage.clickAllow();
//
//                Thread.sleep(1000);
//
//                p2PExtraPage.clickOK();
//            }
//        }
        String actualTitle = p2PExtraPage.getTitle();
        Log.info("TITLE : "+actualTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title On Payments Page", false, false,true);

    }





    public void investInFixed(String expTitle) throws InterruptedException, IOException {


        if(homePage.isXtraIconPresent()) {
            // Click on xtra icon on home page.
            homePage.clicktXtra();
        }
        else {
            homePage.clickAllServices();

            Screen.swipeUp(driver);
            // Click on xtra icon under All services
            p2PExtraPage.clickOnXtraIcon();
        }

        // Click on Skip button
        Thread.sleep(2000);
        if(p2PExtraPage.checkSkipReminder()) p2PExtraPage.selectSkipReminder();

        // Click on Invest More Button
        p2PExtraPage.clickInvestMoreBtn();

        // Click on Plus Option
        p2PExtraPage.clickPlus();

        //Click on Invest Now button
        p2PExtraPage.clickInvestNowBtn();

        // Click on Proceed to Pay button
        p2PExtraPage.clickProceedToPayBtn();

        // Click on NetBanking
        while(!p2PExtraPage.checkNetBankingOptn()){
            Thread.sleep(1000);
        }

        // Click on Netbanking
        p2PExtraPage.clickNetBanking();

        // Click on Axis Bank
        p2PExtraPage.clickAxisBankOptn();

        Thread.sleep(2000);

        String actualTitle = p2PExtraPage.getTitle();
        Log.info("TITLE : "+actualTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title On Payments Page", false, false,true);


    }










}
