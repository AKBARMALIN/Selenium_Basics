package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _18_AuthenticateAlerts {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // syntax: https://username:password@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String expectedText = "Congratulations! You must have the proper credentials.";
        String actualText = driver.findElement(By.cssSelector("div.example p")).getText();

        if(actualText.equals(expectedText)) {
            System.out.println("Authentication successful. Text matches expected.");
        } else {
            System.out.println("Authentication failed or text does not match expected.");
        }

        driver.quit();
    }
}
