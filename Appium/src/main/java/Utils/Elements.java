package Utils;

import Logger.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements extends TestBase {

    AndroidDriver driver;

    public Elements(AndroidDriver driver) {
        this.driver = driver;
    }

    public static void selectElement(AndroidDriver driver, AndroidElement element, String comments) {

        waitForElementToVisibleOnPage(driver, element, 10);
        click(driver, element, comments);
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

}


