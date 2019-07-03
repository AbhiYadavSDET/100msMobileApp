package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CcAvenuePaymentPage {

    WebDriver driver;


    @FindBy(xpath = "//input[@value = 'Return To the Merchant Site']")
    private WebElement button_return_to_merchant_site;


    public CcAvenuePaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, button_return_to_merchant_site);
        Config.logComment("*****On Cc Avenue Payment Page*****");
    }


    public SuccessPage clickOnReturnToMerchantSite() {
        Element.selectElement(driver, button_return_to_merchant_site, "Return to Merchant Site button");
        return new SuccessPage(driver);
    }


}








