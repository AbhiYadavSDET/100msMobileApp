package Helpers;


import PageObject.DashboardPage;
import PageObject.PaymentOptionsPage;
import PageObject.TransactionApiHomePage;
import org.openqa.selenium.WebDriver;

public class TransactionApiHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    TransactionApiHomePage transactionApiHomePage;
    PaymentOptionsPage paymentOptionsPage;


    public TransactionApiHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);


    }

    public void transactionViaDebitCard(String email, String amount) {

        // Select the Flow Type
        transactionApiHomePage = dashboardPage.clickOnTransactApiLink();

        // Enter the Email
        transactionApiHomePage.enterEmail(email);

        // Enter the Amount
        transactionApiHomePage.enterAmount(amount);

        // Click on Submit button
        paymentOptionsPage = transactionApiHomePage.clickOnButtonPayViaZaakpay();

        // Select the Debit card option
        paymentOptionsPage.clickOnDebitCard();

    }


}
