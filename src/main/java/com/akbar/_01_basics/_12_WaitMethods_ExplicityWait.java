package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Demonstrates Explicit Wait mechanism in Selenium WebDriver.
 * @author Akbar
 * @version 1.0
 */
public class _12_WaitMethods_ExplicityWait {

    public static void main(String[] args) {

        // Initialize the WebDriver instance with EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Create a WebDriverWait instance with explicit timeout of 5 seconds
        // This wait object is used for specific element waits throughout the script
        // Unlike implicit wait, this is NOT global - it applies only where explicitly used
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Maximize the browser window for optimal element visibility
        driver.manage().window().maximize();

        // Navigate to the Orange HRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        /*
         * USAGE OF EXPLICIT WAIT #1: Wait for Username Field Visibility
         *
         * wait.until() - Polls the WebDriver until the condition is met or timeout
         * ExpectedConditions.visibilityOfElementLocated() - Condition: Element is visible
         * By.xpath("//input[@name='username']") - Locator for the username input field
         *
         * This waits for:
         * - Element to be present in the DOM
         * - Element to be visible on the page (displayed, not hidden)
         * - Element to have dimensions and position
         */
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))
        );

        // Once condition is met, the element reference is returned and we send keys
        usernameField.sendKeys("Admin");

        /*
         * USAGE OF EXPLICIT WAIT #2: Wait for Password Field Visibility
         *
         * Same logic as above but for the password field
         * WebDriver will wait up to 5 seconds for this field to become visible
         */
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))
        );

        // Once password field is visible, enter the password
        passwordField.sendKeys("admin123");

        /*
         * USAGE OF EXPLICIT WAIT #3: Wait for Login Button to be Clickable
         *
         * ExpectedConditions.elementToBeClickable() - Condition: Element is clickable
         * A clickable element must be:
         * - Present in the DOM
         * - Visible on the page
         * - Enabled (not disabled)
         *
         * This is the MOST RELIABLE way to wait before interaction
         */
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
        );

        // Once login button is clickable, perform the click action
        loginBtn.click();

        // Close the browser and terminate the WebDriver session
        driver.quit();
    }
}

