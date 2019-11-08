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
        offersHelper.offersOption("chirag123@gmail.com" ,"testing123","Successfully Logged in ");




    }



}



