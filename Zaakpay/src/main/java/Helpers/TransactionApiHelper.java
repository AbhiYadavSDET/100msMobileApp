package Helpers;


import PageObject.*;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TransactionApiHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    TransactionApiHomePage transactionApiHomePage;
    PaymentOptionsPage paymentOptionsPage;
    AmexPaymentPage amexPaymentPage;
    SuccessPage successPage;
    MbkReporter mbkReporter;
    CcAvenuePaymentPage ccAvenuePaymentPage;
    public static HashMap<String, String> transactionMap = new HashMap<>();


    public TransactionApiHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public enum flowType {
        AMEX,
        HDFC,
        CCAVENUE,
        CYBERSOURCE;
    }

    public void transactionViaCreditCard(flowType flowType, String email, String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String expectedDescription) throws InterruptedException {

        // Select the Flow Type
        transactionApiHomePage = dashboardPage.clickOnTransactApiLink();

        // Enter the Email
        transactionApiHomePage.enterEmail(email);

        // Enter the Amount
        transactionApiHomePage.enterAmount(amount);

        // Click on Submit button
        paymentOptionsPage = transactionApiHomePage.clickOnButtonPayViaZaakpay();

        // Set the needed values in Map
        transactionMap.put("email", email);
        transactionMap.put("amount", amount);
        String orderId = paymentOptionsPage.getOrderId();
        Log.info("Order Id : " + orderId);
        transactionMap.put("orderId", orderId);

        // Select the Credit card option
        paymentOptionsPage.clickOnCreditCard();

        switch (flowType) {
            case AMEX:
                // Amex payment
                paymentAmex(cardNo, expiryMonth, expiryYear, cvv, expectedDescription);
                break;

            case HDFC:
                // Amex payment
                paymentHdfc(cardNo, expiryMonth, expiryYear, cvv, expectedDescription);
                break;

            case CCAVENUE:
                // Amex payment
                paymentCcAvenue(cardNo, expiryMonth, expiryYear, cvv, expectedDescription);
                break;

            case CYBERSOURCE:
                // Amex payment
                paymentCyberSource(cardNo, expiryMonth, expiryYear, cvv, expectedDescription);
                break;

        }


    }

    public void transactionViaNetBanking(String email, String amount, String expectedDescription) throws InterruptedException {

        // Select the Flow Type
        transactionApiHomePage = dashboardPage.clickOnTransactApiLink();

        // Enter the Email
        transactionApiHomePage.enterEmail(email);

        // Enter the Amount
        transactionApiHomePage.enterAmount(amount);

        // Click on Submit button
        paymentOptionsPage = transactionApiHomePage.clickOnButtonPayViaZaakpay();

        // Set the needed values in Map
        transactionMap.put("email", email);
        transactionMap.put("amount", amount);
        String orderId = paymentOptionsPage.getOrderId();
        Log.info("Order Id : " + orderId);
        transactionMap.put("orderId", orderId);

        // Select the Credit card option
        paymentOptionsPage.clickOnNetBanking();
        Thread.sleep(3000);


        paymentNetbanking(expectedDescription);


    }


    public void paymentNetbanking(String expectedDescription) {
        // select the bank
        paymentOptionsPage.selectBank("CCTEST");

        // Click on the CTA
        ccAvenuePaymentPage = paymentOptionsPage.clickOnMakePaymentNetbanking();

        successPage = ccAvenuePaymentPage.clickOnReturnToMerchantSite();


        //Assertion on the success page
        String actualDescription = successPage.getDescription();
        mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);

    }

    public void paymentAmex(String cardNo, String expiryMonth, String expiryYear, String cvv, String expectedDescription) {
        // Enter the card details
        paymentOptionsPage.enterCardNo(cardNo);
        paymentOptionsPage.selectExpiryMonth(expiryMonth);
        paymentOptionsPage.selectExpiryYear(expiryYear);
        paymentOptionsPage.enterCvv(cvv);

        // Click on the CTA
        amexPaymentPage = (AmexPaymentPage) paymentOptionsPage.clickOnMakePayment(flowType.AMEX);

        // Click on submit button on bank page
        successPage = amexPaymentPage.clickOnSubmitButton();

        //Assertion on the success page
        String actualDescription = successPage.getDescription();

        mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);

    }

    public void paymentHdfc(String cardNo, String expiryMonth, String expiryYear, String cvv, String expectedDescription) {
        // Enter the card details
        paymentOptionsPage.enterCardNo(cardNo);
        paymentOptionsPage.selectExpiryMonth(expiryMonth);
        paymentOptionsPage.selectExpiryYear(expiryYear);
        paymentOptionsPage.enterCvv(cvv);

        // Click on the CTA
        successPage = (SuccessPage) paymentOptionsPage.clickOnMakePayment(flowType.HDFC);


        //Assertion on the success page
        String actualDescription = successPage.getDescription();

        mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);
    }

    public void paymentCcAvenue(String cardNo, String expiryMonth, String expiryYear, String cvv, String expectedDescription) {
        // Enter the card details
        paymentOptionsPage.enterCardNo(cardNo);
        paymentOptionsPage.selectExpiryMonth(expiryMonth);
        paymentOptionsPage.selectExpiryYear(expiryYear);
        paymentOptionsPage.enterCvv(cvv);

        // Click on the CTA
        ccAvenuePaymentPage = (CcAvenuePaymentPage) paymentOptionsPage.clickOnMakePayment(flowType.CCAVENUE);

        successPage = ccAvenuePaymentPage.clickOnReturnToMerchantSite();


        //Assertion on the success page
        String actualDescription = successPage.getDescription();
        mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);
    }

    public void paymentCyberSource(String cardNo, String expiryMonth, String expiryYear, String cvv, String expectedDescription) throws InterruptedException {
        // Enter the card details
        paymentOptionsPage.enterCardNo(cardNo);
        paymentOptionsPage.selectExpiryMonth(expiryMonth);
        paymentOptionsPage.selectExpiryYear(expiryYear);
        paymentOptionsPage.enterCvv(cvv);

        // Click on the CTA
        amexPaymentPage = (AmexPaymentPage) paymentOptionsPage.clickOnMakePayment(flowType.CYBERSOURCE);

        // Click on submit button on bank page
        successPage = amexPaymentPage.clickOnSubmitButton();


        //Assertion on the success page
        String actualDescription = successPage.getDescription();

        mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);
    }


}
