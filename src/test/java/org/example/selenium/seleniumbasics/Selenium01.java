package org.example.selenium.seleniumbasics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Selenium01 {

    public static void main(String[] args) {
        //WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://sdet.live");
            System.out.println(driver.getTitle());

            // Take a screenshot and save it to a file
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Take screenshot
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Specify the destination file path
            File destFile = new File("src/test/java/org/example/selenium/seleniumbasics/screenshots/loginpage1.png");

            // Use FileUtils to save the file to the specified location
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the screenshot.");
            e.printStackTrace();
        } finally {

            driver.quit();

        }







    }
}
