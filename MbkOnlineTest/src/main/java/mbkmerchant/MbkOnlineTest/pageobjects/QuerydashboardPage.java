package mbkmerchant.MbkOnlineTest.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mbkmerchant.MbkOnlineTest.AbstractComponents.AbstractComponent;

public class QuerydashboardPage extends AbstractComponent{
	WebDriver driver ;
	String parentId;
	String childId;
	
	public QuerydashboardPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	

	@FindBy(css="input[name='username']")
	WebElement username;
	
	@FindBy(css="input[name='password']")
	WebElement passwd;

	@FindBy(xpath="//input[@value='Log in']")
	WebElement login;

	@FindBy(xpath="//div[@class='form-group']/textarea")
	WebElement textarea;
	
	@FindBy(css=".btn")
	WebElement btn;
	
	@FindBy(xpath="//table[@class='dataframe table table-striped table-bordered']/tbody/tr/td[1]")
	WebElement otp;
	
	public String getOTP(String userName,String password,String query)
	{
		username.sendKeys(userName);
		passwd.sendKeys(password);
		login.click();
		textarea.sendKeys(query);
		btn.click();
		String otpData = otp.getText();
		return otpData;
	}
	
	public void goToDashboard(String queryDashboardUrl)
	{
		driver.get(queryDashboardUrl);

	}
	
	public void switchTab()
	{
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		parentId=it.next();
		childId=it.next();
	}
	
	public void switchToChild()
	{
		driver.switchTo().window(childId);
	}
	
	public void switchToParent()
	{
		driver.switchTo().window(parentId);
	}

}
