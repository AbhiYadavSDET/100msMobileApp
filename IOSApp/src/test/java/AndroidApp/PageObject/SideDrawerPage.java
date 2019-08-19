package test.java.AndroidApp.PageObject;

import main.java.utils.Element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SideDrawerPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.mobikwik_new:id/drawerHeadingIcon")
    private AndroidElement profile_icon;

    @AndroidFindBy(id = "com.mobikwik_new:id/drawerHeadingName")
    private AndroidElement label_name;

    @AndroidFindBy(id = "com.mobikwik_new:id/drawerHeadingEmail")
    private AndroidElement label_email;

    @AndroidFindBy(id = "com.mobikwik_new:id/drawerHeadingNumber")
    private AndroidElement label_mobile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Update Profile']")
    private AndroidElement link_update_profile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'KYC Centres']")
    private AndroidElement link_kyc_centres;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'My Saved Connections']")
    private AndroidElement link_my_saved_connections;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Payment Reminders']")
    private AndroidElement link_payment_reminders;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Help']")
    private AndroidElement help;


    public SideDrawerPage(AndroidDriver driver) {
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
