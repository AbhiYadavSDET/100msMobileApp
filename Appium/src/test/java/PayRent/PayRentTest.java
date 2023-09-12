package PayRent;

import Helpers.LoginHelper;
import Helpers.PayRentHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class PayRentTest extends TestBase {

    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")

    public void addNewProperty() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Add New Property =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.addNewProperty("006198700002090", "YESB0000061", "Vikrant Nagar", "50");

        Log.info("======= END : Add New Property =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")

    public void payRentviaZip() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via ZIP =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaZIP("50","₹50","₹1.18","₹51.18");

        Log.info("======= END : Pay Rent via ZIP =======");

    }
    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void payRentviaCard() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via Card =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentviaCard("50","₹50","₹1.18","₹51.18");

        Log.info("======= END : Pay Rent via Card =======");

    }
    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void payRentViaUPI() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via UPI =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaUpi("Vikrant Nagar","50");

        Log.info("======= END : Pay Rent via UPI =======");

    }
    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void verifyPayRentBenefitScreen() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify PayRent Benefit Screen =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.verifyText("Benefits of paying rent through Mobikwik");

        Log.info("======= END : Verify PayRent Benefit Screen =======");

    }
    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void verifyFaqScreen() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify FAQ =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.verifyFAQ("FAQ");

        Log.info("======= END : Verify FAQ =======");

    }
    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void deleteRentDetails() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify FAQ =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.deleteProperty();

        Log.info("======= END : Verify FAQ =======");

    }

}
