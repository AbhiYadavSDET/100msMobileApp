package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class SideDrawerPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "drawerHeadingIcon")
    private AndroidElement profile_icon;

    @AndroidFindBy(id = "drawerHeadingName")
    private AndroidElement label_name;

    @AndroidFindBy(id = "drawerHeadingEmail")
    private AndroidElement label_email;

    @AndroidFindBy(id = "drawerHeadingNumber")
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Security Settings']")
    private AndroidElement security_settings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accounts']")
    private AndroidElement accountsPageCta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Use 2% SuperCash on all transactions']")
    private AndroidElement amexPageCta;


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

    public SecuritySettingsPage clickOnSecuritySettings() throws IOException {
        Element.selectElement(driver, security_settings, "Click on Security Settings");
        return new SecuritySettingsPage(driver);
    }

    public SavedConnectionPage clickOnMySavedConnection() throws IOException {
        Element.selectElement(driver, link_my_saved_connections, "Click on My Saved Connection");
        return new SavedConnectionPage(driver);
    }

    public WalletPage clickOnAccountsPage() throws IOException {
        Element.selectElement(driver, accountsPageCta, "Click on Accounts Page");
        return new WalletPage(driver);
    }

    public AmexPage clickOnAmexPage() throws IOException {
        Element.selectElement(driver, amexPageCta, "Click on Amex Page");
        return new AmexPage(driver);
    }


}
