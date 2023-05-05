package Activities_appium;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        this.driver = new AndroidDriver(serverURL, options);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
    }

    @Test
    public void newcontact() {
        driver.findElement(By.id("floating_action_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='First name']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys(new CharSequence[]{"Aaditya"});
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys(new CharSequence[]{"Varma"});
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys(new CharSequence[]{"999148292"});
        driver.findElement(By.id("toolbar_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("large_title")));
        String contactName = this.driver.findElement(By.id("large_title")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

