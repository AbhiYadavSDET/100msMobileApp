package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefundPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@value = 'PayNow']")
    private WebElement button_pay_now;

    @FindBy(xpath = "//input[@name = 'updateDesired']")
    private WebElement textbox_state;

    @FindBy(xpath = "//input[@name = 'orderId']")
    private WebElement textbox_orderid;


    public RefundPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, button_pay_now);
        Config.logComment("*****On Refund Page*****");
    }


    public void enterState(String state) {
        Element.enterText(driver, textbox_state, state, "State");
    }

    public void enterOrderId(String orderId) {
        Element.enterText(driver, textbox_orderid, orderId, "Order Id");
    }

    public void clickOnPayNow() {
        Element.selectElement(driver, button_pay_now, "Pay Now");
    }


}








