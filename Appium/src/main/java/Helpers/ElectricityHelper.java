package Helpers;

import PageObject.ElectricityBillPage;
import PageObject.GasBillPage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ElectricityHelper {



    AndroidDriver<AndroidElement> driver;
    ElectricityBillPage electricityBillPage;
//    String checkViewDetails ="View Details";
//    String  checkLoginSignupButton="Login/Signup";

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement checkLoginSignupButton;

    public ElectricityHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewElectricityBill(String BP_Number, String operatorName) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            electricityBillPage=new ElectricityBillPage(driver);
            electricityBillPage.clickAllServicesTab();
            electricityBillPage.clickElectricityButton();
            electricityBillPage.enterBoard(operatorName);
            electricityBillPage.selectBoard();
            electricityBillPage.enterNumber(BP_Number);
            electricityBillPage.clickContinue();
            electricityBillPage.checkResultScreen(operatorName);
        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            Config.logComment("Please Login/Signup and than continue");
        }


    }

}
