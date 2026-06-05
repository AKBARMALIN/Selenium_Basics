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
 * Demonstrates handling of a Date Picker that contains a Year Dropdown and Month Navigation controls.
 */
public class _06_DatePicker_Demo2 {

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

        // Switch to frame containing the Date Picker
        driver.switchTo().frame("frame-one1434677811");

        // Open calendar widget
        driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

        // Locate Year dropdown
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        // Create Select object
        Select selectYear = new Select(yearDropDown);
        // Select required year
        selectYear.selectByVisibleText(expectedYear);

        // ==========================================
        // Navigate to Required Month
        // ==========================================
        while(true) {
            // Capture currently displayed month
            String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            // Convert displayed month into Month enum
            Month current_month = convertMonth(displayMonth);

            // Convert expected month into Month enum
            Month expected_month = convertMonth(expectedMonth);

            // Stop when required month is displayed
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

        // Iterate through dates
        for(WebElement date : dates) {
            // Select matching date
            if(date.getText().equals(expectedDate)) {
                date.click();
                break;
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }

    /**
     * Converts a month name into its corresponding Java Month Enum.
     *
     * Example:
     * "July" → Month.JULY
     *
     * @param month Month name as String.
     * @return Corresponding Month enum.
     * @throws IllegalArgumentException if invalid month is supplied.
     */
    private static Month convertMonth(String month) {

        // Store month names and corresponding enum values
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

        // Retrieve enum value for supplied month
        Month vmonth = monthHashMap.get(month);

        // Validate month
        if(vmonth == null) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        return vmonth;
    }
}
