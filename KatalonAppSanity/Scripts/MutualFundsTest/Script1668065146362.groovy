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

Mobile.startExistingApplication("com.mobikwik_new")
CustomKeywords.'function.Login.gotoHome1'()
boolean verifyLogin = Mobile.verifyElementExist(findTestObject('Object Repository/LoginT/LoginSignup'), 3, FailureHandling.OPTIONAL)
if(!verifyLogin) {
	
	CustomKeywords.'function.Login.logout'()
}

CustomKeywords.'function.Login.login2'("9205299330")

Mobile.delay(1)
Mobile.tap(findTestObject('MainPage/Main Page - See all services'), 0)


Mobile.scrollToText("Credit Card Zone")
Mobile.tap(findTestObject('Object Repository/MutualFunds/Direct Mutual Funds 2'), 0)

Mobile.delay(6)

boolean checkGetStarted = Mobile.verifyElementExist(findTestObject('Object Repository/MutualFunds/Get Started'), 3, FailureHandling.OPTIONAL)
if(checkGetStarted){
	Mobile.tap(findTestObject('Object Repository/MutualFunds/Get Started'), 0)
}

boolean checkPage = Mobile.verifyElementText(findTestObject('Object Repository/MutualFunds/Mutual Funds Portfolio2'), "Mutual Funds Portfolio", FailureHandling.OPTIONAL)
if(checkPage){
	date = Mobile.getText(findTestObject('Object Repository/MutualFunds/Portfolio value as of 09 Nov 2022'), 0, FailureHandling.OPTIONAL)
	PortfolioValue = Mobile.getText(findTestObject('Object Repository/MutualFunds/PortfolioValue - '), 0, FailureHandling.OPTIONAL)
	Mobile.scrollToText("View Holdings" , FailureHandling.OPTIONAL)
	TotalInvested = Mobile.getText(findTestObject('Object Repository/MutualFunds/Total Invested - 1600'), 0, FailureHandling.OPTIONAL)
	println(date)
	println("PortfolioValue = " + PortfolioValue)
	println("Total Invested = " + TotalInvested)
	
}
	
	
//    date = ""
//	PortfolioValue = "0"
//	TotalInvested = "0"
//	
//	boolean verifyHoldings = false;
//	verifyHoldings = Mobile.checkElement(findTestObject('Object Repository/MutualFunds/PortfolioValue - '), 0 , FailureHandling.CONTINUE_ON_FAILURE)
//	
//	if(verifyHoldings){
//		
//	}
//	else {
//		println("Invest in Mutual Funds")
//	}
	




// boolean checkPage = Mobile.verifyElementText(findTestObject('Object Repository/MutualFunds/Mutual Fund Dashboard'), "Mutual Fund Dashboard", FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5)

Mobile.tap(findTestObject('Object Repository/MutualFunds/ProfileImage'), 0)

Name = Mobile.getText(findTestObject('Object Repository/MutualFunds/Name - Ashish Kumar Pradhan'), 0)
println(Name)

Mobile.verifyElementText(findTestObject('Object Repository/MutualFunds/Name - Ashish Kumar Pradhan'), "Hhtgh", FailureHandling.STOP_ON_FAILURE)

PanNumber = Mobile.getText(findTestObject('Object Repository/MutualFunds/Pan - FMSPP7878E'), 0)
println(PanNumber)

Mobile.verifyElementText(findTestObject('Object Repository/MutualFunds/Pan - FMSPP7878E'), "AQXPJ9529K", FailureHandling.STOP_ON_FAILURE)

Email = Mobile.getText(findTestObject('Object Repository/MutualFunds/Email - akp750750gmail.com'), 0)
println(Email)

Mobile.verifyElementText(findTestObject('Object Repository/MutualFunds/Email - akp750750gmail.com'),"mkwik9330@gmail.com", FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'test.ReSetUpApp.back'(3)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()