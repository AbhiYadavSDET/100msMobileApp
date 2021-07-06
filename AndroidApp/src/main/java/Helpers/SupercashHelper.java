package Helpers;

import PageObject.HomePage;
import PageObject.SupercashStatementPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SupercashHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    SupercashStatementPage supercashStatementPage;
    public static HashMap<String, String> supercashBalance;
    String partnerText, giftcardText, dealsText, rechargesText, discountText;

    public SupercashHelper(AndroidDriver driver) throws InterruptedException, IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        supercashStatementPage = new SupercashStatementPage(driver);
    }

    public void verifySupercash() throws InterruptedException, IOException, JSONException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        supercashBalance =  mbkCommonControlsHelper.getBalance();
        Double actualBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(supercashBalance, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        Thread.sleep(3000);
        supercashStatementPage.clickWalletButton();
        supercashStatementPage.clickStatementButton();


        Thread.sleep(3000);
        //Storing supercash balance in a variable (from supercash page)
        String str = supercashStatementPage.getPointsBalance();
        String substr = str.substring(2);
        double supercash = Double.parseDouble(substr) * 100;

        supercashStatementPage.switchToHistoryTab();
        screen.swipeUpMore(driver);

        supercashStatementPage.switchToSummaryTab();
        screen.swipeUpMore(driver);

        supercashStatementPage.clickOnFAQ();
        Thread.sleep(3000);
        screen.swipeUpMore(driver);
        supercashStatementPage.clickOnBackButton();

        supercashStatementPage.clickOnRedeemButton();
        screen.swipeUpMedium(driver);

        List<MobileElement> myList = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i< myList.size();i++)
        {
            if (myList.get(i).getText().contains("partners")){
                partnerText = myList.get(i).getText();
                myList.get(i).click();
                mbReporter.verifyTrueWithLogging (Element.isElementPresent(driver, By.id("btn_convert_cash")), "Verify Partner Offers Text | Redeem Supercash", false, false);
                supercashStatementPage.clickOnBackButton();
                Thread.sleep(3000);
            }else
                if(myList.get(i).getText().contains("gift")){
                     giftcardText = myList.get(i).getText();
                    myList.get(i).click();
                    mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Gift Cards']")), "Verify Gift Cards | Redeem Superchash", false, false);
                    supercashStatementPage.clickOnBackButton();
                    Thread.sleep(3000);
                }else
                    if(myList.get(i).getText().contains("exclusive deals")){
                         dealsText = myList.get(i).getText();
                        Thread.sleep(3000);
                    }else
                        if(myList.get(i).getText().contains("recharges")){
                            rechargesText = myList.get(i).getText();
                            myList.get(i).click();
                            mbReporter.verifyEqualsWithLogging(driver.findElementById("tx_tittle").getText(),"Recharge & Bill Payments", "Verify Recharge and Bill Text | Redeem Supercash",false, false);
                            supercashStatementPage.clickOnRechargeCloseButton();
                            Thread.sleep(3000);
                        }else
                            if(myList.get(i).getText().contains("discount coupons")){
                             discountText = myList.get(i).getText();
                                myList.get(i).click();
                                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("textActionButton")), "driver.findElementById('textActionButton').isDisplayed()", false, false);
                                supercashStatementPage.clickOnBackButton();
                                break;

                        }
        }

        //Assertions

        mbReporter.verifyEqualsWithLogging(actualBalance, supercash, "Supercash is same on both pages", false, false);
        mbReporter.verifyEqualsWithLogging(partnerText, "Save min 5% on MobiKwik partners", "Validate Partner Text on Redeem Page", false, false);
        mbReporter.verifyEqualsWithLogging(giftcardText, "Save upto 10% on gift cards", "Validate Gift Card Text on Redeem Page", false, false);
        mbReporter.verifyEqualsWithLogging(dealsText, "Exchange for some exclusive deals", "Validate Deals Text on Redeem Page", false, false);
        mbReporter.verifyEqualsWithLogging(rechargesText, "Get 5% discount on recharges & bills", "Validate Recharge Text on Redeem Page", false, false);
        mbReporter.verifyEqualsWithLogging(discountText, "Exchange for MobiKwik discount coupons", "Validate Discount Text on Redeem Page", false, false);

        Thread.sleep(5000);
        supercashStatementPage.navigateBackToHome();

    }
}