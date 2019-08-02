package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.OffersPage;
import PageObject.Recharge.GasPage;
import PageObject.Recharge.RechargePage;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class GasHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MbkReporter mbkReporter;
    GasPage gasPage;
    RechargePage rechargePage;


    public GasHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyGasBill(String op, String bpNo){
        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        gasPage = rechargePage.clickOnGas();

        gasPage.selectOperator(op);

        gasPage.enterBpNo(bpNo);

        gasPage.clickGo();

        mbkReporter.verifyTrue(gasPage.getOperator().contains(op), "Verify same operator", true);
        mbkReporter.verifyTrue(gasPage.getCNo().contains(bpNo), "Verify same cno", true);
        mbkReporter.verifyTrue(gasPage.ifTextPresent(), "Check if bill text present", true);

    }
}
