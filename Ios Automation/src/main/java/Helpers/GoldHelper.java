package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GoldHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    RechargePage rechargePage;
    MBReporter mbReporter;
    GoldPage goldPage;
    SecurityPinPage securityPinPage;

    public GoldHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        mbReporter = new MBReporter(driver);
        goldPage = new GoldPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goldBuy(String amount, String expTitleOnSuccessScreen, String expSubTitleOnSuccessScreen, String expAmountOnSuccessScreen,String expQuantityOnSuccessScreen) throws InterruptedException,IOException {

        //Click All services
        homePage.clickAllServices();

        Screen.swipeUp(driver);

        //Click on gold
        goldPage.clickGold();

        Thread.sleep(2000);

        Screen.tapOutsideBottomSheetByCoordinates(driver);

        //Click on Buy button
        goldPage.clickBuyButton();

        Thread.sleep(1000);

        //Click on Amount field
        goldPage.clickAmountField();

        //Enter amount
        goldPage.enterAmount(amount);

        //Click on Pay button
        rechargePage.clickOnPayButton();

        if(securityPinPage.isSecurityPinPageShown()){
            //Enter security pin
            securityPinPage.enterSecurityPin();
        }

        //Verification on success screen
        String actualTitleOnSuccessScreen = goldPage.getTitleOnSuccessScreen();
        String actualSubTitleOnSuccessScreen = goldPage.getSubTitleOnSuccessScreen();
        String actualQuantityOnSuccessScreen = goldPage.getQuantityOnSuccessScreen();
        String actualAmountOnSuccessScreen = goldPage.getAmountOnSuccessScreen();

        Log.info("Title on Buy Success screen : " + actualTitleOnSuccessScreen);
        Log.info("Sub-title on Buy Success screen : " + actualSubTitleOnSuccessScreen);
        Log.info("Quantity on Buy Success scree : " + actualQuantityOnSuccessScreen);
        Log.info("Title on Buy Success screen : " + actualAmountOnSuccessScreen);

        mbReporter.verifyEqualsWithLogging(actualTitleOnSuccessScreen, expTitleOnSuccessScreen, "Verify Title on buy success screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSubTitleOnSuccessScreen, expSubTitleOnSuccessScreen, "Verify Sub-title on buy success screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualQuantityOnSuccessScreen, expQuantityOnSuccessScreen, "Verify quantity on buy success screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualAmountOnSuccessScreen, expAmountOnSuccessScreen, "Verify amount on buy success screen", false, false, true);

    }

    public void goldSell(String amount, String expSellQuantity, String expReceivableAmount, String expTitleOnSuccessScreen, String expSubTitleOnSuccessScreen) throws InterruptedException,IOException {

        //Click All services
        homePage.clickAllServices();

        Screen.swipeUp(driver);

        //Click on gold
        goldPage.clickGold();

        Thread.sleep(2000);

        Screen.tapOutsideBottomSheetByCoordinates(driver);

        //Click on Buy button
        goldPage.clickSellButton();

        Thread.sleep(1000);

        //Click on Amount field
        goldPage.clickAmountField();

        //Enter amount
        goldPage.enterAmount(amount);

        //Click on Continue button
        rechargePage.clickOnContinueButton();

        Thread.sleep(1000);

        //Verification on confirm payment screen
        String actualSellQuantity = goldPage.getSellQuantity();
        String actualReceivableAmount = goldPage.getReceivableAmount();

        Log.info("Sell Quantity on confirm payment screen : " + actualSellQuantity);
        Log.info("Receivable amount on confirm payment screen : " + actualReceivableAmount);

        mbReporter.verifyEqualsWithLogging(actualSellQuantity, expSellQuantity,"Verify sell quantity on confirm payment screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualReceivableAmount, expReceivableAmount,"Verify receivable amount on confirm payment screen", false, false, true);


        if(securityPinPage.isSecurityPinPageShown()){
            //Enter security pin
            securityPinPage.enterSecurityPin();
        }

        //Verification on success screen
        String actualTitleOnSuccessScreen = goldPage.getTitleOnSuccessScreen();
        String actualSubTitleOnSuccessScreen = goldPage.getSubTitleOnSuccessScreen();

        Log.info("Title on Success screen : " + actualTitleOnSuccessScreen);
        Log.info("Sub-title on Success screen : " + actualSubTitleOnSuccessScreen);

        mbReporter.verifyEqualsWithLogging(actualTitleOnSuccessScreen, expTitleOnSuccessScreen, "Verify Title on sell success screen", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualSubTitleOnSuccessScreen, expSubTitleOnSuccessScreen, "Verify Sub-title on sell success screen", false, false, true);


    }
}
