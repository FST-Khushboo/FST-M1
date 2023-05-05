package Activities_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;






    public class Activity1 {
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

        @Test
        public void multiplyTest() throws InterruptedException {
            this.driver.findElement(AppiumBy.id("digit5")).click();
            this.driver.findElement(AppiumBy.id("mul")).click();
            Thread.sleep(2000L);
            this.driver.findElement(AppiumBy.id("digit8")).click();
            this.driver.findElement(AppiumBy.id("equal")).click();
            String result = this.driver.findElement(AppiumBy.id("input_edit")).getText();
            Assert.assertEquals(result, "40");
        }

        @AfterClass
        public void tearDown() {

            this.driver.quit();
        }
    }


