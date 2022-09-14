package Helpers;

import PageObject.AddMoneyPage;
import PageObject.HomePage;
import PageObject.TransactionHistoryPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Element;
import utils.MBReporter;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    TransactionHistoryPage transactionHistoryPage;
    PermissionHelper permissionHelper;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    private Object AndroidElement;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    /**
     * This method is to Test standalone add money Flow.
     * Flow Can Be "SavedCard" or "NewCard"
     */


    public void addMoneyViaCard(boolean savedCardFlow,String amount, String cardNo, String expiryMonthYear, String cvv, String successPageStatus, String successPageText) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("Saved Card Flow : " + savedCardFlow);
        Log.info("cardNo : " + cardNo);
        Log.info("expiryMonth : " + expiryMonthYear);
        Log.info("cvv : " + cvv);
        Log.info("successPageStatus : " + successPageStatus);
        Log.info("successPageText : " + successPageText);
        Log.info("-------------------------------------");

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        homePage.openBalanceDrawer();

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        // Click on the text box and Enter amount
        addMoneyPage.clickOnAmountTextBox();
        addMoneyPage.enterAmount(amount);

        Thread.sleep(1000);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Recommended Methods']"))) {
            addMoneyPage.chooseMoreOptions();
        }

        Element.waitForVisibility(driver, By.id("next_icon"));

        if(savedCardFlow){

            String cardNoLastFour="";
            int length=cardNo.length();
            for (int i=length-1;i>length-5; i--) {
                cardNoLastFour=cardNoLastFour+cardNo.charAt(i);
            }

            AndroidElement androidElement = element.findElement(driver, By.xpath("//*[contains(text(),'"+ cardNoLastFour +"')]"));
            Element.selectElement(driver, androidElement, "Select Saved Card");

            addMoneyPage.enterCvv(cvv);

        }else {

            if (Element.isElementPresent(driver, By.id("bank_name"))) {
                addMoneyPage.clickOnNewDebitCreditCard();
            } else {
                addMoneyPage.clickOnNoCardsDebitCreditCardFlow();
            }

            addMoneyPage.enterCardDetails(cardNo, expiryMonthYear, cvv);
        }
        addMoneyPage.clickOnPayNow();


        permissionHelper.permissionAllow();

        handleBankWebView();

        boolean condition = false;

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']"))) {
            condition = true;
            mbReporter.verifyTrueWithLogging(condition, "Add Money Failed due to Insufficient Balance in Bank Account", true, false);

        }
        //Assertions
        Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
        Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

        Log.info("END", "Add Money");

    }


    /**
     * This method is to handle add money within the flow.
     * It always enter in new card Journey.
     */

    public void handleAddMoney(String cardNo, String expiryMonthYear, String cvv) throws InterruptedException, IOException {

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Recommended Methods']"))) {
            addMoneyPage.chooseMoreOptions();
        }

        Element.waitForVisibility(driver, By.id("next_icon"));

            if (Element.isElementPresent(driver, By.id("bank_name"))) {
                addMoneyPage.clickOnNewDebitCreditCard();
            } else {
                addMoneyPage.clickOnNoCardsDebitCreditCardFlow();
            }

            addMoneyPage.enterCardDetails(cardNo, expiryMonthYear, cvv);

        addMoneyPage.clickOnPayNow();
        permissionHelper.permissionAllow();

        handleBankWebView();

        boolean condition = false;

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']"))) {
            condition = true;
            mbReporter.verifyTrueWithLogging(condition, "Add Money Failed due to Insufficient Balance in Bank Account", true, false);

        }
        //Assertions
        Boolean out= !(addMoneyPage.getSuccessPageStatus() ==null);
        mbReporter.verifyTrueWithLogging(out, "Success Screen | Verify Status", true, false);
        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        Log.info("END", "Add Money");

    }

    /**
     * This method is to handle add money within the flow till bank otp page.
     * It always enter in new card Journey.
     * Use this only if card is not working.
     */

    public void handleAddMoney(String cardNo, String expiryMonthYear, String cvv,Boolean validateTillOtpPage, String paymentFlow) throws InterruptedException, IOException {

        Log.info("Add Money Flow Start | To be Validated till otp page : "+validateTillOtpPage+" | Payment mode provided : "+paymentFlow );

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Recommended Methods']"))) {
            addMoneyPage.chooseMoreOptions();
        }

        Element.waitForVisibility(driver, By.id("next_icon"));

        if(paymentFlow.equalsIgnoreCase("card")) {

            if (Element.isElementPresent(driver, By.id("bank_name"))) {
                addMoneyPage.clickOnNewDebitCreditCard();
            } else {
                addMoneyPage.clickOnNoCardsDebitCreditCardFlow();
            }

            addMoneyPage.enterCardDetails(cardNo, expiryMonthYear, cvv);

            addMoneyPage.clickOnPayNow();

            permissionHelper.permissionAllow();

            Thread.sleep(2000);
            Element.waitForVisibility(driver, By.xpath("//*[@text ='Confirm & Pay']"));
            Boolean ispresent=Element.isElementPresent(driver, By.id("otpValue"));
            mbReporter.verifyTrueWithLogging(ispresent,"Is Bank Page Webview open", true,true);
            addMoneyPage.goBackFromWebview();


        }else if(paymentFlow.equalsIgnoreCase("netbanking")){

            addMoneyPage.clickOnNetbanking();
            //Select Bank
            Element.waitForVisibility(driver,By.xpath("//android.widget.TextView[@text = 'Select Your Bank']"));

            for (int i=0;i<6;i++) {

                if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'IndusInd Bank']"))) {
                    addMoneyPage.clickOnIndusIndBankInNetBanking();
                    break;

                }else {
                    Screen.swipeUpMore(driver);
                    i++;
                }
            }

            Element.waitForVisibility(driver,By.xpath("//*[@text = 'Indusind Bank']"));

            Boolean ispresent=Element.isElementPresent(driver, By.xpath("//*[@text= 'Welcome To The Online Payment Page Of IndusInd Bank']"));
            mbReporter.verifyTrueWithLogging(ispresent,"Is Indusind Webview open", false,true);
            addMoneyPage.goBackFromWebview();


        }else{

            Log.info("Error", "No such Option Available");

        }

        Log.info("END", "Add Money");

    }

    /**
     * This method is to handle add money with card : Currently using Debit Card
     */

    public void handleBankWebView() throws InterruptedException {
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(6000);
        String newOtp=getOtpDetails();
        Thread.sleep(2000);

        js.executeScript("document.getElementById(\"otpValue\").value=\""+newOtp+"\";");
        Thread.sleep(2000);

        js.executeScript("document.getElementById(\"submitBtn\").click();");
        Thread.sleep(16000);
    }



    /**
     * This method is gets the otp from the url provided. Apk to be installed in the phone in which otp is sent.
     */

    public String getOtpDetails() {
        /**
         * Specify the base URL to the Restful web service
         */
        RestAssured.baseURI = "https://firebasestorage.googleapis.com/";
        RestAssured.basePath="v0/b/testingsyncotpfirebase.appspot.com/o";

        /**
         * Get the RequestSpecification of the request to be sent to the server.
         */
        RequestSpecification httpRequest = RestAssured.given().log().all().urlEncodingEnabled(false);

        /**
         * Specify the method type (GET) and the parameters if any.
         * In this case the request does not take any parameters
         */

        Response response = httpRequest.request(Method.GET, "otpTesting%2Fotp.json?alt=media");

        /**
         * Print the status and message body of the response received from the server
         */

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        String output=response.prettyPrint().replace("{\"otp\":\"","").replace("\"}", "");
        System.out.println("Output Otp=>" + output);
        return output;
    }


}


