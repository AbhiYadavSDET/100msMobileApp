package Helpers;


import PageObject.ProfilePage;
import PageObject.SupercashPage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SupercashHelper {

    AndroidDriver<AndroidElement> driver;
    SupercashPage supercashPage;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement loginSignupButton;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Save Changes']")
    private AndroidElement saveChangesText;

    @AndroidFindBy(xpath="//*[@text='Allow']")
    private AndroidElement allowText;

    public SupercashHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void supercashView(String mobileNumber, String name, String emailId) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            supercashPage=new SupercashPage(driver);
            supercashPage.openSideDrawer();
            supercashPage.clickAccounts();
            supercashPage.clickDetails();
            supercashPage.clickStatement();
            supercashPage.checkCurrentBalanceAndEarned();
            supercashPage.checkTotalSavingsAndUsed();


        }else{
            Config.logComment("Please Login/Signup and than continue");
        }


    }

}
