package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity16 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        userName.sendKeys("NewUser");
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        password.sendKeys("password");
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input"));
        confirmPassword.sendKeys("password");
        WebElement email_id= driver.findElement(By.xpath("//label[text()='Email']/following::input"));
        email_id.sendKeys("real_email@xyz.com");
        driver.findElement(By.xpath("//button[contains (text(),'Sign Up')]")).click();
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        driver.close();




    }
}