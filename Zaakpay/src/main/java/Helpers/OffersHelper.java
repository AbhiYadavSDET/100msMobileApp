package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class OffersHelper {

    WebDriver driver;
    ZaakpayPage zaakpayPage;
    MbkReporter mbkReporter;
    OffersSuccessPage offersSuccessPage;
    public static HashMap<String, String> transactionMap = new HashMap<>();


    public OffersHelper(WebDriver driver)
    {
        this.driver = driver;
        zaakpayPage = new ZaakpayPage(driver);


        mbkReporter = new MbkReporter();

    }

   public void offersOption(String email, String password, String orderid ,String zaakpayid , String expectedDescription) throws InterruptedException {

       //Click on Login button
       zaakpayPage.clickOnLoginButton();

       //Enter Email
       zaakpayPage.enterEmail(email);

       //Enter Password
       zaakpayPage.enterPassword(password);

       //Click on Submit button
       zaakpayPage.clickOnSubmitButton();
       Thread.sleep(3000);

       //Click On transaction option

       zaakpayPage.clickOnTransactionOption();
       Thread.sleep(2000);

       zaakpayPage.enterOrderId(orderid);
       zaakpayPage.enterZaakpayId(zaakpayid);
       zaakpayPage.clickOnGoButton();

       Thread.sleep(2000);

       zaakpayPage.selectoption();

       Thread.sleep(2000);



       offersSuccessPage = new OffersSuccessPage(driver);
       driver.switchTo().alert().accept();

       Thread.sleep(2000);

       //Assertions

       String actualDescription = offersSuccessPage.getConfirmation();
       mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);


   }

}
