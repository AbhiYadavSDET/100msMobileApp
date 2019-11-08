package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZaakpayPage {

    WebDriver driver;

    //Web dashboard details

    @FindBy(xpath = "/html/body/header/div[1]/div/div[2]/nav/ul/li[5]/a")
    private WebElement label_login;

    @FindBy(xpath = ".//*[@type = 'text' and @placeholder = 'Email ID' and @property = 'username']")
    private WebElement label_enter_emailid;


    @FindBy(xpath ="//*[@id=\"LOGINpassword\"]" )
    private WebElement label_enter_password;

    @FindBy(xpath = ".//*[@id=\"loginPop\"]/form/ul/li[4]/input")
    private WebElement label_submit;

    @FindBy(xpath ="/html/body/div[5]/div[1]/div/h1" )
    private WebElement webpage_load;

    public ZaakpayPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        Browser.waitForPageLoad(driver,webpage_load);
        Config.logComment("*****On Zaakpay Dashboard*****");

    }

    //Web Dashboard details

    public void clickOnLoginButton() { Element.selectElement(driver, label_login,"Click On Login Button"); }

    public void enterEmail (String email){ Element.enterText(driver,label_enter_emailid,email,"Email");}

    public void enterPassword (String password){Element.enterText(driver,label_enter_password, password,"Password");}

    public void clickOnSubmitButton () { Element.selectElement(driver,label_submit,"Submit"); }





}
