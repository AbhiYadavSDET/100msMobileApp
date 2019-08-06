package PageObject.Recharge;

import Utils.Element;
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

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button']")
    private WebElement crossButton;

    @FindBy(xpath = "//div[@class='col-md-9']/p[1]")
    private WebElement successMssg;

    @FindBy(xpath = "//mbk-view-payment")
    private WebElement window_view_bill;

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

    public void waitForViewBillWindow() {
        Element.waitForVisibility(driver, crossButton, "Cross Icon");
    }




}
