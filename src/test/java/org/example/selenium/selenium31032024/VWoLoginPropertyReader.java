package org.example.selenium.selenium31032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class VWoLoginPropertyReader {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        driver = new EdgeDriver();

    }

    @Test(groups = "QA")
    @Description("Verify the VWO login with valid user name and pass dshboard is display")
    public void testVWOLogin_Positive() throws Exception {

        //Config file
        //Create FileInputStream class object to load the file
        FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"/src/main/Repository/config.properties");
        //Create Properties class object to read properties file
        Properties pr1 = new Properties();
        pr1.load(file1);
       //Locators file
        FileInputStream file2 = new FileInputStream(System.getProperty("user.dir")+"/src/main/Repository/locators.properties");
        Properties pr2 = new Properties();
        pr2.load(file2);
       //Testdata file
        FileInputStream file3 = new FileInputStream(System.getProperty("user.dir")+"/src/main/Repository/testdata.properties");
        Properties pr3 = new Properties();
        pr3.load(file3);

        driver.get(pr1.getProperty("url"));

        //getProperty() will accept key and return value of that key
         WebElement emailInputBox = driver.findElement(By.xpath(pr2.getProperty("Email")));
        emailInputBox.sendKeys(pr3.getProperty("username"));

        WebElement passwordInputBox = driver.findElement(By.xpath(pr2.getProperty("Password")));
        passwordInputBox.sendKeys(pr3.getProperty("password"));

        driver.findElement(By.xpath(pr2.getProperty("Signin"))).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr2.getProperty("LoggedinUser"))));

        WebElement user = driver.findElement(By.xpath(pr2.getProperty("LoggedinUser")));
        String loggedinUser = user.getText();
        System.out.println(loggedinUser);
        Assert.assertEquals(loggedinUser,pr3.getProperty("user"));

    }

@AfterTest
    public void closeBrowser(){

        driver.quit();
}

}
