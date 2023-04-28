package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity15 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[starts-with(@class,'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class,'password-')]")).sendKeys("password");
        WebElement button_message=driver.findElement(By.xpath("//button[@type='submit']"));
        button_message.click();
        Thread thread = null;
        thread.sleep(1000);
        WebElement button_text = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        System.out.println(button_text.getText());
        driver.close();


    }
}