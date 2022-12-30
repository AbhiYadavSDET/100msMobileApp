package mbkmerchant.MbkOnlineTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mbkmerchant.MbkOnlineTest.AbstractComponents.AbstractComponent;

public class EpayLoginPage extends AbstractComponent{
	
	WebDriver driver ;
	
	public EpayLoginPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(css="input[formcontrolname='otp']")
	WebElement otp;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	public void userLogin(String otpData)
	{
		otp.sendKeys(otpData);
		submit.click();
	}
	
	

}
