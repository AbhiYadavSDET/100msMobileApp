package template

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

import internal.GlobalVariable


import io.restassured.RestAssured as RestAssured
import io.restassured.http.Method as Method
import io.restassured.response.Response as Response
import io.restassured.specification.RequestSpecification as RequestSpecification
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

public class appFunctions {

	@Keyword
	def gotoHome() {
		boolean onHome=false;
		Mobile.delay(3)
		while(!onHome) {
			if(Mobile.verifyElementVisible( findTestObject('Object Repository/HomePage/See all services') , 3, FailureHandling.OPTIONAL))
				onHome=true;
			else Mobile.pressBack();
		}
	}
	
	@Keyword
	def loginWithNumber(String number) {
		Mobile.delay(5)
		boolean snplP = false

		boolean locationP = false

		boolean setupUPIP = false

		boolean videoAdP = false

		boolean chooseANumberPre = false

		boolean get2LakhAd=false

		snplP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/1.SNPL Activity'), 1,FailureHandling.OPTIONAL)?true:false;

		if (snplP) {
			Mobile.tap(findTestObject('Object Repository/Serialize OR/2.SkipSNPL'), 1,FailureHandling.OPTIONAL)
		}

		locationP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/3.Location Access Pop-Up'), 1,FailureHandling.OPTIONAL)

		if (locationP) {
			Mobile.tap(findTestObject('Object Repository/Serialize OR/4.ALLOW Location'), 1,FailureHandling.OPTIONAL)
		}

		get2LakhAd=Mobile.verifyElementExist(findTestObject('Object Repository/Ads/Get 2Lakh Instantly Ad/Get 2 Lakh Instantly Image'), 0,FailureHandling.OPTIONAL)

		if(get2LakhAd)
			Mobile.pressBack()

		setupUPIP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/1.SetupUPI Pop- Up'), 1,FailureHandling.OPTIONAL)

		if (setupUPIP) {
			Mobile.tap(findTestObject('Object Repository/Serialize OR/6.CLOSE setup UPI'), 1,FailureHandling.OPTIONAL)
		}

		videoAdP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/7.Video Ad Pop Up'), 1,FailureHandling.OPTIONAL)

		if (videoAdP) {
			Mobile.tap(findTestObject('Object Repository/Serialize OR/8.Close Video Pop Up'), 1,FailureHandling.OPTIONAL)
		}

		Mobile.doubleTap(findTestObject('Serialize OR/9. LoginSignup Btn'), 1,FailureHandling.OPTIONAL)

		chooseANumberPre = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/10. Choose a Number System Pop -Up'),
				1,FailureHandling.OPTIONAL)

		if (chooseANumberPre) {
			//		    Mobile.tap(findTestObject('Object Repository/Serialize OR/11.NONE OF THE ABOVE Btn'), 1,FailureHandling.OPTIONAL)
			Mobile.pressBack()
		}
		//		Mobile.pressBack()
		
		Mobile.setText(findTestObject('Object Repository/Serialize OR/12.Edit Mobile No'), number, 0)
		Mobile.tap(findTestObject('Object Repository/Serialize OR/13.Send OTP Btn'), 1)
		Mobile.delay(3)
		Mobile.setText(findTestObject('Object Repository/Serialize OR/13.1 Edit OTP Sent to Number'), "547372", 10)
		Mobile.tap(    findTestObject('Object Repository/Serialize OR/Proceed Btn') , 0)


		Mobile.delay(4)

		if(Mobile.verifyElementExist(  findTestObject('Object Repository/Ads/Activate ZIP Ad/Activate ZIP'), 1,FailureHandling.OPTIONAL))
			Mobile.pressBack();
		boolean ZipAd = false

