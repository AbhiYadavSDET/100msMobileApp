package Helpers;


import PageObject.AddMoneyPage;
import PageObject.DashboardPage;
import PageObject.HomePage;
import Utils.Browser;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class AddMoneyHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
    MbkReporter mbkReporter;
    AddMoneyPage addMoneyPage;


    public enum BankName {
        ICICI,
        HDFC,
        AXIS,
        CITI,
        PNB
    }

    public AddMoneyHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();

        // Mandatory pages
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
    }


    public void addMoneyViaNetBanking(String amount, BankName bank, String expectedUrl) throws InterruptedException {

        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();

        // Select netbanking option
        addMoneyPage.clickOnNetbanking();

        // Select Bank radio button
        switch (bank) {
            case PNB:
                Element.selectElement(driver, addMoneyPage.label_PNB_bank, "PNB");
                break;
            case AXIS:
                Element.selectElement(driver, addMoneyPage.label_AXIS_bank, "Axis");
                break;
            case CITI:
                Element.selectElement(driver, addMoneyPage.label_CITI_bank, "Citi");
                break;
            case HDFC:
                Element.selectElement(driver, addMoneyPage.label_HDFC_bank, "HDFC");
                break;
            case ICICI:
                Element.selectElement(driver, addMoneyPage.label_ICICI_bank, "ICICI");
                break;

        }

        addMoneyPage.clickOnProceedToPay();

        // Assertion on bank page
        Thread.sleep(7000);
        mbkReporter.verifyEqualsWithLogging(driver.getCurrentUrl(), expectedUrl, "Bank Page | Url", false);

        // reach back thr home screen
        Browser.goBack(driver);
        Thread.sleep(3000);
        Browser.goBack(driver);

    }

    public void addMoneyViaNewcard(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText){

        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();

        // Click on the New Debit/Credit card




    }


}
