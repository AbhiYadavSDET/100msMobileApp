package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SideDrawerPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/drawerHeadingIcon")
    private IOSElement profile_icon;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/drawerHeadingName")
    private IOSElement label_name;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/drawerHeadingEmail")
    private IOSElement label_email;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/drawerHeadingNumber")
    private IOSElement label_mobile;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Update Profile']")
    private IOSElement link_update_profile;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'KYC Centres']")
    private IOSElement link_kyc_centres;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'My Saved Connections']")
    private IOSElement link_my_saved_connections;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Payment Reminders']")
    private IOSElement link_payment_reminders;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Help']")
    private IOSElement help;


    public SideDrawerPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Side Drawer Page*****");
    }

    public String getName() {
        return label_name.getText();
    }

    public String getEmail() {
        return label_email.getText();
    }

    public String getMobileNo() {
        return label_mobile.getText();
    }

    public HelpPage clickOnHelp() throws IOException {
        Element.selectElement(driver, help, "Click on Help");
        return new HelpPage(driver);
    }
}
