package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Set;

public class _06_GetMethods {

    public static void main(String[] args) {

        // Create EdgeDriver instance. Ensure the Edge driver binary is available or configured.
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Set a simple implicit wait. This affects findElement / findElements calls.
        // For more precise control prefer explicit WebDriverWait conditions.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. get(url) - opens the url on the browser
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //2. getTitle() - returns the title of the current page
        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        //3. getCurrentUrl() - returns the current URL of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        //4. getPageSource() - returns the HTML source code of the current page as a string
        // Be careful: page source can be very large; we print only the length here.
        String pageSource = driver.getPageSource();
        System.out.println("Page source length: " + pageSource.length());

        //5. getWindowHandle() - returns a unique identifier (handle) for the current browser window
        String windowId  = driver.getWindowHandle();
        System.out.println("Current window handle: " + windowId);

        //6. getWindowHandles() - returns a set of unique identifiers (handles) for all open browser windows/tabs
        // The demo site link "OrangeHRM, Inc" typically opens a new window or tab.
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // Opens a new window/tab

        // After clicking, retrieve all available window handles. Use these for switching windows:
        Set<String> windowIds = driver.getWindowHandles();
        System.out.println("All window handles: " + windowIds);

        // Close all browser windows and terminate WebDriver session
        driver.quit();
    }
}