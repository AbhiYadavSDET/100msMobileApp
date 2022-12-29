import com.asprise.ocr.Ocr;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;


public class AadharCaptchaCheck {
    @Test(groups = {"aadharCheckCaptcha"}, priority = 0, description = "Verify Clevertap crash")
    public static void aadharCheck() throws IOException, InterruptedException {
        String username = "mbkmobile.team@mobikwik.com";
        String pass = "Mobikwik@123456", data = "";

        // User and pass to send the mail
        String usernameMail = "mobikwiktest123@gmail.com";
        String passMail = "njwqiqohpbaqekuq";

        Boolean aadharText = false, captchaText = false, captchaImage = false;
        int refreshFlag = 0;
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
        try {

            // Open the Aadhaar Website
            driver.get("https://myaadhaar.uidai.gov.in/");
            driver.manage().window().maximize();

            // Click on the Login Button
            driver.findElement(By.xpath("//button[@class='button_btn__1dRFj' and contains(text(), 'Login')]")).click();

            Thread.sleep(5000);


            while (refreshFlag < 2) {
                Thread.sleep(5000);
                System.out.println("regreshFalg : " + refreshFlag);
                SoftAssert ar = new SoftAssert();
                ar.assertTrue(driver.findElement(By.xpath("//span[@class='label-span' and contains(text(), 'Enter Aadhaar')]")).isDisplayed(), "Aadhar card text check");
                ar.assertTrue(driver.findElement(By.xpath("//span[@class='label-span' and contains(text(), 'Enter Above Captcha')]")).isDisplayed(), "Captcha text check");
                ar.assertTrue(driver.findElement(By.xpath("//div[@id = 'captcha_block']/img")).isDisplayed(), "Captcha image check");

                // Setting the values of both the text on the screen
                aadharText = driver.findElement(By.xpath("//span[@class='label-span' and contains(text(), 'Enter Aadhaar')]")).isDisplayed();
                captchaText = driver.findElement(By.xpath("//span[@class='label-span' and contains(text(), 'Enter Above Captcha')]")).isDisplayed();

                if (driver.findElement(By.xpath("//div[@id = 'captcha_block']/img")).isDisplayed()) {
                    File src = ((TakesScreenshot) driver.findElement(By.xpath("//div[@id = 'captcha_block']/img"))).getScreenshotAs(OutputType.FILE);
                    File dest = new File(System.getProperty("user.dir") + "/Test1.jpg");

                    FileUtils.copyFile(src, dest);
                    System.out.println("Files copied from : " + src + " --> " + dest);
                    Ocr.setUp();
                    Ocr ocr = new Ocr();

                    ocr.startEngine("eng", Ocr.SPEED_FASTEST);

                    String getText = ocr.recognize(new File[]{new File(System.getProperty("user.dir") + "/Test1.jpg")},
                            Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);

                    ocr.stopEngine();

                    if (!getText.isEmpty()) {
                        captchaImage = true;
                        break;
                    } else {
                        driver.findElement(By.xpath("//button[@class = 'fa fa-refresh icon-style']")).click();
                        refreshFlag = refreshFlag + 1;
                    }

                    System.out.println(getText);
                }

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
//            message.setFrom(new InternetAddress("qafront-end@mobikwik.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mayank.suneja@mobikwik.com"));
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("vipul.behl@mobikwik.com"));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("aditya.upadhyay@mobikwik.com"));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("paraj.jain@mobikwik.com"));

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                if (captchaImage) {
                    message.setSubject("Aadhar captcha Check | Pass | " + timestamp);
                } else {
                    message.setSubject("ALERT!!!!!!!!!!!!!Aadhar captcha Check | Fail | " + timestamp + "!!!!!!!!!!!!");
                }

                if (aadharText) {
                    data = data + "<b> Aadhar text is present <br>";
                } else {
                    data = data + "<b> Aadhar text is not present <br>";
                }
                if (captchaText) {
                    data = data + " Captcha text is present <br>";
                } else {
                    data = data + " Captcha text is not present <br>";
                }
                if (captchaImage) {
                    message.setContent(data + " Captcha is present", "text/html");
                } else {
                    message.setContent(data + " Captcha is not present", "text/html");
                }


                // finally send the email
                Transport.send(message);

                System.out.println("=====Email Sent=====");

            } catch (MessagingException e) {

                throw new RuntimeException(e);

            }
            driver.close();
        } catch (Exception e) {
            //throw e;
            driver.close();
        }
    }

}




