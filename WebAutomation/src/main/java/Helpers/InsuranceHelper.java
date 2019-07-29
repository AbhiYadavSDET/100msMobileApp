package Helpers;


import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.InsurancePage;
import PageObject.MoneyTransferPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class InsuranceHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
    MoneyTransferPage moneyTransferPage;
    MbkReporter mbkReporter;
    InsurancePage insurancePage;


    public InsuranceHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();

        // Mandatory pages
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
    }


    public void buyGasInsurance(String expectedSuccessScreenStatus) throws InterruptedException {

        // Click on Insurance from dashboard
        insurancePage = dashboardPage.clickOnInsuranceSideDrawer();

        // Select the insurance category
        insurancePage.clickOnInsuranceGas();

        // Select the ticket value
        insurancePage.clickOnPrice();

        // Click on Make payment
        insurancePage.clickOnMakePayment();

        // Wait for the success screen
        insurancePage.waitForTickIcon();

        // Add the assertions
        String actualTrxStatus = insurancePage.getTrxStatus();

        mbkReporter.verifyEqualsWithLogging(actualTrxStatus, expectedSuccessScreenStatus, "Success Screen | TRX Status", false);

        // reach back thr home screen
        homePage.clickOnLogoMbk();

    }


}
