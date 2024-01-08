package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class RechargePage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile\"]")
    private IOSElement mobile;

    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[2]/XCUIElementTypeButton[2]")
    private IOSElement myNumber;

    @iOSXCUITFindBy(id = "plan_search")
    private IOSElement planSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[2]")
    private IOSElement selectPlan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    private IOSElement amountOnPaymentScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private IOSElement payButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Postpaid\"]")
    private IOSElement postpaid;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement enterNameOrMobileNo;

//    @iOSXCUITFindBy(id = "OK")
//    private IOSElement contactsPermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    private IOSElement searchContact;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement selectNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private IOSElement postpaidAmountField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Successful\"]")
    private IOSElement title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement amountOnSuccessScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"M\"]")
    private IOSElement feedbackPopup;

    @iOSXCUITFindBy(id = "Credit Card Payment")
    private IOSElement creditCardPayment;


    public RechargePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isMobileOptionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, mobile);
    }

    public void clickMobile() { Elements.click(driver, mobile, "Click on Mobile option");   }

    public void selectMyNumber() { Elements.click(driver, myNumber, "Click on My Number");   }

    public void clickPlanSearch() { Elements.click(driver, planSearch, "Click on Search plan"); }

    public void enterPlanAmount(String amount) { Elements.enterToElement(driver, planSearch, amount , "Enter amount to search plan");   }

    public void selectPlan() { Elements.click(driver, selectPlan, "Tap to Select Plan"); }

    public String getAmountOnPrepaidPaymentScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnPaymentScreen, "Amount on payment screen");
    }

    public void clickOnPayButton() { Elements.click(driver, payButton,"Click on Pay button"); }

    public void clickPostpaid() { Elements.click(driver, postpaid,"Click on Postpaid"); }

    public void clickEnterNameOrMobileNo() { Elements.click(driver, enterNameOrMobileNo,"Click on Enter Name or Mobile no."); }

    public void enterPostpaidNumber(String number) {
         Elements.enterToElement(driver, searchContact, number,"Click on Enter Name or Mobile no.");
    }

    public void selectNumber() { Elements.click(driver, selectNumber, "Click to Select postpaid number");}

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, postpaidAmountField, amount,"Click on Enter Name or Mobile no.");
    }

    public void clickOnContinueButton() { Elements.click(driver, continueButton, "Click on Continue Button");}

    public String getAmountOnPostpaidPaymentScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnPaymentScreen, "Amount on payment screen");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title,"Title on success screen");
    }

    public String getAmountOnSuccessScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnSuccessScreen, "Amount on Success screen");
    }

    public void clickBackButton() { Elements.click(driver, backButton,"Click on back button"); }

    public void closeFeedbackPopup() { Elements.click(driver, feedbackPopup, "Click to close feedback popup");}

    public void clickCreditCardPayment() { Elements.click(driver, creditCardPayment,"Click on Credit Card payment");}



}
