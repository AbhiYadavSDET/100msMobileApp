package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WalletBalancePage {

    AndroidDriver driver;
    String apiOtp;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Available Balance']")
    public AndroidElement label_available_balance;

    @AndroidFindBy(id = "text_payment_label")
    public AndroidElement label_total_balance_name;

    @AndroidFindBy(id = "text_amount")
    public AndroidElement label_total_balance_value;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'SuperCash “']/following::android.widget.TextView[1]")
    public AndroidElement label_supercash_balance_value;


    public WalletBalancePage(AndroidDriver driver) throws IOException {
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
