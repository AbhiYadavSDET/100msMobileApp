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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

Mobile.startExistingApplication("com.mobikwik_new")

//CustomKeywords.'function.Login.gotoHome1'()
//boolean verifyLogin = Mobile.verifyElementExist(findTestObject('Object Repository/LoginT/LoginSignup'), 3, FailureHandling.OPTIONAL)
//if(!verifyLogin) {
//	
//	CustomKeywords.'function.Login.logout'()
//}
//
//CustomKeywords.'function.Login.login2'("9205299330")

boolean firstRNR = Mobile.verifyElementExist(findTestObject('Object Repository/RNR/RNR'), 0 , FailureHandling.OPTIONAL)
boolean secRNR = Mobile.verifyElementExist(findTestObject('Object Repository/RNR/RNR2'), 0 , FailureHandling.OPTIONAL)
if(firstRNR) {
	Mobile.tap(findTestObject('Object Repository/RNR/RNR'), 0)
}
else if(secRNR) {
	Mobile.tap(findTestObject('Object Repository/RNR/RNR2'), 0)
}
 

boolean PlayAndWin = Mobile.verifyElementExist(findTestObject('Object Repository/RNR/GetStarted2'), 15 , FailureHandling.OPTIONAL)

if(PlayAndWin) {
	Mobile.tap(findTestObject('Object Repository/RNR/GetStarted2'), 0)
}

// Mobile.tap(findTestObject('Object Repository/RNR/Cross'),0)

boolean checkSTW1 = Mobile.verifyElementText(findTestObject('Object Repository/RNR/Spin the wheel'),"Spin the wheel",FailureHandling.OPTIONAL)
if(checkSTW1){
	CustomKeywords.'function.SpinTheWheel.spin'()
	Mobile.tap(findTestObject('Object Repository/RNR/Cross'), 0)
}


Mobile.scrollToText("Spin Now")

Mobile.tap(findTestObject('Object Repository/RNR/Spin Now'), 0)

boolean checkSTW2 = Mobile.verifyElementText(findTestObject('Object Repository/RNR/Spin the wheel'),"Spin the wheel",FailureHandling.OPTIONAL)
if(checkSTW2){
	CustomKeywords.'function.SpinTheWheel.spin'()
}

Mobile.tap(findTestObject('Object Repository/RNR/Cross'),0)

Mobile.tap(findTestObject('Object Repository/RNR/Your Rewards'),0)

Mobile.delay(5)

CustomKeywords.'test.ReSetUpApp.back'(2)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()