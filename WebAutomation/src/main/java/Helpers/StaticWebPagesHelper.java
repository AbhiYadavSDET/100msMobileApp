package Helpers;

import PageObject.*;
import Utils.Config;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.sound.sampled.Line;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StaticWebPagesHelper {

    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    StaticWebPages staticWebPages;
    List<WebElement> boardOfDirectors;
    List<WebElement> blogStaticPage;
    List<WebElement> pressStaticPage;
    List<WebElement> irStaticPage;

    public StaticWebPagesHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
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

            mbkReporter.verifyEqualsWithLogging(boardOfDirectors.size() , noOfDirectors,"No. of Directors | " , false);

//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Log.info(driver.switchTo().window(child_window).getTitle());



                    genericAssertionCheck(url, text);

                    mbkReporter.verifyEqualsWithLogging(boardOfDirectors.size(),noOfDirectors, "No. of Directors | " , false);

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

            mbkReporter.verifyEqualsWithLogging(blogStaticPage.size(),noOfBlogs, "No. of Blogs | "  , false);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Log.info(driver.switchTo().window(child_window).getTitle());



                    genericAssertionCheck(url, text);

                    mbkReporter.verifyEqualsWithLogging(blogStaticPage.size(),noOfBlogs, "No. of Blogs | "  , false);

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
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
        // open the link in new tab, Keys.Chord string passed to sendKeys
        String hrefValue = homePage.clickOnInvestorRelations(clicklnk);

//        driver.get(hrefValue);
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);
            // optional checks

            mbkReporter.verifyEqualsWithLogging( irStaticPage.size(), noOfIR,"No. of Investor Relations | "  , false);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Log.info(driver.switchTo().window(child_window).getTitle());



                    genericAssertionCheck(url, text);
                    // optional checks

                    mbkReporter.verifyEqualsWithLogging( irStaticPage.size(),noOfIR,"No. of Investor Relations | "  , false);

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
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
        // open the link in new tab, Keys.Chord string passed to sendKeys

        String hrefValue = homePage.clickOnPress(clicklnk);
//        driver.navigate().to(hrefValue);
        Set<String> allTabs = driver.getWindowHandles();

        if (allTabs.size() == 1) {

            genericAssertionCheck(url, text);

            // optional checks

//        List<WebElement> pressStaticPage = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-4']"));
            mbkReporter.verifyEqualsWithLogging( pressStaticPage.size(), noOfPressReleases,"No. of Press Releases "  , false);

            Log.info("No. of Press Releases Expected : "+noOfPressReleases);


//            Thread.sleep(1000);


        } else if (allTabs.size() > 1) {

            // iterate over child tabs
            Iterator<String> I1 = allTabs.iterator();

            while (I1.hasNext()) {

                String child_window = I1.next();

                // checking current tab is child tab
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);

                    Log.info(driver.switchTo().window(child_window).getTitle());



                    genericAssertionCheck(url, text);

                    // optional checks

//        List<WebElement> pressStaticPage = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-4']"));
                    mbkReporter.verifyEqualsWithLogging(pressStaticPage.size(),noOfPressReleases, "No. of Press Releases "  , false);

                    Log.info("No. of Press Releases Expected : "+noOfPressReleases);

                    // closing child tab
                    driver.close();
                }

            }
            // switched to parent tab
            driver.switchTo().window(parent);
//            Thread.sleep(1000);


        }
        Thread.sleep(3000);
//        homePage.navigateToMbk();
        homePage.clickOnLogoMbk();
//        driver.navigate().back();

    }
    public void genericAssertionCheck(String url, String text) {
        Log.info(driver.getTitle());

        mbkReporter.verifyEqualsWithLogging(driver.getTitle(),text, "Title of Page : ",false);

//        mbkReporter.verifyTrueWithLogging(driver.getTitle().contains(text), "Web page opened",false);

        Log.info("Web page is opened.");

        String currentURL = driver.getCurrentUrl();

        mbkReporter.verifyTrueWithLogging(currentURL.equalsIgnoreCase(url), "Actual : " + currentURL + " | "+"Expected : "+url,false);

//        Assert.assertTrue();

        Log.info("Matches : " + currentURL);
    }




}
