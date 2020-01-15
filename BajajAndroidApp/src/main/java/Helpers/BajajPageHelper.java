package Helpers;


import PageObject.BajajPage;
import PageObject.HomePage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * contains all methods to test Add Money Flow
 */
public class BajajPageHelper {
    AndroidDriver driver;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    BajajPage bajajPage;
    HomePage homePage;
    PermissionHelper permissionHelper;


    public BajajPageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        bajajPage = new BajajPage(driver);
        homePage = new HomePage(driver);
        permissionHelper = new PermissionHelper(driver);

    }



    public void validateEmiCardAndDetails(String dob) throws InterruptedException, IOException, JSONException{



        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Your Bajaj Finserv EMI Network Card is ready!']")))
        {

           bajajPage= homePage.clickOnKnowMoreBajajOverlay();

        }else {
            mbkCommonControlsHelper.dismissAllOnHomePage(driver);

            bajajPage= homePage.selectEmiCard();
        }


        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Benefits of the EMI Network Card']"));

        bajajPage.enterDob(dob);

        bajajPage.selectSeeEmiCards();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new.bajajfinserv:id/cardNumber"));


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/cardNumber")), bajajPage.getCardNumber(), true, false);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/cardHolderName")), bajajPage.getCardHolderName(), true, false);


        Thread.sleep(2000);

//        bajajPage.selectViewCardNumber();
//
//        Thread.sleep(1000);
//
//        permissionHelper.permissionAllow();
//
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'OTP will get auto-read']")), "Otp pop Opened", true, false);
//
//
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Screen.swipeUpMore(driver);

        if(Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/loan_product_name"))==false){
            Screen.swipeUpMore(driver);
        }

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/loan_product_name")), bajajPage.getLoanId(), true, false);


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/txt_loan_amount")), bajajPage.getLoanAmount(), true, false);


        bajajPage.selectViewDetails();

        Thread.sleep(2000);


        bajajPage.getEmiAndLoanDetails();

        Thread.sleep(2000);

        bajajPage.selectBackButton();

        Thread.sleep(1000);

        bajajPage.selectBackButton();


        driver.pressKey(new KeyEvent(AndroidKey.BACK));



    }


    public void validateAdsAreVisible() throws InterruptedException, IOException, JSONException {


        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Your Bajaj Finserv EMI Network Card is ready!']")))
        {

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            Thread.sleep(2000);

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Ad']")), "Ads are Present", true, false);

        }else {


            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Ad']")), "Ads are Present", true, false);

        }


    }

    public void validateInstaCreditVisible() throws InterruptedException, IOException, JSONException {


        Thread.sleep(2000);


        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Your Bajaj Finserv EMI Network Card is ready!']")))
        {

            driver.pressKey(new KeyEvent(AndroidKey.BACK));

            Thread.sleep(2000);

            Screen.swipeUpMore(driver);


            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text ='InstaCredit']"))==false){

                Screen.swipeUpMore(driver);
            }

            bajajPage=homePage.clickOnKnowMoreInstaCreditOffer();

            Thread.sleep(2000);
            mbReporter.verifyEqualsWithLogging(bajajPage.getAmountQueryText(), "Insta Credit offers for you", "Insta Credit Page visible", true, false);

            bajajPage.selectInstaCreditOffer();

            Element.waitForVisibility(driver, By.id("com.mobikwik_new.bajajfinserv:id/txt_credit_amount"));

            bajajPage.getInstaCreditLoanDetails();

            driver.pressKey(new KeyEvent(AndroidKey.BACK));


            bajajPage.selectBackButton();

            if( Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/bottom_sheet_text"))){


                bajajPage.getFeedbackReason();
                bajajPage.selectFeedback();

            }



        }else {


            Screen.swipeUpMore(driver);


            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text ='InstaCredit']"))==false){

                Screen.swipeUpMore(driver);
            }

            bajajPage=homePage.clickOnKnowMoreInstaCreditOffer();

            Thread.sleep(2000);
            mbReporter.verifyEqualsWithLogging(bajajPage.getAmountQueryText(), "Insta Credit offers for you", "Insta Credit Page visible", true, false);

            bajajPage.selectInstaCreditOffer();

            Element.waitForVisibility(driver, By.id("com.mobikwik_new.bajajfinserv:id/txt_credit_amount"));

            bajajPage.getInstaCreditLoanDetails();

            driver.pressKey(new KeyEvent(AndroidKey.BACK));


            bajajPage.selectBackButton();

            if( Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/bottom_sheet_text"))){

                bajajPage.getFeedbackReason();
                bajajPage.selectFeedback();

            }

        }


    }



}