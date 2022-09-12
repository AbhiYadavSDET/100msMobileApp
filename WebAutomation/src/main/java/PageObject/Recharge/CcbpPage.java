package PageObject.Recharge;

import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CcbpPage {

    WebDriver driver;


    public CcbpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//input[@id='cn']")
    private WebElement input_credit_card_number;

    @FindBy( xpath = "//input[@id='amt']")
    private WebElement enter_amount;

    @FindBy (xpath = "//div[@class='col-md-1 nopad pall col-tb-12']//child::button[@type= 'submit']")
    private WebElement cta_go;

    @FindBy (xpath = "//p[@class='ft17 fw600 mar22 mbottom']")
    private WebElement confirm_recharge_pop_up;

    @FindBy (xpath= "//div[@class= 'col-md-12 tcenter paybtnWrap m_stickyBtn']//child::button[@type='submit']")
    private WebElement cta_make_payment;

    String successMsg = "//mbk-recharge-status//p[text()='Payment Successful']";

    @FindBy (xpath = "//div[@class='col-md-6 ft15 tright fw600']")
    private WebElement getAmount;




    public void enterCreditCard(String creditcard) {
        Element.enterText(driver, input_credit_card_number, creditcard, "Enter credit Card Number");
    }

    public void enterAmount(String amount) {
        Element.enterText(driver, enter_amount, amount, "Enter Amount");
    }

    public void clickGo() {
        Element.click(driver, cta_go, "Go");
    }

    public void waitForConfirmWindowToOpen() {
        Element.waitForVisibility(driver, confirm_recharge_pop_up, "Confirm payment Screen");
    }

    public void clickMakePayment(){
        Element.selectElement(driver,cta_make_payment, "Click Make Payment" );
    }

    public boolean ifSuccessTextPresent() {

        try {
            Element.waitForVisibility(driver, (WebElement) By.xpath("successMsg"), "Success Page visible");
            return Element.isElementPresent(driver, By.xpath(successMsg));
        } catch (InterruptedException e) {
            Log.info(e.getMessage().toString());
        }
        return false;
    }

    public String getAmount(){
       return Element.getText(driver,getAmount,"Get amount from Success Page").replace("₹ ","");
    }






}
