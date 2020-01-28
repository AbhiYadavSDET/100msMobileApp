package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Browser extends TestBase {


	/**
	 * This Method is used to bring the current window into focus.
	 * 
	 * @param driver
	 * @author manojkumar
	 */
    public static void bringToFocus(WebDriver driver) {

        String currentWindowHandle = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("alert('Test')");
        driver.switchTo().alert().accept();
        driver.switchTo().window(currentWindowHandle);

        Config.logComment("Brought current window to focus");
    }


    /**
	 * This Method is used to refresh Browser.
	 * 
	 * @param driver
	 * @author manojkumar
	 */
    
    public static void browserRefresh(WebDriver driver) {
        //testConfig.driver.navigate().refresh();
        executeJavaScript(driver, "location.reload();");
        Config.logComment("Refreshing the browser...");
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or
     * window in the configuration driver instance.
     *
     * @param javaScriptToExecute Java Script To Execute
     * @return If the script has a return value (i.e. if the script contains a
     * return statement), then the following steps will be taken: For an
     * HTML element, this method returns a WebElement For a decimal, a
     * Double is returned For a non-decimal number, a Long is returned
     * For a boolean, a Boolean is returned For all other cases, a
     * String is returned.
     */
    public static Object executeJavaScript(WebDriver driver, String javaScriptToExecute) {
        Config.logComment("Execute javascript:-" + javaScriptToExecute);
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        return javaScript.executeScript(javaScriptToExecute);
    }

    /**
	 * This Method is used to close Browser.
	 * 
	 * @param driver
	 * @author manojkumar
	 */
    public static void closeBrowser(WebDriver driver) {
        try {
            if (driver != null) {
                Config.logComment("Close the browser window with URL:- " + driver.getCurrentUrl() + ". And title as :- " + driver.getTitle());
                driver.close();
            }
        } catch (UnreachableBrowserException e) {
            Config.logWarning(e.toString());
        }
    }

 
    
    /**
  	 * This Method is used to Delete the cookies of the given browser instance.
  	 * 
  	 * @param driver
  	 * @author manojkumar
  	 */
    public static void deleteCookies(WebDriver driver) {
        if (driver != null) {
            Config.logComment("Delete all cookies!!");
            driver.manage().deleteAllCookies();
        }
    }

    /**
   	 * This Method is used to wait till title is displayed
   	 * 
   	 * @param driver
   	 * @param String Title
   	 * @author manojkumar
   	 */
    public static void waitForPageTitleToContain(WebDriver driver, String title) {
        waitForPageTitleToContain(driver, title, Long.parseLong("10"));
    }

    /**
   	 * This Method is used to wait till title is displayed
   	 * 
   	 * @param driver
   	 * @param String Title
   	 * @param wait time in seconds
   	 * @author manojkumar
   	 */
    public static void waitForPageTitleToContain(WebDriver driver, String title, Long ObjectWaitTimeInSeconds) {
        Config.logComment("Wait for page title to contain '" + title + "'.");
        WebDriverWait wait = new WebDriverWait(driver, ObjectWaitTimeInSeconds);
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
   	 * This Method is used to fetch cookie value.
   	 * 
   	 * @param driver
   	 * @param cookie name
   	 * @author manojkumar
   	 */
    public static String getCookieValue(WebDriver driver, String cookieName) {
        String value = null;
        if (driver != null) {
            Cookie cookie = driver.manage().getCookieNamed(cookieName);
            if (cookie == null) {
                Config.logFail("Cookie " + cookieName + " Not found");
                return null;
            }
            value = cookie.getValue();
            Config.logComment("Read the cookie named '" + cookieName + "' value as '" + value + "'");
        }
        return value;
    }

    /**
   	 * This Method is used to set Cookie value
   	 * 
   	 * @param driver
   	 * @param cookieName
   	 * @param cookieValue
   	 * @param cookieDomain
   	 * @author manojkumar
   	 */
    public static void setCookieValue(WebDriver driver, String cookieName, String cookieValue, String cookieDomain) {

        if (driver != null) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date tomorrow = cal.getTime();

            Cookie cookie = new Cookie(cookieName, cookieValue, cookieDomain, "/", tomorrow);
            driver.manage().addCookie(cookie);
            Config.logComment("Added the cookie - Name: '" + cookieName + "' Value: '" + cookieValue + "' Domain: '" + cookieDomain + "' Expiry: '" + tomorrow.toString() + "'");
        }

    }


    /**
   	 * This Method is used to return back to previous page
   	 * 
   	 * @param driver
   	 * @author manojkumar
   	 */
    public static void goBack(WebDriver driver) {
        Config.logComment("Clicking on back button on browser");
        driver.navigate().back();
       
    }

    /**
   	 * This Method is used to  Quits the driver, closing every associated window.
   	 * 
   	 * @param driver
   	 * @author manojkumar
   	 */
    public static void quitBrowser(WebDriver driver) {
        try {
            if (driver != null) {
                Config.logComment("Quit the browser");
                driver.quit();
            }
        } catch (UnreachableBrowserException e) {
            Config.logWarning(e.toString());
        }
    }

    
    /**
   	 * This Method is used to Switch the driver to the specified window
   	 * 
   	 * @param driver
   	 * @param windowHandle Name of the window to be switched to
   	 * @author manojkumar
   	 */
    public static void switchToGivenWindow(WebDriver driver, String windowHandle) {
        if (driver != null) {
            Config.logComment("Switching to the given window handle:- " + windowHandle);
            driver.switchTo().window(windowHandle);
            Config.logComment("Switched to window with URL:- " + driver.getCurrentUrl() + ". And title as :- " + driver.getTitle());
        }
    }
    
    /**
   	 * This Method is used to Switch the driver to the new window
   	 * 
   	 * @param driver
   	 * @return window handle of the old window, so that it can be switched back later
   	 * @author manojkumar
   	 */
    public static String switchToNewWindow(WebDriver driver) {
        if (driver != null) {
            Config.logComment("Switching to the new window");
            String oldWindow = driver.getWindowHandle();

            if (driver.getWindowHandles().size() < 2) {
                Config.logFail("No new window appeared, windows count available :-" + driver.getWindowHandles().size());
            }

            for (String winHandle : driver.getWindowHandles()) {
                if (!winHandle.equals(oldWindow)) {
                    driver.switchTo().window(winHandle);
                    Config.logComment("Switched to window with URL:- " + driver.getCurrentUrl() + ". And title as :- " + driver.getTitle());
                }
            }

            return oldWindow;
        }
        return null;
    }

    
    /**
   	 * This Method is used to Pause the execution for given seconds
   	 * 
   	 * @param driver
   	 * @param seconds
   	 * @author manojkumar
   	 */
    public static void wait(WebDriver driver, int seconds) {
        int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
            Config.logComment("Wait for '" + seconds + "' seconds");

        } catch (InterruptedException e) {

        }
    }

    /**
   	 * This Method is used to wait until given url visible
   	 * 
   	 * @param driver
   	 * @param url
     * @param maxTimeToWaitInSec
   	 * @author manojkumar
   	 */
    public static void waitForUrlToDisplay(WebDriver driver, String url, int maxTimeToWaitInSec) {
        int count = 0;
        while (!driver.getCurrentUrl().equals(url) && count < maxTimeToWaitInSec) {
            count += 1;
            Browser.wait(driver, 1);
        }
    }
    
    /**
   	 * This Method is used to Waits for the given WebElement to appear on the specified browser
     * instance
   	 * 
   	 * @param driver
   	 * @param element element to be searched
   	 * @author manojkumar
   	 */
    public static void waitForPageLoad(WebDriver driver, WebElement element) {
        waitForPageLoad(driver, element, properties.getProperty("ImplicitWaitTime").toString());
    }

    
    /**
   	 * This Method is used to Waits for the given WebElement to appear on the specified browser
     * instance
   	 * 
   	 * @param driver
   	 * @param element        element to be searched
     * @param ObjectWaitTime - max time to wait for the object
   	 * @author manojkumar
   	 */
    public static void waitForPageLoad(WebDriver driver, WebElement element, String waitTime) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date startDate = new Date();
        double timeTaken = 0;

        // Increase the timeout value
        Long ObjectWaitTime = Long.parseLong(waitTime);
        Config.logComment("Started waiting for WebPage to load at:- " + dateFormat.format(startDate) + ". Wait upto " + ObjectWaitTime + " seconds.");

        // We should not use implicit and explicit wait together, so resetting the implicit wait prior to using explicit wait
        driver.manage().timeouts().implicitlyWait(ObjectWaitTime, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, ObjectWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            Config.logWarning("StaleElementReferenceException occured, wait upto additional " + ObjectWaitTime + " seconds.");

            try {
                wait.until(ExpectedConditions.visibilityOf(element));
            } catch (Exception exc) {
                Date endDate = new Date();
                Config.logWarning("WebPage NOT loaded even after :- " + (endDate.getTime() - startDate.getTime()) / 1000.00 + " seconds. Exiting...");
                Assert.fail();
            }
        } catch (Exception e) {
            Date date = new Date();
            Config.logComment("\n<-----New Exception in Browser.waitForPageLoad----->:-" + date.getTime());
        }

    }
    
    /**
   	 * This Method is used to wait till element visible on page
   	 * 
   	 * @param driver
   	 * @param timeIntervalInSeconds
     * @param totalTimeToWait
   	 * @author manojkumar
   	 */
    public static void waitForElementToVisibleOnPage(WebDriver driver, WebElement webElement, int totalTimeToWaitInSeconds) {
        int calculatedTime = 0;
        for (int i = 0; i < totalTimeToWaitInSeconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            if (webElement.isDisplayed())
                break;
        }
        if (!webElement.isDisplayed())
            Config.logComment("WebElement not Displayed");
    }
    
    /**
   	 * This Method is used to Waits and accepts POP Up
   	 * 
   	 * @param driver
   	 * @param pollTime - Intervals in which Browser should be polled for alert
   	 * @author manojkumar
   	 */
    public static void waitForPopUp(WebDriver driver, int pollTime) {

        // Time to poll for every 5 seconds whether popup is present or not
        int threshold = 5;

        for (int i = 0; i < pollTime; i++) {

            // Time to poll for every 5 seconds whether popup is present or not
            if (Popup.isAlertPresent(driver)) {
                Popup.acceptPopup(driver);
                Config.logComment("Alert closed successfully");
                break;
            }

            Browser.wait(driver, threshold);
        }
    }

    public static String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

}
