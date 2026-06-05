package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of a jQuery Date Picker using Selenium WebDriver.
 */
public class _03_DatePicker_Demo1 {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open jQuery UI DatePicker demo page
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to the frame containing the DatePicker
        driver.switchTo().frame(0);
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2026");

        // Desired date values
        String expectedYear = "2026";
        String expectedMonth = "july";
        String expectedDate = "29";

        // Open the calendar widget
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // Navigate through calendar months until expected month and year appear
        while(true) {
            // Capture currently displayed month
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Capture currently displayed year
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // Check whether expected month and year are displayed
            if(currentMonth.equalsIgnoreCase(expectedMonth) && currentYear.equalsIgnoreCase(expectedYear)) {
                break;
            } else { // Click Next button to move to next month
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        // Capture all available dates from the calendar
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        // Iterate through all dates
        for(WebElement date : dates) {
            // Select the matching date
            if(date.getText().equalsIgnoreCase(expectedDate)) {
                date.click();
                break;
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
