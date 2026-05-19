package project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Web {

    // Covered 294 - 332, 359-363, 622-626
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Enter some text into a textbox/input field on the webpage.
        @When("Enter {string} in {string} field")
        public void enter_string_in_input(String value, String fieldXpath) {
            wait_until_the_field_is_clickable(fieldXpath);
            driver.getDriver()
                    .findElement(By.xpath(Utils.getProperty(fieldXpath)))
                    .sendKeys(value);
        }

        // Fetch environment-specific data (or credentials) and enter it into a web input field.
        @When("Enter {string} in {string} fields")
        public void enter_string_in_input_all_env(String string, String string2) {
            String env = "";

            env = Utils.getProperty("env");
            String cred = "";

            if(string.contains("credVault")) {
                cred = retrieveCredVaultData(Utils.getProperty(env + "." + string));
            } else {
                cred = Utils.getProperty(env + "." + string);
            }

            wait_until_the_field_is_clickable(string2);
            driver.getDriver().findElement(By.xpath(Utils.getPropery(string2))).sendKeys(cred);
        }

        // Fetch a value from properties file and enter it into a web input field.
        @When("Enter {string} value in {string} field")
        public void enter_string_value_in_input(String string. String string2) {
            wait_until_the_field_is_clickable(string2);
            driver.getDriver().findElement(By.xpath(Utils.getProperty(string2))).sendKeys(Utils.getProperty(string));
        }

        // Enter login username and password into login page fields dynamically.
        @When("Enter {string} user login and {string} password")
        public void enter_user_login_and_password(String string, String string2) {
            waitUntilPageIsReady();
            String userId = (string.startsWith("$.")) ? Utils.getProperty(string) : string;
            String password = (string.startsWith("$.")) ? Utils.getProperty(string2) : string2;

            driver.getDriver().findElement(By.xpath("//input[@data-target='user-id']")).sendKeys(userid);
            driver.getDriver().findElement(By.xpath("//input[@data-target='password']")).sendKeys(password);
        }






        // Wait until a web element becomes visible and clickable before performing actions on it.
        @When("Wait until the filed {string} is clickable")
        public void wait_until_the_field_is_clickable(String string) {
            new WebDriverWait(driver.getDriver(), Duration.of(Constants.PAGE_LOAD_TIME_OUT, ChronoUnit.SECONDS)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utis.getProperty(string))));
            new WebDriverWait(driver.getDriver(), Duration.of(5, ChronoUnit.SECONDS)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utils.getProperty(string))));
        }

        //for pages that do not have jquery
        // Wait until the webpage is fully loaded and ready before performing Selenium actions.
        @Then("Wait until the page is ready")
        public void waitUntilPageIsReady() {
            new WebDriverWait(driver.getDriver(), Duratioon.ofSeconds(Constants.PAGE_LOAD_TIME_OUT, ChronoUnit.SECONDS)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("if (document.readyState == 'complete') { document.ts = new Date().getTime(); return 'complete';} else {return 'incomplete';}").toString().equals("complete"));
        }
    }




}
