import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

Mobile.startExistingApplication('com.mobikwik_new')
AppiumDriver<?> driver = MobileDriverFactory.getDriver();
CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.OPTIONAL))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)

Mobile.tap( findTestObject('Object Repository/PayRent/1. All Services') ,0)
Mobile.scrollToText( "Credit Card Bill Payments" )
Mobile.tap(  findTestObject('Object Repository/CCBP/2. Credit Card Bill Payments') ,0)
Mobile.tap(  findTestObject('Object Repository/CCBP/3. Pay Now') ,0)
//Entering Amount

Mobile.tap(  findTestObject('Object Repository/CCBP/android.widget.Button - 1'),0)
Mobile.tap(  findTestObject('Object Repository/CCBP/Number 0'),0)
Mobile.tap(  findTestObject('Object Repository/CCBP/Number 0'),0)

Mobile.delay(3)

Mobile.tap(  findTestObject('Object Repository/CCBP/5. Continue') ,0)
Mobile.tap(  findTestObject('CCBP/6. Pay Amt') ,0)
Mobile.tap(  findTestObject('Object Repository/CCBP/android.widget.TextView - Wallet Balance') ,0)
Mobile.tap(  findTestObject('Object Repository/Prepaid Recharge/9. Pay Amt')    ,0)
Mobile.setText(findTestObject('Object Repository/CCBP/8.Enter Security PIN'), "121212", 0)

String transactionType="Credit Card Bill Payment"

int amt=100

CustomKeywords.'template.appFunctions.checkHistory'(amt, transactionType)
//closing the app
driver.terminateApp('com.mobikwik_new')


