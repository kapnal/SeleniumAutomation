package org.example.selenium.selenium23032024;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium14 {

    // Atomic Test Cases
    // TC who don't have any dependency
    // They serve single purpose

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        // Create Session via the API and Session ID is generated
        driver = new ChromeDriver();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVWOLogin_positive() throws InterruptedException {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVWOLogin_negative() throws InterruptedException {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }
        @AfterTest
        public void closeBrowser(){

        driver.quit();

        }
}
