package Helpers;

import PageObject.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

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
    TransactionHistoryPage transactionHistoryPage;
    SideDrawerPage sideDrawerPage;
    HomePage homePage;
    AddMoneyPage addMoneyPage;

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
        walletBalancePage = new WalletBalancePage(driver);
        transactionHistoryPage = new TransactionHistoryPage(driver);
        sideDrawerPage = new SideDrawerPage(driver);
        homePage = new HomePage(driver);

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

    //Use to handle Add money anywhere.
    public void handleAddMoney(String requiredAmount, String activity, String cardNo, String expiryMonthYear, String cvv, String bankPin) throws InterruptedException, IOException {

        //activity values "withinTestCase"=for in sufficient Flows
        //activity values "BeforeTestCase"=for sufficient Flows

        if (activity.equalsIgnoreCase("BeforeTestCase")) {

            HashMap<String, String> currentBalance = getBalance();
            String balance = currentBalance.get(BalanceType.MONEYADDED);

            if (Double.parseDouble(requiredAmount) > Double.parseDouble(balance)) {

                int amountToAdd = Integer.parseInt(requiredAmount) - Integer.parseInt(balance);

                String amount = String.valueOf(amountToAdd);

                homePage.openBalanceDrawer();

                addMoneyPage = homePage.clickOnAddMoneyButton();

                // Click on the text box and Enter amount
                addMoneyPage.clickOnAmountTextBox();
                addMoneyPage.enterAmount(amount);

                Thread.sleep(1000);

                addMoneyPage.clickOnContinueButton();

            AddMoneyHelper addmoneyHelper = new AddMoneyHelper(driver);
            addmoneyHelper.handleAddMoney(amount, cardNo, expiryMonthYear,cvv,bankPin);

            }

        }else{

            AddMoneyHelper addmoneyHelper = new AddMoneyHelper(driver);
            addmoneyHelper.handleAddMoney(requiredAmount, cardNo, expiryMonthYear,cvv,bankPin);

        }

    }

        public void handleSecurityPin (String pin) throws InterruptedException {
            String[] pinArr = pin.split("|");

            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {

                for (String e : pinArr) {
                    //Log.info("PRESS", e);
                    AndroidElement androidElement = element.findElement(driver, By.id("btn_pin_" + e));
                    Element.selectElement(driver, androidElement, e);
                }

            }
        }

        public void handleRechargeAmountKeyboard (String amt) throws InterruptedException {
            String[] amtArr = amt.split("|");

            if (Element.isElementPresent(driver, By.id("layout_keyboard_btns"))) {

                for (String e : amtArr) {
                    //Log.info("PRESS", e);
                    AndroidElement androidElement = element.findElement(driver, By.id("btn_pin_" + e));
                    Element.selectElement(driver, androidElement, e);
                }

            }
        }

        public void handleUpiPin (String pin) throws InterruptedException {

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

        public void clickUpButton () throws InterruptedException {
            Thread.sleep(1000);
            mbkCommonControlsPage.clickOnUpButton();
        }


        public void clickUpButton2 () throws InterruptedException {
            Thread.sleep(1000);
            mbkCommonControlsPage.clickOnUpButton2();
        }

        public void returnToHomePageFromSuccessScreen () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageCross();
        }

        public void returnToHomePageFromRechargeSuccessScreen () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageCross();
            handleRatingsPopUp();
            handleNPS();
        }
