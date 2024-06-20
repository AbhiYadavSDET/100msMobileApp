package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class RechargeHelper {


    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    Screen screen;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;


    public RechargeHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage = new RechargePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionsPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }


    public void postpaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expSubTitle, String expAmountOnSuccessScreen, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        //
        // rechargePage.clickEnableSecureLoginBottomSheet();

        //
        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        //Press back to close Third Time Lucky Popup
        //rechargePage.clickThirdTimeLuckyPopupRemove();

        // Click on outside Swipe Left Bottom Popup
       if(rechargePage.checkSwipeLeftBottom()) {
           rechargePage.clickSwipeLeftBottomRemove();
       }

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Postpaid
        rechargePage.clickOnPostpaid();

        // Click on Select Number
        rechargePage.selectNumberPostpaid();

        // Enter amount on payment screen
        rechargePage.setEnterAmountPostpaid(amount);

        // Click on Continue
        rechargePage.clickOnContinue();


        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        rechargePage.clickOnPay();

        // checking for security pin
        if (securityPinPage.checkSecurityPinPage()) {
            securityPinPage.enterSecurityPin();
        }

        mbkCommonControlsHelper.handle2FADeviceBindingFlow();

        // Verification on the Success Screen
        String title = rechargePage.getTitle();
        String subTitle = rechargePage.getSubTitle();
        String amountOnSuccesScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);


        // Add the assertions
        mbReporter.verifyEquals(title, expTitle, "Verify Title", false, false);
        mbReporter.verifyEquals(subTitle, expSubTitle, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Gold Amount", false, false);

        mbkCommonControlsHelper.pressback(1);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);


    }


    public void prepaidRecharge(String amount, String expAmountOnPaymentScreen, String expTitle, String expSubTitle, String expAmountOnSuccessScreen, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        //
        // rechargePage.clickEnableSecureLoginBottomSheet();

        //
        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        //Press back to close Third Time Lucky Popup
        //rechargePage.clickThirdTimeLuckyPopupRemove();

        // Click on outside Swipe Left Bottom Popup
        if(rechargePage.checkSwipeLeftBottom()) {
            rechargePage.clickSwipeLeftBottomRemove();
        }

        // Click on Mobile
        rechargePage.clickOnMobile();

        //Click on my number
        rechargePage.clickOnMyNumber();

        // Tap to search plan
        rechargePage.tapToSearchPlan();

        // Enter amount to search plan
        rechargePage.searchPlanPrepaid(amount);

        // Click to select plan
        rechargePage.selectPlan();


        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        rechargePage.clickOnPay();

        if (securityPinPage.checkSecurityPinPage()) {
            securityPinPage.enterSecurityPin();
        }

        // Verification on the Success Screen
        String title = rechargePage.getTitle();
        String subTitle = rechargePage.getSubTitle();
        String amountOnSuccesScreen = rechargePage.getAmountOnSuccessScreen();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount On Success Screen : " + amountOnSuccesScreen);


        // Add the assertions
        mbReporter.verifyEquals(title, expTitle, "Verify Title", false, false);
        mbReporter.verifyEquals(subTitle, expSubTitle, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(amountOnSuccesScreen, expAmountOnSuccessScreen, "Verify Gold Amount", false, false);

        mbkCommonControlsHelper.pressback(2);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Sub");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

    }

    public void changeOperator(String circle, String expOperatorName, String expCircleName) throws InterruptedException, IOException {


        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        //
        // rechargePage.clickEnableSecureLoginBottomSheet();

        //
        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        //Press back to close Third Time Lucky Popup
        //rechargePage.clickThirdTimeLuckyPopupRemove();

        // Click on outside Swipe Left Bottom Popup
        if(rechargePage.checkSwipeLeftBottom()) {
            rechargePage.clickSwipeLeftBottomRemove();
        }

        // Click on Mobile
        rechargePage.clickOnMobile();

        // Click on Select Number
        rechargePage.clickOnMyNumber();
//        rechargePage.selectNumberPrepaid();

        //Click on Change button
        rechargePage.clickChangeButton();

        //Select an operator
        rechargePage.selectAirtelOperator();

        //Click on search your circle
        rechargePage.clickOnSearchCircle();

        //Enter circle name
        rechargePage.enterCircleName(circle);

        //Select circle
        rechargePage.selectCircle();

        Thread.sleep(2000);

        //Verification on Search Plan screen
        String operatorName = rechargePage.getOperatorName();
        String circleName = rechargePage.getCircleName();

        // Display the values
        Log.info("Operator Name : " + operatorName);
        Log.info("Circle Name : " + circle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(operatorName, expOperatorName, "Verify Operator Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(circle, expCircleName, "Verify Circle Name", false, false, true);

    }

    public void changePrepaidToPostpaid(String number, String circle, String expOperatorName, String expCircleName) throws InterruptedException, IOException{

        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        //
        // rechargePage.clickEnableSecureLoginBottomSheet();

        //
        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        //Press back to close Third Time Lucky Popup
        //rechargePage.clickThirdTimeLuckyPopupRemove();

        // Click on outside Swipe Left Bottom Popup
        if(rechargePage.checkSwipeLeftBottom()) {
            rechargePage.clickSwipeLeftBottomRemove();
        }

        // Click on Mobile
        rechargePage.clickOnMobile();

        //Click on Search Mobile no. text field
        rechargePage.clickOnSearchMobileNoField();

        if(permissionsPage.isPermissionContactsPresent()){

            permissionsPage.allowPermissionContacts();
        }

        //Enter mobile no.
        rechargePage.enterMobileNo(number);

        //Select mobile no.
        rechargePage.selectNumber();

        //Click on Change button
        rechargePage.clickChangeButton();

        //Click on switch to postpaid
        rechargePage.clickOnSwitchToPostpaid();

        //Click on Reliance operator
        rechargePage.selectRelianceOperator();

        //Click on search your circle
        rechargePage.clickOnSearchCircle();

        //Enter circle name
        rechargePage.enterCircleName(circle);

        //Select circle
        rechargePage.selectCircle();

        Thread.sleep(2000);

        //Verification on Search Plan screen
        String operatorName = rechargePage.getRelianceOperatorName();
        String circleName = rechargePage.getCircleName();

        // Display the values
        Log.info("Operator Name : " + operatorName);
        Log.info("Circle Name : " + circle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(operatorName, expOperatorName, "Verify Operator Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(circle, expCircleName, "Verify Circle Name", false, false, true);


    }



    public void couponCodeHandling(String amount,String exptitleErrorOnInvalidCoupon) throws InterruptedException, IOException {


        // scroll to Recharge And PayBills
        rechargePage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        rechargePage.clickRechargeAndPayBills();

        if (rechargePage.clickMobileRechargeAlert()) {
            rechargePage.clickToCloseMobileRechargeAlert();
        }

        if(rechargePage.checkAutoPayBottomsheet()) {
            rechargePage.clickSkipbtn();
        }

        // Click on outside Swipe Left Bottom Popup
        if(rechargePage.checkSwipeLeftBottom()) {
            rechargePage.clickSwipeLeftBottomRemove();
        }

        // Click on Mobile
        rechargePage.clickOnMobile();

        //Click on my number
        rechargePage.clickOnMyNumber();

        // Tap to search plan
        rechargePage.tapToSearchPlan();

        // Enter amount to search plan
        rechargePage.searchPlanPrepaid(amount);

        // Click to select plan
        rechargePage.selectPlan();
        Thread.sleep(3000);
        rechargePage.clickOnApplyCoupon();
        Thread.sleep(3000);
        rechargePage.enterCouponCode("abcdf");
        rechargePage.clickOnApplyButtonOnCoupon();
        // Verification on the Success Screen
        String titleErrorOnInvalidCoupon = rechargePage.getErrorOnCouponEnter();
      ;
        Log.info("Error on Invalid coupon code : " + titleErrorOnInvalidCoupon);

        // Add the assertions
        mbReporter.verifyEquals(titleErrorOnInvalidCoupon, exptitleErrorOnInvalidCoupon, "Error on Invalid coupon code", false, false);
        rechargePage.clickOnfirstSupercash();

    }



}
