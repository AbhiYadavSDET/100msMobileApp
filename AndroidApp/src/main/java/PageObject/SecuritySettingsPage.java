package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

public class SecuritySettingsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "mkab_icon_5")
    private AndroidElement security_settings_option;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister UPI Account']")
    private AndroidElement deregister_account;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister Account']")
    private AndroidElement deregister_account_popup;

    @AndroidFindBy(id = "horizontal_button_1")
    private AndroidElement yes_deregister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister successful']")
    private AndroidElement deregister_succesfull;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement cta_ok;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_button;


    public SecuritySettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Side Drawer Page*****");
    }


    public void ClickSecurityOptions() throws InterruptedException {
        Element.selectElement(driver, security_settings_option, "Select options");
    }

    public void ClickDeregisterFromOptions() throws InterruptedException {
        Element.selectElement(driver, deregister_account, "Select Deregister from Options");
    }

    public void ClickYesDeregisterAccount() throws InterruptedException {
        Element.selectElement(driver, yes_deregister, "Select Yes from Options");
    }

    public void ClickOk() throws InterruptedException {
        Element.selectElement(driver, cta_ok, "Select Ok");
    }

    public HomePage clickBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, "Navigate back to Home Page");
        return new HomePage(driver);
    }

}
