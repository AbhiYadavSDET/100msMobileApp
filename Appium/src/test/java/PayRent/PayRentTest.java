package PayRent;

import Helpers.LoginHelper;
import Helpers.PayRentHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class PayRentTest extends TestBase {

    @Test(groups = {"regression", "PayRent", "addNewProperty"}, priority = 0, description = "Add New Property")
    public void PayRent_addNewProperty() throws InterruptedException, IOException {


        Log.info("======= START : Add New Property =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Add New Property =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.addNewProperty("040801000080315", "IOBA0000408", "Ashish Kumar Pradhan ", "50", "123");

        Log.info("======= END : Add New Property =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentviaZip"}, priority = 0, description = "Verify pay rent via ZIP")

    public void PayRent_payRentviaZip() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via ZIP =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaZIP("040801000080315", "IOBA0000408", "Ashish Kumar Pradhan","5000", "₹5000", "₹118", "₹5,118");

        Log.info("======= END : Pay Rent via ZIP =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentviaCard"}, priority = 0, description = "Verify pay rent via Card")
    public void PayRent_payRentviaCard() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via Card =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentviaCard("040801000080315", "IOBA0000408", "Ashish Kumar Pradhan", "5,000","₹5,000", "₹118", "₹5,118");

        Log.info("======= END : Pay Rent via Card =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentViaUPI"}, priority = 0, description = "Verify pay rent via UPI")
    public void PayRent_payRentViaUPI() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via UPI =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaUpi("Ashish Kumar Pradhan ", "50");

        Log.info("======= END : Pay Rent via UPI =======");

    }


    @Test(groups = {"regression", "PayRent"}, priority = 0, description = "Verify FAQ Screen")
    public void PayRent_verifyFaqScreen() throws InterruptedException, IOException {


        Log.info("======= START : Verify FAQ =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Verify FAQ =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.verifyTittleAndFaq("Benefits of paying rent through Mobikwik","FAQ");

        Log.info("======= END : Verify FAQ =======");

    }

    @Test(groups = {"regression", "PayRent"}, priority = 0, description = "Delete property")
    public void deleteRentDetails() throws InterruptedException, IOException {

        Log.info("======= START : P2M Send test =======");
        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        Log.info("======= START : Verify FAQ =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.deleteProperty();

        Log.info("======= END : Verify FAQ =======");

    }

}
