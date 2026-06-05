package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of Radio Buttons using Selenium WebDriver.
 */
public class _15_RadioButtonsHandling {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open Test Automation Practice website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate all radio buttons available on the page
        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));

        // Print total number of radio buttons
        System.out.println("Total radio buttons: " + radioBtns.size());

        // Locate Male radio button
        WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));

        // Locate Female radio button
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));

        // Check initial selection status
        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());

        // Select Male radio button
        male_rd.click();

        // Verify selection status after clicking Male
        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
