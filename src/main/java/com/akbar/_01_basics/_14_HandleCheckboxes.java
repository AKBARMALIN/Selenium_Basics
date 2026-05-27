package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class _14_HandleCheckboxes {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement sundayChkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
        if(!sundayChkbox.isSelected()) {
            sundayChkbox.click();
        }

        List<WebElement> chkboxList = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println("Total checkboxes: " + chkboxList.size());

        for(WebElement chkbox : chkboxList) {
            if(!chkbox.isSelected()) {
                chkbox.click();
            }
        }

        for(int i = 0; i < chkboxList.size(); i++) {
            if(chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        // Select last three checkboxes: Formula: Total checkboxes - 3 = Starting index of last three checkboxes
        for(int i = 4; i < chkboxList.size(); i++) {
            if(!chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        // Select first three checkboxes: Starting index = 0, Ending index = 3 (exclusive)
        for(int i = 0; i < 3; i++) {
            if(!chkboxList.get(i).isSelected()) {
                chkboxList.get(i).click();
            }
        }

        driver.quit();
    }
}