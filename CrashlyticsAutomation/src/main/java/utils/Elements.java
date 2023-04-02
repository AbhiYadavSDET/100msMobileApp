package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {


    public static boolean isElementPresent( WebDriver driver , String element){
        try {
            return driver.findElement(By.xpath(element)).isDisplayed();
        }
        catch(Exception e) {
            return false;
        }
    }

    public static void selectElement( WebDriver driver , String element){
        try {
            driver.findElement(By.xpath(element)).click();
        }
        catch(Exception e) {
        }
    }
}
