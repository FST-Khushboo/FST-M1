package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Activity21
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/tab-opener");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement open_tab = driver.findElement(By.id("launcher"));
        open_tab.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println(driver.getWindowHandles());
        for(String handle: driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        for(String handle : driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("content")));
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());

        }




}
