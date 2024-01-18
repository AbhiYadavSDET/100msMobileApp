package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CentralMapperHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    MbkCommonControlHelper mbkCommonControlHelper;
    MBReporter mbReporter;
    CentralMapperPage centralMapperPage;
    PermissionPage permissionPage;


    public CentralMapperHelper(IOSDriver driver) throws IOException {

        this.driver = driver;
        homePage = new HomePage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        centralMapperPage = new CentralMapperPage(driver);
        permissionPage = new PermissionPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    public void checkMappedNumberOnUPIHomeScreen(String mappedNumber, String expName, String expVpa) throws InterruptedException, IOException {

        // Click on UPI Transfer
        homePage.clickUpiTransfer();

        Thread.sleep(1000);

        if(permissionPage.isPermissionPopUpPresent()) {
            //Click OK to allow contact permission
            permissionPage.clickOnAllow();
        }

        Thread.sleep(2000);

        //Click on Search text field
        centralMapperPage.clickOnSearchField();

        //Enter mapped number in search text field
        centralMapperPage.enterMappedNumber(mappedNumber);

        //Click on Send money
        centralMapperPage.clickOnSendMoney();

        Thread.sleep(2000);

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

        // Click on Scan QR
        homePage.clickOnScanQR();

        // Allow Camera Permission While Using App
        if(permissionPage.isPermissionPopUpPresent()){
            // Allow Camera Permission While Using App
            permissionPage.clickOnAllow();
        }

        // Tap On Search Number field
        centralMapperPage.clickOnSearchNumberField();

        if(permissionPage.isPermissionPopUpPresent()) {
            //Click OK to allow contact permission
            permissionPage.clickOnAllow();
        }

        // Enter Mapped Number in text box
        centralMapperPage.enterMappedNumber(mappedNumber);

        // Click On Send Money
        centralMapperPage.clickOnSendMoney();

        Thread.sleep(1000);

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


