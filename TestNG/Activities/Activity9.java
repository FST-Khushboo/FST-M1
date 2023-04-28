package suiteExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class Activity9
{
    WebDriver driver;
    @BeforeTest
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");



    }
    public void screenShotCapture() throws IOException {
        File scrFile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenShotName= new File("C:\\Users\\003IBZ744\\IdeaProjects\\TestNG\\target\\Screenshot\\"+driver.getTitle()+".png");
        FileUtils.copyFile(scrFile,screenShotName);
        Reporter.log("<br><img src='"+screenShotName+"'height='400' width='400'/><br>");

    }
    @BeforeMethod
    public void beforeMethod()
    {
    driver.switchTo().defaultContent();
    }
    @Test(priority = 0)
    public void simpleAlertTestCase() throws IOException {
        WebElement simple_alert = driver.findElement(By.id("simple"));
        simple_alert.click();
        Reporter.log("simple alert opened");
        Alert alert= driver.switchTo().alert();
        Reporter.log("focus switched to alert");
        String alert_text= alert.getText();
        System.out.println(alert_text);
        Reporter.log("Alert text found");
        Assert.assertEquals("This is a JavaScript Alert!",alert_text);
        alert.accept();
        Reporter.log("Alert closed!");
        Reporter.log("Test case execution done");

    }
    @Test(priority = 1)
    public void confirmAlertTestCase() throws IOException {
        WebElement Confirm_alert= driver.findElement(By.id("confirm"));
        Confirm_alert.click();
        Reporter.log("confirm alert opened");
        Alert alert= driver.switchTo().alert();
        Reporter.log("focus switched to alert");
        String alert_text= alert.getText();
        System.out.println(alert_text);
        Reporter.log("Alert text found");
        Assert.assertEquals("This is a JavaScript Confirmation!",alert_text);
        alert.accept();
        Reporter.log("confirm alert test case log");
        screenShotCapture();
    }
    @Test(priority = 2)
    public void promptAlertTestCase() throws IOException {
        WebElement Prompt_alert = driver.findElement(By.id("prompt"));
        Prompt_alert.click();
        Reporter.log("prompt alert opened");
        Alert alert = driver.switchTo().alert();
        Reporter.log("focus switched to alert");
        alert.sendKeys("testing");
        Reporter.log("Value sent in the input box");
        String alert_text = alert.getText();
        System.out.println(alert_text);
        Reporter.log("Alert text found");
        Assert.assertEquals("This is a JavaScript Prompt!", alert_text);
        alert.accept();
        Reporter.log("Prompt alert test case log");
        screenShotCapture();

        }


    @AfterTest
    public void afterTest()
    {
        driver.close();
    }
}
