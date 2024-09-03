package Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import Logger.Log;
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import net.sourceforge.tess4j.util.LoadLibs;
import org.openqa.selenium.Dimension;

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
        touchAction.press(PointOption.point(400, 900)).moveTo(PointOption.point(400, 300)).release().perform();

    }

    public static void swipeUpMoreFromRightSide(AndroidDriver driver) {
        try {
            Thread.sleep(3000);
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.8; //50
            int heightStart = screenHeightStart.intValue();
            Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.2; //20
            int heightEnd = screenHeightEnd.intValue();
            Log.info("End : " + heightEnd);


            Log.info("SWIPE", "Up More");
            touchAction.press(PointOption.point(5, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(5, heightEnd)).release().perform();

        } catch (NullPointerException | InterruptedException e) {
            Log.info("Screen is not Swipable");
        }
    }

    public static void swipeUpMore(AndroidDriver driver) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.8; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.2; //20
            int heightEnd = screenHeightEnd.intValue();

            Double screenRightOffsetEnd = dimension.getWidth() * 0.5; //20
            int rightOffsetEnd = screenRightOffsetEnd.intValue();
            //Log.info("End : " + heightEnd);


            Log.info("SWIPE", "Up More from Right Side");
            touchAction.press(PointOption.point(rightOffsetEnd, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(rightOffsetEnd, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
    }

    public static void swipeUpMedium(AndroidDriver driver) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.6; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.2; //20
            int heightEnd = screenHeightEnd.intValue();
            //Log.info("End : " + heightEnd);

            Double screenRightOffsetEnd = dimension.getWidth() * 0.5; //20
            int rightOffsetEnd = screenRightOffsetEnd.intValue();


            Log.info("SWIPE", "Up Medium");
            touchAction.press(PointOption.point(rightOffsetEnd, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(rightOffsetEnd, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
    }

    public static void swipeUpLess(AndroidDriver driver) {
        try {

            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.4; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.2; //20
            int heightEnd = screenHeightEnd.intValue();
            //Log.info("End : " + heightEnd);

            Double screenRightOffsetEnd = dimension.getWidth() * 0.5; //20
            int rightOffsetEnd = screenRightOffsetEnd.intValue();


            Log.info("SWIPE", "Up Less");
            touchAction.press(PointOption.point(rightOffsetEnd, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(rightOffsetEnd, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
    }


    public static void swipeDownMore(AndroidDriver driver) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.2; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.8; //20
            int heightEnd = screenHeightEnd.intValue();
            //Log.info("End : " + heightEnd);


            Log.info("SWIPE", "Down More");
            touchAction.press(PointOption.point(0, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(0, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
    }

    public static void swipeDownMedium(AndroidDriver driver) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.2; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.6; //20
            int heightEnd = screenHeightEnd.intValue();
            //Log.info("End : " + heightEnd);


            Log.info("SWIPE", "Down Medium");
            touchAction.press(PointOption.point(0, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(0, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
    }

    public static void swipeDownLess(AndroidDriver driver) {
        try {

            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.2; //50
            int heightStart = screenHeightStart.intValue();
            //Log.info("start : " + heightStart);
            Double screenHeightEnd = dimension.getHeight() * 0.4; //20
            int heightEnd = screenHeightEnd.intValue();
            //Log.info("End : " + heightEnd);


            Log.info("SWIPE", "Down Less");
            touchAction.press(PointOption.point(5, heightStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(5, heightEnd)).release().perform();

        } catch (NullPointerException e) {
            Log.info("Screen is not Swipable");
        }
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
/*
    public String readToastMessage(String screenShotDir, String screenShotName) throws TesseractException {
        String imgName = screenShotName;
        String result = null;
        File imageFile = new File(screenShotDir, imgName);
        System.out.println("Image name is :" + imageFile.toString());
        ITesseract instance = new Tesseract();

        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
        // Tessdata
        // folder
        // from
        // referenced
        // tess4j
        // jar
        // for
        // language
        // support
        instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
        // path

        result = instance.
                doOCR(imageFile);
        System.out.println(result);
        return result;
    }

 */

    public static void tapAtCentre(AndroidDriver driver) {
        try {
            int centerX = driver.manage().window().getSize().getWidth() / 2;
            int centerY = driver.manage().window().getSize().getHeight() / 2;

            touchAction.tap(PointOption.point(centerX, centerY)).perform();

            Log.info("Tap", "On Centre");

        } catch (NullPointerException e) {
            Log.info("Screen is not Tapable");
        }
    }
}
