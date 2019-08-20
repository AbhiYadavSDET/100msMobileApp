package main.java.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
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
    io.appium.java_client.ios.IOSDriver IOSDriver;

    public Element(IOSDriver IOSDriver) {
        this.IOSDriver = IOSDriver;
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public static boolean waitForVisibility(IOSDriver driver, MobileElement targetElement) {
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

    public static boolean waitForVisibility(IOSDriver driver, By targetElement) {
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
    public static boolean waitForInvisibility(IOSDriver driver, IOSElement targetElement) {
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

    /**
     * method verify whether element is present on screen
     *
     * @param IOSDriver
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the
     *                              activity.
     */
    public static Boolean isElementPresent(IOSDriver IOSDriver, By targetElement) throws InterruptedException {
        Thread.sleep(2000);
        Boolean isPresent = findElements(IOSDriver, targetElement).size() > 0;
        return isPresent;

    }

    public static void click(IOSDriver driver, IOSElement IOSElement, String description) {
        try {
            Log.info("CLICK", description);
            IOSElement.click();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * This Method is used to waitForVisibility + click
     *
     * @param driver
     * @param IOSElement
     * @param description
     */
    public static void selectElement(IOSDriver driver, IOSElement IOSElement, String description) {
        waitForVisibility(driver, IOSElement);
        click(driver, IOSElement, description);
    }

    public static void enterText(IOSDriver driver, IOSElement IOSElement, String text, String description) {
        waitForVisibility(driver, IOSElement);

        Log.info("ENTER", description);
        IOSElement.sendKeys(text);
    }

    public static void clearText(IOSDriver driver, IOSElement IOSElement, String text, String description) {
        waitForVisibility(driver, IOSElement);

        Log.info("CLEAR", description);
        IOSElement.clear();
    }

    /**
     * This Method is used to waitForVisibility + click
     *
     * @param driver
     * @param IOSElement
     * @param description
     * @return The text of the element
     */
    public static String getText(IOSDriver driver, IOSElement IOSElement, String description) {
        waitForVisibility(driver, IOSElement);

        Log.info("GET", description);
        return IOSElement.getText();
    }


}
