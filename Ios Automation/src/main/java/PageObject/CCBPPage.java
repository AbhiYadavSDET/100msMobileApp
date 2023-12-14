package PageObject;

import Utils.Elements;
import Utils.Screen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

public class CCBPPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]")
    private IOSElement ccbpHomeBottomSheet;

    @iOSXCUITFindBy(id = "Timely reminders & Insights of your spends")
    private IOSElement emailAccessBottomSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private IOSElement cross;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private IOSElement addNewCreditCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private IOSElement enterCreditCardNumber;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueCTA;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    private IOSElement enterAmountManually;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]//XCUIElementTypeStaticText[2]")
    private IOSElement amountOnPaymentScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name, 'Pay')]")
    private IOSElement payButton;

    public CCBPPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isCCBPHomeBottomSheetShown() throws InterruptedException {
        return Elements.isElementPresent(driver, ccbpHomeBottomSheet);
    }

    public boolean isEmailAccessBottomSheetShown() throws  InterruptedException {
        return Elements.isElementPresent(driver, emailAccessBottomSheet);
    }

    public void closeEmailAccessBottomSheet() { Elements.click(driver, cross,"Click cross to close email access bottom sheet"); }

    public boolean isAddNewCreditCardShown() throws InterruptedException {
        return Elements.isElementPresent(driver, addNewCreditCard);
    }

    public void clickAddNewCreditCard() { Elements.click(driver, addNewCreditCard, "Click on Add new Credit card"); }

    public void clickEnterCreditCardNumber() { Elements.click(driver, enterCreditCardNumber, "Click on Enter credit card number"); }

    public void clickZeroButton() {
        Elements.selectElement(driver, zeroButton, "Click 0");
    }

    public void clickOneButton() {
        Elements.selectElement(driver, oneButton, "Click 1");
    }

    public void clickTwoButton() {
        Elements.selectElement(driver, twoButton, "Click 2");
    }

    public void clickThreeButton() {
        Elements.selectElement(driver, threeButton, "Click 3");
    }

    public void clickFourButton(){
        Elements.selectElement(driver, fourButton, "Click 4");
    }

    public void clickFiveButton() {
        Elements.selectElement(driver, fiveButton, "Click 5");
    }

    public void clickSixButton() {
        Elements.selectElement(driver, sixButton, "Click 6");
    }

    public void clickSevenButton() {
        Elements.selectElement(driver, sevenButton, "Click 7");
    }

    public void clickEightButton() {
        Elements.selectElement(driver, eightButton, "Click 8");
    }

    public void clickNineButton() {
        Elements.selectElement(driver, nineButton, "Click 9");
    }

    //Enter credit card number/amount
    public void enterCreditCardNumber(String number){


        for(int i = 0 ; i < number.length() ; i++) {
            char c = number.charAt(i);

            switch (c) {
                case '2':
                    clickTwoButton();
                    break;

                case '5':
                    clickFiveButton();
                    break;

                case '8':
                    clickEightButton();
                    break;

                case '0':
                    clickZeroButton();
                    break;

                case '1':
                    clickOneButton();
                    break;

                case '4':
                    clickFourButton();
                    break;

                case '7':
                    clickSevenButton();
                    break;

                case '3':
                    clickThreeButton();
                    break;

                case '6':
                    clickSixButton();
                    break;

                case '9':
                    clickNineButton();
                    break;

            }
        }
    }

    public void clickContinueCTA() { Elements.click(driver, continueCTA, "Click on Continue button");   }

    public void clickEnterAmountManually() { Elements.click(driver, enterAmountManually, "Click on Enter Amount Manually"); }

    public String getAmountOnPaymentScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnPaymentScreen);
    }

    public void clickOnPayButton() { Elements.click(driver, payButton,"Click on Pay");  }
}
