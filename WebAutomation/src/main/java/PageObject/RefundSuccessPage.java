package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefundSuccessPage {

    WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Transaction Refund Initiated']")
    private WebElement label_description;

    @FindBy(xpath = "//div[@id = 'collapsible1']")
    private WebElement page_load_text;


    public RefundSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, page_load_text);
        Config.logComment("*****On Refund Success Page*****");
    }


    public String getDescription() {
        return Element.getText(driver, label_description, "Description");
    }


}








