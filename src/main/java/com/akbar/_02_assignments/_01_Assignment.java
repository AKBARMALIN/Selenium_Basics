package com.akbar._02_assignments;

/*
    1. Launch the browser and open the URL https://testautomationpractice.blogspot.com/
    2. Provide some string search for it
    3. Count number of links
    4. Click on each link using for loop
    5. Get windowIds for every browser window
    6. close specific browser window based on title
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Set;

public class _01_Assignment {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id, 'wikipedia-search-input')]"));
        searchBox.sendKeys("Selenium");

        WebElement searchBtn = driver.findElement(By.xpath("//input[contains(@class, 'wikipedia-search-button')]"));
        searchBtn.click();

        List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
        System.out.println("Number of links: " + links.size());

        for(WebElement link : links) {
            link.click();
        }

        Set<String> windowIds = driver.getWindowHandles();
        for(String windowId : windowIds) {
            String title = driver.switchTo().window(windowId).getTitle();
            if(title.equalsIgnoreCase("Selenium disulfide - Wikipedia") || title.equalsIgnoreCase("Selenium in biology - Wikipedia")) {
                driver.close();
            }
        }
    }
}
