package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String args[])
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        String actualHomeUrl= "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
        String expectedHomeUrl= driver.getCurrentUrl();
        if(actualHomeUrl.equals(expectedHomeUrl)){
            System.out.println(expectedHomeUrl);
        }
        driver.close();

    }
}
