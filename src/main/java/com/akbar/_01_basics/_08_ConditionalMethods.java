package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _08_ConditionalMethods {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/register");

        // Conditional methods return boolean values based on the state of the element or page. Common conditional methods include:
        //1. isDisplayed() - returns true if the element is visible on the page, false otherwise.
        WebElement headerLogo = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        System.out.println("Is header logo displayed? " + headerLogo.isDisplayed());

        //2. isEnabled() - returns true if the element is enabled (interactable), false if it is disabled (grayed out or not interactable).
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        System.out.println("Is first name field enabled? " + firstName.isEnabled());

        //3. isSelected() - returns true if the element (like a checkbox or radio button) is selected, false otherwise.
        WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());
        male_rd.click();
        System.out.println("After clicking male radio button: " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());

        driver.quit();
    }
}
