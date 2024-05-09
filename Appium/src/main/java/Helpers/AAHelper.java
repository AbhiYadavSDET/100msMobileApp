package Helpers;

import Logger.Log;
import PageObject.AccountAggregatorPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;


public class AAHelper {
    AndroidDriver<AndroidElement> driver;


    AccountAggregatorPage aaPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    //  mbReporter = new MBReporter(driver);
    //  mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    //     PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    //   PermissionPage permissionPage;


    public AAHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        aaPage = new AccountAggregatorPage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbReporter = new MBReporter(driver);

    }

    /**
     * This method is to Test standalone Account aggregator flow from Wealth dashboard
     */
    public void existingUser(String expTitleOnCategoryPage,String expmoneyinTitle, String expMoneyoutTitleOnDashboard,String expOutgoingSecondSubTitleOnDashboard) throws InterruptedException, IOException {

        if (Element.isElementPresent(driver, By.id("tx_balance"))) {

            // Click on All services to see money plus icon
            aaPage.allServicesCTA();

            Log.info("START", "Account Aggregator");
            Log.info("AA flow for existing user");
            Log.info("-------------------------------------");

            aaPage.scrollTotrackBankAccounts();
            aaPage.clickOnTrackBankAccounts();

            Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));

            Elements.tapByCoordinates(57,916,driver);

            if (Element.isElementPresent(driver, By.xpath("//*[@text='Cashflow']"))) {

                // Fetch the other text on the screen
                String moneyoutTitleOnDashboard = aaPage.getOutgoingTitle();
                String outgoingSecondSubTitleOnDashboard = aaPage.getOutgoingSecondSubTitle();

                Log.info("OutGoing Title :" + moneyoutTitleOnDashboard);
                Log.info("Second Sub Title :" + outgoingSecondSubTitleOnDashboard);

                // Add assertions
                mbReporter.verifyEqualsWithLogging(moneyoutTitleOnDashboard, expMoneyoutTitleOnDashboard, "Verify Outgoing Title on MainDashboard", false, false, true);
                mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false, true);

            }

            else {
                Log.info("Outgoing Data is not present");
            }

                // Add the assertions
                aaPage.scrollTomoneyinTitle();
                aaPage.moneyinTitle();
                String moneyInTTitle = aaPage.moneyinTitle();
                Log.info("Money In Title : " + expmoneyinTitle);
                mbReporter.verifyEqualsWithLogging(moneyInTTitle, expmoneyinTitle, "Verify Money In title", false, false, true);
                aaPage.scrollToReferYourFriend();
                aaPage.scrolltoManage();

        }

    }

    //User Monthly Summery
    /*public void existingUserMonthlySummary(String expTitleLastmonthIncoming, String expTitleLastmonthOutgoing, String expTitleLastmonthinvested, String expTitleLastmonthRemaining, String expTitleLastmonthSpendbycayegoryOutgoing, String expExpensesSpendbycategory, String expSipEmiSpendbycategory, String expBankChargesSpendbycategory, String expOthersSpendbycategory, String expHighestSpendonMontlysummary, String expgetTopCategoryMontlysummary, String expSpenbyDatedonMontlysummary, String expMoneyReceived) throws InterruptedException, IOException {

        aaPage.allServicesCTA();

        int count = 0;

        while(!aaPage.checkTrackbankAccountsCTA() && count < 3){
            screen.swipeUpMore(driver);
            count++;
        }

        aaPage.trackBankAccountsCTA();
        Thread.sleep(2000);

        if (aaPage.isOutgoingTitlePresent()) {
            screen.swipeUpMore(driver);
        }
        else
        {
            aaPage.clickMonthlySummaryOnHomePage();
            Log.info("Click On Monthly Summary bar on Home Page : ");
            Thread.sleep(2000);

            mbReporter.verifyTrueWithLogging(aaPage.getCalender(), "Verify Monthly calender is present on monthly page", false, false);
            Thread.sleep(2000);
            mbReporter.verifyTrueWithLogging(aaPage.getIncomingOnMonthlySummary(), "Verify Incoming Value", false, false);

            String incomingtextOnMonthlySummary = aaPage.getIncomingtextOnMonthlySummary();
            String outgoingtextOnMonthlySummary = aaPage.getOutingtextOnMonthlySummary();

            Log.info("Incoming Title on monthly summary page: " + expTitleLastmonthIncoming);
            Log.info("Outgoing Title on monthly summary page: " + expTitleLastmonthOutgoing);

            mbReporter.verifyEqualsWithLogging(incomingtextOnMonthlySummary, expTitleLastmonthIncoming, "Incoming Title on monthly summary page:", false, true, true);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummary, expTitleLastmonthOutgoing, "Outging Title on monthly summary page:", false, false, true);

            if (aaPage.IsInvestedtextOnMonthlySummaryVisible())
            {
                String investedtextOnMonthlySummary = aaPage.getInvestedtextOnMonthlySummary();

                Log.info("Invested Title on monthly summary page: " + expTitleLastmonthinvested);

                mbReporter.verifyEqualsWithLogging(investedtextOnMonthlySummary, expTitleLastmonthinvested, "Invested Title on monthly summary page:", false, true, true);
            }

            String remaingtextOnMonthlySummary = aaPage.getRemaingtextOnMonthlySummary();
            String outgoingtextOnMonthlySummarySpendbycategory = aaPage.getOutgoingtextOnMonthlySummarySpendbycategory();
            String expensesSpendbycategory = aaPage.getExpensesSpendbycategory();
            String sipEmiSpendbycategory = aaPage.getSipEmiSpendbycategory();
            String bankChargesSpendbycategory = aaPage.getBankChargesSpendbycategory();
            String otherssSpendbycategory = aaPage.getOthersSpendbycategory();

            Log.info("Remainging Title on monthly summary page: " + expTitleLastmonthRemaining);
            Log.info("Outing Title on monthly summary page Spend by category section: " + expTitleLastmonthSpendbycayegoryOutgoing);
            Log.info("Spend By category First title: " + expExpensesSpendbycategory);
            Log.info("Spend By category Second title: " + expSipEmiSpendbycategory);
            Log.info("Spend By category third title: " + expBankChargesSpendbycategory);
            Log.info("Spend By category fourth title: " + expOthersSpendbycategory);

            mbReporter.verifyEqualsWithLogging(remaingtextOnMonthlySummary, expTitleLastmonthRemaining, "Remaining Title on monthly summary page:", false, false, true);
            mbReporter.verifyEqualsWithLogging(outgoingtextOnMonthlySummarySpendbycategory, expTitleLastmonthSpendbycayegoryOutgoing, "Remaining Title on monthly summary page:", false, false, true);
            mbReporter.verifyEqualsWithLogging(expensesSpendbycategory, expExpensesSpendbycategory, "Spend By category First title", false, false, true);
            mbReporter.verifyEqualsWithLogging(sipEmiSpendbycategory, expSipEmiSpendbycategory, "Spend By category Second title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(bankChargesSpendbycategory, expBankChargesSpendbycategory, "Spend By category third title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(otherssSpendbycategory, expOthersSpendbycategory, "Spend By category fourth title:", false, false, true);

            screen.swipeUpMore(driver);

            String spendbyDatedonMontlysummary = aaPage.getSpenbyDatedonMontlysummary();
            String highestSpendonMontlysummary = aaPage.getHighestSpendonMontlysummary();
            String topCategoryMontlysummary = aaPage.getTopCategoryMontlysummary();

            Log.info("Spend By Date graph  title: " + expSpenbyDatedonMontlysummary);
            Log.info("Highest Spend card Title " + expHighestSpendonMontlysummary);
            Log.info("Top category on Monthly summary card title " + expgetTopCategoryMontlysummary);

            mbReporter.verifyEqualsWithLogging(spendbyDatedonMontlysummary, expSpenbyDatedonMontlysummary, "Spend By Date graph  title:", false, false, true);
            mbReporter.verifyEqualsWithLogging(highestSpendonMontlysummary, expHighestSpendonMontlysummary, "Highest Spend card Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(topCategoryMontlysummary, expgetTopCategoryMontlysummary, "Top category on Monthly summary card title ", false, false, true);

            screen.swipeUpMore(driver);

            String moneyReceivedMontlysummary = aaPage.getMoneyReceivedMontlysummary();

            Log.info("Monthly summary mONEY received" + expMoneyReceived);

            mbReporter.verifyEqualsWithLogging(moneyReceivedMontlysummary, expMoneyReceived, "Monthly summary mONEY received ", false, false, true);

        }
    }*/

    public void existingUserAnalyser(String expDebitText,String expWeekText, String expMonthText, String expYearText) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.trackBankAccountsCTA();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.clickonAnalyserOnAAHomePage();
        Log.info("Click On Analyser HomePage ");
        Thread.sleep(2000);

        screen.swipeUpMore(driver);

        String debitText = aaPage.getDebitText();
        String weekText = aaPage.getweekText();
        String monthText = aaPage.getMonthText();
        String yearText = aaPage.getYearText();

        Log.info("Debit text on Analyser screen " + expDebitText);
        Log.info("Week text on Analyser screen " + expWeekText);
        Log.info("Month text on Analyser screen " + expMonthText);
        Log.info("Year text on Analyser screen " + expYearText);

        mbReporter.verifyEqualsWithLogging(debitText, expDebitText, "Debit text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(weekText, expWeekText, "Week text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(monthText, expMonthText, "Month text on Analyser screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(yearText, expYearText, "Year text on Analyser screen", false, false, true);

    }

    public void existingUserManage(String expAllBankBalance, String expmanageTitle) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.clickOndownArrowNexttoBankOnHomePage();

        String allBankBalance = aaPage.getAllBankBalanceText();
        String manageTitle = aaPage.manageTitle();

        Log.info("allBankBalance" + allBankBalance);
        Log.info("manageTitle" + manageTitle);

        mbReporter.verifyEqualsWithLogging(allBankBalance, expAllBankBalance, "All bank balance Text", false, false, true);
        mbReporter.verifyEqualsWithLogging(manageTitle,expmanageTitle, "Manage Title", false, false, true);
        mbReporter.verifyTrueWithLogging(aaPage.isBankAccoutPresent(), "Masked Account is present", false, false);



    }

    /*
    public void existingUserBankAccountDetails() throws InterruptedException, IOException {

        aaPage.allServicesCTA();

        Log.info("START", "Account Aggregator");
        Log.info("AA flow For Bank Account detail");
        Log.info("-------------------------------------");

        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);

        aaPage.scrolltoManage();

        if(!aaPage.savedBankAccount())
        {
            screen.swipeUpMore(driver);
        }
        aaPage.clickOnYourSavedBankAccount();
        Log.info("Click On Your saved Bank account ");
        List<AndroidElement> elements = Element.findElements(driver, By.id("txt_transaction_type"));
        int noOftransaction = elements.size();
        Log.info("no Of Transaction - " + noOftransaction);
        mbReporter.verifyTrueWithLogging(noOftransaction >= 0, "Verify No of transaction should be greater than or equal to 0", false, false);

    }
    */


    public void addAccountNewScreen() throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollToAAOnHomeScreen();
        aaPage.clickOnAAOnHomeScreen();
        aaPage.scrolltoManage();
        aaPage.clickOnBankAccount();
        aaPage.clickOnToAddAccountOnBankListScreen();

        //New Bottomsheet for Add account
        aaPage.clickContinueOnbottomSheet();

        //Fip list Page for add account
        aaPage.enterBankDetail("HDFC");
        aaPage.clickonConsentcheckBox();
        aaPage.clickConfirmButtonOnFIPPage();
        aaPage.clickOnAllowCTaOnBottomsheet();
        Thread.sleep(3000);
        aaPage.clickOnAllowCTaOnPopUp();
        Element.waitForVisibility(driver, By.xpath("//*/android.widget.TextView[@text = 'Enter OTP to']"));

        aaPage.clickOnTocrossButtonOnOTPFetch();

        //FeedbackSheet handle
        Element.waitForVisibility(driver, By.xpath("//*/android.widget.TextView[@text = 'Others']"));
        aaPage.clickonConsentcheckBox();
        aaPage.clickOnexitbutoonOnfeedback();

    }





}

