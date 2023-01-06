package Helpers;

import PageObject.HomePage;
import PageObject.P2PExtraPage;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import Logger.Log;
import org.apache.commons.lang3.ThreadUtils;
import org.openqa.selenium.By;
import Utils.Element;
import Utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class P2PExtraHelper {

    AndroidDriver driver;

    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    Screen screen;
    Element element;



    public static HashMap<String, String> map;


    public P2PExtraHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        p2PExtraPage = new P2PExtraPage(driver);

    }

    public void withdraw(String amount) throws InterruptedException, IOException {

        Log.info("START", "P2P Extra-Withdraw");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on screen to remove bottom sheet.
        p2PExtraPage.removeBottomSheet();

        // Printing portfolio value.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
        String investedAmount = p2PExtraPage.getInvestedAmount();
        String earnedAmount = p2PExtraPage.getEarnedAmount();
        String perDayEarning = p2PExtraPage.getPerDayEarning();

        Log.info("Portfolio Value : " + portfolioValue);
        Log.info("Invested Amount : " + investedAmount);
        Log.info("Earned Amount : " + earnedAmount);
        Log.info("Per Day Earning : " + perDayEarning);


        // Click on withdraw on Xtra main page.
        p2PExtraPage.selectWithdraw();

        // Enter amount on withdrawal amount page.
        p2PExtraPage.enterAmount("1");

        //Click on withdraw on withdrawal amount page.
        p2PExtraPage.selectWithdrawOnWithdrawAmount();

        //Click on bank account to select bank account.
        p2PExtraPage.selectBankOnBottomSheet();

        //Click on withdraw on bottom sheet.
        p2PExtraPage.selectWithdrawOnBottomSheet();

        // Print on success page

        Thread.sleep(5000);


        Log.info("END", "Withdraw Money : P2P Extra");

    }

}