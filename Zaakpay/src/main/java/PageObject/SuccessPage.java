package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

    WebDriver driver;

    @FindBy(xpath = "//td[text() = 'Response Description']/following::td[1]")
    private WebElement label_decription;

    @FindBy(xpath = "//td[text() = 'This Page is for Testing purpose later on will be on merchant Site']")
    private WebElement page_load_text;

    @FindBy(xpath = ".//*[@type = 'button' and @value = 'Make Payment' and @class = 'mk_payment_btn btn']")
    private WebElement label_make_payment;

    @FindBy(xpath = ".//*[@id= 'paylater']/div[2]/div/p[1]/div/div[2]/div/span")
    private WebElement label_unregistered_number;







    public SuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, page_load_text);
        Config.logComment("*****On Success Page*****");
    }




    public String getDescription()
    {
        return Element.getText(driver, label_decription, "Description");
    }



}








