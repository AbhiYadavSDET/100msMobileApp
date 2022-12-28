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

Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/HomeBalanceBreakUp'), 0)

// Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/Add Money'), 0)

Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/Add Money2'), 0)

int amount = 10;
addingAmount = amount.toString()
Mobile.setText(findTestObject('Object Repository/AddMoneyCrossSell/EnterAmount'),addingAmount, 0)

Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/CheckBox'), 0)

CrossSell = Mobile.getText(findTestObject('Object Repository/AddMoneyCrossSell/CrossSellAmount'), 0)
println(CrossSell)
CrossSell = CrossSell.substring(3);
println(CrossSell)
int CrossSellAmount = CrossSell.toInteger();
println(CrossSellAmount)

int SumAmount = amount + CrossSellAmount;
println(SumAmount)

PayAmount = SumAmount.toString();
PayAmount = "₹"+PayAmount;
println(PayAmount)
Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/ArrowUp'), 0)

Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/View Details'), 0)

Mobile.delay(4)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/AddMoneyCrossSell/Continue'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/AddMoneyCrossSell/AMCS-PayableAmount'), PayAmount, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'test.ReSetUpApp.back'(2)

CustomKeywords.'function.Login.logout'()

Mobile.closeApplication()
