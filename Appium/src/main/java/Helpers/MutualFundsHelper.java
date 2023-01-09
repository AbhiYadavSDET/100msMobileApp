package Helpers;

import PageObject.HomePage;
import PageObject.MutualFundPage;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import Logger.Log;
import org.openqa.selenium.By;
import Utils.Element;
import Utils.Screen;
import java.io.IOException;


public class MutualFundsHelper {

    AndroidDriver driver;
    HomePage homePage;
    MutualFundPage mutualFundPage;
    Screen screen;
    Element element;
    MBReporter mbReporter;


    public MutualFundsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mutualFundPage = new MutualFundPage(driver);
        mbReporter = new MBReporter(driver);

    }

    public void mutualFundsCheck() throws InterruptedException, IOException {

        Log.info("START", "Explore Mutual Funds");

        // Tap on See All Services
        homePage.clickAllServices();

        // Swipe till the bottom
        screen.swipeUpMore(driver);

        // Click on direct mutual funds
        mutualFundPage.clickOnMutualFunds();

        // Click on get started button.
        mutualFundPage.clickOnGetStarted();

        // Swipe till the bottom
        screen.swipeUpMore(driver);

        // Click on explore mutual funds.
        mutualFundPage.clickOnExploreMutualFunds();

        // Getting mutual fund details.
        String mutualFundName = mutualFundPage.getMutualFundName();
        String minimumInvestmentAmount = mutualFundPage.getMinimumInvestmentAmount();
        String returns = mutualFundPage.getReturns();
        String rating = mutualFundPage.getRating();

        // Printing mutual fund details.
        Log.info("Mutual Fund Name : " + mutualFundName);
        Log.info("Minimum Investment Amount : " + minimumInvestmentAmount);
        Log.info("Mutual Fund Returns : " + returns);
        Log.info("Mutual Fund Rating : " + rating);

        // Selecting the mutual fund.
        mutualFundPage.selectMutualFund();

        Thread.sleep(5000);

        // Click on sip.
        mutualFundPage.clickOnSip();

        Log.info("END", "Explore Mutual Funds");


    }
}