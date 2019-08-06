package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
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
    HomePage homePage;

    public DthHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyInvalidDthBill(String opt, String cNo, String amt) {

        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        dthPage = rechargePage.clickOnDth();

        dthPage.enterOperator(opt);

        dthPage.enterBpNo(cNo);

        dthPage.enterAmount(amt);

        dthPage.clickGo();

        mbkReporter.verifyEqualsWithLogging(cNo, dthPage.getCNo(), "compare cNo", false);
        mbkReporter.verifyEqualsWithLogging(amt, dthPage.getAmt(), "compare Amt", false);

        dthPage.clickMakePayment();

        mbkReporter.verifyTrueWithLogging(dthPage.ifTextPresent(), "Check if bill text present", false);

        homePage.clickOnLogoMbk();
    }
}
