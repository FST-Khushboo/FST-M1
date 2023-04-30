package Step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps
{
    WebDriver driver;
    WebDriverWait wait;
    @Given("User is on Login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver= new ChromeDriver(options);
        driver.get("https://www.training-support.net/selenium/login-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @When("User enters username and password")
    public void user_enters_username_and_password() {
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void users_enters_and (String Usernames, String Passwords) throws InterruptedException {
    driver.findElement(By.id("username")).sendKeys(Usernames);
    driver.findElement(By.id("password")).sendKeys(Passwords);
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread thread = new Thread();
        thread.sleep(1000);

    }
    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
    System.out.println(driver.getTitle());
    String message=driver.findElement(By.id("action-confirmation")).getText();
    System.out.println(message);
        if(message.contains("admin")) {
            Assert.assertEquals(message, "Welcome Back, admin");
        } else {
            Assert.assertEquals(message, "Invalid Credentials");
        }
    }

    @And("Close the Browser")
    public void close_the_browser() {
    driver.close();
    }
}
