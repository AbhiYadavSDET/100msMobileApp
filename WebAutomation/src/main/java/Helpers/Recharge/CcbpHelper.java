package Helpers.Recharge;

import Helpers.AddMoneyHelper;
import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.Recharge.CcbpPage;
import PageObject.Recharge.RechargePage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CcbpHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    CcbpPage ccbpPage;
    MbkReporter mbkReporter;
    HomePage homePage;

    public CcbpHelper(WebDriver driver) {
        this.driver = driver;
        dashboardPage = new DashboardPage(driver);
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void payCreditCardBill(String cardNo, String amount, String month, String year, String cvv, String bankPassword) throws InterruptedException {
        // Click on Credit Card
        //4386280038636225

        ccbpPage = homePage.clickOnCcbp();

        ccbpPage.enterCreditCard(cardNo);

        ccbpPage.enterAmount(amount);

        ccbpPage.clickGo();

        // Wait for the Pop up window to open
        ccbpPage.waitForConfirmWindowToOpen();

        ccbpPage.clickMakePayment();

        if(Element.isElementPresent(driver, By.xpath("//h3[text()= ' Select a Payment Mode ']"))){

            AddMoneyHelper addMoneyHelper= new AddMoneyHelper(driver);
            addMoneyHelper.handleAddMoney(cardNo, month, year, cvv, bankPassword);

        }

        mbkReporter.verifyTrueWithLogging(ccbpPage.ifSuccessTextPresent(), "success text present", false);

        mbkReporter.verifyEqualsWithLogging(ccbpPage.getAmount(), amount, "Validate Amount", false);

        homePage.clickOnLogoMbk();





    }
}
