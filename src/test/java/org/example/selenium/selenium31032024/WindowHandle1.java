package org.example.selenium.selenium31032024;

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

import java.util.Iterator;
import java.util.Set;

public class WindowHandle1 {

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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

//        String mainWindowHandle = driver.getWindowHandle();
//        System.out.println(mainWindowHandle);


        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println(allWindowID);

        Iterator<String> abc = allWindowID.iterator();
        String win1 = abc.next();
        String win2 = abc.next();

        //Print title of parent window
        driver.switchTo().window(win1);
        System.out.println("Parent window ID: " + win1);
        System.out.println(driver.getTitle());

        //Print title of child window
        driver.switchTo().window(win2);
        System.out.println("Child window ID: " + win2);
        System.out.println(driver.getTitle());

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
