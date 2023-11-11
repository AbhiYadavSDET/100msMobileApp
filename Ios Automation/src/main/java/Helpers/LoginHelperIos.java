package Helpers;

import PageObject.LoginPageIos;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelperIos {

    IOSDriver<IOSElement> driver;
    LoginPageIos loginPageIos;

    public LoginHelperIos(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPageIos = new LoginPageIos(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {
        loginPageIos.enterMobileNumber(mobileNumber);
        loginPageIos.clickContinue();
        loginPageIos.enterOtp(otp);
        Thread.sleep(3000);
    }
}
