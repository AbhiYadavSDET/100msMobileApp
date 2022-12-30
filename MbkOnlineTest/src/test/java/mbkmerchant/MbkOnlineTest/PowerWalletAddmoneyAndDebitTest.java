package mbkmerchant.MbkOnlineTest;

import java.io.IOException;

import org.testng.annotations.Test;

import mbkmerchant.MbkOnlineTest.TestComponents.BaseTest;
import mbkmerchant.MbkOnlineTest.pageobjects.EpayLoginPage;
import mbkmerchant.MbkOnlineTest.pageobjects.HtmlPage;
import mbkmerchant.MbkOnlineTest.pageobjects.PaymentPage;
import mbkmerchant.MbkOnlineTest.pageobjects.QuerydashboardPage;

public class PowerWalletAddmoneyAndDebitTest extends BaseTest{
	
	@Test
	public void powerWallerAddMoneyDebitSuffTxn() throws IOException{
		
		String amount="1";
		String cellNum="9530384776";
		String mid="MBK76624";
		String userName="abhinav.chauhan@mobikwik.com";
		String password="Rajput@54";
		String query="select *,otp P from otpdata where cell='9530384776' limit 10;";
		String queryDashboardUrl="https://mbk-query.mobikwik.com/dataccess/mysql";
		
		powerWalletOTPGen(cellNum,amount,mid);
		QuerydashboardPage querydashboardPage=new QuerydashboardPage(driver);
		querydashboardPage.goToDashboard(queryDashboardUrl);
		String otpData = querydashboardPage.getOTP(userName,password,query);
		powerWalletAddMoneyDebit(cellNum,amount,mid,otpData);
		
		
		//place order
		PaymentPage paymentPage=new PaymentPage(driver);
		String orderId=paymentPage.walletPay();
		System.out.println(orderId);		

	}
	

}
