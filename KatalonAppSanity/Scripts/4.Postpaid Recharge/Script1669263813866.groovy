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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
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
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/1.Recharge  Pay Bills')    , 0)
Mobile.delay(2)
Mobile.doubleTap( findTestObject('Object Repository/Prepaid Recharge/2.Mobile')   ,0)
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/3.Enter name or Mobile no')  , 0)
Mobile.setText(  findTestObject('Object Repository/Prepaid Recharge/4. Search your contact')   , "9311878235", 0)
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/5.Select Number')  ,0)
Mobile.tap( findTestObject('Object Repository/Postpaid Recharge/5.Change')   ,0)
Mobile.tap( findTestObject('Object Repository/Postpaid Recharge/6.Switch to Postpaid')   ,0)
Mobile.tap(  findTestObject('Object Repository/Postpaid Recharge/7. Operator Name android.widget.TextView - Reliance')  ,0)
Mobile.tap(  findTestObject('Object Repository/Postpaid Recharge/8. Select State Andhra Pradesh New')  ,0)

Mobile.setText(findTestObject('Object Repository/Postpaid Recharge/9.Edit Amount'), "1", 3)
Mobile.tap(findTestObject('Object Repository/Postpaid Recharge/10.Continue'),2)
//payment code
//Mobile.tap(  findTestObject('Object Repository/Prepaid Recharge/9. Pay Amt')    ,0)
//CustomKeywords."template.appFunctions.makePayment"()
//println('Payment Done From Your End')

String transactionType="Jio Bill Payment"

int amt=1
CustomKeywords."template.appFunctions.makePayment"()
//println('Payment Done From Your End')

CustomKeywords.'template.appFunctions.checkHistory'(amt, transactionType)

