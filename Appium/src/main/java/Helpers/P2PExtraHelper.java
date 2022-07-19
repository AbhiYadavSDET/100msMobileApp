package Helpers;

import PageObject.AddMoneyPage;
import PageObject.HomePage;
import PageObject.P2PExtraPage;
import PageObject.TransactionHistoryPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class P2PExtraHelper {

    AndroidDriver driver;
    HomePage homePage;
    P2PExtraPage p2PExtraPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;


    public static HashMap<String, String> map;


    public P2PExtraHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }



    public void investMoney(String amount, String cardNo, String expiry, String cvv, String bankPin) throws InterruptedException, IOException {

        Log.info("START", "P2P Extra-Invest");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);


        int returns=Integer.parseInt(amount)%12;
        Log.info("returns : " + returns);

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        homePage.clickInvestmentAndInsuranceLayout();

        p2PExtraPage=homePage.clickP2PExtra();

        Element.waitForVisibility(driver, By.id("tv_heading"));

        if (!Element.isElementPresent(driver, By.id("tv_heading"))){
            Boolean error= p2PExtraPage.getErrorMessageText().equals("We had a little hiccup! In the meantime you can check your network connection too!");
            mbReporter.verifyTrueWithLogging(error,"Timeout Screen Shown", false,false);
            p2PExtraPage.retryCta();
            Element.waitForVisibility(driver, By.id("tv_heading"));
        }

        int investedAmountBefore=Integer.parseInt(p2PExtraPage.getInvestedAmount());

        p2PExtraPage.selectInvestMore();
        Element.waitForVisibility(driver, By.id("cta"));

        p2PExtraPage.enterAmountToInvest(amount);
        mbReporter.verifyEqualsWithLogging(p2PExtraPage.getReturnAmount(),returns,"Verify Returns on Invested amount", false,false);
        p2PExtraPage.selectInvestNow();

        Element.waitForVisibility(driver, By.id("heading"));
        mbReporter.verifyEqualsWithLogging(p2PExtraPage.getTotalInvestmentAmount(),amount,"Verify Amount entered on previous Screen , Passed Correctly",false,true);
        p2PExtraPage.proceedToPay();

        mbkCommonControlsHelper.handleAddMoney("withinTestCase", amount,cardNo,expiry,cvv,bankPin);
        Thread.sleep(3000);
        Element.waitForVisibility(driver, By.id("small_lottie"));

        mbReporter.verifyEqualsWithLogging(p2PExtraPage.getSuccessPageTitleText(),"Investment is successful","Validate Success Page",true,true);

        Log.info("Description Text : "+p2PExtraPage.getSuccessPageDescriptionText());

        mbReporter.verifyEqualsWithLogging(p2PExtraPage.getSuccessPageInvestedAmount(),amount,"Validate Amount",true,true);

        p2PExtraPage.pressBackFromSuccessPage();

        int investedAmountAfter=Integer.parseInt(p2PExtraPage.getInvestedAmount());

        String amountIncreased= String.valueOf(investedAmountAfter-investedAmountBefore);

        mbReporter.verifyEqualsWithLogging(amountIncreased,amount,"Verify Amount on Dashboard",true, false);

        p2PExtraPage.selectHistoryCta();

        Log.info(p2PExtraPage.getLatestTransactionRecord());

        p2PExtraPage.backButton();

        homePage=p2PExtraPage.backToHomeButton();

        homePage.closeInvestmentsBottomSheet();

        Log.info("END", "Invest Money : P2P Extra");


    }


    public void withdrawMoney(String amount) throws InterruptedException, IOException {

        Log.info("START", "P2P Extra-Withdraw");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);


        int returns=Integer.parseInt(amount)%12;
        Log.info("returns : " + returns);

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        homePage.clickInvestmentAndInsuranceLayout();

        p2PExtraPage=homePage.clickP2PExtra();

        Element.waitForVisibility(driver, By.id("tv_heading"));

        if (!Element.isElementPresent(driver, By.id("tv_heading"))){
            Boolean error= p2PExtraPage.getErrorMessageText().equals("We had a little hiccup! In the meantime you can check your network connection too!");
            mbReporter.verifyTrueWithLogging(error,"Timeout Screen Shown", false,false);
            p2PExtraPage.retryCta();
            Element.waitForVisibility(driver, By.id("tv_heading"));
        }

        int investedAmountBefore=Integer.parseInt(p2PExtraPage.getInvestedAmount());

        p2PExtraPage.selectWithdraw();
        Element.waitForVisibility(driver, By.id("tvAvailableBal"));

        int available=Integer.parseInt(p2PExtraPage.getAvailableBalanceToWithdraw());
        int amountToWithdraw=Integer.parseInt(amount);

        if(available>=amountToWithdraw) {
            p2PExtraPage.enterAmountToWithdraw(amount);

            p2PExtraPage.selectWithdrawCta();

            Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Would you still want to withdraw?']"));

            p2PExtraPage.confirmWithdrawCta();
            p2PExtraPage.selectBankToWithdraw();
            p2PExtraPage.bankWithdrawCta();

            Element.waitForVisibility(driver, By.id("small_lottie"));

            mbReporter.verifyEqualsWithLogging(p2PExtraPage.getSuccessPageTitleText(), "Withdrawal request placed successfully", "Validate Success Page", true, true);

            Log.info("Description Text : " + p2PExtraPage.getSuccessPageDescriptionText());

            mbReporter.verifyEqualsWithLogging(p2PExtraPage.getSuccessPageInvestedAmount(), amount, "Validate Amount", true, true);

            p2PExtraPage.pressBackFromSuccessPage();

            int investedAmountAfter = Integer.parseInt(p2PExtraPage.getInvestedAmount());

            String amountDecreased = String.valueOf(investedAmountBefore-investedAmountAfter);

            mbReporter.verifyEqualsWithLogging(amountDecreased, amount, "Verify Amount on Dashboard", true, false);

            p2PExtraPage.selectHistoryCta();

            Log.info(p2PExtraPage.getLatestTransactionRecord());

            p2PExtraPage.backButton();

            homePage = p2PExtraPage.backToHomeButton();

            homePage.closeInvestmentsBottomSheet();

            Log.info("END", "Invest Money : P2P Extra");
        }else{

            Log.info("STOPPED","Balance not available to Withdraw");

            p2PExtraPage.backButton();

            homePage = p2PExtraPage.backToHomeButton();

            homePage.closeInvestmentsBottomSheet();

            Log.info("END", "Invest Money : P2P Extra");


        }

    }


}


