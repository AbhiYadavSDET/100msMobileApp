package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OnboardingPage {

    IOSDriver<IOSElement> driver;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/tv_payments")
    private IOSElement onboarding_text;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/skip")
    private IOSElement button_skip;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/phone_number")
    private IOSElement textbox_mobile_no;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/send_otp")
    private IOSElement cta_get_otp;


    public OnboardingPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Onboarding Page*****");
    }


    public void enterMobileNo(String mobileNo) {
        Element.enterText(driver, textbox_mobile_no, mobileNo, "Enter Mobile No");
    }

    public void clickOnGetOtpCta() {
        Element.selectElement(driver, cta_get_otp, "Click on Get OTP CTA");
    }

    public HomePage clickOnSkip() throws IOException {
        Element.selectElement(driver, button_skip, "Click on Skip button");
        return new HomePage(driver);
    }

}
