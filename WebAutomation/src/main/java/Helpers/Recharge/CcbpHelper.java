package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.Recharge.CcbpPage;
import PageObject.Recharge.RechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class CcbpHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    CcbpPage ccbpPage;
    MbkReporter mbkReporter;
    HomePage homePage;

    public CcbpHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

//    public void payCreditCardBill(String cardNo, String amount) throws InterruptedException {
//        // Click on Landline
//        ccbpPage = homePage.clickOnCcbp();
//
//        // Select the Operator
//        ccbpPage.selectOperator(operator);
//
//        // Enter the Mobile No.
//        ccbpPage.enterTelNo(mobNo);
//
//        // Enter the CAN
//        ccbpPage.enterCAN(cNo);
//
//        // Click on Go
//        ccbpPage.clickGo();
//
//        // Wait for bill window
//        ccbpPage.waitForBillWindow();
//
//        // fetch the values from the screen
//        String actualCn = ccbpPage.getCNo();
//        String actualMNo = ccbpPage.getMNo();
//        String actualOperator = ccbpPage.getOperator();
//        String actualBillText = ccbpPage.getBillText();
//
//        mbkReporter.verifyEqualsWithLogging(actualOperator, operator, "Verify same operator", false);
//        mbkReporter.verifyEqualsWithLogging(actualMNo, mobNo, "Verify same mob no", false);
//        mbkReporter.verifyEqualsWithLogging(actualCn, cNo, "Verify same cno", false);
//        mbkReporter.verifyTrueWithLogging(actualBillText.contains("Bills"), "Check if bills text present", false);
//
//        // Click on the close Icon
//        Thread.sleep(3000);
//        ccbpPage.closeBill();
//
//        // return back to the Hom screen
//        homePage.clickOnLogoMbk();
//    }
}
