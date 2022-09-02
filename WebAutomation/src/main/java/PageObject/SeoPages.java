package PageObject;

import Utils.Config;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class SeoPages {

    WebDriver driver;
    MbkReporter mbkReporter;
    WebElement urlToClick;

    public SeoPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        Browser.waitForPageLoad(driver, labelStaticPages);
        Config.logComment("*****On Seo Page*****");
        mbkReporter = new MbkReporter();
        urlToClick = null;
    }

    public WebElement getMbkUrlForCategory(){
        driver.navigate().to("https://www.google.com/");
        WebElement inputBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        inputBox.click();
        inputBox.sendKeys("mobikwik recharge");
        inputBox.sendKeys(Keys.RETURN);

        List<WebElement> urlOnGoogleSearchPageList = driver.findElements(By.cssSelector(".TbwUpd.NJjxre"));

        for (int i = 0; i < 3; i++) {

            String allText = urlOnGoogleSearchPageList.get(i).getText();
            String[] textArr = allText.split(" › ");
//            System.out.println(Arrays.toString(textArr) + "  " + urlToClick);


            if (textArr[0].contains("https://www.mobikwik.com") && textArr[1].contains("prepaid-recharge")) {
                urlToClick = urlOnGoogleSearchPageList.get(i);
                break;
            }

        }
        return urlToClick;

    }
    public boolean clickOnUrlForCategory(WebElement urlToClick) throws InterruptedException {
        urlToClick.click();

        Thread.sleep(1000);

        List<WebElement> inputFieldsList = driver.findElements(By.xpath("//*[contains(@class,'nopad pleft spad8 spright8 sptop10 fieldBlock')]"));

        return inputFieldsList.size() >= 4;

    }

    public WebElement getMbkUrlForOperator(){
        driver.navigate().to("https://www.google.com/");
        WebElement inputBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        inputBox.click();
        inputBox.sendKeys("mobikwik airtel prepaid recharge");
        inputBox.sendKeys(Keys.RETURN);

        // assertion

        List<WebElement> urlOnGoogleSearchPageList = driver.findElements(By.cssSelector(".TbwUpd.NJjxre"));
        WebElement urlToClick = null;
        for (int i = 0; i < 3; i++) {

            String allText = urlOnGoogleSearchPageList.get(i).getText();
            String[] textArr = allText.split(" › ");
//            System.out.println(Arrays.toString(textArr));


            if (textArr[0].contains("https://www.mobikwik.com") && textArr[1].contains("airtel-online-recharge")) {
                urlToClick = urlOnGoogleSearchPageList.get(i);
                break;
            }

        }
        return urlToClick;

    }
    public boolean clickOnUrlForOperator(WebElement urlToClick) throws InterruptedException {
        urlToClick.click();

        WebElement operatorSelected = driver.findElement(By.cssSelector(".ng-select-container.ng-has-value"));
        return operatorSelected.getText().contains("Airtel");

    }


    public boolean getPlanRowForOperator(){
        List<WebElement> planRow = driver.findElements(By.cssSelector("tr[class=\"planRow\"]"));
        return planRow.size() > 0;
    }


    public WebElement getMbkUrlForPlan(){
        driver.navigate().to("https://www.google.com/");
        WebElement inputBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        inputBox.click();
        inputBox.sendKeys("mobikwik airtel prepaid recharge rajasthan");
        inputBox.sendKeys(Keys.RETURN);

        List<WebElement> urlOnGoogleSearchPageList = driver.findElements(By.cssSelector(".TbwUpd.NJjxre"));
        WebElement urlToClick = null;
        for (int i = 0; i < 3; i++) {

            String allText = urlOnGoogleSearchPageList.get(i).getText();
            String[] textArr = allText.split(" › ");
            System.out.println(Arrays.toString(textArr));


            if (textArr[0].contains("https://www.mobikwik.com") && textArr[1].contains("airtel-online-recharge") && textArr[2].contains("R...")) {
                urlToClick = urlOnGoogleSearchPageList.get(i);
                break;
            }

        }
        return urlToClick;

    }

    public List<WebElement> clickOnUrlForPlan(WebElement urlToClick) throws InterruptedException {
        urlToClick.click();

        List<WebElement> operatorSelected = driver.findElements(By.cssSelector(".ng-select-container.ng-has-value"));
        return operatorSelected;

    }

    public List<WebElement> getInputFieldsForPlan(){
        List<WebElement> inputFields = driver.findElements(By.cssSelector("tr[class=\"planRow\"]"));
        return inputFields;
    }

    public boolean getPlanRowForPlan(){
        List<WebElement> planRow = driver.findElements(By.cssSelector("tr[class=\"planRow\"]"));
        return planRow.size() > 0;
    }

    public WebElement getMbkUrlForAmount(){

        driver.navigate().to("https://www.google.com/");
        WebElement inputBox = driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        inputBox.click();
        inputBox.sendKeys("mobikwik airtel prepaid recharge plan for 755");
        inputBox.sendKeys(Keys.RETURN);
        List<WebElement> urlOnGoogleSearchPageList = driver.findElements(By.cssSelector(".TbwUpd.NJjxre"));
        WebElement urlToClick = null;
        for (int i = 0; i < 3; i++) {

            String allText = urlOnGoogleSearchPageList.get(i).getText();
            String[] textArr = allText.split(" › ");
            System.out.println(Arrays.toString(textArr));


            if (textArr[0].contains("https://www.mobikwik.com") && textArr[1].contains("Haryana") && textArr[2].contains("airtel-Haryana...")) {
                urlToClick = urlOnGoogleSearchPageList.get(i);
            }

        }
        return urlToClick;
    }

    public List<WebElement> clickOnUrlForAmount(WebElement urlToClick) throws InterruptedException {
        urlToClick.click();

        List<WebElement> operatorSelected = driver.findElements(By.cssSelector(".ng-select-container.ng-has-value"));
        return operatorSelected;

    }

    public List<WebElement> getAmountRowList(){
        List<WebElement> amountRowsList = driver.findElements(By.cssSelector(".cmat.btn.btn36.fw600.mar10.wdFull.btn-primary.nobg.bfancy.spleft20.spright20.sptop7.spbottom7.ft15.mat-flat-button.mat-button-base"));
        return amountRowsList;
    }

    public boolean arePlansOfSingleType(List<WebElement> amountRowsList){

        boolean flagForAmount = true;

        for (int i = 0; i < amountRowsList.size(); i++) {
            if (!amountRowsList.get(i).getText().contains("755"))
                flagForAmount = false;
        }
        return flagForAmount;

    }
    public WebElement clickOnGoButton(List<WebElement> amountRowsList){

        amountRowsList.get(0).click();

        WebElement numberInputField = driver.findElement(By.xpath("//*[@class='form-input tx48 ng-untouched ng-pristine ng-invalid']"));

        numberInputField.sendKeys("8527797582");

        WebElement goButton = driver.findElement(By.xpath("//*[@class='cmat btn bt48 fw600 smtop32 wdFull btn-primary nobdr gradbg7 bfancy mat-flat-button mat-button-base']"));

        return goButton;
    }

}
