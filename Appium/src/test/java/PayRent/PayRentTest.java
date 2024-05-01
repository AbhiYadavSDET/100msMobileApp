package PayRent;

import Helpers.LoginHelper;
import Helpers.PayRentHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class PayRentTest extends TestBase {

    @Test(groups = {"sanity","regression", "PayRent", "addNewProperty"}, priority = 0, description = "Add New Property")
    public void PayRent_addNewProperty() throws InterruptedException, IOException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Add New Property =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.addNewProperty("218101502680", "ICIC0002181", "Paraj Jain", "50", "123");

        Log.info("======= END : Add New Property =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentviaZip"}, priority = 0, description = "Verify pay rent via ZIP")

    public void PayRent_payRentviaZip() throws InterruptedException, IOException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via ZIP =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaZIP("218101502680", "ICIC0002181", "Paraj Jain","5000", "₹5,000", "₹88", "₹5,088");

        Log.info("======= END : Pay Rent via ZIP =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentviaCard"}, priority = 0, description = "Verify pay rent via Card")
    public void PayRent_payRentviaCard() throws InterruptedException, IOException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via Card =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentviaCard("218101502680", "ICIC0002181", "Paraj Jain", "5,000","₹5,000", "₹88", "₹5,088");

        Log.info("======= END : Pay Rent via Card =======");

    }

    @Test(groups = {"regression", "PayRent", "payRentViaUPI"}, priority = 0, description = "Verify pay rent via UPI")
    public void PayRent_payRentViaUPI() throws InterruptedException, IOException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : Pay Rent via UPI =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.payRentViaUpi("Paraj Jain", "50");

        Log.info("======= END : Pay Rent via UPI =======");

    }


    @Test(groups = {"regression", "PayRent"}, priority = 0, description = "Verify FAQ Screen")
    public void PayRent_verifyFaqScreen() throws InterruptedException, IOException {

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

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        Log.info("======= START : Verify Delete on pay rent =======");

        // Execute the test
        PayRentHelper payRentHelper = new PayRentHelper(getAndroidDriver());
        payRentHelper.deleteProperty();

        Log.info("======= END : Verify Delete on pay rent ======");

    }

}
