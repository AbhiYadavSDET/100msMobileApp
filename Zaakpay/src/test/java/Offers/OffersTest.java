package Offers;

import Helpers.OffersHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class OffersTest extends TestBase
{
    @Test(groups = {"offerssection"},priority = 0,description = "To check offers section")
    public void Test_Offers_section() throws InterruptedException
    {
        OffersHelper offersHelper = new OffersHelper(driver);
        offersHelper.offersOption("chirag23@zaakpay.com" ,"testing123","ZVAF2019101542100","ZP594ef979593f4","Transaction Refund Initiated");




    }



}



