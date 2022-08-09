package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImpsPage {

    WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Wallet Transfer']")
    private WebElement walletTransferButton;

    @FindBy(xpath = "//label[text() = 'Send To Bank']")
    private WebElement sendToBankButton;

    @FindBy(id = "accName")
    private WebElement enterName;

    @FindBy(id = "accNum")
    private WebElement enterAccNo;

    @FindBy(id = "ifsc")
    private WebElement enterIfsc;

    @FindBy(id = "amount")
    private WebElement enterAmount;

    @FindBy(xpath = "//span[text() = 'Go']")
    private WebElement clickGoButton;

    @FindBy(xpath = "//span[text() = 'Send Money']")
    private WebElement clickSendMoneyButton;

    @FindBy(xpath = "//span[@class='tgreydark spleft6 dpInBLockMid']")
    private WebElement getProcessingFee;

    @FindBy(xpath = "//input[@placeholder='Enter OTP']")
    private WebElement enterOTP;

    @FindBy(xpath = "//span[text()='Submit OTP']")
    private WebElement clickSubmitOtp;


    public ImpsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, walletTransferButton);
        Config.logComment("*****On money Transfer Page*****");
    }


    public void clickSendToBank() {
        Element.click(driver,sendToBankButton,"Send to Bank button");
    }

    public void enterName(String name) {
        Element.enterText(driver,enterName,name,"Beneficiary Name");
    }

    public void enterAccountNo(String account_no) {
        Element.enterText(driver,enterAccNo,account_no,"Account no");
    }

    public void enterIFSCCode(String ifsc_code) {
        Element.enterText(driver,enterIfsc,ifsc_code,"IFSC");
    }

    public void enteramount(String amount) {
        Element.enterText(driver,enterAmount,amount,"Amount");
    }

    public void clickGoButton() {
        Element.selectElement(driver,clickGoButton,"Go button");
    }

    public void clickSendMoney() {
        Element.selectElement(driver,clickSendMoneyButton,"Send money");
    }

    public String getProcessingFee() {
        return Element.getText(driver,getProcessingFee,"Processing fee").replace("₹ ","");
    }

    public void enterotp() {
        Element.enterText(driver,enterOTP,"547372","OTP");
    }

    public void clickSubmitOtp() {
        Element.click(driver,clickSubmitOtp,"Submit otp button");
    }
}








