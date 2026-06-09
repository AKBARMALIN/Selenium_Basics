package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Demonstrates the use of Thread.sleep() for synchronization in Selenium WebDriver.
 */
public class _10_WaitMethods_ThreadSleep {

    public static void main(String[] args) {

        // Initialize the WebDriver instance with EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window to ensure all elements are visible
        driver.manage().window().maximize();

        // Navigate to the Orange HRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Using Thread.sleep() to introduce a delay of 5 seconds
        // This pauses all script execution, even if the element is available sooner
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Handle the InterruptedException if the thread is interrupted during sleep
            e.printStackTrace();
        }

        // Locate the username input field and send the username "Admin"
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // Close the browser and terminate the WebDriver session
        driver.quit();
    }
}

/*
═══════════════════════════════════════════════════════════════════════════════
                    THREAD.SLEEP() - DETAILED EXPLANATION
═══════════════════════════════════════════════════════════════════════════════

METHOD SIGNATURE:
    public static void sleep(long millis) throws InterruptedException

PARAMETERS:
    - millis: The number of milliseconds to sleep (1000 ms = 1 second)

RETURN TYPE:
    void (returns nothing)

THROWS:
    InterruptedException: If the thread is interrupted while sleeping

═══════════════════════════════════════════════════════════════════════════════
                              HOW IT WORKS
═══════════════════════════════════════════════════════════════════════════════

When Thread.sleep(5000) is called:
    1. The current thread (main thread) is paused for exactly 5000 milliseconds
    2. No other operations are performed during this time
    3. After 5 seconds elapse, execution resumes from the next line of code
    4. The browser waits, the page waits - everything is static during sleep

═══════════════════════════════════════════════════════════════════════════════
                           ADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. SIMPLE TO USE
   - Straightforward syntax: just Thread.sleep(milliseconds)
   - No complex configuration needed
   - Easy for beginners to understand

2. QUICK PROTOTYPING
   - Useful for quick debugging and testing scenarios
   - Can verify basic functionality without wait complexity

═══════════════════════════════════════════════════════════════════════════════
                          DISADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. NOT DYNAMIC / INFLEXIBLE
   Problem: If an element appears in 2 seconds, the script still waits the full 5 seconds
   Impact: Unnecessarily long test execution times
   Example: Every test waits 5 seconds regardless of actual element loading time

2. NOT RELIABLE / BRITTLE
   Problem: If an element takes 6 seconds to appear and you set sleep(5000), test fails
   Impact: Tests are prone to failures if page load times vary
   Symptom: NoSuchElementException or StaleElementReferenceException

3. FLAKY TESTS
   Problem: Network delays or slow servers can cause inconsistent behavior
   Impact: Same test passes sometimes and fails other times
   Result: Tests are unreliable and hard to maintain

4. INEFFICIENT
   Problem: Fixed delays waste time in automation execution
   Impact: Test suites take much longer to run
   Consequence: Slower CI/CD pipelines and reduced productivity

5. NOT SUITABLE FOR PRODUCTION
   Problem: Production environments have varying load and performance
   Impact: Same sleep duration won't work across all environments

═══════════════════════════════════════════════════════════════════════════════
                    THREAD.SLEEP() VS WAITS IN SELENIUM
═══════════════════════════════════════════════════════════════════════════════

THREAD.SLEEP()              │  IMPLICIT WAIT              │  EXPLICIT WAIT
────────────────────────────┼──────────────────────────────┼──────────────────
Fixed delay                 │  Global polling             │  Condition-based
No condition checking       │  Applies to all elements    │  Specific to element
Wastes time                 │  Can miss elements          │  Most flexible
Hard to maintain            │  Simple to implement        │  Requires conditions
Not recommended             │  Better than sleep          │  RECOMMENDED ✓

═══════════════════════════════════════════════════════════════════════════════
                             BEST PRACTICES
═══════════════════════════════════════════════════════════════════════════════

❌ DO NOT use Thread.sleep() in production automation scripts
✓ DO use explicit waits with WebDriverWait for better reliability
✓ DO use implicit waits as a fallback mechanism
✓ DO use specific expected conditions to match your requirements
*/
