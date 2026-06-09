package com.akbar._01_basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Demonstrates handling JavaScript Alerts using Explicit Wait in Selenium WebDriver.
 */
public class _17_AlertsUsingExplicitWait {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Create Explicit Wait object with timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open JavaScript Alerts demo page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Locate "Click for JS Alert" button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));

        // Click button to trigger JavaScript Alert
        jsAlertBtn.click();

        // Wait until alert becomes available
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Click OK button on the alert
        alert.accept();

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
