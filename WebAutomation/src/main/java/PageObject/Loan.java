package PageObject;

import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Loan {

    WebDriver driver;
    @FindBy(xpath = "//a[@routerlink = '/zip-paylater']")
    private WebElement loan;



    @FindAll(@FindBy(xpath = "//*[@class='tgreydark tbold']"))
    private List<WebElement> icons;



    @FindAll(@FindBy(xpath = "//*[@class='benewrap sptop20']"))
    private List<WebElement> benifitsZip;



    @FindBy(xpath = "//a[text()='Activate Now']")
    private WebElement activateNow;




    public Loan(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickOnLoan(){
        Element.selectElement(driver,loan,"click on loan");
    }
    public int getIcons(){
        return icons.size();
    }

    public int getBenefitsOfZip(){
        return benifitsZip.size();
    }

    public boolean isActivateNowVisible(){
        return activateNow.isDisplayed();
    }


}
