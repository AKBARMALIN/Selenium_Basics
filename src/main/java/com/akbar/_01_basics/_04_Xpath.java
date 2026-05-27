package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class _04_Xpath {

    public static void main(String[] args) {

        // Instantiate the Edge WebDriver. This will open a new Edge browser window.
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window to avoid viewport-related issues with element visibility.
        driver.manage().window().maximize();

        // Navigate to the demo nopCommerce site
        driver.get("https://demo.nopcommerce.com/");

        // EXAMPLE 1: Locate element by a single attribute (id).
        // XPath: //input[@id='small-searchterms']
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchBox.sendKeys("Mobiles");
        // Clear the input to reuse the same variable for additional examples
        searchBox.clear();

        // EXAMPLE 2: Locate using two attribute predicates (equivalent to AND).
        // XPath: //input[@id='small-searchterms'][@name='q']
        // Note: Two predicate filters placed one after another are combined with AND.
        searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms'][@name='q']"));
        searchBox.sendKeys("Laptops");
        searchBox.clear();

        // EXAMPLE 3: Using explicit 'and' in XPath to combine attributes.
        // XPath: //input[@id='small-searchterms' and @placeholder='Search store']
        searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']"));
        searchBox.sendKeys("Tablets");
        searchBox.clear();

        // EXAMPLE 4: Using 'or' operator in XPath.
        // XPath: //input[@id='small-searchterms' or @placeholder='Search store']
        // This would match if EITHER attribute is true.
        searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='Search store']"));
        searchBox.sendKeys("cameras");
        searchBox.clear();

        // EXAMPLE 5: starts-with() function lets you match partial attribute values.
        // XPath: //input[starts-with(@id, 'small')]
        // Useful for dynamic ids with predictable prefixes.
        searchBox = driver.findElement(By.xpath("//input[starts-with(@id, 'small')]"));
        searchBox.sendKeys("Headphones");
        searchBox.clear();

        // EXAMPLE 6: Locate a link by its visible text and check displayed status
        // XPath: //a[text()='Computers']
        boolean tab_1 = driver.findElement(By.xpath("//a[text()='Computers']")).isDisplayed();
        System.out.println("Tab 1 is displayed: " + tab_1);

        // EXAMPLE 7: Grab visible text from an element that matches exact visible text
        // XPath: //h2[text()='Featured products']
        String text = driver.findElement(By.xpath("//h2[text()='Featured products']")).getText();
        System.out.println("Text: " + text);

        // EXAMPLE 8: contains() function on an attribute (useful for partial matches)
        // XPath: //input[contains(@id, 'all-search')]
        searchBox = driver.findElement(By.xpath("//input[contains(@id, 'all-search')]"));
        searchBox.sendKeys("Accessories");
        searchBox.clear();

        // EXAMPLE 9: Using child navigation with '/' - find the site header logo image
        // XPath: //div[@class='header-logo']/a/img
        WebElement headerLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        boolean logoStatus = headerLogo.isDisplayed();
        System.out.println("Header logo is displayed: " + logoStatus);

        // Close all browser windows and safely end the WebDriver session.
        driver.quit();
    }
}
