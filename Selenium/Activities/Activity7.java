package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://training-support.net/selenium/drag-drop");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        WebElement src_location=driver.findElement(By.id("draggable"));
        WebElement target_location= driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.clickAndHold();
        action.dragAndDrop(src_location, target_location).pause(2000).perform();
        Thread.sleep(4000);
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        action.dragAndDrop(target_location, dropzone2).click().perform();
        driver.close();

    }
}
