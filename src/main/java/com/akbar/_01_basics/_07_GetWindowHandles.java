package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _07_GetWindowHandles {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windowIds = driver.getWindowHandles();

        //Approach 1:
        List<String> windowIdList = new ArrayList<>(windowIds);
        String parentWindowId = windowIdList.get(0);
        String childWindowId = windowIdList.get(1);
        System.out.println("Parent window ID: " + parentWindowId);
        System.out.println("Child window ID: " + childWindowId);

        driver.switchTo().window(childWindowId);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentWindowId);
        System.out.println(driver.getTitle());

        //Approach 2:
        for(String windowId : windowIds) {
            String title = driver.switchTo().window(windowId).getTitle();
            System.out.println("Title: " + title);
            if(title.equalsIgnoreCase("OrangeHRM")) {
                driver.close();
                // Why not  break here? Because we want to close all windows with title "OrangeHRM" if there are multiple.
                // If we break, we will only close the first one we encounter and leave others open.
            }
        }
    }
}
