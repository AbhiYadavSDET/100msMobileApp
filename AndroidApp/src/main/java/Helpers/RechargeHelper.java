package Helpers;

import PageObject.HomePage;
import PageObject.RechargePage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RechargeHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    RechargePage rechargePage;
    PermissionHelper permissionHelper;
    AddMoneyHelper addMoneyHelper;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public RechargeHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    public void prepaidRecharge(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, JSONException {
        Thread.sleep(2000);
//        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);

        rechargePage.clickOnDropDown();

        Element.waitForVisibility(driver, By.id("mkab_title"));
        screen.swipeUpMedium(driver);
        rechargePage.selectOperator();

        Element.waitForVisibility(driver, By.id("mkab_title"));
        rechargePage.selectCircle();

        rechargePage.clickOnSeeAllPlans();

        boolean seeAllPlans = Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'TOPUP']"));

        mbReporter.verifyTrueWithLogging(seeAllPlans, "Plans Page loaded", true, true);

        rechargePage.clickOnBackButtonPlansPage();

        Thread.sleep(300);

        rechargePage.selectAmount();

        rechargePage.enterAmount(amount);

        rechargePage.clickOnContinue();

        // Apply coupon code if applicable
        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeRecharge(promoCode);
        }

        rechargePage.clickOnCtaCotinue();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);


        for(int i=0; i<4; i++){

            if(Element.isElementPresent(driver, By.id("base_title"))){
                Log.info("Success Page");
                break;

            }else{

                if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Convert to Cash']"))){
                    rechargePage.selectCrossIcon();
                }

                i++;

            }

        }



        // Wait for the success screen

        Element.waitForVisibility(driver, By.id("base_title"));

        mbkCommonControlsHelper.handleCTOverlay();
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageStatus(), trxStatus, "Success Page | Verify Status", false, false);

        // Assertions on the success screen

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Connection Number']/following::android.widget.TextView[1]") )) {
            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageConnectionNo(), mobileNo, "Success Page | Verify Connection number", false, false);
        }

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Category']/following::android.widget.TextView[1]"))) {
            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageCategory(), category, "Success Page | Verify category", false, false);
        }

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Operator']/following::android.widget.TextView[1]"))) {
            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageOperator(), operator, "Success Page | Verify operator", false, false);
        }

        if(Element.isElementPresent(driver, By.id("amount_value"))) {
            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageAmount().replace("₹ ", ""), amount, "Success Page | Verify amount", false, false);
        }

        if(Element.isElementPresent(driver, By.id("total_amount_value"))) {
            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageTotalPayment().replace("₹ ", ""), totalPayment, "Success Page | Verify totalPayment", false, false);
        }

        // Assert the Success page in case promo code is applied
        if (promoCodeStatus) {
            String actualPromoCodeText = rechargePage.getPromoCodeTextOnSuccessScreen();
            String expectedPromoCodeText = "Congrats! SuperCash worth ₹ " + promoCodeText + " will be credited within 48 hours";
            mbReporter.verifyEqualsWithLogging(actualPromoCodeText, expectedPromoCodeText, "After TRX | Verify Promo Code Text", false, false);

        }

        mbkCommonControlsHelper.returnToHomePageFromRechargeSuccessScreen();

        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Post TRX assertions
        Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;

        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);

    }

    public void postpaidPayment(String mobileNo, String popupError, String popupText, String operator) throws InterruptedException, IOException, JSONException {

//        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);
        Thread.sleep(3000);
        rechargePage.clickOnPostPaid();


        rechargePage.clickOnCtaContinue2();
        Thread.sleep(10000);

        if (!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']")))) {

            String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
            String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
            String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

            mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
            mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
            mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();
        } else {
            Log.info("No dues");
            // Assertions

            if(Element.isElementPresent(driver, By.id("title_text"))) {

                String actualPopupError = rechargePage.getPopupError();
                mbReporter.verifyEqualsWithLogging(actualPopupError, "Error", "Popup | Error message", false, false);

            }

            if(Element.isElementPresent(driver, By.id("body_text"))) {

                String actualPopupText = rechargePage.getPopupText();
                mbReporter.verifyEqualsWithLogging(actualPopupText, "No dues", "Popup | Message", false, false);

            }

            rechargePage.clickOnPopupCross();

            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();
        }


    }

    public void postpaidPaymentViaSavedConnection(String mobileNo, String popupText, String category, String operator, String successScreenOperatorText) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();


        if (selectSavedConnection(mobileNo, category, operator)) {

            Thread.sleep(10000);

            if (!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']")))) {

                String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
                String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
                String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

                mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, successScreenOperatorText, "Success Page | Verify Operator", false, false);
                mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
                mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

                mbkCommonControlsHelper.clickUpButton();
                mbkCommonControlsHelper.clickUpButton();
            } else {
                Log.info("No dues");
                // Assertions
                String viewBillText = rechargePage.getViewBillText();

                mbReporter.verifyEqualsWithLogging(viewBillText, "No dues", "ViewBill | text", false, false);


//                rechargePage.clickOnPopupCross();

                mbkCommonControlsHelper.clickUpButton();
                mbkCommonControlsHelper.clickUpButton();
            }


        } else {
            Log.info("The saved connection is not present");


        }


    }

    public void rechargeDthInvalidAmount(String mobileNo, String amount, String securityPin, String errorMessage) throws InterruptedException, IOException, JSONException, TesseractException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        rechargePage = homePage.clickOnDthButton();

        permissionHelper.permissionAllow();
        Thread.sleep(5000);
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = '" + mobileNo + "']"))) {
            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + mobileNo + "']"));
            Element.selectElement(driver, androidElement, "Select Saved Connection");

            rechargePage.enterDthAmount(amount);

            rechargePage.clickOnDthContinueCta();

            rechargePage.clickOnCtaCotinue();

            mbkCommonControlsHelper.handleSecurityPin(securityPin);

            Thread.sleep(3000);
            String path = mbReporter.screenShot1("toast", "rechargeInvalidAmount");
            Log.info(path);
            String[] text = screen.readToastMessage("screenshots/toast", path).split("\\r?\\n");
            int len = text.length;

            for (String e : text) {
                Log.info(e);
            }
            String actualErrorText = text[len - 2] + text[len - 1];
            mbReporter.verifyEqualsWithLogging(actualErrorText, errorMessage, "Verify Error Message", false, false);
        } else {
            Log.info("Connection not present");
        }

    }

    public boolean selectSavedConnection(String mobileNo, String category, String operator) throws InterruptedException {


        for (int i = 0; i < 3; i++) {
            if (Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"))) {
                Log.info("SCROLL", "Screen");
                Screen.swipeUpMedium(driver);

                Log.info("SELECT", "Saved Connection");
                AndroidElement androidElement = element.findElement(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"));
                Element.selectElement(driver, androidElement, "Select Connection");
                return true;
            } else {
                Screen.swipeUpMedium(driver);
                Thread.sleep(2000);
            }
        }

        return false;
    }


    public void viewBillGas(String operator, String mobileNo) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        homePage.clickMoreIcon();
        rechargePage = homePage.clickGasIcon();

        permissionHelper.permissionAllow();

        rechargePage.clickOnDropDown();

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"))) {
            rechargePage.selectOperator(operator);
        } else {
            screen.swipeUpMedium(driver);
            rechargePage.selectOperator(operator);
        }

        rechargePage.enterBpNumber(mobileNo);

        rechargePage.clickOnCtaContinue2();
        Thread.sleep(10000);
        if (!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']")))) {

            String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
            String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
            String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

            mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
            mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
            mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();
        } else {
            Log.info("No dues");
            // Assertions
            String actualPopupError = rechargePage.getPopupError();
            String actualPopupText = rechargePage.getPopupText();

            mbReporter.verifyEqualsWithLogging(actualPopupError, "Error", "Popup | Error message", false, false);
            mbReporter.verifyEqualsWithLogging(actualPopupText, "No dues", "Popup | Message", false, false);


            rechargePage.clickOnPopupCross();

            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();
        }

    }

    public void viewBillMtnlDelhi(String operator, String telephoneNo) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();

        String[] arr = telephoneNo.split("\\|");
        String expectedtelephoneNo = arr[arr.length - 2];
        String expectedCan = arr[arr.length - 1];
