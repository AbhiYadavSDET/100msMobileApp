package PageObject.Recharge;

import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasPage {
    WebDriver driver;

    public GasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "(//input[@role='combobox'])[1]")
    private WebElement operator;

    @FindBy(id = "cn")
    private WebElement bpNo;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[2]")
    private WebElement cNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[3]")
    private WebElement op;

    String billText = "//div[@class='col-md-9']/p[1]";

    public void selectOperator(String op){
        Element.enterText(driver, operator, op, "Select MTNL Delhi");
        Element.pressEnter(driver);
    }

    public void enterBpNo(String bp){
        Element.enterText(driver, bpNo, bp, "Enter telephone no");
    }

    public void clickGo(){
        Element.click(driver, ctaGo, "Click on Go");
    }

    public String getOperator(){
        return Element.getText(driver, op, "Get operator on bill");
    }

    public String getCNo(){
        return Element.getText(driver, cNo, "Get Cno on bill");
    }

    public boolean ifTextPresent(){
        try {
            return Element.isElementPresent(driver, By.xpath(billText));
        }catch (InterruptedException e){
            Log.info(e.getMessage().toString());
        }
        return false;
    }


}
