package com.akbar._01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * This class demonstrates Navigation Methods in Selenium WebDriver.
 *
 * Navigation methods are used to navigate between different web pages.
 * Selenium provides two main approaches:
 * 1. driver.get() - Direct navigation using a String URL
 * 2. driver.navigate() - Navigation interface that provides more flexibility
 *
 * This class illustrates the differences and use cases for each method.
 */

public class _09_NavigationMethods {
    public static void main(String[] args) throws MalformedURLException {

        // Initialize the WebDriver with Edge browser
        WebDriver driver = new EdgeDriver();

        // Set implicit wait to 10 seconds for all element lookups
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // ===== Method 1: driver.get() =====
        // This method accepts only a String URL and opens the page in the current window.
        // It waits for the page to load completely before returning control to the test script.
        driver.get("https://demo.nopcommerce.com/");

        // ===== Method 2: driver.navigate().to() with String URL =====
        // Similar to driver.get(), but part of the Navigation interface.
        // Provides access to additional navigation methods like back(), forward(), refresh().
        // driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // ===== Method 3: driver.navigate().to() with URL Object =====
        // This version accepts a URL object instead of a String.
        // Useful when you need to construct URLs programmatically or parse URL components.
        URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to(url);
        // The page is now loaded and we can interact with its elements.

        // ===== Navigation: Back =====
        // Navigates to the previous page in the browser history (equivalent to clicking the back button).
        // This will take us back to the nopcommerce home page (https://demo.nopcommerce.com/).
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        // Expected output: https://demo.nopcommerce.com/

        // ===== Navigation: Forward =====
        // Navigates to the next page in the browser history (equivalent to clicking the forward button).
        // This will take us forward to the OrangeHRM login page again.
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        // Expected output: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        // ===== Navigation: Refresh =====
        // Refreshes the current page (equivalent to pressing F5 or clicking the refresh button).
        // The page will reload and all elements will be re-fetched from the server.
        driver.navigate().refresh();

        // Close the browser and clean up all resources
        driver.quit();
    }
}

/*
================================================================================
Q: Differences between driver.get() and driver.navigate().to() methods in
   Selenium WebDriver?
================================================================================

A: The main differences are as follows:

1. FUNCTIONALITY:
   ▶ driver.get():
     - Opens a web page in the current browser window
     - Waits for the page to load completely before returning control
     - Simpler method for basic navigation

   ▶ driver.navigate().to():
     - Also opens a web page in the current window
     - Part of the Navigation interface
     - Provides access to additional navigation methods (back, forward, refresh)
     - More flexible for complex navigation scenarios

2. PARAMETERS:
   ▶ driver.get():
     - Accepts only a String URL as parameter
     - Example: driver.get("https://example.com")

   ▶ driver.navigate().to():
     - Can accept both String URL and URL object as parameters
     - Example 1 (String): driver.navigate().to("https://example.com")
     - Example 2 (URL): driver.navigate().to(new URL("https://example.com"))

3. USE CASES:
   ▶ driver.get():
     - Use for simple navigation to a web page
     - Typically used at the beginning of a test case
     - When you only need to navigate to a single URL

   ▶ driver.navigate().to():
     - Use when you need to navigate to multiple pages in sequence
     - Use when you want to navigate back and forth between pages
     - Use when you need to refresh a page
     - Use when you need to work with URL objects instead of strings

4. RETURN VALUE:
   ▶ driver.get():
     - Returns void

   ▶ driver.navigate().to():
     - Returns void

   ▶ driver.navigate().back(), forward(), refresh():
     - All return void

5. BEST PRACTICE:
   ▶ Use driver.get() for initial page navigation
   ▶ Use driver.navigate() when you need multiple navigation operations
     in the same test (back, forward, refresh, or multiple navigations)

================================================================================
*/