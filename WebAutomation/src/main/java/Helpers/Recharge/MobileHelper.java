package Helpers.Recharge;

import PageObject.HomePage;
import PageObject.Recharge.MobileRechargePage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class MobileHelper {
    WebDriver driver;
    MobileRechargePage mobileRechargePage;
    MbkReporter mbkReporter;
    HomePage homePage;

    public MobileHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyPrepaid(String operator, String mobNo, String circle, String amount) {

        mobileRechargePage = homePage.clickOnMobile();

        mobileRechargePage.enterMobileNumber(mobNo);

        mobileRechargePage.selectPrepaid();

        mobileRechargePage.enterOperator(operator);

        mobileRechargePage.enterCircle(circle);

        mobileRechargePage.enterAmount(amount);

        mobileRechargePage.clickGo();

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifConfirmRechargePresent(), "bill text present", false);
        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getPrepaidNo(), "compare number", false);

        mobileRechargePage.clickMakePayment();

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifSuccessTextPresent(), "success text present", false);
        homePage.clickOnLogoMbk();

        homePage.clickOnLogoMbk();

    }

    public void verifyPostpaid(String operator, String mobNo, String circle, String amount) throws InterruptedException {

        mobileRechargePage = homePage.clickOnMobile();

        mobileRechargePage.enterMobileNumber(mobNo);

        mobileRechargePage.selectPostpaid();

        mobileRechargePage.enterOperator(operator);

        mobileRechargePage.enterCircle(circle);

        //mobileRechargePage.enterAmount(amount);

        mobileRechargePage.clickGo();

        // Wait for the Pop up window to open
        mobileRechargePage.waitForWindowToOpen();
        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getNo(), "compare number", false);
        mbkReporter.verifyTrueWithLogging(mobileRechargePage.isPostSuccess(), "compare success text", false);

        // Click on the close Icon
        Thread.sleep(3000);
        mobileRechargePage.closeBill();

        // return back to the Hom screen
        homePage.clickOnLogoMbk();

    }
}
