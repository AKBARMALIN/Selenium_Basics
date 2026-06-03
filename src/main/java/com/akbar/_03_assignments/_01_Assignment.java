package com.akbar._03_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Set;

/**
 * Assignment Program:
 * Demonstrates handling of Multiple Browser Windows using Selenium WebDriver.
 *
 * Scenario:
 * 1. Open Test Automation Practice website.
 * 2. Search for the keyword "Selenium" in the Wikipedia search box.
 * 3. Capture and count all generated result links.
 * 4. Open every search result link.
 * 5. Retrieve all browser window IDs.
 * 6. Switch between windows and close selected windows
 *    based on their page titles.
 *
 * Concepts Covered:
 * - Element locating using XPath
 * - Search box interaction
 * - Handling collections of WebElements
 * - Multiple window handling
 * - Window switching
 * - Conditional browser closing
 */
public class _01_Assignment {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Open target website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate Wikipedia search box
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id, 'wikipedia-search-input')]"));

        // Enter search keyword
        searchBox.sendKeys("Selenium");

        // Locate search button
        WebElement searchBtn = driver.findElement(By.xpath("//input[contains(@class, 'wikipedia-search-button')]"));

        // Click search button
        searchBtn.click();

        // Capture all generated Wikipedia result links
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));

        // Print total number of search result links
        System.out.println("Number of links: " + links.size());

        // Iterate through each search result link
        for(WebElement link : links) {
            // Click each link to open in a new browser window/tab
            link.click();
        }

        // Capture all browser window IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Iterate through all opened windows
        for(String windowId : windowIds) {

            // Switch driver focus to current window
            String title = driver.switchTo().window(windowId).getTitle();

            // Check page title and close matching windows
            if(title.equalsIgnoreCase("Selenium disulfide - Wikipedia") || title.equalsIgnoreCase("Selenium in biology - Wikipedia")) {
                // Close matching browser window
                driver.close();
            }
        }

        // Note:
        // Remaining browser windows stay open because
        // driver.quit() is not used in this program.
    }
}
