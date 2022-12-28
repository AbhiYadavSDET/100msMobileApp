import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertTrue

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
import groovy.time.TimeCategory




Mobile.startExistingApplication('com.mobikwik_new')
AppiumDriver<?> driver = MobileDriverFactory.getDriver();
CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.OPTIONAL))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)




Mobile.tap(findTestObject('Object Repository/Zip DashBoard/Zip ICON (1)') , 0)

if(!Mobile.verifyElementExist(  findTestObject('Object Repository/Zip DashBoard/Not Registered/Spend Now, Pay Later Ad Text'), 0, FailureHandling.CONTINUE_ON_FAILURE))
 println("SNPL Text Not Found")
 
 
 if(!Mobile.verifyElementExist(    findTestObject('Object Repository/Zip DashBoard/Not Registered/Check Activate now Btn')   , 0, FailureHandling.CONTINUE_ON_FAILURE))
 println("Available Balance Not Found")
//else println Mobile.getText( findTestObject('Object Repository/Zip DashBoard/Available Balance') , 0)

 
 //CustomKeywords.'template.appFunctions.checkHistory'("₹1");
 //Mobile.tap( findTestObject('Object Repository/Transaction History/History New')    , 0);
 //assertTrue(Mobile.verifyElementText( findTestObject('Object Repository/Transaction History/Check Amount')  , "+ ₹1"));
 //
 //assertTrue(Mobile.verifyElementText( findTestObject('Object Repository/Transaction History/Check Transaction Type') , "Sold Gold"))
 
 
 //CustomKeywords.'template.appFunctions.checkHistory'(1, "Sold Gold")
//closing the app
driver.terminateApp('com.mobikwik_new')