package com.akbar._01_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Demonstrates Implicit Wait mechanism in Selenium WebDriver.
 * @author Akbar
 * @version 1.0
 */
public class _11_WaitMethods_ImplicitlyWait {

    public static void main(String[] args) {

        // Initialize the WebDriver instance with EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Maximize the browser window to ensure optimal visibility
        driver.manage().window().maximize();

        // Set Implicit Wait: Global timeout of 5 seconds for all element searches
        // If an element is not found immediately, WebDriver will keep searching
        // for up to 5 seconds before throwing NoSuchElementException
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        // Navigate to the Orange HRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate the username input field and send keys
        // The implicit wait applies here - if element not found immediately,
        // WebDriver will retry for up to 5 seconds
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // Close the browser and terminate the WebDriver session
        driver.quit();
    }
}

/*
═══════════════════════════════════════════════════════════════════════════════
                     IMPLICIT WAIT - DETAILED EXPLANATION
═══════════════════════════════════════════════════════════════════════════════

METHOD SIGNATURE:
    driver.manage().timeouts().implicitlyWait(Duration duration)

PARAMETERS:
    - duration: The maximum time to wait (e.g., Duration.ofSeconds(10))

RETURN TYPE:
    TimeoutException or NoSuchElementException after timeout expires
═══════════════════════════════════════════════════════════════════════════════
                              HOW IT WORKS
═══════════════════════════════════════════════════════════════════════════════

1. GLOBAL CONFIGURATION
   - Implicit wait is set once and applies to ALL element lookups
   - No need to specify wait for each element search

2. POLLING MECHANISM
   - WebDriver continuously checks the DOM for the element
   - Polling interval: Usually 500ms (checks the DOM twice per second)
   - Once element is found: Immediately proceeds (doesn't wait full timeout)
   - After timeout: Throws NoSuchElementException

3. TIMING
   Example: implicitlyWait(Duration.ofSeconds(5))
   ├── 0ms    → Element lookup starts
   ├── 500ms  → First check (element not found, continue polling)
   ├── 1000ms → Second check (element not found, continue polling)
   ├── 1500ms → Third check (ELEMENT FOUND! → Proceed immediately)
   └── ✓ Completed in 1.5 seconds, not full 5 seconds
═══════════════════════════════════════════════════════════════════════════════
                           ADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. EASY TO USE
   - Simple one-line configuration
   - No complex syntax or additional imports needed
   - Works for all element lookups automatically

2. GLOBAL CONFIGURATION
   - Set once at the beginning of the script
   - Applies to all findElement() calls
   - Reduces code repetition

3. BETTER THAN THREAD.SLEEP()
   - Automatically proceeds if element is found before timeout
   - Reduces unnecessary waiting time
   - More reliable than fixed sleep durations

4. LIGHTWEIGHT
   - Minimal performance overhead
   - Simple to understand and debug
═══════════════════════════════════════════════════════════════════════════════
                          DISADVANTAGES
═══════════════════════════════════════════════════════════════════════════════

1. CANNOT WAIT FOR SPECIFIC CONDITIONS
   Problem: Only waits for element presence, not visibility or clickability
   Example: Cannot wait for an element to become clickable before interacting
   Impact: Element might be present but not visible or enabled

2. APPLIES TO ALL ELEMENTS
   Problem: Same timeout for fast-loading and slow-loading elements
   Example: 5-second wait applies even if element loads in 1 second
   Impact: Cannot have different wait times for different scenarios

3. SLOWER OVERALL EXECUTION
   Problem: Accumulates delays across multiple element searches
   Example: 10 element searches × 5 second timeout = potential 50 second delay
   Impact: Test suite execution time increases significantly

4. NOT CONDITION-BASED
   Problem: Only waits for element presence, not specific conditions
   Example: Cannot wait for an element to contain specific text
   Impact: Limited flexibility for complex synchronization scenarios

5. GLOBAL SCOPE ISSUES
   Problem: If one element needs longer wait, entire suite uses that timeout
   Example: Setting 10 seconds for one slow element affects all elements
   Impact: Over-waiting on fast elements, under-waiting on slow elements
═══════════════════════════════════════════════════════════════════════════════
                    IMPLICIT WAIT VS EXPLICIT WAIT
═══════════════════════════════════════════════════════════════════════════════

IMPLICIT WAIT                  │  EXPLICIT WAIT
───────────────────────────────┼──────────────────────────────
Global (all elements)          │  Specific to target element
Cannot specify conditions      │  Can specify conditions (visible, clickable)
Applies to all findElement()   │  Only when explicitly used
Simpler configuration          │  Requires more code
Less flexible                  │  More flexible and powerful
Best for: Basic projects       │  Best for: Production automation
═══════════════════════════════════════════════════════════════════════════════
*/
