package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.PermissionPage;
import PageObject.RechargePage;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RechargeHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    RechargePage rechargePage;
    MBReporter mbReporter;

    public RechargeHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void prepaidRecharge(String amount, String expAmountOnPaymentScreen) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

        Thread.sleep(5000);

        //Tap to select my number
        rechargePage.selectMyNumber();

        Thread.sleep(2000);

        //Click on search plan
        rechargePage.clickPlanSearch();

        //Enter plan amount
        rechargePage.enterPlanAmount(amount);

        Thread.sleep(2000);

        //Tap to select the plan
        rechargePage.selectPlan();

        String actualAmountOnPaymentScreen = rechargePage.getAmountOnPaymentScreen();
        Log.info("Amount on Payment screen :" + actualAmountOnPaymentScreen);
        mbReporter.verifyEqualsWithLogging(actualAmountOnPaymentScreen, expAmountOnPaymentScreen,"Verify Amount on Payment screen", false, false, true);

        //Click on Pay button
        rechargePage.clickOnPayButton();



    }

    public void postpaidRecharge(String number, String amount, String expAmountOnPaymentScreen) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

        Thread.sleep(5000);

        //click on Postpaid
        rechargePage.clickPostpaid();

        //Click on Enter Name or Mobile No.
        rechargePage.clickEnterNameOrMobileNo();

        //Click OK on Access your contacts popup
        rechargePage.clickAllowContactPermission();

        //Enter Postpaid Number
        rechargePage.enterPostpaidNumber(number);

        //Select Postpaid Number
        rechargePage.selectNumber();

        //Enter amount for recharge
        rechargePage.enterAmount(amount);

        //Click on Continue Button
        rechargePage.clickOnContinueButton();


        String actualAmountOnPaymentScreen = rechargePage.getAmountOnPaymentScreen();
        Log.info("Amount on Payment screen :" + actualAmountOnPaymentScreen);
        mbReporter.verifyEqualsWithLogging(actualAmountOnPaymentScreen, expAmountOnPaymentScreen,"Verify Amount on Payment screen", false, false, true);

        //Click on Pay button
        rechargePage.clickOnPayButton();



    }

}
