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

    @FindBy(xpath = "//div[text()='Mobile Number (+91)']//following-sibling::div")
    private WebElement getNo;

    @FindBy(xpath = "//span[text()='Make Payment']")
    private WebElement makePayment;

    String successMsg = "//mbk-recharge-status//p[text()='Recharge Successful']";

    public MobileRechargePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, mobileNumber);
        Config.logComment("*****On money Transfer Page*****");
    }

    String confirmRecharge = "//form/p[text()='Confirm Recharge ']";

    public void enterMobileNumber(String mobileNo){
        Element.enterText(driver, mobileNumber, mobileNo, "enter mobile no");
    }

    public void selectPrepaid(){
        Element.click(driver, prepaid, "Select prepaid");
    }

    public void selectPostpaid(){
        Element.click(driver, postpaid, "Select postpaid");
    }

    public void enterOperator(String op){

        Element.enterText(driver, operator, op, "enter operator");
        Element.pressEnter(driver);
    }

    public void enterCircle(String circleStr){
        Element.enterText(driver, circle, circleStr, "enter circle");
        Element.pressEnter(driver);
    }

    public void enterAmount(String amt){
        Element.enterText(driver, amount, amt, "enter amount");
    }

    public void clickGo(){
        Element.click(driver, ctaGo, "Click on Go");
    }

    public String getNo(){
        return Element.getText(driver, getNo, "Get mobile on bill");
    }

    public void clickMakePayment(){
        Element.click(driver, makePayment, "Click on Make Payment");
    }

    public boolean ifConfirmRechargePresent(){
        try {
            return Element.isElementPresent(driver, By.xpath(confirmRecharge));
        }catch (InterruptedException e){
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public boolean ifSuccessTextPresent(){
        try {
            return Element.isElementPresent(driver, By.xpath(successMsg));
        }catch (InterruptedException e){
            Log.info(e.getMessage().toString());
        }
        return false;
    }

}
