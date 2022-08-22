import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CheckCrashIOS {

    @Test(groups = {"CrashlyticsIssuesIOS"}, priority = 0, description = "Verify Crashlytics crash for ios")
    public static void CrashlyticsIOS() throws InterruptedException, IOException {

        String username = "mbkmobile.team@mobikwik.com";
        String pass = "Mobikwik@123456";
        String version = "28.6";
        String date = "60 m"; // only for fresh issues
        String crashFreeUsers;
        int MAX_RETRIES = 2;
        int total_fresh = 0, total_topFive;
        boolean sendMail = false;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://console.firebase.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys(username);
        driver.findElement(By.xpath("//*[text()='Next']")).click();

        shortWait(driver, "//input[@type='password']");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        longWait(driver, "//*[contains(text(),'Mobikwik Android')]");
        driver.findElement(By.xpath("//*[contains(text(),'Mobikwik Android')]")).click();
        try {
            shortWait(driver,"//div[text()='Crashlytics']");
            driver.findElement(By.xpath("//div[text()='Crashlytics']")).click();
        }catch (Exception e){
            shortWait(driver, "//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div");
            try {
                driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div")).click();
            }catch (ElementNotInteractableException q){
                driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']")).click();
                driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div")).click();
            }
        }
        shortWait(driver, "//div[@class='selected-resource-wrapper']");
        driver.findElement(By.xpath("//div[@class='selected-resource-wrapper']")).click();
        Thread.sleep(2000);
        shortWait(driver, "//span[text()='MobiKwik iOS App']");
        driver.findElement(By.xpath("//span[text()='MobiKwik iOS App']")).click();
        Thread.sleep(2000);
        shortWait(driver, "//mat-chip[@class='mat-chip mat-focus-indicator mat-menu-trigger filter-picker-trigger mat-primary mat-standard-chip ng-star-inserted'][1]");
        driver.findElement(By.xpath("//mat-chip[@class='mat-chip mat-focus-indicator mat-menu-trigger filter-picker-trigger mat-primary mat-standard-chip ng-star-inserted'][1]")).click();
        shortWait(driver, "//input[@placeholder='Search versions']");
        driver.findElement(By.xpath("//input[@placeholder='Search versions']")).sendKeys(version);
        Thread.sleep(3000);
        shortWait(driver, "//label[@class='mat-checkbox-layout'][1]");
        driver.findElement(By.xpath("//label[@class='mat-checkbox-layout'][1]")).click();
        try {
            driver.findElement(By.xpath("//div[@class='mat-tooltip-trigger facet-button-container ng-star-inserted'][2]")).click();
        } catch (Exception e) {
            if (e.toString().contains("NoSuchElementException"))
                driver.findElement(By.xpath("//div[@class='mat-mdc-tooltip-trigger facet-button-container ng-star-inserted'][2]")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='data-value'] [text()='Crashes']")).click();
        driver.findElement(By.xpath("//span[text()=' Apply ']")).click();

        Thread.sleep(2000);

        shortWait(driver, "//div[@class='date-selection']");
        driver.findElement(By.xpath("//div[@class='date-selection']")).click();
        Thread.sleep(2000);
        if (date.contains("60 m")) {
            driver.findElement(By.xpath("//span[contains(text(),'60 min')]")).click();
        } else if (date.contains("24 h")) {
            driver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();
        } else if (date.contains("7 d")) {
            driver.findElement(By.xpath("//span[contains(text(),'7 days')]")).click();
        }
        Thread.sleep(3000);

        int totalTabs = 0;
        boolean finalStatus = true;

        ArrayList<String> versions = new ArrayList<String>();
        ArrayList<String> events = new ArrayList<String>();
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> title = new ArrayList<String>();
        ArrayList<String> subtitle = new ArrayList<String>();

        while (finalStatus) {
//            System.out.println("1");
            shortWait(driver, "//*[text()=' Fresh issue ']");
            List<WebElement> webEleList = driver.findElements(By.xpath("//*[text()=' Fresh issue ']"));
            int no = webEleList.size();
//            System.out.println("2 "+no);
            if (no > 0) {
                sendMail = true;
            }
            total_fresh = no;
            totalTabs = totalTabs + no;

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Actions a = new Actions(driver);
            int j;
            String crash, versionData, usersData, titleData, subTitleData, titleData1;
            for (int i = 0; i < no; i++) {
                boolean condition = false;
//                System.out.println("3");
                while (!condition) {

                    js.executeScript("window.scrollBy(0,150)", "");
                    Thread.sleep(2000);
                    condition = rightClick_little_right(driver, a, webEleList.get(i));
//                    System.out.println("4");
                }
                Thread.sleep(1000);
                j = i + 1;

                crash = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j
                        + "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/parent::div/parent::issue-caption-table-cell/parent::a/parent::mat-cell/following-sibling::mat-cell[2]/a")).getText();
//                System.out.println(crash+"crash");
                events.add(crash);

                versionData = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j
                        + "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/parent::div/parent::issue-caption-table-cell/parent::a/parent::mat-cell/following-sibling::mat-cell[1]/a")).getText();
//                System.out.println(versionData+"version");
                versions.add(versionData);

                usersData = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j
                        + "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/parent::div/parent::issue-caption-table-cell/parent::a/parent::mat-cell/following-sibling::mat-cell[3]/a")).getText();
