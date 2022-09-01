package Helpers;

import PageObject.*;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeoPagesHelper {
    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
    MbkReporter mbkReporter;
    AddMoneyPage addMoneyPage;
    SeoPages seoPages;

    public SeoPagesHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        // Mandatory pages
//        driver.navigate().to("https://www.mobikwik.com");
        homePage = new HomePage(driver);
//        dashboardPage = new DashboardPage(driver);
        seoPages = new SeoPages(driver);
    }
    public void categoryPage(String url, String text,int noOfDirectors) throws InterruptedException {
        WebElement urlToClick = seoPages.getMbkUrlForCategory();
        mbkReporter.verifyNotNullWithLogging(urlToClick.getText(),"Airtel Recharge Not Url Found",false);
        Boolean allFieldsPresent = seoPages.clickOnUrlForCategory(urlToClick);
        mbkReporter.verifyTrue(allFieldsPresent,"",false);
        homePage.clickOnLogoMbk();
    }

    public void operatorPage(String url, String text,int noOfBlogs) throws InterruptedException {
        WebElement urlToClick = seoPages.getMbkUrlForOperator();
        mbkReporter.verifyNotNullWithLogging(urlToClick.getText(),"Operator is not selected by default",false);
        Boolean allFieldsPresent = seoPages.clickOnUrlForOperator(urlToClick);
        mbkReporter.verifyTrue(allFieldsPresent,"",false);
        boolean isplanRowSizeGreaterthanZero = seoPages.getPlanRowForOperator();
        mbkReporter.verifyTrue(isplanRowSizeGreaterthanZero,"",false);
        homePage.clickOnLogoMbk();;
    }
    public void planLevelPage(String url, String text,int noOfIR) throws InterruptedException {
        WebElement urlToClick = seoPages.getMbkUrlForPlan();
        mbkReporter.verifyNotNullWithLogging(urlToClick.getText(),"Airtel Recharge Not Url Found",false);
        List<WebElement> allFields = seoPages.clickOnUrlForPlan(urlToClick);
        mbkReporter.verifyTrue(allFields.get(0).getText().contains("Airtel"),"",false);
        boolean inputFields = seoPages.getPlanRowForOperator();
        mbkReporter.verifyTrueWithLogging(allFields.get(1).getText().contains("Rajasthan"),"",false);
        boolean isplanRowSizeGreaterthanZero = seoPages.getPlanRowForPlan();
        mbkReporter.verifyTrue(isplanRowSizeGreaterthanZero,"",false);
        homePage.clickOnLogoMbk();
    }

    public void amountSpecificPage(String url, String text,int noOfPressReleases) throws InterruptedException {
        WebElement urlToClick = seoPages.getMbkUrlForAmount();
        mbkReporter.verifyNotNullWithLogging(urlToClick.getText(),"Airtel Recharge Not Url Found",false);
        List<WebElement> allFields = seoPages.clickOnUrlForAmount(urlToClick);
        mbkReporter.verifyTrue(allFields.get(0).getText().contains("Airtel"),"Operator is selected by default",false);
        mbkReporter.verifyTrue(allFields.get(1).getText().contains("Haryana"),"Circle is selected by default",false);
        List<WebElement> listForAmountRow = seoPages.getAmountRowList();
        boolean isSinglePlanPresent =seoPages.arePlansOfSingleType(listForAmountRow);
        mbkReporter.verifyTrue(isSinglePlanPresent,"",false);
        WebElement isButtomEnabled = seoPages.clickOnGoButton(listForAmountRow);
        mbkReporter.verifyTrue(isButtomEnabled.isEnabled(),"",false);
        homePage.clickOnLogoMbk();
    }
}
