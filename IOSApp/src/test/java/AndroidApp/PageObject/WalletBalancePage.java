package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WalletBalancePage {

    IOSDriver driver;
    String apiOtp;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Available Balance']")
    public IOSElement label_available_balance;

    @iOSXCUITFindBy(id = "text_payment_label")
    public IOSElement label_total_balance_name;

    @iOSXCUITFindBy(id = "text_amount")
    public IOSElement label_total_balance_value;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'SuperCash “']/following::android.widget.TextView[1]")
    public IOSElement label_supercash_balance_value;


    public WalletBalancePage(IOSDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Wallet Balance Page*****");
    }

    public String getTotalBalanceName() {
        return Element.getText(driver, label_total_balance_name, "Total Balance Name").replace(" “",
                "").trim();
    }

    public String getTotalBalanceValue() {
        return Element.getText(driver, label_total_balance_value, "Total Balance Value").replace("X", "").replace(",", "");
    }

    public String getSupercashBalanceValue() {
        return Element.getText(driver, label_supercash_balance_value, "Supercash Balance Value").replace("₹ ", "").replace("X", "").replace("“ ", "").replace(",", "");
    }


}
