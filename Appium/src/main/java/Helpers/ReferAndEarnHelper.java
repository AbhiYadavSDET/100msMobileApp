package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.P2PExtraPage;
import PageObject.ReferAndEarnPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class ReferAndEarnHelper {

    AndroidDriver driver;
    HomePage homePage;
    ReferAndEarnPage referAndEarnPage;

    MBReporter mbReporter;

    MBKCommonControlsHelper mbkCommonControlsHelper;

    PermissionHelper permissionHelper;



    public ReferAndEarnHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        referAndEarnPage = new ReferAndEarnPage(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        permissionHelper = new PermissionHelper(driver);
//        screen = new Screen(driver);
//        element = new Element(driver);
//        p2PExtraPage = new P2PExtraPage(driver);
//        mbReporter = new MBReporter(driver);
//        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
//        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }

    public void referInUpiWithoutEarnings(String expTitle) throws InterruptedException ,IOException {

        homePage.clickOnAllServicesSection();

        referAndEarnPage.clickAndNavigateToReferAndEarn();

        referAndEarnPage.clickReferBtn();

        Thread.sleep(1000);

        mbkCommonControlsHelper.pressback(1);

        referAndEarnPage.clickOnEligibleContacts();

        referAndEarnPage.clickOnAllowBtn();

        permissionHelper.permissionAllow();

        String Description = referAndEarnPage.getDesc();
        Log.info(Description);
        // Add the assertions
        mbReporter.verifyTrueWithLogging(referAndEarnPage.getTitleonUPIPage(), "Is Title Available", false, false);
    }



    public void referInUpiWithEarnings(String expTitle) throws InterruptedException,IOException {

        homePage.clickOnAllServicesSection();

        referAndEarnPage.clickAndNavigateToReferAndEarn();

        // Add the assertions
        mbReporter.verifyTrueWithLogging(referAndEarnPage.getTitleonUPIPage(), "Is Title Available", false, false);
        mbReporter.verifyTrueWithLogging(referAndEarnPage.getTotalEarnings(), "Is Earnings Present ", false, false);
        mbReporter.verifyTrueWithLogging(referAndEarnPage.getSucessfullReferals(), "Is Referral counts present", false, false);

        referAndEarnPage.clickKnowMoreCTA();

        Thread.sleep(1000);

        referAndEarnPage.clickTermAndCondition();

        Thread.sleep(2000);

        //Press Back 6 times to go to home screen
        mbkCommonControlsHelper.pressback(2);

        referAndEarnPage.clickReferBtn();

        Thread.sleep(1000);

        mbkCommonControlsHelper.pressback(1);

        referAndEarnPage.clickOnEligibleContacts();

        referAndEarnPage.clickOnAllowBtn();

        permissionHelper.permissionAllow();

//        referAndEarnPage.clickOnInvite();
//
//        Thread.sleep(1000);
//
//        mbkCommonControlsHelper.pressback(1);

    }




    public void referInCCBP() throws InterruptedException,IOException {

        homePage.clickCCPayment();

//        if(referAndEarnPage.checkInsightBottomsheet()) {
//            mbkCommonControlsHelper.pressback(1);
//        }

        Thread.sleep(2000);

        mbkCommonControlsHelper.pressback(1);

        referAndEarnPage.clickReferAndEarn();

        // Add the assertions
        mbReporter.verifyTrueWithLogging(referAndEarnPage.getTitleonCCPBPage(), "Is Title Available", false, false);

        referAndEarnPage.clickReferBtn();

        Thread.sleep(1000);

        mbkCommonControlsHelper.pressback(1);


    }

}
