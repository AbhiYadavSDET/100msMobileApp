package Helpers;

import Logger.Log;
import PageObject.GoldPage;
import PageObject.HelpAndSupportPage;
import PageObject.SecurityPinPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HelpAndSupportHelper {

    AndroidDriver<AndroidElement> driver;
    HelpAndSupportPage helpAndSupportPage;
    SecurityPinPage securityPinPage;
    Screen screen;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    public HelpAndSupportHelper(AndroidDriver driver) throws IOException {

        this.driver = driver;
        helpAndSupportPage = new HelpAndSupportPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void helpAndSupport(String query, String expTitleOnCategoryPage, String expTitleOnTransactionPage, String expTitleOnQueryPage) throws InterruptedException, IOException {

        // Click on profile icon
        securityPinPage.clickOnProfile();

        Thread.sleep(2000);

        // Swipe till the bottom
        screen.swipeUpMoreFromRightSide(driver);

        // Click on Help and Support
        helpAndSupportPage.clickOnHelpAndSupport();

        // Verification on the Category Page
        String titleOnCategoryPage = helpAndSupportPage.getTitle();
        // Display the values
        Log.info("Title On Category Page : " + titleOnCategoryPage);
        // Add the assertions
        mbReporter.verifyEqualsWithLogging(titleOnCategoryPage, expTitleOnCategoryPage, "Verify Title On Category Page", false, false , true );

        // Click on the Issue
        helpAndSupportPage.clickOnIssue();

        // Verification on the Transaction Page
        String titleOnTransactionPage = helpAndSupportPage.getTitle();
        // Display the values
        Log.info("Title On Transaction Page : " + titleOnTransactionPage);
        // Add the assertions
        mbReporter.verifyEqualsWithLogging(titleOnTransactionPage, expTitleOnTransactionPage, "Verify Title On Transaction Page", false, false , true );

        // select transaction
        helpAndSupportPage.selectTransaction();

        // Verification on the Transaction Page
        String titleOnQueryPage = helpAndSupportPage.getTitle();
        // Display the values
        Log.info("Title On Query Page : " + titleOnQueryPage);
        // Add the assertions
        mbReporter.verifyEqualsWithLogging(titleOnQueryPage, expTitleOnQueryPage, "Verify Title On Query Page", false, false , true );

        // Click on question
        helpAndSupportPage.clickOnQues();

        //Tap on text editor
        helpAndSupportPage.tapOnQuery();

        // Enter your query
        helpAndSupportPage.typeQuery(query);

        // Click on Send
        helpAndSupportPage.clickOnSend();

        // check if query is already raised.
        if(helpAndSupportPage.isPopUpPresent()){
            helpAndSupportPage.clickOnOk();
        }

        Thread.sleep(2000);


    }


}
