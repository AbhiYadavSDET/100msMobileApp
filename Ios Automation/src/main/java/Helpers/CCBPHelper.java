package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CCBPHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    RechargePage rechargePage;
    MBReporter mbReporter;
    HistoryPage historyPage;
    CCBPPage ccbpPage;

    public CCBPHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        historyPage = new HistoryPage(driver);
        ccbpPage = new CCBPPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void creditCardPayment(String creditCardNumber, String amount, String expAmountOnPaymentScreen) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Allow loaction permission
        permissionPage.clickAllowWhileUsingApp();

        //Click on Credit card payment
        rechargePage.clickCreditCardPayment();

        Thread.sleep(2000);

        if(ccbpPage.isEmailAccessBottomSheetShown()){
            //Click to close Email Access Bottom sheet
            ccbpPage.closeEmailAccessBottomSheet();
        }

//        Thread.sleep(2000);

        if(ccbpPage.isAddNewCreditCardShown()){
            //Click on Add new Credit card
            ccbpPage.clickAddNewCreditCard();
        }

//        Thread.sleep(3000);

        //Click on Enter credit card number text field
        ccbpPage.clickEnterCreditCardNumber();

        //Enter Credit card number
        ccbpPage.enterCreditCardNumber(creditCardNumber);

        //Click on Continue button
        ccbpPage.clickContinueCTA();

        //Click on Enter amount manually option
        ccbpPage.clickEnterAmountManually();

        //Enter amount manually
        ccbpPage.enterCreditCardNumber(amount);

        //Click on Continue button
        ccbpPage.clickContinueCTA();

        // Verification on the Payment Screen
        String amountOnPaymentScreen = ccbpPage.getAmountOnPaymentScreen();
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, expAmountOnPaymentScreen, "Verify Amount on Payment screen", false, false);

        //Click on Pay button
        ccbpPage.clickOnPayButton();





    }
}