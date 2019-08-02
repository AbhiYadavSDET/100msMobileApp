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

    @FindBy(id = "cn")
    private WebElement bpNo;

    @FindBy(id = "amt")
    private WebElement amount;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    @FindBy(xpath = "//span[text()='Make Payment']")
    private WebElement makePayment;

    @FindBy(xpath = "//div[text()='Customer Id']//following-sibling::div")
    private WebElement getCNo;

    @FindBy(xpath = "//div[text()='Amount']//following-sibling::div")
    private WebElement getAmt;

    String text = "//p[text()='Invalid Denomination']";

    public void enterBpNo(String bp){
        Element.enterText(driver, bpNo, bp, "Enter telephone no");
    }

    public void enterAmount(String amt){
        Element.enterText(driver, amount, amt, "enter circle");
    }

    public void clickGo(){
        Element.click(driver, ctaGo, "Click on Go");
    }

    public void clickMakePayment(){
        Element.click(driver, makePayment, "Click on Make Payment");
    }

    public String getCNo(){
        return Element.getText(driver, getCNo, "Get operator on bill");
    }

    public String getAmt(){
        return Element.getText(driver, getCNo, "Get operator on bill").replace("₹ ", "");
    }

    public boolean ifTextPresent(){
        try {
            return Element.isElementPresent(driver, By.xpath(text));
        }catch (InterruptedException e){
            Log.info(e.getMessage().toString());
        }
        return false;
    }
}
