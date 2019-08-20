package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MutualFundPage {
    IOSDriver driver;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/viewAllFunds")
    private IOSElement viewFunds;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/mkiv_image")
    private IOSElement image_growth;


    public MutualFundPage(IOSDriver driver) throws IOException {
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
