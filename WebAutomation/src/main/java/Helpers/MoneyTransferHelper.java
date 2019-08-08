package Helpers;


import PageObject.DashboardPage;
import PageObject.MbkCommonControlsPage;
import PageObject.MoneyTransferPage;
import Utils.MbkReporter;
import Utils.TestBase;
import org.openqa.selenium.WebDriver;

public class MoneyTransferHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    MoneyTransferPage moneyTransferPage;
    MbkReporter mbkReporter;


    public MoneyTransferHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();

        // Mandatory pages
        dashboardPage = new DashboardPage(driver);
    }


    public void p2p(String mobileNo, String expectedSuccessScreenStatus, String amount) throws InterruptedException {

        // Click on Wallet Transfer from dashboard
        moneyTransferPage = dashboardPage.clickOnWalletTransferSideDrawer();

        // Click on send to wallet
        moneyTransferPage.clickOnSendToWallet();

        // Enter the mobile number
        moneyTransferPage.enterMobileNo(mobileNo);

        // Enter the Amount
        moneyTransferPage.enterAmount(amount);

        // Click on Go Button
        moneyTransferPage.clickOnCtaGo();

        // Click on send money CTA
        moneyTransferPage.clickOnCtaSendMoney();

        // Wait for visibility of the tick icon
        moneyTransferPage.waitForTickIcon();

        // Assertion on the success screen
        String actualSuccessScreenStatus = moneyTransferPage.getTrxStatus();
        String actualSuccessScreenTotalAmount = moneyTransferPage.getTotalAmountPaid();

        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, expectedSuccessScreenStatus, "Success Screen | TRX Status", false);
        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenTotalAmount, amount, "Success Screen | Total Amount Paid", false);

        // Come back to the homepage
        MbkCommonControlsPage mbkCommonControlsPage = new MbkCommonControlsPage(TestBase.getWebDriver());
        mbkCommonControlsPage.clickOnLogoMbk();
    }


}
