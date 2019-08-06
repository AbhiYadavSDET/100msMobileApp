package PageObject.Recharge;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Mobile Number (+91)']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//div[@class='mat-radio-label-content'][text()='Prepaid']")
    private WebElement prepaid;

    @FindBy(xpath = "//div[@class='mat-radio-label-content'][text()='Postpaid']")
    private WebElement postpaid;

    @FindBy(xpath = "//label[@title='Operator']//following::input[@role='combobox'][1]")
    private WebElement operator;

    @FindBy(xpath = "//label[@title='Operator']//following::input[@role='combobox'][2]")
    private WebElement circle;

    @FindBy(xpath = "//input[@placeholder='Amount']")
    private WebElement amount;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    @FindBy(xpath = " //div[text()='Mobile Number (+91)']//following-sibling::div")
    private WebElement getPrepaidNo;

    @FindBy(xpath = "(//mbk-view-payment//p)[2]")
    private WebElement getNo;

    @FindBy(xpath = "//span[text()='Make Payment']")
    private WebElement makePayment;

    @FindBy(xpath = "(//mbk-view-payment//p)[1]")
    private WebElement successMssg;

    String successMsg = "//mbk-recharge-status//p[text()='Recharge Successful']";

    String confirmRecharge = "//form/p[text()='Confirm Recharge ']";

    String successPostMssg = "No Bills Found";

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button']")
    private WebElement crossButton;

    public MobileRechargePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, mobileNumber);
        Config.logComment("*****On mobile Recharge Page*****");
    }


    public void enterMobileNumber(String mobileNo) {
        Element.enterText(driver, mobileNumber, mobileNo, "mobile no");
    }

    public void selectPrepaid() {
        Element.click(driver, prepaid, "prepaid");
    }

    public void selectPostpaid() {
        Element.click(driver, postpaid, "postpaid");
    }

    public void enterOperator(String op) {

        Element.enterText(driver, operator, op, "operator");
        Element.pressEnter(driver);
    }

    public void enterCircle(String circleStr) {
        Element.enterText(driver, circle, circleStr, "circle");
        Element.pressEnter(driver);
    }

    public void enterAmount(String amt) {
        Element.enterText(driver, amount, amt, "amount");
    }

    public void clickGo() {
        Element.click(driver, ctaGo, "Go");
    }

    public String getNo() {
        return Element.getText(driver, getNo, "mobile on bill");
    }

    public void waitForWindowToOpen() {
        Element.waitForVisibility(driver, getNo, "View Bill Window");
    }

    public String getPrepaidNo() {
        return Element.getText(driver, getPrepaidNo, "mobile on bill");
    }

    public void clickMakePayment() {
        Element.click(driver, makePayment, "Make Payment");
    }

    public boolean ifConfirmRechargePresent() {
        try {
            return Element.isElementPresent(driver, By.xpath(confirmRecharge));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public boolean ifSuccessTextPresent() {
        try {
            return Element.isElementPresent(driver, By.xpath(successMsg));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public boolean isPostSuccess() {
        return Element.getText(driver, successMssg, "compare success mssg").equalsIgnoreCase(successPostMssg);
    }

    public void closeBill() {
        Element.selectElement(driver, crossButton, "cross button");
    }


}
