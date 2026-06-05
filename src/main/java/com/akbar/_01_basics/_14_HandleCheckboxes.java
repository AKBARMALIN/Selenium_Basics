package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

/**
 * Demonstrates various techniques for handling Checkboxes using Selenium WebDriver.
 */
public class _14_HandleCheckboxes {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open Test Automation Practice website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate Sunday checkbox
        WebElement sundayChkbox = driver.findElement(By.xpath("//input[@id='sunday']"));

        // Select only if not already selected
        if(!sundayChkbox.isSelected()) {
            sundayChkbox.click();
        }

        // ==================================================
        // Capture All Checkboxes
        // ==================================================
        List<WebElement> chkboxList = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        // Print total number of checkboxes
        System.out.println("Total checkboxes: " + chkboxList.size());

        // ==================================================
        // Select All Checkboxes
        // ==================================================
        for(WebElement chkbox : chkboxList) {
            if(!chkbox.isSelected()) {
                chkbox.click();
            }
        }

        // ==================================================
        // Unselect All Checkboxes
        // ==================================================
        for(int i = 0; i < chkboxList.size(); i++) {
            if(chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        // ==================================================
        // Select Last Three Checkboxes
        // Formula:
        // Starting Index = Total Checkboxes - 3
        // ==================================================
        for(int i = 4; i < chkboxList.size(); i++) {
            if(!chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        // ==================================================
        // Select First Three Checkboxes
        // ==================================================
        // Select first three checkboxes: Starting index = 0, Ending index = 3 (exclusive)
        for(int i = 0; i < 3; i++) {
            if(!chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        // ==================================================
        // Select Specific Checkboxes by Index
        // Indexes:
        // 1 = Monday
        // 3 = Wednesday
        // 6 = Saturday
        // ==================================================
        for(int i = 0; i < chkboxList.size(); i++) {
            if(i == 1 || i == 3 || i == 6) {
                if(!chkboxList.get(i).isSelected()) {
                    chkboxList.get(i).click();
                }
            }
        }

        // ==================================================
        // Dynamic Checkbox Selection Using Switch Statement
        // ==================================================

        String weekDay = "Monday";
        switch(weekDay) {
            case "Sunday" : driver.findElement(By.xpath("//input[@id='sunday']")).click();
                            break;
            case "Monday" : driver.findElement(By.xpath("//input[@id='monday']")).click();
                            break;
            case "Tuesday" : driver.findElement(By.xpath("//input[@id='tuesday']")).click();
                             break;
            case "Wednesday" : driver.findElement(By.xpath("//input[@id='wednesday']")).click();
                               break;
            case "Thursday" : driver.findElement(By.xpath("//input[@id='thursday']")).click();
                              break;
            case "Friday" : driver.findElement(By.xpath("//input[@id='friday']")).click();
                            break;
            case "Saturday" : driver.findElement(By.xpath("//input[@id='saturday']")).click();
                              break;
            default : System.out.println("Invalid week day: " + weekDay);
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}