package Helpers;

import Logger.Log;
import PageObject.EpfoPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import com.mongodb.annotations.NotThreadSafe;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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

        //epfoPage.clickOnInfoIcon();
        // driver.navigate().back();

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

    public void epfoDashBoardBalanceBreakup(String expgetNametxt,String expgetActivesince,String expgetWorkexperience,String expgetemployeeShare,String expgetemployersShare,String expgetPensionShare,String expgetTotalEPFBalance) throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();

        //Click On Info icon present next to balance
        epfoPage.clickOnInfoIcon();
        String getInterestEarned = epfoPage.getInterestEarned();
        Log.info("get Interest Earned:" + getInterestEarned);

        String getNametxt = epfoPage.getNametxt();
        Log.info("get get Name txt:" + getNametxt);

        String getActivesince = epfoPage.getActivesince();
        Log.info("get  Active since:" + getActivesince);

        String getWorkexperience = epfoPage.getWorkexperience();
        Log.info("get  Work experience:" + getWorkexperience);

        String getemployeeShare = epfoPage.getemployeeShare();
        Log.info("get employee Share:" + getemployeeShare);

        String getemployersShare = epfoPage.getemployersShare();
        Log.info("get employer Share:" + getemployersShare);

        String getPensionShare = epfoPage.getPensionShare();
        Log.info("get Pension Share:" + getPensionShare);

        String getTotalEPFBalance = epfoPage.getTotalEPFBalance();
        Log.info("get Tota EPF Balance:" + getTotalEPFBalance);

        mbReporter.verifyEqualsWithLogging(getNametxt, expgetNametxt, "get Name txt", false, false, true);
        mbReporter.verifyEqualsWithLogging(getActivesince, expgetActivesince, "get Active since", false, false, true);
        mbReporter.verifyEqualsWithLogging(getWorkexperience, expgetWorkexperience, "get work exp", false, false, true);
        mbReporter.verifyEqualsWithLogging(getemployeeShare, expgetemployeeShare, "get employee Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getemployersShare, expgetemployersShare, "get employers Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getPensionShare, expgetPensionShare, "exp get Pension Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getTotalEPFBalance, expgetTotalEPFBalance, "get Total EPF Balance", false, false, true);

        Thread.sleep(1000);
        epfoPage.clickOnInterestEarned();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(5000);
        epfoPage.clickPensionShare();

    }

    public void epfoDashBoardViewStatementWithFilter(String expgetemployeeShare,String expgetemployersShare,String expgetPensionShare) throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();
        epfoPage.clickOnViewFullStatementCTA();

        Element.waitForVisibility(driver, By.xpath("//*/android.widget.TextView[@text = 'EPF Statement']"));
        epfoPage.clickOnFiscalYear();
        Thread.sleep(1000);
        driver.navigate().back();
        epfoPage.clickOnDeposit();
        Thread.sleep(3000);
        epfoPage.clickOnDepositfirstArrayItem();
        Thread.sleep(5000);
        Element.waitForVisibility(driver, By.xpath("//*/android.widget.TextView[@text = 'Employee Share']"));

        String getemployeeShare = epfoPage.getemployeeSharebottomsheet();
        Log.info("get employee Share:" + getemployeeShare);

        String getemployersShare = epfoPage.getemployerSharebottomsheet();
        Log.info("get employer Share:" + getemployersShare);

        String getPensionShare = epfoPage.getPensionShare();
        Log.info("get Pension Share:" + getPensionShare);

        mbReporter.verifyEqualsWithLogging(getemployeeShare, expgetemployeeShare, "get employee Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getemployersShare, expgetemployersShare, "get employers Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getPensionShare, expgetPensionShare, "exp get Pension Share", false, false, true);
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(5000);
        screen.swipeUpMoreFromRightSide(driver);

    }


    public void epfoDashBoardCurrentEmp(String expgetemployeeShare,String expgetemployersShare,String expgetPensionShare,String expgetAccountHolderName,String expgetTransactionTxt) throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();
        epfoPage.scrollToOneMobikwikSystem();
        epfoPage.clickOnOneMobikwikSystem();
        Thread.sleep(6000);
        String getemployeeShare = epfoPage.getemployeesharebottomsheet();
        Log.info("get employee Share:" + getemployeeShare);

        String getemployersShare = epfoPage.getemployersharebottomsheet();
        Log.info("get employer Share:" + getemployersShare);

        String getPensionShare = epfoPage.getPensionShare();
        Log.info("get Pension Share:" + getPensionShare);

        String getTransactionTxt = epfoPage.gettxtTransaction();
        Log.info("get Pension Share:" + getTransactionTxt);

        mbReporter.verifyEqualsWithLogging(getemployeeShare, expgetemployeeShare, "get employee Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getemployersShare, expgetemployersShare, "get employers Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getPensionShare, expgetPensionShare, "exp get Pension Share", false, false, true);
        mbReporter.verifyEqualsWithLogging(getTransactionTxt, expgetTransactionTxt, "exp gTxn text", false, false, true);

        Thread.sleep(1000);
        epfoPage.clickOnAccountDetails();
        Thread.sleep(1000);

        String getAccountHolderName = epfoPage.gettxtAccountHolderName();
        Log.info("get employee Share:" + getAccountHolderName);
        mbReporter.verifyEqualsWithLogging(getAccountHolderName, expgetAccountHolderName, "get Account Holder name", false, false, true);

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(3000);

        //Click on all Transactions
        epfoPage.clickOnAllTransaction();
        Thread.sleep(4000);

        // Select FY 2011-12
        epfoPage.clickOnFy201112();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(5000);

        //Verify Multiple previous account is added or not
        epfoPage.clickOnViewAllEmployer();

        epfoPage.clickOnOneMobikwikSystem();

    }



}

