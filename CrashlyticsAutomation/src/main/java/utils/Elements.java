package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class Elements {


    public static boolean isElementPresent( WebDriver driver, String element, String locatorType){

        locatorType = locatorType.toLowerCase();
        char c = locatorType.charAt(0);
        try {
            if(c == 'x'){
                return driver.findElement(By.xpath(element)).isDisplayed();
            }
            else if(c == 'i'){
                return driver.findElement(By.id(element)).isDisplayed();
            }
            else {
                return false;
            }

        }
        catch(Exception e) {
            return false;
        }
    }

    public static void selectElement( WebDriver driver , String element, String locatorType){

        locatorType = locatorType.toLowerCase();
        char c = locatorType.charAt(0);
        try {
            if(c == 'x'){
                driver.findElement(By.xpath(element)).click();
            }
            else if(c == 'i'){
                driver.findElement(By.id(element)).click();
            }

        }
        catch(Exception e) {
        }
    }
}