//                System.out.println(usersData+"users");
                users.add(usersData);

                titleData = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j +
                        "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/following-sibling::div[1]/span")).getText();
//                        titleData1 = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j
//                                + "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/parent::div/parent::issue-caption-table-cell/parent::a/div[1]/span[2]")).getText();
//                System.out.println(titleData+"titleData");
//                        title.add(titleData + titleData1);
                title.add(titleData);

                subTitleData = driver.findElement(By.xpath("(//*[text()=' Fresh issue '])[" + j
                        + "]//parent::fire-chip/parent::div/parent::c9s-issue-tags/parent::div/parent::c9s-issue-caption-metadata-row/following-sibling::div[2]/span")).getText();
//                System.out.println(subTitleData+"subtitle");
                if(subTitleData.contains("<")){
                    subTitleData=subTitleData.replace("<","");
                }
                subtitle.add(subTitleData);

            }
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);
            try {
                shortWait(driver, "//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-next mat-icon-button mat-button-base']");
            } catch (Exception e) {

            }
            try {
                if (driver.findElement(By.xpath("//button[@class='mat-mdc-tooltip-trigger mat-mdc-paginator-navigation-next mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base']")).isEnabled()) {
                    driver.findElement(By.xpath("//button[@class='mat-mdc-tooltip-trigger mat-mdc-paginator-navigation-next mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base']")).click();
                    finalStatus = true;
                } else {
                    finalStatus = false;
                }
                Thread.sleep(5000);
                js.executeScript("window.scrollTo( document.body.scrollHeight,0)");
                Thread.sleep(2000);
            } catch (Exception e) {
                finalStatus = false;
            }
        }
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        ArrayList<String> linksList = new ArrayList<String>();
        for (int i = 1; i < totalTabs + 1; i++) {
            driver.switchTo().window(tabs.get(i));
            if (i == totalTabs + 1) {
                Thread.sleep(4000);
            }
            linksList.add(driver.getCurrentUrl());
//            System.out.println(driver.getCurrentUrl());
        }

//        for (int i = 1; i < totalTabs + 1; i++) {
//            sheet.createRow(i);
//            sheet.getRow(i).createCell(0).setCellValue(i);
//            sheet.getRow(i).createCell(1).setCellValue(title.get(i - 1));
//            sheet.getRow(i).createCell(2).setCellValue(subtitle.get(i - 1));
////            sheet.getRow(i).createCell(3).setCellValue(linksList.get(i-1));
//            sheet.getRow(i).createCell(4).setCellValue(versions.get(i - 1));
//            sheet.getRow(i).createCell(5).setCellValue(events.get(i - 1));
//            sheet.getRow(i).createCell(6).setCellValue(users.get(i - 1));
//        }
        int j = 1;
