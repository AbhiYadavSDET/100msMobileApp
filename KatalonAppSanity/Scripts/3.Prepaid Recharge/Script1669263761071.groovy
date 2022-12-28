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

def extractInts( String input ) {
	input.findAll( /\d+/ )*.toInteger()
}
	

def checkPaymentBottomSheet(int amt) {
	int amtOnScreen=extractInts(Mobile.getText(findTestObject('Object Repository/Prepaid Recharge/Recharge Amt'), 2))[0]   
	int amtOnPayBtn=extractInts(Mobile.getText(findTestObject('Object Repository/Prepaid Recharge/Button - Pay Amt in Rupees'),2))[0]
	println(amtOnScreen)
	println(amtOnPayBtn)
	assert amtOnScreen==amt:"Amount is not equal to ${amt}"
	assert amtOnPayBtn==amt:"Amount at pay button is not equal to ${amt}"
}
	
//script starts from here

//doing recharge of Vodafone Number by Amount Rs. 10 by adding new debit card

Mobile.startExistingApplication('com.mobikwik_new')
int amt=10

AppiumDriver<?> driver = MobileDriverFactory.getDriver();
CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.OPTIONAL))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
String transactionType="Vi Recharge"

CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)
boolean isClickable=false;
isClickable=Mobile.verifyElementVisible(findTestObject('Object Repository/HomePage/See all services'), 0, FailureHandling.OPTIONAL)

if(!isClickable)
	Mobile.pressBack()
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/1.Recharge  Pay Bills')    , 0)
Mobile.delay(3)
Mobile.doubleTap( findTestObject('Object Repository/Prepaid Recharge/2.Mobile')   ,0)
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/3.Enter name or Mobile no')  , 0)
Mobile.setText(  findTestObject('Object Repository/Prepaid Recharge/4. Search your contact')   , "7795709569", 0)
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/5.Select Number')  ,0)
Mobile.delay(3)
Mobile.tap(   findTestObject('Object Repository/Prepaid Recharge/6.Search ICON New')   ,0)
Mobile.setText( findTestObject('Object Repository/Prepaid Recharge/7. Search Plan or Amount New')  , "10", 0)
Mobile.tap( findTestObject('Object Repository/Prepaid Recharge/8. First View Group (of Amt)')  ,0)

checkPaymentBottomSheet(amt);



//Payment Part Handled in makePayment Function if insufficient flow
Mobile.tap(  findTestObject('Object Repository/Prepaid Recharge/9. Pay Amt')    ,0)

//will open insufficient flow if wallet balance is lower than the required amount

//CustomKeywords."template.appFunctions.makePayment"()

//println('Payment Done From Your End')

CustomKeywords.'template.appFunctions.gotoHome'()
//CustomKeywords.'template.appFunctions.checkHistory'(amt, transactionType)
//CustomKeywords.'function.Login.logout'()
