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

Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/Recharge  Pay Bills'), 0)

Mobile.doubleTap(findTestObject('Object Repository/MobileRechargeCrossSell/Mobile'), 0)

Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/Jio'), 0)

Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/Popular'), 0)

RechargeAmount1 = Mobile.getText(findTestObject('Object Repository/MobileRechargeCrossSell/RechargeAmount'), 0)
println(RechargeAmount1)

Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/RechargeAmount'),0)

Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/CheckBox'), 0)

RechargeAmount2 = Mobile.getText(findTestObject('Object Repository/MobileRechargeCrossSell/RechargeAmount (1)'), 0)
RechargeAmount2 = RechargeAmount2.substring(1)
int RechargeAmountInt = RechargeAmount2.toInteger();
println(RechargeAmount2)

InsuranceAmount = Mobile.getText(findTestObject('Object Repository/MobileRechargeCrossSell/InsuranceAmount'), 0)
InsuranceAmount = InsuranceAmount.substring(1)
InsuranceAmountInt = InsuranceAmount.toInteger();
println(InsuranceAmount)

SumAmountInt = InsuranceAmountInt + RechargeAmountInt;
SumAmount = SumAmountInt.toString();
println(SumAmount)

SumAmount = "₹" + SumAmount;
println(SumAmount)

Mobile.verifyElementText(findTestObject('Object Repository/MobileRechargeCrossSell/TotalAmount'), SumAmount, FailureHandling.STOP_ON_FAILURE)

TotalAmount = Mobile.getText(findTestObject('Object Repository/MobileRechargeCrossSell/TotalAmount'), 0)
TotalAmount = TotalAmount.substring(1)
println(TotalAmount)

SumAmount = "Pay " + SumAmount;
println(SumAmount)

Mobile.verifyElementText(findTestObject('Object Repository/MobileRechargeCrossSell/PayAmount'), SumAmount, FailureHandling.STOP_ON_FAILURE)

PayAmount = Mobile.getText(findTestObject('Object Repository/MobileRechargeCrossSell/PayAmount'), 0)
PayAmount = PayAmount.substring(5)
println(PayAmount)

// Mobile.tap(findTestObject('Object Repository/MobileRechargeCrossSell/PayAmount'), 0)

CustomKeywords.'test.ReSetUpApp.back'(4)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()