//        for (int i = totalTabs - 1; i >= 0; i--) {
//            sheet.getRow(j).createCell(3).setCellValue(linksList.get(i));
//            j++;
//        }

//        workbook.write(file);
//        workbook.close();

        String m, freshTest = "";
        freshTest = "<H2>All Fresh Crash</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\">" + "<tr><th>Serial No.</th><th>Title</th><th>Subtitle</th><th>URL</th><th>Version</th><th>Events</th><th>Users</th></tr>";
        m = "</table>";
        j = totalTabs - 1;
        for (int i = 1; i <= totalTabs; i++) {
            freshTest = freshTest + "<td>" + i + "</td><td>" + title.get(i - 1) + "</td><td>" + subtitle.get(i - 1) + "</td><td><a href=\"" + linksList.get(j) + "\">UrlLink</a></td><td>" + versions.get(i - 1) + "</td><td>" + events.get(i - 1) + "</td><td>" + users.get(i - 1) + "</td><tr></tr>";
            j--;
        }
        if (totalTabs == 0) {
            freshTest = freshTest + "<td> No fresh issues </td>";
        }
        freshTest = freshTest + m;
        try{
            driver.quit();
        }catch (Exception e) {
            driver.close();
        }

        //////////For top 5 issues
        if (sendMail) {
//            HSSFWorkbook workbook1 = new HSSFWorkbook();
//            HSSFSheet sheet1 = workbook1.createSheet();
//            sheet1.createRow(0);
//            sheet1.getRow(0).createCell(0).setCellValue("SNo.");
//            sheet1.getRow(0).createCell(1).setCellValue("Title");
//            sheet1.getRow(0).createCell(2).setCellValue("Subtitle");
//            sheet1.getRow(0).createCell(3).setCellValue("URL");
//            sheet1.getRow(0).createCell(4).setCellValue("Version");
//            sheet1.getRow(0).createCell(5).setCellValue("Events");
//            sheet1.getRow(0).createCell(6).setCellValue("Users");
//            File file1 = new File("\\Desktop\\TestTop5.xls");


            double crashFreePercent = 99.8;
            Boolean redHeading = false;
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://console.firebase.google.com");
            driver.manage().window().maximize();
            driver.findElement(By.id("identifierId")).sendKeys(username);
            driver.findElement(By.xpath("//*[text()='Next']")).click();

            shortWait(driver, "//input[@type='password']");
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
            driver.findElement(By.xpath("//*[text()='Next']")).click();
            longWait(driver, "//*[contains(text(),'Mobikwik Android')]");
            driver.findElement(By.xpath("//*[contains(text(),'Mobikwik Android')]")).click();
            try {
                shortWait(driver,"//div[text()='Crashlytics']");
                driver.findElement(By.xpath("//div[text()='Crashlytics']")).click();
            }catch (Exception e){
                shortWait(driver, "//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div");
                try {
                    driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div")).click();
                }catch (ElementNotInteractableException q){
                    driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']")).click();
                    driver.findElement(By.xpath("//*[@id='nav-group-container-Release & Monitor']/div/div[2]/fire-navbar-item[1]/a/div")).click();
                }
            }
            shortWait(driver, "//div[@class='selected-resource-wrapper']");
            driver.findElement(By.xpath("//div[@class='selected-resource-wrapper']")).click();
            Thread.sleep(2000);
            shortWait(driver, "//span[text()='MobiKwik iOS App']");
            driver.findElement(By.xpath("//span[text()='MobiKwik iOS App']")).click();
            Thread.sleep(2000);
            shortWait(driver, "//mat-chip[@class='mat-chip mat-focus-indicator mat-menu-trigger filter-picker-trigger mat-primary mat-standard-chip ng-star-inserted'][1]");
            driver.findElement(By.xpath("//mat-chip[@class='mat-chip mat-focus-indicator mat-menu-trigger filter-picker-trigger mat-primary mat-standard-chip ng-star-inserted'][1]")).click();
            Thread.sleep(2000);
            shortWait(driver, "//input[@placeholder='Search versions']");
            driver.findElement(By.xpath("//input[@placeholder='Search versions']")).sendKeys(version);
            Thread.sleep(2000);
            shortWait(driver, "//label[@class='mat-checkbox-layout'][1]");
            driver.findElement(By.xpath("//label[@class='mat-checkbox-layout'][1]")).click();
            try {
                driver.findElement(By.xpath("//div[@class='mat-tooltip-trigger facet-button-container ng-star-inserted'][2]")).click();
            } catch (Exception e) {
                if (e.toString().contains("NoSuchElementException"))
                    driver.findElement(By.xpath("//div[@class='mat-mdc-tooltip-trigger facet-button-container ng-star-inserted'][2]")).click();
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='data-value'] [text()='Crashes']")).click();
            driver.findElement(By.xpath("//span[text()=' Apply ']")).click();

            Thread.sleep(2000);
            shortWait(driver, "//div[@class='date-selection']");
            driver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'24 hour')]")).click();
            Thread.sleep(3000);
            shortWait(driver, "//span[@class='value ng-star-inserted']");
            crashFreeUsers = driver.findElement(By.xpath("//span[@class='value ng-star-inserted']")).getText();

            String[] check;
            check = crashFreeUsers.split("%");
            if (crashFreePercent > Double.parseDouble(check[0])) {
                redHeading = true;
                sendMail = true;
            }

