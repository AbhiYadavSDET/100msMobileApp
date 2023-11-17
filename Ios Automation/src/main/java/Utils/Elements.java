package Utils;

import Logger.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Elements extends TestBase {

    IOSDriver driver;

    public Elements(IOSDriver driver) {
        this.driver = driver;
    }

    public static void selectElement(IOSDriver driver, IOSElement element, String comments) {

        waitForElementToVisibleOnPage(driver, element, 10);
        click(driver, element, comments);
    }

    public static void selectElement(IOSDriver driver, String element, String comments) {

        waitForElementToVisibleOnPageUsingText(driver, element, 10);
        click(driver, element, comments);
    }

    public static void enterToElement(IOSDriver driver, IOSElement element, String data, String comments) {

        waitForElementToVisibleOnPage(driver, element, 10);
        enterData(driver, element, comments, data);
    }

    public static void clearText(IOSDriver driver, IOSElement element, String comments) {

        Config.logComment("Clear '" + comments + "'");
        element.clear();

    }

    public static void click(IOSDriver driver, IOSElement element, String comments) {
        Config.logComment("Click on '" + comments + "'");
        element.click();
    }

    public static void click(IOSDriver driver, String element, String comments) {

        Config.logComment("Click on '" + comments + "'");
        driver.findElement(By.xpath("//*[@text='" + element + "']")).click();
    }

    public static void back(IOSDriver driver, String comments) {

        Config.logComment("Click on '" + comments + "'");
        driver.navigate().back();
    }

    private static void enterData(IOSDriver driver, IOSElement element, String comments, String data) {

        Config.logComment("Click on '" + comments + "'");
        element.sendKeys(data);
    }


    public static void waitForElementToVisibleOnPage(IOSDriver driver, MobileElement element, int totalTimeToWaitInSeconds) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, totalTimeToWaitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            Config.logComment(element + "- Element is not visible");
            Config.logComment(e.getMessage());
        }

    }

    public static void waitForElementToVisibleOnPageUsingText(IOSDriver driver, String element, int totalTimeToWaitInSeconds) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, totalTimeToWaitInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='" + element + "']")));
        } catch (TimeoutException e) {
            Config.logComment(element + "- Element is not visible");
            Config.logComment(e.getMessage());
        }

    }

    public static boolean isElementPresent(IOSDriver driver, IOSElement element) throws InterruptedException {
        Thread.sleep(1000);
        try {
            waitForElementToVisibleOnPage(driver, element, 3);
            element.isDisplayed();
            Config.logComment(element + "- element is displayed");
            return true;

        } catch (NoSuchElementException e) {
            Config.logComment(element + "- element is not displayed");
            return false;
        }

    }

    public static boolean isElementPresent(IOSDriver driver, String element) throws InterruptedException {
        Thread.sleep(1000);
        try {
            waitForElementToVisibleOnPageUsingText(driver, element, 3);
            driver.findElement(By.xpath("//*[@text='" + element + "']")).isDisplayed();
            Config.logComment(element + "- element is displayed");
            return true;

        } catch (NoSuchElementException e) {
            Config.logComment(element + "- element is not displayed");
            return false;
        }

    }

    public static boolean isElementEnabled(IOSDriver driver, IOSElement element) throws InterruptedException {
        Thread.sleep(1000);
        try {
            waitForElementToVisibleOnPage(driver, element, 3);
            element.isEnabled();
            Config.logComment(element + "- element is enabled");
            return true;

        } catch (NoSuchElementException e) {
            Config.logComment(element + "- element is not enabled");
            return false;
        }

    }

    public static String getText(IOSDriver driver, IOSElement element) throws InterruptedException {
        isElementPresent(driver, element);
        String text;
        text = element.getText().toString();
        return text;
    }

    public static String getText(IOSDriver driver, IOSElement element, String comments) throws InterruptedException {
        isElementPresent(driver, element);
        String text;
        Log.info("Get Text | " + comments);
        text = element.getText().toString();
        return text;
    }

    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public IOSElement findElement(WebDriver driver, By locator) {
        try {
            IOSElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
            Log.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
            throw e;
        }
    }

    /**
     * method to find all the elements of specific locator
     *
     * @param locator element to be found
     * @return return the list of elements if found else throws
     * NoSuchElementException
     */
    public static List<IOSElement> findElements(IOSDriver driver, By locator) {
        try {
            List<IOSElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    //Tap by coordinates
    public static void tapByCoordinates(int x, int y, IOSDriver driver) {
        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    //Press by coordinates
    public static void pressByCoordinates(int x, int y, long seconds, IOSDriver driver) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

}


