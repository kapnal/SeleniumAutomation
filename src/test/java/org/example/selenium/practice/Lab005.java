package org.example.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Lab005 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https:app.vwo.com");
        driver.get("https:google.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.quit();

    }
}
