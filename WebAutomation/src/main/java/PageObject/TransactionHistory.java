package PageObject;

import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransactionHistory {

    WebDriver driver;
    @FindBy(xpath = "//*[@class='dpInBLockMid ft13 fw600 nowrap colsep cright pad10 pleft pright autoheight noblur']")
    private WebElement transactionHistory;

    @FindAll(@FindBy(xpath = "//*[@class='cmat btn bt42 fw600 btn-primary nobg bfancy spleft20 spright20 ft13 mat-flat-button mat-button-base']"))
    private List<WebElement> invoiceButtons;

    public TransactionHistory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickOnHistory(){
        Element.selectElement(driver,transactionHistory,"History button");
    }
    public int getInvoiceButtons(){
        return invoiceButtons.size();
    }


}
