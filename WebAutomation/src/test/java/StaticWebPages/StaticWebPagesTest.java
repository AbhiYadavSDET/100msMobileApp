package StaticWebPages;


import Helpers.StaticWebPagesHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class StaticWebPagesTest extends TestBase {
    @Test(groups = {"staticWebPagesSanity","AboutPage"}, priority = 1, description = "Verify Static Web Pages")
    public void Test_About_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.aboutWebPage("https://www.mobikwik.com/about", "About us - Mobikwik | Recharge, Bill Payment & More",17);

    }

    @Test(groups = {"staticWebPagesSanity","BlogPage"}, priority = 2, description = "Verify Static Web Pages")
    public void Test_Blog_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.blogWebPage("https://blog.mobikwik.com/", "MobiKwik - Who we Are, What we Think, What we Do.",9);

    }


    @Test(groups = {"staticWebPagesSanity","PressPage"}, priority = 3, description = "Verify Static Web Pages")
    public void Test_Press_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.pressWebPage("https://blog.mobikwik.com/category/press/pressreleases/", "Press Release Archives - MobiKwik",9);

    }

    @Test(groups = {"staticWebPagesSanity","InvestorRelationsPage"}, priority = 4, description = "Verify Static Web Pages")
    public void Test_InvestorRelations_WebPage() throws InterruptedException, IOException {

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.investorRelationsWebPage("https://www.mobikwik.com/ir/", "Investor Relations",5);

    }


}
