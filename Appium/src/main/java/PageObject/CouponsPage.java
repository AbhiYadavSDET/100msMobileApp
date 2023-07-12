package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CouponsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "edit_text")
    private AndroidElement enterCouponCode;


    @AndroidFindBy(id = "tv_apply")
    private AndroidElement applySuperCash;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[4]/android.view.ViewGroup/android.widget.TextView[1]")
    private AndroidElement couponApplied;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private AndroidElement billAmount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private AndroidElement superCashAmount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.FrameLayout[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement totalAmount;

    @AndroidFindBy(id = "message")
    private AndroidElement message;




    public CouponsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterEnterCouponCode(String couponCode){
        Elements.enterToElement(driver, enterCouponCode, couponCode, "Enter coupon code");
    }

    public void clickApplySuperCash(){
        Elements.selectElement(driver, applySuperCash, "Click Apply on SuperCash");
    }

    public String getCouponApplied() throws InterruptedException {
        return Elements.getText(driver, couponApplied,"Get coupon applied text");
    }

    public String getMessage() throws InterruptedException {
       return Elements.getText(driver, message,"Coupon Message");
    }

    public String getBilAmount() throws InterruptedException {
        return Elements.getText(driver, billAmount, "Bill Amount on Payment Confirmation Screen");
    }

    public String getSuperCashAmount() throws InterruptedException {
        return Elements.getText(driver, superCashAmount, "SuperCash Amount on Payment Confirmation Screen");
    }

    public String getTotalAmount() throws InterruptedException {
        return Elements.getText(driver, totalAmount, "Total Amount on Payment Confirmation Screen");
    }
}
