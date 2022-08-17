package Helpers;


import PageObject.AddMoneyPage;
import PageObject.DashboardPage;
import PageObject.HomePage;
import Utils.Browser;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        addMoneyPage = new AddMoneyPage(driver);
    }



    public void addMoneyViaNewcard(String amount, String cardNo, String month, String year, String cvv, String bankPassword, String expectedSuccessScreenStatus) throws InterruptedException {

        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();
        Thread.sleep(2000);

        // Click on the New Debit/Credit card

        if(!Element.isElementPresent(driver, By.xpath("//*[text()='Enter Credit / Debit Card Number']"))) {
            addMoneyPage.clickOnDebitOrCreditCards("debit");
            // Click in new Card
            addMoneyPage.clickOnNewCard();
        }

        // Enter the card
        addMoneyPage.enterCardNo(cardNo);
        addMoneyPage.enterExpiryMonth();
//        WebElement expiryMonth= driver.findElement(By.id("a950aeb29f63-"+(month-1)));
        WebElement expiryMonth= driver.findElement(By.xpath("//span[text()='"+month+"']"));

        Element.selectElement(driver,expiryMonth,"Select Expiry Month");

        addMoneyPage.enterExpiryYear();
        WebElement expiryYear= driver.findElement(By.xpath("//span[text()='"+year+"']"));
        Element.selectElement(driver,expiryYear,"Enter Expiry Year");

        Thread.sleep(2000);
        addMoneyPage.enterCvv(cvv);

        // Click on the Proceed button
        addMoneyPage.clickOnProceedToPay2();

        // Handle the Bank page
        handlePayZappWebView(bankPassword);

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

//    public void addMoneyViaSavedcard(String amount, String cvv, String bankPassword, String expectedSuccessScreenStatus, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException {
//
//        // Click on Add Money button
//        addMoneyPage = homePage.clickOnAddMoney();
//
//        // Enter the amount
//        addMoneyPage.enterAmount(amount);
//
//        // Click on continue button
//        addMoneyPage.clickOnCtaContinue();
//
//        // Click on the New Debit/Credit card
//        addMoneyPage.clickOnDebitCards();
//
//
//        // Select the Saved card
//        addMoneyPage.clickOnSavedCard();
//
//        // Enter the CVV
//        addMoneyPage.enterSavedCardCvv(cvv);
//
//        if (promoCodeStatus) {
//            applyPromoCodeAddMoney(promoCode, promoCodeText);
//        }
//
//        // Click on the Proceed button
//        addMoneyPage.clickOnPayNow();
//
//        // Handle the Indusind page
//        handlePayZappWebView(bankPassword);
//
//        //Assertions
//        // Wait for visibility of the tick icon
//        addMoneyPage.waitForTickIcon();
//
//        // Assertion on the success screen
//        String actualSuccessScreenStatus = addMoneyPage.getTrxStatus();
//        String actualSuccessScreenTotalAmount = addMoneyPage.getTotalAmountPaid();
//
//        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, expectedSuccessScreenStatus, "Success Screen | TRX Status", false);
//        mbkReporter.verifyEqualsWithLogging(actualSuccessScreenTotalAmount, amount, "Success Screen | Total Amount Paid", false);
//
//        // Come back to the homepage
//        homePage.clickOnLogoMbk();
//
//    }

//    public void handleIndusindWebView(String password) throws InterruptedException {
//        Element.waitForVisibility(driver, addMoneyPage.indusInd_logo, "IndusInd Logo");
//
//        addMoneyPage.clickOnBankPageSecurePassword();
//        addMoneyPage.clickOnBankPageContinueButton();
//        addMoneyPage.enterBankPagePassword(password);
//        addMoneyPage.clickOnBankPageSubmitButton();
//
//        Thread.sleep(10000);
//
//
//    }

    public void handlePayZappWebView(String password) throws InterruptedException {
        Element.waitForVisibility(driver, addMoneyPage.payzapp_logo, "Payzapp Logo");
        addMoneyPage.enterPayzappPin(password);
        addMoneyPage.clickOnPayzappPageSubmitButton();
        Thread.sleep(10000);

    }

    public void handleIndusIndWebView(String password) throws InterruptedException {
        Element.waitForVisibility(driver, addMoneyPage.indusInd_logo, "Indusind Logo");
//        addMoneyPage.enterIndusIndBankPageOtp(password);
        Thread.sleep(6000);
        addMoneyPage.clickOnIndusIndBankPageSubmitButton();
        Thread.sleep(16000);

    }

    public WebDriver handleAddMoney(String cardNo, String month, String year, String cvv, String bankPassword) throws InterruptedException {
        if(Element.isElementPresent(driver, By.xpath("//label[@class= 'ft12 mft13 dpBLock tgreyteel']"))) {
            Browser.ScrollToVisibleElement(driver,By.xpath("//div[@class= 'pad40 ptop separator']"));
            addMoneyPage.clickOnNewCard();
        }

        // Enter the card
        addMoneyPage.enterCardNo(cardNo);
        addMoneyPage.enterExpiryMonth();
//        WebElement expiryMonth= driver.findElement(By.id("a950aeb29f63-"+(month-1)));
        WebElement expiryMonth= driver.findElement(By.xpath("//span[text()='"+month+"']"));

        Element.selectElement(driver,expiryMonth,"Select Expiry Month");

        addMoneyPage.enterExpiryYear();
        WebElement expiryYear= driver.findElement(By.xpath("//span[text()='"+year+"']"));
        Element.selectElement(driver,expiryYear,"Enter Expiry Year");

        Thread.sleep(2000);
        addMoneyPage.enterCvv(cvv);

        // Click on the Proceed button
        addMoneyPage.clickOnProceedToPay2();

        // Handle the Bank page
        handleIndusIndWebView("");

        Thread.sleep(3000);

        return driver;

    }

//    public void applyPromoCodeAddMoney(String promoCode, String expectedText) throws InterruptedException {
//        // Click on Apply a coupon code
//        addMoneyPage.clickOnApplyACouponCode();
//
//        // Enter the code
//        addMoneyPage.enterCoupon(promoCode);
//
//        // Click on Apply
//        addMoneyPage.clickOnApply();
//
//        Thread.sleep(3000);
//
//        // Assert the promocode text
//        String actualCouponCodeText = addMoneyPage.getCouponCodeText();
//
//        mbkReporter.verifyEqualsWithLogging(actualCouponCodeText, expectedText, "Coupon Code Text", false);
//    }

}
