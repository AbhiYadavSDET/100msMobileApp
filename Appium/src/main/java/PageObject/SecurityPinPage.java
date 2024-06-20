package PageObject;

import Logger.Log;
import Utils.Element;
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

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement backToHome;

    @AndroidFindBy(id = "title_enable_pin")
    private AndroidElement securityPinState;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Security PIN']")
    private AndroidElement securityPin;

    @AndroidFindBy(id = "tv_change_update_pin")
    private AndroidElement change_pin;

    @AndroidFindBy(id = "edit_text_mket")
    private AndroidElement current_pin_text_box;

    @AndroidFindBy(xpath = "//*/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.AutoCompleteTextView")
    private AndroidElement pin_text_box;

    @AndroidFindBy(xpath = "//*/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.AutoCompleteTextView")
    private AndroidElement confirm_pin_text_box;

    @AndroidFindBy(id = "btn_change_pin_action")
    private AndroidElement change_security_pin;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '0']")
    private AndroidElement zeroButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '1']")
    private AndroidElement oneButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '2']")
    private AndroidElement twoButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '3']")
    private AndroidElement threeButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '4']")
    private AndroidElement fourButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '5']")
    private AndroidElement fiveButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '6']")
    private AndroidElement sixButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '7']")
    private AndroidElement sevenButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '8']")
    private AndroidElement eightButton;

    @AndroidFindBy(xpath = "//*/android.widget.Button[@text = '9']")
    private AndroidElement nineButton;


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

    public Boolean isSecuritySettingsProfileVisible() throws InterruptedException {
       return Elements.isElementPresent(driver, securitySettingButton);
    }

    public void clickOnSecurityPin() {
        Elements.selectElement(driver, securityPinEnable, "click on Security Pin Enable");
    }

    public void clickOnChangePin() {
        Elements.selectElement(driver, change_pin, "click on Change Pin");
    }

    public void clickOnChangeSecurityPin() {
        Elements.selectElement(driver, change_security_pin, "click on Change Security Pin");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Title");
    }

    public String getCurrentState() throws InterruptedException {
        return Elements.getText(driver, securityPinState, "Security Pin Current State");
    }

    public void enterCurrentPin(String pin) {
        Elements.enterToElement(driver, current_pin_text_box, pin, "Current Pin");
    }

    public void enterNewPin(String pin) {
        Elements.enterToElement(driver, pin_text_box, pin, "New Pin");
    }

    public void enterConfirmNewPin(String pin) {
        Elements.enterToElement(driver, confirm_pin_text_box, pin, "Confirm New Pin");
    }

    public void enterSecurityPin(){
       enterSecurityPin("121212");
    }

    public void enterSecurityPin(String pin){
        for(int i = 0 ; i < pin.length() ; i++){
            char c = pin.charAt(i);
            switch (c) {
                case '0':
                    Elements.selectElement(driver, zeroButton, "click on zero");
                    break;

                case '1':
                    Elements.selectElement(driver, oneButton, "click on one");
                    break;

                case '2':
                    Elements.selectElement(driver, twoButton, "click on two");
                    break;

                case '3':
                    Elements.selectElement(driver, threeButton, "click on three");
                    break;

                case '4':
                    Elements.selectElement(driver, fourButton, "click on four");
                    break;

                case '5':
                    Elements.selectElement(driver, fiveButton, "click on five");
                    break;

                case '6':
                    Elements.selectElement(driver, sixButton, "click on six");
                    break;

                case '7':
                    Elements.selectElement(driver, sevenButton, "click on seven");
                    break;

                case '8':
                    Elements.selectElement(driver, eightButton, "click on eight");
                    break;

                case '9':
                    Elements.selectElement(driver, nineButton, "click on nine");
                    break;
            }
        }
    }

    public boolean checkSecurityPinPage() throws InterruptedException {
        return Elements.isElementPresent(driver, securityPin);
    }

    public void navigateBackToProfile() throws InterruptedException{
        Elements.selectElement(driver, backToHome, "Navigating Back to Profile Dashboard");
    }

}
