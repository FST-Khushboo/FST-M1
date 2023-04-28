package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/login-form");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println("the title of the page is:" +driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui button")).click();
        System.out.println("login is working fine");
        driver.close();



    }
}
