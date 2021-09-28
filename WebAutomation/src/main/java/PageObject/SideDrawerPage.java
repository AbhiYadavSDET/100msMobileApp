package PageObject;

import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideDrawerPage {

    WebDriver driver;


    @FindBy(xpath = "//i[@class='mg mg_icouser ft20 ln40 sptop2 gradbg7_bf']/following::p[1]")
    private WebElement user_name;

    @FindBy(xpath = "//i[@class='mg mg_icouser ft20 ln40 sptop2 gradbg7_bf']/following::p[2]")
    private WebElement user_email_id;

    @FindBy(xpath = "//i[@class='mg mg_icouser ft20 ln40 sptop2 gradbg7_bf']/following::p[3]")
    private WebElement user_cell_number;

    @FindBy(xpath= "(//div[@class= 'overlaybgDark zi6'])[2]")
    private WebElement dark_overlay;

    @FindBy(xpath= "//span[text() ='Home']")
    private WebElement home_cta;



    public SideDrawerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }



    public  String getUserName() {

        return Element.getText(driver, user_name, "User Name");

    }


    public  String getEmailId() {

        return Element.getText(driver, user_email_id, "User Email ID");
    }


    public  String getUserCellNumber()
    {
        return Element.getText(driver, user_cell_number, "User Cell Number");
    }

    public void clickDarkOverlay(){
        Element.selectElement(driver, dark_overlay, "Click on greyed out area");
    }

    public void clickHomeCtaInSideDrawer(){
        Element.selectElement(driver, home_cta, "Click on Home Cta in side Drawer");
    }


}
