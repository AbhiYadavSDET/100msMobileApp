package Helpers;

import PageObject.DashboardPage;
import PageObject.HelpPage;
import PageObject.HomePage;
import Utils.Element;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpHelper {

    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    DashboardPage dashboardPage;
    HelpPage helpPage;


    public HelpHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        dashboardPage= new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }

    public void help(String query) throws InterruptedException {

        helpPage=homePage.clickHelpIcon();

        helpPage.selectAddMoneyIcon();

        helpPage.selectIssueToReport();

        helpPage.selectQuestionFromList();

        helpPage.enterQuery(query);

        helpPage.selectSend();

        if(Element.isElementPresent(driver, By.xpath("//p[text()= 'Sorry for the inconvenience']"))){

           String ticketId= helpPage.getTicketId();
            Log.info("Issue Raised :"+ticketId);

        }

        Thread.sleep(100);

        homePage.clickOnLogoMbk();

        
    }


}
