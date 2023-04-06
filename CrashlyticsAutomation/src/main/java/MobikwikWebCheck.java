import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MobikwikWebCheck {

    @Test(groups = {"mobikwikWebCheck"}, priority = 0, description = "Verify Mobikwik Website is Running")
    public static void mbkCheck() throws IOException, InterruptedException {

        // User and pass to send the mail
        String usernameMail = "mobikwiktest123@gmail.com";
        String passMail = "njwqiqohpbaqekuq";

        String mobileNumber="9205299330";
        String otp="547372";
        String data = "";
        String exception="";
        String buildNumber="";

        Boolean userLoggedIn=false;


        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();

        try {

            // Open the Aadhaar Website
            driver.get("https://www.mobikwik.com/");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//span/span[text()='Login']")).click();

            driver.findElement(By.xpath("//input[@id='email']")).click();

            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mobileNumber);

            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Get OTP']")).click();

            driver.findElement(By.xpath("//div/input[@id='otp']")).sendKeys(otp);

            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Submit OTP']")).click();


            SoftAssert val = new SoftAssert();
            val.assertTrue(driver.findElement(By.xpath("//span[text()='Available Balance:']")).isDisplayed(), "User Login Status Check");

            if (driver.findElement(By.xpath("//span[text()='Available Balance:']")).isDisplayed()) {
                userLoggedIn = true;
            }

            buildNumber= driver.findElement(By.xpath("//div[@class='bluebgdark2 tcenter twhite_80 ft13 ln35 copyright']")).getText().replace("© 2023 One MobiKwik Systems Limited | All rights reserved. |", "");

            Thread.sleep(1000);
            driver.quit();


        }catch (Exception e) {

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            exception = sw.toString();
            System.out.println(exception);
            driver.quit();

            }




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


                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("mbk-web@mobikwik.com"));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("paraj.jain@mobikwik.com"));

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                if (userLoggedIn) {
                    message.setSubject("Build Number :"+buildNumber+" MobiKwik Website Running | LOGIN PASS | " + timestamp);
                } else {
                    message.setSubject("ALERT!!!!!!!!!!!!!"+" Build Number :"+buildNumber+" MobiKwik Website Not Running | LOGIN FAILED | " + timestamp + "!!!!!!!!!!!!");
                }

                if (userLoggedIn) {
                    data = data + "<b> User is able to Log in Successfully <br>";
                } else {
                    data = data + "<b> User failed to Log in on Website <br><br><br>" + exception;
                }

                if (userLoggedIn) {
                    message.setContent(data , "text/html");
                } else {
                    message.setContent(data , "text/html");
                }


                // finally send the email
                Transport.send(message);

                System.out.println("=====Email Sent=====");

            } catch (MessagingException e) {

                throw new RuntimeException(e);

            }
        driver.quit();



        }

}
