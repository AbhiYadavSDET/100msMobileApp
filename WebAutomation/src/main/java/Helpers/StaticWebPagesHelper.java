package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

import static Utils.TestBase.getWebDriver;

public class StaticWebPagesHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
    MbkReporter mbkReporter;
    AddMoneyPage addMoneyPage;
    StaticWebPages staticWebPages;

    public StaticWebPagesHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        // Mandatory pages
//        driver.navigate().to("https://www.mobikwik.com");
        homePage = new HomePage(driver);
//        dashboardPage = new DashboardPage(driver);
        staticWebPages=new StaticWebPages(driver);
    }
    public void aboutWebPage(String url, String text,int noOfDirectors) throws InterruptedException {
        String parent = driver.getWindowHandle();
        staticWebPages = homePage.clickOnAbout();
        staticWebPages.handleAssertionsAndMultipleTabsForAbout(url,text,noOfDirectors,parent);
        homePage.clickOnLogoMbk();

    }

    public void blogWebPage(String url, String text,int noOfBlogs) throws InterruptedException {
        String parent = driver.getWindowHandle();
        staticWebPages = homePage.clickOnBlog();
        staticWebPages.handleAssertionsAndMultipleTabsForBlog(url,text,noOfBlogs,parent);
        homePage.clickOnLogoMbk();

    }
    public void investorRelationsWebPage(String url, String text,int noOfIR) throws InterruptedException {
        String parent = driver.getWindowHandle();
        String hrefValue = homePage.clickOnInvestorRelations();
        driver.get(hrefValue);
        staticWebPages.handleAssertionsAndMultipleTabsForIR(url,text,noOfIR,parent);
        homePage.clickOnLogoMbk();

    }

    public void pressWebPage(String url, String text,int noOfPressReleases) throws InterruptedException {
        String parent = driver.getWindowHandle();
        String hrefValue = homePage.clickOnPress();
        driver.navigate().to(hrefValue);
        staticWebPages.handleAssertionsAndMultipleTabsForPress(url,text,noOfPressReleases,parent);
        homePage.navigateToMbk();

    }



}
