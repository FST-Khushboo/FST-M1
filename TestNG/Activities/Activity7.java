package suiteExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7
{
        WebDriver driver;
        @BeforeClass(alwaysRun = true)
        public void testCase1()
        {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            driver.get("https://www.training-support.net/selenium/login-form");
        }

        @DataProvider(name="Authentication")
        public static Object[][] credentials(){
        return new Object[][] { {"admin","password"} };
        }
        @Test(dataProvider = "Authentication")
        public void testCase2(String username,String password)
        {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
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
