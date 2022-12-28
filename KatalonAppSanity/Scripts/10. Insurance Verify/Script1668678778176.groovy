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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

Mobile.startExistingApplication('com.mobikwik_new')

AppiumDriver driver = MobileDriverFactory.getDriver();



CustomKeywords.'template.appFunctions.gotoHome'()
if(!Mobile.verifyElementExist( findTestObject('Serialize OR/9. LoginSignup Btn')  , 0,FailureHandling.OPTIONAL))
	CustomKeywords.'function.Login.logout'();
	
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.delay(5)

Mobile.tap( findTestObject('Object Repository/PayRent/1. All Services') ,0)
Mobile.scrollToText( "Financial Services" )


Mobile.tap( findTestObject('Object Repository/Insurance/2. Insurance') ,0)
Mobile.tap( findTestObject('Object Repository/Insurance/Retail Insurance Btn')  ,0)
Mobile.tap( findTestObject('Object Repository/Insurance/Group Insurance BTn')   ,0)



List<WebElement> elements = driver.findElementsById('com.mobikwik_new:id/offercardLayout')

int rowsSize = elements.size();
println(rowsSize );

if(rowsSize==5)
println ('The number of rows is correct i.e. '+ rowsSize)
else if(rowsSize<5)
	println('The number of rows is less i.e. '+ rowsSize)
else println('The number of rows is more i.e. '+ rowsSize)
if(rowsSize!=5) {
	println('Test case is failed because number of rows is not 5 ')
	KeywordUtil.markFailed("Test case is failed because number of rows is not 5 ")
}


	


driver.terminateApp('com.mobikwik_new')

