package PageObject.Recharge;

import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandlinePage {

    WebDriver driver;


    public LandlinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "(//input[@role='combobox'])[1]")
    private WebElement operator;

    @FindBy(id = "telephoneNumber")
    private WebElement telNo;

    @FindBy(id = "cn")
    private WebElement can;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement ctaGo;

    String billText = "//div[@class='col-md-9']/p[1]";

    @FindBy(xpath = "//div[@class='col-md-9']/p[2]")
    private WebElement cNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[4]")
    private WebElement mNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[3]")
    private WebElement op;

    String bill = "//mbk-view-payment/section";

    public void selectOperator(String op){
        Element.enterText(driver, operator, op, "Select MTNL Delhi");
        Element.pressEnter(driver);
    }

    public void enterTelNo(String mobNo){
        Element.enterText(driver, telNo, mobNo, "Enter telephone no");
    }

    public void enterCAN(String cNo){
        Element.enterText(driver, can, cNo, "Enter telephone no");
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

    public String getMNo(){
        return Element.getText(driver, mNo, "Get Mob No on bill");
    }

    public boolean ifBillExists(){
        try {
            return Element.isElementPresent(driver, By.xpath(bill));
        }catch (InterruptedException e){
            Log.info(e.getMessage().toString());
        }
        return false;
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
