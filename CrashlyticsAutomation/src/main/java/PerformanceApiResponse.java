import Listeners.WebDriverListeners;
import Logger.Log;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PerformanceApiResponse {


    @Test(groups = {"performanceAPIResp"}, priority = 0, description = "Verify api reponse time")
    public static void PerformanceApiResponse() throws InterruptedException, IOException {
        Log.info("Branch : Master");

        /** Username and Password to login on Firebase */

        Log.info("Username and Password to login on Firebase");

        String usernameWebLogin = "mbkmobile.team@mobikwik.com";
        String passWebLogin = "Mobikwik@12345";

        /**Username and Password will be used to send mail */
        Log.info("Username and Password will be used to send mail");

//        String usernameMail = "mobikwiktest123@gmail.com";
//        String passMail = "njwqiqohpbaqekuq";

        String usernameMail = "dont-reply@mobikwik.com";
        String passMail = "mobikwik123#";



        /**BrowserStack Credentials */
        String username = "parajjain_sbic3m";
        String accessKey = "UiQCwarqqgMmUwmdBH7V";
//        String buildName = "TestMbk";



        /** Variables Declaration */
        Log.info("Variables Declaration");

        String respTime, changePer, name, success, sample, changeSuccess;
        float respTimeCheck, successCheck;
        int i, percent, pages = 1;
        float samplesCheck;
        Boolean condition = true, sendMail = false, changeSub = true;
        String loggingException="";


        /** Array List for Data */
        Log.info("Array List for Data");

        /** Array List for Response Change Tables */
        ArrayList<String> responseTime = new ArrayList<String>();
        ArrayList<String> changePercent = new ArrayList<String>();
        ArrayList<String> apiName = new ArrayList<String>();
        ArrayList<String> apiSuccess = new ArrayList<String>();
        ArrayList<String> apiSample = new ArrayList<String>();

        /** Array List for Success Change Tables */
        ArrayList<String> responseTime1 = new ArrayList<String>();
        ArrayList<String> changePercent1 = new ArrayList<String>();
        ArrayList<String> apiName1 = new ArrayList<String>();
        ArrayList<String> apiSuccess1 = new ArrayList<String>();
        ArrayList<String> apiSample1 = new ArrayList<String>();
        ArrayList<String> changeSuccess1 = new ArrayList<String>();


/** Driver Initiate Method 1 : Chrome Browser Local */

//        /** Initiating Chrome driver */
//        Log.info("Initiating Chrome driver");
//
//        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
////        chromeOptions.addArguments("--headless");
//
//
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
//
//        WebDriverEventListener webDriverEventListener = new WebDriverListeners();
//        eventDriver.register(webDriverEventListener);


/** Driver Initiate Method 2 : Chrome Browser Browserstack */


        /** Initiating Browserstack Chrome driver */
        Log.info("Initiating Browserstack Chrome driver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("name", "MBKTest"); // test buildName
//        capabilities.setCapability("build", buildName); // CI/CD job name using BROWSERSTACK_BUILD_NAME env variable

        WebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        WebDriverEventListener webDriverEventListener = new WebDriverListeners();
        eventDriver.register(webDriverEventListener);



        try {

            /** Opening Firebase URL */
            Log.info("Opening Firebase URL");

            eventDriver.get("https://console.firebase.google.com");
            eventDriver.manage().window().maximize();

            /** Logging into Firebase  */
            Log.info("Logging into Firebase");
            eventDriver.findElement(By.id("identifierId")).sendKeys(usernameWebLogin);
            eventDriver.findElement(By.xpath("//*[text()='Next']")).click();

            shortWait(eventDriver, "//input[@type='password']");
            eventDriver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWebLogin);
            eventDriver.findElement(By.xpath("//*[text()='Next']")).click();

            /**
             *We have setup intellij as Authenticator and using it also to generate otp to login
             */




            eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);

            Log.info("Tap Google Authenticator");

            try{
            if (eventDriver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).isDisplayed()){
                eventDriver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).click();
            }

        } catch (Exception e)
            {
                Log.info("Exception : Try Another Way , Then Tap Google Authenticator");
                eventDriver.findElement(By.xpath("//span[text()= 'Try another way']")).click();
                eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Thread.sleep(5000);
                eventDriver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).click();

            }

            /** Getting 2FA Code from the method getTwoFactorCode : Which is set as authenticator App */

            Log.info("Getting 2FA Code from the method getTwoFactorCode : Which is set as authenticator App");

            shortWait(eventDriver, "//input[@name='totpPin']");
            eventDriver.findElement(By.xpath("//input[@name='totpPin']")).sendKeys(getTwoFactorCode());
            eventDriver.findElement(By.xpath("//*[text()='Next']")).click();

            /** Test Case Starts */

            Log.info("Test Case Starts");


            Log.info("Project Selector Page");
            longWait(eventDriver, "//*[contains(text(),'Mobikwik Android')]");
            eventDriver.findElement(By.xpath("//*[contains(text(),'Mobikwik Android')]")).click();
            longWait(eventDriver, "//div[text()=' Release & Monitor ']");
            try {
                Log.info("Select Performance Main Title from Side Drawer");
                eventDriver.findElement(By.xpath("//div[text()='Performance']")).click();

            } catch (Exception e) {
                Log.info(" EXCEPTION : Select Performance Backup under Release & Monitor from Side Drawer");
                eventDriver.findElement(By.xpath("//div[text()=' Release & Monitor ']")).click();

                Thread.sleep(2000);

                shortWait(eventDriver, "//a[@role='treeitem']//div[text()='Performance']");
                eventDriver.findElement(By.xpath("//a[@role='treeitem']//div[text()='Performance']")).click();
            }

            /** App Selector */


            Log.info("Open App Selector Dropdown");
            shortWait(eventDriver, "//div[@class='selected-resource-wrapper']");
            eventDriver.findElement(By.xpath("//div[@class='selected-resource-wrapper']")).click();
            Thread.sleep(2000);

            /** Select Mobikwik Consumer App from the List */

            Log.info("Select Mobikwik Consumer App from the List");

            shortWait(eventDriver, "//button[@role='menuitem']//span[text()='Mobikwik Consumer App']");
            eventDriver.findElement(By.xpath("//button[@role='menuitem']//span[text()='Mobikwik Consumer App']")).click();

            /** Setting period for Results from Calender Icon */

            Log.info("Setting period for Results from Calender Icon");

            longWait(eventDriver, "//div[@class='date-selection']");
            eventDriver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            eventDriver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();

            Log.info("Scroll to View Api Data");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,150)", "");

            /** Extracting Data and validating through conditions */
            /** Locators of Network Request Tables */

            Log.info("Extracting Data and validating through conditions");


            Log.info("Initializing Page Locators");
            String responseTimeCell="(//mat-cell[@class='mat-cell cdk-cell metric-value-cell cdk-column-RESPONSE_TIME_LATEST_VALUE mat-column-RESPONSE_TIME_LATEST_VALUE ng-star-inserted'])";
            String responseTimeChange= "(//mat-cell[@class='mat-cell cdk-cell metric-delta-cell extended cdk-column-RESPONSE_TIME_DELTA mat-column-RESPONSE_TIME_DELTA ng-star-inserted'])";
            String networkApiName= "(//a[@class='mat-mdc-tooltip-trigger fire-router-link-host data-text-wrapper'])";
            String successPercentage= "(//mat-cell[@class='mat-cell cdk-cell metric-value-cell cdk-column-SUCCESS_RATE_LATEST_VALUE mat-column-SUCCESS_RATE_LATEST_VALUE ng-star-inserted'])";
            String sampleSize= "(//div[@class='resource-subtitle ng-star-inserted']/p)";
            String hourlyChange="(//mat-cell[@class='mat-cell cdk-cell metric-delta-cell standard cdk-column-SUCCESS_RATE_DELTA mat-column-SUCCESS_RATE_DELTA ng-star-inserted'])";
            String pageNavigation="//button[@aria-label='Next page']";



            /** Response Change Table Process Begins */
            Log.info("Response Change Table Process Begins");

            while (condition && pages < 4) {
                Log.info("While Loop Starts for Multiple Pages");
                Log.info("Page Number : "+pages);
                Log.info("Condition TRUE/FALSE : " + condition);
                longWait(eventDriver, responseTimeCell);
                Thread.sleep(4000);


                for (i = 1; i <= 10; i++) {

                    Log.info("Extracting Response Time For Record Number : "+i+ " And on Page number : "+ pages);
                    respTime = eventDriver.findElement(By.xpath(responseTimeCell+"[" + i + "]")).getText();
                    respTimeCheck = Float.parseFloat(respTime.replace("s", "").replace("min", ""));

                    Log.info("Extracting Change Percentage For Record Number : "+i+ " And on Page number : "+ pages);
                    shortWait(eventDriver, responseTimeChange);
                    changePer = eventDriver.findElement(By.xpath(responseTimeChange+"[" + i + "]")).getText();
                    percent = Integer.parseInt(changePer.replace("%", "").replace(",", "").replace("+", "").replace("-", "").replace(">", ""));

                    Log.info("Extracting Name For Record Number : "+i+ " And on Page number : "+ pages);
                    shortWait(eventDriver, networkApiName);
                    name = eventDriver.findElement(By.xpath(networkApiName+"[" + i + "]")).getText();

                    Log.info("Extracting Api Success Percentage For Record Number : "+i+ " And on Page number : "+ pages);
                    shortWait(eventDriver, successPercentage);
                    success = eventDriver.findElement(By.xpath(successPercentage+"[" + i + "]")).getText();

                    Log.info("Extracting API Sample Size For Record Number : "+i+ " And on Page number : "+ pages);
                    shortWait(eventDriver, sampleSize);
                    sample = eventDriver.findElement(By.xpath(sampleSize+"[" + i + "]")).getText();
                    samplesCheck = Float.parseFloat(sample.replace(" samples", "").replace("K", "").replace("M", ""));

                    if ((respTimeCheck > 10 || respTime.contains("min")) && percent > 100 && (sample.contains("K") || samplesCheck > 30 || sample.contains("M"))) {
                        if (changePer.contains("+") || changePer.contains(">")) {

                            Log.info("Adding All Response Change data for Record : "+i+ " For page : "+ pages+" to the respective Lists");

                            responseTime.add(respTime);
                            changePercent.add(changePer);
                            apiName.add(name);
                            apiSuccess.add(success);
                            apiSample.add(sample);
                        }

                    }

                    js.executeScript("window.scrollBy(0,100)", "");
                }

                try {
                    if (eventDriver.findElement(By.xpath(pageNavigation)).isEnabled()) {
                        Log.info("Clicked > for Next page");
                        eventDriver.findElement(By.xpath(pageNavigation)).click();
                        pages = pages + 1;
                        condition = true;
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    Log.info("EXCEPTION : Clicking > for Next page for Response Change");
                    condition = false;
                }
                js.executeScript("window.scrollBy(0,100)", "");
            }

            for (i = 0; i < responseTime.size(); i++) {
                Log.info(responseTime.get(i) + "   " + changePercent.get(i) + "   " + apiName.get(i) + "   " + apiSuccess.get(i) + "   " + apiSample.get(i) + " ");
            }




            /** Response Change Table Process Ends */
            Log.info("Response Change Table Process Ends");

            /** Send Mail */
            Log.info("Send Mail Config Setting True/False based on condition");
            if (changePercent.size() >= 0) {
                sendMail = true;
                if (changePercent.size() > 5) {
                    changeSub = false;
                }
            }


            /** Success Change Table Process Begins */
            Log.info("Success Change Table Process Begins");
            eventDriver.navigate().refresh();

            eventDriver.findElement(By.xpath("//div[@id='cdk-drop-list-0']//fire-navbar-item[3]")).click();
            Thread.sleep(2000);

            eventDriver.findElement(By.xpath("//div[@id='cdk-drop-list-0']//fire-navbar-item[4]")).click();
            Thread.sleep(5000);
            longWait(eventDriver, responseTimeCell);
            Log.info("Open Date Selector");

            eventDriver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            Log.info("Select 24 hrs Data");
            eventDriver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();

            js.executeScript("window.scrollBy(0,150)", "");
            WebDriverWait wait = new WebDriverWait(eventDriver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header-text-wrapper fire-popover-trigger ng-star-inserted']")));
            shortWait(eventDriver, hourlyChange+"[1]");
            Log.info("Sort Success Change Ascending");
            eventDriver.findElement(By.xpath("//span[@class='header-text-wrapper fire-popover-trigger ng-star-inserted']")).click();

            condition = true;
            pages = 1;
            while (condition && pages < 4) {
                Log.info("While Loop Starts for Multiple Pages");
                Log.info("Page Number : "+pages);
                Log.info("Condition TRUE/FALSE : " + condition);
                longWait(eventDriver, hourlyChange+"[1]");
                Thread.sleep(4000);

                for (i = 1; i <= 10; i++) {
                    Log.info("Extracting Response Time For Record Number : "+i+ " And on Page number : "+ pages);
                    respTime = eventDriver.findElement(By.xpath(responseTimeCell+"[" + i + "]")).getText();
//                    respTimeCheck = Float.parseFloat(respTime.replace("s", "").replace("min", ""));
                    shortWait(eventDriver, responseTimeChange);

                    Log.info("Extracting Change Percentage For Record Number : "+i+ " And on Page number : "+ pages);
                    changePer = eventDriver.findElement(By.xpath(responseTimeChange+"[" + i + "]")).getText();
//                    percent = Integer.parseInt(changePer.replace("%", "").replace(",", "").replace("+", "").replace("-", "").replace(">", ""));
                    shortWait(eventDriver, networkApiName);

                    Log.info("Extracting Name For Record Number : "+i+ " And on Page number : "+ pages);
                    name = eventDriver.findElement(By.xpath(networkApiName+"[" + i + "]")).getText();
//                Thread.sleep(1000);
//                Log.info(eventDriver.findElement(By.xpath(networkApiName+"["+i+"]")).getText());
                    shortWait(eventDriver, successPercentage);

                    Log.info("Extracting Api Success Percentage For Record Number : "+i+ " And on Page number : "+ pages);
                    success = eventDriver.findElement(By.xpath(successPercentage+"[" + i + "]")).getText();
                    successCheck = Float.parseFloat(success.replace("%", ""));
//                Thread.sleep(2000);
                    shortWait(eventDriver, sampleSize);

                    Log.info("Extracting API Sample Size For Record Number : "+i+ " And on Page number : "+ pages);
                    sample = eventDriver.findElement(By.xpath(sampleSize+"[" + i + "]")).getText();
                    samplesCheck = Float.parseFloat(sample.replace(" samples", "").replace("K", "").replace("M", ""));

                    Log.info("Extracting 24 Hour change For Record Number : "+i+ " And on Page number : "+ pages);
                    changeSuccess = eventDriver.findElement(By.xpath(hourlyChange+"[" + i + "]")).getText();

                    if ((sample.contains("K") || samplesCheck > 30 || sample.contains("M")) && !name.startsWith("static") && successCheck < 90) {
                        if (changeSuccess.contains("-") || changeSuccess.contains(">")) {

                            Log.info("Adding All Success Change data for Record : "+i+ " For page : "+ pages+" to the respective Lists");
                            responseTime1.add(respTime);
                            changePercent1.add(changePer);
                            apiName1.add(name);
                            apiSuccess1.add(success);
                            apiSample1.add(sample);
                            changeSuccess1.add(changeSuccess);
                        }

                    }

                    js.executeScript("window.scrollBy(0,100)", "");

                }
                try {
                    if (eventDriver.findElement(By.xpath(pageNavigation)).isEnabled()) {
                        Log.info("Clicking > for Next page");
                        eventDriver.findElement(By.xpath(pageNavigation)).click();
                        pages = pages + 1;
                        condition = true;
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    Log.info("EXCEPTION : Clicking > for Next page for Success Change for Success Change");
                    condition = false;
                }
                js.executeScript("window.scrollBy(0,100)", "");
            }

            for (i = 0; i < changePercent1.size(); i++) {
                Log.info(responseTime1.get(i) + "   " + changePercent1.get(i) + "   " + apiName1.get(i) + "   " + apiSuccess1.get(i) + "   " + apiSample1.get(i) + " " + changeSuccess1.get(i));
            }


            /** Send Mail */
            Log.info("Send Mail Config Setting True/False based on condition");
            if (changeSuccess1.size() >= 0) {
                sendMail = true;
                if (changeSuccess1.size() > 5) {
                    changeSub = false;
                }
            }



            eventDriver.quit();

        } catch (Exception e) {

            Log.info("EXCEPTION : Generic Exception Caught in main Code");
            loggingException= String.valueOf(e);
            sendMail=false;
            eventDriver.quit();

        }

        /** Send Mail */

        if (sendMail) {
            Log.info("Send Mail Method Initiated");
            String m;
            int n;
            n = changePercent.size();
            String test = "", testRed = "";
//        testRed = "<H2 style=\"background-color:red;\">Top 5 Crash (URGENT CHECK)</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\">" + "<tr><th>Serial No.</th><th>Title</th><th>Subtitle</th><th>URL</th><th>Version</th><th>Events</th><th>Users</th></tr>";
            test = "<H2>API Performance</H2><H3>Response change</H3><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\"><tr><th>Serial No.</th><th>Api Name</th><th>Sample</th><th>Response Time</th><th>Response percent change</th><th>Success</th></tr>";
            m = "</table>";
            for (i = 1; i <= n; i++) {
                test = test + "<td>" + i + "</td><td>" + apiName.get(i - 1) + "</td><td>" + apiSample.get(i - 1) + "</td><td>" + responseTime.get(i - 1) + "</td><td>" + changePercent.get(i - 1) + "</td><td>" + apiSuccess.get(i - 1) + "</td><tr></tr>";
            }
            if (n == 0) {
                test = test + "<td> No issues </td>";
            }
            test = test + m;
            n = changePercent1.size();

            test = test + "<H3>Success change</H3><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\"><tr><th>Serial No.</th><th>Api Name</th><th>Sample</th><th>Response Time</th><th>Response percent change</th><th>Success</th><th>Success Change</th></tr>";
            for (i = 1; i <= n; i++) {
                test = test + "<td>" + i + "</td><td>" + apiName1.get(i - 1) + "</td><td>" + apiSample1.get(i - 1) + "</td><td>" + responseTime1.get(i - 1) + "</td><td>" + changePercent1.get(i - 1) + "</td><td>" + apiSuccess1.get(i - 1) + "</td><td>" + changeSuccess1.get(i - 1) + "</td><tr></tr>";
            }
            if (n == 0) {
                test = test + "<td> No issues </td>";
            }
            test = test + m;

            Properties props = new Properties();

            // this will set host of server- you can change based on your requirement
            props.put("mail.smtp.host", "10.10.116.180");

            props.put("mail.smtp.starttls.enable", "true");

            // set the authentication to true
            props.put("mail.smtp.auth", "true");

            // set the port of SMTP server
            props.put("mail.smtp.port", "587");

            // Testing
            props.put("mail.transport.protocol", "smtp");
            // This will handle the complete authentication
            Session session = Session.getDefaultInstance(props,

                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {
                            Log.info(usernameMail + passMail);
                            return new PasswordAuthentication(usernameMail, passMail);

                        }

                    });

            String[] recipients = new String[4];
            //recipients[0] = "qafront-end@mobikwik.com";
            recipients[0] = "mayank.suneja@mobikwik.com";
            recipients[1] = "paraj.jain@mobikwik.com";
            recipients[2] = "MBK-Android@mobikwik.com";

            try {

                // Create object of MimeMessage class
                Message message = new MimeMessage(session);

                // Set the from address
                message.setFrom(new InternetAddress("qafront-end@mobikwik.com"));

                // Set the recipient address
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));

                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("MBK-Android@mobikwik.com"));

