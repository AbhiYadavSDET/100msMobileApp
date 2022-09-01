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

    @FindBy(xpath = "//div[@class='ng-input']/input")
    private WebElement operator;

    @FindBy(xpath = "//input[@placeholder='Telephone Number (Without STD Code)']")
    private WebElement telNo;

    @FindBy(xpath = "//input[@id='customerAccountNumber']")
    private WebElement can;

    @FindBy(xpath = "//span[text()='Go']")
    private WebElement ctaGo;

    String billText = "//div[@class='col-md-9']/p[1]";

    @FindBy(xpath = "//p[@class='ft11 tgreyteel breakword']")
    private WebElement cNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[4]")
    private WebElement mNo;

    @FindBy(xpath = "//div[@class='col-md-9']/p[3]")
    private WebElement op;

    @FindBy(xpath = "/mbk-view-payment/section")
    private WebElement bill_window;

    @FindBy(xpath = "//div[@class='col-md-9']/p[1]")
    private WebElement bill_text;

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button mat-button-base']")
    private WebElement crossButton;

    String bill_amount = "//input[@class= 'form-input tx48 nobdr nobg nopad pleft ptop ng-untouched ng-pristine']";

    String no_due_amount="//p[@class = 'ft15 smtop15 smbottom30 tcenter']";

    @FindBy(xpath = "//p[@class = 'ft15 smtop15 smbottom30 tcenter']")
    private WebElement error_message;

    String bill = "//mbk-view-payment/section";

    public void selectOperator(String op) {
        Element.enterText(driver, operator, op, "MTNL Delhi");
        Element.pressEnter(driver);
    }

    public void enterTelNo(String mobNo) throws InterruptedException {
        Element.selectElement(driver,telNo,"Telephone no");
//        Thread.sleep(3000);
        Element.enterText(driver, telNo, mobNo, "telephone no");
//        driver.findElement(By.xpath("//input[@class='form-input tx48 ng-touched ng-dirty ng-invalid']")).sendKeys(mobNo);
    }

    public void enterCAN(String cNo) {
        Element.selectElement(driver,can,"cn");
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

    public boolean billStatus() throws InterruptedException {

        if(Element.isElementPresent(driver, By.xpath(bill_amount) )){
            Log.info("Bill amount Present");
            return true;
        }else if( Element.isElementPresent(driver, By.xpath(no_due_amount))){
            Log.info("No Due amount Present");
            return true;
        }else {
            String Error =Element.getText(driver, error_message,"Getting Error Message");
            Log.info(Error);
            return false;
        }

    }

}