//        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }


        homePage.clickMoreIcon();
        rechargePage = homePage.clickLandlineIcon();

        permissionHelper.permissionAllow();

        rechargePage.clickOnDropDown();

        rechargePage.selectOperator(operator);

        rechargePage.enterTelephoneNumber(expectedtelephoneNo);

        rechargePage.enterCanNumber(expectedCan);

        rechargePage.clickOnCtaContinue2();

        String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
        String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
        String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, expectedCan, "Success Page | Verify Telephone Number", false, false);
        mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();

    }

    public void creditCardRechargeWapgFlow(String amount, String securityPin, String cardNo, String cvv, String bankPassword, String success_page_status, String success_page_text, Boolean promoCodeStatus, String promoCode) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        homePage.clickMoreIcon();
        rechargePage = homePage.clickCreditCardIcon();

        permissionHelper.permissionAllow();

        rechargePage.selectCreditCardFromSavedConnection();

        rechargePage.enterCreditCardAmount(amount);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));

        rechargePage.clickOnCreditCardContinueCta();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));

        // Apply coupon code if applicable
        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeRecharge(promoCode);
        }

        rechargePage.clickOnCtaCotinue();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        Thread.sleep(3000);

        addMoneyHelper = new AddMoneyHelper(driver);
        addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);


        Element.waitForVisibility(driver, By.id("base_title"));


        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success, WAPG transaction was success", true, true);

        String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, true);

        String actualPendingDescription = rechargePage.getPendingDescMessage();

        mbReporter.verifyEqualsWithLogging(actualPendingDescription, success_page_text, "Verify Pening Message", true, true);


        if (promoCodeStatus) {

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);
        }

        rechargePage.backToHomeFromPendingScreen();

        homePage.closeRechargeServicesOverlay();

        Thread.sleep(300);


    }

    public void creditCardRechargeWapgFlowVoucherSameAmount(String amount, String securityPin, String success_page_status, String success_page_text) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        homePage.clickMoreIcon();
        rechargePage = homePage.clickCreditCardIcon();

        permissionHelper.permissionAllow();

        rechargePage.selectCreditCardFromSavedConnection();

        rechargePage.enterCreditCardAmount(amount);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));

        rechargePage.clickOnCreditCardContinueCta();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));


        rechargePage.clickApplyCoupon();

        Element.waitForVisibility(driver, By.id("redeem_layout"));


        List<AndroidElement> vouchers = Element.findElements(driver, By.id("redeem_layout"));
        int noOfVouchersAvailable = vouchers.size();

        if (noOfVouchersAvailable > 0) {

            rechargePage.selectVoucher();

            Thread.sleep(1000);

            rechargePage.clickOnCtaCotinue();

            mbkCommonControlsHelper.handleSecurityPin(securityPin);

            Thread.sleep(3000);

            Element.waitForVisibility(driver, By.id("base_title"));


            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success with voucher applied of same amount", true, true);

            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");

            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, true);

            String actualPendingDescription = rechargePage.getPendingDescMessage();

            mbReporter.verifyEqualsWithLogging(actualPendingDescription, success_page_text, "Verify Pending Message", true, true);

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);

            rechargePage.backToHomeFromPendingScreen();

            homePage.closeRechargeServicesOverlay();

            Thread.sleep(300);

        } else {

            mbReporter.verifyFalse(noOfVouchersAvailable < 1, "No vouchers Available", true, true);
        }

    }

    public void creditCardRechargeWapgFlowMoreAmountThanVoucher(String amount, String securityPin, String cardNo, String cvv, String bankPassword, String success_page_status, String success_page_text) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {

            screen.swipeUpMedium(driver);
        }

        homePage.clickMoreIcon();
        rechargePage = homePage.clickCreditCardIcon();

        permissionHelper.permissionAllow();

        rechargePage.selectCreditCardFromSavedConnection();

        rechargePage.enterCreditCardAmount(amount);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));

        rechargePage.clickOnCreditCardContinueCta();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));


        rechargePage.clickApplyCoupon();

        Element.waitForVisibility(driver, By.id("redeem_layout"));


        List<AndroidElement> vouchers = Element.findElements(driver, By.id("redeem_layout"));
        int noOfVouchersAvailable = vouchers.size();

        if (noOfVouchersAvailable > 0) {

            rechargePage.selectVoucher();

            Thread.sleep(1000);

            rechargePage.clickOnCtaCotinue();

            mbkCommonControlsHelper.handleSecurityPin(securityPin);

            Thread.sleep(3000);

            addMoneyHelper = new AddMoneyHelper(driver);
            addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);

            Element.waitForVisibility(driver, By.id("base_title"));


            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success, voucher applied and Wapg Transaction success", true, true);

            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");

            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, true);

            String actualPendingDescription = rechargePage.getPendingDescMessage();

            mbReporter.verifyEqualsWithLogging(actualPendingDescription, success_page_text, "Verify Pending Message", true, true);


            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);


            rechargePage.backToHomeFromPendingScreen();

            homePage.closeRechargeServicesOverlay();

            Thread.sleep(300);

        } else {

            mbReporter.verifyFalse(noOfVouchersAvailable < 1, "No vouchers Available", true, true);
        }

    }


}
