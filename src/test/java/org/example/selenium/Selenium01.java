package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium01 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();





    }
}
