package mbkmerchant.MbkOnlineTest.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import mbkmerchant.MbkOnlineTest.pageobjects.HtmlPage;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//mbkmerchant//MbkOnlineTest//resources//GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			//safari
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public HtmlPage launchApplication(String htmlPageUrl) throws IOException
	{
		
		driver=initializeDriver();
		HtmlPage htmlPage= new HtmlPage(driver);
		htmlPage.goTo(htmlPageUrl);
		return htmlPage;
		
	}
	
	public void powerWalletOTPGen(String cellNum,String amount,String mid) throws IOException
	{
		driver=initializeDriver();
		driver.get("https://walletapi.mobikwik.com/otpgenerate?checksum=d3010da59cd8a6fc7d955bbf09db49beb6050a5ee7e5ee9f11e0a8fc48d0d5a8&cell="+cellNum+"&amount="+amount+"&tokentype=0&msgcode=504&mid="+mid+"&merchantname=Test Merchant");
			
	}
	
	public void powerWalletAddMoneyDebit(String cellNum,String amount,String mid, String otp)
	{
		driver.get("https://walletapi.mobikwik.com/walletapis/addmoneytowalletanddebit?checksum=055d6ccb9808acfe2b4525c85bdd3e168a79bc90db2f0060587d19eb322a3b45&amount="+amount+"&mid="+mid+"&merchantname=Test Merchant&orderid=ORDER5426857684EQRR&redirecturl=https://stagingmerchant.mobikwik.com/views/demoreturnmerchant.jsp&otp="+otp+"&cell="+cellNum);
	}
	
	
	

}
