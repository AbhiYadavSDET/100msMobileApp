package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element {
    public final static int timeOut = 70;
    AndroidDriver androidDriver;

    public Element(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public static boolean waitForVisibility(AndroidDriver driver, MobileElement targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw e;

        }
    }

    public static boolean waitForVisibility(AndroidDriver driver, By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw e;

        }
    }

    /**
     * method to wait for an element until it is invisible
     *
     * @param targetElement element to be invisible
     * @return true if element gets invisible else throws TimeoutException
     */
    public static boolean waitForInvisibility(AndroidDriver driver, AndroidElement targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOf(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is still visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw e;

        }
    }

    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public AndroidElement findElement(WebDriver driver, By locator) {
        try {
            AndroidElement element = driver.findElement(locator);
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
    public static List<AndroidElement> findElements(AndroidDriver driver, By locator) {
        try {
            List<AndroidElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /**
     * method verify whether element is present on screen
     *
     * @param androidDriver
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the
     *                              activity.
     */
    public static Boolean isElementPresent(AndroidDriver androidDriver, By targetElement) throws InterruptedException {
        Thread.sleep(2000);
        Boolean isPresent = findElements(androidDriver, targetElement).size() > 0;
        return isPresent;

    }

    public static void click(AndroidDriver driver, AndroidElement androidElement, String description) {
        try {
            Log.info("CLICK", description);
            androidElement.click();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * This Method is used to waitForVisibility + click
     *
     * @param driver
     * @param androidElement
     * @param description
     */
    public static void selectElement(AndroidDriver driver, AndroidElement androidElement, String description) {
        waitForVisibility(driver, androidElement);
        click(driver, androidElement, description);
    }

    public static void enterText(AndroidDriver driver, AndroidElement androidElement, String text, String description) {
        waitForVisibility(driver, androidElement);

        Log.info("ENTER", description);
        androidElement.sendKeys(text);
    }

    public static void clearText(AndroidDriver driver, AndroidElement androidElement, String text, String description) {
        waitForVisibility(driver, androidElement);

        Log.info("CLEAR", description);
        androidElement.clear();
    }

    /**
     * This Method is used to waitForVisibility + click
     *
     * @param driver
     * @param androidElement
     * @param description
     * @return The text of the element
     */
    public static String getText(AndroidDriver driver, AndroidElement androidElement, String description) {
        waitForVisibility(driver, androidElement);

        Log.info("GET", description);
        return androidElement.getText();
    }


}