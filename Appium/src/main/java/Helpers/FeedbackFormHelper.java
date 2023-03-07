package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class FeedbackFormHelper {
    AndroidDriver<AndroidElement> driver;

    CCPage ccPage;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    FeedbackFormPage feedbackFormPage;
    SyncEmailBottomSheet syncEmailBottomSheet;

    public FeedbackFormHelper(AndroidDriver<AndroidElement> driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        ccPage = new CCPage(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        feedbackFormPage = new FeedbackFormPage(driver);
        syncEmailBottomSheet = new SyncEmailBottomSheet(driver);


    }
    public void submitFeedbackForm(String expTitle) throws InterruptedException, IOException {

        // Click on Recharge And PayBills
        ccPage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        // Click on Credit card payment option
        ccPage.clickOnCreditCardPayment();

        //Close Email Sync Bottom sheet
        if(syncEmailBottomSheet.checkEmailSyncBottomSheet())
        {
            syncEmailBottomSheet.clickSyncEmailBottomSheet();
        }

        //Click back button to open feedback form
        feedbackFormPage.clickBackButton();

        feedbackFormPage.clickSuggestion();

        feedbackFormPage.clickSubmitButton();

        String title = feedbackFormPage.getTitle();
        Log.info("Title : " + title);
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);




    }
}
