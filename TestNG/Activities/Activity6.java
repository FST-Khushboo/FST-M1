package suiteExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6
{
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void testCase1()
    {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    @Parameters({"username","password"})
    public void testCase2(String username,String password) throws InterruptedException {
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    Thread thread = new Thread();
    thread.sleep(1000);
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
    String confirmation_text= driver.findElement(By.id("action-confirmation")).getText();
    System.out.println(confirmation_text);
    Assert.assertEquals("Welcome Back, admin",confirmation_text);
    }
    @AfterClass(alwaysRun = true)
    public void testCase3()
    {
    driver.close();
    }
}
