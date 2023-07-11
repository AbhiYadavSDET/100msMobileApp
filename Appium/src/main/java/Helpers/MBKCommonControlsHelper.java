package Helpers;

import PageObject.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import Logger.Log;
import org.openqa.selenium.By;
import Utils.Element;
import Utils.Elements;
import Utils.Screen;
import Utils.MBReporter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MBKCommonControlsHelper {

    AndroidDriver driver;
    MbkCommonControlsPage mbkCommonControlsPage;
    Element element;
    Elements elements;
    WalletBalancePage walletBalancePage;
    Screen screen;
    TransactionHistoryPage transactionHistoryPage;
    SideDrawerPage sideDrawerPage;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    MBReporter mbReporter;

    enum BalanceType {
        MAINBALANCE,
        FOODBALANCE,
        SUPERCASH,
        MONEYADDED,
    }

    public String getBalance(HashMap<String, String> balance, BalanceType balanceType) {
        switch (balanceType) {
            case MAINBALANCE:
                return balance.get("Balance");
            case SUPERCASH:
                return balance.get("Supercash");

            case MONEYADDED:
                return balance.get("AddMoney");


            case FOODBALANCE:
                return balance.get("Food Reimbursement");

            default:
                return "Empty";

        }
    }

    public void verifyWalletBalanceAfterTransaction(AndroidDriver driver, HashMap<String, String> balanceBefore, HashMap<String, String> balanceAfter , String amount , String change) throws IOException {


        Double actualMainBalanceAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAddedAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double actualSupercashAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Double expectedMainBalanceAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 ;
        Double expectedMoneyAddedAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 ;
        Double expectedSupercashAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        if(change.charAt(0) == 'a' || change.charAt(0) == 'A'){
            expectedMainBalanceAfter = expectedMainBalanceAfter + Double.parseDouble(amount) * 100;
            expectedMoneyAddedAfter = expectedMoneyAddedAfter + Double.parseDouble(amount) * 100;
        }
        else{
            expectedMainBalanceAfter = expectedMainBalanceAfter - Double.parseDouble(amount) * 100;
            expectedMoneyAddedAfter = expectedMoneyAddedAfter - Double.parseDouble(amount) * 100;
        }

        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "Post TRX | Verify Wallet Main Balance", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualMoneyAddedAfter, expectedMoneyAddedAfter, "Post TRX | Verify Money Added Balance", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualSupercashAfter, expectedSupercashAfter, "Post TRX | Verify Supercash Balance", false, false,true);


    }




    public MBKCommonControlsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        element = new Element(driver);
        elements = new Elements(driver);
        screen = new Screen(driver);
        walletBalancePage = new WalletBalancePage(driver);
        transactionHistoryPage = new TransactionHistoryPage(driver);
        sideDrawerPage = new SideDrawerPage(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver);

    }


    public void applyPromoCodeGold(String promoCode) {
        mbkCommonControlsPage.applyPromoCode(promoCode);
    }

    public void applyPromoCodeRecharge(String promoCode) {
        mbkCommonControlsPage.applyRechargePromoCode(promoCode);
    }

    public void applyPromoCodeAddMoney(String promoCode) {

        // Click on Have a Promo code
        mbkCommonControlsPage.clickOnHavePromoCode();

        // Enter Code
        mbkCommonControlsPage.enterPromoCode(promoCode);

        // Click on Apply button
        mbkCommonControlsPage.clickOnApplyButton();

    }


    /**
     * This method is use to handle Add money anywhere.
     * activity values "withinTestCase"=for recreating insufficient Flows
     * activity values "BeforeTestCase"=for recreating sufficient Flows
     */

    public void handleAddMoney(String activity, String requiredAmount, String cardNo, String expiryMonthYear, String cvv) throws InterruptedException, IOException {

        if (activity.equalsIgnoreCase("BeforeTestCase")) {

            HashMap<String, String> currentBalance = getBalance();
            String balance = currentBalance.get(BalanceType.MONEYADDED);

            if (Double.parseDouble(requiredAmount) > Double.parseDouble(balance)) {

                int amountToAdd = Integer.parseInt(requiredAmount) - Integer.parseInt(balance);

                String amount = String.valueOf(amountToAdd);

                homePage.openBalanceDrawer();

                addMoneyPage = homePage.clickOnAddMoneyButton();

                // Click on the text box and Enter amount
                //addMoneyPage.clickOnAmountTextBox();
                addMoneyPage.enterAmount(amount);

                Thread.sleep(1000);

                //addMoneyPage.clickOnContinueButton();

                AddMoneyHelper addmoneyHelper = new AddMoneyHelper(driver);
                //addmoneyHelper.handleAddMoney(cardNo, expiryMonthYear, cvv);

            }

        } else {

            AddMoneyHelper addmoneyHelper = new AddMoneyHelper(driver);
            //addmoneyHelper.handleAddMoney(cardNo, expiryMonthYear, cvv);

        }

    }

    public void handleAddMoneyTillOtpPage(String cardNo, String expiryMonthYear, String cvv, String paymentFlow) throws InterruptedException, IOException {

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(driver);
        //addmoneyHelper.handleAddMoney(cardNo, expiryMonthYear, cvv, true, paymentFlow);

    }


    public void handleSecurityPin(String pin) throws InterruptedException {
        String[] pinArr = pin.split("|");

        if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {

            for (String e : pinArr) {
                //Log.info("PRESS", e);
                AndroidElement androidElement = element.findElement(driver, By.id("btn_pin_" + e));
                Element.selectElement(driver, androidElement, e);
            }

        }
    }

    public void handleRechargeAmountKeyboard(String amt) throws InterruptedException {
        String[] amtArr = amt.split("|");

        if (Element.isElementPresent(driver, By.id("layout_keyboard_btns"))) {

            for (String e : amtArr) {
                //Log.info("PRESS", e);
                AndroidElement androidElement = element.findElement(driver, By.id("btn_pin_" + e));
                Element.selectElement(driver, androidElement, e);
            }

        }
    }

    public void handleUpiPin(String pin) throws InterruptedException {

        String[] pinArr = pin.split("|");

        Element.waitForVisibility(driver, By.xpath("//android.widget.TableLayout[@index='2']"));
        Log.info(" Waiting for Element");

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TableLayout[@index='2']"))) {

            for (String e : pinArr) {
                Log.info("PRESS", e);
                AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text='" + e + "']"));
                Element.selectElement(driver, androidElement, e);
            }

            //Click on submit icon

            AndroidElement clickElement = element.findElement(driver, By.xpath("//android.widget.TableRow[@index='3']/android.widget.ImageView[@index='2']"));
            Element.selectElement(driver, clickElement, "Submit UPI Pin");

        }
    }

    public void clickUpButton() throws InterruptedException {
        Thread.sleep(1000);
        mbkCommonControlsPage.clickOnUpButton();
    }


    public void clickUpButton2() throws InterruptedException {
        Thread.sleep(1000);
        mbkCommonControlsPage.clickOnUpButton2();
    }

    public void returnToHomePageFromRechargeSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
        handleRatingsPopUp();
        handleNPS();
    }


    public void returnToHomePageFromRechargeSuccessScreenBackButton() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageBackbutton();
        handleRatingsPopUp();
        handleNPS();
    }

    public void returnToHomePageFromP2MSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
        handleRatingsPopUp();
        handleNPS();
    }

    public void returnToHomePageFromSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
        handleRatingsPopUp();
        handleNPS();

        if (Element.isElementPresent(driver, By.id("close_button"))) {
            mbkCommonControlsPage.closeAddmoneyBottomSheet();
        }
    }

    public void returnToHomePage() throws InterruptedException {
        mbkCommonControlsPage.clickOnNavigateHome();
    }

    public void returnToHomePageByBackArrow() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageBackbutton();
    }


    public LinkedHashMap<String, String> getBalance() throws InterruptedException, IOException {

        Log.info("START", "Fetch Wallet balance");

        LinkedHashMap<String, String> walletBalance = new LinkedHashMap<>();

        // Click on the Wallet balance Drop down
        HomePage homePage = new HomePage(driver);
        homePage.clickWalletBalanceDropDown();

        Thread.sleep(2000);

        // Display the Nos. of balance for the user
        int noOfBalance = Element.findElements(driver, By.id("amount")).size();
        Log.info("noOfBalance - " + (noOfBalance - 2));

        // Get the "Total Balance" and add to Map
        String totalBalance = homePage.getTotalBalance().replace("₹", "");
        walletBalance.put("Balance", totalBalance);

        // Get the "Add Money" Balance
        String addmoney = homePage.getAddMoney().replace("₹", "");
        walletBalance.put("AddMoney", addmoney);


        // Swipe Up if supercash balance card is not present
        if(!homePage.isSuperCashBalancePresent()){

            screen.swipeUpMore(driver);
        }

        // Get the "Supercash" Balance
        String supercash = homePage.getSuperCashBalance().replace("₹", "");
        walletBalance.put("Supercash", supercash);

        Log.info("------------ Balance --------------");

        for (Map.Entry<String, String> e : walletBalance.entrySet()) {
            Log.info(e.getKey(), e.getValue());
        }

        Log.info("-----------------------------------");

        // Click to close profile screen
        homePage.clickCloseWalletBalanceDropDown();

        // Handling Enable secure Pin bottom sheet
        if(!homePage.isZipIconPresent()){
            pressback();
        }

        Log.info("END : Fetch Wallet balance");
        return walletBalance;
    }


    public void handleCTOverlay() throws InterruptedException {
        Thread.sleep(4000);

        if (Element.isElementPresent(driver, By.xpath("//android.widget.RelativeLayout[@index = '0']/android.widget" +
                ".ImageView[@index = '1']"))) {

            Log.info("Handle", "CT Overlay");
            mbkCommonControlsPage.clickOnCtOverLayCross();
        }
    }

    // Added by MS@10 Oct, 2018 to handle the NPS Pop-on pressing back from the success screens
    public void handleNPS() throws InterruptedException {
        Thread.sleep(3000);
        if (Element.isElementPresent(driver, By.id("rating_seekbar"))) {
            Log.info("Handle", "NPS Screen");
            mbkCommonControlsPage.clickOnCross();
            if (Element.isElementPresent(driver, By.id("base_icon_close"))) {
                mbkCommonControlsPage.clickOnSuccessPageCross();
            } else if (Element.isElementPresent(driver, By.id("base_icon_back"))) {
//                mbkCommonControlsPage.clickOnSuccessPageBack();
            }
        }
    }

    // Added by MS@10 Oct, 2018 to handle the Rating Pop-on pressing back from the success screens
    public void handleRatingsPopUp() throws InterruptedException {
        Thread.sleep(3000);
        if (Element.isElementPresent(driver, By.id("content_root"))) {
            Log.info("Handle", "Ratings PopUp");
            mbkCommonControlsPage.clickOnCross();
            if (Element.isElementPresent(driver, By.id("base_icon_close"))) {
                mbkCommonControlsPage.clickOnSuccessPageCross();
            } else if (Element.isElementPresent(driver, By.id("base_icon_back"))) {
//                mbkCommonControlsPage.clickOnSuccessPageBack();
            }

        }
    }


    /*---------------------Home Page Pop Up Handlers---------------------------*/

    public void handleReferAndEarnBottomSheet() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Refer Now']"))) {
            Log.info("Handle", "Refer & Earn Bottom sheet");
            mbkCommonControlsPage.clickOnReferAndEarnBottonSheetCross();
        }
    }

    public void handleUpiBottomSheet(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Link Your Bank Account']"))) {
            Log.info("Handle", "Upi Bottom sheet");
            driver.navigate().back();
        }
    }

    public void handleGetInstantLoanBottomSheet() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.id("cross_button"))) {
            Log.info("Handle", "Get Instant Loan Bottom sheet");
            mbkCommonControlsPage.clickOnGetInstantLoanBottonSheetCross();
        } else if (Element.isElementPresent(driver, By.id("ic_close"))) {
            Log.info("Handle", "Get Instant ZIP Dialogue");
            mbkCommonControlsPage.clickOnLoanDialogueCross();

        }
    }

    public void handleFloatingWidget() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.id("home_floating_widget"))) {
            Log.info("Handle", "Home Floating Widget");
            mbkCommonControlsPage.closeFloatingWidget();
        }
    }

    public void handleClevertapPromotion(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.id("half_interstitial_image"))) {
            Log.info("Handle", "Clevertap Promotion");
//                driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView").click();
            driver.navigate().back();

        } else if (Element.isElementPresent(driver, By.id("alertTitle"))) {
            Log.info("Handle", "Clevertap Promotion Message");
            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'SKIP']"))) {
                driver.findElementById("button1").click();
            } else {
                driver.findElementById("button2").click();
            }
        }

    }

    public void handleSetupSecurityBottomSheet() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Enable secure login']"))) {
            Log.info("Handle", "Setup Security Bottom Sheet");
            mbkCommonControlsPage.closeSecurityBottomSheet();
        }
    }


    public void dismissAllOnHomePage(AndroidDriver driver) throws InterruptedException {
//        Handle Expense Manager Bottom sheet

        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.id("navigation_home"))) {

            Log.info("No Home Card");

        } else if (Element.isElementPresent(driver, By.id("cross_button"))) {
            Log.info("Handle", "Any Other Bottom sheet");
            driver.navigate().back();
        } else {

            Log.info("Checking", "Clevertap Alerts");
            handleClevertapPromotion(driver);

            Log.info("Checking", "Security Bottom sheet");
            handleSetupSecurityBottomSheet();

            Log.info("Checking", "Get Instant Loan Bottom sheet or ZIP Dialogue");
            handleGetInstantLoanBottomSheet();

            Log.info("Checking", "Upi Bottom sheet");
            handleUpiBottomSheet(driver);

            Log.info("Checking", "Refer and Earn Bottom sheet");
            handleReferAndEarnBottomSheet();
        }

        handleFloatingWidget();

    }


    /**
     * ---------------------Home Page Pop Up Handlers---------------------------
     */


    public void handleHomePageLanding() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < 10; i++) {
            if (!Element.isElementPresent(driver, By.id("view_icon_bg"))) {
                driver.navigate().back();
                Log.info("Pressed Back : Due to Pop UP interruption");
                Thread.sleep(1000);
            } else {
                break;
            }
        }
    }

    public void handleHomePage() throws InterruptedException {
        if(mbkCommonControlsPage.isWhitePopUpPresent()){
            mbkCommonControlsPage.closeWhitePopUp();
            Thread.sleep(1000);
        }
        for (int i = 0; i < 10; i++) {
            if (!Element.isElementPresent(driver, By.id("view_icon_bg"))) {
                driver.navigate().back();
                Log.info("Pressed Back : Due to Pop UP interruption");
                Thread.sleep(1000);
            } else {
                break;
            }
        }
    }

    public void uncheckInsuranceCta() throws InterruptedException {
        mbkCommonControlsPage.uncheckInsuranceCheckBox();
    }

    public void pressback(Integer times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            Elements.back(driver, "press back");
        }
    }

    public void pressback() throws InterruptedException {
        Elements.back(driver, "press back");
    }

    // Verify the History Section
    public HashMap<String, String> getHistoryDetails(AndroidDriver driver) throws InterruptedException {
        HistoryPage historyPage;

        historyPage = new HistoryPage(driver);

        // Click on the History Tab
        Thread.sleep(5000);
        historyPage.clickHistoryTab();

        // Get the details from the latest entry in history section
        String historyDescription = historyPage.getDescription();
        String historyAmount = historyPage.getAmount();
        String historyStatus = historyPage.getStatus();

        Log.info(historyDescription);
        Log.info(historyAmount);
        Log.info(historyStatus);

        HashMap<String, String> historyDetails = new HashMap<String, String>();
        historyDetails.put("description", historyDescription);
        historyDetails.put("amount", historyAmount);
        historyDetails.put("status", historyStatus);

        // Click on the History Tab
        historyPage.clickHomeTab();

        return historyDetails;

    }

    public void verifyHistoryDetails(AndroidDriver driver ,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        HashMap<String, String> historyDetails = getHistoryDetails(driver);

        Log.info(historyDetails.get("description"));
        Log.info(historyDetails.get("amount"));
        Log.info(historyDetails.get("status"));

        mbReporter.verifyEqualsWithLogging(historyDetails.get("description"), expectedHistoryDescription, "Post TRX | Verify History Description", false, false,true);
        mbReporter.verifyEqualsWithLogging(historyDetails.get("amount"), expectedHistoryAmount, "Post TRX | Verify History Amount", false, false,true);
        mbReporter.verifyEqualsWithLogging(historyDetails.get("status"), expectedHistoryStatus, "Post TRX | Verify History Status", false, false,true);


    }



}






