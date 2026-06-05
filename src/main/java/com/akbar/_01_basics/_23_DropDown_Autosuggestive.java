package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of an Auto-Suggestive Dropdown using Selenium WebDriver.
 */
public class _23_DropDown_Autosuggestive {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Maximize browser window
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open Google website
        driver.get("https://www.google.com/");

        // Locate Google search box and enter text "Selenium"
        driver.findElement(By.name("q")).sendKeys("Selenium");

        // Locate all auto-suggestion options from the dropdown
        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));

        // Print total number of suggestions available
        System.out.println("Total options in the dropdown: " + options.size());

        // Iterate through all dropdown suggestions
        for(int i = 0; i < options.size(); i++) {

            // Get text of current suggestion
            String option = options.get(i).getText();

            // Print suggestion text
            System.out.println("- " + option);

            // Check whether current suggestion matches expected text
            if(option.equalsIgnoreCase("selenium")) {

                // Click matching option
                options.get(i).click();

                // Exit loop after successful selection
                break;
            }
        }

        // Close browser and end WebDriver session
        driver.quit();
    }
}