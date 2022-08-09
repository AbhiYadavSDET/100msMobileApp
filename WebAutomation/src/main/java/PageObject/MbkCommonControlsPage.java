package PageObject;

import Utils.Config;
import Utils.Element;
import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MbkCommonControlsPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class = 'mar20 mbottom dpBLock csrPtr noblur']")
    private WebElement logo_mbk;

    @FindBy(xpath = "//button[@class = 'cmat cls mg mg_icoclose mat-icon-button']")
    private WebElement crossButton;

    @FindBy(xpath = "//div[@class='dpInBLockMid']//span[@class='tbold dpInBLockMid pad5 pleft csrPtr']")
    private WebElement balanceBeforeTxn;


    public MbkCommonControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Config.logComment("*****On MbkCommonControls Page*****");
    }

    public void clickOnLogoMbk() {
        Element.selectElement(driver, logo_mbk, "Logo Mbk");
    }

    public void closeBill() throws InterruptedException {
        if (isCrossIconPresent()) {
            Element.selectElement(driver, crossButton, "cross button");
        } else {
            Log.info("Cross Icon is not present");
        }
    }

    public Boolean isCrossIconPresent() throws InterruptedException {
        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.xpath("//button[@class = 'cmat cls mg mg_icoclose mat-icon-button']"))) {
            return true;
        } else {
            return false;
        }
    }

    public String getBalance() {
        Element.waitForVisibility(driver,balanceBeforeTxn,"Balance");
        String balance= Element.getText(driver,balanceBeforeTxn,"Get balance").replace("₹ ","");
        return balance;
    }
}








