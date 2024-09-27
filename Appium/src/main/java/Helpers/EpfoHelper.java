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
        epfoPage.clickOnInfoIcon();
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

    public void epfoDashBoardAll() throws InterruptedException, IOException {

        epfoPage.clickAllServices();
        epfoPage.scrollToTrackEpfBalance();
        epfoPage.clickTrackEpfBalance();
        epfoPage.scrollToOneMobikwikSystem();
        epfoPage.clickOnViewAllEmployer();
        Log.info("======= Third employer =======");
        epfoPage.clickOnIngenuityGaming();

        String getTotalEPFBalanceOfIngenuityGaming = epfoPage.getTotalEPFBalanceAmount();
        Log.info("get total EPF balance IngenuityGaming :" + getTotalEPFBalanceOfIngenuityGaming);
        mbReporter.verifyTrueWithLogging(!(getTotalEPFBalanceOfIngenuityGaming ==null), "Verify amount on EPF page", false, false, true);

        String getemployeeShareIngenuityGaming = epfoPage.getemployeesharebottomsheet();
        String getEmployeeShareBalanceIngenuityGaming = epfoPage.getEmployeeShareOneMobikwikSystem();
        Log.info("get employee Share IngenuityGaming: " + getemployeeShareIngenuityGaming + ":" + getEmployeeShareBalanceIngenuityGaming);
        mbReporter.verifyTrueWithLogging(!(getEmployeeShareBalanceIngenuityGaming ==null), "Verify employee share on EPF page", false, false, true);

        String getemployersShareIngenuityGaming = epfoPage.getemployersharebottomsheet();
        String getEmployerShareBalanceIngenuityGaming = epfoPage.getEmployerShareAOneMobikwikSystem();
        Log.info("get employer Share IngenuityGaming: " + getemployersShareIngenuityGaming + ":" + getEmployerShareBalanceIngenuityGaming);
        mbReporter.verifyTrueWithLogging(!(getEmployerShareBalanceIngenuityGaming ==null), "Verify employer share on EPF page", false, false, true);

        String getPensionShareIngenuityGaming = epfoPage.getPensionShare();
        String getPensionShareAIngenuityGaming = epfoPage.getPensionShareAOneMobikwikSystem();
        Log.info("get Pension Share IngenuityGaming: " + getPensionShareIngenuityGaming + ":" + getPensionShareAIngenuityGaming);
        mbReporter.verifyTrueWithLogging(!(getPensionShareAIngenuityGaming ==null), "Verify employer share on EPF page", false, false, true);

        epfoPage.clickOnAccountDetails();

        String getAccountHolderNameIngenuityGaming = epfoPage.gettxtAccountHolderName();
        Log.info(" AccountHolderName for IngenuityGaming:" + getAccountHolderNameIngenuityGaming);
        mbReporter.verifyTrueWithLogging(!(getAccountHolderNameIngenuityGaming.isEmpty()), "get Account Holder name", false, false, true);
        driver.navigate().back();
        epfoPage.clickBackIcon();

        Log.info("======= First employer =======");
        epfoPage.clickOnMobikwikSystemDetails();

        String getTotalEPFBalanceOfOnMobikwikSystem = epfoPage.getTotalEPFBalanceAmount();
        Log.info("get total EPF balance OnMobikwikSystem :" + getTotalEPFBalanceOfOnMobikwikSystem);
        mbReporter.verifyTrueWithLogging(!(getTotalEPFBalanceOfOnMobikwikSystem ==null), "Verify amount on EPF page", false, false, true);

        String getemployeeShareMobikwikSystem = epfoPage.getemployeesharebottomsheet();
        String getEmployeeShareBalanceMobikwikSystem = epfoPage.getEmployeeShareOneMobikwikSystem();
        Log.info("get employee Share MobikwikSystem: " + getemployeeShareMobikwikSystem + ":" + getEmployeeShareBalanceMobikwikSystem);
        mbReporter.verifyTrueWithLogging(!(getEmployeeShareBalanceMobikwikSystem ==null), "Verify employee share on EPF page", false, false, true);

        String getemployersShareMobikwikSystem = epfoPage.getemployersharebottomsheet();
        String getEmployerShareBalanceMobikwikSystem = epfoPage.getEmployerShareAOneMobikwikSystem();
        Log.info("get employer Share MobikwikSystem: " + getemployersShareMobikwikSystem + ":" + getEmployerShareBalanceMobikwikSystem);
        mbReporter.verifyTrueWithLogging(!(getEmployerShareBalanceMobikwikSystem ==null), "Verify employer share on EPF page", false, false, true);

        String getPensionShareMobikwikSystem = epfoPage.getPensionShare();
        String getPensionShareAMobikwikSystem = epfoPage.getPensionShareAOneMobikwikSystem();
        Log.info("get Pension Share MobikwikSystem: " + getPensionShareMobikwikSystem + ":" + getPensionShareAMobikwikSystem);
        mbReporter.verifyTrueWithLogging(!(getPensionShareAMobikwikSystem ==null), "Verify employer share on EPF page", false, false, true);

        epfoPage.clickOnAccountDetails();

        String getAccountHolderNameMobikwikSyste = epfoPage.gettxtAccountHolderName();
        Log.info("AccountHolderName for MobikwikSystem:" + getAccountHolderNameMobikwikSyste);
        mbReporter.verifyTrueWithLogging(!(getAccountHolderNameMobikwikSyste.isEmpty()), "get Account Holder name", false, false, true);
        driver.navigate().back();
        epfoPage.clickBackIcon();

        Log.info("======= Second employer =======");
        epfoPage.clickOnAquimoSportsDetails();

        String getTotalEPFBalanceOfOnAquimoSports = epfoPage.getTotalEPFBalanceAmount();
        Log.info("get total EPF balance AquimoSports :" + getTotalEPFBalanceOfOnAquimoSports);
        mbReporter.verifyTrueWithLogging(!(getTotalEPFBalanceOfOnAquimoSports ==null), "Verify amount on EPF page", false, false, true);

        String getemployeeShareAquimoSports = epfoPage.getemployeesharebottomsheet();
        String getEmployeeShareBalanceAquimoSports = epfoPage.getEmployeeShareOneMobikwikSystem();
        Log.info("get employee Share AquimoSports: " + getemployeeShareAquimoSports + ":" + getEmployeeShareBalanceAquimoSports);
        mbReporter.verifyTrueWithLogging(!(getEmployeeShareBalanceAquimoSports ==null), "Verify employee share on EPF page", false, false, true);

        String getemployersShareAquimoSports = epfoPage.getemployersharebottomsheet();
        String getEmployerShareBalanceAquimoSports = epfoPage.getEmployerShareAOneMobikwikSystem();
        Log.info("get employer Share AquimoSports: " + getemployersShareAquimoSports + ":" + getEmployerShareBalanceAquimoSports);
        mbReporter.verifyTrueWithLogging(!(getEmployerShareBalanceAquimoSports ==null), "Verify employer share on EPF page", false, false, true);

        String getPensionShareAquimoSports = epfoPage.getPensionShare();
        String getPensionShareAAquimoSports = epfoPage.getPensionShareAOneMobikwikSystem();
        Log.info("get Pension Share AquimoSports: " + getPensionShareAquimoSports + ":" + getPensionShareAAquimoSports);
        mbReporter.verifyTrueWithLogging(!(getPensionShareAAquimoSports ==null), "Verify employer share on EPF page", false, false, true);

        epfoPage.clickOnAccountDetails();

        String getAccountHolderNameAquimoSports = epfoPage.gettxtAccountHolderName();
        Log.info("AccountHolderName for AquimoSports:" + getAccountHolderNameAquimoSports);
        mbReporter.verifyTrueWithLogging(!(getAccountHolderNameAquimoSports.isEmpty()), "get Account Holder name", false, false, true);

        Log.info("======= fourth employer =======");
        driver.navigate().back();
        epfoPage.clickBackIcon();

        epfoPage.clickOnHermanMillerDetails();

        String getTotalEPFBalanceOfOnHermanMiller = epfoPage.getTotalEPFBalanceAmount();
        Log.info("get total EPF balance HermanMiller :" + getTotalEPFBalanceOfOnHermanMiller);
        mbReporter.verifyTrueWithLogging(!(getTotalEPFBalanceOfOnHermanMiller ==null), "Verify amount on EPF page", false, false, true);

        String getemployeeShareHermanMiller = epfoPage.getemployeesharebottomsheet();
        String getEmployeeShareBalanceHermanMiller = epfoPage.getEmployeeShareOneMobikwikSystem();
        Log.info("get employee Share HermanMiller: " + getemployeeShareHermanMiller + ":" + getEmployeeShareBalanceHermanMiller);
        mbReporter.verifyTrueWithLogging(!(getEmployeeShareBalanceHermanMiller ==null), "Verify employee share on EPF page", false, false, true);

        String getemployersShareHermanMiller = epfoPage.getemployersharebottomsheet();
        String getEmployerShareBalanceHermanMiller = epfoPage.getEmployerShareAOneMobikwikSystem();
        Log.info("get employer Share HermanMiller: " + getemployersShareHermanMiller + ":" + getEmployerShareBalanceHermanMiller);
        mbReporter.verifyTrueWithLogging(!(getEmployerShareBalanceHermanMiller ==null), "Verify employer share on EPF page", false, false, true);

        String getPensionShareHermanMiller = epfoPage.getPensionShare();
        String getPensionShareAHermanMiller = epfoPage.getPensionShareAOneMobikwikSystem();
        Log.info("get Pension Share HermanMiller: " + getPensionShareHermanMiller + ":" + getPensionShareAHermanMiller);
        mbReporter.verifyTrueWithLogging(!(getPensionShareAHermanMiller ==null), "Verify employer share on EPF page", false, false, true);

        epfoPage.clickOnAccountDetails();

        String getAccountHolderNameHermanMiller = epfoPage.gettxtAccountHolderName();
        Log.info("AccountHolderName for HermanMiller:" + getAccountHolderNameHermanMiller);
        mbReporter.verifyTrueWithLogging(!(getAccountHolderNameHermanMiller.isEmpty()), "get Account Holder name", false, false, true);
        Log.info("======= end of all employer =======");

    }

}

