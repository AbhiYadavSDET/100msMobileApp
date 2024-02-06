package Helpers;

import PageObject.LoginPage;
import PageObject.PermissionPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginHelper{

    IOSDriver<IOSElement> driver;
    LoginPage loginPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    PermissionPage permissionPage;

    public LoginHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        permissionPage = new PermissionPage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void loginViaOtp(String mobileNumber, String otp) throws InterruptedException, IOException {

        if(permissionPage.isPermissionPopUpPresent()){

            permissionPage.clickOnAllow();
        }

        // Enter Mobile Number
        loginPage.enterMobileNumber(mobileNumber);

        // Click On Continue
        loginPage.clickContinue();

        // Enter Otp
        loginPage.enterOtp(otp);

        //Handling of KYC Screen for NON-KYC User
//        if(loginPage.isKycScreenPresent()){
//
//            // Click On Continue
//            loginPage.clickContinue();
//
//            //Allow location permission
//            if(permissionPage.isEnablePermissionPopupPresent()) { permissionPage.clickAllowWhileUsingApp();   }
//
//            //Allow contacts permission
//            if(permissionPage.isPermissionPopUpPresent())   { permissionPage.clickOnAllow();  }
//
//            //Click Skip
//            loginPage.clickSkip();
//
//            //Click i don't want benefits
//            loginPage.clickToCloseKycScreen();
//
//
//        }

        // Remove popup on home page
        mbkCommonControlHelper.handleHomePageLanding();
    }
}
