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
    private IOSElement floating_widgit;

    public HomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isFloatingWidgitPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, floating_widgit);
    }

    public void closeFloatingWidgit() {
        Elements.click(driver, floating_widgit ,"Flowting Widgit");
    }

    public void clickOnOffers() {
        Elements.click(driver, offers,"Offers");
    }
}
