package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        Browser.waitForPageLoad(driver, searchBox);
        Config.logComment("*****On money Transfer Page*****");
    }

    @FindBy(xpath = "//input[@name='searchText']")
    private WebElement searchBox;


    @FindBy(xpath = "//input[@name='searchText']//following::a[1]")
    private WebElement searchButton;

    String noOfOffers = "//div//content";

    public void enterSearchBox(String text){
        Element.enterText(driver, searchBox, text, "search text");

    }

    public void clickSearch(){
        Element.click(driver, searchButton, "search button");
    }


    public int noOfOffers(){
        return Element.getListOfElements(driver, Element.How.xPath, noOfOffers).size();
    }


}
