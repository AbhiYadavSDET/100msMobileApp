package PageObject;

import utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SupercashPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[3]")
    private AndroidElement clickSideDrawer;

    @AndroidFindBy(xpath="//*[@text='Accounts']")
    private AndroidElement clickAccounts;

    @AndroidFindBy(xpath="//*[@text='Details']")
    private AndroidElement clickDetails;

    @AndroidFindBy(xpath="//*[@text='Statement']")
    private AndroidElement clickStatement;

    @AndroidFindBy(xpath="//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView")
    private AndroidElement test;
    
//    @AndroidFindBy(xpath="//*[contains(@text,'Remove')]")
//    private AndroidElement clickRemove;
    
    public SupercashPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void openSideDrawer() {
        Elements.selectElement(driver,clickSideDrawer,"Open side drawer");
    }

    public void clickAccounts() {
        Elements.waitForElementToVisibleOnPage(driver,clickAccounts,5);
        Elements.selectElement(driver,clickAccounts,"Click Accounts");
    }

    public void clickDetails() {
        Elements.selectElement(driver,clickDetails,"Click Details");
    }

    public void clickStatement() {
        Elements.selectElement(driver,clickStatement,"Click Statement");
    }

    public void checkCurrentBalanceAndEarned() throws InterruptedException {
        int i=1;
        int n;
//        Elements.waitForElementToVisibleOnPage(driver,);
        double total=0;
        n=driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")).size();
        System.out.println(n+"n");
        for(i=1;i<=n;i++) {
            total=total+ Double.parseDouble(Elements.getText(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.LinearLayout[" + i + "]/android.view.ViewGroup/android.widget.TextView[8]"))));
            System.out.println(total);
        }
        System.out.println(total);
    }

    public void checkTotalSavingsAndUsed() {
    }
}
