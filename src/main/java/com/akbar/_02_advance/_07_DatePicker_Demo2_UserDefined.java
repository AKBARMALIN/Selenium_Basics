package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

/**
 * Demonstrates handling of a Date Picker (Calendar Control)
 * using a User-Defined Generic Method in Selenium WebDriver.
 */
public class _07_DatePicker_Demo2_UserDefined {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open application URL
        driver.get("https://testautomationpractice.blogspot.com/");

        // Desired date values
        String expectedYear = "2026";
        String expectedMonth = "july";
        String expectedDate = "29";

        // Switch to frame containing the calendar widget
        driver.switchTo().frame("frame-one1434677811");

        // Open date picker calendar
        driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

        // Call reusable method to select date
        selectDate(driver, expectedYear, expectedMonth, expectedDate);

        // Close browser
        driver.close();
    }

    /**
     * Converts a month name String into Java Month Enum.
     *
     * Example:
     * "July" -> Month.JULY
     *
     * @param month Month name as String.
     * @return Corresponding Month enum value.
     * @throws IllegalArgumentException if invalid month is provided.
     */
    private static Month convertMonth(String month) {

        // Store month name and corresponding Month enum
        HashMap<String, Month> monthHashMap = new HashMap<>();

        monthHashMap.put("January", Month.JANUARY);
        monthHashMap.put("February", Month.FEBRUARY);
        monthHashMap.put("March", Month.MARCH);
        monthHashMap.put("April", Month.APRIL);
        monthHashMap.put("May", Month.MAY);
        monthHashMap.put("June", Month.JUNE);
        monthHashMap.put("July", Month.JULY);
        monthHashMap.put("August", Month.AUGUST);
        monthHashMap.put("September", Month.SEPTEMBER);
        monthHashMap.put("October", Month.OCTOBER);
        monthHashMap.put("November", Month.NOVEMBER);
        monthHashMap.put("December", Month.DECEMBER);

        // Retrieve Month enum value
        Month vmonth = monthHashMap.get(month);

        // Validate month input
        if(vmonth == null) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        return vmonth;
    }

    /**
     * Selects a specific date from the calendar widget.
     *
     * Steps:
     * 1. Select Year from dropdown.
     * 2. Navigate to desired month.
     * 3. Select desired date.
     *
     * @param driver Selenium WebDriver instance.
     * @param expectedYear Desired year.
     * @param expectedMonth Desired month.
     * @param expectedDate Desired date.
     */
    private static void selectDate(WebDriver driver, String expectedYear, String expectedMonth, String expectedDate) {

        // Locate Year dropdown
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        // Create Select object for year dropdown
        Select selectYear = new Select(yearDropDown);

        // Select desired year
        selectYear.selectByVisibleText(expectedYear);

        // Navigate to desired month
        while(true) {
            // Capture currently displayed month
            String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Convert displayed month to Month enum
            Month current_month = convertMonth(displayMonth);

            // Convert expected month to Month enum
            Month expected_month = convertMonth(expectedMonth);

            // Desired month reached
            if(expected_month.compareTo(current_month) == 0) {
                break;
            } else if(expected_month.compareTo(current_month) > 0) { // Move forward to next month
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } else { // Move backward to previous month
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        // Capture all available dates
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));

        // Iterate through dates and select matching date
        for(WebElement date : dates) {
            if(date.getText().equals(expectedDate)) {
                // Click desired date
                date.click();
                break;
            }
        }
    }
}
