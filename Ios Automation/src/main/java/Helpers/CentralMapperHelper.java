package Helpers;

import Logger.Log;
import PageObject.CentralMapperPage;
import PageObject.P2MPage;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class CentralMapperHelper {

    AndroidDriver driver;
    CentralMapperPage centralMapperPage;
    P2MPage p2MPage;
    MBReporter mbReporter;

    public CentralMapperHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        centralMapperPage = new CentralMapperPage(driver);
        p2MPage = new P2MPage(driver);
        mbReporter = new MBReporter(driver);
    }

    public void checkMappedNumberOnUPIHomeScreen(String mappedNumber, String expName, String expVpa) throws InterruptedException, IOException {

        // Click on UPI Transfer
        centralMapperPage.clickOnUpiTransfer();

        // Enter Mapped Number in text box
        centralMapperPage.enterMappedNumber(mappedNumber);

        // Click On Send Money
        centralMapperPage.clickOnSendMoney();

        // Get actual Name
        String actualName = centralMapperPage.getName();

        // Get actual Vpa
        String actualVpa = centralMapperPage.getVpa();

        // Display the values
        Log.info("Name : " + actualName);
        Log.info("Vpa : " + actualVpa);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualName, expName, "Verify Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualVpa, expVpa, "Verify Vpa", false, false,true);


    }


    public void checkMappedNumberOnScanAnyQrScreen(String mappedNumber, String expName, String expVpa) throws InterruptedException, IOException {

        // Click on UPI Transfer
        p2MPage.clickScanQR();

        // Allow Camera Permission While Using App
        p2MPage.allowPermissionWhileUsingApp();

        // Tap On Search Upi Id
        centralMapperPage.tapOnSearchUpiId();

        // Enter Mapped Number in text box
        centralMapperPage.enterMappedNumber(mappedNumber);

        // Click On Send Money
        centralMapperPage.clickOnSendMoney();

        // Get actual Name
        String actualName = centralMapperPage.getName();

        // Get actual Vpa
        String actualVpa = centralMapperPage.getVpa();

        // Display the values
        Log.info("Name : " + actualName);
        Log.info("Vpa : " + actualVpa);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualName, expName, "Verify Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualVpa, expVpa, "Verify Vpa", false, false,true);

    }

    public void changeStateOfMappedNumber(String action) throws InterruptedException, IOException {

        // Click on UPI Transfer
        centralMapperPage.clickOnUpiTransfer();

        // Click on Manage Upi
        centralMapperPage.clickOnManage();

        // Click on Three Dots
        centralMapperPage.clickOnThreeDots();

        // Click on Manage Upi Numbers
        centralMapperPage.clickOnManageUpiNumbers();

        if(action.equals("activate")){
            // Check activate button
            while(centralMapperPage.isActivateButtonPresent()) {
                // Click on Activate
                centralMapperPage.clickOnActivate();
            }
        }
        else if(action.equals("deactivate")){
            // Check deactivate button
            if(centralMapperPage.isDeactivateButtonPresent()){
                // Click on deactivate
                centralMapperPage.clickOnDeactivate();

                // Click Deactivate on Bottom Sheet
                centralMapperPage.clickDeactivateOnBottomSheet();
            }
        }
        else if(action.equals("deregister")){
            // Check deregister button
            if (centralMapperPage.isDeregisterButtonPresent()){
                // Click on Deregister
                centralMapperPage.clickOnDeregister();

                // Click Deregister on Bottom Sheet
                centralMapperPage.clickDeregisterOnBottomSheet();
            }
        }
    }

    public void addNewNumber(String number) throws InterruptedException, IOException {

        // Click on UPI Transfer
        centralMapperPage.clickOnUpiTransfer();

        // Click on Manage Upi
        centralMapperPage.clickOnManage();

        // Click on Three Dots
        centralMapperPage.clickOnThreeDots();

        // Click on Manage Upi Numbers
        centralMapperPage.clickOnManageUpiNumbers();

        // Click on Add New Number
        centralMapperPage.clickOnAddNewNumber();

        // Enter Number In Text Box
        centralMapperPage.enterNumberInTextBox(number);

        // Click on Check Availablity
        centralMapperPage.clickOnCheckAvailablity();

    }
}
