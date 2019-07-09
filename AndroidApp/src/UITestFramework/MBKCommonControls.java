package UITestFramework;

import IntegrationTests.Screens.OnboardingScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MBKCommonControls extends MobiKwikScreen {
    OnboardingScreen onboardingScreen;
    TouchAction touchAction;


    public MBKCommonControls(AndroidDriver driver) {
        super(driver);
        onboardingScreen = new OnboardingScreen(driver);
        touchAction = new TouchAction(driver);
    }

    public void selectElement(By target) throws InterruptedException {
        waitForVisibility(target);
        findElement(target).click();
    }

    public int selectElementWithScreenshot(By target, String directoryName, String screenName, int ssCount)
            throws InterruptedException {
        waitForVisibility(target);
        onboardingScreen.screenShot1(directoryName, screenName + "_" + ++ssCount);
        findElement(target).click();

        return ssCount;
    }

    public LinkedHashMap<String, String> getBalance(String directoryName, String screenName, int ssCount)
            throws InterruptedException {
        LinkedHashMap<String, String> walletBalance = new LinkedHashMap<>();
        Log.info("START", "Fetch Wallet balance");

        // Goto balance details screen
        onboardingScreen.selectElement(By.id("tx_balance"));

        // fetch the balance and add to Map
        onboardingScreen.waitForVisibility(By.xpath("//android.widget.TextView[@text = 'Available Balance']"));
        int noOfBalance = onboardingScreen.findElements(By.xpath("//*/android.widget.ScrollView/android.widget" +
                ".FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")).size();
        Log.info("noOfBalance - " + noOfBalance);

        // Fetch the total balance
        String totalBalanceText = onboardingScreen.findElement(By.id("text_payment_label")).getText().replace(" “",
                "").trim();
        String totalBalanceValue =
                onboardingScreen.findElement(By.id("text_amount")).getText().replace("X", "").replace(",", "");
        walletBalance.put(totalBalanceText, totalBalanceValue);


        // Fetch the rest of the balances
        for (int i = 1; i <= noOfBalance; i++) {


            String balanceText = onboardingScreen.findElement(By.xpath("//*/android.widget.ScrollView/android.widget" +
                    ".FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget" +
                    ".LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android" +
                    ".widget.TextView[@index = '0']")).getText().replace(" “", "").trim();
            String balanceValue = onboardingScreen.findElement(By.xpath("//*/android.widget.ScrollView/android.widget" +
                    ".FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget" +
                    ".LinearLayout[" + i + "]/android.widget.LinearLayout/android.widget.RelativeLayout/android" +
                    ".widget.TextView[@index = '1']")).getText().replace("X", "").replace(",", "");


            walletBalance.put(balanceText, balanceValue);

        }

        // Swipe up
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400,500)).release().perform();
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400,500)).release().perform();


        // Fetch the supercash balance

        if (onboardingScreen.isElementPresent(By.xpath("//android.widget.TextView[@text='SuperCash “']"))) {
            String supercashText = "SuperCash";
            String supercashValue = onboardingScreen.findElement(By.xpath("//android.widget.TextView[@text='SuperCash" +
                    " “']/following::android.widget.TextView[1]")).getText().replace("₹ ", "").replace("X", "").replace("“ ", "").replace(",", "");
            walletBalance.put(supercashText, supercashValue);
        } else {
            String supercashText = "SuperCash";
            String supercashValue = "0";
            walletBalance.put(supercashText, supercashValue);
        }


        Log.info("------------ Balance --------------");

        for (Map.Entry<String, String> e : walletBalance.entrySet()) {
            Log.info(e.getKey(), e.getValue());
        }

        Log.info("-----------------------------------");

        onboardingScreen.selectElement(By.xpath("//*[@text='w']"));


        Log.info("END : Fetch Wallet balance");

        handleUpiPopup();

        return walletBalance;
    }


    public void applyPromocodeRecharge(String promocode) throws InterruptedException {
        onboardingScreen.selectElement(By.id("com.mobikwik_new:id/have_a_promo_text"));

        onboardingScreen.sendText(By.id("com.mobikwik_new:id/edit_text_mket"), promocode);

        onboardingScreen.selectElement(By.xpath("//*[@text='Apply']"));
        Thread.sleep(5000);
    }

    public void applyPromocodeAddMoney(String promocode) throws InterruptedException {
        onboardingScreen.selectElement(By.id("btn_have_promo"));

        onboardingScreen.selectElement(By.xpath("//*/android.widget.TextView[@text = 'Enter Promo " +
                "Code']/following::android.widget.EditText[1]"));
        onboardingScreen.findElement(By.xpath("//*/android.widget.TextView[@text = 'Enter Promo " +
                "Code']/following::android.widget.EditText[1]")).sendKeys(promocode);

        onboardingScreen.selectElement(By.id("button_label"));
        Thread.sleep(3000);
    }

    public void handleSecurityPin(String pin) throws InterruptedException {
        String[] pinArr = pin.split("|");

        if (onboardingScreen.isElementPresent(By.id("lock_rationale_text_view"))) {

            for (String e : pinArr) {
                Log.info("PRESS", e);
                onboardingScreen.selectElement(By.id("btn_pin_" + e));
            }

        }
    }

    public void allowPermission(boolean flag, String permissionName) throws InterruptedException {
        Thread.sleep(4000);
        if (onboardingScreen.isElementPresent(By.id("com.android.packageinstaller:id/dialog_container"))) {
            if (flag) {
                Log.info("ALLOW", permissionName + " permission");
                onboardingScreen.selectElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
            } else {
                Log.info("DENY", permissionName + " permission");
                onboardingScreen.selectElement(By.id("com.android.packageinstaller:id/dialog_container"));
            }
        }
    }

    public void allowPermissionContacts(boolean flag, String permissionName) throws InterruptedException {
        Thread.sleep(4000);
        if (onboardingScreen.isElementPresent(By.name("OK"))) {
            if (flag) {
                Log.info("ALLOW", permissionName + " permission");
                onboardingScreen.selectElement(By.name("OK"));
            } else {
                Log.info("DENY", permissionName + " permission");
                onboardingScreen.selectElement(By.name("Don't Allow"));
            }
        }
    }


    public void allowTouchID(boolean flag, String permissionName) throws InterruptedException {
        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.xpath("//*[@text='Later']"))) {
            if (flag) {
                Log.info("ALLOW", permissionName + " permission");
                onboardingScreen.selectElement(By.xpath("//*[@text='Enable']"));
            } else {
                Log.info("DENY", permissionName + " permission");
                onboardingScreen.selectElement(By.xpath("//*[@text='Later']"));
            }
        }
    }


    public void handleCTOverlay() throws InterruptedException {
        Thread.sleep(5000);

        if (onboardingScreen.isElementPresent(By.xpath("//android.widget.RelativeLayout[@index = '0']/android.widget" +
                ".ImageView[@index = '1']"))) {

            Log.info("Handle", "CT Overlay");
            onboardingScreen.selectElement(By.xpath("//android.widget.RelativeLayout[@index = '0']/android.widget" +
                    ".ImageView[@index = '1']"));
        }
    }

    public void handleConscentPopup() throws InterruptedException {
        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.xpath("//android.widget.Button[@text = 'OK']"))) {
            Log.info("Handle", "Conscent Popup");

            onboardingScreen.navigateBack();


        }
    }

    public void handleKycConcent() throws InterruptedException {
        Thread.sleep(2000);
        if (onboardingScreen.isElementPresent(By.xpath("//android.widget.Button[@text = 'DISAGREE']"))) {
            Log.info("Handle", "KYC Conscent Popup");

            onboardingScreen.selectElement(By.xpath("//android.widget.Button[@text = 'DISAGREE']"));
            onboardingScreen.selectElement(By.xpath("//android.widget.Button[@text = 'No, Thanks']"));
        }
    }

    public void handleMagicPopup() throws InterruptedException {
        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.id("com.mobikwik_new:id/view_pager"))) {
            Log.info("Handle", "Magic Popup");

            onboardingScreen.navigateBack();
        }
    }

    public void handleUpiPopup() throws InterruptedException {
        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.id("com.mobikwik_new:id/cashback_tnc"))) {
            Log.info("Handle", "Sanity Popup");
            onboardingScreen.navigateBack();
        }
    }

    public void handleUpiInOnboarding() throws InterruptedException {
        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.id("upi_icon"))) {
            Log.info("Handle", "Sanity Popup in Onboarding");
            onboardingScreen.navigateBack();
        }
    }

    // Added by MS@10 Oct, 2018 to handle the NPS Pop-on pressing back from the success screens
    public void handleNPS() throws InterruptedException {
        Thread.sleep(3000);
        if (isElementPresent(By.id("com.mobikwik_new:id/rating_seekbar"))) {
            Log.info("Handle", "NPS Screen");
            onboardingScreen.selectElement(By.id("com.mobikwik_new:id/close_button"));
        }
    }

    // Added by MS@10 Oct, 2018 to handle the Rating Pop-on pressing back from the success screens
    public void handleRatingsPopUp() throws InterruptedException {
        Thread.sleep(3000);
        if (isElementPresent(By.id("com.mobikwik_new:id/content_root"))) {
            Log.info("Handle", "Ratings PopUp");
            onboardingScreen.selectElement(By.id("com.mobikwik_new:id/close_button"));
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return (dateFormat.format(date));
    }

    public String getCurrentDay() {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        return (dateFormat.format(date));
    }
}
