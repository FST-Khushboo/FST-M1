package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class Activity5 {
    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        String color = driver.findElement(By.cssSelector(".desktop-toolbar")).getCssValue("color");
        System.out.println(color);


    }
}
