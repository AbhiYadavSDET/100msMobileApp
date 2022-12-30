package mbkmerchant.MbkOnlineTest.AbstractComponents;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	
	WebDriver driver ;
	String parentId;
	String childId;
	
	
	public AbstractComponent(WebDriver driver) 
	{
		
		this.driver=driver;

	}
	
}
