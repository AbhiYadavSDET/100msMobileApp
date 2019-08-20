package test.java.AndroidApp.PageObject;

import UITestFramework.MobiKwikScreen;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class MgmScreen extends MobiKwikScreen {
    public MgmScreen(IOSDriver driver){super(driver);}

    public By wallet = By.xpath("//android.widget.TextView[@text = 'Wallet']");
    public By mgmPoints = By.id("com.mobikwik_new:id/reward_option_loylty");
    public By mgmAddNewCard = By.id("com.mobikwik_new:id/fab_add_card");
    public By mgmTitle = By.id("com.mobikwik_new:id/mkab_title");
    public By cardNo = By.xpath("//*/android.widget.TextView[@text = 'Card Number']/following::android.widget.EditText[0]");
    public By mobileNo = By.xpath("//*/android.widget.TextView[@text = 'Mobile No. registered with bank']/following::android.widget.EditText[0]");
    public By continueBtn = By.id("com.mobikwik_new:id/redeem_balance_button");
}
