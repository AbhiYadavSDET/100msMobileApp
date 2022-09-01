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
    public void genericAssertionCheck(String url, String text) {
        System.out.println(driver.getTitle());

        mbkReporter.verifyEqualsWithLogging(text,driver.getTitle(), "Title of Page : ",false);

//        mbkReporter.verifyTrueWithLogging(driver.getTitle().contains(text), "Web page opened",false);

        System.out.println("Web page is opened.");

        String currentURL = driver.getCurrentUrl();

        mbkReporter.verifyTrueWithLogging(currentURL.equalsIgnoreCase(url), "Actual : " + currentURL + " | "+"Expected : "+url,false);

//        Assert.assertTrue();

        System.out.println("Matches : " + currentURL);
    }

    public void assertionCheckForAbout(String url, String text,int noOfDirectors) {
        genericAssertionCheck(url, text);

        mbkReporter.verifyEqualsWithLogging(noOfDirectors, boardOfDirectors.size(),"No. of Directors | " , false);

    }
    public void handleAssertionsAndMultipleTabsForAbout(String url, String text,int noOfDirectors,String parent) throws InterruptedException {
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            assertionCheckForAbout(url,text,noOfDirectors);

            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    System.out.println(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    assertionCheckForAbout(url,text,noOfDirectors);
                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
            Thread.sleep(1000);


        } else {
            //do nothing
            Thread.sleep(1000);

        }

    }

    public void assertionCheckForBlog(String url, String text ,int noOfBlogs) throws InterruptedException {
        genericAssertionCheck(url, text);

        mbkReporter.verifyEqualsWithLogging(noOfBlogs, blogStaticPage.size(),"No. of Blogs | "  , false);

//        System.out.println("All blogs are present");


    }

    public void handleAssertionsAndMultipleTabsForBlog(String url, String text,int noOfBlogs,String parent) throws InterruptedException {
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            assertionCheckForBlog(url,text,noOfBlogs);

            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    System.out.println(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    assertionCheckForBlog(url,text,noOfBlogs);
                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
            Thread.sleep(1000);


        } else {
            //do nothing
            Thread.sleep(1000);

        }

    }
    public void assertionCheckForPress(String url, String text,int noOfPressReleases) {
        genericAssertionCheck(url, text);

        // optional checks

//        List<WebElement> pressStaticPage = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-4']"));
        mbkReporter.verifyEqualsWithLogging(noOfPressReleases, pressStaticPage.size(),"No. of Press Releases | "  , false);

        System.out.println("No. of Press Releases Expected : "+noOfPressReleases);


    }

    public void clickOnLogoMbkOnPressPage(){
        Element.selectElement(driver, logo_mbk_presspage, "Logo Mbk");
    }

    public void handleAssertionsAndMultipleTabsForPress(String url, String text,int noOfPressReleases,String parent) throws InterruptedException {
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            assertionCheckForPress(url,text,noOfPressReleases);

            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    System.out.println(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    assertionCheckForPress(url,text,noOfPressReleases);
                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
            Thread.sleep(1000);


        } else {
            //do nothing
            Thread.sleep(1000);

        }

    }

    public void assertionCheckForInvestorRelations(String url, String text,int noOfIR) {


        genericAssertionCheck(url, text);
        // optional checks

        mbkReporter.verifyEqualsWithLogging(noOfIR, irStaticPage.size(),"No. of Investor Relations | "  , false);


    }

    public void handleAssertionsAndMultipleTabsForIR(String url, String text,int noOfIR,String parent) throws InterruptedException {
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            assertionCheckForInvestorRelations(url,text,noOfIR);

            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    System.out.println(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    assertionCheckForInvestorRelations(url,text,noOfIR);
                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
            Thread.sleep(1000);


        } else {
            //do nothing
            Thread.sleep(1000);

        }

    }


}
