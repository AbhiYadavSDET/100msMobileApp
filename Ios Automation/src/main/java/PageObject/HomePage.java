package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Offers")
    private IOSElement offers;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"M\"]")
    private IOSElement flowting_widgit;


    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isFlowtingWidgitPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, flowting_widgit);
    }

    public void closeFlowtingWidgit() {
        Elements.click(driver, flowting_widgit ,"Flowting Widgit");
    }

    public void clickOnOffers() {
        Elements.click(driver, offers,"Offers");
    }
}
