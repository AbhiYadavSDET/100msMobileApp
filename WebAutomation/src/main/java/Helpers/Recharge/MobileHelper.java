package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.MobileRechargePage;
import PageObject.Recharge.RechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class MobileHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MobileRechargePage mobileRechargePage;
    MbkReporter mbkReporter;
    RechargePage rechargePage;


    public MobileHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void verifyPrepaid(String operator, String mobNo, String circle, String amount){

        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        mobileRechargePage = rechargePage.clickOnMobile();

        mobileRechargePage.enterMobileNumber(mobNo);

        mobileRechargePage.selectPrepaid();

        mobileRechargePage.enterOperator(operator);

        mobileRechargePage.enterCircle(circle);

        mobileRechargePage.enterAmount(amount);

        mobileRechargePage.clickGo();

        mbkReporter.verifyTrue(mobileRechargePage.ifTextPresent(), "bill text present", true);

    }

    public void verifyPostpaid(String operator, String mobNo, String circle, String amount){

        rechargePage = dashboardPage.clickOnRechargeSideDrawer();

        mobileRechargePage = rechargePage.clickOnMobile();

        mobileRechargePage.enterMobileNumber(mobNo);

        mobileRechargePage.selectPostpaid();

        mobileRechargePage.enterOperator(operator);

        mobileRechargePage.enterCircle(circle);

        mobileRechargePage.enterAmount(amount);

        mobileRechargePage.clickGo();

        mbkReporter.verifyTrue(mobileRechargePage.ifTextPresent(), "bill text present", true);

    }
}
