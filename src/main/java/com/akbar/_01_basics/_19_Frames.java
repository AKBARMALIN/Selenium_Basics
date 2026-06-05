package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Demonstrates handling of Frames and Nested Frames using Selenium WebDriver.
 */
public class _19_Frames {

    public static void main(String[] args) {

        // Create Chrome browser instance
        WebDriver driver=new ChromeDriver();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open UI Vision Frames demo page
        driver.get("https://ui.vision/demo/webtest/frames/");

        // Maximize browser window
        driver.manage().window().maximize();

        // ===============================
        // Frame 1 Handling
        // ===============================

        // Locate Frame 1
        WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));

        // Switch to Frame 1
        driver.switchTo().frame(frame1);

        // Enter text into Frame 1 textbox
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

        // Return to main page
        driver.switchTo().defaultContent();

        // ===============================
        // Frame 2 Handling
        // ===============================

        // Locate Frame 2
        WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));

        // Switch to Frame 2
        driver.switchTo().frame(frame2);

        // Enter text into Frame 2 textbox
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Automation");

        // Return to main page
        driver.switchTo().defaultContent();

        // ===============================
        // Frame 3 Handling
        // ===============================

        // Locate Frame 3
        WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));

        // Switch to Frame 3
        driver.switchTo().frame(frame3);

        // Enter text into Frame 3 textbox
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("programming");

        // ===============================
        // Nested Frame Handling
        // ===============================

        // Switch to inner frame inside Frame 3
        // Index 0 refers to the first child frame
        driver.switchTo().frame(0);

        // Select radio button option inside nested frame
        driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
