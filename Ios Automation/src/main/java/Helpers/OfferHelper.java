package Helpers;

import Logger.Log;
import PageObject.OfferPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OfferHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    OfferPage offerPage;
    Screen screen;
    MBReporter mbReporter;


    public OfferHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        offerPage = new OfferPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void searchOffers(String offerName, String expTileTitle, String expTileDescription, String expTitle, String expCtaText) throws InterruptedException, IOException {

        // Click on Offers Button
        offerPage.clickOffers();

        // Click on Search Button
        offerPage.clickSearchOfferButton();

        // Enter the name of the offer
        offerPage.enterOffer(offerName);

        // Get & Assert the Tile details
        String tileTitle = offerPage.getTileTitle();
        String tileDescription = offerPage.getTileDescription();

        Log.info("Tile Title : " + tileTitle);
        Log.info("Tile Description : " + tileDescription);

        mbReporter.verifyEqualsWithLogging(tileTitle, expTileTitle, "Verify Tile Title", false,false,true);
        mbReporter.verifyEqualsWithLogging(tileDescription, expTileDescription, "Verify Tile Decription", false,false,true);

        // Click on the tile
        offerPage.clickLogo();

        // Assert the Label and Cta Text
        String title = offerPage.getTitle();
        String ctaText = offerPage.getCtaText();

        Log.info("Title : " + title);
        Log.info("Cta Text : " + ctaText);

        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false,false,true);
        mbReporter.verifyEqualsWithLogging(ctaText, expCtaText, "Verify Cta Text", false,false,true);


    }


}
