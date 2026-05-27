package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class _13_WaitMethods_FluentWait {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        usernameField.sendKeys("Admin");

        driver.quit();
    }
}

/*
FluentWait:
FluentWait is a more flexible and customizable wait mechanism in Selenium WebDriver that allows you to specify the maximum amount of time to wait for a condition,
the frequency with which to check the condition, and the types of exceptions to ignore while waiting.

Advantages:
1. Customizable: Allows you to specify the polling frequency and the exceptions to ignore, giving you more control over the waiting behavior.
2. More reliable: Can help avoid issues with elements that take varying amounts of time to load or become interactable, similar to explicit waits.
3. Can be used for complex waiting scenarios where you need to wait for multiple conditions or handle specific exceptions.

Disadvantages:
1. More complex: Requires additional code to set up and use compared to implicit waits and explicit waits.
2. Not as widely used: FluentWait is less commonly used than implicit and explicit waits,
   so there may be less documentation and community support available for it compared to the other wait types.
 */