//    public void returnToHomePageFromCCBPSuccessScreen() throws InterruptedException {
//        mbkCommonControlsPage.clickOnSuccessPageBack();
//        handleRatingsPopUp();
//        handleNPS();
//    }


        public void returnToHomePageFromRechargeSuccessScreenBackButton () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageBackbutton();
            handleRatingsPopUp();
            handleNPS();
        }

        public void returnToHomePageFromP2MSuccessScreen () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageCross();
            handleRatingsPopUp();
            handleNPS();
        }

        public void returnToHomePageFromAddMoneySuccessScreen () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageCross();
            handleRatingsPopUp();
            handleNPS();

            if (Element.isElementPresent(driver, By.id("close_button"))) {
                mbkCommonControlsPage.closeAddmoneyBottomSheet();
            }
        }

        public void returnToHomePage () throws InterruptedException {
            mbkCommonControlsPage.clickOnNavigateHome();
        }

        public void returnToHomePageByBackArrow () throws InterruptedException {
            mbkCommonControlsPage.clickOnSuccessPageBackbutton();
        }


        public LinkedHashMap<String, String> getBalance () throws InterruptedException, IOException {

            LinkedHashMap<String, String> walletBalance = new LinkedHashMap<>();

            Log.info("START", "Fetch Wallet balance");

            // Goto balance details screen
            HomePage homePage = new HomePage(driver);

            homePage.openBalanceDrawer();

            mbkCommonControlsPage.clickOnSeeAll();

            Thread.sleep(2000);

            // fetch the balance and add to Map
            Element.waitForVisibility(driver, walletBalancePage.label_available_balance);
            int noOfBalance = Element.findElements(driver, By.id("bt_type")).size();
            Log.info("noOfBalance - " + noOfBalance);

            // Fetch the total balance
            String totalBalanceText = walletBalancePage.getTotalBalanceName();
            String totalBalanceValue = walletBalancePage.getTotalBalanceValue();

            walletBalance.put(totalBalanceText, totalBalanceValue);


            // Fetch the rest of the balances
            for (int i = 1; i <= noOfBalance; i++) {

                String balanceText = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1]")).getText().replace(" “", "").trim();
                String balanceValue = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[\" + i + \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[2]")).getText().replace("X", "").replace(",", "");
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

            for (int i = 0; i < 2; i++) {
                clickUpButton();
            }
            Log.info("END : Fetch Wallet balance");
            return walletBalance;
        }

        public void handleCTOverlay () throws InterruptedException {
            Thread.sleep(4000);

            if (Element.isElementPresent(driver, By.xpath("//android.widget.RelativeLayout[@index = '0']/android.widget" +
                    ".ImageView[@index = '1']"))) {

                Log.info("Handle", "CT Overlay");
                mbkCommonControlsPage.clickOnCtOverLayCross();
            }
        }

        // Added by MS@10 Oct, 2018 to handle the NPS Pop-on pressing back from the success screens
        public void handleNPS () throws InterruptedException {
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
        public void handleRatingsPopUp () throws InterruptedException {
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

        public void handleReferAndEarnBottomSheet () throws InterruptedException {
            Thread.sleep(2000);
            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Refer Now']"))) {
                Log.info("Handle", "Refer & Earn Bottom sheet");
                mbkCommonControlsPage.clickOnReferAndEarnBottonSheetCross();
            }
        }

        public void handleUpiBottomSheet (AndroidDriver driver) throws InterruptedException {
            Thread.sleep(2000);
            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Link Your Bank Account']"))) {
                Log.info("Handle", "Upi Bottom sheet");
                driver.navigate().back();
            }
        }

        public void handleGetInstantLoanBottomSheet () throws InterruptedException {
            Thread.sleep(2000);
            if (Element.isElementPresent(driver, By.id("cross_button"))) {
                Log.info("Handle", "Get Instant Loan Bottom sheet");
                mbkCommonControlsPage.clickOnGetInstantLoanBottonSheetCross();
            } else if (Element.isElementPresent(driver, By.id("ic_close"))) {
                Log.info("Handle", "Get Instant ZIP Dialogue");
                mbkCommonControlsPage.clickOnLoanDialogueCross();

            }
        }

        public void handleFloatingWidget () throws InterruptedException {
            Thread.sleep(2000);
            if (Element.isElementPresent(driver, By.id("home_floating_widget"))) {
                Log.info("Handle", "Home Floating Widget");
                mbkCommonControlsPage.closeFloatingWidget();
            }
        }

        public void handleClevertapPromotion (AndroidDriver driver) throws InterruptedException {
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

        public void handleSetupSecurityBottomSheet () throws InterruptedException {
            Thread.sleep(2000);
            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Enable secure login']"))) {
                Log.info("Handle", "Setup Security Bottom Sheet");
                mbkCommonControlsPage.closeSecurityBottomSheet();
            }
        }


        public void dismissAllOnHomePage (AndroidDriver driver) throws InterruptedException {
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


        /*---------------------Home Page Pop Up Handlers---------------------------*/


//        public void handleLogin (String number, String otp) throws InterruptedException, IOException {
//            Thread.sleep(1000);
//            if (Element.isElementPresent(driver, By.id("tnc_layout"))) {
//                Log.info("Handle", "Login User in the Flow");
//
////            LoginHelper loginHelper=new LoginHelper(driver);
////            loginHelper.quickLoginViaNumberWithinFlow(number,otp);
//            }
//        }

        public void uncheckInsuranceCta () throws InterruptedException {
            mbkCommonControlsPage.uncheckInsuranceCheckBox();
        }


    }






