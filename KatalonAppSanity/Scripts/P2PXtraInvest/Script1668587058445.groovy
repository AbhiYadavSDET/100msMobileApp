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

CustomKeywords.'function.Login.login2'("7795709569")

Mobile.tap(findTestObject('MainPage/Main Page - See all services'), 0)

Mobile.scrollToText("Credit Card Zone")

Mobile.tap(findTestObject('Object Repository/MainPage/Xtra Earn 12 p.a.'), 0)

//yourInvestment = Mobile.getText(findTestObject('P2PXtraWithdraw/YourInvestment - 101'),0)
//int length = yourInvestment.length()
//if(length > 2 && yourInvestment.charAt(length-3) == '.'){
//	yourInvestment = yourInvestment.substring(0 , length-3)
//}
//println(yourInvestment)
//int value = yourInvestment.toInteger()
//println(value)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/InvestMoreNew'), 0)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Plus'), 0)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Flexi'), 0)


Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Yearly'), 0)
int Amount = 2000;
InvestmentAmountInt = Amount.toString()
Mobile.setText(findTestObject('Object Repository/P2PXtraInvest/Your Investment'), InvestmentAmountInt, 0)

InvestmentAmount = Mobile.getText(findTestObject('Object Repository/P2PXtraInvest/Your Investment'), 0)

println(InvestmentAmount) 
InvestmentAmount = "₹" + InvestmentAmount;
Returns = (Amount*12)/100;
println(Returns)
Return = Returns.toString()
println(Return)
//Re = Mobile.getText(findTestObject('Object Repository/P2PXtraInvest/YourReturns'), 0)
//println(Re)
// Mobile.verifyElementText(findTestObject('Object Repository/P2PXtraInvest/YourReturns'),Return, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Invest Now'), 0)

//TotalInvestmentBottomSheet = Mobile.getText(findTestObject('Object Repository/P2PXtraInvest/TotalInvestment-BottomSheet'),0 )
//println(TotalInvestmentBottomSheet)
//
//Mobile.verifyElementText(findTestObject('Object Repository/P2PXtraInvest/TotalInvestment-BottomSheet'),InvestmentAmount, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Proceed to pay'), 0)

PayableAmount = Mobile.getText(findTestObject('Object Repository/P2PXtraInvest/PayableAmount'),0 )
println(PayableAmount)

Mobile.verifyElementText(findTestObject('Object Repository/P2PXtraInvest/PayableAmount'),InvestmentAmount, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Netbanking'), 0)

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/ICICI Bank'), 0)
 
Mobile.delay(5)

Mobile.verifyElementText(findTestObject('Object Repository/P2PXtraInvest/Make Payment'),"Make Payment", FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Object Repository/P2PXtraInvest/Payment through ICICI Bank') ,"Payment through ICICI Bank", FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/P2PXtraInvest/Cancel transaction - Yes'), 0)

CustomKeywords.'test.ReSetUpApp.back'(2)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()

