package Helpers;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.SideDrawerPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class LoginHelper {


    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    LoginPage loginPage;
    SideDrawerPage sideDrawerPage;


    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbkReporter = new MbkReporter();
    }


    public void loginViaOtp(String mobileNumber, String expectedName, String expectedEmailId, String expectedCellNumber) throws InterruptedException {


        //click on login on home page
        loginPage = homePage.clickOnLoginButton();

        // enter mobile number

        loginPage.enterMobileNumber(mobileNumber);

        //click on get otp

        Thread.sleep(1000);

        loginPage.clickGetOtp();
        //enter otp

        loginPage.enterOtp();

        Thread.sleep(20000);

        //submit otp

        loginPage.clickSubmitOtp();

        Thread.sleep(1000);

        sideDrawerPage = homePage.clickOnProfileIcon();

        Thread.sleep(2000);

        String actualName = sideDrawerPage.getUserName();
//        Log.info(actualName);
        String actualEmailId = sideDrawerPage.getEmailId();
//        Log.info(actualEmailId);
        String actualCellNumber = sideDrawerPage.getUserCellNumber();
//        Log.info(actualCellNumber);


        mbkReporter.verifyEqualsWithLogging(actualName, expectedName, "User name displayed", false);
        mbkReporter.verifyEqualsWithLogging(actualEmailId, expectedEmailId, "User Email ID displayed", false);
        mbkReporter.verifyEqualsWithLogging(actualCellNumber, expectedCellNumber, "User Cell Number Displayed", false);


        sideDrawerPage.clickDarkOverlay();

        Thread.sleep(1000);

        homePage.clickOnLogoMbk();

        Thread.sleep(1000);

    }
}
