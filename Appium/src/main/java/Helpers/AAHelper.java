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
        //     mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        //     mbReporter = new MBReporter(driver, "testScreenshotDir");
        //   permissionPage = new PermissionPage(driver);
    }

    /**
     * This method is to Test standalone Account aggregator flow from Wealth dashboard
     */
    public void existingUser() throws InterruptedException, IOException {

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
            aaPage.moneyPlusCTA();

            Thread.sleep(20000);

            //Swipe up till the AA card
            screen.swipeUpMore(driver);

            // Tap on AA card of exiting user
            aaPage.accountAggregatorCard();

            //  aaPage.AA_card();
            //   aaPage.checkCTA();

            //Click on bank account card for existing user
            aaPage.bankCard();
            Thread.sleep(10000);

            //Click on download cta to check the bank statement
            aaPage.downloadCTA();
            Thread.sleep(2000);

            //     aaPage.refreshCTA();

            //Tap on filter to check available filters
            aaPage.filterCTA();

            // Apply filter
            aaPage.applyFilter();
            Thread.sleep(1000);


            // Click on bank
            aaPage.bankDetailsCTA();

            //Toucxh outside if the bottom sheet
            aaPage.touchOutsideCTA();

            //   aaPage.userDetails();


            //Assertion------------------------------------------
            // Get the user's details which is from bank end

        }
        else {
            //If user is logged out
            System.out.println("Login to continue");
        }



    }

}

