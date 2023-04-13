package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Range.range;

import static org.apache.commons.collections4.CollectionUtils.size;


public class Activity8 {
    public static <t_row, t_column> void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        WebElement Accounts = driver.findElement(By.id("moduleTab_9_Accounts"));
        Actions action = new Actions(driver);
        action.moveToElement(sales).perform();
        action.moveToElement(Accounts).click().perform();
        Thread.sleep(1000);
        List<WebElement> rows = driver.findElements(By.xpath("//td[@type='name']"));
        for (int i = 0; i <=9; i++) {
            if (i >= 0)
            {
                System.out.println(rows.get(i).getText());
                i= i + 1;

            }
        }
        driver.close();


    }
}









