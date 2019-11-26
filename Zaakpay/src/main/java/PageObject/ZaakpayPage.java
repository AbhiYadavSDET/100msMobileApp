package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ZaakpayPage {

    WebDriver driver;



    //Web dashboard details

    @FindBy(xpath = ".//*[@class = 'LgIn']")
    private WebElement label_login;

    @FindBy(xpath = ".//*[@type = 'text' and @placeholder = 'Email ID' and @property = 'username']")
    private WebElement label_enter_emailid;


    @FindBy(xpath ="//*[@id=\"LOGINpassword\"]" )
    private WebElement label_enter_password;

    @FindBy(xpath = ".//*[@id=\"loginPop\"]/form/ul/li[4]/input")
    private WebElement label_submit;

    @FindBy(xpath ="/html/body/div[5]/div[1]/div/h1" )
    private WebElement webpage_load;

    @FindBy(xpath = ".//*[@class = 'transaction']")
    private WebElement label_transactions;

    @FindBy(xpath = ".//*[@placeholder = 'Enter Order ID' and @id = 'orderId']")
    private WebElement label_enter_orderid;

    @FindBy(xpath = ".//*[@placeholder = 'Enter Zaakpay ID' and @id = 'zaakpayId']")
    private WebElement label_enter_zaakpay_id;

    @FindBy(xpath = ".//*[@type = 'button' and @value = 'GO']")
    private WebElement label_go_button;

    @FindBy (xpath = ".//*[@onchange = 'submitFromSelect(this);']" )
    private WebElement label_clickonselectoption;





    public ZaakpayPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        Browser.waitForPageLoad(driver,webpage_load);
        Config.logComment("*****On Zaakpay Dashboard*****");

    }

    //Web Dashboard details

    public void clickOnLoginButton() { Element.selectElement(driver, label_login,"Login Button"); }

    public void enterEmail (String email){ Element.enterText(driver,label_enter_emailid,email,"Email");}

    public void enterPassword (String password){Element.enterText(driver,label_enter_password, password,"Password");}

    public void clickOnSubmitButton () { Element.selectElement(driver,label_submit,"Submit"); }

    public void clickOnTransactionOption(){ Element.click(driver,label_transactions,"Transaction Option");}

    public void enterOrderId(String orderid){Element.enterText(driver,label_enter_orderid,orderid,"OrderId");}

    public void enterZaakpayId(String zaakpayid){Element.enterText(driver,label_enter_zaakpay_id,zaakpayid,"ZaakpayId");}

    public void clickOnGoButton(){Element.click(driver,label_go_button,"Go button");}

    public  void  selectoption (){Element.selectVisibleText(driver,label_clickonselectoption,"Initiate Full Refund","Option from");}











}
