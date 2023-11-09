package Helpers;

import PageObject.HomePage;
import PageObject.ImpsPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class ImpsHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    ImpsPage impsPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    Double fee = 0.00;

    public ImpsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new ImpsPage(driver);

    }


    public void verifyImpsNewAccountTransferFlow(String accountName, String accountNo, String ifsc, String amount, String securityPin, String cardNumber, String expiryMonthYear, String cvv) throws InterruptedException, IOException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        impsPage.clickOnTransfertoANewAccount();

        // Enter the bank details
        impsPage.enterBeneficiaryName(accountName);
        impsPage.enterAccountNo(accountNo);
        impsPage.enterIfsc(ifsc);


        impsPage.clickOnCtaContinue();

        impsPage.sendAmount(amount);
        Thread.sleep(3000);

        int convFee= Integer.parseInt(impsPage.getConvFee().replace("₹",""));

        mbReporter.verifyTrueWithLogging(convFee>0, "Convenience Fee shown to User :"+convFee,false, true);


        impsPage.clickOnContinueArrow();

        impsPage.clickOnConfirm();

        if(impsPage.getPayAmountCtaText().equalsIgnoreCase("continue")){
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }
            Thread.sleep(3000);

        }else {
            mbkCommonControlsHelper.handleAddMoney("withinTestCase", "", cardNumber, expiryMonthYear, cvv);
            Thread.sleep(3000);
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }

        }

        Thread.sleep(5000);

        //Assertion on the success page
        //fetch the values
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        mbReporter.verifyEqualsWithLogging(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹50", "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

    }



    public void verifyImpsSavedAccountTransferFlow(String amount, String securityPin, String cardNumber, String expiryMonthYear, String cvv) throws InterruptedException, IOException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        impsPage.selectFromRecentTransfers("account");

        Thread.sleep(2000);

        impsPage.sendAmount(amount);
        Thread.sleep(3000);

        int convFee= Integer.parseInt(impsPage.getConvFee().replace("₹",""));

        mbReporter.verifyTrueWithLogging(convFee>0, "Convenience Fee shown to User :"+convFee,false, true);

        impsPage.clickOnContinueArrow();

        impsPage.clickOnConfirm();

        if(impsPage.getPayAmountCtaText().equalsIgnoreCase("continue")){
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }
            Thread.sleep(3000);

        }else {
            mbkCommonControlsHelper.handleAddMoney("withinTestCase", "", cardNumber, expiryMonthYear, cvv);
            Thread.sleep(3000);
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }

        }

        Thread.sleep(5000);

        //Assertion on the success page
        //fetch the values
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        mbReporter.verifyEqualsWithLogging(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹50", "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

    }

    public void verifyImpsVPATransferFlow(String amount, String securityPin, String cardNumber, String expiryMonthYear, String cvv) throws InterruptedException, IOException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        impsPage.selectFromRecentTransfers("vpa");

        Thread.sleep(2000);

        impsPage.sendAmount(amount);
        Thread.sleep(3000);

        int convFee= Integer.parseInt(impsPage.getConvFee().replace("₹",""));

        mbReporter.verifyTrueWithLogging(convFee>0, "Convenience Fee shown to User :"+convFee,false, true);


        impsPage.clickOnContinueArrow();

        impsPage.clickOnConfirm();

        if(impsPage.getPayAmountCtaText().equalsIgnoreCase("continue")){
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }
            Thread.sleep(3000);

        }else {
            mbkCommonControlsHelper.handleAddMoney("withinTestCase", "", cardNumber, expiryMonthYear, cvv);
            Thread.sleep(3000);
            if (Element.isElementPresent(driver, By.id("lock_rationale_text_view"))) {
                mbkCommonControlsHelper.handleSecurityPin(securityPin);
            }

        }

        Thread.sleep(5000);

        //Assertion on the success page
        //fetch the values
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        mbReporter.verifyEqualsWithLogging(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹50", "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

    }


}
