package org.example.selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium05 {

    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("121.40.185.42:1080");
        edgeOptions.setCapability("proxy", proxy);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://sdet.live");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
