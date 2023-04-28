package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1
{
        WebDriver driver;
        @BeforeMethod
        public void beforeMethod()
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://www.training-support.net");
            System.out.println("launched url successfully");
        }
        @Test
        public void activity1TestCase() {
            String Title= driver.getTitle();
            System.out.println(Title);
            Assert.assertEquals("Training Support",Title);
            driver.findElement(By.id("about-link")).click();
            String Title_newPage= driver.getTitle();
            System.out.println(Title_newPage);
            Assert.assertEquals("About Training Support",Title_newPage);
        }
        @AfterMethod
        public void afterMethod()
        {
         driver.quit();
         System.out.println("closed Url successfully");

    }
}
