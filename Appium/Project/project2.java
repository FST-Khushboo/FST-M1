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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class project2 {
        AndroidDriver driver;
        WebDriverWait wait;
        @BeforeClass
        public void setUp() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.apps.tasks");
            options.setAppActivity(".ui.TaskListsActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(20L));
        }

        @Test(
                priority = 0
        )
        public void googletask() throws InterruptedException {
            String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};



                for (String task : tasks) {
                    this.driver.findElement(AppiumBy.id("tasks_fab")).click();
                    Thread.sleep(1000);
                    this.driver.findElement(AppiumBy.id("add_task_title")).sendKeys(new CharSequence[]{task});
                    Thread.sleep(2000L);
                    this.driver.findElement(AppiumBy.id("add_task_done")).click();
                    Thread.sleep(2000L);
                }


            String first_task = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView")).getText();
            Assert.assertEquals(first_task, "Complete Activity with Google Tasks");
            String second_task = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();
            Assert.assertEquals(second_task, "Complete Activity with Google Keep");
            String third_task = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();
            Assert.assertEquals(third_task, "Complete the second Activity Google Keep");
        }

        @Test(
                priority = 1
        )
        public void setup() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.keep");
            options.setAppActivity(".activities.BrowseActivity");
            options.noReset();
            URL serverURL = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(serverURL, options);
        }

        @Test(
                priority = 2
        )
        public void googleNotes() throws InterruptedException {

            driver.findElement(AppiumBy.accessibilityId("New text note")).click();


            driver.findElement(By.id("editable_title")).sendKeys(new CharSequence[]{"My notes"});
            driver.findElement(By.id("edit_note_text")).sendKeys(new CharSequence[]{"Mynotes xxxxxxxxxxxxxxxxxxxxxxxx"});
            driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
            Thread.sleep(2000L);
            String notes = driver.findElement(By.id("index_note_title")).getText();
            Assert.assertEquals("My notes", notes);
        }

        @AfterClass
        public void tearDown() {
            this.driver.quit();
        }
    }


