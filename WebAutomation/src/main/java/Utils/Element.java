package Utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Element extends TestBase {

    public static enum How {
        className, css, id, linkText, name, partialLinkText, tagName, xPath, accessibility
    }

    ;

    /**
     * This Method is used to click on checkbox
     *
     * @param driver
     * @param element     WebElement to be checked
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void clickOnCheckbox(WebDriver driver, WebElement element, String description) {
        Config.logComment("Check '" + description + "'");
        if (!element.isSelected()) {
            try {
                clickWithoutLog(driver, element);
                Browser.wait(driver, 1);
            } catch (StaleElementReferenceException e) {
                Config.logComment("Stale element reference exception. Trying again...");
                clickWithoutLog(driver, element);
            }

        }
    }

    /**
     * This Method is used to Click without logging
     *
     * @param driver
     * @param element
     * @author manojkumar
     */
    private static void clickWithoutLog(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(false)", element);
            element.click();
        } catch (WebDriverException wde) {
            element.click();
        }
    }

    /**
     * This Method is used to clear Text
     *
     * @param driver
     * @param element     WebElement to be cleared
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void clearText(WebDriver driver, WebElement element, String description) {
        Config.logComment("Clear data of '" + description + "'");
        element.clear();

    }

    /**
     * This Method is used to click on element
     *
     * @param driver
     * @param element     WebElement to be clicked
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void click(WebDriver driver, WebElement element, String description) {

        Config.logComment("Click on '" + description + "'");

        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(false)", element);
        } catch (WebDriverException wde) {
        }

        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");

            element.click();

        } catch (UnreachableBrowserException e) {
            Config.logWarning(e.toString());
        }


    }

    /**
     * This Method is used to waitForElementToVisibleOnPage + click
     *
     * @param driver
     * @param element
     * @author manojkumar
     */
    public static void selectElement(WebDriver driver, WebElement webElement, String description) {
        Browser.waitForElementToVisibleOnPage(driver, webElement, 30);
        click(driver, webElement, description);
    }

    /**
     * This Method is used to waitForElementToVisibleOnPage + enterText
     *
     * @param driver
     * @param element
     * @author manojkumar
     */
    public static void enterText(WebDriver driver, WebElement webElement, String value, String description) {
        Browser.waitForElementToVisibleOnPage(driver, webElement, 30);
        enterData(driver, webElement, value, description);
    }

    /**
     * This Method is used to waitForElementToVisibleOnPage + enterText
     *
     * @param element
     * @param driver
     * @author manojkumar
     */
    public static String fetchText(WebDriver driver, WebElement webElement, String description) {
        Browser.waitForElementToVisibleOnPage(driver, webElement, 30);
        return getText(driver, webElement, description);
    }

    /**
     * This Method is used to Click on element using JavaScript
     *
     * @param driver
     * @param elementToBeClicked - Element to be clicked
     * @param description        For logging
     * @author manojkumar
     */
    public static void clickThroughJS(WebDriver driver, WebElement element, String description) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
        Config.logComment("Clicked on " + description);

    }

    /**
     * This Method is used to double click on element
     *
     * @param driver
     * @param element     WebElement to be double clicked
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void doubleClick(WebDriver driver, WebElement element, String description) {
        Config.logComment("Double Click on '" + description + "'");
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    /**
     * This Method is used to Enter the given 'value'in the specified WebElement
     *
     * @param driver
     * @param element     WebElement where data needs to be entered
     * @param value       value to the entered
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void enterData(WebDriver driver, WebElement element, String value, String description) {
        if (!value.equalsIgnoreCase("{skip}")) {

            // encode the html characters so that they get printed correctly
            String message = StringUtils.replaceEach(value, new String[]{"&", "\"", "<", ">"}, new String[]{"&amp;", "&quot;", "&lt;", "&gt;"});
            Config.logComment("Enter the " + description + " as '" + message + "'");
            element.clear();
            element.sendKeys(value);

        } else {
            Config.logComment("Skipped data entry for " + description);
        }
    }

    /**
     * This Method is used to Enter the given 'value'in the specified WebElement after clicking on it
     *
     * @param driver
     * @param element     WebElement where data needs to be entered
     * @param value       value to the entered
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void enterDataAfterClick(WebDriver driver, WebElement element, String value, String description) {
        if (!value.equalsIgnoreCase("{skip}")) {
            // encode the html characters so that they get printed correctly
            String message = StringUtils.replaceEach(value, new String[]{"&", "\"", "<", ">"}, new String[]{"&amp;", "&quot;", "&lt;", "&gt;"});
            Config.logComment("Enter the " + description + " as '" + message + "'");
            clickWithoutLog(driver, element);
            element.clear();
            Browser.wait(driver, 1);
            element.sendKeys(value);

        } else {
            Config.logComment("Skipped data entry for " + description);
        }
    }

    /**
     * This Method is used to Enter the given 'value'in the specified WebElement without clear
     *
     * @param driver
     * @param element     WebElement where data needs to be entered
     * @param value       value to the entered
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void enterDataWithoutClear(WebDriver driver, WebElement element, String value, String description) {
        if (!value.equalsIgnoreCase("{skip}")) {
            // encode the html characters so that they get printed correctly
            String message = StringUtils.replaceEach(value, new String[]{"&", "\"", "<", ">"}, new String[]{"&amp;", "&quot;", "&lt;", "&gt;"});
            Config.logComment("Enter the " + description + " as '" + message + "'");
            element.sendKeys(value);

        } else {
            Config.logComment("Skipped data entry for " + description);
        }
    }


    /**
     * This Method is used to find element in iFrame
     *
     * @param driver
     * @author manojkumar
     */
    private static WebElement findiFrameElement(WebDriver driver, How how, String what) {
        List<WebElement> frames = getiFramesOnPage(driver);
        if (frames.isEmpty())
            return null;
        WebElement element = null;

        for (WebElement fr : frames) {
            if (element != null) {
                return element;
            }

            try {
                driver.switchTo().frame(fr);
            } catch (StaleElementReferenceException e) {
                Config.logComment("Stale element reference exception. Trying again...");
                driver.switchTo().defaultContent();
                try {
                    driver.switchTo().frame(fr);
                } catch (StaleElementReferenceException ex) {
                    Config.logWarning(ex.toString());
                }
            }

            element = getPageElement(driver, how, what);

            if (element == null) {
                element = findiFrameElement(driver, how, what);
            }
        }

        return element;
    }

    /**
     * This Method is used to Get all the available string options in the Select Element
     *
     * @param driver
     * @param element Select WebElement
     * @return String list of options
     * @author manojkumar
     */
    public static List<String> getAllOptionsInSelect(WebDriver driver, WebElement element) {
        Config.logComment("Retrieve all the Options present for this specified Select WebElement");
        Select sel = new Select(element);
        List<WebElement> elements = sel.getOptions();
        List<String> options = new ArrayList<String>(elements.size());

        for (WebElement e : elements) {
            options.add(e.getText());
        }
        return options;
    }

    /**
     * This Method is used to Retrieve all the values(atribute=value) present for this specified Select WebElement
     *
     * @param driver
     * @param element Select WebElement
     * @return String list of options
     * @author manojkumar
     */
    public static List<String> getAllValuesInSelect(WebDriver driver, WebElement element) {
        Config.logComment("Retrieve all the values(atribute=value) present for this specified Select WebElement");
        Select sel = new Select(element);
        List<WebElement> elements = sel.getOptions();
        List<String> options = new ArrayList<String>(elements.size());

        for (WebElement e : elements) {
            options.add(e.getAttribute("value"));
        }
        return options;
    }

    /**
     * This Method is used to Get all the selected options in the Select Element
     *
     * @param driver
     * @param element Select WebElement
     * @return String list of options
     * @author manojkumar
     */
    public static List<String> getAllSelectedOptions(WebDriver driver, WebElement element) {
        Config.logComment("Retrieve all the Options selected for this specified Select WebElement");
        Select sel = new Select(element);


        List<WebElement> elements = sel.getAllSelectedOptions();
        List<String> options = new ArrayList<String>(elements.size());

        for (WebElement e : elements) {
            options.add(e.getText());
        }
        return options;
    }

    /**
     * This Method is used to get the first selected option in this select web element
     *
     * @param driver
     * @param element WebElement whose first selected value is to be read
     * @return
     * @author manojkumar
     */
    public static WebElement getFirstSelectedOption(WebDriver driver, WebElement element, String description) {
        Config.logComment("Get the first selected value for " + description);
        try {

            Select sel = new Select(element);
            return sel.getFirstSelectedOption();
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");
            Select sel = new Select(element);
            return sel.getFirstSelectedOption();
        }

    }


    /**
     * This Method is used to all iFrame on page
     *
     * @param driver
     * @author manojkumar
     */
    private static List<WebElement> getiFramesOnPage(WebDriver driver) {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        return iframes;
    }

    /**
     * This Method is used to get the list of WebElements using the specified locator technique on the
     * passed driver page
     *
     * @param driver
     * @param how    Locator technique to use
     * @param what   element to be found with given technique (any arguments in
     *               this string will be replaced with run time properties)
     * @return List of WebElements Found
     * @author manojkumar
     */
    public static List<WebElement> getListOfElements(WebDriver driver, How how, String what) {
        Config.logComment("Get the List of WebElements with " + how + ":" + what);
        try {
            switch (how) {
                case className:
                    return driver.findElements(By.className(what));
                case css:
                    return driver.findElements(By.cssSelector(what));
                case id:
                    return driver.findElements(By.id(what));
                case linkText:
                    return driver.findElements(By.linkText(what));
                case name:
                    return driver.findElements(By.name(what));
                case partialLinkText:
                    return driver.findElements(By.partialLinkText(what));
                case tagName:
                    return driver.findElements(By.tagName(what));
                case xPath:
                    return driver.findElements(By.xpath(what));
                default:
                    return null;
            }
        } catch (StaleElementReferenceException e1) {
            Config.logComment("Stale element reference exception. Trying again...");
            // retry
            return getListOfElements(driver, how, what);
        } catch (Exception e) {
            Config.logWarning("Could not find the list of the elements on page");
            return null;
        }
    }

    /**
     * This Method is used to getting out of frame
     *
     * @param driver
     * @author manojkumar
     */
    public static void getOutOfFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /**
     * This Method is used to gets the WebElement using the specified locator technique on the passed
     * driver page
     *
     * @param driver
     * @param how                              Locator technique to use
     * @param what                             element to be found with given technique (any arguments in
     *                                         this string will be replaced with run time properties)
     * @param isTestCaseFailedIfNoSuchExcetion ---> true : If NoSuchElement exception is thrown then test case will be failed immediately
     *                                         ---> false : If NoSuchElement exception is thrown then test case will never failed
     * @return found WebElement
     * @author manojkumar
     */
    public static WebElement getPageElement(WebDriver driver, How how, String what, Boolean isTestCaseFailedIfNoSuchExcetion) {
        try {
            switch (how) {
                case className:
                    return driver.findElement(By.className(what));
                case css:
                    return driver.findElement(By.cssSelector(what));
                case id:
                    return driver.findElement(By.id(what));
                case linkText:
                    return driver.findElement(By.linkText(what));
                case name:
                    return driver.findElement(By.name(what));
                case partialLinkText:
                    return driver.findElement(By.partialLinkText(what));
                case tagName:
                    return driver.findElement(By.tagName(what));
                case xPath:
                    return driver.findElement(By.xpath(what));
                default:
                    return null;
            }
        } catch (StaleElementReferenceException e1) {
            Config.logComment("Stale element reference exception. Trying again...");
            // retry
            Browser.wait(driver, 3);
            Config.logComment("Retrying getting element" + how + ":" + what);
            return getPageElement(driver, how, what);
        } catch (NoSuchElementException e) {
            Config.logWarning("Could not find the element on page");
            return null;
        }

    }

    /**
     * This Method is used to fetch text
     *
     * @param driver
     * @param how         locator strategy to find element
     * @param what        element locator
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @return
     * @author manojkumar
     */
    public static String getText(WebDriver driver, How how, String what, String description) {
        Config.logComment("Get text of '" + description + "'");
        String text = null;
        try {
            WebElement elm = Element.getPageElement(driver, how, what);
            text = Element.getText(driver, elm, description);
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");
            WebElement elm = Element.getPageElement(driver, how, what);
            text = Element.getText(driver, elm, description);

        }
        return text;
    }

    /**
     * This Method is used to fetch text
     *
     * @param driver
     * @param element     WebElement whose text is needed
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static String getText(WebDriver driver, WebElement element, String description) {
        Config.logComment("Get text of '" + description + "'");
        String text = null;
        try {
            text = element.getText();
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");

            text = element.getText();

        }
        return text;
    }


    /**
     * This Method is used to verify if element is displayed
     *
     * @param driver
     * @author manojkumar
     */
    public static Boolean IsElementDisplayed(WebDriver driver, WebElement element) {
        Boolean visible = true;
        if (element == null)
            return false;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            visible = element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            visible = element.isDisplayed();

        } catch (NoSuchElementException e) {
            visible = false;
        } catch (ElementNotVisibleException e) {
            visible = false;
        } finally {
            Long ObjectWaitTime = Long.parseLong(properties.getProperty("ImplicitWaitTime"));
            driver.manage().timeouts().implicitlyWait(ObjectWaitTime, TimeUnit.SECONDS);
        }
        return visible;
    }

    /**
     * This Method is used to verify if element is enabled
     *
     * @param driver
     * @author manojkumar
     */
    public static Boolean IsElementEnabled(WebDriver driver, WebElement element) {
        Boolean visible = true;
        if (element == null)
            return false;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            visible = element.isEnabled();
        } catch (StaleElementReferenceException e) {
            Config.logComment("Stale element reference exception. Trying again...");
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            visible = element.isDisplayed();

        } catch (NoSuchElementException e) {
            visible = false;
        } catch (ElementNotVisibleException e) {
            visible = false;
        }

        return visible;
    }

    /**
     * This Method is used to press the given Key in the specified WebElement
     *
     * @param driver
     * @param element     Filename WebElement where data needs to be entered
     * @param Key         key to the entered
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void KeyPress(WebDriver driver, WebElement element, Keys key, String description) {
        Config.logComment("Press the key '" + key.toString() + "' on " + description + "");
        element.sendKeys(key);

    }

    /**
     * This Method is used to select the given 'value' attribute for the specified WebElement
     *
     * @param driver
     * @param element     WebElement to select
     * @param value       value to the selected
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void selectValue(WebDriver driver, WebElement element, String value, String description) {
        if (!value.equalsIgnoreCase("{skip}")) {
            Config.logComment("Select the " + description + " dropdown value '" + value + "'");

            Select sel = new Select(element);
            sel.selectByValue(value);

        } else {
            Config.logComment("Skipped value selection for " + description);
        }
    }

    /**
     * This Method is used to select the given visible text 'value' for the specified WebElement
     *
     * @param driver
     * @param element     WebElement to select
     * @param value       visible text value to the selected
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void selectVisibleText(WebDriver driver, WebElement element, String value, String description) {
        if (!value.equalsIgnoreCase("{skip}")) {
            Config.logComment("Select the " + description + " dropdown text '" + value + "'");

            Select sel = new Select(element);
            sel.selectByVisibleText(value);

            try {
                sel = new Select(element);
                element.click();
                sel.selectByVisibleText(value);
            } catch (Exception e) {
            }
        } else {
            Config.logComment("Skipped text selection for " + description);
        }
    }

    /**
     * This Method is used to select visible text
     *
     * @param driver
     * @param element     WebElement to select
     * @param value       String of Visible text values to be selected
     * @param description for logging purpose.
     * @author manojkumar
     */
    public static void selectVisibleText(WebDriver driver, WebElement element, String[] value, String description) {
        Select sel = new Select(element);
        sel.deselectAll();
        for (int i = 0; i < value.length; i++) {
            if (!value[i].equalsIgnoreCase("{skip}")) {
                Config.logComment("Select the " + description + " dropdown text '" + value[i] + "'");
                sel.selectByVisibleText(value[i]);
            } else {
                Config.logComment("Skipped text selection for " + description);
            }
        }
    }

    /**
     * This Method is used to submit form
     *
     * @param driver
     * @param element     WebElement to be submitted
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void submit(WebDriver driver, WebElement element, String description) {
        Config.logComment("Submit '" + description + "'");
        element.submit();

    }

    /**
     * This Method is used to uncheck checkbox
     *
     * @param driver
     * @param element     WebElement to be unchecked
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void uncheck(WebDriver driver, WebElement element, String description) {
        Config.logComment("Un-Check '" + description + "'");
        if (element.isSelected()) {
            try {
                clickWithoutLog(driver, element);
            } catch (StaleElementReferenceException e) {
                Config.logComment("Stale element reference exception. Trying again...");
                clickWithoutLog(driver, element);
            }
        }
    }

    /**
     * This Method is used to wait for element to be visible on the page
     *
     * @param driver
     * @param element       element to be searched
     * @param description   logical name of specified WebElement, used for Logging
     *                      purposes in report
     * @param timeInSeconds Polling time
     * @author manojkumar
     */
    public static void waitForVisibility(WebDriver driver, WebElement element, int timeInSeconds, String description) {
        Config.logComment("Wait for element '" + description + "' to be visible on the page.");
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException tm) {
            throw new TimeoutException(description + " not found after waiting for " + timeInSeconds + " seconds");
        }
    }


    /**
     * This Method is used to wait for element to be visible on the page
     *
     * @param driver
     * @param element     element to be searched
     * @param description logical name of specified WebElement, used for Logging
     *                    purposes in report
     * @author manojkumar
     */
    public static void waitForVisibility(WebDriver driver, WebElement element, String description) {
        Config.logComment("Wait for element '" + description + "' to be visible on the page.");
        Long ObjectWaitTime = Long.parseLong(properties.getProperty("ImplicitWaitTime"));
        WebDriverWait wait = new WebDriverWait(driver, ObjectWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException tm) {
            throw new TimeoutException(description + " not found after waiting for " + ObjectWaitTime + " seconds");
        }
    }


    /**
     * This Method is used to press enter key
     *
     * @param driver
     * @author manojkumar
     */
    public static void pressEnter(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    /**
     * This Method is used to get attribute value
     *
     * @param driver
     * @author manojkumar
     */
    public static String getAttribute(WebDriver driver, WebElement element, String attributeName, String comment) {
        Config.logComment("Getting value of attribute '" + attributeName + "' for :" + comment);
        String value = "";
        try {
            value = element.getAttribute(attributeName);
        } catch (Exception wde) {
            Config.logComment("Exception occurred in fetching value of attribute '" + attributeName + "' for :" + comment + " : " + wde.getMessage());
        }

        return value;
    }


    /**
     * This Method is used to select by value in radio group
     *
     * @param driver
     * @param webElements - List of elements
     * @param value       - Value to select
     * @param comment     - Comments
     * @author manojkumar
     */
    public static void selectByValueInRadioGroup(WebDriver driver, List<WebElement> webElements, String value, String comment) {
        Config.logComment("Selecting value '" + value + "' in radio group :" + comment);
        String radioValue = null;
        boolean valueFound = false;
        try {
            for (WebElement element : webElements) {
                radioValue = element.getAttribute("value");
                if (value.equals(radioValue)) {
                    element.click();
                    valueFound = true;
                    break;
                }
            }

            if (!valueFound)
                Config.logFail("Value " + value + " could not found in radio group " + comment);
        } catch (Exception wde) {
            Config.logComment("Exception occurred in selecting value '" + value + "' for :" + comment + " : " + wde.getMessage());
        }
    }


    /**
     * This Method is used to execute javascript on given elements
     *
     * @param driver
     * @param javaScriptToExecute
     * @param element
     * @return result
     * @author manojkumar
     */
    public static Object executeJavaScript(WebDriver driver, String javaScriptToExecute, Object... element) {
        Config.logComment("Execute javascript:-" + javaScriptToExecute);
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        return javaScript.executeScript(javaScriptToExecute, element);
    }


    /**
     * This function is used to scroll an element into view
     *
     * @param driver
     * @param element
     * @param testConfig
     * @author manojkumar
     */
    public static void scrollToView(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(false)", element);

    }


    /**
     * This Method is used to move cursor from one web element to another element
     *
     * @param driver
     * @param source
     * @param destination
     * @author manojkumar
     */
    public static void moveCursorfromSourceToDestination(WebDriver driver, WebElement source, WebElement destination) {
        Actions actions = new Actions(driver);
        actions.moveToElement(source);
        actions.moveToElement(destination);
        actions.click().build().perform();
    }

    /**
     * This Method is used to gets the WebElement using the specified locator technique on the passed
     * driver page
     *
     * @param driver
     * @param how    Locator technique to use
     * @param what   element to be found with given technique (any arguments in
     *               this string will be replaced with run time properties)
     * @return found WebElement
     * @author manojkumar
     */
    public static WebElement getPageElement(WebDriver driver, How how, String what) {
        return Element.getPageElement(driver, how, what, true);
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
    public static Boolean isElementPresent(WebDriver driver, By targetElement) throws InterruptedException {
        Thread.sleep(2000);
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    public static void hoverOn(WebDriver webDriver, WebElement webElement) throws InterruptedException {
        Thread.sleep(2000);
        Element.waitForVisibility(webDriver, webElement, "Hover On");
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }


}
