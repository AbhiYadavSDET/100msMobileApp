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



Mobile.startExistingApplication('com.mobikwik_new')
AppiumDriver<?> driver = MobileDriverFactory.getDriver();
CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.CONTINUE_ON_FAILURE))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)

Mobile.tap(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/1.Wallet to Bank Transfer Btn'), 0)

Mobile.tap(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/2.Transfer to a new account'), 0)

Mobile.setText(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/3. Beneficiary Name'), 'Paraj Jain', 0)

Mobile.setText(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/4.Account Number'), '218101502680', 0)

Mobile.setText(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/5. IFSC Code'), 'ICIC0002181', 0)

Mobile.tap(findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/6.Continue'), 0)

Mobile.setText(findTestObject('Object Repository/IMPS Wallet 2 UPI ID/5. Edit Amount'), '50', 0)

Mobile.delay(1)

Mobile.tap( findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/Continue Arrow')  , 0)

Mobile.tap(  findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/Pay Amt New')  , 0)

Mobile.setText( findTestObject('Object Repository/IMPS Wallet 2 Acc No OR/Enter Security PIN')  , '121212', 0)


driver.terminateApp('com.mobikwik_new')

