package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup extends TestBase{


	/**
	 * This method is used to get Pop details
	 * @param driver
	 * @return
	 */
	public static Alert getPopup(WebDriver driver)
	{
		try
		{
			String waitTime=properties.getProperty("ImplicitWaitTime");
			Long ObjectWaitTime = Long.parseLong(waitTime);
			WebDriverWait wait = new WebDriverWait(driver, ObjectWaitTime);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			Config.logComment("Got the Alert with text '" + alert.getText() + "'");
			return alert;
		}
		catch(Exception e)
		{
			Config.logComment("Exception while getting the PopUp...");
			Config.logWarning(e.toString());
			return null;		
		}
	}

	/**
	 * This method is used to check id alert id present
	 * @param driver
	 * @return
	 */
	public static boolean isAlertPresent(WebDriver driver)
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			Config.logComment("Got the Alert with text '" + alert.getText() + "'");
			return true;
		}
		catch (Exception e)
		{
			Config.logComment("Checked alert is not present");
			return false;
		}
	}

	/**
	 * This method is used to dismiss a popup
	 * @param driver
	 */
	public static void dismissPopup(WebDriver driver)
	{
		Alert alert = getPopup(driver);

		if (alert != null)
		{
			alert.dismiss();
			driver.switchTo().defaultContent();
			Config.logComment("Dismissed the Pop-up.");
		}

	}

	/**
	 * This method is used to Accept a popup
	 * @param driver
	 */
	public static void acceptPopup(WebDriver driver)
	{
		Alert alert = getPopup(driver);

		if (alert != null)
		{
			alert.accept();
			driver.switchTo().defaultContent();
			Config.logComment("Accepted the Pop-up.");
		}

	}

	/**
	 * This method is used to get text of a popup
	 * @param driver
	 */
	public static String getPopupText(WebDriver driver)
	{
		Alert alert = getPopup(driver);
		String text = alert.getText();
		return text;
	}
}
