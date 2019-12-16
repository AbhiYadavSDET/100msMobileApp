package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

public class RootedNotePage {

    AndroidDriver<AndroidElement> driver;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement sorry_text;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[2]")
    private AndroidElement rooted_disclaimer_text;


    public RootedNotePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Log.info("*****Rooted Note Page*****");
    }

    public String intialText()
    {
        return Element.getText(driver, sorry_text,"Initial SORRY Text");
    }

    public String rootedDisclaimer()
    {
        return Element.getText(driver, rooted_disclaimer_text,"Rooted Disclaimer Text");
    }
}
