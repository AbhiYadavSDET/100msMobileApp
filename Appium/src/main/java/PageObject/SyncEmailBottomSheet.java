package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SyncEmailBottomSheet {


    AndroidDriver driver;

    @AndroidFindBy(id = "close_button")
    private AndroidElement syncEmailBottomSheet;

    public SyncEmailBottomSheet(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickSyncEmailBottomSheet(){
        Elements.selectElement(driver, syncEmailBottomSheet, "Click close to close Sync Email bottom sheet");
    }


    public boolean checkEmailSyncBottomSheet() throws InterruptedException {
        return Elements.isElementPresent(driver, syncEmailBottomSheet);
    }
}
