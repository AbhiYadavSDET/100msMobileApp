package Helpers;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.SideDrawerPage;
import Utils.Element;
import Utils.Log;
import Utils.MbkReporter;
import Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Scanner;

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


    public void loginViaOtp(String mobileNumber, String expectedName, String expectedEmailId, String expectedCellNumber) throws InterruptedException, IOException {
        //click on login on home page
        if (Element.isElementPresent(driver, By.xpath("//a[text() = 'Login']"))) {

            Log.info("User is Logged out, Proceed to Login In");

            loginPage = homePage.clickOnLoginButton();

            // enter mobile number

            loginPage.enterMobileNumber(mobileNumber);

            //click on get otp
            loginPage.clickGetOtp();

            //enter otp
            loginPage.enterOtp();

            // Handle the OTP wrt headLess Flag
            if (TestBase.headLess.equalsIgnoreCase("true")) {
                Scanner sc = new Scanner(System.in);
                Log.info("Enter the OTP");

                String otp = sc.nextLine();
                Log.info("OTP : " + otp);
            }

            // Wait for Add Money button
            loginPage.waitForAddMoneyButton();

            sideDrawerPage = homePage.clickOnProfileIcon();

            Thread.sleep(2000);
            String actualName = sideDrawerPage.getUserName();
            MbkReporter.verifyEqualsWithLogging(actualName, expectedName, "Verify : User name displayed", false);

            String actualEmailId = sideDrawerPage.getEmailId();
            MbkReporter.verifyEqualsWithLogging(actualEmailId, expectedEmailId, "Verify : User Email ID displayed", false);

            String actualCellNumber = sideDrawerPage.getUserCellNumber();
            MbkReporter.verifyEqualsWithLogging(actualCellNumber, expectedCellNumber, "Verify : User Cell Number Displayed", false);


            sideDrawerPage.clickHomeCtaInSideDrawer();

            homePage.clickOnLogoMbk();

        } else {
            Log.info("User is already Logged In");

        }
    }
}
