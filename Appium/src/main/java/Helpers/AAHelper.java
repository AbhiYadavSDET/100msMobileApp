package Helpers;

import Logger.Log;
import PageObject.AccountAggregatorPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;

import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


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
        //     mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        //     mbReporter = new MBReporter(driver, "testScreenshotDir");
        //   permissionPage = new PermissionPage(driver);
    }

    /**
     * This method is to Test standalone Account aggregator flow from Wealth dashboard
     */
    public void existingUser(String expTitleOnCategoryPage,String exptitleOfMonthlySummary,String expmainDashboardAnalyser,String expdashBoardHighlightTitle,String expaccountTitle,String expOutgoingTitleOnDashboard,String expOutgoingFirstSubTitleOnDashboard,String expOutgoingSecondSubTitleOnDashboard,String expOutgoingThirdSubTitleOnDashboard,String expoutgoingFourthSubTitleOnDashboard,String expsettingsTitle,String expdownloadStatementsTitle,String exphelpSupportTitle) throws InterruptedException, IOException {

        if (Element.isElementPresent(driver, By.id("tx_balance")))
        {
            // Click on All services to see money plus icon
            aaPage.allServicesCTA();


            Log.info("START", "Account Aggregator");

            Log.info("AA flow for existing user");
            Log.info("-------------------------------------");

            // Swipe up for wealth dashboard
            screen.swipeUpMore(driver);

            // click on money plus icon
            aaPage.trackBankAccountsCTA();

            Thread.sleep(2000);
            // Verification on the Category Page
            String titleOnCategoryPage = aaPage.getTitle();
            Log.info("First Title On MainDashboard Page : " + expTitleOnCategoryPage);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(titleOnCategoryPage, expTitleOnCategoryPage, "Verify heading On Category Page", false, false , true );
            Thread.sleep(2000);

            // Verification on the Category Page
            String outgoingTitleOnDashboard = aaPage.getOutgoingTitle();
            Log.info("Outgoing title On MainDashboard Page : " + expOutgoingTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingTitleOnDashboard, expOutgoingTitleOnDashboard, "Verify Outgoing Title on MainDashboard", false, false , true );


            // Verification on the Category Page
            String outgoingFirstSubTitleOnDashboard = aaPage.getOutgoingFirstSubTitle();
            Log.info("Outgoing First Subtitle On MainDashboard Page : " + expOutgoingFirstSubTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingFirstSubTitleOnDashboard, expOutgoingFirstSubTitleOnDashboard, "Verify First Outgoing SubTitle on MainDashboard", false, false , true );

            mbReporter.verifyTrueWithLogging(aaPage.getMoneyTrf(),"Is Value Available", false,false);

            // Verification on the Category Page
            String outgoingSecondSubTitleOnDashboard = aaPage.getOutgoingSecondSubTitle();
            Log.info("Outgoing Second Subtitle On MainDashboard Page : " + expOutgoingSecondSubTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingSecondSubTitleOnDashboard, expOutgoingSecondSubTitleOnDashboard, "Verify Second Outgoing SubTitle on MainDashboard", false, false , true );

            mbReporter.verifyTrueWithLogging(aaPage.getExpensesPercentage(),"Is Expense Value percentage Available", false,false);

            mbReporter.verifyTrueWithLogging(aaPage.getSipePercentage(),"Is Expense Value percentage Available", false,false);

            mbReporter.verifyTrueWithLogging(aaPage.getBankChargesPercentage(),"Is Expense Value percentage Available", false,false);


            // Verification on the Category Page
            String outgoingThirdSubTitleOnDashboard = aaPage.getOutgoingThirdSubTitle();
            Log.info("Outgoing Third Subtitle On MainDashboard Page : " + expOutgoingThirdSubTitleOnDashboard);
            // Add the assertions
            mbReporter.verifyEqualsWithLogging(outgoingThirdSubTitleOnDashboard, expOutgoingThirdSubTitleOnDashboard, "Verify Third Outgoing SubTitle on MainDashboard", false, false , true );


            // Verification on the Category Page
            String outgoingFourthSubTitleOnDashboard = aaPage.getOutgoingFourthSubTitle();
            Log.info("Outgoing Fourth Subtitle On MainDashboard Page : " + expoutgoingFourthSubTitleOnDashboard);
            // Add the assertions
            String titleOfmainDashboardAnalyser = aaPage.mainDashboardAnalyserCTA();
            mbReporter.verifyEqualsWithLogging(outgoingFourthSubTitleOnDashboard, expoutgoingFourthSubTitleOnDashboard, "Verify Fourth Outgoing SubTitle on MainDashboard", false, false , true );

            screen.swipeUpMore(driver);

            String titleOfMonthlySummary = aaPage.getMonthlySummeryCTA();
            Log.info("Monthly summery text on MainDashboard : " + exptitleOfMonthlySummary);
            mbReporter.verifyEqualsWithLogging(titleOfMonthlySummary, exptitleOfMonthlySummary, "Verify Monthly summery title on dashboard", false, false , true );

            String dashBoardHighlightTitle = aaPage.dashboardHighlightTitle();
            Log.info("Highlight Title on MainDashboard : " + expdashBoardHighlightTitle);
            mbReporter.verifyEqualsWithLogging(dashBoardHighlightTitle, expdashBoardHighlightTitle, "Verify Highlight Title on Main Dashboardd", false, false , true );

            screen.swipeUpMore(driver);
            String accounTTitle = aaPage.accountTitle();
            Log.info("Account Title on MainDashboard : " + expaccountTitle);
            mbReporter.verifyEqualsWithLogging(accounTTitle, expaccountTitle, "Verify Account Title on MainDashboard", false, false , true );

            String settingsTitle = aaPage.settingsTitle();
            Log.info("Setting Title on MainDashboard : " + expsettingsTitle);
            mbReporter.verifyEqualsWithLogging(settingsTitle, expsettingsTitle, "Verify Account settings Title on MainDashboard", false, false , true );

            screen.swipeUpMore(driver);
            String downloadStatementsTitle = aaPage.downloadStatementsTitle();
            Log.info("Download Statements Title on MainDashboard : " + expdownloadStatementsTitle);
            mbReporter.verifyEqualsWithLogging(downloadStatementsTitle, expdownloadStatementsTitle, "Verify Account Download Statements Title on MainDashboardd", false, false , true );



            String helpSupportTitle = aaPage.helpSupportTitle();
            Log.info("Help Support Title on MainDashboard : " + exphelpSupportTitle);
            mbReporter.verifyEqualsWithLogging(helpSupportTitle, exphelpSupportTitle, "help Support Title on MainDashboard", false, false , true );


        }
        else {
            //If user is logged out
            System.out.println("Login to continue");
        }



    }

}

