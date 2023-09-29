package PayRent;

import Helpers.LoginHelper;
import Helpers.PayRentHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class PayRentTest extends TestBase {

    @Test(groups = {"regression", "Pay Rent"}, priority = 0, description = "Add New Property")
    public void Test_PayRent_addNewProperty() throws InterruptedException, IOException {


        Log.info("======= START : Add New Property =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Add New Property =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.addNewProperty("006198700002090", "YESB0000061", "Vikrant Nagar", "50", "123");

        Log.info("======= END : Add New Property =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 1, description = "Verify pay rent via ZIP")

    public void Test_PayRent_payRentviaZip() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via ZIP =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaZIP("50", "₹50", "₹1.18", "₹51.18");

        Log.info("======= END : Pay Rent via ZIP =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 2, description = "Verify pay rent via Card")
    public void Test_PayRent_payRentviaCard() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via Card =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentviaCard("50", "₹50", "₹1.18", "₹51.18");

        Log.info("======= END : Pay Rent via Card =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 3, description = "Verify pay rent via UPI")
    public void Test_PayRent_payRentViaUPI() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via UPI =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaUpi("Vikrant Nagar", "50");

        Log.info("======= END : Pay Rent via UPI =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 4, description = "Verify Pay rent benefit screen")
    public void Test_PayRent_verifyPayRentBenefitScreen() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify PayRent Benefit Screen =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.verifyText("Benefits of paying rent through Mobikwik");

        Log.info("======= END : Verify PayRent Benefit Screen =======");

    }

    @Test(groups = {"regression", "Pay Rent"}, priority = 5, description = "Verify FAQ Screen")
    public void Test_PayRent_verifyFaqScreen() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify FAQ =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.verifyFAQ("FAQ");

        Log.info("======= END : Verify FAQ =======");

    }

//    @Test(groups = {"regression", "Pay Rent"}, priority = 6, description = "Delete property")
//    public void deleteRentDetails() throws InterruptedException, IOException {
//
//        Log.info("======= START : P2M Send test =======");
//        // Login to the account
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaOtp("9205299330", "547372");
//
//        Log.info("======= START : Verify FAQ =======");
//
//        // Execute the test
//        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
//        payRentHelper.deleteProperty();
//
//        Log.info("======= END : Verify FAQ =======");
//
//    }

}
