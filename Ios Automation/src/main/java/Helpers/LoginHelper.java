package Helpers;

import PageObject.LoginPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelper {

    IOSDriver<IOSElement> driver;
    LoginPage loginPage;

    public LoginHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {
        loginPage.enterMobileNumber(mobileNumber);
        loginPage.clickContinue();
        loginPage.enterOtp(otp);
        Thread.sleep(3000);
    }
}