//                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("wealth-tech@mobikwik.com"));

                // Add the subject link
//                Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //with date and time
//            Log.info(timestamp);
                if (changePercent.size() > 0) {
                    if (changeSub) {
                        message.setSubject("Api Performance | Report | " + java.time.LocalDate.now()); // with only date
                    } else {
                        message.setSubject("!!!!!!!!!!!!!!!!!!!!ALERT!!!!!!!!!!!!!!!!!!!!!!!   Api Performance | Report | " + java.time.LocalDate.now());
                    }
                } else {
                    message.setSubject(":::::::::::::::::::::::Everything Looks good:::::::::::::::::::::: Api Performance | Report | " + java.time.LocalDate.now());
                }

                message.setContent(test, "text/html");


                // finally send the email
                Transport.send(message);

                Log.info("=====Email Sent=====");

            } catch (MessagingException e) {
                Log.info("EXCEPTION : While Sending Mail");
                throw new RuntimeException(e);

            }
        }else {

            /**Sending Suite Failure Mail*/

            Log.info("Send Mail: Suite Failure Method Initiated");

            Properties props = new Properties();

            // this will set host of server- you can change based on your requirement
            props.put("mail.smtp.host", "10.10.116.180");

            props.put("mail.smtp.starttls.enable", "true");

            // set the authentication to true
            props.put("mail.smtp.auth", "true");

            // set the port of SMTP server
            props.put("mail.smtp.port", "587");

            // Testing
            props.put("mail.transport.protocol", "smtp");

            // This will handle the complete authentication
            Session session = Session.getDefaultInstance(props,

                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {
                            Log.info(usernameMail + passMail);
                            return new PasswordAuthentication(usernameMail, passMail);

                        }

                    });

            String[] recipients = new String[4];
            recipients[0] = "mayank.suneja@mobikwik.com";
            recipients[1] = "paraj.jain@mobikwik.com";


            try {

                // Create object of MimeMessage class
                Message message = new MimeMessage(session);

                // Set the from address
                message.setFrom(new InternetAddress("qafront-end@mobikwik.com"));

                // Set the recipient address
//
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));

                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("MBK-Android@mobikwik.com"));

                message.setSubject(" ALERT !!!! SUITE FAILURE | Api Performance | FOCAL : Front-End Team QA Team "); // with only date


                // Append the log.info file for failure

                Log.info("------");

                String messageContent="";
                String logContent=Log.returnLogs();
                messageContent = "<H2>API Performance</H2><H3>Logs Below:</H3>";
                messageContent=messageContent+logContent;
                messageContent=messageContent+"<H3>Exception Below:</H3>";
                messageContent=messageContent+loggingException;

                message.setContent(messageContent, "text/html");


                // finally send the email
                Transport.send(message);

                Log.info("=====Failure Email=====");

                Log.info("=====Email Sent=====");

            } catch (MessagingException e) {

                Log.info("EXCEPTION : While Sending Failure Suite Mail");
                throw new RuntimeException(e);

            }




        }


    }

    public static void shortWait(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element;
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
        } catch (Exception e) {
            Log.info("EXCEPTION : Caught in Short Wait");
            if (!e.toString().contains("TimeoutException")) {
                Assert.assertTrue(false);
            }
        }
    }

    public static void longWait(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            WebElement element;
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
        } catch (Exception e) {

            Log.info("EXCEPTION : Caught in Long Wait");
            if (!e.toString().contains("TimeoutException")) {
                Assert.assertTrue(false);
            }
        }
    }


    /**
     * Method is used to get the TOTP based on the security token
     *
     * @return
     */
    public static String getTwoFactorCode() {

        Totp totp = new Totp("bt2lxmrr5cvg32tp3cnbfkda64gctbki"); // 2FA secret key
        String twoFactorCode = totp.now(); //Generated 2FA code here
        Log.info("Two Factor Code = "+twoFactorCode);
        return twoFactorCode;
    }

}
