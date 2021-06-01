package Helpers;

import PageObject.GiftCardPage;
import PageObject.HomePage;
import PageObject.SideDrawerPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.List;

public class GiftCardHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    GiftCardPage giftCardPage;
    SideDrawerPage sideDrawerPage;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;
    AddMoneyHelper addMoneyHelper;


    public GiftCardHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        giftCardPage = new GiftCardPage(driver);
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }

    public void buyGiftCard(String giftCard, String amount, String name, String phoneNumber, String emailId, String pin, String cardNo, String cvv, String bankPassword) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Gift Cards']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        giftCardPage = homePage.clickGiftCardIcon();


        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Benefits of Gift Cards']"));

        giftCardPage.clickViewGiftCards();

        Thread.sleep(2000);

        Element.waitForVisibility(driver, By.id("btn_search"));

        giftCardPage.searchGiftCard();

        giftCardPage.enterGiftCard(giftCard);

        Thread.sleep(2000);

        if ((giftCardPage.getBrandName()).equalsIgnoreCase(giftCard)) {


            Thread.sleep(2000);

            giftCardPage.selectBrandGiftCard();

            Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Buy for self']"));

            giftCardPage.selectAmount();

            giftCardPage.enterAmount(amount);

            giftCardPage.clickNext();

            giftCardPage.enterName(name);

            giftCardPage.enterPhoneNumber(phoneNumber);

            giftCardPage.enterEmailId(emailId);

            giftCardPage.clickBuyCard();

            mbkCommonControlsHelper.handleSecurityPin(pin);


            Thread.sleep(3000);

            addMoneyHelper = new AddMoneyHelper(driver);
            addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);

            Thread.sleep(3000);


            Element.waitForVisibility(driver, By.id("base_title"));


            mbReporter.verifyTrueWithLogging(Element.waitForVisibility(driver, By.id("base_title")), "Success Page Title is : " + giftCardPage.getSuccessPageTitle(), true, false);

            mbReporter.verifyTrueWithLogging(Element.waitForVisibility(driver, By.id("base_title")), "Gift Card orderId : " + giftCardPage.getOrderId(), true, false);


            giftCardPage.clickOk();

            mbkCommonControlsHelper.handleNPS();

            giftCardPage.clickBackToHome();

        } else {

            mbReporter.verifyFalse(Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Buy for self']")), "Gift Card not available", true, false);

        }

    }

    public void checkPurchasedGiftCard(String giftCard) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Gift Cards']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        giftCardPage = homePage.clickGiftCardIcon();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Benefits of Gift Cards']"));

        giftCardPage.clickViewGiftCards();

        Thread.sleep(2000);

        Element.waitForVisibility(driver, By.id("btn_search"));

        giftCardPage.clickMyGiftsButton();

        giftCardPage.checkSentGiftCards();

        if ((giftCardPage.getBrandName()).equalsIgnoreCase(giftCard)) {

            giftCardPage.selectBrandGiftCard();

            Thread.sleep(2000);

            if (Element.isElementPresent(driver, By.id("body_text"))){

                String error= giftCardPage.getErrorPopUpText();

                mbReporter.verifyTrueWithLogging(error!=null, ""+error+"", true, false);
                giftCardPage.pressOk();


            }else {

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("btn_share")), "Gift Card available", true, false);

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("btn_share")), "Recipient Name is : " + giftCardPage.getRecipientName(), true, false);

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("btn_share")), "Order Id is : " + giftCardPage.getOrderId(), true, false);

                giftCardPage.clickBackToHome();

            }
        }

        giftCardPage.clickBackToHome();

        giftCardPage.clickBackToHome();


    }


    public void checkCategoryFilter() throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Gift Cards']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        giftCardPage = homePage.clickGiftCardIcon();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Benefits of Gift Cards']"));


        giftCardPage.clickViewGiftCards();

        Thread.sleep(2000);

        giftCardPage.clickMoreIcon();


        List<AndroidElement> category = Element.findElements(driver, By.id("icon_txt"));
        int noOfCategories = category.size() - 1;

        mbReporter.verifyTrueWithLogging(noOfCategories > 0, "No of Catgeories are : " + noOfCategories, true, false);


        giftCardPage.clickTrendingIcon();

        List<AndroidElement> offers = Element.findElements(driver, By.id("offer_brand"));
        int noOfOffers = offers.size();


        mbReporter.verifyTrueWithLogging(noOfOffers > 0, "No of offers available under trending : " + noOfOffers, true, false);


        giftCardPage.clickBackToHome();

        giftCardPage.clickBackToHome();


    }


}
