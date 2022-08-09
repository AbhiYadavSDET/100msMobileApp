package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.Recharge.ElectricityPage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.RechargePage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectricityHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    ElectricityPage electricityPage;
    MbkReporter mbkReporter;
    RechargePage rechargePage;
    HomePage homePage;

    public ElectricityHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyElectricityBill(String operator, String cNo) throws InterruptedException {
        // Click on Landline
        electricityPage = homePage.clickOnElectricity();

        // Select the Operator
        electricityPage.selectOperator(operator);


        // Enter the CAN
        electricityPage.enterCAN(cNo);

        // Click on Go
        electricityPage.clickGo();

        // Wait for bill window
        electricityPage.waitForBillWindow();

        // fetch the values from the screen
        String actualCn = electricityPage.getCNo();
        String actualOperator = electricityPage.getOperator();
        String actualBillText = electricityPage.getBillText();

        mbkReporter.verifyEqualsWithLogging(actualOperator, operator, "Verify same operator", false);
        mbkReporter.verifyEqualsWithLogging(actualCn, cNo, "Verify same cno", false);
        mbkReporter.verifyTrueWithLogging(actualBillText.contains("Bill"), "Check if bills text present", false);

        mbkReporter.verifyTrueWithLogging(electricityPage.billStatus(), "Validate Bill state", false);

        // Click on the close Icon
        Thread.sleep(3000);
        electricityPage.closeBill();

        // return back to the Hom screen
        homePage.clickOnLogoMbk();
    }
}
