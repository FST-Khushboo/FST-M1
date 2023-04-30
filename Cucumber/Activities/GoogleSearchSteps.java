package Step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps
{
    WebDriver driver;
    WebDriverWait wait;
    @Given("User is on Google Home Page")
    public void user_is_on_google_home_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @When("User types in Cheese and hits ENTER")
    public void user_types_in_cheese_and_hits_enter() {
        WebElement google_search=driver.findElement(By.id("APjFqb"));
        google_search.sendKeys("Cheese",Keys.ENTER);


    }
    @Then("Show how many search results were shown")
    public void show_how_many_search_results_were_shown() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("gsr")));
        String resultStats = driver.findElement(By.id("gsr")).getText();
        System.out.println("Number of results found: " + resultStats);


    }
    @And("Close the browser")
    public void close_the_browser() {
     driver.close();
    }
}
