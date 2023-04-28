package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/javascript-alerts");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement confirm_alert = driver.findElement(By.id("confirm"));
        confirm_alert.click();
        Thread thread = new Thread();
        thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        thread.sleep(1000);
        alert.accept();
        thread.sleep(1000);
        confirm_alert.click();
        alert.dismiss();
        driver.quit();

    }
}