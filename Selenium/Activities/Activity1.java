package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.training-support.net/");
        System.out.println("title of the page:" + driver.getTitle());
        driver.findElement(By.id("about-link")).click();
        System.out.println("title of the new page:" + driver.getTitle());

    }


    }
