package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Static WebTable Handling Program
 *
 * This program demonstrates how to interact with static HTML tables using Selenium WebDriver.
 * It performs various operations on a table including:
 * - Counting rows and columns
 * - Retrieving specific cell values
 * - Displaying all table data
 * - Filtering data based on specific criteria
 * - Performing calculations on table data
 *
 * Website under test: https://testautomationpractice.blogspot.com/
 * Table name: BookTable
 *
 * @author Akbar
 * @version 1.0
 */
public class _01_Static_WebTable {

    public static void main(String[] args) {

        // Initialize EdgeDriver to control Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Set implicit wait of 10 seconds - automatically waits for elements up to 10 seconds
        // This applies to all findElement() calls throughout the session
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Navigate to the test automation practice website
        driver.get("https://testautomationpractice.blogspot.com/");

        // ============== GET TABLE DIMENSIONS ==============

        // Find all rows in the table with name "BookTable"
        // XPath: //table[@name='BookTable']//tr selects all <tr> (table row) elements
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        System.out.println("Total rows in the table: " + rows.size());

        // Find all column headers (th elements) in the first row of the table
        // XPath: //table[@name='BookTable']//tr[1]/th selects all <th> elements in the first row
        List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th"));
        System.out.println("Total columns in the table: " + cols.size());

        // ============== RETRIEVE SPECIFIC CELL VALUE ==============

        // Get the cell value at row 5, column 1 (first column of the 5th data row)
        // Note: Row 1 is the header, so row 5 is the 4th data row
        WebElement cell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]"));
        System.out.println("Cell value at row 5 and column 1: " + cell.getText());

        // ============== PRINT ALL TABLE DATA IN FORMATTED WAY ==============
        // Print table headers
        System.out.println("BookName" + "\t" + "\t" + "Author" + "\t" + "\t" + "Subject" + "\t" + "\t" + "Price");

        // Iterate through all data rows (starting from row 2, skipping the header row)
        for(int r = 2; r <= rows.size(); r++) {
            // Iterate through all columns in each row
            for (int c = 1; c <= cols.size(); c++) {
                // Dynamically construct XPath to get each cell
                // XPath: //table[@name='BookTable']//tr[r]/td[c]
                WebElement currentCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]"));
                System.out.print(currentCell.getText() + "\t" + "\t");
            }
            // Print newline after each row
            System.out.println();
        }

        // ============== FILTER DATA - FIND BOOKS BY SPECIFIC AUTHOR ==============
        // Loop through all data rows (starting from row 2) to find books by author "mukesh"
        for(int i = 2; i <= rows.size(); i++) {
            // Get the author cell (column 2) for the current row
            WebElement authorCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[2]"));

            // Check if the author name matches "mukesh" (case-insensitive comparison)
            if(authorCell.getText().equalsIgnoreCase("mukesh")) {
                // If match found, get the book name from column 1
                WebElement bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[1]"));
                System.out.println("Books written by Mukesh are:: " + bookName.getText());
            }
        }

        // ============== CALCULATE SUM OF PRICES ==============
        // Initialize a variable to store the total price
        int priceSum = 0;

        // Loop through all data rows to accumulate prices
        for(int i = 2; i <= rows.size(); i++) {

            // Get the price cell (column 4) for the current row
            WebElement priceCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[4]"));

            // Parse the text value to integer and add to the sum
            priceSum += Integer.parseInt(priceCell.getText());
        }

        // Print the total price of all books
        System.out.println("Total price of all the books: " + priceSum);

        // Close the browser and cleanup all resources
        driver.quit();
    }
}
