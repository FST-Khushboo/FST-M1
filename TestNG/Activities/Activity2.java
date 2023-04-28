package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2
{
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

        @Test
        public void testCase1()
        {
            String title= driver.getTitle();
            System.out.println(title);
            Assert.assertEquals("Target Practice",title);

        }
        @Test
        public void testCase2()
        {
        WebElement black_button=driver.findElement(By.xpath("//button[text()='Black']"));
        Assert.assertTrue(black_button.isDisplayed());
        Assert.assertEquals("Black",black_button.getText());
        }
        @Test(enabled = false)
        public void testCase3()
        {        String subHeading = driver.findElement(By.className("sub")).getText();

            Assert.assertTrue(subHeading.contains("Practice"));

        }

        @Test
        public void testCase4()
        {
           throw new SkipException("skipping test case");
        }
        @AfterClass
        public void afterClass()
        {
        driver.quit();

    }
    }