		ZipAd = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/14.Get up to 30,000 with ZIP Activity'),
				1,FailureHandling.OPTIONAL)

		if (ZipAd) {
			Mobile.tap(findTestObject('Object Repository/Serialize OR/15.Skip KYC Zip'), 1,FailureHandling.OPTIONAL)

			Mobile.tap(findTestObject('Object Repository/Serialize OR/16. Dont want benefits Btn'), 1,FailureHandling.OPTIONAL)
		}

		boolean checkKYCPopUp = false

		checkKYCPopUp = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/17. Check KYC Text'), 1,FailureHandling.OPTIONAL)

		if (checkKYCPopUp) {
			Mobile.pressBack()
		}

		boolean ZipAdK=false
		ZipAdK=Mobile.verifyElementExist( findTestObject('Object Repository/SerializeLoginOR/20. Zip Ad Check android.widget.TextView - Buy now  pay later at 0 interest Shop at your favorite brands') , 1,FailureHandling.OPTIONAL)
		if(ZipAdK)
			Mobile.tap( findTestObject('Object Repository/SerializeLoginOR/21.Close Zip Ad') , 1,FailureHandling.OPTIONAL)


			boolean LinkBank=false;
			LinkBank=Mobile.verifyElementExist(findTestObject('Object Repository/Ads/Link Your Bank Account Ad/2.TextView - Setup your UPI today and transfer seamlessly on MobiKwik'), 1, FailureHandling.OPTIONAL)
			if(LinkBank)
				Mobile.pressBack();
				
		boolean get2lakh=false;
		get2lakh=Mobile.verifyElementExist(findTestObject('Object Repository/Ads/Get 2Lakh Instantly Ad/Get 2 Lakh Instantly Image'),1,FailureHandling.OPTIONAL)
		if(get2lakh)
			Mobile.pressBack();
			
	}

	@Keyword
	def checkPaymentBottomSheet(int totalAmt) {
		int netPayableAmt=extractInts(Mobile.getText( findTestObject('Object Repository/Payments BottomSheet/Net Payable Amt')  , 0))[0];
		println(netPayableAmt)
	}

	@Keyword
	def makePayment() {


		Mobile.tap(  findTestObject('Object Repository/Prepaid Recharge/9. Pay Amt')    ,0)
		Mobile.setText(findTestObject('Object Repository/CCBP/8.Enter Security PIN'), "121212", 0)
		//	Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/10.Enter your 16 digit card number')  ,0)
		//		Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/9.More payment options')  ,0)
		if(Mobile.verifyElementExist( findTestObject('Object Repository/Prepaid Recharge/9.More payment options') , 0,FailureHandling.OPTIONAL))
		{
			Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/9.More payment options') ,0)
			Mobile.tap( findTestObject('Object Repository/AddMoneyThroughCard/Add New Debit card')  ,0)
			checkScanCard();
			Mobile.setText( findTestObject('Object Repository/Prepaid Recharge/11. EditText - Card Number'),"4363931800224460"   ,0)
			Mobile.setText(  findTestObject('Object Repository/Prepaid Recharge/12.EditText - Card Expiry')  , "12/22", 0)
			Mobile.setText( findTestObject('Object Repository/Prepaid Recharge/13.EditText - CVV') ,"239",0  )
			//Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/14.Pay 10') , 0)
			//Mobile.delay(20)
			//
			//def OTP=fetchOTP()
			//
			//Mobile.setText(findTestObject('AddMoneyThroughCard/android.widget.EditText0'), OTP, 0)
			//
			//Mobile.tap( findTestObject('AddMoneyThroughCard/Confirm  Pay') , 0)
		}


	}

	@Keyword
	def extractInts( String input ) {
		input.findAll( /\d+/ )*.toInteger()
	}
	@Keyword
	def checkHistory(int amt,String transactionType) {
		gotoHome();
		Mobile.tap( findTestObject('Object Repository/Transaction History/History New')    , 0);

		int lastAmt=extractInts(Mobile.getText(   findTestObject('Object Repository/Transaction History/Check Amount')  , 0))[0];
		String transName=Mobile.getText( findTestObject('Object Repository/Transaction History/Check Transaction Type')   , 0);

		println('Last Amount :'+ lastAmt);
		println('Last Transaction Type :'+transName);


		assert Mobile.getText( findTestObject('Object Repository/Transaction History/Check Transaction Type')   , 0)==transactionType:"Test Failed as the transaction type is ${transName}  instead of ${transactionType} ";
		assert extractInts(Mobile.getText(   findTestObject('Object Repository/Transaction History/Check Amount')  , 0))==[amt]:"Amount is not same as requested to do recharge. Amount to be paid was ${amt} instead of ${lastAmt}";

	}

	@Keyword
	def fetchOTP(){
		Mobile.delay(10)
		def response = WS.sendRequest(findTestObject('OTPRequest'))
		def responseText = response.getResponseText()
		println JsonOutput.prettyPrint(responseText)


		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(responseText)

		def OTP= parsedJson.otp;
		println OTP
		return OTP
	}

	@Keyword
	def checkScanCard() {
		boolean isPresent=false;
		isPresent= Mobile.verifyElementExist( findTestObject('Object Repository/Prepaid Recharge/11.Check Scan a new card') , 0, FailureHandling.OPTIONAL)
		if(isPresent)
			Mobile.pressBack();
	}


	

	@Keyword
	def checkZipBenefits() {
		boolean isPresent=false;
		isPresent=Mobile.verifyElementExist( findTestObject('Object Repository/PayRentToUPI/3.Check Benefits of paying rent through Credit card')  , 0, FailureHandling.CONTINUE_ON_FAILURE)
		if(isPresent) {
			println("Check Zip Benefits Ad is shown. Closing....")
			Mobile.tap( findTestObject('Object Repository/PayRentToUPI/3.Use UPI')  ,0)
			println("Zip Ad closed . UPI is selected!!")
		}
	}
}