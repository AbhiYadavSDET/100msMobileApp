package PageObject.Recharge;

import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GasPage {
    WebDriver driver;

    public GasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "(//input[@role='combobox'])[1]")
    private WebElement operator;

    @FindBy(xpath = "//input[@id = \"cn\"]")
    private WebElement bpNo;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[2]")
    private WebElement cNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[3]")
    private WebElement op;

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button mat-button-base']")
    private WebElement crossButton;

    @FindBy(xpath = "//div[@class='col-md-9']/p[1]")
    private WebElement successMssg;

    @FindBy(xpath = "//mbk-view-payment")
    private WebElement window_view_bill;

    @FindAll(@FindBy(xpath = "//div[@class='viewbillLst']/div[@class='row mar10 mbottom']/div"))
    private List<WebElement> date_and_amount_text;

    @FindBy(xpath = "//div[@class='col-md-9']/p[@class='fw600 ft17']")
    private WebElement no_dues_text;


    @FindBy(xpath = "(//div[@class='viewbillLst']/div[@class='row mar10 mbottom']/div[@class='col-md-6 tgreyteel ft13'])[1]")
    private WebElement due_date_text;



    String billText = "No Bills Found";

    public void selectOperator(String op) {
        Element.enterText(driver, operator, op, "MTNL Delhi");
        Element.pressEnter(driver);
    }

    public void enterBpNo(String bp) {
        Element.enterText(driver, bpNo, bp, "telephone no");
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

    public void closeBill() {
        Element.selectElement(driver, crossButton, "cross button");
    }

    public String getSuccessText() {
        return Element.getText(driver, successMssg, "success message");
    }
    public WebElement getSuccessElement() {
        return successMssg;
    }

    public void waitForViewBillWindow() {
        Element.waitForVisibility(driver, crossButton, "Cross Icon");
    }

    public List<WebElement> getDateAndAmountText(){
        return date_and_amount_text;
    }

    public WebElement getNoDuestext(){
        return no_dues_text;
    }

    public WebElement getDueDateText(){
        return due_date_text;

    }


}
