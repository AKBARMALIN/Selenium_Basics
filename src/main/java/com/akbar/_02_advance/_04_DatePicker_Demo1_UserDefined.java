package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of a jQuery Date Picker using User-Defined Methods in Selenium WebDriver.
 */
public class _04_DatePicker_Demo1_UserDefined {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open jQuery UI DatePicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to the iframe containing the DatePicker
        driver.switchTo().frame(0);

        // Directly enter date into input field.
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2026");

        // Desired date values
        String expectedYear = "2026";
        String expectedMonth = "july";
        String expectedDate = "29";

        // Open calendar widget
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // Navigate to desired month and year
        selectMonthAndYear(driver, expectedMonth, expectedYear);

        // Select desired date
        selectDate(driver, expectedDate);

        // Close browser and terminate WebDriver session
        driver.quit();
    }

    /**
     * Navigates through the calendar until the expected
     * month and year are displayed.
     *
     * @param driver Selenium WebDriver instance
     * @param expectedMonth Required month
     * @param expectedYear Required year
     */
    private static void selectMonthAndYear(WebDriver driver, String expectedMonth, String expectedYear) {
        while(true) {
            // Capture currently displayed month
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Capture currently displayed year
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Stop navigation when desired month and year are reached
            if(currentMonth.equalsIgnoreCase(expectedMonth) && currentYear.equalsIgnoreCase(expectedYear)) {
                break;
            } else { // Move to next month
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
    }

    /**
     * Selects the required date from the currently displayed month.
     *
     * @param driver Selenium WebDriver instance
     * @param expectedDate Required date
     */
    private static void selectDate(WebDriver driver, String expectedDate) {
        // Capture all available dates from calendar
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        // Iterate through dates
        for(WebElement date : dates) {
            // Select matching date
            if(date.getText().equalsIgnoreCase(expectedDate)) {
                date.click();
                break;
            }
        }
    }
}
