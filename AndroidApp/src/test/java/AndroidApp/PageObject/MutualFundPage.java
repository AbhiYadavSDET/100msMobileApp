package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MutualFundPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new:id/viewAllFunds")
    private AndroidElement viewFunds;

    public MutualFundPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isViewAllFunds() throws InterruptedException{
        return Element.waitForVisibility(driver, viewFunds);
    }
}
