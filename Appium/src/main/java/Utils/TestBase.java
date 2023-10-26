package Utils;

import Logger.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Listeners(Utils.Listeners.TestListener.class)
public class TestBase {

    public AndroidDriver<AndroidElement> driver = null;

    String androidOSVersion = "13.0";
    String portNo = "4723";
    String udId = "172.18.31.239:5555";
    String deviceName = "RZ8W60BB9HB";


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
     * @author: Paraj
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
    @Parameters({"build", "methodName", "portNo", "androidOSVersion", "deviceName", "udId", "cloudRun"})
    @BeforeMethod(groups = "setUp", alwaysRun = true)
    public void createDriver(@Optional String build, @Optional String methodName, @Optional String portNo, @Optional String androidOSVersion, @Optional String deviceName, @Optional String udId, @Optional Boolean cloudRun) throws Exception {

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

        if (udId == null) {
            udId = this.udId;
        }

        if (cloudRun == null) {
            cloudRun = this.cloudRun;
        }


        if (!cloudRun) {
            Log.info("------ Arguments -------------");
            Log.info(build);
            Log.info(methodName);
            Log.info(portNo);
            Log.info(deviceName);
            Log.info(udId);
            Log.info(androidOSVersion);
            Log.info("--------------------------------");
        } else {

            Log.info("------ Arguments -------------");
            Log.info("MBK Signed APK");
            Log.info("Samsung Galaxy S22 Ultra");
            Log.info("12.0");
            Log.info("Cloud Run : BrowserStack");
            Log.info("--------------------------------");

        }

        String buildPath = choosebuild(build);
        initiateTest(buildPath, methodName, portNo, androidOSVersion, deviceName, udId, cloudRun);

    }

    /**
     * this method creates the iOS driver
     *
     * @param buildPath- path to pick the location of the app
     * @return instance of iOS driver
     * @throws MalformedURLException Thrown to indicate that a malformed URL has occurred.
     */
    protected AndroidDriver initiateTest(String buildPath, String methodName, String portNo, String androidOSVersion, String deviceName, String udId, Boolean cloudRun) throws MalformedURLException {


        if (!cloudRun) {
            File app = new File(buildPath);
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            cap.setCapability(MobileCapabilityType.UDID, udId);
//        cap.setCapability("avd","Pixel_3a");
            cap.setCapability("noSign", true);
            cap.setCapability("appPackage", "com.mobikwik_new.debug");
            cap.setCapability("appActivity", "com.mobikwik_new.MobikwikMain");
            cap.setCapability("noReset", "false");
            cap.setCapability("androidCoverage", "com.mobikwik_new.debug/com.mobikwik_new.instrumentation.CodeCoverageInstrumentation");
//            cap.setCapability("app", app.getAbsolutePath());
            cap.setCapability("app", "//Users//mayanksuneja//app//mobikwik.apk");
            AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:" + portNo + "/wd/hub"), cap);
            androidDriverThread.set(driver);
            return androidDriverThread.get();

        } else {
            DesiredCapabilities caps = new DesiredCapabilities();
            // Set your access credentials
            caps.setCapability("browserstack.user", "parajjain_sbic3m");
            caps.setCapability("browserstack.key", "UiQCwarqqgMmUwmdBH7V");
            // Set URL of the application under test
            caps.setCapability("app", "bs://13c268d959c97610e9f4125fd24392e75f5be7d1");
            // Specify device and os_version for testing
            caps.setCapability("device", "Samsung Galaxy S22 Ultra");
            caps.setCapability("os_version", "12.0");
            // Set other BrowserStack capabilities
            caps.setCapability("project", "MBK Sanity Project");
            caps.setCapability("build", "browserstack-build-1");
            caps.setCapability("name", "first_test");

            // Initialize the remote Webdriver using BrowserStack remote URL
            // and desired capabilities defined above

            AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
            androidDriverThread.set(driver);
            return androidDriverThread.get();

        }

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
    public void teardown(ITestResult result) {
        String testname = result.getMethod().getMethodName();
        Log.info("Dumping coverage data");
        Map<String, Object> args = new HashMap<>();
        args.put("command", "am broadcast -a com.mobikwik_new.debug.END_EMMA com.mobikwik_new.debug");
        getAndroidDriver().executeScript("mobile: shell", args);
        args.clear();
        args.put("command", "run-as com.mobikwik_new.debug mv /data/data/com.mobikwik_new.debug/coverage.ec /data/data/com.mobikwik_new.debug/coverage_"+testname+".ec");
        getAndroidDriver().executeScript("mobile: shell", args);
        args.clear();
        args.put("command", "run-as com.mobikwik_new.debug cp /data/data/com.mobikwik_new.debug/coverage_"+testname+".ec /sdcard/Download" );
        getAndroidDriver().executeScript("mobile: shell", args);
        pullData(this.udId, "/sdcard/Download/coverage_"+testname+".ec");
        Log.info("Shutting down driver");
        getAndroidDriver().quit();

    }
    public static void pullData(String udId, String sourcePath){
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","adb -s "+udId+" pull "+sourcePath+" ./"});
        } catch (IOException e) {
            Log.info("Coverage file pull failed.");
        }
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

        Log.info("Send the Mail");
        //sendReportViaMail();
    }

    private static void sendReportViaMail() {

        String usernameMail = "mobikwiktest123@gmail.com";
        String passMail = "njwqiqohpbaqekuq";
        String data = "";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,

                new Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(usernameMail, passMail);

                    }

                });

        try {
            Message message = new MimeMessage(session);

//            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("paraj.jain@mobikwik.com"));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("MBK-Android@mobikwik.com"));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("paraj.jain@mobikwik.com"));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());


            message.setSubject("Android App Periodic Sanity : " + timestamp);


            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("Sanity Report is Attached with this mail.\nPlease open in CHROME and check for all cases execution status.");

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = "ExtentReport.html";
            String filesource = "/Users/parajjain/IdeaProjects/MK-Automation/Appium/test-output/ExtentReports/ExtentReport.html";//change accordingly
            DataSource source = new FileDataSource(filesource);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            message.setContent(multipart);

            // finally send the email
            Transport.send(message);
            Log.info("Email Sent");

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }


    }

}
