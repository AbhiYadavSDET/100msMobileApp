package mbkmerchant.MbkOnlineTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mbkmerchant.MbkOnlineTest.AbstractComponents.AbstractComponent;

public class PowerWalletLocalHostPage extends AbstractComponent{
	
WebDriver driver ;
	
	public PowerWalletLocalHostPage (WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//PageFactory
	@FindBy(xpath="//input[contains(@value,'otp')]")
	WebElement otpBullet;

	@FindBy(xpath="//input[@value='Submit']")
	WebElement otpGenSubmit;
	

}
