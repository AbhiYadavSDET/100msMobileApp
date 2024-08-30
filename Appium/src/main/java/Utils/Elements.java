package Utils;

import Logger.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Elements extends TestBase {

    private static Screen screen;
    AndroidDriver driver;

    public Elements(AndroidDriver driver) {
        this.driver = driver;
        screen = new Screen(driver);
    }

    public static String selectElement(AndroidDriver driver, AndroidElement element, String comments) {

        waitForElementToVisibleOnPage(driver, element, 10);
        click(driver, element, comments);
        return comments;
    }

    public static void selectElement(AndroidDriver driver, String element, String comments) {

        waitForElementToVisibleOnPageUsingText(driver, element, 10);
        click(driver, element, comments);
    }

    public static void enterToElement(AndroidDriver driver, AndroidElement element, String data, String comments) {

        waitForElementToVisibleOnPage(driver, element, 10);
        enterData(driver, element, comments, data);
    }

    public static void clearText(AndroidDriver driver, AndroidElement element, String comments) {

        Config.logComment("Clear '" + comments + "'");
        element.clear();

    }

    private static void click(AndroidDriver driver, AndroidElement element, String comments) {

        Config.logComment("Click on '" + comments + "'");
        element.click();
    }

    public static void click(AndroidDriver driver, String element, String comments) {


        Config.logComment("Click on '" + comments + "'");
        driver.findElement(By.xpath("//*[@text='" + element + "']")).click();
    }

    public static void back(AndroidDriver driver, String comments) {

        Config.logComment("Click on '" + comments + "'");
        driver.navigate().back();
    }

    private static void enterData(AndroidDriver driver, AndroidElement element, String comments, String data) {

        Config.logComment("Click on '" + comments + "'");
        element.sendKeys(data);
    }


    public static void waitForElementToVisibleOnPage(AndroidDriver driver, MobileElement element, int totalTimeToWaitInSeconds) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, totalTimeToWaitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            Config.logComment(element + "- Element is not visible");
            Config.logComment(e.getMessage());
        }

    }

    public static void waitForElementToVisibleOnPageUsingText(AndroidDriver driver, String element, int totalTimeToWaitInSeconds) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, totalTimeToWaitInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='" + element + "']")));
        } catch (TimeoutException e) {
            Config.logComment(element + "- Element is not visible");
            Config.logComment(e.getMessage());
        }

    }

    public static boolean isElementPresent(AndroidDriver driver, AndroidElement element) throws InterruptedException {
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

    public static boolean isElementPresent(AndroidDriver driver, String element) throws InterruptedException {
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

    public static boolean isElementPresentNoWait(AndroidDriver driver, AndroidElement element) throws InterruptedException {
        try {
            waitForElementToVisibleOnPage(driver, element, 1);
            element.isDisplayed();
            Config.logComment(element + "- element is displayed");
            return true;

        } catch (NoSuchElementException e) {
            Config.logComment(element + "- element is not displayed");
            return false;
        }

    }

    public static boolean scrollToElement(AndroidDriver driver, AndroidElement element) throws InterruptedException {
        int i = 0;
        while(!isElementPresentNoWait(driver, element)){
            screen.swipeUpMore(driver);
            i++;
            if(i > 6){
                return false;
            }
        }
        return true;
    }

    public static boolean isElementEnabled(AndroidDriver driver, AndroidElement element) throws InterruptedException {
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

    public static String getText(AndroidDriver driver, AndroidElement element) throws InterruptedException {
        isElementPresent(driver, element);
        String text;
        text = element.getText().toString();
        return text;
    }

    public static String getText(AndroidDriver driver, AndroidElement element, String comments) throws InterruptedException {
        isElementPresent(driver, element);
        String text;
        Log.info("Get Text | " + comments);
        text = element.getText().toString();
        return text;
    }

    //Tap by coordinates
    public static void tapByCoordinates(int x, int y, AndroidDriver driver) {
        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    //Press by coordinates
    public static void pressByCoordinates(int x, int y, long seconds, AndroidDriver driver) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

}


