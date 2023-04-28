package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity20
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/javascript-alerts");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement prompt_alert= driver.findElement(By.id("prompt"));
        prompt_alert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread thread = new Thread();
        thread.sleep(1000);
        alert.sendKeys("Awesome!");
        alert.accept();
        driver.quit();

}}
