package main.java.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;

import java.time.Duration;

public class Screen {


    static TouchAction touchAction;
    AndroidDriver driver;


    public Screen(AndroidDriver androidDriver) {
        this.driver = androidDriver;
        touchAction = new TouchAction(driver);
    }


    /**
     * swipes the screen-up
     */
    public static void swipeUp() {
        Log.info("SWIPE", "Up");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(400, 500)).release().perform();
    }

    /**
     * swipes the screen-down
     */
    public static void swipeDown() {
        Log.info("SWIPE", "Up");
        touchAction.press(PointOption.point(400, 500)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(400, 1000)).release().perform();
    }

    /**
     * swipes the screen-up as per user's start/End point
     *
     * @param yStart   starting yoffset
     * @param yEnd     ending yoffset
     * @param duration
     */
    public static void swipeVertical(int yStart, int yEnd, int duration) {
        Log.info("SWIPE", "Vertical");
        touchAction.press(PointOption.point(400, yStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(400, yEnd)).release().perform();
    }

    public static boolean isKeyboardShown(AndroidDriver androidDriver) throws InterruptedException {
        Thread.sleep(2000);
        return androidDriver.isKeyboardShown();
    }

    public static void hideKeyboard(AndroidDriver androidDriver) throws InterruptedException {
        if (isKeyboardShown(androidDriver)) {
            androidDriver.hideKeyboard();
        }
    }

    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
