package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NearByPage {
    WebDriver driver;

    public NearByPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, searchBox);
        Config.logComment("*****On near by Page*****");
    }

    @FindBy(xpath = "//input[@name='searchArea']")
    private WebElement searchBox;


    @FindBy(xpath = "//input[@name='searchArea']//following::a[1]")
    private WebElement searchButton;

    String noOfStores = "//div//content";

    public void enterSearchBox(String text){
        Element.enterText(driver, searchBox, text, "search text");

    }

    public void clickSearch(){
        Element.click(driver, searchButton, "search button");
    }


    public int noOfStores(){
        return Element.getListOfElements(driver, Element.How.xPath, noOfStores).size();
    }


}
