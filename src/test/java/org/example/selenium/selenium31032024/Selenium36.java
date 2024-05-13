package org.example.selenium.selenium31032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium36 {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(4000);

        //Selenium Support file upload only when <input type="file"
        //https://awesomeqa.com/selenium/upload.html

        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        uploadFileInput.sendKeys(dir+"\\src\\test\\java\\org\\example\\selenium\\selenium31032024\\toUpload.txt");
//if we want to give directory path :

        driver.findElement(By.name("submit")).click();

        Thread.sleep(5000);

        // Download File
        // Checked by the ChromeOption
        // Problem - Download a file and check in the dir if that is present.
        // ChromeOptions -> dir(Doc)
        // filename.doc ->  /User/pramod/Download/chrome
        // file exist - T


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
