package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _10_WaitMethods_ThreadSleep {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Using Thread.sleep() to introduce a delay of 5 seconds
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        driver.quit();
    }
}

/*
Thread.sleep() is a static method in Java that causes the current thread to pause execution for a specified duration. It is commonly used in Selenium WebDriver to introduce a delay in the execution of test scripts.
The method takes a single argument, which is the number of milliseconds to sleep.

Advantages of Thread.sleep():
1. Simple to use: It is straightforward and easy to understand.

Disadvantages of Thread.sleep():
1. Not dynamic: It does not account for the actual time it takes for an element to become available.
   If the element appears before the specified time, it still waits for the entire duration, which can lead to unnecessarily long test execution times.
2. Not reliable: If the element takes longer than the specified time to appear, it can lead to test failures due to NoSuchElementException or other exceptions.
3. Not recommended: It is generally not recommended to use Thread.sleep() in Selenium tests because it can lead to flaky tests and inefficient test execution.
   Instead, it is better to use explicit waits (WebDriverWait) or implicit waits, which are more dynamic and reliable for handling synchronization issues in Selenium WebDriver.
 */
