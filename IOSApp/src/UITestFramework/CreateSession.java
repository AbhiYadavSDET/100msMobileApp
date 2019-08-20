package UITestFramework;


import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;
import main.java.utils.Config;
import main.java.utils.Listeners.AppiumDriverListeners;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * contains all the methods to create a new session and destroy the session
 * after the test(s) execution is over. Each test extends this class.
 */

public class CreateSession {

    public IOSDriver<IOSElement> driver = null;

    public Properties testDataFile;

    String portNo = "4723";
    String deviceName = "Mobikwik";
    String udId = "42d1ed66160146bc73712fbdaa243853e044f9cc";
    String platformVersion = "12.2";
    String automationName = "XCUITest";
    String bundleId = "com.mobikwik";
    String platformName = "iOS";

    private String reportDirectory = "reports";
    private String reportFormat = "xml";

    protected static Properties properties;
    protected static Logger log = Logger.getLogger(Config.class);


    /**
     * ThreadLocal variable which contains the {@link IOSDriver} instance which
     * is used to perform browser interactions with.
     */
    private ThreadLocal<IOSDriver> iosDriverThread = new ThreadLocal<>();


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
        initialization();

        if (portNo == null) {
            portNo = this.portNo;

        }

        if (deviceName == null) {
            deviceName = this.deviceName;
        }

        if (udid == null) {
            udid = this.udId;
        }

        String buildPath = choosebuild(build);
        iosDriver(buildPath, methodName, portNo, deviceName, udid, automationName, bundleId, platformName, platformVersion);


    }

    /**
     * this method quit the driver after the execution of test(s)
     */
    @AfterMethod(groups = "tearDown", alwaysRun = true)
    public void teardown() {
        Log.info("Shutting down driver");
        getIOSDriver().quit();
    }


    /**
     * this method creates the iOS driver
     *
     * @param buildPath- path to pick the location of the app
     * @return instance of iOS driver
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    public IOSDriver iosDriver(String buildPath, String methodName, String portNo, String deviceName, String udid, String automationName, String bundleId, String platformName, String platformVersion)
            throws MalformedURLException {
        File app = new File(buildPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        capabilities.setCapability("reportDirectory", reportDirectory);
        capabilities.setCapability("reportFormat", reportFormat);
        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("fullReset", false);
//        capabilities.setCapability("noReset", false);

        //Log.info("http://localhost:" + portNo + "/wd/hub");

        driver = new IOSDriver(new URL("http://localhost:" + portNo + "/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumDriverListeners());
        iosDriverThread.set(driver);


        return iosDriverThread.get();

    }


    public String choosebuild(String build) {


        if (build.equals("prod")) {
            String appPath = "src/app/MobiKwik.ipa";
            return appPath;
        }

        if (build.equals("stag")) {
            String appPath = "src/app/MobiKwik.ipa";
            return appPath;
        }

        if (build.equals("beta")) {
            String appPath = "src/app/MobiKwik.ipa";
            return appPath;
        }

        return build;
    }


    /**
     * @return the {@link IOSDriver} for the current thread
     */
    public IOSDriver getIOSDriver() {
        return iosDriverThread.get();
    }

    /**
     * @return the Current Date
     */


    public void initialization() {
        fetchDataFromPropertiesFile();
    }

    private void fetchDataFromPropertiesFile() {

        String filepath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        fetchConfiguration(filepath);
        String env = properties.getProperty("Environment", "production").trim().toLowerCase();
        if (!(env.equals("production") || env.equals(""))) {
            filepath = System.getProperty("user.dir") + "/Parameters/" + env + ".properties";
            fetchConfiguration(filepath);
        }

    }

    private void fetchConfiguration(String filepath) {

        //	String filepath=System.getProperty("user.dir")+"/Parameters/Config.properties";

        properties = new Properties();

        InputStream input = null;
        try {

            input = new FileInputStream(filepath);

            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            System.out.println("Error while loading property file.\n");
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
