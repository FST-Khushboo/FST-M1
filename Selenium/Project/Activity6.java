package Activities;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Activity6 {
    static WebDriverWait wait;
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co/crm");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        WebElement navigationMenu = driver.findElement(By.id("toolbar"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_3")));
        System.out.println(navigationMenu.isDisplayed());
        driver.close();
    }
}