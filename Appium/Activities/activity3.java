package Activities_appium;



import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity3 {
    AndroidDriver driver;



    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.vivo.calculator");
        options.setAppActivity(".Calculator");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        this.driver = new AndroidDriver(serverURL, options);
    }

    @Test(
            priority = 0
    )
    public void AddTest() throws InterruptedException {
        this.driver.findElement(AppiumBy.id("digit5")).click();
        this.driver.findElement(AppiumBy.id("plus")).click();
        Thread.sleep(2000L);
        this.driver.findElement(AppiumBy.id("digit9")).click();
        this.driver.findElement(AppiumBy.id("equal")).click();
        String result = this.driver.findElement(AppiumBy.id("input_edit")).getText();
        System.out.println("Add 9 + 5 = " + result);
        Assert.assertEquals(result, "14");
    }

    @Test(
            priority = 1
    )
    public void SubTest() throws InterruptedException {
        Thread.sleep(1000L);
        this.driver.findElement(AppiumBy.id("digit1")).click();
        this.driver.findElement(AppiumBy.id("digit0")).click();
        this.driver.findElement(AppiumBy.id("minus")).click();
        Thread.sleep(2000L);
        this.driver.findElement(AppiumBy.id("digit5")).click();
        this.driver.findElement(AppiumBy.id("equal")).click();
        String result = this.driver.findElement(AppiumBy.id("input_edit")).getText();
        System.out.println("Sub 10 - 5 = " + result);
        Assert.assertEquals(result, "5");
    }

    @Test(
            priority = 2
    )
    public void MultiplyTest() throws InterruptedException {
        Thread.sleep(1000L);
        this.driver.findElement(AppiumBy.id("digit5")).click();
        this.driver.findElement(AppiumBy.id("mul")).click();
        Thread.sleep(2000L);
        this.driver.findElement(AppiumBy.id("digit1")).click();
        this.driver.findElement(AppiumBy.id("digit0")).click();
        this.driver.findElement(AppiumBy.id("digit0")).click();
        this.driver.findElement(AppiumBy.id("equal")).click();
        String result = this.driver.findElement(AppiumBy.id("input_edit")).getText();
        System.out.println("Sub 5*100 = " + result);
        Assert.assertEquals(result, "500");
    }

    @Test(
            priority = 3
    )
    public void DivideTest() throws InterruptedException {
        Thread.sleep(1000L);
        this.driver.findElement(AppiumBy.id("digit5")).click();
        this.driver.findElement(AppiumBy.id("digit0")).click();
        this.driver.findElement(AppiumBy.id("div")).click();
        Thread.sleep(2000L);
        this.driver.findElement(AppiumBy.id("digit2")).click();
        this.driver.findElement(AppiumBy.id("equal")).click();
        String result = this.driver.findElement(AppiumBy.id("input_edit")).getText();
        System.out.println("Sub 10 - 5 = " + result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}

