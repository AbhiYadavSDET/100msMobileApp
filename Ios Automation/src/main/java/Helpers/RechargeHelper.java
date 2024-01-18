package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import freemarker.template.utility.SecurityUtilities;
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
    HistoryPage historyPage;
    SecurityPinPage securityPinPage;

    public RechargeHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        historyPage = new HistoryPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void prepaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expAmountOnSuccessScreen) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

        Thread.sleep(3000);

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

        String actualAmountOnPrepaidPaymentScreen = rechargePage.getAmountOnPrepaidPaymentScreen();
        Log.info("Amount on Payment screen :" + actualAmountOnPrepaidPaymentScreen);
        mbReporter.verifyEqualsWithLogging(actualAmountOnPrepaidPaymentScreen, expAmountOnPaymentScreen,"Verify Amount on Payment screen", false, false, true);

        //Click on Pay button
        rechargePage.clickOnPayButton();

        //Verification on Success Screen
        String actualTitle = rechargePage.getTitle();
        String amountOnSuccessScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccessScreen);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(amountOnSuccessScreen, expAmountOnSuccessScreen, "Verify Recharge Amount", false, false, true);

        //Click on back button
        rechargePage.clickBackButton();

        //Close Feedback popup
        rechargePage.closeFeedbackPopup();

        //Click on back button
        rechargePage.clickBackButton();



    }

    public void postpaidRecharge(String number, String amount, String expAmountOnPaymentScreen, String expTitle, String expAmountOnSuccessScreen) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

        Thread.sleep(2000);

        //click on Postpaid
        rechargePage.clickPostpaid();

        Thread.sleep(2000);

        //Click on Enter Name or Mobile No.
        rechargePage.clickEnterNameOrMobileNo();

        if(permissionPage.isPermissionPopUpPresent()) {
            //Click OK on Access your contacts popup
            permissionPage.clickOnAllow();
        }

        //Enter Postpaid Number
        rechargePage.enterPostpaidNumber(number);

        //Select Postpaid Number
        rechargePage.selectNumber();

        //Enter amount for recharge
        rechargePage.enterAmount(amount);

        //Click on Continue Button
        rechargePage.clickOnContinueButton();


        String actualAmountOnPostpaidPaymentScreen = rechargePage.getAmountOnPostpaidPaymentScreen();
        Log.info("Amount on Payment screen :" + actualAmountOnPostpaidPaymentScreen);
        mbReporter.verifyEqualsWithLogging(actualAmountOnPostpaidPaymentScreen, expAmountOnPaymentScreen,"Verify Amount on Payment screen", false, false, true);

        //Click on Pay button
        rechargePage.clickOnPayButton();

        if(securityPinPage.isSecurityPinPageShown())
        {
            securityPinPage.enterSecurityPin();
        }

        Thread.sleep(2000);

        //Verification on Success Screen
        String actualTitle = rechargePage.getTitle();
        String amountOnSuccessScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + actualTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccessScreen);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(amountOnSuccessScreen, expAmountOnSuccessScreen, "Verify Recharge Amount", false, false, true);

        //Click on back button
        rechargePage.clickBackButton();

        //Close Feedback popup
        rechargePage.closeFeedbackPopup();

        //Click on back button
        rechargePage.clickBackButton();

        //Click History
        historyPage.clickHistory();


    }

    public void changeOperator(String circleName, String expOperatorName, String expCircleName) throws InterruptedException, IOException{

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Provide loaction access while using app
        permissionPage.clickAllowWhileUsingApp();

        //Click on Mobile option
        rechargePage.clickMobile();

        Thread.sleep(2000);

        //Tap to select my number
        rechargePage.selectMyNumber();

        Thread.sleep(2000);

        //Click on Change operator
        rechargePage.clickOnChangeOperator();

        //Select reliance operator
        rechargePage.selectOperator();

        //Click on search circle
        rechargePage.searchCircle();

        //Enter circle
        rechargePage.enterCircle(circleName);

        //Select circle
        rechargePage.selectCircle();

        Thread.sleep(2000);

        //Verification on Search Plan screen
        String operatorName = rechargePage.getOperatorName();
        String circle = rechargePage.getCircleName();

        // Display the values
        Log.info("Operator Name : " + operatorName);
        Log.info("Circle Name : " + circle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(operatorName, expOperatorName, "Verify Operator Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(circle, expCircleName, "Verify Circle Name", false, false, true);


    }

}
