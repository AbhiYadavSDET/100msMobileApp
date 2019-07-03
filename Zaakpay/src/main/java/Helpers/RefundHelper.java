package Helpers;


import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class RefundHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    TransactionApiHomePage transactionApiHomePage;
    PaymentOptionsPage paymentOptionsPage;
    AmexPaymentPage amexPaymentPage;
    SuccessPage successPage;
    MbkReporter mbkReporter;
    CcAvenuePaymentPage ccAvenuePaymentPage;
    RefundPage refundPage;
    RefundSuccessPage refundSuccessPage;


    public RefundHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();


    }


    public void refundTransaction(String orderId, String state, String expectedDescription) throws InterruptedException {

        // Select the Flow type
        refundPage = dashboardPage.clickOnUpdateTrxApiLink();

        // Enter the Order Id
        refundPage.enterOrderId(orderId);

        // Enter the state
        refundPage.enterState(state);

        // Click on Submit button
        refundPage.clickOnPayNow();

        Thread.sleep(10000);

        String pageSource = driver.getPageSource();

        // Assertions
        mbkReporter.verifyTrueWithLogging(pageSource.contains("Transaction Refund Initiated"), "Refund Success page Message", false);

    }


}
