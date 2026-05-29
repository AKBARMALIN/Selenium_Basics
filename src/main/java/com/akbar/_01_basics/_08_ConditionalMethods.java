package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/**
 * This class demonstrates the use of Conditional Methods in Selenium WebDriver.
 *
 * Conditional methods are used to check the state or condition of web elements.
 * They return boolean values (true/false) based on whether the condition is met.
 *
 * Common conditional methods include:
 * 1. isDisplayed() - Checks if an element is visible on the page
 * 2. isEnabled() - Checks if an element is enabled and interactive
 * 3. isSelected() - Checks if an element (checkbox/radio button) is selected
 *
 * These methods are essential for writing robust test cases, as they help verify
 * the state of elements before interacting with them.
 */

public class _08_ConditionalMethods {

    public static void main(String[] args) {

        // Initialize the WebDriver with Edge browser
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait to 5 seconds for all element lookups
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to the nopcommerce registration page
        driver.get("https://demo.nopcommerce.com/register");

        // ===== 1. isDisplayed() Method =====
        // Returns true if the element is visible on the page, false otherwise.
        // This method checks both visibility (display: none, visibility: hidden, etc.) and presence in the DOM.
        WebElement headerLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        System.out.println("Is header logo displayed? " + headerLogo.isDisplayed());
        // Expected output: true (assuming the logo is visible on the page)

        // ===== 2. isEnabled() Method =====
        // Returns true if the element is enabled (interactable), false if it is disabled (grayed out).
        // Disabled elements typically have a "disabled" attribute or are not interactive.
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        System.out.println("Is first name field enabled? " + firstName.isEnabled());
        // Expected output: true (the field should be enabled on a fresh registration page)

        // ===== 3. isSelected() Method =====
        // Returns true if the element (checkbox or radio button) is selected, false otherwise.
        // This method is specifically for input elements of type "checkbox" or "radio".
        WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));

        // Check if radio buttons are selected before clicking
        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());
        // Expected output: false, false (neither should be selected initially)

        // Click the male radio button to select it
        male_rd.click();

        // Check the selection status after clicking
        System.out.println("After clicking male radio button: " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());
        // Expected output: true (male is now selected), false (female is still not selected)

        // Close the browser and clean up resources
        driver.quit();
    }
}
