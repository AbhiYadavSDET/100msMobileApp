package PageObject;

import Utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StaticWebPages{
    WebDriver driver;
    MbkReporter mbkReporter;

//    @FindBy(xpath = "//*[text() = '© 2022 One MobiKwik Systems Limited']")
//    public WebElement labelStaticPages;


    @FindAll({@FindBy(xpath = "//*[@class='col-md-3 col-tb-12 tcenter smbottom30']")})
    public List<WebElement> boardOfDirectors;

    @FindAll({@FindBy(xpath = "//div[@class='col-xs-12 col-sm-4']")})
    public List<WebElement> blogStaticPage;

    @FindAll({@FindBy(xpath = "//div[@class='col-xs-12 col-sm-4']")})
    public List<WebElement> pressStaticPage;

    @FindAll({@FindBy(xpath = "//div[@class='t-container t-align_center']")})
    public List<WebElement> irStaticPage;

    @FindBy(xpath = "//a[@class = 'site-logo text-center image-logo-wrapper']")
    private WebElement logo_mbk_presspage;




//    List<WebElement> boardOfDirectors = driver.findElements(By.xpath("//*[@class='col-md-3 col-tb-12 tcenter smbottom30']"));




    public StaticWebPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        Browser.waitForPageLoad(driver, labelStaticPages);
        Config.logComment("*****On Static Web Page*****");
        mbkReporter = new MbkReporter();
    }

    public List<WebElement> getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public List<WebElement> getBlogStaticPage() {
        return blogStaticPage;
    }

    public List<WebElement> getIrStaticPage() {
        return irStaticPage;
    }

    public List<WebElement> getPressStaticPage() {
        return pressStaticPage;
    }

    public void clickOnLogoMbkOnPressPage(){

        Element.selectElement(driver, logo_mbk_presspage, "Logo Mbk");

    }

}
