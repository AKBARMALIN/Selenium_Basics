package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Demonstrates locating elements using CSS selectors on the nopCommerce demo site.
 *
 * Notes:
 * - This is a simple demo/main-class style program. For robust test code, use a test framework,
 *   explicit waits, and proper setup/teardown (try/finally or JUnit/TestNG lifecycle methods).
 * - Requires a matching EdgeDriver binary available to the runtime (on PATH or managed).
 */
public class _03_Css_Locators {

    public static void main(String[] args) {

        // Create a new EdgeDriver instance -> opens a Microsoft Edge browser.
        // Precondition: correct Edge WebDriver executable must be available.
        WebDriver driver = new EdgeDriver();

        // Optional: maximize the browser window for consistent layout/visibility.
        driver.manage().window().maximize();

        // Navigate to the demo nopCommerce homepage used in the examples below.
        driver.get("https://demo.nopcommerce.com/");

        // Find the search input using a CSS selector which matches an <input> element with id "small-searchterms".
        // CSS: input#small-searchterms  -> tag name + id selector
        WebElement searchBox = driver.findElement(By.cssSelector("input#small-searchterms"));

        // Type "laptop" into the located search box.
        searchBox.sendKeys("laptop");

        // Clear the search box text using WebElement.clear(). Usually used before sending new text.
        searchBox.clear();

        // Locate the search button using a CSS selector for a button element with class "search-box-button".
        // CSS: button.search-box-button -> tag name + class selector
        boolean status = driver.findElement(By.cssSelector("button.search-box-button")).isDisplayed();
        System.out.println("Search button is displayed: " + status);

        // Locate the same (or another) button by attribute selector. Here we check if it is enabled.
        // CSS: button[type='submit'] -> tag + attribute selector (exact match)
        status = driver.findElement(By.cssSelector("button[type='submit']")).isEnabled();
        System.out.println("Search button is enabled: " + status);

        // Locate an input using both class and attribute selectors:
        // CSS: input.ui-autocomplete-input[placeholder='Search store']
        // - matches an <input> element with class "ui-autocomplete-input" AND placeholder attribute equal to "Search store".
        driver.findElement(By.cssSelector("input.ui-autocomplete-input[placeholder='Search store']")).sendKeys("Mobiles");

        // Locate a radio input using a pseudo-class nth-child(1).
        // CSS: input[type='radio']:nth-child(1)
        // Note: nth-child selects based on the element's position among siblings; ensure the DOM structure is what you expect.
        driver.findElement(By.cssSelector("input[type='radio']:nth-child(1)")).click();

        driver.quit();

    }
}
