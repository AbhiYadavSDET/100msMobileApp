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



    public void investInFlexi(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

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


        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        //Click on tooltip of XTRA Plus If comes
        if(p2PExtraPage.checkOkfromPlusPopUp()) p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFlexiFromNavBar();

        //USed to click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        //Select NetBanking from XTRA checkout screen
        p2PExtraPage.selectNBOnCheckoutScreen();

        //Select Axis Bank in NetBanking
        p2PExtraPage.selectAxisBankInNB();

        Log.info("You  have invested in FLEXI via NB ");

    }






    public void investInFixed(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

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


        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        //Click on tooltip of XTRA Plus If comes
        if(p2PExtraPage.checkOkfromPlusPopUp()) p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFixedFromNavBar();

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        //Click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        //Select NetBanking from XTRA checkout screen
        p2PExtraPage.selectNBOnCheckoutScreen();

        //Select Axis Bank in NetBanking
        p2PExtraPage.selectAxisBankInNB();

        Log.info("You  have invested in FIXED via NB ");

    }






    public void newUserFlow(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();


        if (mbkCommonControlsPage.isWhitePopUpPresent()) {
            mbkCommonControlsPage.closeWhitePopUp();
        }

        // Click on Got it to remove referral bottom sheet.
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();

        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
        String perDayEarning = p2PExtraPage.getPerDayEarning();
        Log.info("Portfolio Value : " + portfolioValue);
        Log.info("Per Day Earning : " + perDayEarning);


        //Click on Get Started button on XTRA Pitch Page
        p2PExtraPage.selectInvestMore();

        //For NON-KYCED User Flow
        if (p2PExtraPage.isKYCBottomSheetPresent()) {

            //Click Proceed button on Complete KYC bottomsheet
            p2PExtraPage.selectInvestMore();


        }

    }







        public void referAndEarnFlow(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

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
            String perDayEarning = p2PExtraPage.getPerDayEarning();
            Log.info("Portfolio Value : " + portfolioValue);
            Log.info("Per Day Earning : " + perDayEarning);


            //Swipe till Refer & Earn Widget
            screen.swipeUpMore(driver);

            // Click on Refer & earn Widget on XTRA dashboard
            p2PExtraPage.clickReferAndEarnWidget();

            //Swipe up complete on Total Earnings Page
            screen.swipeUpMore(driver);

            // Click on Earnings table
            p2PExtraPage.clickEarningsTable();

            //Swipe up complete on Referrals Page
            screen.swipeUpMore(driver);




    }




    public void setDefaultBankAccount(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        if(mbkCommonControlsPage.isWhitePopUpPresent()){ mbkCommonControlsPage.closeWhitePopUp(); }

        // Click on Got it to remove referral bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();




        //Swipe till the bottom | Settings Option
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);

        //Click on Settings option on XTRA dashboard
        p2PExtraPage.clickSettings();


        //If Default Bank Account is already setup
        if(!p2PExtraPage.checkAddBankOptn())
        {
            //Click on Default Bank Account
            p2PExtraPage.clickDefaultBankAccount();

            //Wait for 1 sec
            Thread.sleep(1000);

            // Click on cancel button to remove bottom sheet
            p2PExtraPage.clickCancelBtn();

        } else {

            //Click on Add Bank Option
            p2PExtraPage.clickAddBankBtn();

            //Click on Back Button
            p2PExtraPage.clickBackBtn();

        }


        //If Nominee is already setup
        if(!p2PExtraPage.checkAddNomineeOptn()){

            // Select Nominee from Settings option
            p2PExtraPage.clickNominee();


        } else {

            //Click on Add Nominee Option
            p2PExtraPage.clickAddNominee();

            //Click on Back Button
            p2PExtraPage.clickBackBtn();

        }



    }




    public void reinvest(String amount, String expAmount, String expStatus) throws InterruptedException, IOException {

        Log.info("----------- Arguments ---------------");


        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        if(mbkCommonControlsPage.isWhitePopUpPresent()){ mbkCommonControlsPage.closeWhitePopUp(); }

        // Click on Got it to remove referral bottom sheet.
        if(p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        // Click on screen to remove bottom sheet.
        // p2PExtraPage.tapOutsideBottomSheet();




        //Swipe till the bottom | Settings Option
        screen.swipeUpMore(driver);


        //Click on first fixed investment
        p2PExtraPage.click1stFixedInvestment();

        //Wait for 3 seconds
        Thread.sleep(3000);

        //Click on On-Maturity Option
        //If User already selected reinvest while investing
        if(p2PExtraPage.checkReinvestBtn()){

            //Click on Re-invest Option
            p2PExtraPage.selectReinvestBtn();

            //Wait for 2 seconds
            Thread.sleep(2000);

            //Change to Transfer to Flexi Option
            p2PExtraPage.selectTransferToFlexioption();

            //Wait for 3 seconds
            Thread.sleep(3000);


        } else {
            //If User already selected transfer to flexi  while investing
            //Click on Transfer to Flexi Option
            p2PExtraPage.selectTransferToFlexiBtn();

            //Wait for 2 seconds
            Thread.sleep(2000);

            //Change to Reinvest option
            p2PExtraPage.selectReinvestoption();

            //Wait for 3 seconds
            Thread.sleep(3000);

        }









    }














}