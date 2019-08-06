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

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    String billText = "//div[@class='col-md-9']/p[1]";

    @FindBy(xpath = "//div[@class='col-md-9']/p[2]")
    private WebElement cNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[4]")
    private WebElement mNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[3]")
    private WebElement op;

    @FindBy(xpath = "/mbk-view-payment/section")
    private WebElement bill_window;

    @FindBy(xpath = "//div[@class='col-md-9']/p[1]")
    private WebElement bill_text;

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button']")
    private WebElement crossButton;

    String bill = "//mbk-view-payment/section";

    public void selectOperator(String op) {
        Element.enterText(driver, operator, op, "MTNL Delhi");
        Element.pressEnter(driver);
    }

    public void enterTelNo(String mobNo) {
        Element.enterText(driver, telNo, mobNo, "telephone no");
    }

    public void enterCAN(String cNo) {
        Element.enterText(driver, can, cNo, "cn");
    }

    public void clickGo() {
        Element.click(driver, ctaGo, "Go");
    }

    public String getOperator() {
        return Element.getText(driver, op, "operator on bill");
    }

    public String getCNo() {
        return Element.getText(driver, cNo, "Cno on bill");
    }

    public String getMNo() {
        return Element.getText(driver, mNo, "Mob No on bill");
    }

    public String getBillText() {
        return Element.getText(driver, bill_text, "Bill Text");
    }

    public boolean ifBillExists() {
        try {
            return Element.isElementPresent(driver, By.xpath(bill));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public boolean ifTextPresent() {
        try {
            return Element.isElementPresent(driver, By.xpath(billText));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public void waitForBillWindow() {
        Element.waitForVisibility(driver, crossButton, "Bill Window");
    }

    public void closeBill() {
        Element.selectElement(driver, crossButton, "cross button");
    }

}
