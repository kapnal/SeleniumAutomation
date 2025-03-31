package org.example.selenium.seleniumbasics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium07 {

    public static void main(String[] args) throws MalformedURLException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bing.com");  // only forward allowed not back

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
