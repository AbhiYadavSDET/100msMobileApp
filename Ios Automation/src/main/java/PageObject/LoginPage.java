package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Enter mobile number']")
    private IOSElement mobile_number;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue\"]")
    private IOSElement continue_button;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private IOSElement otp;


    public LoginPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterMobileNumber(String mobileNumber) {
        Elements.enterToElement(driver, mobile_number, mobileNumber, "Enter mobile number");
    }

    public void clickContinue() {
        Elements.click(driver, continue_button ,"Enter continue button");
    }

    public void enterOtp(String otpNum) {
        Elements.enterToElement(driver, otp, otpNum, "Enter Otp");
    }

}
