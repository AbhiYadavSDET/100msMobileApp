package Helpers;

import PageObject.HomePage;
import PageObject.MbkCommonControlsPage;
import PageObject.Recharge.GasPage;
import Utils.Element;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MbkCommonControlsHelper {
    WebDriver driver;
    MbkReporter mbkReporter;
    GasPage gasPage;
    HomePage homePage;
    MbkCommonControlsPage mbkCommonControlsPage;

    public MbkCommonControlsHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
        mbkCommonControlsPage = new MbkCommonControlsPage(driver);
    }
    public String homeScreenBalance(){
        String balance=mbkCommonControlsPage.getBalance();
        return balance;
    }

    public Boolean handlePayments(String cardNo, String month, String year,String cvv, String bankPassword) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='tgreyteel ft13 caption']")));
        Thread.sleep(3000);
        if(Element.isElementPresent(driver, By.xpath("//h3[text()= ' Select a Payment Mode ']"))){
            AddMoneyHelper addMoneyHelper= new AddMoneyHelper(driver);
            addMoneyHelper.handleAddMoney(cardNo, month, year, cvv, bankPassword);
            return true;
        }else{
            return true;
        }

    }


}
