package Helpers;
import Logger.Log;
import PageObject.*;
import Utils.Element;
import io.appium.java_client.android.AndroidDriver;
import Utils.MBReporter;
import Utils.Screen;
import org.openqa.selenium.By;

import java.io.IOException;

import java.util.HashMap;

    public class HistoryHelper {
        AndroidDriver<io.appium.java_client.android.AndroidElement> driver;

        HistoryPage historyPage;
        Screen screen;
        Element element;
        MBKCommonControlsHelper mbkCommonControlsHelper;
        AAHelper aAHelper;
        AccountAggregatorPage accountAggregatorPage;
        MBReporter mbReporter;

        public HistoryHelper(AndroidDriver driver) throws IOException {
            this.driver = driver;
            historyPage = new HistoryPage(driver);
            screen = new Screen(driver);
            element = new Element(driver);
            mbReporter = new MBReporter(driver);
            mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
            aAHelper = new AAHelper(driver);
            accountAggregatorPage= new AccountAggregatorPage(driver);
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


        public void existingUserHistory(String expallCategoriesTitle,String exphelpTitle) throws InterruptedException, IOException {
            historyPage.clickHistoryTab();
            historyPage.clickMobikwikHeaderOnHistory();

            // First Mobikwik Tab verification for kyced User

            mbReporter.verifyTrueWithLogging(historyPage.isTotalBalancePresent(), "Is Total Balance Present", false, false);


            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Enable secure login']"))) {
                mbkCommonControlsHelper.handleSetupSecurityBottomSheet();
            }

            String helpTitle = historyPage.getHelpText();

            Log.info("Help Title :" + helpTitle);

            mbReporter.verifyEqualsWithLogging(helpTitle, exphelpTitle, "Verify Help Title", false, false, true);
            mbReporter.verifyTrueWithLogging(historyPage.isTxnHistoryDataPresent(), "Is Transaction History Data Present", false, false);

            historyPage.clickonTxnHistoryDataPresent();
            if (Element.isElementPresent(driver, By.id("download_statement_frame")))
            {

                Log.info("Invoice not present");

            }

            else {
                Element.waitForVisibility(driver, By.id("mkab_icon_1"));

                historyPage.clickonBackCTAOnInvoiceTxn();
                if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Enable secure login']"))) {
                    mbkCommonControlsHelper.handleSetupSecurityBottomSheet();
                }
                historyPage.clickonAllCategories();
                historyPage.clickonDoneCTAOnselectCategoryPage();
            }

        }
        public void existingUserHistoryAAbottomSheet(String expselectYourBank,String expinsightTxt) throws InterruptedException, IOException
        {
            historyPage.clickHistoryTab();
            historyPage.clickBankAccountOnHistory();

            String insightTxt = historyPage.getIsightTxt();
            Log.info("Get Insight Txt" +insightTxt );
            mbReporter.verifyEqualsWithLogging(insightTxt, expinsightTxt, "Insight txt", false, false, true);


            historyPage.clickOnRightArrowNexttobankNo();

            String selectYourBank = historyPage.getTxtSelectYourBank();
            Log.info("Select your bank txt:" +selectYourBank );
            mbReporter.verifyEqualsWithLogging(selectYourBank, expselectYourBank, "Select your bank txt", false, false, true);


        }

    }