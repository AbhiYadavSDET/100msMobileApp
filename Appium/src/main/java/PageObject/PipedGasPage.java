package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PipedGasPage {

    AndroidDriver driver;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Home Services']")
    private AndroidElement homeServices;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Piped Gas']")
    private AndroidElement pipedGas;

    @AndroidFindBy(id = "text_input")
    private AndroidElement searchPipedGasProvider;

    public PipedGasPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void clickHomeServices() {
        Elements.selectElement(driver, homeServices, "Click on Home Services");
    }

    public void clickPipedGas() {
        Elements.selectElement(driver, pipedGas, "Click on Piped Gas");
    }

    public void clickSearchPipedGasProvider() {
        Elements.selectElement(driver, searchPipedGasProvider, "Click on Search Piped Gas Provider");
    }

    public void enterSearchPipedGasProvider(String BrandName) {
        Elements.enterToElement(driver, searchPipedGasProvider, BrandName, "Enter Gas Provider Brand Name");
    }

}
