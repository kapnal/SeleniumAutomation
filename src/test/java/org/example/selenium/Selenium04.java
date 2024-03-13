package org.example.selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;


public class Selenium04 {
    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--window-size=800,600");
        EdgeDriver driver = new EdgeDriver(edgeOptions); // Dynamic Dispatch -> Runtime Poly
        driver.get ("https://sdet.live");
        System.out.println(driver.getTitle());

        //driver.manage().window().maximize();

        driver.quit();



    }

}
