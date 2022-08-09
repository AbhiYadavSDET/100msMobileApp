package Helpers;


import PageObject.HomePage;
import PageObject.ImpsPage;
import PageObject.MbkCommonControlsPage;
import PageObject.MoneyTransferPage;
import Utils.Config;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImpsHelper {

    WebDriver driver;
    MoneyTransferPage moneyTransferPage;
    MbkReporter mbkReporter;
    MbkCommonControlsHelper mbkCommonControlsHelper;
    HomePage homePage;
    MbkCommonControlsPage mbkCommonControlsPage;
    ImpsPage impsPage;


    public ImpsHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();

        // Mandatory pages
        moneyTransferPage= new MoneyTransferPage(driver);
        mbkCommonControlsHelper= new MbkCommonControlsHelper(driver);
        homePage=new HomePage(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
        impsPage=new ImpsPage(driver);
    }

    public void imps(String name,String account_no,String IFSC_code,String amount) throws InterruptedException {

        moneyTransferPage= homePage.clickWalletTransfer();
        Double processingFee;

        Double balanceBefore=Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance());

        // Check wallet balance
        if(Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance())<Double.parseDouble(amount)){
            // Have to write Add money flow
            mbkReporter.verifyTrueWithLogging(false,"Insufficient amount",false);
        }else if(Double.parseDouble(amount)<50){
            mbkReporter.verifyTrueWithLogging(false,"Min amount for imps txn is 50",false);
        }

        impsPage.clickSendToBank();
        impsPage.enterName(name);
        impsPage.enterAccountNo(account_no);
        impsPage.enterIFSCCode(IFSC_code);
        impsPage.enteramount(amount);

        processingFee=Double.parseDouble(impsPage.getProcessingFee());
        System.out.println(processingFee);

        impsPage.clickGoButton();
        impsPage.clickSendMoney();

//        Have to add code when OTP is fixed
        impsPage.enterotp();
        impsPage.clickSubmitOtp();
//        Thread.sleep(20000);

        // Wait for success screen
        if(!driver.findElement(By.xpath("//*[text()='Money sent successfully']")).isDisplayed()){
            mbkReporter.verifyTrueWithLogging(false,"Txn not successful",false);
        }else{
            Config.logComment("Transfer Successful");
            Thread.sleep(3000);
        }

        // Check balance after Txn
        Double balanceAfter=Double.parseDouble(mbkCommonControlsHelper.homeScreenBalance());
        System.out.println(balanceBefore+"   "+ balanceAfter+"   "+Double.parseDouble(amount)+"   "+processingFee);
        if((balanceBefore-balanceAfter-processingFee)!=Double.parseDouble(amount)){
            mbkReporter.verifyTrueWithLogging(false,"Issue in balance deduction",false);
        }

        // Come back to the homepage
        mbkCommonControlsPage.clickOnLogoMbk();


    }


}
