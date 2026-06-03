package com.akbar._03_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Assignment Program:
 * Demonstrates handling of Radio Buttons and Checkboxes
 * using Selenium WebDriver.
 *
 * Scenario:
 * 1. Launch browser and open Radio Buttons page.
 * 2. Capture total number of radio buttons.
 * 3. Select the "Red" radio button.
 * 4. Verify whether the radio button is selected.
 * 5. Navigate to Checkbox page.
 * 6. Capture total number of checkboxes.
 * 7. Select all unchecked checkboxes.
 *
 * Concepts Covered:
 * - Element locating using XPath
 * - Radio button handling
 * - Checkbox handling
 * - Element state validation
 * - Browser navigation
 * - Working with List<WebElement>
 */
public class _02_Assignment {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Open radio buttons practice page
        driver.get("https://practice.expandtesting.com/radio-buttons");

        // Capture all radio buttons having name='color'
        List<WebElement> radioList = driver.findElements(By.xpath("//input[@type='radio' and @name='color']"));

        // Print total number of radio buttons
        System.out.println("Total radio buttons: " + radioList.size());

        // Iterate through all radio buttons
        for(WebElement radio : radioList) {

            // Check whether current radio button value is "red"
            if(radio.getAttribute("value").equalsIgnoreCase("red")) {

                // Click Red radio button
                radio.click();

                // Verify and print selection status
                System.out.println("Red radio button is selected: " + radio.isSelected());
            }
        }

        // Navigate to checkbox practice page
        driver.navigate().to("https://practice.expandtesting.com/checkboxes");

        // Capture all checkbox elements
        List<WebElement> chkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Print total number of checkboxes
        System.out.println("Total checkboxes: " + chkboxList.size());

        // Iterate through all checkboxes
        for(WebElement chkbox : chkboxList) {
            // Select checkbox only if it is not already selected
            if(!chkbox.isSelected()) {
                // Click unchecked checkbox
                chkbox.click();
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
