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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.startExistingApplication('com.mobikwik_new')
int amt =5
String transType="Spin-the-wheel SuperCash"
CustomKeywords.'template.appFunctions.checkHistory'(amt, transType)
//Mobile.tap(findTestObject('TestCase/android.widget.TextView0 - Invest Now'), 0)
//Mobile.tap(findTestObject('TestCase/android.widget.TextView0 - Proceed to pay'), 0)
//Mobile.tap(findTestObject('TestCase/android.widget.TextView0 - Netbanking'), 0)
//
//Mobile.delay(10)
//
//device_Height = Mobile.getDeviceHeight()
// 
// 
// 
//'Get Width Height and Store in device_Width variable'
// 
//device_Width = Mobile.getDeviceWidth()
// 
//
//println(device_Height);
//println device_Width;
// 
// 
//'Storing the startX value by dividing device width by 2. Because x coordinates are constant for Vertical Swiping'
// 
//int startX = device_Width / 2
// 
// 
// 
//'Here startX and endX values are equal for vertical Swiping for that assigning startX value to endX'
// 
//int endX = startX
// 
// 
// 
//'Storing the startY value'
// 
//int startY = device_Height * 0.30
// 
// 
// 
//'Storing the endY value'
// 
//int endY = device_Height * 0.70
// 
// 
// 
//'Swipe Vertical from top to bottom'
// 
//// Mobile.swipe(startX, endY, endX, startY)
// 
// 
// 
//'Swipe Vertical from bottom to top'
// 
////Mobile.swipe(startX, startY, endX, endY)
//
////Mobile.scrollToText('IDBI Bank')


//boolean checkPaymentSuccesPage = Mobile.verifyElementText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Payment Successful'), "Payment Successful", FailureHandling.CONTINUE_ON_FAILURE)
//if(checkPaymentSuccesPage){
//	
//	OrderID = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Order Id'), 0, FailureHandling.STOP_ON_FAILURE)
//	Quantity = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Quantity'), 0, FailureHandling.STOP_ON_FAILURE)
//	DateOfBuy = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful- Date'), 0, FailureHandling.STOP_ON_FAILURE)
//	Amount = Mobile.getText(findTestObject('Object Repository/BuyGold/PaymentSuccessful-Amount'), 0, FailureHandling.STOP_ON_FAILURE)
//	
//	println(OrderID)
//	println(Quantity)
//	println(DateOfBuy)
//	println(Amount)
//}
//
//Mobile.delay(5)
//boolean snplP = false
//
//boolean locationP = false
//
//boolean setupUPIP = false
//
//boolean videoAdP = false
//
//boolean chooseANumberPre = false
//
//boolean get2LakhAd = false
//
//boolean snplP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/1.SNPL Activity'), 1,FailureHandling.OPTIONAL)
//
//if (snplP) {
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/2.SkipSNPL'), 1,FailureHandling.OPTIONAL)
//}
//
//locationP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/3.Location Access Pop-Up'), 1,FailureHandling.OPTIONAL)
//
//if (locationP) {
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/4.ALLOW Location'), 1,FailureHandling.OPTIONAL)
//}
//
//get2LakhAd=Mobile.verifyElementExist(findTestObject('Object Repository/Ads/Get 2Lakh Instantly Ad/Get 2 Lakh Instantly Image'), 0,FailureHandling.OPTIONAL)
//
//if(get2LakhAd)
//	Mobile.pressBack()
//
//setupUPIP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/1.SetupUPI Pop- Up'), 1,FailureHandling.OPTIONAL)
//
//if (setupUPIP) {
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/6.CLOSE setup UPI'), 1,FailureHandling.OPTIONAL)
//}
//
//videoAdP = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/7.Video Ad Pop Up'), 1,FailureHandling.OPTIONAL)
//
//if (videoAdP) {
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/8.Close Video Pop Up'), 1,FailureHandling.OPTIONAL)
//}
//
//Mobile.doubleTap(findTestObject('Serialize OR/9. LoginSignup Btn'), 1,FailureHandling.OPTIONAL)
//
//chooseANumberPre = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/10. Choose a Number System Pop -Up'),
//		1,FailureHandling.OPTIONAL)
//
//if (chooseANumberPre) {
//	//		    Mobile.tap(findTestObject('Object Repository/Serialize OR/11.NONE OF THE ABOVE Btn'), 1,FailureHandling.OPTIONAL)
//	Mobile.pressBack()
//}
////		Mobile.pressBack()
//Mobile.setText(findTestObject('Object Repository/Serialize OR/12.Edit Mobile No'), number, 0)
//Mobile.tap(findTestObject('Object Repository/Serialize OR/13.Send OTP Btn'), 1)
//Mobile.setText(findTestObject('Object Repository/Serialize OR/13.1 Edit OTP Sent to Number'), "547372", 0)
//Mobile.tap(findTestObject('Object Repository/Serialize OR/Proceed Btn') , 0)
//
//
//Mobile.delay(4)
//
//if(Mobile.verifyElementExist(  findTestObject('Object Repository/Ads/Activate ZIP Ad/Activate ZIP'), 1,FailureHandling.OPTIONAL))
//	Mobile.pressBack();
//boolean ZipAd = false
//
//ZipAd = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/14.Get up to 30,000 with ZIP Activity'),
//		1,FailureHandling.OPTIONAL)
//
//if (ZipAd) {
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/15.Skip KYC Zip'), 1,FailureHandling.OPTIONAL)
//
//	Mobile.tap(findTestObject('Object Repository/Serialize OR/16. Dont want benefits Btn'), 1,FailureHandling.OPTIONAL)
//}
//
//boolean checkKYCPopUp = false
//
//checkKYCPopUp = Mobile.verifyElementExist(findTestObject('Object Repository/Serialize OR/17. Check KYC Text'), 1,FailureHandling.OPTIONAL)
//
//if (checkKYCPopUp) {
//	Mobile.pressBack()
//}
//
//boolean ZipAdK=false
//ZipAdK=Mobile.verifyElementExist( findTestObject('Object Repository/SerializeLoginOR/20. Zip Ad Check android.widget.TextView - Buy now  pay later at 0 interest Shop at your favorite brands') , 1,FailureHandling.OPTIONAL)
//if(ZipAdK){
//	Mobile.tap( findTestObject('Object Repository/SerializeLoginOR/21.Close Zip Ad') , 1,FailureHandling.OPTIONAL)
//}
//

CustomKeywords.'function.Login.logout'()



Mobile.closeApplication()

