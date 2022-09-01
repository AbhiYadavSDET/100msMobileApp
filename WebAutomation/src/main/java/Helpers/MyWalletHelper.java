package Helpers;


import PageObject.AddMoneyPage;
import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.MyWalletPage;
import Utils.Config;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWalletHelper {

    WebDriver driver;
    DashboardPage dashboardPage;
    HomePage homePage;
//    MbkReporter mbkReporter;
    MyWalletPage myWalletPage;


    public MyWalletHelper(WebDriver driver) {
        this.driver = driver;
//        mbkReporter = new MbkReporter();

        // Mandatory pages
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
        myWalletPage=new MyWalletPage(driver);
    }

    public void myWalletDetails() throws InterruptedException {

        myWalletPage.clickMyWallet();
        MbkReporter.verifyTrueWithLogging(myWalletPage.validateWalletPage(),"My Wallet page",false);
        myWalletPage.clickBalanceBreakup();
        myWalletPage.checkBalanceBreakupData();
        myWalletPage.clickSavedCards();
        myWalletPage.checkSavedCardsData();
        myWalletPage.clickSavedConnections();
        myWalletPage.checkSavedConnectionsData();
        myWalletPage.clickSuperCash();
        myWalletPage.checkSuperCashData();
        myWalletPage.clickLinkedBankAccount();
        myWalletPage.checkLinkedBankAccountData();

    }
}