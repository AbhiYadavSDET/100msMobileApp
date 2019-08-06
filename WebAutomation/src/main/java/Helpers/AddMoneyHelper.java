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

    public void addMoneyViaNewcard(String amount, String cardNo, String cvv, String bankPassword, String expectedSuccessScreenStatus) throws InterruptedException {

        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();

        // Click on the New Debit/Credit card
        addMoneyPage.clickOnDebitCards();

        // Click in new Card
        addMoneyPage.clickOnNewCard();

        // Enter the card
        addMoneyPage.enterCardNo(cardNo);
        addMoneyPage.enterExpiryMonth();
        addMoneyPage.enterExpiryYear();

        Thread.sleep(2000);
        addMoneyPage.enterCvv(cvv);

        // Click on the Proceed button
        addMoneyPage.clickOnProceedToPay2();

        // Handle the Indusind page
        handleIndusindWebView(bankPassword);

        //Assertions
        // Wait for visibility of the tick icon
        addMoneyPage.waitForTickIcon();

        // Assertion on the success screen
        String actualSuccessScreenStatus = addMoneyPage.getTrxStatus();
        String actualSuccessScreenTotalAmount = addMoneyPage.getTotalAmountPaid();

        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, expectedSuccessScreenStatus, "Success Screen | TRX Status", false);
        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenTotalAmount, amount, "Success Screen | Total Amount Paid", false);

        // Come back to the homepage
        homePage.clickOnLogoMbk();

    }

    public void addMoneyViaSavedcard(String amount, String cvv, String bankPassword, String expectedSuccessScreenStatus, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException {

        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();

        // Click on the New Debit/Credit card
        addMoneyPage.clickOnDebitCards();


        // Select the Saved card
        addMoneyPage.clickOnSavedCard();

        // Enter the CVV
        addMoneyPage.enterSavedCardCvv(cvv);

        if (promoCodeStatus) {
            applyPromoCodeAddMoney(promoCode, promoCodeText);
        }

        // Click on the Proceed button
        addMoneyPage.clickOnPayNow();

        // Handle the Indusind page
        handleIndusindWebView(bankPassword);

        //Assertions
        // Wait for visibility of the tick icon
        addMoneyPage.waitForTickIcon();

        // Assertion on the success screen
        String actualSuccessScreenStatus = addMoneyPage.getTrxStatus();
        String actualSuccessScreenTotalAmount = addMoneyPage.getTotalAmountPaid();

        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, expectedSuccessScreenStatus, "Success Screen | TRX Status", false);
        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenTotalAmount, amount, "Success Screen | Total Amount Paid", false);

        // Come back to the homepage
        homePage.clickOnLogoMbk();

    }

    public void handleIndusindWebView(String password) throws InterruptedException {
        Element.waitForVisibility(driver, addMoneyPage.indusInd_logo, "IndusInd Logo");

        addMoneyPage.clickOnBankPageSecurePassword();
        addMoneyPage.clickOnBankPageContinueButton();
        addMoneyPage.enterBankPagePassword(password);
        addMoneyPage.clickOnBankPageSubmitButton();

        Thread.sleep(10000);


    }

    public void applyPromoCodeAddMoney(String promoCode, String expectedText) throws InterruptedException {
        // Click on Apply a coupon code
        addMoneyPage.clickOnApplyACouponCode();

        // Enter the code
        addMoneyPage.enterCoupon(promoCode);

        // Click on Apply
        addMoneyPage.clickOnApply();

        Thread.sleep(3000);

        // Assert the promocode text
        String actualCouponCodeText = addMoneyPage.getCouponCodeText();

        mbkReporter.verifyEqualsWithLogging(actualCouponCodeText, expectedText, "Coupon Code Text", false);
    }

}
