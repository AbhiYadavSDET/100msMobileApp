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

        Double balanceBefore =Double.parseDouble(homePage.getAvailableBalance());

        bankTransferPage= dashboardPage.clickOnBankTransferSideDrawer();

        bankTransferPage.enterAccountName(accountName);

        bankTransferPage.enterAccountNumber(accountNumber);

        bankTransferPage.enterIfsc(ifsc);

        bankTransferPage.enterAmount(amount);

        //For Processing Fee to Get Load
        Thread.sleep(2000);

        bankTransferPage.clickGo();

        Thread.sleep(2000);

        bankTransferPage.clickSendMoney();

        bankTransferPage.enterOtp();

        Thread.sleep(20000);

        bankTransferPage.clickSubmitOtp();

        Thread.sleep(2000);

        bankTransferPage.waitForTickIcon();

        String actualMessage= bankTransferPage.getTrxStatus();

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bank transfer success", false );

        String amountPaid= bankTransferPage.getAmountPaid();

        mbkReporter.verifyEqualsWithLogging(amountPaid, amount, "Validated amount transfer", false);


        Double balanceAfter= Double.parseDouble(homePage.getAvailableBalance());

        Double paidAmount= Double.parseDouble(amountPaid);

        Double expectedAmount= balanceBefore-paidAmount;

        mbkReporter.verifyEqualsWithLogging(expectedAmount, balanceAfter, "Amount Validated", false);


        homePage.clickOnLogoMbk();




    }

}
