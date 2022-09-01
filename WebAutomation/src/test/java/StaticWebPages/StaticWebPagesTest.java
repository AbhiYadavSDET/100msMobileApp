package StaticWebPages;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Helpers.StaticWebPagesHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.TestBase.getWebDriver;

public class StaticWebPagesTest extends TestBase {
    @Test(groups = {"staticWebPagesSanity"}, priority = 1, description = "Verify Static Web Pages")
    public void Test_About_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.aboutWebPage("https://www.mobikwik.com/about", "About us - Mobikwik | Recharge, Bill Payment & More",17);

    }

    @Test(groups = {"staticWebPagesSanity"}, priority = 2, description = "Verify Static Web Pages")
    public void Test_Blog_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.blogWebPage("https://blog.mobikwik.com/", "MobiKwik - Who we Are, What we Think, What we Do.",9);

    }


    @Test(groups = {"staticWebPagesSanity"}, priority = 3, description = "Verify Static Web Pages")
    public void Test_Press_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.pressWebPage("https://blog.mobikwik.com/category/press/pressreleases/", "Press Release Archives - MobiKwik",9);

    }

    @Test(groups = {"staticWebPagesSanity"}, priority = 4, description = "Verify Static Web Pages")
    public void Test_InvestorRelations_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.investorRelationsWebPage("https://www.mobikwik.com/ir/", "Investor Relations",5);

    }


}
