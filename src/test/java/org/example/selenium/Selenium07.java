package org.example.selenium;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium07 {

    public static void main(String[] args) throws MalformedURLException {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");  // only forward allowed not back

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
