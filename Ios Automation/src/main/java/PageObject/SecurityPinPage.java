package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityPinPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Security")
    private IOSElement securitySettings;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Security')]")
    private IOSElement title;


    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeSwitch[`value == \"1\"`]")
    private IOSElement securityPinState;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"0\"]")
    private IOSElement zeroButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"1\"]")
    private IOSElement oneButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"2\"]")
    private IOSElement twoButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"3\"]")
    private IOSElement threeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"4\"]")
    private IOSElement fourButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"5\"]")
    private IOSElement fiveButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"6\"]")
    private IOSElement sixButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"7\"]")
    private IOSElement sevenButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"8\"]")
    private IOSElement eightButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"9\"]")
    private IOSElement nineButton;



    public SecurityPinPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnSecuritySettings() { Elements.click(driver, securitySettings,"Security Settings");   }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title);
    }

    public boolean isSecurityPinPageShown() throws InterruptedException {
        return Elements.isElementPresent(driver, title);
    }

    public String getCurrentState() throws InterruptedException{
        return Elements.getText(driver, securityPinState);
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


}