//        System.out.println(crashFreeUsers);
            String crashFreeMail;
            crashFreeMail = "<H2 > Crash Free Users (Limit is " + crashFreePercent + ")</H2><t1> " + crashFreeUsers + " </t1>";

            Thread.sleep(2000);
            shortWait(driver, "//div[@class='date-selection']");
            driver.findElement(By.xpath("//div[@class='date-selection']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'60 min')]")).click();
            Thread.sleep(3000);
            int n;
            ArrayList<String> topVersions = new ArrayList<String>();
            ArrayList<String> topEvents = new ArrayList<String>();
            ArrayList<String> topUsers = new ArrayList<String>();
            ArrayList<String> topTitle = new ArrayList<String>();
            ArrayList<String> topSubtitle = new ArrayList<String>();
            ArrayList<String> checkTopTags = new ArrayList<String>();
            n = driver.findElements(By.xpath("//mat-row[@class='mat-row cdk-row ng-star-inserted']")).size();
            total_topFive = n;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Actions a = new Actions(driver);
            if (n >= 5) {
                n = 5;
            }
            String topCrash, topVersionData, topUsersData, topTitleData, topSubTitleData, topTitleData2;
            for (int i = 1; i <= n; i++) {
                boolean condition = false;
                while (!condition) {

                    js.executeScript("window.scrollBy(0,100)", "");
                    Thread.sleep(2000);
                    condition = rightClick(driver, a, driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]")));
                }

                Thread.sleep(1000);

                topCrash = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[3]/a")).getText();
//                System.out.println(topCrash+"crash");
                topEvents.add(topCrash);

                topVersionData = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[2]/a/span")).getText();
//                System.out.println(topVersionData+"version");
                topVersions.add(topVersionData.toString());

                topUsersData = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[4]/a")).getText();
//                System.out.println(topUsersData+"users");
                topUsers.add(topUsersData);

                topTitleData = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[1]/a/issue-caption-table-cell/div/div/span")).getText();
//                        topTitleData2 = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[1]/a/div[1]/span[2]")).getText();
//                System.out.println(topTitleData+"titleData");
//                        topTitle.add(topTitleData + topTitleData2.toString());
                topTitle.add(topTitleData);


                topSubTitleData = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[1]/a//div[2]")).getText();
                if(topSubTitleData.isEmpty()) {
                    topSubTitleData = driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell[1]/a/issue-caption-table-cell/div/div[2]")).getText();
                }
//                System.out.println(topSubTitleData+"subtitle");
                if(topSubTitleData.contains("<")){
                    topSubTitleData=topSubTitleData.replace("<","");
                }
                topSubtitle.add(topSubTitleData);

                try {
                    if (driver.findElement(By.xpath("(//mat-row[@class='mat-row cdk-row ng-star-inserted'])[" + i + "]/mat-cell/a/c9s-issue-tags/mat-chip-list/div//*[text()=' Fresh issue ']")).isDisplayed()) {
                        checkTopTags.add("Fresh issue present");
                    } else {
                        checkTopTags.add("Not present");
                    }
                } catch (Exception e) {
                    if (e.toString().contains("NoSuchElement")) {
                        checkTopTags.add("Not present");
                    } else {
                        Assert.assertTrue(false);
                    }
                }


            }
            ArrayList<String> topTabs = new ArrayList<String>(driver.getWindowHandles());
            ArrayList<String> topLinksList = new ArrayList<String>();
            Thread.sleep(5000);
            for (int i = 1; i < n + 1; i++) {
                driver.switchTo().window(topTabs.get(i));
                topLinksList.add(driver.getCurrentUrl());
//            System.out.println(driver.getCurrentUrl());
            }
