package Step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step_definition
{
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    JavascriptExecutor js;
    @Given("User is on the page")
    public void user_is_on_the_page()
    {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");


    }
    @When("User clicks the Simple Alert button")
    public void user_clicks_the_simple_alert_button() {
       driver.findElement(By.xpath("//button[@id='simple']")).click();
    }
    @When("User clicks the Confirm Alert button")
    public void user_clicks_the_confirm_alert_button() {
        driver.findElement(By.xpath("//button[@id='confirm']")).click();
    }
    @When("User clicks the Prompt Alert button")
    public void user_clicks_the_prompt_alert_button() {
        driver.findElement(By.xpath("//button[@id='prompt']")).click();
    }
    @Then("Alert opens")
    public void alert_opens() {
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void read_the_text_from_it_and_print_it() {
      System.out.println(alert.getText());

    }
    @And("Write a custom message in it")
    public void write_a_custom_message_in_it() throws InterruptedException {
        //wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.sendKeys("Custom Message");
    }


    @And("Close the alert")
    public void closeAlert() {
        alert.accept();
    }
    @And("Close the alert with Cancel")
    public void close_the_alert_with_cancel() {
        alert.dismiss();
    }

    @And("Close Browser")
    public void close_browser() {
        driver.close();
    }

}
