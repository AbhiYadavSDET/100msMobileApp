//package utils.Listeners;
//
//import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
//import logger.Log;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import utils.TestBase;
//
//public class AppiumDriverListeners extends TestBase implements AppiumWebDriverEventListener {
//
//    private By lastFindBy;
//    private WebElement lastElement;
//
//
//    @Override
//    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeAlertAccept(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterAlertAccept(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterAlertDismiss(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeAlertDismiss(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeNavigateTo(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterNavigateTo(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeNavigateBack(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterNavigateBack(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeNavigateForward(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterNavigateForward(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeNavigateRefresh(WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterNavigateRefresh(WebDriver webDriver) {
//
//    }
//
////    @Override
////    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
////        lastFindBy = by;
////        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true")) {
////            Log.info("Trying to find: '" + lastFindBy + "'.");
////        }
////    }
////
////    @Override
////    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
////        lastFindBy = by;
////        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true")) {
////            Log.info("Found: '" + lastFindBy + "'.");
////        }
////    }
////
////    @Override
////    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
////        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true")) {
////            Log.info("Trying to Click: '" + lastFindBy + "'.");
////        }
////    }
////
////    @Override
////    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
////        if (properties.getProperty("DebugMode").trim().equalsIgnoreCase("true")) {
////            Log.info("Clicked: '" + lastFindBy + "'.");
////        }
////    }
//
//    @Override
//    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
//
//    }
//
//    @Override
//    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
//
//    }
//
//    @Override
//    public void beforeScript(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterScript(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterSwitchToWindow(String s, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void onException(Throwable throwable, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
//
//    }
//
//    @Override
//    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
//
//    }
//
//    @Override
//    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
//
//    }
//
//    @Override
//    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
//
//    }
//}