//        System.out.println(topLinksList.get(0)+"          1st");
//            for (int i = 1; i < n + 1; i++) {
//                sheet1.createRow(i);
//                sheet1.getRow(i).createCell(0).setCellValue(i);
//                sheet1.getRow(i).createCell(1).setCellValue(topTitle.get(i - 1));
//                sheet1.getRow(i).createCell(2).setCellValue(topSubtitle.get(i - 1));
////            sheet1.getRow(i).createCell(3).setCellValue(linksList.get(i-1));
//                sheet1.getRow(i).createCell(4).setCellValue(topVersions.get(i - 1));
//                sheet1.getRow(i).createCell(5).setCellValue(topEvents.get(i - 1));
//                sheet1.getRow(i).createCell(6).setCellValue(topUsers.get(i - 1));
//            }
            j = 1;
//            for (int i = n - 1; i >= 0; i--) {
//                sheet1.getRow(j).createCell(3).setCellValue(topLinksList.get(i));
//                j++;
//            }
//            workbook1.write(file1);
//            workbook1.close();

            String test = "", testRed = "";
            testRed = "<H2 style=\"background-color:red;\">Top 5 Crash (URGENT CHECK)</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\">" + "<tr><th>Serial No.</th><th>Title</th><th>Subtitle</th><th>URL</th><th>Version</th><th>Events</th><th>Users</th></tr>";
            test = "<H2>Top 5 Crash</H2><table cellpadding=\"8px\" cellspacing=\"1\" border=\"1\" style=\"width:60%;text-align: centre;\">" + "<tr><th>Serial No.</th><th>Title</th><th>Subtitle</th><th>URL</th><th>Version</th><th>Events</th><th>Users</th></tr>";
            m = "</table>";
            j = n - 1;
            for (int i = 1; i <= n; i++) {
                if (checkTopTags.get(i - 1).contains("Fresh issue present")) {
                    if (redHeading == false) {
                        test = test + "<td style=\"background-color:yellow;\">" + i + "</td><td style=\"background-color:yellow;\">" + topTitle.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topSubtitle.get(i - 1) + "</td><td style=\"background-color:yellow;\"><a href=\"" + topLinksList.get(j) + "\">UrlLink</a></td><td style=\"background-color:yellow;\">" + topVersions.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topEvents.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topUsers.get(i - 1) + "</td><tr></tr>";
                    } else {
                        testRed = testRed + "<td style=\"background-color:yellow;\">" + i + "</td><td style=\"background-color:yellow;\">" + topTitle.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topSubtitle.get(i - 1) + "</td><td style=\"background-color:yellow;\"><a href=\"" + topLinksList.get(j) + "\">UrlLink</a></td><td style=\"background-color:yellow;\">" + topVersions.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topEvents.get(i - 1) + "</td><td style=\"background-color:yellow;\">" + topUsers.get(i - 1) + "</td><tr></tr>";
                    }
                } else {
                    if (redHeading == false) {
                        test = test + "<td>" + i + "</td><td>" + topTitle.get(i - 1) + "</td><td>" + topSubtitle.get(i - 1) + "</td><td><a href=\"" + topLinksList.get(j) + "\">UrlLink</a></td><td>" + topVersions.get(i - 1) + "</td><td>" + topEvents.get(i - 1) + "</td><td>" + topUsers.get(i - 1) + "</td><tr></tr>";
                    } else {
                        testRed = testRed + "<td>" + i + "</td><td>" + topTitle.get(i - 1) + "</td><td>" + topSubtitle.get(i - 1) + "</td><td><a href=\"" + topLinksList.get(j) + "\">UrlLink</a></td><td>" + topVersions.get(i - 1) + "</td><td>" + topEvents.get(i - 1) + "</td><td>" + topUsers.get(i - 1) + "</td><tr></tr>";
                    }
                }
                j--;
            }
            if (n == 0) {
                test = test + "<td> No issues </td>";
                testRed = testRed + "<td> No issues </td>";
            }
            test = test + m;
            testRed = testRed + m;

            try{
                driver.quit();
            }catch (Exception e) {
                driver.close();
            }


            /////////// Sending Mail
