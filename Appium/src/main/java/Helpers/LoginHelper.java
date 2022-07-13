package Helpers;

import PageObject.LoginPage;
import utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginHelper {



    AndroidDriver<AndroidElement> driver;
    LoginPage loginPage;
//    String getStartedButton ="Get Started";
//    String loginSignupButton ="Login/Signup";
//    String noneOfAboveButton="NONE OF THE ABOVE";

    @AndroidFindBy(xpath="//*[@text='Get Started']")
    private AndroidElement getStartedButton;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    @AndroidFindBy(xpath="//*[@text='NONE OF THE ABOVE']")
    private AndroidElement noneOfAboveButton;

    public LoginHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String expectedName, String expectedEmailId) throws InterruptedException {


        Thread.sleep(6000);
        if(Elements.isElementPresent(driver,getStartedButton)) {
            loginPage = new LoginPage(driver);
            Thread.sleep(2000);
            loginPage.clickGetstarted();
        }else if(Elements.isElementPresent(driver,loginSignupButton)){
            loginPage = new LoginPage(driver);
            Thread.sleep(2000);
            loginPage.clickLoginSignup();
        }
        if(Elements.isElementPresent(driver,noneOfAboveButton)) {
            loginPage.clickNoneOfAbove();
        }
        loginPage.enterMobileNum(mobileNumber);
        loginPage.clickSendOtpbutton();
//        Thread.sleep(10000);
        loginPage.clickHistoryTab();
        loginPage.checkHistoryText();
        loginPage.clickHomeTab();


    }

}
