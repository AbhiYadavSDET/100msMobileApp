package Helpers;


import PageObject.ProfilePage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfileHelper {

    AndroidDriver<AndroidElement> driver;
    ProfilePage profilePage;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Save Changes']")
    private AndroidElement saveChangesText;

    @AndroidFindBy(xpath="//*[@text='Allow']")
    private AndroidElement allowText;

    public ProfileHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void profileView(String mobileNumber, String name, String emailId) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            profilePage=new ProfilePage(driver);
            profilePage.openSideDrawer();
            profilePage.clickProfile();
            if(Elements.isElementPresent(driver,allowText)){
                profilePage.clickAllow();
            }
            profilePage.checkNumber(mobileNumber);
            profilePage.checkSaveChangesButton();
            profilePage.checkNameAndEmail(name,emailId);
            profilePage.enterName(name);
            profilePage.enterEmailId(emailId);
            profilePage.checkSaveChangesButton();
            profilePage.enterName("Test");
            profilePage.clickBackButton();
            if(Elements.isElementPresent(driver,saveChangesText)) {
                profilePage.checkDetailsOnBackClicked();
                profilePage.clickNoThanksButton();
            }
            profilePage.openSideDrawer();
            profilePage.clickProfile();

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

        }else{
            Config.logComment("Please Login/Signup and than continue");
        }


    }

}
