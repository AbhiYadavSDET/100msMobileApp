package Helpers;

import PageObject.RechargeBillPage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class RechargeHelper {



    AndroidDriver<AndroidElement> driver;
    RechargeBillPage rechargeBillPage;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement checkLoginSignupButton;

    @AndroidFindBy(xpath="//*[@text='Operators']")
    private AndroidElement operator;

    public RechargeHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewRechargeBill(String number, String operatorName, String circle, String amount,String pin) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            rechargeBillPage=new RechargeBillPage(driver);
            rechargeBillPage.clickAllServicesTab();
            rechargeBillPage.clickMobileButton();
            rechargeBillPage.enterMobileNumber(number);
            rechargeBillPage.selectNumber();
            Elements.waitForElementToVisibleOnPage(driver,operator,2);
            if(Elements.isElementPresent(driver,operator)){
                rechargeBillPage.selectOperator(operatorName);
                rechargeBillPage.selectCircle(circle);
            }
            if(rechargeBillPage.checkResultScreen(number)) {
                rechargeBillPage.enterAmount(amount);
                rechargeBillPage.clickNextCTA();
                rechargeBillPage.clickConfirm();
                rechargeBillPage.clickPayButton();
                rechargeBillPage.enterSecurityPin(pin);
            }
        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            Config.logComment("Please Login/Signup and than continue");
        }


    }

}
