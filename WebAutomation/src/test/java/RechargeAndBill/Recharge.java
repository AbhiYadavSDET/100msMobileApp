package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.*;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Recharge extends TestBase {
    @Test(groups = {"DTH","recharge"}, priority = 0, description = "Verify Dth bill")
    public void Test_Dth() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        DthHelper dthHelper = new DthHelper(getWebDriver());
        dthHelper.verifyInvalidDthBill("tata", "1043233392", "1");

    }
    @Test(groups = {"Electricity","recharge"}, priority = 1, description = "Verify Electricity bill")
    public void Test_Electricity() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        ElectricityHelper electricityHelper = new ElectricityHelper(getWebDriver());
        electricityHelper.verifyElectricityBill("Kota Electricity Distribution Limited (KEDL)", "210736016179");
    }
    @Test(groups = {"Gas","recharge"}, priority = 2, description = "Verify Gas bill")
    public void Test_Gas() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        GasHelper gasHelper = new GasHelper(getWebDriver());
        gasHelper.verifyGasBill("Adani Gas", "1000236410", "No Bills Found", "Adani Gas");

    }
    @Test(groups = {"Landline","recharge"}, priority = 3, description = "Verify Landline bill")
    public void Test_Landline() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        LandlineHelper landlineHelper = new LandlineHelper(getWebDriver());
        landlineHelper.verifyLandlineBill("MTNL Delhi","23693162", "2061533162");
    }
    @Test(groups = {"rechargeMobile","recharge"}, priority = 4, description = "Verify Mobile prepaid bill")
    public void Test_Prepaid() throws InterruptedException, IOException {
//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("jio", "9149237812", "up(west)", "15", false, "APPTEAMREC", "5.0","4799470274582974","07","2027", "443", "521991");

    }
}
