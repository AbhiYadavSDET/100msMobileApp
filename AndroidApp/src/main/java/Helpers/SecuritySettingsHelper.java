package Helpers;

import PageObject.HomePage;
import PageObject.SavedConnectionPage;
import PageObject.SecuritySettingsPage;
import PageObject.SideDrawerPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

//import sun.awt.windows.ThemeReader;

public class SecuritySettingsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    SideDrawerPage sideDrawerPage;
    HomePage homePage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    SecuritySettingsPage securitySettingsPage;
    AndroidDriver driver;
    Element element;
    Screen screen;

    public SecuritySettingsHelper(AndroidDriver driver) throws IOException {
        touchAction = new TouchAction(driver);
        screen = new Screen(driver);
        mbkPermissions = new MBKPermissions(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        securitySettingsPage= new SecuritySettingsPage(driver);
        this.driver = driver;
        element=new Element(driver);

    }


    public void setSecurityPin(String pin) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        sideDrawerPage = homePage.clickHamburgerIcon();

        screen.swipeUpMoreFromRightSide(driver);

        Thread.sleep(1000);

        if(matchSecurityPinString("Set Security Pin")) {

            mbReporter.verifyTrueWithLogging(matchSecurityPinString("Set Security Pin"), "Validating Title has change to Set Security Pin", true, false);

            securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

            mbkCommonControlsHelper.handleSecurityPin(pin);

            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getSuccessPageTitleText(), "You have successfully set your Security PIN", "Verify Success Page Title Text", false, false);
            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getSuccessPageInstructionText(), "You can always change or disable it by going to Security Settings", "Verify Success Page Instruction Text", false, false);

            securitySettingsPage.clickBackToHome();

        }else {

            securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();
            Thread.sleep(1000);

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Security PIN: Enabled']"))) {

                securitySettingsPage.hitToggle();
                mbkCommonControlsHelper.handleSecurityPin(pin);
                Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Security PIN: Disabled']"));
                securitySettingsPage.clickBackButton();
                sideDrawerPage = homePage.clickHamburgerIcon();
                screen.swipeUpMoreFromRightSide(driver);
                mbReporter.verifyEqualsWithLogging(sideDrawerPage.getSecuritySettingsTitleText(), "Set Security Pin", "Validating Title has change to Set Security Pin", true, false);
                securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();
            }

            mbkCommonControlsHelper.handleSecurityPin(pin);

            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getSuccessPageTitleText(), "You have successfully set your Security PIN", "Verify Success Page Title Text", false, false);
            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getSuccessPageInstructionText(), "You can always change or disable it by going to Security Settings", "Verify Success Page Instruction Text", false, false);

            securitySettingsPage.clickBackToHome();

        }


    }

    public void changeSecurityPin(String pin, String newPin) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        sideDrawerPage = homePage.clickHamburgerIcon();

        securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Security Settings']"));

        securitySettingsPage.clickChangeSecurityPinLabel();

        securitySettingsPage.enterCurrentSecurityPin(pin);

        Thread.sleep(1000);

        securitySettingsPage.enterNewSecurityPin(newPin);
        securitySettingsPage.confirmNewSecurityPin(newPin);

        securitySettingsPage.clickChangeSecurityPinCta();

        mbReporter.verifyEqualsWithLogging(securitySettingsPage.getChangePinSuccessPageText(), "Security PIN Changed Successfully!", "Verify Change Pin Success Page Title Text", false,false);

        securitySettingsPage.clickBackToHome();

        //Resetting Back to Normal pin , So that other test cases will not Fail.--------------------------------------------

        sideDrawerPage = homePage.clickHamburgerIcon();

        securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Security Settings']"));

        securitySettingsPage.clickChangeSecurityPinLabel();

        securitySettingsPage.enterCurrentSecurityPin(newPin);

        Thread.sleep(1000);

        securitySettingsPage.enterNewSecurityPin(pin);
        securitySettingsPage.confirmNewSecurityPin(pin);

        securitySettingsPage.clickChangeSecurityPinCta();

        mbReporter.verifyEqualsWithLogging(securitySettingsPage.getChangePinSuccessPageText(), "Security PIN Changed Successfully!", "Verify Change Pin Success Page Title Text", false,false);

        securitySettingsPage.clickBackToHome();


    }

    public void forgotSecurityPin(String pin, String mobileNumber, String flowType, String securityQuestionAnswer, String newPin) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        sideDrawerPage = homePage.clickHamburgerIcon();

        securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Security Settings']"));

        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Security PIN: Enabled']"))){
            securitySettingsPage.hitToggle();
            mbkCommonControlsHelper.handleSecurityPin(pin);
        }

        Thread.sleep(1000);
        securitySettingsPage.hitToggle();

        securitySettingsPage.clickForgetSecurityPinCta();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Verify your number via SMS']"));

        mbReporter.verifyEqualsWithLogging(securitySettingsPage.getMobileNumber(), mobileNumber, "Validate the mobile Number is same with which user has logged in.", false, false);

        if(flowType == "recoverViaMobileNumber"){

            securitySettingsPage.clickContinueToRecoverViaMobileNumber();
            //As the Test Sim is present in ios device only. Here for this case only autoread is allowed. So will apply assertions for Progress bar only

            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getProgressMessageText(), "Waiting for SMS to arrive on your number", "Device is Trying to AutoRead SMS to open Forgot Pin flow", false,false);

            Thread.sleep(6000);
            Element.waitForVisibility(driver,By.id("mkab_icon_1"));
            securitySettingsPage.clickBackButtonWithinFlow();

            securitySettingsPage.clickBackButtonWithinFlow();

            securitySettingsPage.clickBackButton();


        }else if (flowType == "recoverViaOtherOptions"){

            securitySettingsPage.clickToRecoverViaOtherOptions();

            mbReporter.verifyTrueWithLogging(getForgetPinOtherOptions(), "Verify Available options in Other options Section", false,false);

            securitySettingsPage.clickToRecoverViaSecurityQuestion();



                while(securitySettingsPage.getQuestionText() != "What is your First School Name?")
                {
                    Log.info(securitySettingsPage.getQuestionText());
                    securitySettingsPage.clickBackButtonWithinFlow();
                    securitySettingsPage.clickToRecoverViaOtherOptions();
                    securitySettingsPage.clickToRecoverViaSecurityQuestion();

                }


            securitySettingsPage.enterAnswer(securityQuestionAnswer);

            securitySettingsPage.clickContinueToSubmitAnswer();

            Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = 'Create Security PIN']"));

            securitySettingsPage.enterNewSecurityPin(newPin);
            securitySettingsPage.confirmNewSecurityPin(newPin);

            securitySettingsPage.clickContinueToConfirmPin();

            Element.waitForVisibility(driver, By.id("base_title"));

            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getSetupSuccessPageTitleText(), "Security Setup Successful", "Security Setup Successful", true, true);

            LinkedHashMap<String, String> successPageDetails = new LinkedHashMap<>();

            for (int i = 1; i <= 3; i++) {

                String snNo = "-";
                String value = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView["+i+"]")).getText();
                successPageDetails.put(snNo, value);
            }

            Log.info("------------ Options --------------");

            for (Map.Entry<String, String> e : successPageDetails.entrySet()) {
                Log.info(e.getKey(), e.getValue());
            }

            Log.info("-----------------------------------");

            securitySettingsPage.clickGoToHome();

            Thread.sleep(1500);

            sideDrawerPage = homePage.clickHamburgerIcon();

            securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();

            Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Security Settings']"));

            securitySettingsPage.clickChangeSecurityPinLabel();

            securitySettingsPage.enterCurrentSecurityPin(newPin);

            Thread.sleep(1000);

            securitySettingsPage.enterNewSecurityPin(pin);
            securitySettingsPage.confirmNewSecurityPin(pin);

            securitySettingsPage.clickChangeSecurityPinCta();

            mbReporter.verifyEqualsWithLogging(securitySettingsPage.getChangePinSuccessPageText(), "Security PIN Changed Successfully!", "Verify Change Pin Success Page Title Text", false,false);

            securitySettingsPage.clickBackToHome();


        }

    }


    public Boolean getForgetPinOtherOptions() throws InterruptedException, IOException {
        LinkedHashMap<String, String> optionDetails = new LinkedHashMap<>();
        Log.info("START", "Fetch Other Options Available to Recover Security Pin Details");

        if(Element.waitForVisibility(driver, By.id("mk_checkbox_container"))) {
            int noOfOptions = Element.findElements(driver, By.id("mk_checkbox_container")).size();
            Log.info("No Of Options - " + noOfOptions);

            // Fetch Details
            for (int i = 1; i <= noOfOptions; i++) {

                String snNo = ""+i+"";
                String optionValue = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout["+i+"]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
                optionDetails.put(snNo, optionValue);
            }

            Log.info("------------ Options --------------");

            for (Map.Entry<String, String> e : optionDetails.entrySet()) {
                Log.info(e.getKey(), e.getValue());
            }

            Log.info("-----------------------------------");

            return true;

        }else {
            return false;
        }


    }

    public Boolean matchSecurityPinString(String securityPin)  {

        Boolean answer=false;
        List<AndroidElement> textList = driver.findElements(By.xpath("//android.widget.TextView[contains(text(),'Security')]"));

        for (AndroidElement androidElement : textList) {
            Log.info(androidElement.getText());

            if (androidElement.getText() == securityPin) {
                answer=true;
            }
            }

        return answer;
    }


    }


