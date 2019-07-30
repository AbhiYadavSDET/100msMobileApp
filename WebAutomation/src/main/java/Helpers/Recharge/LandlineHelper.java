package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.RechargePage;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class LandlineHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    LandlinePage landlinePage;
    MbkReporter mbkReporter;
    RechargePage rechargePage;


    public LandlineHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyLandlineBill(String operator, String mobNo, String cNo){
        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        landlinePage = rechargePage.clickOnLandline();

        landlinePage.selectOperator(operator);

        landlinePage.enterTelNo(mobNo);

        landlinePage.enterCAN(cNo);

        landlinePage.clickGo();
        System.out.print("Rashi" + landlinePage.getOperator());

        mbkReporter.verifyTrue(landlinePage.ifBillExists(), "Check if bill opens", true);
        mbkReporter.verifyTrue(landlinePage.getOperator().contains(operator), "Verify same operator", true);
        mbkReporter.verifyTrue(landlinePage.getMNo().contains(mobNo), "Verify same mob no", true);
        mbkReporter.verifyTrue(landlinePage.getCNo().contains(cNo), "Verify same cno", true);
        mbkReporter.verifyTrue(landlinePage.ifTextPresent(), "Check if bill text present", true);


    }
}
