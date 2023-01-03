package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import Utils.Elements;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GoldHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    GoldPage goldPage;
    Screen screen;


    public GoldHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        goldPage = new GoldPage(driver);
        screen = new Screen(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goldBuy(String amount) throws InterruptedException {

        // Tap on See All Services
        goldPage.clickAllServices();

        // Swipe till the bottom
        screen.swipeUpMore(driver);

        // Click on 99% Buy Gold
        goldPage.clickBuyGold();

        // Click on Buy Gold
        goldPage.clickBuyCta();

        // Enter the Gold amount
        goldPage.enterAmount(amount);

        // Click on Pay Now CTA
        goldPage.clickPayCta();

        // Verification on the Success Screen
        String title = goldPage.getTitle();
        String subTitle = goldPage.getSubTitle();
        String goldAmount = goldPage.getGoldAmount();
        String txnAmount = goldPage.getAmount();

        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Gold Amount : " + goldAmount);
        Log.info("Txn Amount : " + txnAmount);


        // Click on the Back Icon
        goldPage.clickCloseIcon();

        // Click on the up Icon


    }

}
