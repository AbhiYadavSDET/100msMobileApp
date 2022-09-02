package PageObject.Recharge;

import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DthPage {
    WebDriver driver;

    public DthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='cn']")
    private WebElement bpNo;

    @FindBy(xpath = "//input[@id='amt']")
    private WebElement amount;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    @FindBy(xpath = "//span[text()='Make Payment']")
    private WebElement makePayment;

    @FindBy(xpath = "//div[text()='Mobile No./Subscriber No.']//following-sibling::div")
    private WebElement getCNo;

    @FindBy(xpath = "//div[text()='Amount']//following-sibling::div")
    private WebElement getAmt;

    @FindBy(xpath = "(//input[@role='combobox'])[1]")
    private WebElement operator;

    String text = "//div//p[text()='Minimum recharge amount should be Rs.20']";

    public void enterBpNo(String bp) throws InterruptedException {
//        Element.click(driver,bpNo,"click ");
        Thread.sleep(1000);
        Element.enterText(driver, bpNo, bp, "telephone no");
    }

    public void enterOperator(String opt) {
        Element.click(driver,operator,"click on operator");
        Element.enterText(driver, operator, opt, "operator");
        Element.pressEnter(driver);
    }

    public void enterAmount(String amt) {
        Element.enterText(driver, amount, amt, "enter amount");
    }

    public void clickGo() {
        Element.click(driver, ctaGo, "Go");
    }

    public void clickMakePayment() {
        Element.click(driver, makePayment, "Make Payment");
    }

    public String getCNo() {
        return Element.getText(driver, getCNo, "operator on bill");
    }

    public String getAmt() {
        return Element.getText(driver, getAmt, "amount on bill").replace("₹ ", "");
    }

    public boolean ifTextPresent() {
        try {
            return Element.isElementPresent(driver, By.xpath(text));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public void waitForMakePaymentScreen() {
        Element.waitForVisibility(driver, getCNo, "Make Payment Screen");
    }
}
