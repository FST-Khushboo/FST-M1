package Activities_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".main.MainActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
    }

    @Test
    public void newcontact() {
        driver.findElement(By.id("start_chat_fab")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        driver.findElement(By.id("recipient_text_view")).sendKeys("7708704592");


        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));


        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");

        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();


        String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }


    @AfterClass
    public void tearDown() {

//        driver.quit();
    }}