package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldPage {

    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Buy 99.5% pure gold']")
    private IOSElement gold;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Buy']")
    private IOSElement buyButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sell']")
    private IOSElement sellButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='In Rupees']")
    private IOSElement enterAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private IOSElement titleOnSuccessScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement subTitleOnSuccessScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private IOSElement quantityOnSuccessScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'₹')]")
    private IOSElement amountOnSuccessScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'0.0')]")
    private IOSElement sellQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]")
    private IOSElement receivableAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sell Gold']")
    private IOSElement sellGoldButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='History']")
    private IOSElement history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[3]")
    private IOSElement errorMessage;


    public GoldPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickGold(){  Elements.click(driver, gold,"Click on gold");   }

    public void clickBuyButton(){  Elements.click(driver, buyButton,"Click on buy button");   }

    public void clickSellButton(){  Elements.click(driver, sellButton,"Click on sell button");   }

    public void clickAmountField(){ Elements.click(driver,enterAmount,"Click on enter Amount");   }

    public void enterAmount(String amount) throws InterruptedException{
         Elements.enterToElement(driver, enterAmount, amount, "Enter Amount");
    }

    public String getTitleOnSuccessScreen() throws InterruptedException{
        return Elements.getText(driver, titleOnSuccessScreen);
    }
    public String getSubTitleOnSuccessScreen() throws InterruptedException{
        return Elements.getText(driver, subTitleOnSuccessScreen);
    }

    public String getQuantityOnSuccessScreen() throws InterruptedException{
        return Elements.getText(driver, quantityOnSuccessScreen);
    }

    public String getAmountOnSuccessScreen() throws InterruptedException{
        return Elements.getText(driver, amountOnSuccessScreen);
    }

    public String getSellQuantity() throws InterruptedException{
        return Elements.getText(driver, sellQuantity);
    }

    public String getReceivableAmount() throws InterruptedException{
        return Elements.getText(driver, receivableAmount);
    }

    public void clickOnSellGoldButton(){ Elements.click(driver, sellGoldButton,"Click on sell gold button");   }

    public void clickHistory(){ Elements.click(driver, history,"Click on history");   }

    public boolean isErrorMessageShown() throws InterruptedException{
        return Elements.isElementPresent(driver, errorMessage);
    }

    public String getErrorMessage() throws InterruptedException{
        return Elements.getText(driver, errorMessage);
    }

}
