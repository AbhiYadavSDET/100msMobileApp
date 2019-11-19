package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.GiftCardPage;
import test.java.AndroidApp.PageObject.GoldPage;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.SideDrawerPage;

import java.io.IOException;
import java.util.List;

public class GoldHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    GoldPage goldPage;
    SideDrawerPage sideDrawerPage;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;
    AddMoneyHelper addMoneyHelper;


    public GoldHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        goldPage = new GoldPage(driver);
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }



    public void buyGold(String securityPin, String amount) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        goldPage = homePage.clickGoldIcon();
        Thread.sleep(3000);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Gold Balance :']"))){

            goldPage.clickOnBuyGoldRegisteredUser();
        }else {
            goldPage.clickOnBuyGold();
        }


        goldPage.enterAmount(amount);

        goldPage.clickBuyNowCta();

        goldPage.clickOnMakePaymentCta();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);
        Thread.sleep(3000);


        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']"));


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), goldPage.getTxnStatus(), true, false);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), "Order id is : "+ goldPage.getOrderId(), true, false);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), "Quantity in gram is : "+ goldPage.getQuantityInGram(), true, false);


        goldPage.clickCheckYourGoldBalance();

        goldPage.checkHistory();

        goldPage.selectTransaction();


        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/gold_purchased_or_sold"));


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/gold_purchased_or_sold")),"Invoice Id on History Page : "+goldPage.getInvoiceIdHistoryPage(), true, false );


        goldPage.clickBack();


        goldPage.clickBack();


        goldPage.clickBack();


    }

    public void sellGold(String securityPin, String amount) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        goldPage = homePage.clickGoldIcon();
        Thread.sleep(3000);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Gold Balance :']"))){

            goldPage.clickOnSellGoldRegisteredUser();

            goldPage.enterAmount(amount);

            goldPage.clickOnContinueCta();

            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"))){

                goldPage.clickOnSellGoldCta();

                Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']"));


                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), goldPage.getTxnStatus(), true, false);

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), "Order id is : "+ goldPage.getOrderId(), true, false);

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Payment Successful']")), "Quantity in gram is : "+ goldPage.getQuantityInGram(), true, false);


                goldPage.clickCheckYourGoldBalance();

                goldPage.checkHistory();

                goldPage.selectTransaction();


                Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/gold_purchased_or_sold"));

                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/gold_purchased_or_sold")),"Invoice Id on History Page : "+goldPage.getInvoiceIdHistoryPage(), true, false );

                goldPage.clickBack();


                goldPage.clickBack();


                goldPage.clickBack();



            }else {

                String error= goldPage.getErrorDescription();

                mbReporter.verifyTrueWithLogging(!Element.isElementPresent(driver, By.id("com.mobikwik_new:id/txt_description_amount")), error,true, false);

                goldPage.clickBack();


                goldPage.clickBack();

            }


        }else {

            mbReporter.verifyFalse(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Why To Invest?']")), "Gold not available to sell", true, false);


            goldPage.clickBack();


        }








    }



}
