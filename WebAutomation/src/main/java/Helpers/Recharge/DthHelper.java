package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.Recharge.DthPage;
import PageObject.Recharge.GasPage;
import PageObject.Recharge.RechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class DthHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MbkReporter mbkReporter;
    DthPage dthPage;
    RechargePage rechargePage;

    public DthHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyInvalidDthBill(String cNo, String amt) {
        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        dthPage = rechargePage.clickOnDth();

        dthPage.enterBpNo(cNo);

        dthPage.enterAmount(amt);

        dthPage.clickGo();

        dthPage.clickMakePayment();

        /*mbkReporter.verifyTrue(gasPage.getOperator().contains(op), "Verify same operator", true);
        mbkReporter.verifyTrue(gasPage.getCNo().contains(bpNo), "Verify same cno", true);
        mbkReporter.verifyTrue(gasPage.ifTextPresent(), "Check if bill text present", true);*/
    }
}
