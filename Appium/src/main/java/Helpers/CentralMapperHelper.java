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
}
