package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://training-support.net/selenium/ajax");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement change_content_button = driver.findElement(By.xpath("//button[text()='Change Content']"));
        change_content_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);
        WebElement delayedtext = driver.findElement(By.cssSelector("#ajax-content > h3"));
        System.out.println(delayedtext.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String text1 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(text1);
        driver.quit();


    }
}