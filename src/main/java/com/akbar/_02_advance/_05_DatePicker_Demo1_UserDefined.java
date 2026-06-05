package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of a jQuery Date Picker using User-Defined Methods for both Future and Past Date Selection.
 */
public class _05_DatePicker_Demo1_UserDefined {

    public static void main(String[] args) {
        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open jQuery UI DatePicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to iframe containing the DatePicker
        driver.switchTo().frame(0);

        // Directly enter the date into the text field.
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2026");

        // Desired date values
        String expectedYear = "2026";
        String expectedMonth = "july";
        String expectedDate = "29";

        // Open DatePicker calendar
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // Select future date
        selectFutureDate(driver, expectedMonth, expectedYear, expectedDate);

        /*
         * Select past date
         * Uncomment and provide a past date if needed.
         */
        // selectPastDate(driver, expectedMonth, expectedYear, expectedDate);

        // Close browser and terminate WebDriver session
        driver.quit();
    }

    /**
     * Selects a future date by navigating through
     * the calendar using the Next button.
     *
     * @param driver Selenium WebDriver instance
     * @param expectedMonth Required month
     * @param expectedYear Required year
     * @param expectedDate Required date
     */
    private static void selectFutureDate(WebDriver driver, String expectedMonth, String expectedYear, String expectedDate) {
        // Navigate until desired month and year appear
        while(true) {

            // Capture current month displayed
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Capture current year displayed
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Stop when desired month and year are found
            if(currentMonth.equalsIgnoreCase(expectedMonth) && currentYear.equalsIgnoreCase(expectedYear)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        // Capture all available dates
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        // Select required date
        for(WebElement date : dates) {
            if(date.getText().equalsIgnoreCase(expectedDate)) {
                date.click();
                break;
            }
        }
    }

    /**
     * Selects a past date by navigating through
     * the calendar using the Previous button.
     *
     * @param driver Selenium WebDriver instance
     * @param expectedMonth Required month
     * @param expectedYear Required year
     * @param expectedDate Required date
     */
    private static void selectPastDate(WebDriver driver, String expectedMonth, String expectedYear, String expectedDate) {
        // Navigate until desired month and year appear
        while(true) {

            // Capture current month displayed
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Capture current year displayed
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Stop when desired month and year are found
            if(currentMonth.equalsIgnoreCase(expectedMonth) && currentYear.equalsIgnoreCase(expectedYear)) {
                break;
            } else { // Move to previous month
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        // Capture all available dates
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        // Select required date
        for(WebElement date : dates) {
            if(date.getText().equalsIgnoreCase(expectedDate)) {
                date.click();
                break;
            }
        }
    }
}
