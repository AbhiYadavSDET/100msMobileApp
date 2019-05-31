package UITestFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
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

    public AndroidDriver<AndroidElement> driver = null;

    public Properties testDataFile;

    String androidOSVersion = "8.0";
    String portNo = "5000";
    String udid = "909aaa06";
    String deviceName = "Samsung J7";

    private String reportDirectory = "reports";
    private String reportFormat = "xml";

    protected static Properties properties;
    protected static Logger log = Logger.getLogger(Config.class);


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
        initialization();

        /*Log.info("BEFORE");
        System.out.println("portNo : " + portNo);
        System.out.println("androidOSVersion : " + androidOSVersion);
        System.out.println("deviceName : " + deviceName);
        System.out.println("udid : " + udid);*/

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

        /*Log.info("AFTER");
        System.out.println("portNo : " + portNo);
        System.out.println("androidOSVersion : " + androidOSVersion);
        System.out.println("deviceName : " + deviceName);
        System.out.println("udid : " + udid);*/


        String buildPath = choosebuild(build);
        androidDriver(buildPath, methodName, portNo, androidOSVersion, deviceName, udid);
        //Log.info("Android driver created");


    }

    /**
     * this method quit the driver after the execution of test(s)
     */
    @AfterMethod(groups = "tearDown", alwaysRun = true)
    public void teardown() {
        Log.info("Shutting down driver");
        getAndroidDriver().quit();
    }


    /**
     * this method creates the iOS driver
     *
     * @param buildPath- path to pick the location of the app
     * @return instance of iOS driver
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    public AndroidDriver androidDriver(String buildPath, String methodName, String portNo, String androidOSVersion, String deviceName, String udid)
            throws MalformedURLException {
        File app = new File(buildPath);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", androidOSVersion);

        capabilities.setCapability("app-package", "com.mobikwik_new");
        capabilities.setCapability("app-activity", ".MobikwikMain");
        capabilities.setCapability("app-wait-activity", ".MobikwikMain");

        if (Double.parseDouble(androidOSVersion) < Double.parseDouble("7.0")) {
            Log.info("Automation Type : " + "Appium");
            //capabilities.setCapability("automationName", "Appium");

        } else {
            capabilities.setCapability("automationName", "uiautomator2");
            Log.info("Automation Type : " + "uiautomator2");
        }

        // capabilities.setCapability("deviceName", "4200ea8cce337347");


        //Moto G3
       /* capabilities.setCapability("deviceName", "MotoG3");
        capabilities.setCapability(MobileCapabilityType.UDID, "ZY2227VCMX");*/

/*        capabilities.setCapability("deviceName", "Moto G (5S) Plus");
        capabilities.setCapability(MobileCapabilityType.UDID, "192.168.4.73:5656");*/

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        capabilities.setCapability("reportDirectory", reportDirectory);
        capabilities.setCapability("reportFormat", reportFormat);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("fullReset", true);

        //Log.info("http://localhost:" + portNo + "/wd/hub");

        driver = new AndroidDriver(new URL("http://localhost:" + portNo + "/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumDriverListeners());
        androidDriverThread.set(driver);


        return androidDriverThread.get();

    }


    public String choosebuild(String build) {


        if (build.equals("prod")) {
            String appPath = "src/app/MobiKwik_prod.apk";
            return appPath;
        }

        if (build.equals("stag")) {
            String appPath = "src/app/MobiKwik_stag.apk";
            return appPath;
        }

        if (build.equals("beta")) {
            String appPath = "src/app/MobiKwik_beta.apk";
            return appPath;
        }

        return build;
    }


    /**
     * @return the {@link AndroidDriver} for the current thread
     */
    public AndroidDriver getAndroidDriver() {
        return androidDriverThread.get();
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
