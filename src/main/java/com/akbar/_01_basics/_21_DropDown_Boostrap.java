package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates handling of a Bootstrap Multi-Select Dropdown
 * using Selenium WebDriver.
 */
public class _21_DropDown_Boostrap {

    public static void main(String[] args) throws InterruptedException {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open Bootstrap Multiselect demo website
        driver.get("https://davidstutz.github.io/bootstrap-multiselect/");

        // Locate Bootstrap dropdown button
        WebElement multiSelectDrpDwnEle = driver.findElement(By.xpath("//select[@id='example-getting-started']/following-sibling::div/button"));

        // Create JavaScriptExecutor reference
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll dropdown into visible area of webpage
        js.executeScript("arguments[0].scrollIntoView(true);", multiSelectDrpDwnEle);

        // Pause for visibility
        Thread.sleep(1000);

        // Open Bootstrap dropdown
        multiSelectDrpDwnEle.click();

       // Select single option
        // driver.findElement(By.xpath("//input[@value='tomatoes']")).click();
        Thread.sleep(1000);

        // Capture all dropdown options
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='example-getting-started']/following-sibling::div/button/following-sibling::div/button/span/label"));

        // Print total number of dropdown options
        System.out.println("Total options in the dropdown: " + options.size());

        for(WebElement option : options) {
            System.out.println("- " + option.getText());
        }

        // Select multiple required options
        for(WebElement op : options) {
            // Capture current option text
            String option = op.getText();

            // Select desired options
            if(option.equalsIgnoreCase("Cheese") || option.equalsIgnoreCase("tomatoes") || option.equalsIgnoreCase("onions")) {
                // Click option
                op.click();
                // Small pause between selections
                Thread.sleep(500);
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
