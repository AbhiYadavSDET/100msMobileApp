package Helpers;


import PageObject.DashboardPage;
import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.MoneyTransferPage;
import Utils.Config;
import Utils.Element;
import Utils.MbkReporter;
import Utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MoneyTransferHelper {

    WebDriver driver;
    MoneyTransferPage moneyTransferPage;
    MbkReporter mbkReporter;
    MbkCommonControlsHelper mbkCommonControlsHelper;
    HomePage homePage;
    MbkCommonControlsPage mbkCommonControlsPage;


    public MoneyTransferHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();

        // Mandatory pages
        moneyTransferPage= new MoneyTransferPage(driver);
        mbkCommonControlsHelper= new MbkCommonControlsHelper(driver);
        homePage=new HomePage(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
    }


    public void p2p(String mobileNo, String expectedSuccessScreenStatus, String amount) throws InterruptedException {

        // Click on Wallet Transfer
        moneyTransferPage= homePage.clickWalletTransfer();

        Double balanceBefore=Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance());
        System.out.println(balanceBefore);

        // Check wallet balance
        if(Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance())<Double.parseDouble(amount)){
            // Have to write Add money flow
            mbkReporter.verifyTrueWithLogging(false,"Insufficient amount",false);
        }

        // Click on send to wallet
        moneyTransferPage.clickOnSendToWallet();

        // Enter the mobile number
        moneyTransferPage.enterMobileNo(mobileNo);

        // Enter the Amount
        moneyTransferPage.enterAmount(amount);

        // Click on Go Button
        moneyTransferPage.clickOnCtaGo();

        // Click on send money CTA
        moneyTransferPage.clickOnCtaSendMoney();

        // Wait for success screen
        if(!driver.findElement(By.xpath("//*[text()='Transfer Successful']")).isDisplayed()){
            mbkReporter.verifyTrueWithLogging(false,"Txn not successful",false);
        }else{
            Config.logComment("Transfer Successful");
            Thread.sleep(2000);
        }

        // Check balance after Txn
        Double balanceAfter=Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance());
        System.out.println(balanceAfter+"  "+Double.parseDouble(amount));
        if((balanceBefore-balanceAfter)!=Double.parseDouble(amount)){
            mbkReporter.verifyTrueWithLogging(false,"Issue in balance deduction",false);
        }

        // Come back to the homepage
        mbkCommonControlsPage.clickOnLogoMbk();
    }


}
