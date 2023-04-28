package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity12
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        driver.manage().window().maximize();
        System.out.println("title of the page:"+driver.getTitle());
        WebElement text_field= driver.findElement(By.id("input-text"));
        System.out.println(text_field.isEnabled());
        WebElement input_field= driver.findElement(By.id("toggleInput"));
        input_field.click();
        System.out.println(text_field.isEnabled());
        driver.close();

    }
}
