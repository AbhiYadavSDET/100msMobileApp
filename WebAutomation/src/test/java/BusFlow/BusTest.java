package BusFlow;

import Helpers.BusHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class BusTest extends TestBase {

    @Test(groups = {"busFlow"}, priority = 0, description = "Verify Bus Booking Flow on Web")
    public void Test_Bus_Flow() throws InterruptedException {

        LoginHelper loginHelper= new LoginHelper(driver);
        loginHelper.loginViaOtp("7795709569", "para jain", "par.ajjain@gmail.com", "7795709569");


        BusHelper busHelper= new BusHelper(driver);
        busHelper.busBook("Bhubaneswar", "Baripada", "Paraj Jain", "28", "Payment Successful");

        busHelper.busCancel("Thanks your ticket has been cancelled successfully");


    }










}
