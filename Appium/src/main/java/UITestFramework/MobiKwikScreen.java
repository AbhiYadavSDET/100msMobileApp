package UITestFramework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MobiKwikScreen extends MBReporter {

    AndroidDriver<AndroidElement> driver = null;
    public final int timeOut = 70;
    // Configure the Action
    Actions action;

    public MobiKwikScreen(AndroidDriver driver) {
        super(driver, "testScreenshotDir");
        this.driver = driver;
        //action = new Actions(driver);
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the
     *                              activity.
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException {
        Thread.sleep(2000);
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }


    /**
     * Added by MS @16th Aug,2018 for clicking on the ANDROID done button
     */
    public void androidDone() throws InterruptedException {


        try {
            selectElement(By.xpath("//android.widget.FrameLayout[@index = '0']/android.widget.ImageView[@id = 'icon']"));
        } catch (Exception e) {
            Log.info("No Keyboard present");
        }


    }

    /**
     * Added by MS @16th Aug,2018 for clicking on the ANDROID done button
     */
    public void navigateBack() throws InterruptedException {

        driver.navigate().back();

    }

    /**
     * Added by MS @16th Aug,2018 for clicking on the ANDROID done button
     */
    public void navigateUp() throws InterruptedException {


        try {
            selectElement(By.xpath("//android.widget.FrameLayout[@index = '0']/android.widget.ImageView[@id = 'icon']"));
        } catch (Exception e) {
            Log.info("No Keyboard present");
        }


    }


    /**
     * method to go to Home by Android Native Home click
     */
    public void iosBack(String arg1) {
// Test
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public boolean waitForVisibility(By targetElement) {
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
    public boolean waitForInvisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is still visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw e;

        }
    }

    /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(double xPosition, double yPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }

    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public AndroidElement findElement(By locator) {
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
    public List<AndroidElement> findElements(By locator) {
        try {
            List<AndroidElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
            Log.logError(this.getClass().getName(), "findElements", "element not found" + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            throw new NoAlertPresentException();
        }
    }

    /**
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false
     */
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            throw new NoAlertPresentException();
        }
    }

    /**
     * method to Accept Alert if alert is present
     */

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    /**
     * method to Dismiss Alert if alert is present
     */

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    /**
     * method to get network settings
     */
    public void getNetworkConnection() {
        // System.out.println(((AndroidDriver) driver).getNetworkConnection());

    }


    public void selectElement(By target) throws InterruptedException {
        waitForVisibility(target);
        //Element.click(driver,findElement(target), "Element Clicked");
        findElement(target).click();
    }

    public int selectElementWithSS(By target, String directoryName, String screenName, int ssCount)
            throws InterruptedException {
        waitForVisibility(target);

        screenShot1(directoryName, screenName + "_" + ++ssCount);

        findElement(target).click();

        return ssCount;
    }


    /**
     * method to swipe on the screen on provided coordinates
     *
     * @param startX   - start X coordinate to be tapped
     * @param endX     - end X coordinate to be tapped
     * @param startY   - start y coordinate to be tapped
     * @param endY     - end Y coordinate to be tapped
     * @param duration duration to be tapped
     */

    public void swipe(double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);

    }

    @SuppressWarnings("unchecked")
    public void swipeCustom(double startX, double startY, double endX, double endY, double duration) {

    }

    public void swipeTarget(WebElement target) {
        int topY = target.getLocation().getY();
        int bottomY = topY + target.getSize().getHeight();
        int centerX = target.getLocation().getX() + (target.getSize().getWidth() / 2);
        // ((AppiumDriver) driver).swipe(centerX, bottomY, centerX, topY, 3000);
    }

    /**
     * Scroll to the element whose 'text' attribute contains the input text. This
     * scrolling happens within the first UIATableView on the UI. Use the method on
     * AndroidElement to scroll from a different ScrollView.
     *
     * @param text
     *            input text contained in text attribute
     */

    /**
     * Scroll forward to the element which has a description or name which contains
     * the input text. The scrolling is performed on the first scrollView present on
     * the UI
     *
     * @param text text of the element text to be found
     */

    public void scrollTo(String text) {
        try {
            // ((AppiumDriver) driver).scrollTo(text);
            Log.info("Scroll Done for element: " + text);
        } catch (NoSuchElementException e) {
            Log.logError(this.getClass().getName(), "findElement", "Element not found with Scroll" + text);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /**
     * Scroll forward to the element which has a description or name which exactly
     * matches the input text. The scrolling is performed on the first scrollView
     * present on the UI
     *
     * @param text - exact text of the element to be found
     */

    public void scrollToExact(String text) {
        try {
            // ((AppiumDriver) driver).scrollToExact(text);
            Log.info("Scroll To Exact Done: " + text);
        } catch (NoSuchElementException e) {
            Log.logError(this.getClass().getName(), "findElement", "Element not found with Scroll To Exact" + text);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
                + ".instance(0));";
    }


    public void swipeLeft(By locator, int duration) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        // element.swipe(SwipeElementDirection.LEFT, duration);

    }

    /**
     * method to Swipe UP on Element By Locator
     *
     * @param locator  - By locator
     * @param duration - Time to swipe
     */

    public void swipeUP(By locator, int duration) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        // element.swipe(SwipeElementDirection.UP, duration);

    }


    public void swipeDOWN(By locator, int duration) {
        MobileElement element = (MobileElement) driver.findElement(locator);
        // element.swipe(SwipeElementDirection.DOWN, duration);

    }

    /**
     * method to maximize Broswer
     */

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }


    // Added @13th June,16
    public String getNumericValue(String text, String identifier) {

        String[] tempSplit = text.split(identifier);

        String temp = tempSplit[(tempSplit.length) - 1];
        // Log.info("Numeric Value : " + temp);

        return temp;
    }

    /*
     * Added by MS @16th Jan,2018 All the helpers for Action class To be used for
     * Web Automation
     */

    public void moveToElement(WebElement targetElement) {
        action.moveToElement(targetElement).build().perform();
    }

    public void moveToElementAndClick(WebElement targetElement) {
        action.moveToElement(targetElement).build().perform();
        action.click(targetElement).perform();

    }

    public void clickAndHold(WebElement targetElement) {
        action.clickAndHold(targetElement).perform();

    }

    public void doubleClick(WebElement targetElement) {
        action.doubleClick(targetElement).perform();

    }

    public void contextClick(WebElement targetElement) {
        action.contextClick(targetElement).perform();

    }

    /*
     * Added by MS @19th Jan,2018 for select an elemnt from the <Select> list
     */
    public void selectByVisibleText(By locator, String text) {
        WebElement mySelectElement = driver.findElement(locator);
        Select dropdown = new Select(mySelectElement);

        dropdown.selectByVisibleText(text);

    }

    public void selectByIndex(By locator, int index) {
        WebElement mySelectElement = driver.findElement(locator);
        Select dropdown = new Select(mySelectElement);

        dropdown.selectByIndex(index);
    }

    /*
     * Added by MS @22nd Jan,2018 for select an element from the non <Select> list
     */

    public AndroidElement getElementByIndex(By locator, int index) {
        List<AndroidElement> myList = new ArrayList<>();
        myList = driver.findElements(locator);

        Log.info(myList.get(index).getText());
        return myList.get(index);

    }

    public String getURL() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;

    }


    /*
    Added by MS @29thJune,2018 for adding the iOS driver wait
     */
    public void iosDriverWait(int duration, By locator) {

        new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(locator));


    }

    /*
   Added by MS @9thJuly,2018 for empting a field
    */
    public void emptyFieldAndEnterText(By locator, String text) {
        Log.info("CLEAR        | Field");
        driver.findElement(locator).clear();

        Log.info("ENTER        | Text");
        driver.getKeyboard().sendKeys(text);

    }

    /*
   Added by MS @9thJuly,2018 for empting a field
    */
    public void enterText(String text) {

        driver.getKeyboard().sendKeys(text);

    }

    /*
   Added by MS @30thJuly,2018 for getting the size of the window
    */
    public Dimension getWindowSize() {

        Dimension windowSize = driver.manage().window().getSize();
        return windowSize;

    }

    /*
 Added by MS @30thJuly,2018 for getting the size of the window
  */
    public void getContext() {

        Log.info(driver.getContext());

    }

    /*
Added by MS @19thSept,2018 for clubbing waitforvisibility + gettext()
*/
    public String getText(By locator) {

        waitForVisibility(locator);
        String text = driver.findElement(locator).getText();

        return text;
    }

    /*
Added by MS @19thSept,2018 for clubbing waitforvisibility + gettext()
*/
    public void sendText(By locator, String text) {

        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(text);

    }

    public void hideKeyboard() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.isKeyboardShown()) {
            Log.info("HIDE", "Keyboard");
            driver.hideKeyboard();
        }
    }
}
