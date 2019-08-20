package test.java.AndroidApp.PageObject;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class TransactionHistoryPage {
    IOSDriver driver;

    public String txn_list = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout";

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btnVerfiySignUp")
    public IOSElement CTA_text;


    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    public IOSElement first_element_in_list;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_txn_id")
    public IOSElement txn_id;


    public TransactionHistoryPage(IOSDriver driver) throws IOException {
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

    public void clickOnFirstElementInTheList() throws InterruptedException {
        Element.selectElement(driver, first_element_in_list, "First Element");
    }

    public String getTrxId() throws InterruptedException {
        return Element.getText(driver, txn_id, "Get CTA text").replace("Order ID: ", "");
    }

}
