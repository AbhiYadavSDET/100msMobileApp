package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import Utils.MbkReporter;
import com.amazonaws.services.dynamodbv2.xspec.B;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWalletPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text() = 'My Wallet']")
    private WebElement myWalletButton;

    @FindBy(xpath = "//p[@class = 'tbold ft18 spbottom10']")
    private WebElement myWalletText;

    @FindBy(xpath = "//li[contains(@class,'csrPtr')][1]")
    private WebElement balanceBreakupButton;

    @FindBy(xpath = "//li[contains(@class,'csrPtr')][2]")
    private WebElement savedCardsButton;

    @FindBy(xpath = "//li[contains(@class,'csrPtr')][3]")
    private WebElement savedConnectionsButton;

    @FindBy(xpath = "//li[contains(@class,'csrPtr')][4]")
    private WebElement superCashButton;

    @FindBy(xpath = "//li[contains(@class,'csrPtr')][5]")
    private WebElement linkedBankAccountButton;

    @FindBy(xpath = "(//div[@class='col-md-8 spleft0'])[1]/p[1]")
    private WebElement verifyMoneyAddedText;

    @FindBy(xpath = "(//div[@class='col-md-8 spleft0'])[2]/p[1]")
    private WebElement verifySupercashText;

    @FindBy(xpath = "(//button[@class='cmat btn bt48 nobg nowrap btn-primary bfancy dpInBLock mar10 mright ft16 mat-flat-button mat-button-base'")
    private WebElement verifySavedCardsRemoveButton;

    @FindBy(xpath = "(//button[@class='cmat btn bt36 nobg nowrap btn-primary width100 bfancy dpInBLock mar20 mright ft13 mat-flat-button mat-button-base'")
    private WebElement verifySavedConnectionrechargeButton;

    @FindBy(xpath = "//p[@class='dpTbCell vmiddle']/label[@class='tgreyteel ft13 dpBLock ln22']")
    private WebElement verifySupercashTextData;

    @FindBy(xpath = "//div[@class='csloader brad4 unitset commonloader']//div[@class= 'spinloader']")
    private WebElement loader;

    @FindBy(xpath = "//section[@class='dpInBLock brad5 greybgdark5 spall15']//a[@class= 'posrel dpBLock csrPtr ']")
    private WebElement verifyAddNewBankAccount;


    public MyWalletPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, myWalletButton);
        Config.logComment("*****On My wallet Page*****");
    }


    public void clickMyWallet() {
        Element.selectElement(driver,myWalletButton,"My Wallet");
    }

    public Boolean validateWalletPage() throws InterruptedException {
        return Element.isElementPresent(driver, By.xpath("//p[@class = 'tbold ft18 spbottom10']"));
    }

    public void clickBalanceBreakup() {
        Element.click(driver,balanceBreakupButton,"Balance breakup button");
    }

    public void checkBalanceBreakupData() {
        MbkReporter.verifyEqualsWithLogging(Element.getText(driver,verifyMoneyAddedText,"Money added text"),"Money Added","Money added text in balance breakup",false);
        MbkReporter.verifyEqualsWithLogging(Element.getText(driver,verifySupercashText,"SuperCash text"),"SuperCash","Supercash text in balance breakup",false);
    }

    public void clickSavedCards() {
        Element.click(driver,savedCardsButton,"Saved cards button");
        handleLoader();
    }

    public void checkSavedCardsData() throws InterruptedException {

        if(Element.isElementPresent(driver, By.xpath("//button[@class='cmat btn bt48 nobg nowrap btn-primary bfancy dpInBLock mar10 mright ft16 mat-flat-button mat-button-base']"))){
            MbkReporter.verifyTrueWithLogging(true,"User with cards",false);
        }else if(false){
            //code for new user
            MbkReporter.verifyTrueWithLogging(true,"User without cards",false);
        }else{
            MbkReporter.verifyTrueWithLogging(false,"Issue in saved cards data",false);
        }
    }

    public void clickSavedConnections() {
        Element.click(driver,savedConnectionsButton,"Saved connections button");
        handleLoader();
    }

    public void checkSavedConnectionsData() throws InterruptedException {
        if(Element.isElementPresent(driver, By.xpath("//button[@class='cmat btn bt36 nobg nowrap btn-primary width100 bfancy dpInBLock mar20 mright ft13 mat-flat-button mat-button-base']"))){
            MbkReporter.verifyTrueWithLogging(true,"User with saved connection",false);
        }else if(false){
            //code for new user
            MbkReporter.verifyTrueWithLogging(true,"User without saved connection",false);
        }else{
            MbkReporter.verifyTrueWithLogging(false,"Issue in saved cards data",false);
        }
    }

    public void clickSuperCash() {
        Element.click(driver,superCashButton,"Supercash button");
    }

    public void checkSuperCashData() {
        handleLoader();
        MbkReporter.verifyEqualsWithLogging(Element.getText(driver,verifySupercashTextData,"Supercash text"),"SuperCash Balance","Supercash text",false);
    }

    public void clickLinkedBankAccount() {
        Element.click(driver,linkedBankAccountButton,"Linked bank account button");
    }

    public void checkLinkedBankAccountData() throws InterruptedException {
        handleLoader();
        if(Element.isElementPresent(driver, By.xpath("//section[@class='dpInBLock brad5 greybgdark5 spall15']//a[@class= 'posrel dpBLock csrPtr ']"))){
            MbkReporter.verifyTrueWithLogging(true,"User having no bank account linked",false);
        }else if(false){
            //code for user having bank account
            MbkReporter.verifyTrueWithLogging(true,"User having bank account linked",false);
        }else{
            MbkReporter.verifyTrueWithLogging(false,"Issue in linked bank account",false);
        }
    }

    public void handleLoader(){
        WebDriverWait wait= new WebDriverWait(driver,3);
        try{
            wait.until(ExpectedConditions.invisibilityOf(loader));
        }catch (TimeoutException t){
            System.out.println(t);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}