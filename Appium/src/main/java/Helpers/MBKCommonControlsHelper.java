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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    PermissionHelper permissionHelper;

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

    public void verifyWalletBalanceAfterTransaction(AndroidDriver driver, HashMap<String, String> balanceBefore, HashMap<String, String> balanceAfter, String amount, String change) throws IOException {


        Double actualMainBalanceAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE).replace(",", "")) * 100;
        Double actualMoneyAddedAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED).replace(",", "")) * 100;
        Double actualSupercashAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH).replace(",", "")) * 100;

        Double expectedMainBalanceAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE).replace(",", "")) * 100;
        Double expectedMoneyAddedAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED).replace(",", "")) * 100;
        Double expectedSupercashAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH).replace(",", "")) * 100;

        if (change.charAt(0) == 'a' || change.charAt(0) == 'A') {
            expectedMainBalanceAfter = expectedMainBalanceAfter + Double.parseDouble(amount) * 100;
            expectedMoneyAddedAfter = expectedMoneyAddedAfter + Double.parseDouble(amount) * 100;
        } else {
            expectedMainBalanceAfter = expectedMainBalanceAfter - Double.parseDouble(amount) * 100;
            expectedMoneyAddedAfter = expectedMoneyAddedAfter - Double.parseDouble(amount) * 100;
        }

        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "Post TRX | Verify Wallet Main Balance", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualMoneyAddedAfter, expectedMoneyAddedAfter, "Post TRX | Verify Money Added Balance", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSupercashAfter, expectedSupercashAfter, "Post TRX | Verify Supercash Balance", false, false, true);


    }

    public void verifyWalletBalanceAfterTransactionWithConvenienceFee(AndroidDriver driver, HashMap<String, String> balanceBefore, HashMap<String, String> balanceAfter, String amount, double percentageConvenienceFee) throws IOException {


        Double actualMainBalanceAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAddedAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double actualSupercashAfter = Double.parseDouble(getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Double expectedMainBalanceAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double expectedMoneyAddedAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double expectedSupercashAfter = Double.parseDouble(getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Double actualAmount = Double.parseDouble(amount) * 100;
        Double convFeeAmount = Double.parseDouble(amount) * percentageConvenienceFee;
        Double gstAmount = convFeeAmount * 0.18;
        actualAmount = actualAmount + convFeeAmount + gstAmount;


        Log.info("expectedMainBalanceAfter = " + expectedMainBalanceAfter);
        Log.info("actualAmount = " + actualAmount);
        expectedMainBalanceAfter = expectedMainBalanceAfter - actualAmount;
        expectedMoneyAddedAfter = expectedMoneyAddedAfter - actualAmount;
        Log.info("expectedMainBalanceAfter = " + expectedMainBalanceAfter);


        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "Post TRX | Verify Wallet Main Balance", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualMoneyAddedAfter, expectedMoneyAddedAfter, "Post TRX | Verify Money Added Balance", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSupercashAfter, expectedSupercashAfter, "Post TRX | Verify Supercash Balance", false, false, true);


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
        permissionHelper=new PermissionHelper(driver);

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

    /**---------------------Security Pin Handler---------------------------*/

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




    /**---------------------UPI Pin Handler---------------------------*/
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


    /**---------------------Fetching Balance---------------------------*/

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
        if (!homePage.isSuperCashBalancePresent()) {

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

        handleHomePageLanding();

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



    public void handleSetupSecurityBottomSheet() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Enable secure login']"))) {
            Log.info("Handle", "Setup Security Bottom Sheet");
            mbkCommonControlsPage.closeSecurityBottomSheet();
        }
    }



    /**
     * ---------------------Home Page Pop Up Handlers---------------------------
     */

    public void handleHomePageLanding() throws InterruptedException {

        if(Element.isElementPresentNoWait(driver, By.id("container"))){
            Log.info("Home Page pop interruption Locator  : container");
            Thread.sleep(3000);
            Log.info("Waiting more due to Slow Phone");
        }


//        for (int i = 0; i < 2; i++) {
            if (!Element.isElementPresentNoWait(driver, By.id("cl_root"))) {
//                driver.navigate().back();
//                Log.info("Pressed Back : Due to Pop UP interruption");
                if (Element.isElementPresentNoWait(driver, By.id("alertTitle"))){
                    Log.info("Home Page pop interruption Locator  : alertTitle");
                    driver.findElementByXPath("//android.widget.Button[@text='LATER']").click();
                }
                else if (Element.isElementPresentNoWait(driver, By.id("tv_do_not_want_benefits"))){
                    Log.info("Home Page pop interruption Locator  : tv_do_not_want_benefits");
                    driver.findElementById("tv_do_not_want_benefits").click();
                }
                else if (Element.isElementPresentNoWait(driver, By.id("com.mobikwik_new.debug:id/question_nps"))){
                    Log.info("Home Page pop interruption Locator  : question_nps");
                    driver.findElementById("com.mobikwik_new.debug:id/close_button").click();
                }
                else if(Element.isElementPresentNoWait(driver, By.id("com.mobikwik_new.debug:id/btn_secure_now"))){
                    Log.info("Home Page pop interruption Locator  : btn_secure_now");
                    driver.navigate().back();
                }
                else if(Element.isElementPresentNoWait(driver,By.xpath("//android.widget.TextView[@text='I don’t want benefits']"))){
                    Log.info("Home Page pop interruption Locator  : I don’t want benefits");
                    driver.findElement(By.xpath("//android.widget.TextView[@text='I don’t want benefits']")).click();
                }
                else if (Element.isElementPresentNoWait(driver, By.id("tv_explore_home"))){
                    Log.info("Home Page pop interruption Locator  : Feature Assist Page Shown");
                    driver.findElementById("tv_explore_home").click();
                    Thread.sleep(3000);
                }else {
                    Log.info("Home Page pop interruption Locator  : New Type Pop Up Detected");
                    Log.info("-----------------Page Source Start----------------");
                    Log.info(driver.getPageSource());
                    Log.info("-----------------Page Source End----------------");
                    driver.navigate().back();
                }

//            }else {
//                break;
//            }
        }
        if (Element.isElementPresentNoWait(driver, By.id("ic_close"))) {
            Log.info("Home Page pop interruption Locator  : ic_close");
            driver.findElementById("ic_close").click();
        }


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

        Thread.sleep(2000);

        if (!historyPage.isHistoryDesciptionPresent()) {
            pressback(1);
        }

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

    public void verifyHistoryDetails(AndroidDriver driver, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        HashMap<String, String> historyDetails = getHistoryDetails(driver);

        Log.info(historyDetails.get("description"));
        Log.info(historyDetails.get("amount"));
        Log.info(historyDetails.get("status"));

        mbReporter.verifyEqualsWithLogging(historyDetails.get("description"), expectedHistoryDescription, "Post TRX | Verify History Description", false, false, true);
        mbReporter.verifyEqualsWithLogging(historyDetails.get("amount"), expectedHistoryAmount, "Post TRX | Verify History Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(historyDetails.get("status"), expectedHistoryStatus, "Post TRX | Verify History Status", false, false, true);


    }

    public void handle2FADeviceBindingFlow() throws InterruptedException, IOException {
        Thread.sleep(3000);
        if(Element.isElementPresentNoWait(driver, By.id("btn_verify"))) {

                Log.info("Binding Device with Sim Card");
                mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageTile() ==null), "2FA Page Title : "+mbkCommonControlsPage.get2FAPageTile(), false, false);
                mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageSubTile() ==null), "2FA Page SubTitle : "+mbkCommonControlsPage.get2FAPageSubTile(), false, false);
                mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageNoteDescription() ==null), "2FA Page Note Description : "+mbkCommonControlsPage.get2FAPageNoteDescription(), false, false);

                mbkCommonControlsPage.clickVerifyNumberCta();
                permissionHelper.permissionAllow();

                element.waitForVisibility(driver, By.id("progress_bar"));
                element.waitForInvisibility(driver, By.id("progress_bar"));

                if(mbkCommonControlsPage.isSmsVerificationFailed()){

                    mbkCommonControlsPage.clickRetryNumberVerificationCta();
                    element.waitForVisibility(driver, By.id("progress_bar"));
                    element.waitForInvisibility(driver, By.id("progress_bar"));

                }


        }else {
            Log.info("2FA Flow Not Displayed");
        }
    }

    public Boolean is2FADeviceBindingFlowDisplayed() throws InterruptedException, IOException {
        Thread.sleep(3000);
        if(Element.isElementPresentNoWait(driver, By.id("btn_verify"))) {
            mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageTile() == null), "------------Assertion : 2FA Flow Shown-----------", false, false);
            mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageTile() == null), "2FA Page Title : " + mbkCommonControlsPage.get2FAPageTile(), false, false);
            mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageSubTile() == null), "2FA Page SubTitle : " + mbkCommonControlsPage.get2FAPageSubTile(), false, false);
            mbReporter.verifyTrueWithLogging(!(mbkCommonControlsPage.get2FAPageNoteDescription() == null), "2FA Page Note Description : " + mbkCommonControlsPage.get2FAPageNoteDescription(), false, false);

            return true;
        }else {
            return false;
        }

    }








}






