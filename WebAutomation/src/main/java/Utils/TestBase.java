package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners(Utils.TestListener.class)
public class TestBase {

    protected static Properties properties;
    public WebDriver driver = null;
    protected static Logger log = Logger.getLogger(TestBase.class);
    private static ThreadLocal<WebDriver> webDriverThread = new ThreadLocal<>();


    protected void initiateTest() {

        String driverPath = "";
        fetchDataFromPropertiesFile();

        String browser = properties.getProperty("Browser", "chrome").trim().toLowerCase();
        String os = System.getProperty("os.name");

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;

            case "ie":
                break;

            case "opera":
                break;

            case "safari":
                break;

            case "chrome":

            default:
                if (os.contains("Linux"))
                    driverPath = System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver";
                else if (os.contains("Mac OS X"))
                    driverPath = System.getProperty("user.dir") + "/src/main/resources/Drivers/mac/chromedriver";
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;
        }

        if (properties.getProperty("MaximizeWindow").equalsIgnoreCase("true"))
            driver.manage().window().maximize();

        int timeout = Integer.parseInt(properties.getProperty("ImplicitWaitTime"));
        if (timeout > 0)
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        EventFiringWebDriver event = new EventFiringWebDriver(driver);
        WebDriverListeners eventListener = new WebDriverListeners();
        event.register(eventListener);
        driver = event;

        setWebDriver(driver);

        String webUrl = "https://www.mobikwik.com";
        webUrl = properties.getProperty("WebUrl", "https://www.mobikwik.com");
        getWebDriver().get(webUrl);


    }

    public static WebDriver getWebDriver() {
        return webDriverThread.get();
    }

    public void setWebDriver(WebDriver driver) {
        webDriverThread.set(driver);
    }


    private void fetchDataFromPropertiesFile() {

        String filepath = System.getProperty("user.dir") + "/Parameters/config.properties";
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

    @BeforeSuite(alwaysRun = true)
    public void intialization() {
        initiateTest();
        Log.info("Setup");
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Browser.quitBrowser(getWebDriver());
    }

}
