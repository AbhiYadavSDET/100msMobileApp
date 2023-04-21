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
        System.out.println("Branch : Master");

        /** Username and Password to login on Firebase */

        System.out.println("Username and Password to login on Firebase");

        String usernameWebLogin = "mbkmobile.team@mobikwik.com";
        String passWebLogin = "Mobikwik@12345";

        /**Username and Password will be used to send mail */
        System.out.println("Username and Password will be used to send mail");

//        String usernameMail = "mobikwiktest123@gmail.com";
//        String passMail = "njwqiqohpbaqekuq";

        String usernameMail = "dont-reply@mobikwik.com";
        String passMail = "mobikwik123#";



        /**BrowserStack Credentials */
        String username = "parajjain_X3pLgw";
        String accessKey = "5QyNfuj7vp3qsNWTvWsF";
//        String buildName = "TestMbk";



        /** Variables Declaration */
        System.out.println("Variables Declaration");

        String respTime, changePer, name, success, sample, changeSuccess;
        float respTimeCheck, successCheck;
        int i, percent, pages = 1;
        float samplesCheck;
        Boolean condition = true, sendMail = false, changeSub = true;


        /** Array List for Data */
        System.out.println("Array List for Data");

        ArrayList<String> responseTime = new ArrayList<String>();
        ArrayList<String> changePercent = new ArrayList<String>();
        ArrayList<String> apiName = new ArrayList<String>();
        ArrayList<String> apiSuccess = new ArrayList<String>();
        ArrayList<String> apiSample = new ArrayList<String>();
        ArrayList<String> responseTime1 = new ArrayList<String>();
        ArrayList<String> changePercent1 = new ArrayList<String>();
        ArrayList<String> apiName1 = new ArrayList<String>();
        ArrayList<String> apiSuccess1 = new ArrayList<String>();
        ArrayList<String> apiSample1 = new ArrayList<String>();
        ArrayList<String> changeSuccess1 = new ArrayList<String>();



//        /** Initiating Chrome driver */
//        System.out.println("Initiating Chrome driver");
//
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
////        WebDriver driver = new ChromeDriver();
//
//
////        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//
//        WebDriver driver = new ChromeDriver(chromeOptions);

