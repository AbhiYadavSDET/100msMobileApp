package Helpers.Recharge;

import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.Recharge.LandlinePage;
import PageObject.Recharge.MobileRechargePage;
import PageObject.Recharge.RechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;
import sun.security.ssl.HandshakeMessage;

public class MobileHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    MobileRechargePage mobileRechargePage;
    MbkReporter mbkReporter;
    RechargePage rechargePage;
    HomePage homePage;

    public MobileHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
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

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifConfirmRechargePresent(), "bill text present", true);
        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getNo(), "compare number", true);

        mobileRechargePage.clickMakePayment();

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifSuccessTextPresent(), "bill text present", true);
        homePage.clickOnLogoMbk();


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

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifConfirmRechargePresent(), "bill text present", true);
        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getNo(), "compare number", true);

        mobileRechargePage.clickMakePayment();

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifSuccessTextPresent(), "bill text present", true);

        homePage.clickOnLogoMbk();
    }
}
