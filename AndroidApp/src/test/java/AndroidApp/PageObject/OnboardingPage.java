package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OnboardingPage {

    AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(id = "com.mobikwik_new:id/tv_payments")
    private AndroidElement onboarding_text;

    @AndroidFindBy(id = "com.mobikwik_new:id/skip")
    private AndroidElement button_skip;

    @AndroidFindBy(id = "com.mobikwik_new:id/phone_number")
    private AndroidElement textbox_mobile_no;

    @AndroidFindBy(id = "com.mobikwik_new:id/send_otp")
    private AndroidElement cta_get_otp;


    public OnboardingPage(AndroidDriver driver) {
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
