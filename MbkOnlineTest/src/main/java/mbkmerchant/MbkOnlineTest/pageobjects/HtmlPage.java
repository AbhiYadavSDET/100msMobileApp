package mbkmerchant.MbkOnlineTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mbkmerchant.MbkOnlineTest.AbstractComponents.AbstractComponent;

public class HtmlPage extends AbstractComponent{
	
	WebDriver driver ;
	
	public HtmlPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//PageFactory
	//WebElement t = driver.findElement(By.cssSelector("#amt"))
	@FindBy(css="#amt")
	WebElement amt;
	//driver.findElement(By.cssSelector("input[id='cell']"))
	@FindBy(css="input[id='cell']")
	WebElement cell;
	//driver.findElement(By.xpath("//input[@id='mid']"))
	@FindBy(xpath="//input[@id='mid']")
	WebElement mid;
	//driver.findElement(By.xpath("//input[contains(@id,'proc')]"))
	@FindBy(xpath="//input[contains(@id,'proc')]")
	WebElement submit;
	
	
	public QuerydashboardPage htmlSubmit(String amount,String cellNum,String mId)
	{
		amt.sendKeys(amount);
		cell.sendKeys(cellNum);
		mid.clear();
		mid.sendKeys(mId);
		submit.click();
		QuerydashboardPage querydashboardPage=new QuerydashboardPage(driver);
		return querydashboardPage;
		
	}
	
	public void goTo(String htmlPageUrl)
	{
		driver.get(htmlPageUrl);
	}
	
}
