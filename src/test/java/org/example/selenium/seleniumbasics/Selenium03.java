package org.example.selenium.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {

    @Test
    public void testMethod(){

        //Extension to the Edge Browser
        // YouTube video -. Ad blocker Extension

//        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--headless");  //without showing UI executes tests
//        edgeOptions.addExtensions(new File("C:\\Users\\kapil\\Downloads\\AddBlocker.crx"));
//
//        WebDriver driver  = new EdgeDriver(edgeOptions);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("/Users/kapil/Downloads/AddBlocker.crx"));

        WebDriver driver  = new ChromeDriver(chromeOptions);
        driver.get("https://youtube.com");

        System.out.println(driver.getTitle());
        driver.quit();


    }

}
