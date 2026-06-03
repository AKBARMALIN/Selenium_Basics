package com.akbar._01_basics;

import io.cucumber.java.it.Ed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/**
 * Demonstrates handling of a Static Dropdown using Selenium WebDriver.
 *
 * Scenario:
 * 1. Launch the browser and open the Test Automation Practice website.
 * 2. Locate the Country dropdown.
 * 3. Select dropdown options using:
 *    - Visible Text
 *    - Value
 *    - Index
 * 4. Retrieve all dropdown options.
 * 5. Print the total number of options.
 * 6. Print each option available in the dropdown.
 *
 * Static Dropdown:
 * A dropdown whose options are predefined in the HTML page
 * and can be handled using Selenium's Select class.
 *
 * Concepts Covered:
 * - Select class
 * - selectByVisibleText()
 * - selectByValue()
 * - selectByIndex()
 * - getOptions()
 * - Iterating through dropdown options
 */
public class _20_DropDown_Static {

    public static void main(String[] args) throws InterruptedException {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open the Test Automation Practice website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate Country dropdown element
        WebElement countryDrpDwnEle = driver.findElement(By.xpath("//select[@id='country']"));

        // Create Select object to interact with dropdown
        Select countryDrpDwn = new Select(countryDrpDwnEle);

        // Select option using visible text
        countryDrpDwn.selectByVisibleText("France");
        Thread.sleep(1000);

        // Select option using value attribute
        countryDrpDwn.selectByValue("japan");
        Thread.sleep(1000);

        // Select option using index
        countryDrpDwn.selectByIndex(9);
        Thread.sleep(1000);

        // Retrieve all available options from dropdown
        List<WebElement> options =  countryDrpDwn.getOptions();

        // Print total number of options
        System.out.println("Total options in the dropdown: " + options.size());

        // Print all dropdown options
        System.out.println("Options in the dropdown:");

        for (WebElement option : options) {
            // Print option text
            System.out.println("- " + option.getText());
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
