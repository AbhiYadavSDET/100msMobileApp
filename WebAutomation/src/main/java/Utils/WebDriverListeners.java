package Utils;

import com.aventstack.extentreports.markuputils.ExtentColor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class WebDriverListeners extends TestBase implements WebDriverEventListener {

    private By lastFindBy;
    private WebElement lastElement;
    private String originalValue;


    /*
     *  URL NAVIGATION | NAVIGATE() & GET()
     */
    // Prints the URL before Navigating to specific URL "get("http://www.google.com");"
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Before Navigating To : " + url + ", my url was: " + driver.getCurrentUrl());

    }

    // Prints the current URL after Navigating to specific URL "get("http://www.google.com");"
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("After Navigating To: " + url + ", my url is: "
                    + driver.getCurrentUrl());
    }

    // Prints the URL before Navigating back "navigate().back()"
    @Override
    public void beforeNavigateBack(WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Before Navigating Back. I was at "
                    + driver.getCurrentUrl());
    }

    // Prints the current URL after Navigating back "navigate().back()"
    @Override
    public void afterNavigateBack(WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("After Navigating Back. I'm at "
                    + driver.getCurrentUrl());
    }

    // Prints the URL before Navigating forward "navigate().forward()"
    @Override
    public void beforeNavigateForward(WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Before Navigating Forward. I was at "
                    + driver.getCurrentUrl());
    }

    // Prints the current URL after Navigating forward "navigate().forward()"
    @Override
    public void afterNavigateForward(WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("After Navigating Forward. I'm at "
                    + driver.getCurrentUrl());
    }


    /*
     * ON EXCEPTION | SCREENSHOT, THROWING ERROR
     */
    // Takes screenshot on any Exception thrown during test execution
    @Override
    public void onException(Throwable throwable, WebDriver webdriver) {
        Config.logComment("Caught Exception");
        Long timestamp;
        timestamp = System.currentTimeMillis();

        File scrFile = ((TakesScreenshot) webdriver)
                .getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(scrFile, new File(
                    System.getProperty("user.dir") + "/test-output/screenshots/" + timestamp + ".jpeg"));
            Log.info("SS 1 : " + System.getProperty("user.dir") + "/test-output/screenshots/" + timestamp + ".jpeg");
        } catch (Exception e) {
            Config.logComment("Unable to Save");
        }


        try {
            Log.info("Logging the Exception in Extent Report");
            ExtentReport.createLable("Exception", ExtentColor.CYAN);
            ExtentReport.extentReportDisplay(ExtentReport.Status.FAIL, "Exception Message", throwable.getMessage());
            ExtentReport.extentReportAttachScreenshot("./test-output/screenshots/" + timestamp + ".jpeg");
            Log.info("SS 2 : " + "./test-output/screenshots/" + timestamp + ".jpeg");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * FINDING ELEMENTS | FINDELEMENT() & FINDELEMENTS()
     */
    // Called before finding Element(s)
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        lastFindBy = by;
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Trying to find: '" + lastFindBy + "'.");
    }

    // Called after finding Element(s)
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        lastFindBy = by;
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Found: '" + lastFindBy + "'.");
    }


    /*
     * CLICK | CLICK()
     */
    // Called before clicking an Element
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Trying to click: '" + element + "'");
        // Highlight Elements before clicking
        for (int i = 0; i < 1; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: black; border: 3px solid black;");
        }
    }

    // Called after clicking an Element
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true"))
            Config.logComment("Clicked Element with: '" + element + "'");
    }


    /*
     * SCRIPT - this section will be modified ASAP
     */
    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])
    @Override
    public void beforeScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub
    }

    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])
    @Override
    public void afterScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub
    }


    @Override
    public void afterAlertAccept(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterAlertDismiss(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterChangeValueOf(WebElement arg0, WebDriver arg1,
                                   CharSequence[] arg2) {
        // TODO Auto-generated method stub

    }


    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
        // TODO Auto-generated method stub

    }


    @Override
    public void afterNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub

    }


    @Override
    public void afterSwitchToWindow(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeAlertAccept(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeAlertDismiss(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1,
                                    CharSequence[] arg2) {
        // TODO Auto-generated method stub

    }


    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeGetText(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateRefresh(WebDriver arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }


}
