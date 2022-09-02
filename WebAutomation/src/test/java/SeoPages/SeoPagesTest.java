package SeoPages;

import Helpers.SeoPagesHelper;
import Helpers.StaticWebPagesHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.TestBase.getWebDriver;

public class SeoPagesTest extends TestBase {
    @Test(groups = {"seoWebPagesSanity"}, priority = 1, description = "Verify Seo Web Pages")
    public void Test_Category_Page() throws InterruptedException, IOException {

        SeoPagesHelper seoPagesHelper = new SeoPagesHelper(getWebDriver());
        seoPagesHelper.categoryPage();

    }

    @Test(groups = {"seoWebPagesSanity"}, priority = 2, description = "Verify Seo Web Pages")
    public void Test_Operator_Page() throws InterruptedException, IOException {

        SeoPagesHelper seoPagesHelper = new SeoPagesHelper(getWebDriver());
        seoPagesHelper.operatorPage();
    }


    @Test(groups = {"seoWebPagesSanity"}, priority = 3, description = "Verify Seo Web Pages")
    public void Test_Plan_Level_Page() throws InterruptedException, IOException {

        SeoPagesHelper seoPagesHelper = new SeoPagesHelper(getWebDriver());
        seoPagesHelper.planLevelPage();
    }

    @Test(groups = {"seoWebPagesSanity"}, priority = 4, description = "Verify Seo Web Pages")
    public void Test_Amount_Level_Page() throws InterruptedException, IOException {

        SeoPagesHelper seoPagesHelper = new SeoPagesHelper(getWebDriver());
        seoPagesHelper.amountSpecificPage();
    }

}
