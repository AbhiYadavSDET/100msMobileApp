package Helpers;

import PageObject.HelpPage;
import PageObject.HomePage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpHelper {

    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    HelpPage helpPage;


    public HelpHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbkReporter = new MbkReporter();
    }

    public void help(String query) throws InterruptedException {

        helpPage = homePage.clickHelpIcon();

        helpPage.selectAddMoneyIcon();

        helpPage.selectIssueToReport();

        helpPage.selectQuestionFromList();

        helpPage.enterQuery(query);

        helpPage.selectSend();

        Thread.sleep(3000);

        // Aasertions
        mbkReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//p[text()= ' Sorry for the inconvenience ']")), "Ticket ID", false);

        // Click on the cross Button
        Thread.sleep(3000);
        helpPage.clickOnCrossButton();

        // Reach the home screen
        homePage.clickOnLogoMbk();

    }


}
