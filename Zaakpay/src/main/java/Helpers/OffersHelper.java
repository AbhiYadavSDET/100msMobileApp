package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;

public class OffersHelper {

    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    OffersSuccessPage offersSuccessPage;
    public static HashMap<String, String> transactionMap = new HashMap<>();


    public OffersHelper(WebDriver driver)
    {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbkReporter = new MbkReporter();

    }

   public void offersOption(String email, String password, String orderid ,String zaakpayid , String expectedDescription) throws InterruptedException {

       //Click on Login button
       homePage.clickOnLoginButton();
       //Enter Email
       homePage.enterEmail(email);
       //Enter Password
       homePage.enterPassword(password);
       //Click on Submit button
       homePage.clickOnSubmitButton();
       Thread.sleep(3000);
       //Click On transaction option
       homePage.clickOnTransactionOption();
       Thread.sleep(2000);
       homePage.enterOrderId(orderid);
       homePage.enterZaakpayId(zaakpayid);
       homePage.clickOnGoButton();

       Thread.sleep(2000);

       homePage.selectoption();

       Thread.sleep(2000);

       offersSuccessPage = new OffersSuccessPage(driver);
       driver.switchTo().alert().accept();

       Thread.sleep(2000);

       //Assertions

       String actualDescription = offersSuccessPage.getConfirmation();
       mbkReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Success Page Description", false);
    }
}
