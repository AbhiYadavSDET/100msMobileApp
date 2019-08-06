package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.RechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class LandlineHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    LandlinePage landlinePage;
    MbkReporter mbkReporter;
    RechargePage rechargePage;
    HomePage homePage;

    public LandlineHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyLandlineBill(String operator, String mobNo, String cNo) throws InterruptedException {
        // Click on Landline
        landlinePage = homePage.clickOnLandline();

        // Select the Operator
        landlinePage.selectOperator(operator);

        // Enter the Mobile No.
        landlinePage.enterTelNo(mobNo);

        // Enter the CAN
        landlinePage.enterCAN(cNo);

        // Click on Go
        landlinePage.clickGo();

        // Wait for bill window
        landlinePage.waitForBillWindow();

        // fetch the values from the screen
        String actualCn = landlinePage.getCNo();
        String actualMNo = landlinePage.getMNo();
        String actualOperator = landlinePage.getOperator();
        String actualBillText = landlinePage.getBillText();

        mbkReporter.verifyEqualsWithLogging(actualOperator, operator, "Verify same operator", false);
        mbkReporter.verifyEqualsWithLogging(actualMNo, mobNo, "Verify same mob no", false);
        mbkReporter.verifyEqualsWithLogging(actualCn, cNo, "Verify same cno", false);
        mbkReporter.verifyTrueWithLogging(actualBillText.contains("Bills"), "Check if bills text present", false);

        // Click on the close Icon
        Thread.sleep(3000);
        landlinePage.closeBill();

        // return back to the Hom screen
        homePage.clickOnLogoMbk();
    }
}
