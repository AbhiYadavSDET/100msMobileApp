package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text() = 'Transact API']")
    private WebElement link_transact_api;

    @FindBy(xpath = "//a[text() = 'Update Txn API']")
    private WebElement link_update_transaction_api;

    @FindBy(xpath = "//a[text() = 'Check Txn API']")
    private WebElement link_check_transaction_api;

    @FindBy(xpath = "//td[@colspan = '3']")
    private WebElement label_page_load_text;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_page_load_text);
        Config.logComment("*****On Dashboard Page*****");
    }

    public TransactionApiHomePage clickOnTransactApiLink() {
        Element.selectElement(driver, link_transact_api, "Transact Api Link");
        return new TransactionApiHomePage(driver);
    }

    public RefundPage clickOnUpdateTrxApiLink() {
        Element.selectElement(driver, link_update_transaction_api, "Update Trx Api Link");
        return new RefundPage(driver);
    }

    public void clickOnCheckTxnApiLink() {
        Element.selectElement(driver, link_transact_api, "Check Trx Api Link");
    }


}