/*
═══════════════════════════════════════════════════════════════════════════════
                     EXPLICIT WAIT - DETAILED EXPLANATION
═══════════════════════════════════════════════════════════════════════════════

CORE CONCEPT:
    Explicit Wait allows you to wait for specific conditions before proceeding
    with test execution. It combines a timeout with a condition check.

METHOD SIGNATURE:
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    WebElement element = wait.until(ExpectedCondition condition);

COMPONENTS:
    1. WebDriverWait: Waits until a condition is met or timeout expires
    2. Duration: Maximum time to wait (e.g., Duration.ofSeconds(10))
    3. ExpectedConditions: Specific conditions to check (visibility, clickability, etc.)

═══════════════════════════════════════════════════════════════════════════════
                              HOW IT WORKS
═══════════════════════════════════════════════════════════════════════════════

POLLING LOOP (Default polling interval: 500ms):

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));

Timeline:
    0ms   → Condition check starts
    500ms → Check if element is visible? NO → Continue polling
    1000ms → Check if element is visible? NO → Continue polling
    1500ms → Check if element is visible? YES → Proceed immediately!
    Result: Returned after 1.5 seconds (not full 5 seconds)

═══════════════════════════════════════════════════════════════════════════════
                           ADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. CONDITION-SPECIFIC
   ✓ Wait for specific states: visible, clickable, text presence, etc.
   ✓ Different conditions for different elements
   ✓ Precise synchronization control

2. FLEXIBLE & POWERFUL
   ✓ Can wait for various conditions (10+ built-in conditions available)
   ✓ Can create custom conditions if needed
   ✓ Adapts to different test scenarios

3. EFFICIENT
   ✓ Proceeds immediately when condition is met (doesn't wait full timeout)
   ✓ Significantly reduces test execution time
   ✓ Faster than implicit wait or Thread.sleep()

4. RELIABLE
   ✓ Handles dynamic content loading
   ✓ Prevents premature element interaction
   ✓ Reduces flaky tests and random failures
   ✓ Handles varying page load times

5. PRODUCTION-GRADE
   ✓ Industry standard for test automation
   ✓ Recommended by Selenium team
   ✓ Used in enterprise automation frameworks
   ✓ Best for complex, dynamic web applications

6. ELEMENT-SPECIFIC
   ✓ Wait only for elements that need it
   ✓ Different timeouts for different elements if needed
   ✓ No global configuration affecting all elements

═══════════════════════════════════════════════════════════════════════════════
                          DISADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. MORE CODE
   - Requires WebDriverWait declaration
   - Requires ExpectedConditions imports
   - More verbose than implicit wait

2. SLIGHTLY MORE COMPLEX
   - Need to understand available conditions
   - Requires knowledge of WebDriver API
   - May seem overwhelming for beginners

(Note: These minor disadvantages are far outweighed by the benefits)

═══════════════════════════════════════════════════════════════════════════════
                    COMMON EXPECTED CONDITIONS
═══════════════════════════════════════════════════════════════════════════════

1. visibilityOfElementLocated(By locator)
   └─ Waits until element is present AND visible on the page
   └─ Element must have size and be displayed
   └─ USE FOR: Elements that need to be visible before interaction

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));

2. elementToBeClickable(By locator)
   └─ Waits until element is visible AND enabled
   └─ Most reliable before clicking
   └─ USE FOR: Buttons, links, and interactive elements

       wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));

3. presenceOfElementLocated(By locator)
   └─ Waits until element is present in DOM (may not be visible)
   └─ Fastest condition to satisfy
   └─ USE FOR: Elements that load but may be hidden

       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("element")));

4. textToBePresentInElementLocated(By locator, String text)
   └─ Waits until specific text appears in element
   └─ USE FOR: Dynamic content, messages, labels

       wait.until(ExpectedConditions.textToBePresentInElementLocated(
           By.id("message"), "Success"));

5. alertIsPresent()
   └─ Waits until a JavaScript alert appears
   └─ USE FOR: Handling alert popups

       wait.until(ExpectedConditions.alertIsPresent());

6. titleContains(String title)
   └─ Waits until page title contains specified string
   └─ USE FOR: Page navigation verification

       wait.until(ExpectedConditions.titleContains("Login Page"));

7. urlContains(String url)
   └─ Waits until current URL contains specified string
   └─ USE FOR: URL-based navigation checks

       wait.until(ExpectedConditions.urlContains("/dashboard"));

8. frameToBeAvailableAndSwitchToIt(By locator)
   └─ Waits until iframe is available and switches to it
   └─ USE FOR: iframe/frame content

       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame")));

9. invisibilityOfElementLocated(By locator)
   └─ Waits until element is no longer visible or not present
   └─ USE FOR: Loading indicators, modals closing

       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

10. stalenessOf(WebElement element)
    └─ Waits until element is stale (detached from DOM)
    └─ USE FOR: Page refreshes, DOM updates

        wait.until(ExpectedConditions.stalenessOf(element));

═══════════════════════════════════════════════════════════════════════════════
                    HANDLING TIMEOUT EXCEPTIONS
═══════════════════════════════════════════════════════════════════════════════

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

try {
    WebElement element = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("element")));
    element.click();
} catch (TimeoutException e) {
    // Element did not appear within 5 seconds
    System.out.println("Element not found within timeout period");
    e.printStackTrace();
} catch (NoSuchElementException e) {
    // Element is not in the DOM
    System.out.println("Element not present in DOM");
    e.printStackTrace();
}

═══════════════════════════════════════════════════════════════════════════════
                          SUMMARY
═══════════════════════════════════════════════════════════════════════════════

✓ Use Explicit Wait (WebDriverWait) for production test automation
✓ Choose appropriate ExpectedConditions for each scenario
✓ Explicit Wait is faster, more reliable, and more maintainable
✓ It's the industry-recommended best practice for Selenium automation

═══════════════════════════════════════════════════════════════════════════════
*/
