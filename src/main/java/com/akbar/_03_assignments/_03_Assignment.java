package com.akbar._03_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Assignment Program:
 * Demonstrates an end-to-end Flight Booking automation using Selenium WebDriver.
 *
 * Scenario:
 * 1. Launch BlazeDemo website.
 * 2. Select departure and destination cities.
 * 3. Search available flights.
 * 4. Identify and select a flight with the expected lowest price.
 * 5. Fill passenger and payment details.
 * 6. Complete the purchase process.
 * 7. Verify booking confirmation message.
 *
 * Concepts Covered:
 * - Dropdown handling using Select class
 * - Web table handling
 * - Dynamic XPath creation
 * - Data extraction and type conversion
 * - Form handling
 * - Conditional validation
 */
public class _03_Assignment {

    public static void main(String[] args) {

        // Create Edge browser instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Apply implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Open BlazeDemo application
        driver.get("https://blazedemo.com/");

        // Locate source city dropdown
        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));

        // Locate destination city dropdown
        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));

        // Locate "Find Flights" button
        WebElement findFlightsBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        // Create Select objects for dropdown handling
        Select fromPortDrpDwn = new Select(fromPort);
        Select toPortDrpDwn = new Select(toPort);

        // Select departure and destination cities
        fromPortDrpDwn.selectByVisibleText("Mexico City");
        toPortDrpDwn.selectByVisibleText("New York");

        // Click Find Flights button
        findFlightsBtn.click();

        // Capture all flight rows from result table
        List<WebElement> options = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));

        // Print total number of flights available
        System.out.println("Total flights available: " + options.size());

        // Expected lowest price value
        double lowestPrice = 200.98;

        // Iterate through table rows to find matching price
        for(int r = 2; r <= options.size(); r++) {
            // Capture price from current row
            WebElement priceAmountEle = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[6]"));
            // Remove "$" symbol from price text
            String priceAmount = priceAmountEle.getText().replace("$", "");
            // Convert String price into double
            double price = Double.parseDouble(priceAmount);
            // Compare with expected lowest price
            if(price == lowestPrice) {
                // Locate corresponding "Choose This Flight" button
                WebElement chooseThisFlightBtn = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[1]/input"));
                // Click button to select flight
                chooseThisFlightBtn.click();
                // Exit loop after selection
                break;
            }
        }

        // Locate booking form elements
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='inputName']"));
        WebElement addressInput = driver.findElement(By.xpath("//input[@id='address']"));
        WebElement cityInput = driver.findElement(By.xpath("//input[@id='city']"));
        WebElement stateInput = driver.findElement(By.xpath("//input[@id='state']"));
        WebElement zipCodeInput = driver.findElement(By.xpath("//input[@id='zipCode']"));
        WebElement cardTypeDrpDwnEle = driver.findElement(By.xpath("//select[@id='cardType']"));
        WebElement creditCardNumberInput = driver.findElement(By.xpath("//input[@id='creditCardNumber']"));
        WebElement creditCardMonthInput = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
        WebElement creditCardYearInput = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
        WebElement nameOnCardInput = driver.findElement(By.xpath("//input[@id='nameOnCard']"));
        WebElement purchaseFlightBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        // Enter passenger details
        nameInput.sendKeys("John Doe");
        addressInput.sendKeys("123 Main St");
        cityInput.sendKeys("New York");
        stateInput.sendKeys("NY");
        zipCodeInput.sendKeys("10001");

        // Select card type from dropdown
        Select cardTypeDrpDwn = new Select(cardTypeDrpDwnEle);
        cardTypeDrpDwn.selectByVisibleText("Visa");

        // Enter payment details
        creditCardNumberInput.sendKeys("4111111111111111");

        // Clear default month value and enter new value
        creditCardMonthInput.clear();
        creditCardMonthInput.sendKeys("12");

        // Clear default year value and enter new value
        creditCardYearInput.clear();
        creditCardYearInput.sendKeys("2026");

        // Enter card holder name
        nameOnCardInput.sendKeys("John Doe");

        // Click Purchase Flight button
        purchaseFlightBtn.click();

        // Locate confirmation message element
        WebElement confirmMsg = driver.findElement(By.xpath("//h1"));

        // Capture confirmation message text
        String message = confirmMsg.getText();

        // Validate booking confirmation
        if(message.contains("Thank you for your purchase today!")) {
            System.out.println("Test Passed: Flight booking confirmed.");
        } else {
            System.out.println("Test Failed: Flight booking not confirmed.");
        }

        // Close browser and terminate WebDriver session
        driver.quit();
    }
}
