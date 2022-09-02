package Helpers;

import PageObject.*;
import Utils.Config;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Utils.TestBase.getWebDriver;

public class StaticWebPagesHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
    MbkReporter mbkReporter;
    AddMoneyPage addMoneyPage;
    StaticWebPages staticWebPages;
    List<WebElement> boardOfDirectors;
    List<WebElement> blogStaticPage;
    List<WebElement> pressStaticPage;
    List<WebElement> irStaticPage;

    public StaticWebPagesHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        // Mandatory pages
//        driver.navigate().to("https://www.mobikwik.com");
        homePage = new HomePage(driver);
//        dashboardPage = new DashboardPage(driver);
        staticWebPages=new StaticWebPages(driver);
        boardOfDirectors = staticWebPages.getBoardOfDirectors();
        blogStaticPage = staticWebPages.getBlogStaticPage();
        pressStaticPage = staticWebPages.getPressStaticPage();
        irStaticPage = staticWebPages.getIrStaticPage();
    }
    public void aboutWebPage(String url, String text,int noOfDirectors) throws InterruptedException {
        String parent = driver.getWindowHandle();
        staticWebPages = homePage.clickOnAbout();
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);

            mbkReporter.verifyEqualsWithLogging(noOfDirectors, boardOfDirectors.size(),"No. of Directors | " , false);

//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Config.logComment(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    genericAssertionCheck(url, text);

                    mbkReporter.verifyEqualsWithLogging(noOfDirectors, boardOfDirectors.size(),"No. of Directors | " , false);

                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
//            Thread.sleep(1000);


        }

        homePage.clickOnLogoMbk();

    }

    public void blogWebPage(String url, String text,int noOfBlogs) throws InterruptedException {
        String parent = driver.getWindowHandle();
        staticWebPages = homePage.clickOnBlog();
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);

            mbkReporter.verifyEqualsWithLogging(noOfBlogs, blogStaticPage.size(),"No. of Blogs | "  , false);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Config.logComment(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    genericAssertionCheck(url, text);

                    mbkReporter.verifyEqualsWithLogging(noOfBlogs, blogStaticPage.size(),"No. of Blogs | "  , false);

                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
//            Thread.sleep(1000);


        }
        homePage.clickOnLogoMbk();

    }
    public void investorRelationsWebPage(String url, String text,int noOfIR) throws InterruptedException {
        String parent = driver.getWindowHandle();
        String hrefValue = homePage.clickOnInvestorRelations();
        driver.get(hrefValue);
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);
            // optional checks

            mbkReporter.verifyEqualsWithLogging(noOfIR, irStaticPage.size(),"No. of Investor Relations | "  , false);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Config.logComment(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    genericAssertionCheck(url, text);
                    // optional checks

                    mbkReporter.verifyEqualsWithLogging(noOfIR, irStaticPage.size(),"No. of Investor Relations | "  , false);

                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
//            Thread.sleep(1000);


        }
        homePage.clickOnLogoMbk();

    }

    public void pressWebPage(String url, String text,int noOfPressReleases) throws InterruptedException {
        String parent = driver.getWindowHandle();
        String hrefValue = homePage.clickOnPress();
        driver.navigate().to(hrefValue);
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);

            // optional checks

//        List<WebElement> pressStaticPage = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-4']"));
            mbkReporter.verifyEqualsWithLogging(noOfPressReleases, pressStaticPage.size(),"No. of Press Releases "  , false);

            Config.logComment("No. of Press Releases Expected : "+noOfPressReleases);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Config.logComment(driver.switchTo().window(child_window).getTitle());

                    // do work here

                    genericAssertionCheck(url, text);

                    // optional checks

//        List<WebElement> pressStaticPage = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-4']"));
                    mbkReporter.verifyEqualsWithLogging(noOfPressReleases, pressStaticPage.size(),"No. of Press Releases "  , false);

                    Config.logComment("No. of Press Releases Expected : "+noOfPressReleases);

                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
//            Thread.sleep(1000);


        }
        homePage.navigateToMbk();

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




}