//        if(sendMail) {
            Properties props = new Properties();

            // this will set host of server- you can change based on your requirement
            props.put("mail.smtp.host", "smtp.gmail.com");

            // set the port of socket factory
            props.put("mail.smtp.socketFactory.port", "465");

            // set socket factory
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // set the authentication to true
            props.put("mail.smtp.auth", "true");

            // set the port of SMTP server
            props.put("mail.smtp.port", "465");

            // This will handle the complete authentication
            Session session = Session.getDefaultInstance(props,

                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {

                            return new PasswordAuthentication(username, pass);

                        }

                    });

            String[] recipients = new String[4];
            recipients[0] = "qafront-end@mobikwik.com";
            recipients[1] = "MBK-Android@mobikwik.com";

            try {

                // Create object of MimeMessage class
                Message message = new MimeMessage(session);

                // Set the from address
                message.setFrom(new InternetAddress("qafront-end@mobikwik.com"));

                // Set the recipient address
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("qafront-end@mobikwik.com"));

                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("ios@mobikwik.com"));

                // Add the subject link
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            System.out.println(timestamp);
                message.setSubject("IOS Crashlytics | Report | " + timestamp);

                if (redHeading == false) {
                    message.setContent(crashFreeMail + test + freshTest, "text/html");
                } else {
                    message.setContent(crashFreeMail + testRed + freshTest, "text/html");
                }

                // finally send the email
                Transport.send(message);

                System.out.println("=====Email Sent=====");

            } catch (MessagingException e) {

                throw new RuntimeException(e);

            }
        }

    }

    public static void shortWait(WebDriver driver,String text){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element;
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
        } catch (Exception e){
            if(!e.toString().contains("TimeoutException")){
                Assert.assertTrue(false);
            }
        }
    }

    public static void longWait(WebDriver driver,String text){
        WebDriverWait wait=new WebDriverWait(driver, 40);
        WebElement element;
        element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
    }

    public static boolean rightClick_little_right(WebDriver driver,Actions a, WebElement web){
        try {
            a.moveToElement(web,550,0).keyDown(Keys.COMMAND).click().perform();
            a.moveToElement(driver.findElement(By.xpath("//i[text()='gmp_nav20_performance']"))).perform();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static boolean rightClick(WebDriver driver, Actions a, WebElement web){
        try {
            a.moveToElement(web).keyDown(Keys.COMMAND).click().perform();
            a.moveToElement(driver.findElement(By.xpath("//i[text()='gmp_nav20_performance']"))).perform();
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }

    }
}
