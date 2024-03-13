package Helpers;
import Logger.Log;
import PageObject.*;
import Utils.Element;
import io.appium.java_client.android.AndroidDriver;
import Utils.MBReporter;
import Utils.Screen;
import java.io.IOException;

import java.util.HashMap;

    public class HistoryHelper {
        AndroidDriver<io.appium.java_client.android.AndroidElement> driver;

        HistoryPage historyPage;
        Screen screen;
        Element element;
        MBKCommonControlsHelper mbkCommonControlsHelper;
        MBReporter mbReporter;

        public HistoryHelper(AndroidDriver driver) throws IOException {
            this.driver = driver;
            historyPage = new HistoryPage(driver);
            screen = new Screen(driver);
            element = new Element(driver);
            mbReporter = new MBReporter(driver);

        }

    public void newUserHistory() throws InterruptedException, IOException
    {
           historyPage.clickHistoryTab();
           historyPage.clickMobikwikHeaderOnHistory();

           // First Tab verification for Non kyc user
           mbReporter.verifyTrueWithLogging(historyPage.isdescriptionPresentOnMobiwiktab(), "Is Description on Mobikwik History for new user in mobikwik tab", false, false);
           mbReporter.verifyTrueWithLogging(historyPage.isLetsDobuttonPresentOnMobiwiktab(), "Is let do button Presen ton Mobikwik history tab", false, false);

          // Second Tab verification for Non kyc user
           historyPage.clickBankAccountOnHistory();
           mbReporter.verifyTrueWithLogging(historyPage.isNotSetupAACTA(), "Is Not set up bank account CTA in Bank A/c tab", false, false);
           mbReporter.verifyTrueWithLogging(historyPage.isNotSetupAAtTitle(), "Is Not set up bank account Title in bank account CTA  tab", false, false);

          // Third Tab verification for Non kyc user
           historyPage.clickCreditCardOnHistory();
           mbReporter.verifyTrueWithLogging(historyPage.isNotSetupAACTA(), "Is Not set up bank account CTA in Credit tab", false, false);
           mbReporter.verifyTrueWithLogging(historyPage.isNotSetupAAtTitle(), "Is Not set up bank account Title in Credit tab", false, false);

    }
    }