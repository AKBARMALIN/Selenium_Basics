package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
/**
 * Demonstrates basic usage of different WebElement locator strategies in Selenium.
 * This simple standalone main method:
 *  - starts an Edge browser,
 *  - navigates to a practice page,
 *  - demonstrates sendKeys, isDisplayed, findElements for various tags,
 *  - clicks links using partial and full link text,
 *  - then quits the browser.
 *
 * Note: This is a demo program — for real test suites, use setup/teardown, waits, and proper exception handling.
 */
public class _02_Locators {

    public static void main(String[] args) {

        // Create a new instance of EdgeDriver. This opens a new Microsoft Edge browser window.
        // Precondition: the matching Edge WebDriver executable must be available on the PATH,
        // or managed by a driver manager library (e.g., WebDriverManager).
        WebDriver driver = new EdgeDriver();

        // Navigate to the practice page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate an input element by its 'name' attribute and type text into it.
        // By.name("enter-name") returns the first matching element.
        WebElement textBox = driver.findElement(By.name("enter-name"));
        textBox.sendKeys("Selenium");

        // Locate an element by its id attribute and send text to it.
        // sendKeys simulates typing into an element (commonly used for <input> and <textarea>).
        driver.findElement(By.id("displayed-text")).sendKeys("Hello Selenium");

        // Locate an element by its class name and check if it is displayed on the page.
        // isDisplayed() returns true when the element is present and visible.
        boolean status = driver.findElement(By.className("logoClass")).isDisplayed();
        if (status) {
            System.out.println("Logo is displayed");
        } else {
            System.out.println("Logo is not displayed");
        }

        // findElements returns a List of WebElements (zero or more). We can iterate over them.
        // Here we find all elements with class "btn-primary" (probably buttons).
        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));

        // Print the visible text for each found button.
        // getText() returns the visible (rendered) text of the element.
        for(WebElement button : buttons) {
            System.out.println(button.getText());
        }

        // Find all anchor (<a>) elements on the page and print the total count.
        // Useful for checking link coverage on a page.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        // Find all image (<img>) elements and print the total count.
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images: " + images.size());

        // Click a link by partial link text. This matches anchors where the visible text contains "REST API".
        // Useful when the full link text is long or partially dynamic.
        driver.findElement(By.partialLinkText("REST API")).click();

        // Click a link by full link text. Text must match exactly the anchor's visible text.
        driver.findElement(By.linkText("Chapter 1. Introduction")).click();

        // Close the browser and end the WebDriver session.
        driver.quit();
    }
}
