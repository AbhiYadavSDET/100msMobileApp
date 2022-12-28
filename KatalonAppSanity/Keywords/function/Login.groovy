package function

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
import internal.GlobalVariable

public class Login {




	@Keyword
	def login2(String number){
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
		Mobile.setText(findTestObject('Object Repository/Serialize OR/13.1 Edit OTP Sent to Number'), "547372", 0)
		Mobile.tap(findTestObject('Object Repository/Serialize OR/Proceed Btn') , 0)


		Mobile.delay(4)

		boolean LYBA = Mobile.verifyElementExist(findTestObject('Object Repository/LoginT/Link Your Bank Account'), 0, FailureHandling.OPTIONAL)

		if(LYBA) {
			Mobile.pressBack()
		}

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

	}

	@Keyword
	def gotoHome1() {
		boolean onHome=false;
		Mobile.delay(3)
		while(!onHome) {
			if(Mobile.verifyElementVisible( findTestObject('Object Repository/HomePage/See all services') , 3, FailureHandling.OPTIONAL))
				onHome=true;
			else Mobile.pressBack();
		}
	}

	@Keyword
	def logout() {
		gotoHome1()
		Mobile.tap(findTestObject('Object Repository/logOut/profile'), 0)
		Mobile.tap(findTestObject('Object Repository/logOut/Accounts'), 0)
		Mobile.scrollToText("logout")
		Mobile.tap(findTestObject('Object Repository/logOut/Logout'), 0)
	}

	@Keyword
	def popUpHandling() {
		//		boolean checkSNPL = Mobile.verifyElementExit(findTestObject('Object Repository/Adver/SNPL/Full-Spend NowPay Later'), 0)
		//		if(checkSNPL){
		//			Mobile.tap(findTestObject('Object Repository/Adver/SNPL/Full-Spend NowPay Later-Skip'), 0)
		//		}
		boolean checkFloatingPopUp = Mobile.verifyElementExist(findTestObject('Object Repository/Adver/FloatingPopUp/floatingAdver'), 2, FailureHandling.OPTIONAL)
		if(checkFloatingPopUp){
			Mobile.tap(findTestObject('Object Repository/Adver/FloatingPopUp/cross'), 0)
		}
		// Mobile.tap(findTestObject('Object Repository/Adver/white/CLOSE'), 0)
	}
}
