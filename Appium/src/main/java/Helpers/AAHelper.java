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

            screen.tapAtCentre(driver);
            aaPage.clickOnUnhideIcon();

            Elements.tapByCoordinates(57,916,driver);

            aaPage.scrollToCashflow();
            if (Element.isElementPresent(driver, By.xpath("//*[@text='Cashflow']"))) {


                aaPage.scrollTomoneyOutTitle();
                if (Element.isElementPresent(driver, By.xpath("//*[@text='MONEY OUT']"))) {

                    // Fetch the other text on the screen
                    String moneyoutTitleOnDashboard = aaPage.getOutgoingTitle();
                    String outgoingSecondSubTitleOnDashboard = aaPage.getOutgoingSecondSubTitle();

                    Log.info("OutGoing Title :" + moneyoutTitleOnDashboard);
                    Log.info("Second Sub Title :" + outgoingSecondSubTitleOnDashboard);

                    // Add assertions
                    mbReporter.verifyEqualsWithLogging(moneyoutTitleOnDashboard, expMoneyoutTitleOnDashboard, "Verify Outgoing Title on MainDashboard", false, false, true);
                    mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false, true);

                    screen.swipeUpMore(driver);
                    screen.swipeUpMore(driver);

                    if (aaPage.checkmoneyinTitle()) {

                        aaPage.moneyinTitle();
                        String moneyInTTitle = aaPage.moneyinTitle();
                        Log.info("Money In Title : " + expmoneyinTitle);
                        mbReporter.verifyEqualsWithLogging(moneyInTTitle, expmoneyinTitle, "Verify Money In title", false, false, true);
                    }

                }

            }
            else {
                Log.info("Outgoing Data is not present");
            }
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
        aaPage.scrollToMoneyOut();
        aaPage.clickonAnalyserOnAAHomePage();
        Log.info("Click On Analyser HomePage ");
        Thread.sleep(2000);
        Elements.tapByCoordinates(57,916,driver);
        Thread.sleep(4000);
        if (aaPage.isDebitTextPresent()) {
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
    }

    public void existingUserManage(String expAllBankBalance, String expmanageTitle) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.clickOndownArrowNexttoBankOnHomePage();
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
        aaPage.scrollToBankAccount();
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


    public void FilterAA(String expmonthlyfilter,String explastMonthfilter) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.scrollToMoneyOut();
        aaPage.clickonnewMonthSelectFilter();

        String monthlyfilter = aaPage.getCurrentMonthtxt();
        Log.info("Monthly Filter " + monthlyfilter);
        mbReporter.verifyEqualsWithLogging(monthlyfilter, expmonthlyfilter, "Monthly filter", false, false, true);

        //Click on monthly filter
        aaPage.clickonCurrentMonth();
        aaPage.clickonnewMonthSelectFilter();

        //Click on yearly filter
        String lastMonthfilter = aaPage.getlastMonthtxt();
        Log.info("last Month Filter  txt" + lastMonthfilter);
        mbReporter.verifyEqualsWithLogging(lastMonthfilter, explastMonthfilter, "Last Month filter", false, false, true);

        aaPage.clickonLastMonth();
    }

    public void SearchAA() throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        //click on first search Icon
        aaPage.clickOnSearchIcon();

        //Click on first search value
        aaPage.clickOnFirstSearchvalue();

        //Click on First list from search item
        aaPage.clickonfilter();
        aaPage.clickonBankTXtfromFilter();

        //Click on the first bank account in the list
        aaPage.clickonBankFilter();

        //Click on Apply CTA
        aaPage.clickonApplyCta();

    }


    public void AAretagging(String expnickNametext,String expcategoryheader,String expsubcategoryheader,String exppaymentModetext) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollToAAOnHomeScreen();
        aaPage.clickOnAAOnHomeScreen();
        aaPage.scrolltoViewHighlights();
        aaPage.clickOnviewHighlisht();

        aaPage.clickOnOneHighlightInterestCredit();
        aaPage.clickonfirstIcon();

        String nickNametext = aaPage.getTextRetaggingNickName();
        Log.info("NickNameText" + nickNametext);
        mbReporter.verifyTrueWithLogging(aaPage.isTextRetaggingNickNamePresent(), "Verify Nickname is present or not", false, false);
        mbReporter.verifyEqualsWithLogging(nickNametext, expnickNametext, "Nickname Category name", false, false, true);

        //Nick Name Value
        String nickNametextvalue =aaPage.getTextNickNameVal();
        Log.info("NickNameText value " + nickNametextvalue);

        if (Element.isElementPresent(driver, By.xpath("//*[@text='+Add']")))
        {

            aaPage.clickOnAddbutton();
            aaPage.setpayeeName("jaiRam");
            aaPage.clickonUpdateName();

        }

        // Get Category Name
        String categoryheader =aaPage.getTextCategory();
        Log.info("Category Header " + categoryheader);
        mbReporter.verifyEqualsWithLogging(categoryheader, expcategoryheader, "Header Category name", false, false, true);

        aaPage.clickonTextCategoryVa();
        Thread.sleep(4000);
        aaPage.clickonleftIcon();

        // Get Sub Category Name
        String subcategoryheader =aaPage.getTextSubCategory();
        Log.info("Subcategory Header " + subcategoryheader);
        mbReporter.verifyEqualsWithLogging(subcategoryheader, expsubcategoryheader, "Header SubCategory name", false, false, true);

        aaPage.clickonTextSubCategoryVa();
        aaPage.clickonleftIcon();

        String paymentModetext =aaPage.getTextpaymentMode();
        Log.info("Payment Mode text " + paymentModetext);
        mbReporter.verifyEqualsWithLogging(paymentModetext, exppaymentModetext, "Header Payment Mode", false, false, true);


    }

    public void AADownloadStatement(String explast7daysTxt, String exptxtLast30Days, String exptxtLast6Months, String exptxtLast12Months, String exptxtThisYear,String exptxtFinancialYear) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.scrolltoViewStatement();
        aaPage.clickOnViewStatement();
        aaPage.clickOnDownloadStatement();

        String txtLast6Months =aaPage.getLast6monthTxt();
        String txtThisYear =aaPage.getThisYearTxt();
        String txtFinancialYear =aaPage.getFinanacialYearTxt();

        Log.info("last 6 month txn" + txtLast6Months);
        Log.info("this year txn" + txtThisYear);
        Log.info("Txn financial year" + txtFinancialYear);

        mbReporter.verifyEqualsWithLogging(txtLast6Months, exptxtLast6Months, "last 6 months", false, false, true);
         mbReporter.verifyEqualsWithLogging(txtThisYear, exptxtThisYear, "this year txn", false, false, true);
        mbReporter.verifyEqualsWithLogging(txtFinancialYear, exptxtFinancialYear, "Txn financial year", false, false, true);

    }

    public void aaHighlight(String expfirstHeadingTxt, String expsecondHeadingTxt,String expfirstTaxCardHeadingTxt) throws InterruptedException, IOException {

        aaPage.allServicesCTA();
        aaPage.scrollTotrackBankAccounts();
        aaPage.clickOnTrackBankAccounts();
        Element.waitForVisibility(driver, By.id("bottom_navigation_tool_tip"));
        Elements.tapByCoordinates(57,916,driver);
        aaPage.scrolltoViewHighlights();
        aaPage.clickOnviewHighlisht();

        //Get text Tax Highlight
        String firstHeadingTxt =aaPage.firsttabLifeStyleHeading();
        String secondHeadingTxt =aaPage.secondttabTaxSavingHeading();

        Log.info("first Heading Txt inside the Highlight" + firstHeadingTxt);
        Log.info("Second Heading Txt inside the Highlight" + secondHeadingTxt);

        mbReporter.verifyEqualsWithLogging(firstHeadingTxt, expfirstHeadingTxt, "first Heading Txt inside the Highlight", false, false, true);
        mbReporter.verifyEqualsWithLogging(secondHeadingTxt, expsecondHeadingTxt, "Second Heading Txt inside the Highlight", false, false, true);

        aaPage.clickonTaxSavingHeading();
        aaPage.clickonFinancialYearFilter();
        aaPage.clickonFinancialYearFirstFilter();

        //Get text Tax Highlight first Tax card text
        String firstTaxCardHeadingTxt =aaPage.getTaxProgressTxt();
        Log.info("first Tax Card Text inside the Highlight" + firstTaxCardHeadingTxt);
        mbReporter.verifyEqualsWithLogging(firstTaxCardHeadingTxt, expfirstTaxCardHeadingTxt, "Second Heading Txt inside the Highlight", false, false, true);

    }




}

