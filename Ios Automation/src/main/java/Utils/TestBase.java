package Utils;

import Logger.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import javax.mail.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@Listeners(Utils.Listeners.TestListener.class)
public class TestBase {

    public IOSDriver<IOSElement> driver = null;

    String IOSVersion = "13.0";
    String portNo = "4723";
    String udId = "auto";
    String deviceName = "Iphone 7";
    String buildPath = "/Users/ashishkumarpradhan/Downloads/mobi.ipa";

    Boolean cloudRun = false;

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


    @BeforeSuite(alwaysRun = true)
    public void initialSetup() throws IOException {

        Log.info("Testbase : Initialising the Extent Report");
        ExtentReport extentReport = new ExtentReport();
        extentReport.extentReportSetup();


    }

    /**
     * ThreadLocal variable which contains the {@link AndroidDriver} instance which
     * is used to perform browser interactions with.
     *
     * @author: Ashish Kumar Pradhan
     */
    private ThreadLocal<IOSDriver> iosDriverThread = new ThreadLocal<>();
    //private ThreadLocal<String> sessionId = new ThreadLocal<String>();


    /**
     * this method creates the driver depending upon the passed parameter
     * (android or iOS) and loads the properties files (config and test data
     * properties files).
     *
     * @param build            - staging,beta,production
     * @param methodName
     * @param buildPath
     * @param portNo           - for specifying the appium portNo
     * @param IOSVersion - for specifying the OS version of te device
     * @throws Exception issue while loading properties files or creation of driver.
     */
    @Parameters({"build", "methodName", "portNo", "androidOSVersion", "deviceName", "udId", "buildPath", "cloudRun", "codeCoverage"})
    @BeforeMethod(groups = "setUp", alwaysRun = true)
    public void createDriver(@Optional String build, @Optional String methodName, @Optional String portNo, @Optional String IOSVersion, @Optional String deviceName, @Optional String udId, @Optional String buildPath, @Optional Boolean cloudRun, @Optional Boolean codeCoverage) throws Exception {

        // Initializing the test and load the config files
        intialization();

        if (portNo == null) {
            portNo = this.portNo;
        }

        if (IOSVersion == null) {
            IOSVersion = this.IOSVersion;
        }

        if (deviceName == null) {
            deviceName = this.deviceName;
        }

        if (udId == null) {
            udId = this.udId;
        }

        if (buildPath == null) {
            buildPath = this.buildPath;
        }

        if (cloudRun == null) {
            cloudRun = this.cloudRun;
        }

        if (codeCoverage == null) {
            codeCoverage = false;
        }

        Log.info("------ Arguments -------------");
        Log.info(build);
        Log.info(methodName);
        Log.info(portNo);
        Log.info(deviceName);
        Log.info(udId);
        Log.info(IOSVersion);
        Log.info("--------------------------------");

        initiateTest(buildPath, methodName, portNo, IOSVersion, deviceName, udId, cloudRun, codeCoverage);

    }

    /**
     * this method creates the iOS driver
     *
     * @param buildPath- path to pick the location of the app
     * @return instance of iOS driver
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    protected IOSDriver initiateTest(String buildPath, String methodName, String portNo, String IOSVersion, String deviceName, String udId, Boolean cloudRun, Boolean codeCoverage) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOSVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID, udId);
        capabilities.setCapability("bundleId", "com.mobikwik");
        capabilities.setCapability("xcodeOrgId", "WKLFHL5THF");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("updatedWDABundleId", "com.facebook.WebDriverAgentRunner");
        // capabilities.setCapability("noRest", true);
        capabilities.setCapability(MobileCapabilityType.APP, buildPath);
        IOSDriver driver = new IOSDriver<>(new URL("http://0.0.0.0:"+ portNo +"/wd/hub"), capabilities);
        iosDriverThread.set(driver);
        return iosDriverThread.get();
    }


    public IOSDriver getIosDriver() {
        return iosDriverThread.get();
    }


    public void intialization() throws MalformedURLException {
        info("Starting App Automation");
    }


    public static void info(String message) {
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(message);
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUpActions() throws MessagingException, IOException, InterruptedException {
        Log.info("TestBase : cleanUpActions");
        Log.info("Flush the Report");
        ExtentReport extentReport = new ExtentReport();
        extentReport.extentReportTearDown();

    }


}
