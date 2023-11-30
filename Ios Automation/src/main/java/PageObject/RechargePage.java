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

    @iOSXCUITFindBy(id = "₹739")
    private IOSElement amountOnPaymentScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pay ₹739\"]")
    private IOSElement payButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Postpaid\"]")
    private IOSElement postpaid;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter name or Mobile no.\"]")
    private IOSElement enterNameOrMobileNo;

    @iOSXCUITFindBy(id = "OK")
    private IOSElement contactsPermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement selectNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private IOSElement postpaidRechargeAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueButton;



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

    public String getAmountOnPaymentScreen() throws InterruptedException {
        return Elements.getText(driver, amountOnPaymentScreen, "Amount on payment screen");
    }

    public void clickOnPayButton() { Elements.click(driver, payButton,"Click on Pay button"); }

    public void clickPostpaid() { Elements.click(driver, postpaid,"Click on Postpaid"); }

    public void clickEnterNameOrMobileNo() { Elements.click(driver, enterNameOrMobileNo,"Click on Enter Name or Mobile no."); }

    public void clickAllowContactPermission() { Elements.click(driver, contactsPermission,"Click OK on contact permission popup"); }

    public void enterPostpaidNumber(String number) {
         Elements.enterToElement(driver, enterNameOrMobileNo,number,"Click on Enter Name or Mobile no.");
    }

    public void selectNumber() { Elements.click(driver, selectNumber, "Click to Select postpaid number");}

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, postpaidRechargeAmount, amount,"Click on Enter Name or Mobile no.");
    }

    public void clickOnContinueButton() { Elements.click(driver, continueButton, "Click on Continue Button");}
}
