package Helpers;

import PageObject.*;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Helper;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class UpiHelper {

    AndroidDriver driver;
    OnboardingPage onboardingPage;
    LoginPage loginPage;
    ApiCommonControls apiCommonControls;
    HashMap<String, String> apiOtp;
    HomePage homePage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    Screen screen;
    UpiPage upiPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AddMoneyPage addMoneyPage;
    SideDrawerPage sideDrawerPage;
    SecuritySettingsPage securitySettingsPage;
    WalletPage walletPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public UpiHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        // Starting page declaration
        onboardingPage = new OnboardingPage(driver);
        permissionHelper = new PermissionHelper(driver);
        screen = new Screen(driver);
        homePage = new HomePage(driver);
        addMoneyPage = new AddMoneyPage(driver);
        sideDrawerPage = new SideDrawerPage(driver);
        securitySettingsPage = new SecuritySettingsPage(driver);
        walletPage = new WalletPage(driver);


    }

    public void sendMoneyViaUpi(String upiId, String amount, String message, String pin) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

        upiPage = homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        upiPage.clickSendMoney();

        upiPage.selectEnterUPI();

        permissionHelper.permissionAllow();

        upiPage.enterUpiId(upiId);

        upiPage.clickConfrimUpi();

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmPayment();

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(400);

        mbkCommonControlsHelper.handleGullak();

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment sent successfully", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        mbkCommonControlsHelper.handleRatingsPopUp();

    }

    public void sendMoneyToBankViaUpi(String beneficiaryName, String accountNumber, String ifsc, String amount, String message, String pin) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

        upiPage = homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        upiPage.clickSendMoney();

        upiPage.selectTransfertoBank();

        upiPage.enterBeneficiaryName(beneficiaryName);

        upiPage.enterAccountNumber(accountNumber);

        upiPage.enterIfsc(ifsc);

        upiPage.clickConfirmBankDetails();

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmPayment();

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(400);

        mbkCommonControlsHelper.handleGullak();

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment sent successfully", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        mbkCommonControlsHelper.handleRatingsPopUp();

    }

    public void requestMoneyViaUpi(String upiId, String amount, String message) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

        upiPage = homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        upiPage.clickRequestMoney();

        upiPage.selectEnterUPI();

        permissionHelper.permissionAllow();

        upiPage.enterUpiId(upiId);

        upiPage.clickConfrimUpi();

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmRequest();

        Element.waitForVisibility(driver, By.id("payment_success_msg"));

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment request sent successfully", "Request Message Validation", true, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        mbkCommonControlsHelper.handleRatingsPopUp();

        mbkCommonControlsHelper.handleNPS();

    }

    public void checkAccountBalance(String pin) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        homePage.clickCheckBalance();

        Thread.sleep(200);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Link Your Bank Account']"));

        Thread.sleep(2000);

        upiPage = homePage.clickOnLinkBankAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        homePage = upiPage.clickOnBackButton();

        homePage.clickCheckBalance();

        mbkCommonControlsHelper.handleUpiPin(pin);

        Boolean isBalanceVisible = Element.isElementPresent(driver, By.id("balance"));

        String balance = homePage.getAccountBalance();

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("balance")), "Avalaible Balance is =Rs " + balance, true, true);

        homePage.dismissOverlay();


    }

    //Payment Successful
    //Money added into your wallet successfully

    public void addMoneyViaUpi(String pin, String amount, String successPageStatus, String successPageText) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        addMoneyPage.chooseUpiOption();

        addMoneyPage.restoreUpi();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        addMoneyPage.chooseUpiBank();

        mbkCommonControlsHelper.handleUpiPin(pin);

        //Assertions
        Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
        Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Screen | Verify Text", false, false);
        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

    }

    public void deregisterUpi() throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        upiPage = homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);


        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        homePage = upiPage.clickOnBackButton();

        sideDrawerPage = homePage.clickHamburgerIcon();

        securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

        securitySettingsPage.ClickSecurityOptions();

        securitySettingsPage.ClickDeregisterFromOptions();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Deregister Account']"));

        securitySettingsPage.ClickYesDeregisterAccount();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Deregister successful']"));

        boolean deregisterRequest = Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Deregister successful']"));

        mbReporter.verifyTrueWithLogging(deregisterRequest, "Deregister successful", true, true);

        securitySettingsPage.ClickOk();

        homePage = securitySettingsPage.clickBackButton();

        Thread.sleep(100);

        Boolean upiId = Element.isElementPresent(driver, By.id("tx_upi_id"));

        mbReporter.verifyTrueWithLogging(!upiId, "Upi is Deregistered Succesfully", true, true);


    }

    public void registerUpi(String bankName) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        if (Element.isElementPresent(driver, By.id("tx_bank_balance")) == false) {

            sideDrawerPage= homePage.clickHamburgerIcon();
            walletPage = sideDrawerPage.clickOnAccountsPage();

            Thread.sleep(5000);
            for (int i = 0; i < 2; i++) {
                Screen.swipeDownMore(driver);
            }

            homePage.clickOnBottomBarHome();

        }

        homePage.clickCheckBalance();

        upiPage = homePage.clickOnLinkBankAccount();

        Element.waitForVisibility(driver, By.id("mkiv_image"));

        upiPage.enterBankName(bankName);

        upiPage.selectBankFromList();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Select the phone number linked with your Kotak Mahindra Bank Account. An SMS will be triggered from the number to verify your bank account.']"));

        upiPage.selectSim1();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Create New VPA']"));

        String randomVpa = Helper.generateRandomAlphaNumericString(5).toLowerCase();

//        Thread.sleep(5000);

        upiPage.enterVpa(randomVpa);

        upiPage.submitVpa();

        Element.waitForVisibility(driver, By.id("upi_id_label"));

        String upiId = upiPage.upiIdGenerated();

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("upi_id_text")), "Upi ID generated is:" + upiId, true, true);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("account_number")), "Account Number is present", true, true);

        homePage = upiPage.clickBackToHomeFromSetupSuccess();

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= '" + upiId + "']")), "Upi Id is Reflected", true, true);


    }


}
