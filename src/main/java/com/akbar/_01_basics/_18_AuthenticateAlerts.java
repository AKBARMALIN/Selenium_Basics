package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/**
 * Demonstrates handling of Authentication Alerts (HTTP Basic Authentication) using Selenium WebDriver.
 */
public class _18_AuthenticateAlerts {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ==================================================
        // Basic Authentication Handling
        // ==================================================

        /*
         * Syntax:
         * https://username:password@website-url
         *
         * username = admin
         * password = admin
         *
         * Selenium automatically passes these credentials
         * to the authentication popup.
         */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Expected success message after authentication
        String expectedText = "Congratulations! You must have the proper credentials.";

        // Capture actual message displayed on the webpage
        String actualText = driver.findElement(By.cssSelector("div.example p")).getText();

        // Compare actual and expected messages
        if(actualText.equals(expectedText)) {
            System.out.println("Authentication successful. Text matches expected.");
        } else {
            System.out.println("Authentication failed or text does not match expected.");
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
