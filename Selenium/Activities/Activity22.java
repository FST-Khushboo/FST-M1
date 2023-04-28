package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/popups");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement popup = driver.findElement(By.xpath("(//button[normalize-space()='Sign In'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(popup).perform();
        String tooltip_message= popup.getAttribute("data-tooltip");
        System.out.println(tooltip_message);
        action.moveToElement(popup).click().perform();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement message = driver.findElement(By.id("action-confirmation"));
        System.out.println(message.getText());
        driver.quit();

    }}

