package Helpers;

import PageObject.BankTransferPage;
import PageObject.DashboardPage;
import PageObject.HomePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BankTransferHelper {


    WebDriver driver;
    HomePage homePage;
    DashboardPage dashboardPage;
    BankTransferPage bankTransferPage;


    public BankTransferHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
    }


    public void bankTransfer(String accountName, String accountNumber, String ifsc, String amount, String expectedMessage) throws InterruptedException, IOException {

        Double balanceBefore = Double.parseDouble(homePage.getAvailableBalance()) * 100;

        bankTransferPage = dashboardPage.clickOnBankTransferSideDrawer();

        bankTransferPage.enterAccountName(accountName);

        bankTransferPage.enterAccountNumber(accountNumber);

        bankTransferPage.enterIfsc(ifsc);

        bankTransferPage.enterAmount(amount);

        //For Processing Fee to Get Load
        Thread.sleep(2000);

        Double processingFee = Double.parseDouble(bankTransferPage.getProcessingFee());

        bankTransferPage.clickGo();

        Thread.sleep(2000);

        bankTransferPage.clickSendMoney();

        bankTransferPage.enterOtp();

//        Thread.sleep(20000);
//
//        bankTransferPage.clickSubmitOtp();
//
//        Thread.sleep(2000);

        bankTransferPage.waitForTickIcon();

        String actualMessage = bankTransferPage.getTrxStatus();

        MbkReporter.verifyEqualsWithLoggingExtentReport(actualMessage, expectedMessage, "Bank transfer success", false);

        String amountPaid = bankTransferPage.getAmountPaid();

        MbkReporter.verifyEqualsWithLoggingExtentReport(amountPaid, amount, "Validated amount transfer", false);


        Double balanceAfter = Double.parseDouble(homePage.getAvailableBalance()) * 100;

        Double paidAmount = Double.parseDouble(amountPaid) * 100;

        Double expectedAmount = (balanceBefore - (paidAmount + (processingFee * 100)));

        MbkReporter.verifyEqualsWithLoggingExtentReport(expectedAmount, balanceAfter, "Amount Validated", false);


        homePage.clickOnLogoMbk();


    }

}
