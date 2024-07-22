package Helpers;

import Logger.Log;
import PageObject.EpfoPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class EpfoHelper {

    AndroidDriver driver;
    EpfoPage epfoPage;
    MBReporter mbReporter;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    public EpfoHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        epfoPage = new EpfoPage(driver);
        mbReporter = new MBReporter(driver);
    }

    public void epfoDashBoardExistingUser(String expgetEpfBalanceCTA,String expgetRecentContributionCTA,String expgetViewFullStatementCTA,String expgetRetirementCTA,String expgetContactUsCTA) throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();


        // Fetch all data on the dashboard screen
        String getEpfBalanceCTA = epfoPage.getTotalEpfBalanceCTA();
        String getRecentContributionCTA = epfoPage.getRecentContributionCTA();
        String getViewFullStatementCTA = epfoPage.getViewFullStatementCTA();

        Log.info("get Epf Balance CTA :" + getEpfBalanceCTA);
        Log.info("get Recent Contribution CTA :" + getRecentContributionCTA);
        Log.info("get View Full Statement CTA :" + getViewFullStatementCTA);

        // Add assertions
        mbReporter.verifyTrueWithLogging(epfoPage.isBalancePresent(), "Account balance is present", false, false);
        mbReporter.verifyEqualsWithLogging(getEpfBalanceCTA, expgetEpfBalanceCTA, "get Epf Balance CTA", false, false, true);
        mbReporter.verifyEqualsWithLogging(getRecentContributionCTA, expgetRecentContributionCTA, "get Recent Contribution CTA", false, false, true);
        mbReporter.verifyEqualsWithLogging(getViewFullStatementCTA, expgetViewFullStatementCTA, "get View Full Statement CTA", false, false, true);

        epfoPage.clickOnInfoIcon();
        driver.navigate().back();

        //Scroll till retirement fund
        epfoPage.scrollToTotalBalanceCTA();
        String getRetirementCTA = epfoPage.getViewYourRetirementFund();
        Log.info("get Retirement CTA :" + getRetirementCTA);

        // Add assertions
        mbReporter.verifyEqualsWithLogging(getRetirementCTA, expgetRetirementCTA, "get Retirement fund", false, false, true);

        // Scroll till Current Employee
        epfoPage.scrollToCurrentEmployee();
        mbReporter.verifyTrueWithLogging(epfoPage.isViewAllEmplyCTA(), "Verify View All Employee", false, false);

        // Scroll till Need Help
        epfoPage.scrollToNeedHelp();

        // Need Help Verify txt
        String getContactUsCTA = epfoPage.getContactUsCTA();
        Log.info("get Need Help CTA:" + getContactUsCTA);
        mbReporter.verifyEqualsWithLogging(getContactUsCTA, expgetContactUsCTA, "get Contact Us Cta", false, false, true);

    }


    public void epfoDashBoardNewUser(String expgetTrackYourEmpoProvidentFund,String expgetInutyourUANtxt,String expgetknowMoreActivation,String expgetProceedTxt,String expgetFindyourUAN) throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();

        // Fetch all data on the dashboard screen
        String getTrackYourEmpoProvidentFund = epfoPage.getTrackYourEmpoProvidentFund();

        Log.info("get View Full Statement CTA :" + getTrackYourEmpoProvidentFund);

        // Add assertions
        mbReporter.verifyEqualsWithLogging(getTrackYourEmpoProvidentFund, expgetTrackYourEmpoProvidentFund, "get Track Your Empo Provident Fund", false, false, true);
        epfoPage.clickContinueCTA();

        // Fetch all data Input Your UAN screen
        String getInutyourUANtxt = epfoPage.getInutyourUANtxt();
        String getknowMoreActivation = epfoPage.getknowMoreActivation();
        String getFindyourUAN = epfoPage.getFindyourUAN();

        Log.info("get Inut your UAN txt :" + getInutyourUANtxt);
        Log.info("get know More Activation :" + getFindyourUAN);
        Log.info("get Find your UAN :" + getFindyourUAN);

        // Add assertions
        mbReporter.verifyEqualsWithLogging(getInutyourUANtxt, expgetInutyourUANtxt, "get Inut your UAN txt", false, false, true);
        mbReporter.verifyEqualsWithLogging(getknowMoreActivation, expgetknowMoreActivation, "get know More Activation", false, false, true);
        mbReporter.verifyEqualsWithLogging(getFindyourUAN, expgetFindyourUAN, "get Find your UAN", false, false, true);

        epfoPage.enterUANNumber("1234");

        String getProceedTxt = epfoPage.getProceedTxt();
        Log.info("get Proceed Txt:" + getProceedTxt);
        mbReporter.verifyEqualsWithLogging(getProceedTxt, expgetProceedTxt, "getProceedTxt", false, false, true);

    }

    }

