package Helpers.Recharge;

import Helpers.AddMoneyHelper;
import Helpers.MbkCommonControlsHelper;
import PageObject.HomePage;
import PageObject.Recharge.MobileRechargePage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileHelper {
    WebDriver driver;
    MobileRechargePage mobileRechargePage;
    MbkReporter mbkReporter;
    MbkCommonControlsHelper mbkCommonControlsHelper;
    HomePage homePage;

    public MobileHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
        mbkCommonControlsHelper= new MbkCommonControlsHelper(driver);
    }

    public void verifyPrepaid(String operator, String mobNo, String circle, String amount, boolean promoCodeStatus, String promoCode, String promoCodeText ,String cardNo, String month, String year, String cvv, String bankPassword) throws InterruptedException {

        mobileRechargePage = homePage.clickOnMobile();

        mobileRechargePage.enterMobileNumber(mobNo);

        mobileRechargePage.selectPrepaid();

        mobileRechargePage.enterOperator(operator);

        mobileRechargePage.enterCircle(circle);

        mobileRechargePage.enterAmount(amount);

        mobileRechargePage.clickGo();

        // Wait for the Pop up window to open
        mobileRechargePage.waitForPrePaidWindowToOpen();

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifConfirmRechargePresent(), "bill text present", false);
        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getPrepaidNo(), "compare number", false);


        if (promoCodeStatus) {
            mobileRechargePage.clickPromoCode();

            mobileRechargePage.enterPromoCode(promoCode);

            mobileRechargePage.applyPromoCode();

            String actualPromoCodeText = mobileRechargePage.getPromoCodeTextOnSuccessScreen();
            String expectedPromoCodeText = "You will get ₹ " + promoCodeText + " SuperCash";
            mbkReporter.verifyEqualsWithLogging(actualPromoCodeText, expectedPromoCodeText, "After TRX | Verify Promo Code Text", false);

        }
        mobileRechargePage.clickMakePayment();

        mbkCommonControlsHelper.handlePayments(cardNo,month,year,cvv,bankPassword);

        mbkReporter.verifyTrueWithLogging(mobileRechargePage.ifSuccessTextPresent(), "success text present", false);

        homePage.clickOnLogoMbk();

    }

//    public void verifyPostpaid(String operator, String mobNo, String circle, String amount) throws InterruptedException {
//
//        mobileRechargePage = homePage.clickOnMobile();
//
//        mobileRechargePage.enterMobileNumber(mobNo);
//
//        mobileRechargePage.selectPostpaid();
//
//        mobileRechargePage.enterOperator(operator);
//
//        mobileRechargePage.enterCircle(circle);
//
//        //mobileRechargePage.enterAmount(amount);
//
//        mobileRechargePage.clickGo();
//
//        // Wait for the Pop up window to open
//        mobileRechargePage.waitForWindowToOpen();
//        mbkReporter.verifyEqualsWithLogging(mobNo, mobileRechargePage.getNo(), "compare number", false);
//        mbkReporter.verifyTrueWithLogging(mobileRechargePage.isPostSuccess(), "compare success text", false);
//
//        // Click on the close Icon
//        Thread.sleep(3000);
//        mobileRechargePage.closeBill();
//
//        // return back to the Hom screen
//        homePage.clickOnLogoMbk();
//
//    }
}
