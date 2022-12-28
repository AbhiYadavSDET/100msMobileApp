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

Mobile.startExistingApplication('com.mobikwik_new')
String number="9205299330"
CustomKeywords."template.appFunctions.loginWithNumber"(number)

Mobile.tap(findTestObject('Object Repository/Serialize OR/19.Profile Menu Btn'), 5,FailureHandling.CONTINUE_ON_FAILURE)




//string(Name, Email, Mobile_Num)

Name = Mobile.getText(findTestObject('Object Repository/Serialize OR/20.Name'), 5,FailureHandling.CONTINUE_ON_FAILURE)

Email = Mobile.getText(findTestObject('Object Repository/Serialize OR/21.email'), 5,FailureHandling.CONTINUE_ON_FAILURE)

Mobile_Num = Mobile.getText(findTestObject('Object Repository/Serialize OR/22.Phone Num'), 5,FailureHandling.CONTINUE_ON_FAILURE)

println Name

println Email

println Mobile_Num

Mobile.closeApplication()

