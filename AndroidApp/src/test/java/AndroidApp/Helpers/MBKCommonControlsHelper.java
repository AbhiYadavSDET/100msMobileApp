package test.java.AndroidApp.Helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.MbkCommonControlsPage;
import test.java.AndroidApp.PageObject.WalletBalancePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MBKCommonControlsHelper {

    AndroidDriver driver;
    MbkCommonControlsPage mbkCommonControlsPage;
    Element element;
    WalletBalancePage walletBalancePage;
    Screen screen;

    enum BalanceType {
        MAINBALANCE,
        FOODBALANCE,
        SUPERCASH,
        MONEYADDED,
    }

    public String getBalance(HashMap<String, String> balance, BalanceType balanceType) {
        switch (balanceType) {
            case MAINBALANCE:
                return balance.get("Available Balance");
            case SUPERCASH:
                return balance.get("SuperCash");


            case MONEYADDED:
                return balance.get("Money Added");


            case FOODBALANCE:
                return balance.get("Food Reimbursement");

            default:
                return "Empty";

        }
    }


    public MBKCommonControlsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        element = new Element(driver);
        screen = new Screen(driver);

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

    public void clickUpButton() {
        mbkCommonControlsPage.clickOnUpButton();
    }

    public void returnToHomePageFromSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
    }

    public void returnToHomePageFromRechargeSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
        handleRatingsPopUp();
        handleNPS();
    }

    public void returnToHomePageFromP2MSuccessScreen() throws InterruptedException {
        mbkCommonControlsPage.clickOnSuccessPageCross();
        handleRatingsPopUp();
        handleNPS();
        //mbkCommonControlsPage.clickOnSuccessPageCross();
    }

    public LinkedHashMap<String, String> getBalance()
            throws InterruptedException, IOException {
        LinkedHashMap<String, String> walletBalance = new LinkedHashMap<>();
        Log.info("START", "Fetch Wallet balance");

        // Goto balance details screen
        HomePage homePage = new HomePage(driver);
        walletBalancePage = homePage.clickOnViewBalance();

        // fetch the balance and add to Map
        Element.waitForVisibility(driver, walletBalancePage.label_available_balance);
        int noOfBalance = Element.findElements(driver, By.xpath("//*/android.widget.ScrollView[@index = '1']/android.widget" +
                ".FrameLayout[@index = 0]/android.widget.LinearLayout[@index = 0]/android.widget.LinearLayout[@index = 0]/android.widget.LinearLayout")).size();
        Log.info("noOfBalance - " + noOfBalance);

        // Fetch the total balance
        String totalBalanceText = walletBalancePage.getTotalBalanceName();
        String totalBalanceValue = walletBalancePage.getTotalBalanceValue();

        walletBalance.put(totalBalanceText, totalBalanceValue);


        // Fetch the rest of the balances
        for (int i = 1; i <= noOfBalance; i++) {


            String balanceText = element.findElement(driver, By.xpath("//*/android.widget.ScrollView/android.widget" +
                    ".FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget" +
                    ".LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android" +
                    ".widget.TextView[@index = '0']")).getText().replace(" “", "").trim();
            String balanceValue = element.findElement(driver, By.xpath("//*/android.widget.ScrollView/android.widget" +
                    ".FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget" +
                    ".LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android" +
                    ".widget.TextView[@index = '1']")).getText().replace("X", "").replace(",", "");


            walletBalance.put(balanceText, balanceValue);

        }

        screen.swipeUpMore(driver);


        // Fetch the supercash balance

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='SuperCash “']"))) {
            String supercashText = "SuperCash";
            String supercashValue = walletBalancePage.getSupercashBalanceValue();
            walletBalance.put(supercashText, supercashValue);
        } else {
            String supercashText = "SuperCash";
            String supercashValue = "0";
            walletBalance.put(supercashText, supercashValue);
        }


        Log.info("------------ Balance --------------");

        for (Map.Entry<String, String> e : walletBalance.entrySet()) {
            Log.info(e.getKey(), e.getValue());
        }

        Log.info("-----------------------------------");

        clickUpButton();

        Log.info("END : Fetch Wallet balance");

        // TO DO
        //Handle Expense Manager Bottom sheet

        return walletBalance;
    }

    public void handleCTOverlay() throws InterruptedException {
        Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.xpath("//android.widget.RelativeLayout[@index = '0']/android.widget" +
                ".ImageView[@index = '1']"))) {

            Log.info("Handle", "CT Overlay");
            mbkCommonControlsPage.clickOnCtOverLayCross();
        }
    }

    // Added by MS@10 Oct, 2018 to handle the NPS Pop-on pressing back from the success screens
    public void handleNPS() throws InterruptedException {
        Thread.sleep(3000);
        if (Element.isElementPresent(driver, By.id("com.mobikwik_new:id/rating_seekbar"))) {
            Log.info("Handle", "NPS Screen");
            mbkCommonControlsPage.clickOnCross();
            mbkCommonControlsPage.clickOnSuccessPageCross();
        }
    }

    // Added by MS@10 Oct, 2018 to handle the Rating Pop-on pressing back from the success screens
    public void handleRatingsPopUp() throws InterruptedException {
        Thread.sleep(3000);
        if (Element.isElementPresent(driver, By.id("com.mobikwik_new:id/content_root"))) {
            Log.info("Handle", "Ratings PopUp");
            mbkCommonControlsPage.clickOnCross();
            mbkCommonControlsPage.clickOnSuccessPageCross();
        }
    }
}
