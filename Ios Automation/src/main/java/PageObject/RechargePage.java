package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class RechargePage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile\"]")
    private IOSElement mobile;



    public RechargePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isMobileOptionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, mobile);
    }

    public void clickMobile() { Elements.click(driver, mobile, "Click on Mobile option");}

}
