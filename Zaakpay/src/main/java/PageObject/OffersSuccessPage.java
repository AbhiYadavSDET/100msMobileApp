package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersSuccessPage {

    WebDriver driver;

    @FindBy(xpath = ".//*[@class = 'ServerError txtCenter']")
    private WebElement label_confirmationmessage;

    @FindBy(xpath = "//*[@id='transaction']/tbody/tr[3]/td[9]/strong")
    private WebElement label_status;

    public OffersSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_status);
        Config.logComment("*****Refunded Successfully*****");
    }

    public String getConfirmation()
    {
        return Element.getText(driver, label_confirmationmessage, "Description");
    }

}
