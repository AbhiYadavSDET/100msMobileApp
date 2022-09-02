package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class TransactionHistoryHelper {

        WebDriver driver;
        HomePage homePage;
        MbkReporter mbkReporter;
        TransactionHistory transactionHistory;

    public TransactionHistoryHelper(WebDriver driver) {
            this.driver = driver;
            mbkReporter = new MbkReporter();
            homePage = new HomePage(driver);
            transactionHistory = new TransactionHistory(driver);
        }
        public void transactionHistoryHelper(){
            transactionHistory.clickOnHistory();
            int noOfInvoiceButtons = transactionHistory.getInvoiceButtons();
            mbkReporter.verifyTrueWithLogging(noOfInvoiceButtons>0,"No of Invoice Buttons",false);
            homePage.clickOnLogoMbk();
        }
}
