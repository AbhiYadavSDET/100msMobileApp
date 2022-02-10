package Utils.Listeners;

import io.appium.java_client.events.api.general.ElementEventListener;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementListener implements ElementEventListener {

    private By lastFindBy;
    private WebElement lastElement;

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Log.info("Trying to find: '" + lastFindBy + "'.");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        Log.info("Found: '" + lastFindBy + "'.");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
