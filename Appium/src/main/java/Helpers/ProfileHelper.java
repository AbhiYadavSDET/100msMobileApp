package Helpers;


import PageObject.HomePage;
import PageObject.ProfilePage;
import PageObject.SideDrawerPage;
import Utils.Config;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class ProfileHelper {

    AndroidDriver<AndroidElement> driver;
    ProfilePage profilePage;
    SideDrawerPage sideDrawerPage;
    MBReporter mbReporter;
    HomePage homePage;
    Screen screen;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Save Changes']")
    private AndroidElement saveChangesText;

    @AndroidFindBy(xpath="//*[@text='Allow']")
    private AndroidElement allowText;

    public ProfileHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
    //    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        profilePage = new ProfilePage(driver);
        screen = new Screen(driver);
        sideDrawerPage = new SideDrawerPage(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver);
    }

    public void profileView(String expMobileNumber, String expName, String expEmailId, String expInteropID) throws InterruptedException, IOException {

        /*
            profilePage.checkSaveChangesButton();
            profilePage.enterName("Test");
            profilePage.clickBackButton();
            if(Elements.isElementPresent(driver,saveChangesText)) {
                profilePage.checkDetailsOnBackClicked();
                profilePage.clickNoThanksButton();
            }
            homePage.openSideDrawr();
            sideDrawerPage.clickProfile();

            //Change profile
            profilePage.clickProfileIamge();
            profilePage.clickCamera();
            if(Elements.isElementPresent(driver,allowText)){
                profilePage.clickAllow();
            }
            profilePage.takePicture();
            profilePage.clickOk();
            profilePage.clickNext();
            profilePage.waitForProfileSection();
            profilePage.clickProfileIamge();
            profilePage.clickRemove();
            profilePage.waitForProfileSection();
            profilePage.clickProfileIamge();
            profilePage.clickGallery();
            if(Elements.isElementPresent(driver,allowText)){
                profilePage.clickAllow();
            }
            profilePage.selectImageOrComeBack();
            profilePage.clickNext();
            profilePage.waitForProfileSection();


*/
            HomePage homePage = new HomePage(driver);
            homePage.clickWalletBalanceDropDown();

            Thread.sleep(2000);

            String actualName = profilePage.getName();
            String actualEmailId = profilePage.getEmailId();
            String actualMobileNumber = profilePage.getMobileNumber();
            String actualInteropID = profilePage.getInteropID();

            mbReporter.verifyEqualsWithLogging(actualName, expName, "Verify Profile Name", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualEmailId, expEmailId, "Verify Email ID", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualMobileNumber, expMobileNumber, "Verify Mobile Number", false, false, true);
            mbReporter.verifyEqualsWithLogging(actualInteropID, expInteropID, "Verify Interop ID", false, false, true);

            screen.swipeUpLess(driver);



    }

}
