package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CustomKeyboardPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "btn_pin_0")
    private AndroidElement tap0;

    @AndroidFindBy(id = "btn_pin_1")
    private AndroidElement tap1;

    @AndroidFindBy(id = "btn_pin_2")
    private AndroidElement tap2;

    @AndroidFindBy(id = "btn_pin_3")
    private AndroidElement tap3;

    @AndroidFindBy(id = "btn_pin_4")
    private AndroidElement tap4;

    @AndroidFindBy(id = "btn_pin_5")
    private AndroidElement tap5;

    @AndroidFindBy(id = "btn_pin_6")
    private AndroidElement tap6;

    @AndroidFindBy(id = "btn_pin_7")
    private AndroidElement tap7;

    @AndroidFindBy(id = "btn_pin_8")
    private AndroidElement tap8;

    @AndroidFindBy(id = "btn_pin_9")
    private AndroidElement tap9;


    public CustomKeyboardPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void enterAmount(String amount){
        int n = amount.length();
        for(int i = 0 ; i < n ; i++){
            char c = amount.charAt(i);
            switch(c){
                case '0':
                    Elements.selectElement(driver, tap0, "click on zero");
                    break;
                case '1':
                    Elements.selectElement(driver, tap1, "click on one");
                    break;
                case '2':
                    Elements.selectElement(driver, tap2, "click on two");
                    break;
                case '3':
                    Elements.selectElement(driver, tap3, "click on three");
                    break;
                case '4':
                    Elements.selectElement(driver, tap4, "click on four");
                    break;
                case '5':
                    Elements.selectElement(driver, tap5, "click on five");
                    break;
                case '6':
                    Elements.selectElement(driver, tap6, "click on six");
                    break;
                case '7':
                    Elements.selectElement(driver, tap7, "click on seven");
                    break;
                case '8':
                    Elements.selectElement(driver, tap8, "click on one");
                    break;
                case '9':
                    Elements.selectElement(driver, tap9, "click on two");
                    break;
            }
        }
    }

}
