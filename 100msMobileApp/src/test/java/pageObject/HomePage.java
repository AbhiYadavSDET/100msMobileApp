package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final AppiumDriver driver;


    @AndroidFindBy(id = "live.hms.app2:id/edit_text_name")
    private MobileElement nameEditText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"live.hms.app2:id/edt_meeting_url\"]")
    private MobileElement joiningLinkField;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"live.hms.app2:id/btn_join_now\"]")
    private MobileElement joinNowCTA;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement whileUsingAppButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"live.hms.app2:id/button_join_meeting\"]")
    private MobileElement joinNowCTAOnHomePage;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"End Call\"]")
    private MobileElement endCall;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"live.hms.app2:id/end_session_title\"]")
    private MobileElement endSession;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='End Session']")
    private MobileElement endSessionButton;

    @AndroidFindBy(id = "live.hms.app2:id/end_session_button")
    private MobileElement endSessionButtonInBottomsheet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Experience the power of 100ms']")
    private MobileElement headerText;
    /*-----------------------------------------------------------------------------------------------*/


    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean isAtHomePage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Explicit wait
            wait.until(ExpectedConditions.visibilityOf(headerText));
            return  headerText.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false; // Element not found or is stale, not on home page
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during home page check: " + e.getMessage());
            return false;
        }
    }
    public boolean isMeetingJoined() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Explicit wait
            wait.until(ExpectedConditions.visibilityOf(endCall));
            return  endCall.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false; // Element not found or is stale, not on home page
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during home page check: " + e.getMessage());
            return false;
        }
    }

    public void enterName(String name) {
        nameEditText.sendKeys(name);
    }

    public void enterMeetingUrl(String meetingUrl) {
        joiningLinkField.sendKeys(meetingUrl);
    }

    public void clickJoinNow() {
        joinNowCTA.click();
    }
    public void clickJoinNowOnHomePage() {
        joinNowCTAOnHomePage.click();
    }

    public void endMeetingSession() {
        try {
                endCall.click();
            WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust timeout as needed
            wait.until(ExpectedConditions.visibilityOf(endSessionButton)).click();

            // Wait for and click on the second "End Session" button
            wait.until(ExpectedConditions.visibilityOf(endSessionButtonInBottomsheet)).click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found during ending session: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
