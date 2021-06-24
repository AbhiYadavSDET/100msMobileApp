package Helpers;

import PageObject.*;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import utils.Element;
import utils.Screen;

import java.io.IOException;

public class PayRentHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    PayRentPage payRentPage;
    AllServicesPage allServicesPage;
    SupercashStatementPage supercashStatementPage;

    public PayRentHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        payRentPage = new PayRentPage(driver);
        allServicesPage = new AllServicesPage(driver);
        supercashStatementPage = new SupercashStatementPage(driver);
    }

    public void feeVerificator(String amount) throws InterruptedException {
        String procFeesOnScreen = payRentPage.getProcessingFees();
        String substr = procFeesOnScreen.substring(1);
        Double amt = Double.parseDouble(substr);
        Double amtparsed = Double.parseDouble(amount);
        Double procFees = (amtparsed * 1.5) / 100;
        Double gstAmt = (procFees * 18) / 100;
        Double total = procFees + gstAmt;
        mbReporter.verifyEqualsWithLogging(amt, total, "Validating Processing Fees", false, false);

    }

    public void verifyPayRent(String address, String pincode, String name, String amount, String bankAccNum, String ifsc) throws IOException, InterruptedException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        homePage.clickAllServices();
        Screen.swipeUpMore(driver);
        allServicesPage.clickOnPayRent();

        String title = payRentPage.getTitle();
        String homeTitle = payRentPage.getTitleText();

        switch (title) {
            case "homeTitle":
                payRentPage.clickCCButton();

                //Entering Landlord Details
                payRentPage.selectAndEnterAddress(address);
                payRentPage.selectAndEnterPincode(pincode);
                payRentPage.clickOnContinueButton();
                Thread.sleep(3000);

                //Entering Rent Details
                payRentPage.selectAndEnterLandlordName(name);
                payRentPage.selectAndEnterAmount(amount);
                Thread.sleep(3000);

                //Validating processing fees
                feeVerificator(amount);

                payRentPage.clickOnContinueButton();
                Thread.sleep(3000);

                //Entering Account Details
                payRentPage.selectAndEnterBankAccountNumber(bankAccNum);
                payRentPage.selectAndEnterIFSC(ifsc);
                payRentPage.clickOnContinueButton();

        }

    }
}