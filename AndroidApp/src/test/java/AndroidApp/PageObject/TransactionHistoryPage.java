package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TransactionHistoryPage {
    AndroidDriver driver;

    public String txn_list = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout";

    @AndroidFindBy(id = "com.mobikwik_new:id/btnVerfiySignUp")
    public AndroidElement CTA_text;

    public TransactionHistoryPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        Log.info("*****Transaction History Page*****");
    }

    public int getListSize() throws InterruptedException {
        return Element.findElements(driver, By.xpath(txn_list)).size();
    }

    public String getCTAText() throws InterruptedException {
        return Element.getText(driver, CTA_text, "Get CTA text").toString();
    }


}
