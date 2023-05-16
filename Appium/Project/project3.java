package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class project3 {
    WebDriverWait wait;
    AndroidDriver driver;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20L));
    }

    @Test
    public void chromeapp() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.accessibilityId("To-Do List \uf0ae Elements get added at run time")).click();
        Thread.sleep(2000);
        String[] tasks = {"Add tasks to list", "Get number of tasks", "Clear the list"};

        for (String task : tasks) {
            driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys(task);
            driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")")).click();
        }

        Thread.sleep(1000);

        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add tasks to list\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Get number of tasks\")")).click();

        driver.findElement(AppiumBy.androidUIAutomator("text(\"Clear the list\")")).click();
        Thread.sleep(1000);



    }


    @AfterMethod
    public void chrome() {
        //driver.quit();
    }
}
