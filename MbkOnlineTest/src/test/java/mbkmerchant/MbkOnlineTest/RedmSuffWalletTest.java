package mbkmerchant.MbkOnlineTest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mbkmerchant.MbkOnlineTest.TestComponents.BaseTest;
import mbkmerchant.MbkOnlineTest.pageobjects.EpayLoginPage;
import mbkmerchant.MbkOnlineTest.pageobjects.HtmlPage;
import mbkmerchant.MbkOnlineTest.pageobjects.PaymentPage;
import mbkmerchant.MbkOnlineTest.pageobjects.QuerydashboardPage;

public class RedmSuffWalletTest extends BaseTest{

	@Test
	public void redmWalleTxn() throws IOException{
		// TODO Auto-generated method stub
		
		String amount="1";
		String cellNum="9530384776";
		String mid="MBK8780739";
		String userName="abhinav.chauhan@mobikwik.com";
		String password="Password";
		String query="select *,otp P from otpdata where cell='9530384776' limit 10;";
		String htmlPageUrl="file://///Users/abhinavsinghchauhan/Documents/REDM_Testing/prodnew.html";
		String queryDashboardUrl="https://mbk-query.mobikwik.com/dataccess/mysql";
		
		HtmlPage htmlPage=launchApplication(htmlPageUrl);
	
		QuerydashboardPage querydashboardPage = htmlPage.htmlSubmit(amount,cellNum,mid);
		querydashboardPage.switchTab();
		querydashboardPage.goToDashboard(queryDashboardUrl);
		String otpData = querydashboardPage.getOTP(userName,password,query);
		//switch to e-pay
		querydashboardPage.switchToParent();	
		
		EpayLoginPage epayLoginPage=new EpayLoginPage(driver);
		epayLoginPage.userLogin(otpData);
		
		//place order
		PaymentPage paymentPage=new PaymentPage(driver);
		String orderId=paymentPage.walletPay();
		System.out.println(orderId);		

	}
	
	

}
