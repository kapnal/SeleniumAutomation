package org.example.selenium.selenium31032024;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReading {

    public static void main(String[] args) throws Exception {

        // Specify Location of file
        File src = new File(System.getProperty("user.dir")+"/src/main/Repository/List of Top Shares.xlsx");

        // Load the file
        FileInputStream fis = new FileInputStream(src);

        //Load workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        // Load sheet
        XSSFSheet sh = wb.getSheet("List of Shares");

        // Print the loaded sheet name
        System.out.println(sh.getSheetName());

        // Print Company Name
        System.out.println(sh.getRow(0).getCell(1).getStringCellValue());

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        //Enter username from excel
        String us = sh.getRow(1).getCell(1).getStringCellValue();
        //int pa = (int)sh.getRow(1).getCell(2).getNumericCellValue();
        driver.findElement(By.id("email")).sendKeys(us);
        //driver.findElement(By.id("pass")).sendKeys(pa);
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
