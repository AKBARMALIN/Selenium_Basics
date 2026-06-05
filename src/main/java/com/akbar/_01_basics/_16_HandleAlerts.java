package com.akbar._01_basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/**
 * Demonstrates handling different types of JavaScript Alerts using Selenium WebDriver.
 */
public class _16_HandleAlerts {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Text to be entered into Prompt Alert
        String alertText = "Selenium Alert";

        // Open JavaScript Alerts demo page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Locate and click JS Alert button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertBtn.click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Print alert message
        System.out.println("Alert text: " + alert.getText());

        // Click OK button
        alert.accept();

        // Locate and click JS Confirm button
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmBtn.click();

        // Switch to alert
        alert = driver.switchTo().alert();

        // Print alert message
        System.out.println("Alert text: " + alert.getText());

        // Click Cancel button
        alert.dismiss();

        // Locate and click JS Prompt button
        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPromptBtn.click();

        // Switch to prompt alert
        alert = driver.switchTo().alert();

        // Print alert message
        System.out.println("Alert text: " + alert.getText());

        // Enter text into prompt textbox
        alert.sendKeys(alertText);

        // Click OK button
        alert.accept();

        // Capture displayed result message
        String actAlertText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        // Verify entered text is displayed
        if(actAlertText.contains(alertText)) {
            System.out.println("Alert text is correctly displayed in the result.");
        } else {
            System.out.println("Alert text is NOT correctly displayed in the result.");
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
