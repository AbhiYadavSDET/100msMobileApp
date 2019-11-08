package Helpers;

import PageObject.DashboardPage;
import PageObject.PaymentOptionsPage;
import PageObject.ZaakpayPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class OffersHelper {

    WebDriver driver;
    ZaakpayPage zaakpayPage;
    MbkReporter mbkReporter;
    PaymentOptionsPage paymentOptionsPage;
    public static HashMap<String, String> transactionMap = new HashMap<>();

    public OffersHelper(WebDriver driver)
    {
        this.driver = driver;
        zaakpayPage = new ZaakpayPage(driver);


        mbkReporter = new MbkReporter();

    }

   public void offersOption(String email, String password, String expectedDescription) throws InterruptedException
   {

       //Click on Login button
       zaakpayPage.clickOnLoginButton();

       //Enter Email
       zaakpayPage.enterEmail(email);

       //Enter Password
       zaakpayPage.enterPassword(password);

       //Click on Submit button
       zaakpayPage.clickOnSubmitButton();

   }

   public void zaakpayDashboard(String expectedDescription)
   {


   }

}
