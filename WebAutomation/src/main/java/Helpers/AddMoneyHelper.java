package Helpers;


import PageObject.AddMoneyPage;
import PageObject.DashboardPage;
import PageObject.HomePage;
import Utils.Browser;
import Utils.Element;
import Utils.Log;
import Utils.MbkReporter;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        Boolean newCardWindowFlow=false;
        // Click on Add Money button
        addMoneyPage = homePage.clickOnAddMoney();

        // Enter the amount
        Thread.sleep(2000);
        addMoneyPage.enterAmount(amount);

        // Click on continue button
        addMoneyPage.clickOnCtaContinue();
        Thread.sleep(2000);

        // Click on the New Debit/Credit card

        if(Element.isElementPresent(driver, By.xpath("//div[@class= 'dpTable cardSecWrap']"))) {
//            addMoneyPage.clickOnDebitOrCreditCards("debit");
            // Click in new Card
            addMoneyPage.clickOnNewCard();
            newCardWindowFlow=true;

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
        addMoneyPage.enterCvv(cvv,newCardWindowFlow);

        // Click on the Proceed button
        addMoneyPage.clickOnProceedToPay2();

        // Handle the Bank page
//        handlePayZappWebView(bankPassword);

        handleIndusIndWebView();

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

    public void handleIndusIndWebView() throws InterruptedException {

        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(6000);
        String newOtp=getOtpDetails();
        Thread.sleep(2000);

        js.executeScript("document.getElementById(\"otpValue\").value=\""+newOtp+"\";");
        Thread.sleep(2000);

        js.executeScript("document.getElementById(\"submitBtn\").click();");
        Thread.sleep(16000);

    }

    public WebDriver handleAddMoney(String cardNo, String month, String year, String cvv, String bankPassword) throws InterruptedException {
       Boolean newCardWindowFlow=false;

        if(Element.isElementPresent(driver, By.xpath("//div[@class= 'dpTable cardSecWrap']"))) {
//            addMoneyPage.clickOnDebitOrCreditCards("debit");
            // Click in new Card
            addMoneyPage.clickOnNewCard();
            newCardWindowFlow=true;

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
        addMoneyPage.enterCvv(cvv,newCardWindowFlow);

        // Click on the Proceed button
        addMoneyPage.clickOnProceedToPay2();

        // Handle the Bank page
        handleIndusIndWebView();

        Thread.sleep(3000);

        return driver;

    }

    public String getOtpDetails() {
        // Specify the base URL to the RESTful web service

        RestAssured.baseURI = "https://firebasestorage.googleapis.com/";
        RestAssured.basePath="v0/b/testingsyncotpfirebase.appspot.com/o";

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given().log().all().urlEncodingEnabled(false);

        //Specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "otpTesting%2Fotp.json?alt=media");
        // Print the status and message body of the response received from the server

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        String output=response.prettyPrint().replace("{\"otp\":\"","").replace("\"}", "");
        System.out.println("Output Otp=>" + output);
        return output;
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

//    public JSONObject readJsonFromUrl(String link) throws IOException, JSONException {
//        InputStream input = new URL(link).openStream();
//        // Input Stream Object To Start Streaming.
//        try {                                 // try catch for checked exception
//            BufferedReader re = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
//            // Buffer Reading In UTF-8
//            String Text = Read(re);         // Handy Method To Read Data From BufferReader
//            JSONObject json = new JSONObject(Text);    //Creating A JSON
//            return json;    // Returning JSON
//        } catch (Exception e) {
//            return null;
//        } finally {
//            input.close();
//        }
//    }

}
