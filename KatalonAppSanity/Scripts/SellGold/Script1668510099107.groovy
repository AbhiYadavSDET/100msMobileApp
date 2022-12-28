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

Mobile.tap(findTestObject('MainPage/Main Page - See all services'), 0)

Mobile.scrollToText("Credit Card Zone")

Mobile.tap(findTestObject('Object Repository/BuyGold/Buy 99.5 pure gold 2'), 0)

Mobile.delay(3)

GoldBalance = Mobile.getText(findTestObject('Object Repository/BuyGold/Gold Balance -   0.4213 gram(s)'), 0)
NetLoss = Mobile.getText(findTestObject('Object Repository/BuyGold/Net Loss  7.19'), 0)
OldTotalPurchased = Mobile.getText(findTestObject('Object Repository/BuyGold/Total Purchased  2167'), 0)
OldTotalSold = Mobile.getText(findTestObject('Object Repository/BuyGold/Total Sold  10'), 0)

println(GoldBalance)
println(NetLoss)
println(OldTotalPurchased)
println(OldTotalSold)


Mobile.tap(findTestObject('Object Repository/SellGold/Sell Gold'), 0)

Mobile.setText(findTestObject('Object Repository/SellGold/sell in Rupees'), "1", 0)
Mobile.tap(findTestObject('Object Repository/SellGold/sell-Continue'), 0)
Mobile.delay(3)

boolean checkConfirmPaymentPage = Mobile.verifyElementText(findTestObject('Object Repository/SellGold/Confirm Payment - Confirm Payment'), "Confirm Payment", FailureHandling.CONTINUE_ON_FAILURE)
if(checkConfirmPaymentPage){
	
	Mobile.verifyElementText(findTestObject('Object Repository/SellGold/Sell-Amount'), "₹1", FailureHandling.STOP_ON_FAILURE)
	
	Purity = Mobile.getText(findTestObject('Object Repository/SellGold/sell-Purity'), 0, FailureHandling.STOP_ON_FAILURE)
	Quantity = Mobile.getText(findTestObject('Object Repository/SellGold/sell-Quantity'), 0, FailureHandling.STOP_ON_FAILURE)
	DateOfBuy = Mobile.getText(findTestObject('Object Repository/SellGold/Sell - Date'), 0, FailureHandling.STOP_ON_FAILURE)
	Amount = Mobile.getText(findTestObject('Object Repository/SellGold/Sell-Amount'), 0, FailureHandling.STOP_ON_FAILURE)
	
	println("Purity " + Purity)
	println("Quantity in grams " + Quantity)
	println("Date " + DateOfBuy)
	println("Total Amount Paid " + Amount)
}

Mobile.tap(findTestObject('Object Repository/SellGold/Sell Gold - Confirm Payment'), 0)

boolean checkPaymentSuccessPage = Mobile.verifyElementText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Payment Successful'), "Payment Successful", FailureHandling.CONTINUE_ON_FAILURE)
if(checkPaymentSuccessPage){
	
	Mobile.verifyElementText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Amount'), "₹1", FailureHandling.STOP_ON_FAILURE)
	
	OrderID = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Order Id'), 0, FailureHandling.STOP_ON_FAILURE)
	Quantity = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Quantity'), 0, FailureHandling.STOP_ON_FAILURE)
	DateOfBuy = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful- Date'), 0, FailureHandling.STOP_ON_FAILURE)
	Amount = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Amount'), 0, FailureHandling.STOP_ON_FAILURE)
	
	println("Order ID " + OrderID)
	println("Quantity in grams " + Quantity)
	println("Date " + DateOfBuy)
	println("Total Amount Paid " + Amount)
}

Mobile.pressBack()

OTSString = OldTotalSold.substring(14);
println(OTSString)
OTSInt = OTSString.toInteger();
println(OTSInt)


int NTSInt = OTSInt + 1;
NTSString = NTSInt.toString();
println(NTSString)
NTSString = "Total Sold : ₹" + NTSString;

Mobile.verifyElementText(findTestObject('Object Repository/BuyGold/Total Purchased  2167'), OldTotalPurchased, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Object Repository/BuyGold/Total Sold  10'), NTSString, FailureHandling.STOP_ON_FAILURE)

GoldBalance = Mobile.getText(findTestObject('Object Repository/BuyGold/Gold Balance -   0.4213 gram(s)'), 0)
NetLoss = Mobile.getText(findTestObject('Object Repository/BuyGold/Net Loss  7.19'), 0)
NewTotalPurchased = Mobile.getText(findTestObject('Object Repository/BuyGold/Total Purchased  2167'), 0)
NewTotalSold = Mobile.getText(findTestObject('Object Repository/BuyGold/Total Sold  10'), 0)

println(GoldBalance)
println(NetLoss)
println(NewTotalPurchased)
println(NewTotalSold)



CustomKeywords.'test.ReSetUpApp.back'(2)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()

