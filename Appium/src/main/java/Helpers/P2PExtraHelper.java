package Helpers;

import PageObject.HomePage;
import PageObject.P2PExtraPage;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import Logger.Log;
import org.openqa.selenium.By;
import Utils.Element;
import Utils.Screen;
import java.io.IOException;


public class P2PExtraHelper {

    AndroidDriver driver;
    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    Screen screen;
    Element element;
    MBReporter mbReporter;


    public P2PExtraHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        p2PExtraPage = new P2PExtraPage(driver);
        mbReporter = new MBReporter(driver);

    }

    public void withdraw(String amount , String expAmount , String expStatus) throws InterruptedException, IOException {

        Log.info("START", "P2P Extra-Withdraw");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on screen to remove bottom sheet.
        p2PExtraPage.removeBottomSheet();

        // Printing portfolio values.
        String portfolioValue = p2PExtraPage.getPortfolioValue();
//        String investedAmount = p2PExtraPage.getInvestedAmount();
//        String earnedAmount = p2PExtraPage.getEarnedAmount();
        String perDayEarning = p2PExtraPage.getPerDayEarning();

        Log.info("Portfolio Value : " + portfolioValue);
//        Log.info("Invested Amount : " + investedAmount);
//        Log.info("Earned Amount : " + earnedAmount);
        Log.info("Per Day Earning : " + perDayEarning);


        int integerPortfolioValue = p2PExtraPage.getIntegerPortfolioValue();
        Log.info("Portfolio Value in integer : " + integerPortfolioValue);

        if(integerPortfolioValue >= Integer.parseInt(amount)){

            // Click on withdraw on Xtra main page.
            p2PExtraPage.selectWithdraw();

            // Enter amount on withdrawal amount page.
            p2PExtraPage.enterAmount(amount);

            //Click on withdraw on withdrawal amount page.
            p2PExtraPage.selectWithdrawOnWithdrawAmount();

            //Click on bank account to select bank account.
            p2PExtraPage.selectBankOnBottomSheet();

            //Click on withdraw on bottom sheet.
            p2PExtraPage.selectWithdrawOnBottomSheet();

            Thread.sleep(5000);

            // Print on success page
            String actualAmount = p2PExtraPage.getWithdrawalAmount();
            String actualStatus = p2PExtraPage.getWithdrawalStatus();

            Log.info("Withdrawal amount : " + actualAmount);
            Log.info("Withdrawal status : " + actualStatus);

            mbReporter.verifyEquals(actualAmount, expAmount, "Verify Withdrawal amount", false, false);
            mbReporter.verifyEquals(actualStatus, expStatus, "Verify Withdrawal status", false, false);

            Thread.sleep(5000);
        }

        else{
            Log.info("Portfolio value is less then amount entered");
        }

        Log.info("END", "Withdraw Money : P2P Extra");

    }

}