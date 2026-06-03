package com.akbar._03_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Assignment Program:
 * Demonstrates handling of a Web Table with Pagination using Selenium WebDriver.
 *
 * Scenario:
 * 1. Launch the Test Automation Practice website.
 * 2. Capture the total number of pagination pages.
 * 3. Navigate through each page of the table.
 * 4. Read product details (ID, Name, Price) from each row.
 * 5. Select the checkbox corresponding to every product.
 * 6. Print product information in the console.
 *
 * Concepts Covered:
 * - Web Table handling
 * - Pagination handling
 * - Dynamic XPath creation
 * - Looping through rows and pages
 * - Checkbox interaction
 */
public class _04_Assignment {

    public static void main(String[] args) throws InterruptedException {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open target website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Capture total number of pagination links/pages
        int total_pages = driver.findElements(By.xpath("//ul[@class='pagination']//li/a")).size();

        // Iterate through all pages
        for(int page = 1; page <= total_pages; page++) {
            System.out.println("Page: " + page);

            // Navigate to next page (skip for first page because it loads by default)
            if(page > 1) {
                // Locate pagination link dynamically using page number
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li/a[text()='" + page + "']"));
                // Click on the page number
                active_page.click();
                // Pause execution to allow page content to refresh
                Thread.sleep(2000);
            }

            // Capture total rows available in current page table
            int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
            // Iterate through all rows of the current page
            for(int row = 1; row <= rows; row++) {
                // Capture Product ID from current row
                String productId = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + row + "]//td[1]")).getText();
                // Capture Product Name from current row
                String productName = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + row + "]//td[2]")).getText();
                // Capture Product Price from current row
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + row + "]//td[3]")).getText();
                // Select product checkbox from current row
                driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + row + "]//td[4]//input")).click();
                // Print product details in console
                System.out.println(productId + " - " + productName + " - " + productPrice);
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}