package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SecurityPinPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "vfLogo")
    private AndroidElement profileSectionButton;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Security']")
    private AndroidElement securitySettingButton;

    @AndroidFindBy(id = "switch_enable_pin")
    private AndroidElement securityPinEnable;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '1']")
    private AndroidElement oneButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '2']")
    private AndroidElement twoButton;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement backToHome;

    @AndroidFindBy(id = "title_enable_pin")
    private AndroidElement securityPinState;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Security PIN']")
    private AndroidElement securityPin;




    public SecurityPinPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickOnProfile() {
        Elements.selectElement(driver, profileSectionButton, "click on profile icon");
    }

    public void clickOnsSecuritySettings() {
        Elements.selectElement(driver, securitySettingButton, "click on Security Settings");
    }

    public void clickOnSecurityPin() {
        Elements.selectElement(driver, securityPinEnable, "click on Security Pin Enable");
    }


    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getCurrentState() throws InterruptedException {
        return Elements.getText(driver, securityPinState, "Security Pin Current State");
    }

    public void enterSecurityPin(){
       for(int i = 0 ; i < 3 ; i++){
           Elements.selectElement(driver, oneButton, "click on one");
           Elements.selectElement(driver, twoButton, "click on two");
       }
    }

    public boolean checkSecurityPinPage() throws InterruptedException {
        return Elements.isElementPresent(driver, securityPin);
    }

}
