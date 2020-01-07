package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class MutualFundPage {
    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/viewAllFunds")
    private AndroidElement viewFunds;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/mkiv_image")
    private AndroidElement image_growth;


    public MutualFundPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isViewAllFunds() throws InterruptedException {
        return (Element.isElementPresent(driver, (By.id("viewAllFunds"))));
    }

    public boolean isVisibleGrowthImage() throws InterruptedException {
        return (Element.isElementPresent(driver, By.id("mkiv_image")));
    }
}
