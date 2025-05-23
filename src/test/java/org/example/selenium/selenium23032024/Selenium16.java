package org.example.selenium.selenium23032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium16 {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {

        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("macmini");
        WebElement searchBoxButton = driver.findElement(By.cssSelector("button[value='Search']"));
        searchBoxButton.click();

        //After Click we will wait
        Thread.sleep(3000);

        //We can use By.className='s-item__title';
        List<WebElement> searchedTitles = driver.findElements(By.xpath("//div[@class='s-item__title']"));
         // int i = 0;
        for (WebElement title:searchedTitles){
            System.out.println(title.getText());

//            if(i == 10){
//                title.click();

            //}
            //i++;

        }


    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
