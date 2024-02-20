package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.MutualFundPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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

    public void mutualFundsCheck(String fundName, String minInvestAmount, String mfReturns, String mfRating, String expPopUpTitle, String expPopUpSubTitle, String expPopUpCtaText) throws InterruptedException, IOException {

        Log.info("START", "Explore Mutual Funds");

        // Tap on See All Services
        homePage.clickAllServices();

        clickOnMutualFund();
        // Click on get started button.
        mutualFundPage.clickOnGetStarted();

        // Swipe till the bottom
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        screen.swipeUpLess(driver);


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

        // Add the assertions
        mbReporter.verifyEquals(mutualFundName, fundName, "Verify MF Name", false, false);
        mbReporter.verifyEquals(minimumInvestmentAmount, minInvestAmount, "Verify MF Min Amount", false, false);
        mbReporter.verifyEquals(returns, mfReturns, "Verify MF Returns", false, false);
        mbReporter.verifyEquals(rating, mfRating, "Verify MF rating", false, false);

        // Selecting the mutual fund.
        mutualFundPage.selectMutualFund();

        // Click on sip.
        mutualFundPage.clickOnSip();

        // Getting mutual fund details.
        String popupTitle = mutualFundPage.getPopUpTitle();
        String popupSubTitle = mutualFundPage.getPopUpSubTitle();
        String popCtaText = mutualFundPage.getPopUpCtaText();

        // Printing mutual fund details.
        Log.info("Popup Title : " + popupTitle);
        Log.info("Popup SubTitle : " + popupSubTitle);
        Log.info("Popup Cta text : " + popCtaText);

        // Add the assertions
        mbReporter.verifyEquals(popupTitle, expPopUpTitle, "Verify Pop Up Title", false, false);
        mbReporter.verifyEquals(popupSubTitle, expPopUpSubTitle, "Verify Pop Up Sub Title", false, false);
        mbReporter.verifyEquals(popCtaText, expPopUpCtaText, "Verify Pop Up Cta Text", false, false);

        Log.info("END", "Explore Mutual Funds");

    }

    public void retakeRiskAnalyser() throws IOException, InterruptedException {

        Log.info("START", "Risk analyser Mutual Funds");

        // Tap on See All Services
        homePage.clickAllServices();

        // click on mutual funds from All service
        clickOnMutualFund();

        mutualFundPage.clickOnGetStarted();

        mutualFundPage.clickOnRetakeButton();
        mutualFundPage.clickOnStartNow();

        mutualFundPage.clickOnInvsetmentTimeFor();
        mutualFundPage.clickOnInvsetmentTimeLast();
        mutualFundPage.clickOnSaveButton();

        mutualFundPage.clickOnAnnualIncomeOption();
        mutualFundPage.clickOnIsPrimaryBreadWinner();
        mutualFundPage.clickOnSaveButton();

        mutualFundPage.clickOnCareMostOption();
        mutualFundPage.clickOnInvestmentDownOption();
        mutualFundPage.clickOnSaveButton();

        mutualFundPage.clickOnInvestmentGoUpDownOption();
        mutualFundPage.clickOnCurrentSavingOption();
        mutualFundPage.clickOnSaveButton();
       String successText=  mutualFundPage.getTextOnRiskAnalyserSuccessScreen();

        mbReporter.verifyEquals(successText, "Recommended combination for you", "Verify retake analyser success ", false, false);

    }

    public void privacyPolicy() throws IOException, InterruptedException {

        Log.info("START", "Privacy policy on  Mutual Funds");

        // Tap on See All Services
        homePage.clickAllServices();

        // click on mutual funds from All service
        clickOnMutualFund();

        mutualFundPage.clickOnGetStarted();
        mutualFundPage.clickOnProfile();

        mutualFundPage.clickOnPrivacyPolicy();
        String  privacyPolicy = mutualFundPage.getTitleOnPrivacyPolicy();

        mbReporter.verifyEquals(privacyPolicy, "Privacy Policy", "Verify Privacy policy link on MF", false, false);
    }
    public  void faq() throws IOException, InterruptedException {

        Log.info("START", "FAQ on  Mutual Funds");
        // Tap on See All Services
        homePage.clickAllServices();

        // click on mutual funds from All service
        clickOnMutualFund();

        mutualFundPage.clickOnGetStarted();
        mutualFundPage.clickOnProfile();
        mutualFundPage.clickOnFaq();

        String faqText = mutualFundPage.getTitleOnFaq();
        mbReporter.verifyEquals(faqText, "FAQs", "Verify FAQ on MF", false, false);

    }

    public void clickOnMutualFund() throws InterruptedException {
        for(int i=0;i<5;i++){
            if(!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Direct Mutual Funds']"))){
                // Swipe till the bottom
                screen.swipeUpMore(driver);
            }else {
                break;
            }
        }

        // Click on direct mutual funds
        mutualFundPage.clickOnMutualFunds();
    }
}