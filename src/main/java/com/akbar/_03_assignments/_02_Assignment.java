package com.akbar._02_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class _02_Assignment {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        driver.get("https://practice.expandtesting.com/radio-buttons");

        List<WebElement> radioList = driver.findElements(By.xpath("//input[@type='radio' and @name='color']"));
        System.out.println("Total radio buttons: " + radioList.size());

        for(WebElement radio : radioList) {
            if(radio.getAttribute("value").equalsIgnoreCase("red")) {
                radio.click();
                System.out.println("Red radio button is selected: " + radio.isSelected());
            }
        }

        driver.navigate().to("https://practice.expandtesting.com/checkboxes");

        List<WebElement> chkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Total checkboxes: " + chkboxList.size());

        for(WebElement chkbox : chkboxList) {
            if(!chkbox.isSelected()) {
                chkbox.click();
            }
        }
    }
}
