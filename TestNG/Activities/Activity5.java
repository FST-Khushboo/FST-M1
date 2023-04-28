package suiteExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity5
{
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test(groups = {"HeaderTests","ButtonTests"})
    public void testCase1()
    {
    String title= driver.getTitle();
    System.out.println(title);
        Assert.assertEquals("Target Practice",title);
    }
    @Test(dependsOnMethods = {"testCase1"},groups = {"HeaderTests"})
    public void Header1()
    {
        String third_header = driver.findElement(By.tagName("h3")).getText();
        System.out.println(third_header);
        Assert.assertEquals("Third header", third_header);
    }
    @Test(dependsOnMethods = {"testCase1"},groups = {"HeaderTests"})
    public void Header2()
        {
        WebElement fifth_header= driver.findElement(By.tagName("h5"));
        System.out.println(fifth_header.getCssValue("color"));
        Assert.assertEquals(fifth_header.getCssValue("color"), "rgb(33, 186, 69)");
    }
    @Test(dependsOnMethods = {"testCase1"},groups = {"ButtonTests"})
    public void Button1()
    {
        String olive_button = driver.findElement(By.xpath("//button[text()='Olive']")).getText();
        System.out.println(olive_button);
        Assert.assertEquals("Olive", olive_button);
    }

    @Test(dependsOnMethods = {"testCase1"},groups = {"ButtonTests"})
    public void Button2()
    {
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        System.out.println(button2.getCssValue("color"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");

    }
    @AfterClass(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }
}
