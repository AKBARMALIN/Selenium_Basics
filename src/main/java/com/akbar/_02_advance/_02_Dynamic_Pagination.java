package com.akbar._02_advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Demonstrates handling of Dynamic Pagination in a Web Table using Selenium WebDriver.
 */
public class _02_Dynamic_Pagination {

    public static void main(String[] args) throws InterruptedException {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        // Open OpenCart Admin application
        driver.get("https://demo.opencart.com/admin/index.php");

        // Locate username field
        WebElement usernameEle = driver.findElement(By.id("input-username"));

        // Clear existing value and enter username
        usernameEle.clear();
        usernameEle.sendKeys("demo");

        WebElement passwordEle = driver.findElement(By.id("input-password"));

        // Clear existing value and enter password
        passwordEle.clear();
        passwordEle.sendKeys("demo");

        // Click Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Close dashboard popup if displayed
        if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        }

        // Navigate to Customers menu
        driver.findElement(By.xpath("//a[@class, 'parent collapsed'][normalize-space()='Customers']")).click();

        // Click Customers submenu
        driver.findElement(By.xpath("//a[normalize-space()='Customers']")).click();

        // Capture pagination text
        String totalPagesText =   driver.findElement(By.xpath("//div[contains(@text, 'Showing')]")).getText();

        /*
         * Example pagination text:
         *
         * Showing 1 to 20 of 569 (29 Pages)
         *
         * Extract:
         * 29
         */
        int total_pages = Integer.parseInt(totalPagesText.substring(totalPagesText.indexOf("("), totalPagesText.indexOf("Pages") - 1));

        // Iterate through all pages
        for(int page = 1; page <= total_pages; page++) {
            System.out.println("Page: " + page);

            // Navigate to the desired page
            if(page > 1) {
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='" + page + "']"));
                active_page.click();

                // Wait for table refresh
                Thread.sleep(3000);
            }

            // Capture total rows in current page
            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();

            // Iterate through each row
            for(int row = 1; row <= rows; row++) {
                // Capture Customer Name
                String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + row + "]/td[2]")).getText();

                // Capture Customer Email
                String customerEmail = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + row + "]/td[3]")).getText();

                // Capture Customer Status
                String customerStatus = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + row + "]/td[5]")).getText();

                // Print customer details
                System.out.println(customerName + " - " + customerEmail + " - " + customerStatus);
            }
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
