package com.akbar._01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class _09_NavigationMethods {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/"); // Accepts only String URL and opens the page in the current window.

        // driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Accepts only String URL and opens the page in the current window.
        URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to(url); // Accepts URL object and opens the page in the current window.

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();

        driver.quit();

    }
}

/*
Q: Differences between driver.get() and driver.navigate().to() methods in Selenium WebDriver?
A: The main differences between driver.get() and driver.navigate().to() methods in Selenium WebDriver are as follows:
i. Functionality:
   - driver.get(): This method is used to open a web page in the current browser window.
     It waits for the page to load completely before returning control to the test script.
   - driver.navigate().to(): This method is also used to open a web page, but it is part of the Navigation interface and can be used for
     more complex navigation scenarios, such as navigating back and forth between pages.

ii. Parameters:
   - driver.get(): Accepts only a String URL as a parameter.
   - driver.navigate().to(): Can accept both a String URL and a URL object as parameters.
iii. Use Cases:
   - driver.get(): Typically used for simple navigation to a web page at the beginning of a test case.
   - driver.navigate().to(): More suitable for scenarios where you need to navigate to multiple pages, or
     when you want to use additional navigation methods like back(), forward(), or refresh().
 */
