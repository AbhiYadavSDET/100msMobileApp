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
import utils.Elements;
import utils.Mailer;


public class AadharCaptchaCheck {
    @Test(groups = {"aadharCheckCaptcha"}, priority = 0, description = "Verify Clevertap crash")
    public static void aadharCheck() throws IOException, InterruptedException {
        String username = "mbkmobile.team@mobikwik.com";
        String pass = "Mobikwik@123456";
        String data = "";
        String subject = "";
        String sentFrom = "qafront-end@mobikwik.com";
        String mailTo = "ashishkumarpradhan2022@gmail.com," +
                "ashish.pradhan@mobikwik.com";
        String mailCC = "vipul.behl@mobikwik.com," +
                "aditya.upadhyay@mobikwik.com," +
                "paraj.jain@mobikwik.com";
        String mailBCC = "";

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
            //driver.get("https://www.mobikwik.com/");
            driver.manage().window().maximize();

            if(Elements.isElementPresent(driver,"//button[@class='button_btn__1dRFj' and contains(text(), 'Login')]")){
                driver.findElement(By.xpath("//button[@class='button_btn__1dRFj' and contains(text(), 'Login')]")).click();
            }
            // Click on the Login Button


            Thread.sleep(5000);


            while (refreshFlag < 2) {
                Thread.sleep(5000);
                System.out.println("regreshFalg : " + refreshFlag);

                // Setting the values of both the text on the screen
                aadharText = Elements.isElementPresent(driver,"//span[@class='label-span' and contains(text(), 'Enter Aadhaar')]");
                captchaText = Elements.isElementPresent(driver,"//span[@class='label-span' and contains(text(), 'Enter Above Captcha')]");

                if (Elements.isElementPresent(driver,"//div[@id = 'captcha_block']/img")) {
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
                    }

                    System.out.println(getText);
                }
                refreshFlag = refreshFlag + 1;

            }

            if (captchaImage) {
                subject = "Aadhar captcha Check | Pass | ";
            } else {
                subject = "ALERT!!!!!!!!!!!!!Aadhar captcha Check | Fail | ";
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
                data = data + " Captcha is present";
            } else {
                data = data + " Captcha is not present";
            }

            Mailer.sendMail(subject,data,sentFrom,mailTo,mailCC,mailBCC);


            driver.close();
        } catch (Exception e) {
            //throw e;
            driver.close();
        }
    }

}




