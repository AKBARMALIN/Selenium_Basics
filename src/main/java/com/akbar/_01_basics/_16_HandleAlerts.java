package com.akbar._01_basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class _16_HandleAlerts {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String alertText = "Selenium Alert";

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmBtn.click();
        alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.dismiss();

        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPromptBtn.click();
        alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.sendKeys(alertText);
        alert.accept();

        String actAlertText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        if(actAlertText.contains(alertText)) {
            System.out.println("Alert text is correctly displayed in the result.");
        } else {
            System.out.println("Alert text is NOT correctly displayed in the result.");
        }

        driver.quit();
    }
}
