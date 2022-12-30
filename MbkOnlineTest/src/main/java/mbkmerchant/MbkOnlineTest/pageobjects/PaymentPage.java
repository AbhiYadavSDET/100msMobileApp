package mbkmerchant.MbkOnlineTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mbkmerchant.MbkOnlineTest.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	WebDriver driver ;
	
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//div/span[2]")
	WebElement order;
	
	public String walletPay()
	{
		submit.click();
		String orderId=order.getText();
		return orderId;
		
	}
	
	

}
