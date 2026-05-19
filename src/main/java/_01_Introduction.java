/*
    1. Launch the browser and open the URL https://www.google.com/
    2. Verify the title of the page is "Google"
    3. Close the browser
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_Introduction {

    public static void main(String[] args) {

        // Step 1: Launch the browser and open the URL https://www.google.com/
        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver(); // For Firefox
        // WebDriver driver = new EdgeDriver(); // For Edge

        driver.get("https://www.google.com/");

        // Step 2: Verify the title of the page is "Google"
        String expectedTitle = "Google";

        // Retrieve the actual title from the opened page
        String actualTitle = driver.getTitle();

        // Compare expected vs actual and print the result.
        // equals() is used for exact match. If you want case-insensitive comparison, use equalsIgnoreCase().
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed!");
        } else {
            System.out.println("Title verification failed! Expected: " + expectedTitle + ", but got: " + actualTitle);
        }

        // Step 3: Close the browser
        // quit() closes all browser windows and safely ends the session.
        driver.quit();
    }
}
