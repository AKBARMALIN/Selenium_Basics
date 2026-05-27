package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _11_WaitMethods_ImplicitlyWait {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Set implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        driver.quit();
    }
}

/*
Implicit Wait:
 Implicit wait is a global wait that applies to all elements in the WebDriver instance.
 It tells the WebDriver to wait for a certain amount of time when trying to find an element if it is not immediately available.
 The WebDriver will keep trying to find the element until the specified time has elapsed or the element is found, whichever comes first.

 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

 Advantages:
      Easy to use
      Global configuration
 Disadvantages
      Cannot wait for specific conditions
      Slower execution sometimes
 */
