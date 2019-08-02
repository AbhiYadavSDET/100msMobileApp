package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
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
    HomePage homePage;

    public LandlineHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyLandlineBill(String operator, String mobNo, String cNo){
        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        landlinePage = rechargePage.clickOnLandline();
        landlinePage.selectOperator(operator);

        landlinePage.enterTelNo(mobNo);

        landlinePage.enterCAN(cNo);

        landlinePage.clickGo();

        mbkReporter.verifyTrueWithLogging(landlinePage.ifBillExists(), "Check if bill opens", true);
        mbkReporter.verifyTrueWithLogging(landlinePage.getOperator().contains(operator), "Verify same operator", true);
        mbkReporter.verifyTrueWithLogging(landlinePage.getMNo().contains(mobNo), "Verify same mob no", true);
        mbkReporter.verifyTrueWithLogging(landlinePage.getCNo().contains(cNo), "Verify same cno", true);
        mbkReporter.verifyTrueWithLogging(landlinePage.ifTextPresent(), "Check if bill text present", true);

    }
}
