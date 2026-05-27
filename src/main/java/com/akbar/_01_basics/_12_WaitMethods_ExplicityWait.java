package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _12_WaitMethods_ExplicityWait {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        // Explicit wait declaration with a timeout of 5 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Usage of explicit wait to wait until the username field is visible on the page
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        usernameField.sendKeys("Admin");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        passwordField.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();

        driver.quit();
    }
}

/*
Explicit Wait:
    Explicit wait is a more flexible and powerful wait mechanism in Selenium WebDriver that allows you to wait for specific conditions to occur
    before proceeding with the next step in your test script.
    It is implemented using the WebDriverWait class in combination with ExpectedConditions.

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

    Advantages:
        More control: Allows you to wait for specific conditions, such as visibility, clickability, or presence of an element.
        More reliable: Can help avoid issues with elements that take varying amounts of time to load or become interactable.
    Disadvantages:
        More complex: Requires additional code to set up and use compared to implicit waits.

    Conditions:
    i. visibilityOfElementLocated(By locator): Waits until the specified element is visible on the page.
    ii. elementToBeClickable(By locator): Waits until the specified element is clickable (visible and enabled).
    iii. presenceOfElementLocated(By locator): Waits until the specified element is present in the DOM, regardless of its visibility.
    iv. textToBePresentInElementLocated(By locator, String text): Waits until the specified text is present in the element located by the given locator.
    v. alertIsPresent(): Waits until an alert is present on the page.
    vi. titleContains(String title): Waits until the page title contains the specified string.
    vii. urlContains(String url): Waits until the current URL contains the specified string.
    viii. frameToBeAvailableAndSwitchToIt(By locator): Waits until the specified frame is available and switches to it.
    ix. invisibilityOfElementLocated(By locator): Waits until the specified element is no longer visible on the page.

 */
