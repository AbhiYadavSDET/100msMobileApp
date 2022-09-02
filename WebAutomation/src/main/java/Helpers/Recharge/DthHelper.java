package Helpers.Recharge;

import PageObject.HomePage;
import PageObject.Recharge.DthPage;
import PageObject.Recharge.RechargePage;
import Utils.Config;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class DthHelper {
    WebDriver driver;
    MbkReporter mbkReporter;
    DthPage dthPage;
    RechargePage rechargePage;
    HomePage homePage;

    public DthHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyInvalidDthBill(String opt, String cNo, String amt) throws InterruptedException {
        // Click on DTH
        dthPage = homePage.clickOnDth();

        // Enter the Operator
        dthPage.enterOperator(opt);
        Thread.sleep(1000);
        // Enter the C No.
        Config.logComment("Before entering number");
        dthPage.enterBpNo(cNo);
        Config.logComment("After entering number");
        Thread.sleep(1000);

        // Enter the Amount
        Config.logComment("Before entering amount");
        dthPage.enterAmount(amt);
        Config.logComment("After entering amount");
        Thread.sleep(1000);

        // Click on Go
        dthPage.clickGo();

        // Wait for make Payment screen and assert
        dthPage.waitForMakePaymentScreen();
        mbkReporter.verifyEqualsWithLogging(cNo, dthPage.getCNo(), "compare cNo", false);
        mbkReporter.verifyEqualsWithLogging(amt, dthPage.getAmt(), "compare Amt", false);

        // click on Make Payment
        dthPage.clickMakePayment();

        // Assertions
        Thread.sleep(5000);
        mbkReporter.verifyTrueWithLogging(dthPage.ifTextPresent(), "Check if bill text present", false);

        // Return back to the home-screen
        homePage.clickOnLogoMbk();
    }
}
