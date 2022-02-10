package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class AllServicesPage {

    AndroidDriver driver;

    @AndroidFindBy (xpath="//android.widget.TextView[@text='Split Bills']")
    private AndroidElement split_bill_icon;

    @AndroidFindBy (xpath="//android.widget.TextView[@text='Pay Rent']")
    private AndroidElement pay_rent_icon;


    public AllServicesPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****All Services Page*****");
    }

    public void clickOnSplitBill() throws InterruptedException{
        Element.selectElement(driver, split_bill_icon, "Click on Split Bill Button");

    }

    public void clickOnPayRent() throws InterruptedException{
        Element.selectElement(driver, pay_rent_icon, "Click on Pay Rent Button");
    }
}


