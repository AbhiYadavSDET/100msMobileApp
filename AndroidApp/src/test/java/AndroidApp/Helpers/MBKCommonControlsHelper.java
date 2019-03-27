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
import java.util.LinkedHashMap;
import java.util.Map;

public class MBKCommonControlsHelper {

    AndroidDriver driver;
    MbkCommonControlsPage mbkCommonControlsPage;
    Element element;
    WalletBalancePage walletBalancePage;

    public MBKCommonControlsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        element = new Element(driver);

    }


    public void applyPromoCodeGold(String promoCode) {
        mbkCommonControlsPage.applyPromoCode(promoCode);
    }

    public void applyPromoCodeRecharge() {

    }

    public void applyPromoCodeAddMoney() {

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

    public void returnToHomePageFromSuccessScreen() {
        mbkCommonControlsPage.clickOnSuccessPageCross();
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

        // Swipe up
        Screen.swipeUp();
        Screen.swipeUp();


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
}
