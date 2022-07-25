import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.util.Properties;

public class Clevertap {

    @Test(groups = {"clevertapIssues"}, priority = 0, description = "Verify Clevertap crash")
    public static void cleverTap() throws InterruptedException {
        String username = "udit.gupta@mobikwik.com", pass = "Udit@112233";
        String usernameMail = "mbkmobile.team@mobikwik.com";
        String passMail = "Mobikwik@123456";
        String url = "https://in1.dashboard.clevertap.com/844-6K7-984Z/dashboards/custom/1639662815";
        int n, i;
        int threshold = 10;
        boolean checkMail = false;
        int MAX_RETRIES = 2;

        for (int iExcept = 1; iExcept <= MAX_RETRIES; iExcept++) {
            try {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                driver.findElement(By.id("input-15")).sendKeys(username);
                driver.findElement(By.id("input-19")).sendKeys(pass);
                driver.findElement(By.xpath("//span[text()='Log In']")).click();
                Thread.sleep(6000);
                try {
                    driver.switchTo().frame((WebElement) driver.findElement(By.id("wiz-iframe-intent")));
                    if (driver.findElement(By.xpath("//button[@class='announcement-popup__btn announcement-popup__btn_secondary']")).isDisplayed()) {
                        driver.findElement(By.xpath("//button[@class='announcement-popup__btn announcement-popup__btn_secondary']")).click();
                    }
                } catch (Exception e) {
                    if (!e.toString().contains("NoSuchElementException")) {
                        Assert.assertTrue(false);
                    }

                }
                driver.switchTo().defaultContent();

                //for android
                Thread.sleep(4000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,450)", "");

                shortWait(driver, "//div[text()='Zip Repayment-Hourly-Android ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect");
                n = driver.findElements(By.xpath("//div[text()='Zip Repayment-Hourly-Android ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect")).size();
                System.out.println(n);
                String[] data = new String[2];
                String[] d;
                int[] data1 = new int[2];
                int j = 0;
                if (n - 2 >= 0) {
                    for (i = n; i > n - 2; i--) {
                        d = driver.findElement(By.xpath("//div[text()='Zip Repayment-Hourly-Android ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect[" + i + "]")).getAttribute("aria-label").split(", ");
                        data[j] = d[1].trim().replace(",", "");
                        data1[j] = Integer.parseInt(data[j].substring(0, data[j].length() - 1));
                        j++;
                    }
                } else if (n - 1 == 0) {
                    i = 1;
                    d = driver.findElement(By.xpath("//div[text()='Zip Repayment-Hourly-Android ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect[" + i + "]")).getAttribute("aria-label").split(", ");
                    data[j] = d[1].trim().replace(",", "");
                    data1[j] = Integer.parseInt(data[j].substring(0, data[j].length() - 1));
                } else if (n == 0) {
//            checkMail=true;
                }
                int check;
                if (n - 2 >= 0) {
                    check = 2;
                } else {
                    check = n;
                }
                for (i = 0; i < check; i++) {
                    System.out.println(data1[i]);
                    if (data1[i] <= threshold) {
                        checkMail = true;
                    }
                }

                //For ios
                js.executeScript("window.scrollBy(0,350)", "");

                shortWait(driver, "//div[text()='Zip Repayment-Hourly-ios ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect");
                n = driver.findElements(By.xpath("//div[text()='Zip Repayment-Hourly-ios ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect")).size();
                System.out.println(n);
                String[] dataios = new String[2];
                String[] dios;
                int[] data1ios = new int[2];
                j = 0;
                if (n - 2 >= 0) {
                    for (i = n; i > n - 2; i--) {
                        dios = driver.findElement(By.xpath("//div[text()='Zip Repayment-Hourly-ios ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect[" + i + "]")).getAttribute("aria-label").split(", ");
                        dataios[j] = dios[1].trim().replace(",", "");
                        data1ios[j] = Integer.parseInt(dataios[j].substring(0, dataios[j].length() - 1));
                        j++;
                    }
                } else if (n - 1 == 0) {
                    i = 1;
                    dios = driver.findElement(By.xpath("//div[text()='Zip Repayment-Hourly-ios ']/parent::div//*[@class='highcharts-series-group']/svg:g/svg:rect[" + i + "]")).getAttribute("aria-label").split(", ");
                    dataios[j] = dios[1].trim().replace(",", "");
                    data1ios[j] = Integer.parseInt(dataios[j].substring(0, dataios[j].length() - 1));
                } else if (n == 0) {
//            checkMail=true;
                }
                if (n - 2 >= 0) {
                    check = 2;
                } else {
                    check = n;
                }
                for (i = 0; i < check; i++) {
                    System.out.println(data1ios[i]);
                    if (data1ios[i] <= threshold) {
                        checkMail = true;
                    }
                }


                ////Send mail
                if (checkMail) {
                    String clevertapMail;
                    clevertapMail = "<H2 style=\"background-color:red;\"> Issue in Clevertap </H2><t1> Check " + url + " </t1>";

                    Properties props = new Properties();

                    // this will set host of server- you can change based on your requirement
                    props.put("mail.smtp.host", "smtp.gmail.com");

                    // set the port of socket factory
                    props.put("mail.smtp.socketFactory.port", "465");

                    // set socket factory
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                    // set the authentication to true
                    props.put("mail.smtp.auth", "true");

                    // set the port of SMTP server
                    props.put("mail.smtp.port", "465");

                    // This will handle the complete authentication
                    Session session = Session.getDefaultInstance(props,

                            new javax.mail.Authenticator() {

                                protected PasswordAuthentication getPasswordAuthentication() {

                                    return new PasswordAuthentication(usernameMail, passMail);

                                }

                            });

                    try {

                        // Create object of MimeMessage class
                        Message message = new MimeMessage(session);

                        // Set the from address
                        message.setFrom(new InternetAddress("qafront-end@mobikwik.com"));

                        // Set the recipient address
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("qafront-end@mobikwik.com"));

                        // Add the subject link
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            System.out.println(timestamp);
                        message.setSubject("CleverTap | Report | " + timestamp);

                        message.setContent(clevertapMail, "text/html");

                        // finally send the email
                        Transport.send(message);

                        System.out.println("=====Email Sent=====");

                    } catch (MessagingException e) {

                        throw new RuntimeException(e);

                    }
                }

                driver.close();
                ///// Breaking on success
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (iExcept == MAX_RETRIES) {
                    throw e;
                }
            }
        }
    }

    public static void shortWait(WebDriver driver,String text){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element;
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
        } catch (Exception e){
            if(!e.toString().contains("TimeoutException")){
                Assert.assertTrue(false);
            }
        }
    }
}
