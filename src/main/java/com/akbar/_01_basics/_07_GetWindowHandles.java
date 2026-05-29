package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates how to handle multiple windows/tabs in Selenium WebDriver.
 * It shows two approaches to work with window handles:
 * 1. Using ArrayList to access specific windows by index
 * 2. Using enhanced for-loop to iterate through all windows
 *
 * Window handles are unique identifiers for each open window/tab in the browser.
 * This is useful when a web page opens new windows or tabs (e.g., clicking links that open in new tabs).
 */

public class _07_GetWindowHandles {

    public static void main(String[] args) {

        // Initialize the WebDriver with Edge browser
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Set implicit wait to 5 seconds - WebDriver will wait up to 5 seconds before throwing NoSuchElementException
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Navigate to the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Click on the "OrangeHRM, Inc" link which opens a new window/tab
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        // Get all window handles. A Set is used because window handles are unique identifiers.
        Set<String> windowIds = driver.getWindowHandles();

        // ===== APPROACH 1: Using ArrayList to access specific windows =====
        // Convert Set to ArrayList for index-based access
        List<String> windowIdList = new ArrayList<>(windowIds);

        // Get the parent window ID (first window that was opened)
        String parentWindowId = windowIdList.get(0);

        // Get the child window ID (second window that was opened)
        String childWindowId = windowIdList.get(1);

        System.out.println("Parent window ID: " + parentWindowId);
        System.out.println("Child window ID: " + childWindowId);

        // Switch to the child window using switchTo().window()
        driver.switchTo().window(childWindowId);
        System.out.println(driver.getTitle());

        // Switch back to the parent window
        driver.switchTo().window(parentWindowId);
        System.out.println(driver.getTitle());

        // ===== APPROACH 2: Using enhanced for-loop to iterate through all windows =====
        // This approach is useful when you want to perform operations on all windows
        for(String windowId : windowIds) {
            // Switch to each window and get its title
            String title = driver.switchTo().window(windowId).getTitle();
            System.out.println("Title: " + title);
            if(title.equalsIgnoreCase("OrangeHRM")) {
                driver.close();
                // Why not  break here?
                // Because we want to close all windows with title "OrangeHRM" if there are multiple.
                // If we break, we will only close the first one we encounter and leave others open.
            }
        }
    }
}
