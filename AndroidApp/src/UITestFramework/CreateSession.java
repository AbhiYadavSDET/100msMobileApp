package UITestFramework;

import applicationcontext.ApplicationContextProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;
import mail.Mailer;
import main.java.utils.Config;
import main.java.utils.Listeners.AppiumDriverListeners;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * contains all the methods to create a new session and destroy the session
 * after the test(s) execution is over. Each test extends this class.
 */

public class CreateSession {

    public AndroidDriver<AndroidElement> driver = null;

    public Properties testDataFile;

    String androidOSVersion = "8.0";
    String portNo = "4723";
    String udid = "330062db17b4a48b";
    String deviceName = "Samsung J6";

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

        String buildPath = choosebuild(build);
        androidDriver(buildPath, methodName, portNo, androidOSVersion, deviceName, udid);


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
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", androidOSVersion);

        capabilities.setCapability("appPackage", "com.mobikwik_new");
        capabilities.setCapability("appActivity", ".MobikwikMain");
        capabilities.setCapability("appWaitActivity", ".MobikwikMain");
        capabilities.setCapability("appWaitPackage", "com.mobikwik_new");



        if (Double.parseDouble(androidOSVersion) < Double.parseDouble("7.0")) {
            Log.info("Automation Type : " + "Appium");
            //capabilities.setCapability("automationName", "Appium");

        } else {
            capabilities.setCapability("automationName", "uiautomator2");
            Log.info("Automation Type : " + "uiautomator2");
        }


        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        capabilities.setCapability("reportDirectory", reportDirectory);
        capabilities.setCapability("reportFormat", reportFormat);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("fullReset", true);
//        capabilities.setCapability("noReset", false);

        //Log.info("http://localhost:" + portNo + "/wd/hub");

        driver = new AndroidDriver(new URL("http://localhost:" + portNo + "/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumDriverListeners());
        androidDriverThread.set(driver);


        return androidDriverThread.get();

    }


    public String choosebuild(String build) {


        if (build.equals("prod")) {
            String appPath = "src/app/MobiKwik_prod.apk";
            Log.info(appPath);
            return appPath;
        }

        if (build.equals("stag")) {
            String appPath = "src/app/MobiKwik_stag.apk";
            Log.info(appPath);
            return appPath;
        }

        if (build.equals("beta")) {
            String appPath = "src/app/MobiKwik_beta.apk";
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

    @AfterSuite(alwaysRun = true)
    public void cleanUpActions() {
        Log.info("cleanUpActions");
        sendReportViaMail();
    }

    private static void sendReportViaMail() {


        Log.info("sendReportViaMail");
        Mailer mailer = (Mailer) ApplicationContextProvider.getApplicationContext().getBean("mailer");

// Create the list of attachments
        List<String> listOfAttachments = new ArrayList<>();
        listOfAttachments.add("/home/parajjain/Documents/MK-Automation/AndroidApp/test-output/Extent.html");

// Create the recipients array
        String[] recipients = {"paraj.jain@mobikwik.com"};

        Log.info("Send Mail : " + "Extent Report");
        mailer.sendMail(recipients, "Front-End Test Execution report", "Hi,\n"+"\n"+"PFB Front-End Automation TestReport.\n"+"Please download and open the file with Chrome.\n"+"\n"+"\n"+"Thanks,\n"+"App Team", listOfAttachments);
    }
}
