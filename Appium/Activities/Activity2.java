package Activities_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
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
        this.driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void aboutusTest() throws InterruptedException {
        this.driver.get("https://www.training-support.net/");
        String Title = this.driver.findElement(By.className("android.widget.TextView")).getText();
        System.out.println(Title);
        Thread.sleep(2000L);
        this.driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"About Us\"]")).click();
        Thread.sleep(1000L);
        String PageHeading = this.driver.findElement(By.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println(PageHeading);
    }

    @AfterClass
    public void tearDown() {
    }
}

