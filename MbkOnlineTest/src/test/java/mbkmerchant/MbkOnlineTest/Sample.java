package mbkmerchant.MbkOnlineTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String amount="1";
		String cellNum="9530384776";
		String mid="MBK8780739";
		String userName="abhinav.chauhan@mobikwik.com";
		String password="Rajput@54";
		String query="select *,otp P from otpdata where cell='9530384776' limit 10;";
		String htmlPageUrl="file://///Users/abhinavsinghchauhan/Documents/REDM_Testing/prodnew.html";
		String queryDashboardUrl="https://mbk-query.mobikwik.com/dataccess/mysql";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(htmlPageUrl);

		//HTMLForm submission
		driver.get("file://///Users/abhinavsinghchauhan/Documents/REDM_Testing/prodnew.html");		
		driver.findElement(By.cssSelector("#amt")).sendKeys(amount);
		driver.findElement(By.cssSelector("input[id='cell']")).sendKeys(cellNum);
		driver.findElement(By.xpath("//input[@id='mid']")).clear();
		driver.findElement(By.xpath("//input[@id='mid']")).sendKeys(mid);
		driver.findElement(By.xpath("//input[contains(@id,'proc')]")).click();
		
		
		
		// opening to new Tab and passing driver control to new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
	
		//launching URL to new tab opened
		
		driver.get(queryDashboardUrl);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.xpath("//div[@class='form-group']/textarea")).sendKeys(query);
		driver.findElement(By.cssSelector(".btn")).click();
		String otpData=driver.findElement(By.xpath("//table[@class='dataframe table table-striped table-bordered']/tbody/tr/td[1]")).getText();
		System.out.println(otpData);
		
		//switch to e-pay
		driver.switchTo().window(parentId);
		
		driver.findElement(By.cssSelector("input[formcontrolname='otp']")).sendKeys(otpData);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//place order
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String orderId=driver.findElement(By.xpath("//div/span[2]")).getText();

		
		
		

	}

}
