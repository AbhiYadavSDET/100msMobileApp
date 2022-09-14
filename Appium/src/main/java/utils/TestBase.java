package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;
import org.apache.log4j.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Listeners(utils.TestListener.class)
public class TestBase {

    AndroidDriver driver;

    String androidOSVersion = "8.0";
    String portNo = "4723";
    String udid = "e0cd9c9";
    String deviceName = "OnePlus 8T";

    private static FileAppender appender;
    private static PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} [%M] [%C{1}:%L] - %m%n ");
    private static ConsoleAppender consoleAppender;
    protected static Logger LOGGER = Logger.getLogger(TestBase.class);

    static {
        try {
            consoleAppender = new ConsoleAppender(layout, "System.out");
            appender = new FileAppender(layout, "LogFile.txt", true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    @BeforeSuite
    public void initialSetup() throws IOException {


        Log.info("Initialising the Extent Report");

        ExtentReport extentReport = new ExtentReport();
        extentReport.extentReportSetup();


    }

    /**
     * ThreadLocal variable which contains the {@link AndroidDriver} instance which
     * is used to perform browser interactions with.
     */
    private ThreadLocal<AndroidDriver> androidDriverThread = new ThreadLocal<>();
    //private ThreadLocal<String> sessionId = new ThreadLocal<String>();


    /**
     * this method creates the driver depending upon the passed parameter
     * (android or iOS) and loads the properties files (config and test data
     * properties files).
     *
     * @param build            - staging,beta,production
     * @param methodName
     * @param portNo           - for specifying the appium portNo
     * @param androidOSVersion - for specifying the OS version of te device
     * @throws Exception issue while loading properties files or creation of driver.
     */
    @Parameters({"build", "methodName", "portNo", "androidOSVersion", "deviceName", "udid"})
    @BeforeMethod(groups = "setUp", alwaysRun = true)
    public void createDriver(String build, @Optional String methodName, @Optional String portNo, @Optional String androidOSVersion, @Optional String deviceName, @Optional String udid) throws Exception {

        // Initializing the test and load the config files
        intialization();

        if (portNo == null) {
            portNo = this.portNo;

        }

        if (androidOSVersion == null) {
            androidOSVersion = this.androidOSVersion;
        }

        if (deviceName == null) {
            deviceName = this.deviceName;
        }

        if (udid == null) {
            udid = this.udid;
        }


        Log.info("------ Arguments -------------");
        Log.info(build);
        Log.info(methodName);
        Log.info(portNo);
        Log.info(deviceName);
        Log.info(udid);
        Log.info(androidOSVersion);
        Log.info("--------------------------------");

        String buildPath = choosebuild(build);
        initiateTest(buildPath, methodName, portNo, androidOSVersion, deviceName, udid);

    }

    /**
     * this method creates the iOS driver
     *
     * @param buildPath- path to pick the location of the app
     * @return instance of iOS driver
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    protected AndroidDriver initiateTest(String buildPath, String methodName, String portNo, String androidOSVersion, String deviceName, String udid) throws MalformedURLException {

        File app = new File(buildPath);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "e0cd9c9");
//        cap.setCapability("avd","Pixel_3a");
        cap.setCapability("noSign", true);
        cap.setCapability("appPackage", "com.mobikwik_new");
        cap.setCapability("appActivity", ".MobikwikMain");
        cap.setCapability("noReset", "false");
        cap.setCapability("app", app.getAbsolutePath());
//        cap.setCapability("app","//Users//uditgupta//Desktop//MK_Android_App-prod-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        androidDriverThread.set(driver);
        return androidDriverThread.get();
    }

    public String choosebuild(String build) {


        if (build.equals("prod")) {
            String appPath = "src/app/MobiKwik_prod.apk";
            Log.info(appPath);
            return appPath;
        }

        if (build.equals("debug")) {
            String appPath = "src/app/MobiKwik_debug.apk";
            Log.info(appPath);
            return appPath;
        }

        return build;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriverThread.get();
    }


    public void intialization() throws MalformedURLException {
        info("Starting App Automation");
    }


    /**
     * this method quit the driver after the execution of test(s)
     */
    @AfterMethod(groups = "tearDown", alwaysRun = true)
    public void teardown() {
        Log.info("Shutting down driver");
        getAndroidDriver().quit();
        
    }

    public static void info(String message) {
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(message);
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUpActions() {
        Log.info("cleanUpActions");
        sendReportViaMail();
    }

    private static void sendReportViaMail() {


        Log.info("sendReportViaMail");
//        Mailer mailer = (Mailer) ApplicationContextProvider.getApplicationContext().getBean("mailer");

// Create the list of attachments
        List<String> listOfAttachments = new ArrayList<>();
        listOfAttachments.add("/home/parajjain/Documents/MK-Automation/AndroidApp/test-output/ExtentReports/ExtentReport.html");

// Create the recipients array
        String[] recipients = {"QAfront-End@mobikwik.com"};
//        String[] recipients = {"paraj.jain@mobikwik.com"};

        Log.info("Send Mail : " + "Extent Report");

//        String date = DateHelper.getCurrentDate(YYYY_MM_DD_HH_MM_SS);


//        mailer.sendMail(recipients, "Front-End Test Execution report : " + date, "Hi,<br>" + "<br>" + "PFB Front-End Automation TestReport.<br>" + "Please download and open the file with Chrome.<br>" + "<br>" + "<br>" + "Thanks,<br>" + "App Team", listOfAttachments);
    }

}
