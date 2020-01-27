package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FabricPage {


    WebDriver driver;

    public FabricPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, page_load_welcome_text);
        Config.logComment("*****On Fabric Page*****");
    }

    @FindBy(xpath = "//*/input[@id = 'email']")
    private WebElement userName;

    @FindBy(xpath = "//*/input[@id = 'password']")
    private WebElement password;

    @FindBy(xpath = "//header[text()= 'Welcome back']")
    private WebElement page_load_welcome_text;

    @FindBy(xpath = "//*/button[@data-title = 'Sign In']")
    private WebElement button_sign_in;

    @FindBy(xpath = "//*/div[text() = 'com.mobikwik_new']")
    private WebElement label_com_mobikwik_new;

    @FindBy(xpath = "//*/div[text() = 'Active Users']/preceding::div[1]")
    private WebElement label_active_users;

    @FindBy(xpath = "//a[@class = 'crashlytics ']/span/i")
    private WebElement link_crashlytics;

    @FindBy(xpath = "//span[text() = 'crash-free users']/preceding::span[2]")
    private WebElement label_crash_free_users;

    @FindBy(xpath = "//span[text() = 'crash-free sessions']/preceding::span[1]")
    private WebElement label_crash_free_sessions;

    @FindBy(xpath = "//*[text() = 'Last 7 Days']")
    private WebElement label_last_7_days;

    @FindBy(xpath = "//*[text() = 'Last 60 Minutes']")
    private WebElement label_last_60_minutes;

    @FindBy(xpath = "//*[text() = 'Last 24 Hours']")
    private WebElement label_last_24_Hours;

    @FindBy(xpath = "//*[text() = 'Last 30 Days']")
    private WebElement label_last_30_Days;

    @FindBy(xpath = "//*[text() = 'Last 7 Days']")
    private WebElement label_last_7_Days;

    @FindBy(xpath = "//div[@class = 'date-wrapper']/preceding::span[@class = 'Select-arrow'][1]")
    private WebElement drop_down_arrow;

    @FindBy(xpath = "//div[@class = 'date-wrapper']/preceding::span[@class = 'Select-arrow'][3]")
    private WebElement app_version_drop_down_arrow;

    @FindBy(xpath = "//span[text() = 'Crashes']")
    private WebElement label_crashes;


    // Crash title
    @FindBy(xpath = "//tr[1]/td/a/div/span[1]")
    private WebElement label_title_1;

    @FindBy(xpath = "//tr[2]/td/a/div/span[1]")
    private WebElement label_title_2;

    @FindBy(xpath = "//tr[3]/td/a/div/span[1]")
    private WebElement label_title_3;

    // Crash description
    @FindBy(xpath = "//tr[1]/td/a/div[2]")
    private WebElement label_description_1;

    @FindBy(xpath = "//tr[2]/td/a/div[2]")
    private WebElement label_description_2;

    @FindBy(xpath = "//tr[3]/td/a/div[2]")
    private WebElement label_description_3;

    // Crash link
    @FindBy(xpath = "//tr[1]/td[@class = 'cell-title']/a")
    private WebElement link_crash_1;

    @FindBy(xpath = "//tr[2]/td[@class = 'cell-title']/a")
    private WebElement link_crash_2;

    @FindBy(xpath = "//tr[3]/td[@class = 'cell-title']/a")
    private WebElement link_crash_3;

    // Crashs
    @FindBy(xpath = "//tr[1]/td[5]/a/div/div/span")
    private WebElement label_crashes_1;

    @FindBy(xpath = "//tr[2]/td[5]/a/div/div/span")
    private WebElement label_crashes_2;

    @FindBy(xpath = "//tr[3]/td[5]/a/div/div/span")
    private WebElement label_crashes_3;

    // Users
    @FindBy(xpath = "//tr[1]/td[6]/a/div/div/span")
    private WebElement label_users_1;

    @FindBy(xpath = "//tr[2]/td[6]/a/div/div/span")
    private WebElement label_users_2;

    @FindBy(xpath = "//tr[3]/td[6]/a/div/div/span")
    private WebElement label_users_3;

    // App version
    @FindBy(xpath = "//tr[1]/td[@class = 'more-info']/a")
    private WebElement label_app_version_1;

    @FindBy(xpath = "//tr[2]/td[@class = 'more-info']/a")
    private WebElement label_app_version_2;

    @FindBy(xpath = "//tr[3]/td[@class = 'more-info']/a")
    private WebElement label_app_version_3;


    // Added @23rd Jan
    @FindBy(xpath = "//span[@id = 'react-select-22--value']")
    private WebElement click_app_version;

    @FindBy(xpath = "//span[text() = 'Top Builds']")
    private WebElement label_top_builds;

    @FindBy(xpath = "//span[text() = '×']")
    private WebElement label_cross;

    @FindBy(xpath = "//span[text() = 'crash-free users']/preceding::input[@role = 'combobox']")
    private WebElement combobox_app_version;

    // Added @24th Jan
    @FindBy(xpath = "//div[@class = 'date-wrapper']/following::span[@class = 'Select-arrow'][1]")
    private WebElement drop_down_top_devices;

    @FindBy(xpath = "//div[@class = 'date-wrapper']/following::span[@class = 'Select-arrow'][2]")
    private WebElement drop_down_top_os;

    @FindBy(xpath = "//div[text() = 'Device & OS']")
    private WebElement label_devices_and_os;

    @FindBy(xpath = "//div[text() = 'Crash Insights']")
    private WebElement label_crash_insights;


    public void enterUserName(String text) {
        Element.enterText(driver, userName, text, "username");
    }

    public void enterPassword(String text) {
        Element.enterText(driver, password, text, "password");
    }

    public void clickSignIn() {
        Element.selectElement(driver, button_sign_in, "sign in button");
    }

    public void clickMobikwikAndroid() {
        Element.selectElement(driver, label_com_mobikwik_new, "Mobikwik Android App");
    }

    public String getActiveUsers() {
        return Element.fetchText(driver, label_active_users, "Active Users");
    }

    public void clickCrashlytics() {
        Element.selectElement(driver, link_crashlytics, "Link Crashlytics");
    }

    public String getCrashFreeUsers() {
        return Element.fetchText(driver, label_crash_free_users, "Crash Free Users");
    }

    public String getCrashFreeSessions() {
        return Element.fetchText(driver, label_crash_free_sessions, "Crash Free sessions");
    }

    public void clickLast7Days() {
        Element.selectElement(driver, label_last_7_days, "Last 7 Days");
    }

    public void clickDropDownArrow() {
        Element.selectElement(driver, drop_down_arrow, "Drop down arrow");
    }

    public void selectLast60Minutes() {
        Element.selectElement(driver, label_last_60_minutes, "Last 60 mins");
    }

    public void selectLast30Days() {
        Element.selectElement(driver, label_last_30_Days, "Last 30 Days");
    }

    public void selectLast7Days() {
        Element.selectElement(driver, label_last_7_Days, "Last 7 Days");
    }

    public void selectLast24Hours() {
        Element.selectElement(driver, label_last_24_Hours, "Last 24 Hours");
    }

    public void hoverOnLabelCrashes() throws InterruptedException {
        Element.hoverOn(driver, label_crashes);
    }

    public void hoverOnIconCrashlytics() throws InterruptedException {
        Element.hoverOn(driver, link_crashlytics);
    }

    // Fetch the top 3 crashes details
    public String getCrash1Title() {
        return Element.fetchText(driver, label_title_1, "Crash 1 : Title");
    }

    public String getCrash2Title() {
        return Element.fetchText(driver, label_title_2, "Crash 2 : Title");
    }

    public String getCrash3Title() {
        return Element.fetchText(driver, label_title_3, "Crash 3 : Title");
    }

    public String getCrash1Description() {
        return Element.fetchText(driver, label_description_1, "Crash 1 : Description");
    }

    public String getCrash2Description() {
        return Element.fetchText(driver, label_description_2, "Crash 2 : Description");
    }

    public String getCrash3Description() {
        return Element.fetchText(driver, label_description_3, "Crash 3 : Description");
    }

    public String getCrash1AppVersion() {
        return Element.fetchText(driver, label_app_version_1, "Crash 1 : App Version");
    }

    public String getCrash2AppVersion() {
        return Element.fetchText(driver, label_app_version_2, "Crash 2 : App  Version");
    }

    public String getCrash3AppVersion() {
        return Element.fetchText(driver, label_app_version_3, "Crash 3 : App Version");
    }

    public String getCrash1Crashes() {
        return Element.fetchText(driver, label_crashes_1, "Crash 1 : Crashes");
    }

    public String getCrash2Crashes() {
        return Element.fetchText(driver, label_crashes_2, "Crash 2 : Crashes");
    }

    public String getCrash3Crashes() {
        return Element.fetchText(driver, label_crashes_3, "Crash 3 : Crashes");
    }

    public String getCrash1Users() {
        return Element.fetchText(driver, label_users_1, "Crash 1 : Users");
    }

    public String getCrash2Users() {
        return Element.fetchText(driver, label_users_2, "Crash 2 : Users");
    }

    public String getCrash3Users() {
        return Element.fetchText(driver, label_users_3, "Crash 3 : Users");
    }

    public void moveToCrashes() {
        Element.scrollToView(driver, label_crashes_1);
    }

    public String getCrash1Link() {
        return Element.fetchLink(driver, link_crash_1, "Crash 1 : Link");
    }

    public String getCrash2Link() {
        return Element.fetchLink(driver, link_crash_2, "Crash 2 : Link");
    }

    public String getCrash3Link() {
        return Element.fetchLink(driver, link_crash_3, "Crash 3 : Link");
    }


    // Added @23rd Jan
    public void clickAppversionDropDownArrow() {
        Element.selectElement(driver, app_version_drop_down_arrow, "App version drop down arrow");
    }

    public void clickAppVersion() {
        Element.selectElement(driver, click_app_version, "App version");
    }

    public void clickTopBuilds() {
        Element.selectElement(driver, label_top_builds, "Top Builds");
    }

    public void clickCrossIcon() {
        Element.selectElement(driver, label_cross, "Cross Icon");
    }

    public void enterAppVersion(String text) {
        Element.enterText(driver, combobox_app_version, text, "app version");
    }

    // Added @24th Jan
    public void clickDropdownTopDevices() {
        Element.selectElement(driver, drop_down_top_devices, "Top Devices Drop down arrow");
    }

    public void clickDropdownTopOS() {
        Element.selectElement(driver, drop_down_top_os, "Top OS Drop down arrow");
    }

    public void clickDeviceOS() {
        Element.selectElement(driver, label_devices_and_os, "Device & OS");
    }

    public void clickCrashInsights() {
        Element.selectElement(driver, label_crash_insights, "Crash Insights");
    }
}
