package Helpers;

import PageObject.LoginPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelper{

    IOSDriver<IOSElement> driver;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;

    public LoginHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {

        // Enter Mobile Number
        loginPage.enterMobileNumber(mobileNumber);

        // Click On Continue
        loginPage.clickContinue();

        // Enter Otp
        loginPage.enterOtp(otp);

        mbkCommonControlHelper.handleHomePageLanding();
    }
}
