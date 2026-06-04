package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Demonstrates handling of Hidden (Custom) Dropdowns using Selenium WebDriver.
 */
public class _22_DropDown_Hiddens {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Create Explicit Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open OrangeHRM application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate login page elements
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        // Enter username
        username.sendKeys("Admin");

        // Enter password
         password.sendKeys("admin123");

        // Click Login button
         loginBtn.click();

        // Wait until PIM menu becomes visible and click it
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'Pim')]"))).click();

        // Open Job Title dropdown
         driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div/div/div")).click();

        // Capture all available dropdown options
         List<WebElement> options =  driver.findElements(By.xpath("//div[@role='listbox']/div/span"));

        // Print total number of dropdown options
         System.out.println("Total options in the dropdown: " + options.size());

         for(WebElement option : options) {
                System.out.println("- " + option.getText());
         }

        // Wait for "Software Engineer" option to become visible
        WebElement jobTitleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']/span[text()='Software Engineer']")));

         // Select Software Engineer option
         jobTitleOption.click();

        // Close browser and terminate WebDriver session
         driver.quit();
    }
}

/*
 * How to identify options in a Hidden Dropdown:
 *
 * Method 1:
 * - Open SelectorsHub.
 * - Inspect the dropdown.
 * - Capture the locator for dropdown options.
 *
 * Method 2:
 * - Open Chrome/Edge DevTools (F12).
 * - Inspect the dropdown element.
 * - Go to the "Event Listeners" tab.
 * - Locate and temporarily disable/remove the "blur" event.
 * - Click the dropdown again.
 * - The option list remains visible.
 * - Inspect and capture locators for dropdown options.
 *
 * This technique is useful when dropdown options disappear
 * immediately after losing focus.
 */
