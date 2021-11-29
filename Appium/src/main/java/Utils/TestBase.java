package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Listeners(Utils.TestListener.class)
public class TestBase {

    AndroidDriver driver;
    private static FileAppender appender;
    private static PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} [%M] [%C{1}:%L] - %m%n");
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

    protected AndroidDriver initiateTest() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"RZ8N90TQDHD");
        cap.setCapability("appPackage","com.mobikwik_new");
        cap.setCapability("appActivity",".MobikwikMain");
        cap.setCapability("noReset","true");
//        cap.setCapability("fullReset","false");
//        cap.setCapability("app","//Users//uditgupta//Desktop//MK_Android_App-prod-debug.apk");
        AndroidDriver driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        this.driver=driver;
        return driver;
    }

    public AndroidDriver getDriver(){
        return this.driver;
    }

    @BeforeSuite(alwaysRun = true)
    public void intialization() throws MalformedURLException {
        info("Starting app automation");
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        info("App closed");
    }

    public static void info(String message){
        LOGGER.addAppender(consoleAppender);
        LOGGER.addAppender(appender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(message);
    }

}
