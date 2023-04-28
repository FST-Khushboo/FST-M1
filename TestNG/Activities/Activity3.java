package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3
{
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    public void testCase1()
    {
    driver.findElement(By.xpath("//input[contains(@name,'Username')]")).sendKeys("admin");
    driver.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys("password");
    driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
    WebElement message= driver.findElement(By.xpath("//div[contains(text(),'Welcome Back, admin')]"));
    System.out.println(message.getText());
    Assert.assertEquals("Welcome Back, admin",message.getText());
    }
    @AfterClass
    public void afterClass()
    {
       driver.quit();
    }

}
