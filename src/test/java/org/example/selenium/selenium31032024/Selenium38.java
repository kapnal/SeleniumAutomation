package org.example.selenium.selenium31032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;

public class Selenium38 {

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://app.vwo.com/#/analyze/osa/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);
        driver.manage().window().maximize();

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click " + mainWindowHandle);
        Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(By.cssSelector("[data-qa=\"meqeqiwiwe\"]"))).click().build().perform();

        Thread.sleep(3000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();

            if (!mainWindowHandle.equalsIgnoreCase((childWindow))) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
            }
        }

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
