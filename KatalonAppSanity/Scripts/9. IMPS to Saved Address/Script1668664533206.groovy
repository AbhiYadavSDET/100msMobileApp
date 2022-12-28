import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

def checkVPAPresent() {
    
	boolean isVPAPresent=false;
	int height=Mobile.getDeviceHeight();
	int width=Mobile.getDeviceWidth();
	int startX=width/2;
	int startY=height/2;
	int endX=startX;
	int endY=startY*0.3;
	Mobile.swipe(startX, startY, endX, endY)
	isVPAPresent=Mobile.verifyElementExist(findTestObject('Object Repository/IMPS to Saved VPA/Find TextView 8076595767ikwik')   , 0,FailureHandling.OPTIONAL)
	if(isVPAPresent)
	{
		Mobile.tap(  findTestObject('Object Repository/IMPS to Saved VPA/Find TextView 8076595767ikwik')     ,0)
		Mobile.setText( findTestObject('Object Repository/IMPS Wallet 2 UPI ID/5. Edit Amount') , "200", 0)
		Mobile.delay(3)
		Mobile.tap( findTestObject('Object Repository/IMPS Wallet 2 UPI ID/6.Done Amount')  ,0 )
		Mobile.tap(  findTestObject('Object Repository/IMPS Wallet 2 UPI ID/7.Pay') ,0 )
		Mobile.setText( findTestObject('Object Repository/IMPS Wallet 2 UPI ID/8. Enter PIN') , "121212", 0)
	}
		
}

Mobile.startExistingApplication('com.mobikwik_new')
AppiumDriver<?> driver = MobileDriverFactory.getDriver();
CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.OPTIONAL))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)

Mobile.tap( findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/Wallet to Bank Transfer New')    , 0)

checkVPAPresent()


//Mobile.tap(  findTestObject('Object Repository/IMPS Wallet 2 UPI ID/3.UPI ID'),0)
//Mobile.setText(  findTestObject('Object Repository/IMPS Wallet 2 UPI ID/4. Edit UPI ID'), "9910757211@ikwik", 0)
//Mobile.tap( findTestObject('Object Repository/IMPS Wallet 2 UPI ID/Continue') ,0)
String transactionType="IMPS Fund Transfer"

int amt=50

CustomKeywords.'template.appFunctions.checkHistory'(amt, transactionType)

driver.terminateApp('com.mobikwik_new')

