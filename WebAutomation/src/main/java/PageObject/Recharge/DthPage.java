package PageObject.Recharge;

import Utils.Element;
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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement ctaGo;

    @FindBy(xpath = "//span[text()='Make Payment']")
    private WebElement makePayment;


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


}
