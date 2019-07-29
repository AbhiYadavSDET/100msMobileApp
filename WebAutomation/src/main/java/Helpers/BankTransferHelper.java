package Helpers;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.DashboardPage;
import PageObject.BankTransferPage;
import PageObject.SideDrawerPage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class BankTransferHelper {


    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    DashboardPage dashboardPage;
    BankTransferPage bankTransferPage;


    public BankTransferHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        dashboardPage= new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }



    public void bankTransfer(String accountName, String accountNumber, String ifsc, String amount, String expectedMessage) throws InterruptedException {

        int balanceBefore =Integer.parseInt(homePage.getAvailableBalance());

        bankTransferPage= dashboardPage.clickOnBankTransferSideDrawer();

        bankTransferPage.enterAccountName(accountName);

        bankTransferPage.enterAccountNumber(accountNumber);

        bankTransferPage.enterIfsc(ifsc);

        bankTransferPage.enterAmount(amount);

        bankTransferPage.clickGo();

        Thread.sleep(2000);

        bankTransferPage.clickSendMoney();

        bankTransferPage.enterOtp();

        Thread.sleep(20000);

        bankTransferPage.clickSubmitOtp();

        Thread.sleep(2000);

        bankTransferPage.waitForTickIcon();

        String actualMessage= bankTransferPage.getTrxStatus();

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bank transfer success", true );

        String amountPaid= bankTransferPage.getAmountPaid();

        mbkReporter.verifyEqualsWithLogging(amountPaid, amount, "Validated amount transfer", true);


        int balanceAfter= Integer.parseInt(homePage.getAvailableBalance());

        int paidAmount= Integer.parseInt(amountPaid);

        int expectedAmount= balanceBefore-paidAmount;

        mbkReporter.verifyEqualsWithLogging(expectedAmount, balanceAfter, "Amount Validated", true);


        
        homePage.clickOnLogoMbk();




    }

}
