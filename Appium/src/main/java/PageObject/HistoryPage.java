package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'History']")
    private AndroidElement historyTab;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(id = "txt_transaction_summary")
    private AndroidElement historyDescription;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement historyAmount;

    @AndroidFindBy(id = "txt_status")
    private AndroidElement historyStatus;


    public HistoryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickHistoryTab() {
        Elements.selectElement(driver, historyTab, "History Tab");
    }

    public void clickHomeTab() {
        Elements.selectElement(driver, homeTab, "Home Tab");
    }

    public boolean isHistoryDesciptionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, historyDescription);
    }

    public String getDescription() throws InterruptedException {
        return Elements.getText(driver, historyDescription, "History Description");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, historyAmount, "History Amount");
    }

    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, historyStatus, "History Status");
    }


}
