package PageObject;

import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MbkCommonControlsPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class = 'mar20 mbottom dpBLock csrPtr noblur']")
    private WebElement logo_mbk;


    public MbkCommonControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Config.logComment("*****On MbkCommonControls Page*****");
    }

    public void clickOnLogoMbk() {
        Element.selectElement(driver, logo_mbk, "Logo Mbk");
    }
}








