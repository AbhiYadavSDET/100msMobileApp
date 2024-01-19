package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class CheckoutHelper {

    AndroidDriver<AndroidElement> driver;
    P2PExtraPage p2PExtraPage;
    MBReporter mbReporter;
    CheckoutPage checkoutPage;

    PermissionHelper permissionHelper;



    public CheckoutHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        p2PExtraPage=new P2PExtraPage(driver);
        mbReporter = new MBReporter(driver);
        checkoutPage=new CheckoutPage(driver);

    }



    public void validateXtraCheckoutFlow(String expTitle, String bankPageTitleExpected, String expectedAccountNumber, String expectedIFSCNumber, String expectedAccountHolderName, String expectedBankName, String expectedAccountType) throws IOException, InterruptedException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        // Click on the Tooltip
        p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFlexiFromNavBar();

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----NetBanking Check-----");

        //Click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        //Select NetBanking from XTRA checkout screen
        checkoutPage.selectNBOnCheckoutScreen();

        Thread.sleep(2000);

        // Get bank page heading
        String actualTitle = checkoutPage.getBankPageTitleNetbanking();

        Log.info("Bank List Page Title : " + actualTitle);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Xtra Net Banking Flow Bank List Shown", false, false, true);

        checkoutPage.selectKotakBankFromBAnkList();

        permissionHelper.permissionAllow();

        String bankPageTitleActual=checkoutPage.getBankPageTitleWeb();

        Log.info("Bank Otp Page Title : " + bankPageTitleActual);

        mbReporter.verifyEqualsWithLogging(bankPageTitleActual, bankPageTitleExpected, "Net Banking Flow Web Page Open", false, false, true);

        checkoutPage.selectBackBtn();

        if(checkoutPage.isCancelTransactionPopUpShown()){
            checkoutPage.yesCancelTransaction();
        }


        Log.info("-----Checkout Flow Open-----");

        Log.info("-----IMPS/NEFT/RTGS Check-----");

        //Click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        checkoutPage.selectIMPSOnCheckoutScreen();
        Thread.sleep(1000);

        mbReporter.verifyTrueWithLogging(checkoutPage.isImpsPageOpened(), "Bank Page opened with 2 Step Process of Transferring Amount", false,false);

        checkoutPage.clickViewBankAccountDetails();

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountNumber(),expectedAccountNumber, "Validate Bank Account Number", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsIFSCNumber(),expectedIFSCNumber, "Validate Bank IFSC Number", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountHolderName(),expectedAccountHolderName, "Validate Bank Account Holder Name", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsBankName(),expectedBankName, "Validate Bank Name", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountType(),expectedAccountType, "Validate Bank Account Type", false,false);

        checkoutPage.goBackFromBankDetailsPage();

    }


    public void validateXtraCheckoutUpiModeHandling(String amount) throws IOException, InterruptedException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        // Click on the Tooltip
        p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFlexiFromNavBar();


        p2PExtraPage.enterInvestmentAmount(amount);

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----UPI Module Check----- Amount : " + amount);

        mbReporter.verifyTrueWithLogging(checkoutPage.isUpiModeVisible(), "Upi Mode should be Visible when amount is =< Rs. 100000", false, false);

        driver.navigate().back();

        amount = amount + 1;

        p2PExtraPage.enterInvestmentAmount(amount);

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----UPI Module Check----- Amount : " + amount);

        mbReporter.verifyTrueWithLogging(!checkoutPage.isUpiModeVisible(), "Upi Mode should not be Visible when amount is > Rs. 100000", false, false);

        driver.navigate().back();


    }

}





