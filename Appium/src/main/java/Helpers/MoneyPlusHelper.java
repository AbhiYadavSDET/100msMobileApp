package Helpers;


import PageObject.MoneyPlusPage;

import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;

public class MoneyPlusHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;

    Screen screen;
    MBReporter mbReporter;

    MoneyPlusPage moneyPlusPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;





    public MoneyPlusHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        moneyPlusPage=new MoneyPlusPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }
    //"Track your bank accounts with 100% accuracy","Watch your money grow", "Get Started", "Track your PF accounts at one place"
    public void verifyMoneyPlusFlow(String AAIntroText, String xtraIntroText, String mfIntroPageCtaText, String epfoIntroPagetitleText) throws InterruptedException, IOException {

        moneyPlusPage.clickAllServices();


        moneyPlusPage.scrollToMoneyPlus();

        moneyPlusPage.clickOnMoneyPlus();
        

        Element.waitForVisibility(driver,By.id("lineChart"));

        mbReporter.verifyTrueWithLogging(!(moneyPlusPage.fetchNetWorthAmount() ==null), " Net Worth Amount : "+ moneyPlusPage.fetchNetWorthAmount(), false,false);

        mbReporter.verifyTrueWithLogging(!(moneyPlusPage.fetchNetIncrement() ==null), " Net Increment : "+ moneyPlusPage.fetchNetIncrement(), false,false);

        mbReporter.verifyTrueWithLogging(!(moneyPlusPage.fetchNetIncrementPercentage() ==null), " Net Increment Percentage : "+ moneyPlusPage.fetchNetIncrementPercentage(), false,false);

        moneyPlusPage.clickOnAccountAggregatorCard();

        Element.waitForVisibility(driver, By.id("ic_text"));

        mbReporter.verifyEqualsWithLogging(moneyPlusPage.fetchAccountAggregatorIntroText().trim(), AAIntroText, " Validating Account Agregator Intro Text", false,false);

        moneyPlusPage.navigateBack();

        moneyPlusPage.scrollToXtraCard();

        moneyPlusPage.clickOnXtraCard();

        Element.waitForVisibility(driver, By.id("description"));

        mbReporter.verifyEqualsWithLogging(moneyPlusPage.fetchXtraIntroText(), xtraIntroText, " Validating Xtra Intro Text", false,false);

        moneyPlusPage.navigateBack();

        moneyPlusPage.scrollToGoldScreen();
        moneyPlusPage.clickToGoldScreen();
        //moneyPlusPage.tapOutsideBottomSheet();

        while(!moneyPlusPage.isBuyGoldPresent()){
            mbkCommonControlsHelper.pressback();
        }

        Double goldCurrentValue=Double.parseDouble(moneyPlusPage.fetchGoldCurrentValue());

        mbReporter.verifyTrueWithLogging(goldCurrentValue>0,"Checking Gold Current Value", false,false);

        moneyPlusPage.navigateBack();

        moneyPlusPage.clickOnMutualFundCard();

        Element.waitForVisibility(driver, By.id("tv_subtitle"));

        mbReporter.verifyEqualsWithLogging(moneyPlusPage.fetchMFIntroPageCtaValue(), mfIntroPageCtaText, " Validating MF Intro Page cta Text", false,false);

        moneyPlusPage.navigateBack();

        Screen.swipeUpMore(driver);

        moneyPlusPage.clickOnEpfoCard();

        mbReporter.verifyEqualsWithLogging(moneyPlusPage.fetchEPFOIntroPageTitleValue(), epfoIntroPagetitleText, " Validating EPFO Intro Page Title Text", false,false);

        moneyPlusPage.navigateBack();

        moneyPlusPage.navigateBack();


    }


}
