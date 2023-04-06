import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class MobikwikB2BCheck {

    @Test(groups = {"mobikwikB2BCheck"}, priority = 0, description = "Verify Mobikwik B2B is Running")
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
            driver.get("https://b2b.mobikwik.com/prepaid-recharge?mid=ix101");
            Dimension dm = new Dimension(400,900);
            driver.manage().window().setSize(dm);
            Thread.sleep(1000);
            driver.get("https://b2b.mobikwik.com/prepaid-recharge?mid=ix101");

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//input[@id='email']")).click();

            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mobileNumber);

            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Continue']")).click();

            driver.findElement(By.xpath("//input[@id='otp']")).click();

            driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);

            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Submit OTP']")).click();


            SoftAssert val = new SoftAssert();
            val.assertTrue(driver.findElement(By.xpath("//small[text()='Available Balance']")).isDisplayed(), "User Login Status Check");

            if (driver.findElement(By.xpath("//small[text()='Available Balance']")).isDisplayed()) {
                userLoggedIn = true;
            }

            buildNumber= driver.findElement(By.xpath("//div[@class='tcenter footerColor ft13 ln35 smleft28 smright28']")).getText().replace("Powered By One MobiKwik Systems Limited |", "");

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

//                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("paraj.jain@mobikwik.com"));

                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("mbk-web@mobikwik.com"));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("paraj.jain@mobikwik.com"));

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                if (userLoggedIn) {
                    message.setSubject("Build Number :"+buildNumber+" MobiKwik B2B Running | LOGIN PASS | " + timestamp);
                } else {
                    message.setSubject("ALERT!!!!!!!!!!!!!"+" Build Number :"+buildNumber+" MobiKwik B2B Not Running | LOGIN FAILED | " + timestamp + "!!!!!!!!!!!!");
                }

                if (userLoggedIn) {
                    data = data + "<b> User is able to Log in Successfully on Ixigo B2B <br>";
                } else {
                    data = data + "<b> User failed to Log in on Ixigo B2B <br><br><br>" + exception;
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
