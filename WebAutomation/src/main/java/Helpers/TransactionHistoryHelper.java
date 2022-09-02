package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class TransactionHistoryHelper {

        WebDriver driver;
        DashboardPage dashboardPage;
        HomePage homePage;
        MbkReporter mbkReporter;
        AddMoneyPage addMoneyPage;
        TransactionHistory transactionHistory;

    public TransactionHistoryHelper(WebDriver driver) {
            this.driver = driver;
            mbkReporter = new MbkReporter();
            // Mandatory pages
//        driver.navigate().to("https://www.mobikwik.com");
            homePage = new HomePage(driver);
//        dashboardPage = new DashboardPage(driver);
            transactionHistory = new TransactionHistory(driver);
        }
        public void transactionHistoryHelper(){
            transactionHistory.clickOnHistory();
            int noOfInvoiceButtons = transactionHistory.getInvoiceButtons();
            mbkReporter.verifyTrueWithLogging(noOfInvoiceButtons>0,"No of Invoice Buttons",false);
        }
}