//        LogEntries log= driver.manage().logs().get("browser");
//        List<LogEntry> logs=log.getAll();



        /** Initiating Browserstack Chrome driver */
        System.out.println("Initiating Browserstack Chrome driver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("name", "MBKTest"); // test buildName
//        capabilities.setCapability("build", buildName); // CI/CD job name using BROWSERSTACK_BUILD_NAME env variable

        WebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);




        try {

            /** Opening Firebase URL */
            System.out.println("Opening Firebase URL");

            driver.get("https://console.firebase.google.com");
            driver.manage().window().maximize();

            /** Logging into Firebase  */
            System.out.println("Logging into Firebase");
            driver.findElement(By.id("identifierId")).sendKeys(usernameWebLogin);
            driver.findElement(By.xpath("//*[text()='Next']")).click();

            shortWait(driver, "//input[@type='password']");
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWebLogin);
            driver.findElement(By.xpath("//*[text()='Next']")).click();

            /**
             *We have setup intellij as Authenticator and using it also to generate otp to login
             */




            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);

            System.out.println("Tap Google Authenticator");

            try{
            if (driver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).isDisplayed()){
                driver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).click();
            }

        } catch (Exception e)
            {
                System.out.println("Exception : Try Another Way , Then Tap Google Authenticator");
                driver.findElement(By.xpath("//span[text()= 'Try another way']")).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                Thread.sleep(5000);
                driver.findElement(By.xpath("//div[@class= 'vxx8jf']/strong[text()= 'Google Authenticator']")).click();

            }

            /** Getting 2FA Code from the method getTwoFactorCode : Which is set as authenticator App */

            System.out.println("Getting 2FA Code from the method getTwoFactorCode : Which is set as authenticator App");

            shortWait(driver, "//input[@name='totpPin']");
            driver.findElement(By.xpath("//input[@name='totpPin']")).sendKeys(getTwoFactorCode());
            driver.findElement(By.xpath("//*[text()='Next']")).click();

            /** Test Case Starts */

            System.out.println("Test Case Starts");


            System.out.println("Project Selector Page");
            longWait(driver, "//*[contains(text(),'Mobikwik Android')]");
            driver.findElement(By.xpath("//*[contains(text(),'Mobikwik Android')]")).click();
            longWait(driver, "//div[text()=' Release & Monitor ']");
            try {
                System.out.println("Select Performance Main Title from Side Drawer");
                driver.findElement(By.xpath("//div[text()='Performance']")).click();
            } catch (Exception e) {
                System.out.println("Select Performance Backup under Release & Monitor from Side Drawer");
                driver.findElement(By.xpath("//div[text()=' Release & Monitor ']")).click();

                Thread.sleep(2000);

                shortWait(driver, "//a[@role='treeitem']//div[text()='Performance']");
                driver.findElement(By.xpath("//a[@role='treeitem']//div[text()='Performance']")).click();
            }

            /** App Selector */


            System.out.println("Open App Selector Dropdown");
            shortWait(driver, "//div[@class='selected-resource-wrapper']");
            driver.findElement(By.xpath("//div[@class='selected-resource-wrapper']")).click();
            Thread.sleep(2000);

            /** Select Mobikwik Consumer App from the List */

            System.out.println("Select Mobikwik Consumer App from the List");

            shortWait(driver, "//button[@role='menuitem']//span[text()='Mobikwik Consumer App']");
            driver.findElement(By.xpath("//button[@role='menuitem']//span[text()='Mobikwik Consumer App']")).click();

            /** Setting period for Results from Calender Icon */

            System.out.println("Setting period for Results from Calender Icon");

            longWait(driver, "//div[@class='date-selection']");
            driver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();

            System.out.println("Scroll to View Api Data");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,150)", "");

            /** Extracting Data and validating through conditions */
            /** Locators of Network Request Tables */

            System.out.println("Extracting Data and validating through conditions");

            String responseTimeCell="(//mat-cell[@class='mat-cell cdk-cell metric-value-cell cdk-column-RESPONSE_TIME_LATEST_VALUE mat-column-RESPONSE_TIME_LATEST_VALUE ng-star-inserted'])";
            String responseTimeChange= "(//mat-cell[@class='mat-cell cdk-cell metric-delta-cell extended cdk-column-RESPONSE_TIME_DELTA mat-column-RESPONSE_TIME_DELTA ng-star-inserted'])";
            String networkApiName= "(//a[@class='mat-mdc-tooltip-trigger fire-router-link-host data-text-wrapper'])";
            String successPercentage= "(//mat-cell[@class='mat-cell cdk-cell metric-value-cell cdk-column-SUCCESS_RATE_LATEST_VALUE mat-column-SUCCESS_RATE_LATEST_VALUE ng-star-inserted'])";
            String sampleSize= "(//div[@class='resource-subtitle ng-star-inserted']/p)";
            String hourlyChange="(//mat-cell[@class='mat-cell cdk-cell metric-delta-cell standard cdk-column-SUCCESS_RATE_DELTA mat-column-SUCCESS_RATE_DELTA ng-star-inserted'])";
            String pageNavigation="//button[@aria-label='Next page']";


            while (condition && pages < 4) {
                longWait(driver, responseTimeCell);
                Thread.sleep(4000);
                for (i = 1; i <= 10; i++) {

                    respTime = driver.findElement(By.xpath(responseTimeCell+"[" + i + "]")).getText();
                    respTimeCheck = Float.parseFloat(respTime.replace("s", "").replace("min", ""));
                    shortWait(driver, responseTimeChange);
                    changePer = driver.findElement(By.xpath(responseTimeChange+"[" + i + "]")).getText();
                    percent = Integer.parseInt(changePer.replace("%", "").replace(",", "").replace("+", "").replace("-", "").replace(">", ""));

                    shortWait(driver, networkApiName);
                    name = driver.findElement(By.xpath(networkApiName+"[" + i + "]")).getText();

                    shortWait(driver, successPercentage);
                    success = driver.findElement(By.xpath(successPercentage+"[" + i + "]")).getText();

                    shortWait(driver, sampleSize);
                    sample = driver.findElement(By.xpath(sampleSize+"[" + i + "]")).getText();
                    samplesCheck = Float.parseFloat(sample.replace(" samples", "").replace("K", "").replace("M", ""));

                    if ((respTimeCheck > 10 || respTime.contains("min")) && percent > 100 && (sample.contains("K") || samplesCheck > 30 || sample.contains("M"))) {
                        if (changePer.contains("+") || changePer.contains(">")) {
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
                    if (driver.findElement(By.xpath(pageNavigation)).isEnabled()) {
                        driver.findElement(By.xpath(pageNavigation)).click();
                        pages = pages + 1;
                        condition = true;
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    condition = false;
                }
                js.executeScript("window.scrollBy(0,100)", "");
            }

            if (changePercent.size() >= 0) {
                sendMail = true;
                if (changePercent.size() > 5) {
                    changeSub = false;
                }
            }


            driver.navigate().refresh();
            Thread.sleep(2000);
            longWait(driver, "//div[@class='date-selection']");
            driver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();

            js.executeScript("window.scrollBy(0,150)", "");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header-text-wrapper ng-star-inserted']")));
            shortWait(driver, hourlyChange+"[1]");
            driver.findElement(By.xpath("(//span[@class='header-text-wrapper ng-star-inserted'])[5]")).click();

            condition = true;
            pages = 1;
            while (condition && pages < 4) {
                longWait(driver, hourlyChange+"[1]");
                Thread.sleep(4000);
                for (i = 1; i <= 10; i++) {
                    respTime = driver.findElement(By.xpath(responseTimeCell+"[" + i + "]")).getText();
//                    respTimeCheck = Float.parseFloat(respTime.replace("s", "").replace("min", ""));
                    shortWait(driver, responseTimeChange);
                    changePer = driver.findElement(By.xpath(responseTimeChange+"[" + i + "]")).getText();
//                    percent = Integer.parseInt(changePer.replace("%", "").replace(",", "").replace("+", "").replace("-", "").replace(">", ""));

                    shortWait(driver, networkApiName);
                    name = driver.findElement(By.xpath(networkApiName+"[" + i + "]")).getText();
//                Thread.sleep(1000);
//                System.out.println(driver.findElement(By.xpath(networkApiName+"["+i+"]")).getText());
                    shortWait(driver, successPercentage);
                    success = driver.findElement(By.xpath(successPercentage+"[" + i + "]")).getText();
                    successCheck = Float.parseFloat(success.replace("%", ""));
//                Thread.sleep(2000);
                    shortWait(driver, sampleSize);
                    sample = driver.findElement(By.xpath(sampleSize+"[" + i + "]")).getText();
                    samplesCheck = Float.parseFloat(sample.replace(" samples", "").replace("K", "").replace("M", ""));

                    changeSuccess = driver.findElement(By.xpath(hourlyChange+"[" + i + "]")).getText();

                    if ((sample.contains("K") || samplesCheck > 30 || sample.contains("M")) && !name.startsWith("static") && successCheck < 90) {
                        if (changeSuccess.contains("-") || changeSuccess.contains(">")) {
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
                    if (driver.findElement(By.xpath(pageNavigation)).isEnabled()) {
                        driver.findElement(By.xpath(pageNavigation)).click();
                        pages = pages + 1;
                        condition = true;
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    condition = false;
                }
                js.executeScript("window.scrollBy(0,100)", "");
            }
            for (i = 0; i < changePercent1.size(); i++) {
                System.out.println(responseTime1.get(i) + "   " + changePercent1.get(i) + "   " + apiName1.get(i) + "   " + apiSuccess1.get(i) + "   " + apiSample1.get(i) + " " + changeSuccess1.get(i));
            }
            if (changeSuccess1.size() >= 0) {
                sendMail = true;
                if (changeSuccess1.size() > 5) {
                    changeSub = false;
                }
            }


//        try{
            driver.quit();
//        }catch (Exception e) {
//            driver.close();
//        }
        } catch (Exception e) {

            driver.quit();
//            throw e;
        }

        if (sendMail) {
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
                            System.out.println(usernameMail + passMail);
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

                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("wealth-tech@mobikwik.com"));

                // Add the subject link
//                Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //with date and time
//            System.out.println(timestamp);
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

                System.out.println("=====Email Sent=====");

            } catch (MessagingException e) {

                throw new RuntimeException(e);

            }
        }else {

            /**Sending Suite Failure Mail*/


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
                            System.out.println(usernameMail + passMail);
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

//                String messageContent= logs.toString();
                String messageContent="";
                System.out.println("------");


                message.setContent(messageContent, "text/html");


                // finally send the email
                Transport.send(message);

                System.out.println("=====Failure Email=====");

                System.out.println("=====Email Sent=====");

            } catch (MessagingException e) {

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
        System.out.println("Two Factor Code = "+twoFactorCode);
        return twoFactorCode;
    }

}
