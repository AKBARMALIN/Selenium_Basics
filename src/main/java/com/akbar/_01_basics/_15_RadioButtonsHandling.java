package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class _15_RadioButtonsHandling {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("Total radio buttons: " + radioBtns.size());

        WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));

        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());

        male_rd.click();

        System.out.println("Is male radio button selected? " + male_rd.isSelected());
        System.out.println("Is female radio button selected? " + female_rd.isSelected());

        driver.quit();
    }
}
