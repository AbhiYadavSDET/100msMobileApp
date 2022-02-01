package Helpers;

import PageObject.GasBillPage;
import PageObject.LoginPage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GasHelper {



    AndroidDriver<AndroidElement> driver;
    GasBillPage gasBillPage;
//    String checkViewDetails ="View Details";
//    String  checkLoginSignupButton="Login/Signup";

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement checkLoginSignupButton;

    public GasHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewGasBill(String BP_Number, String operatorName) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            gasBillPage=new GasBillPage(driver);
            gasBillPage.clickAllServicesTab();
            gasBillPage.clickMoreButton();
            gasBillPage.clickPipedGasButton();
            gasBillPage.enterOperator(operatorName);
            gasBillPage.selectOperator();
            gasBillPage.enterBPNumber(BP_Number);
            gasBillPage.clickContinue();
            gasBillPage.checkResultScreen(operatorName);
        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            Config.logComment("Please Login/Signup and than continue");
        }


    }

}
