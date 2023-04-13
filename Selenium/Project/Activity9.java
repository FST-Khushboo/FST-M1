package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Activity9 {
    public static <JavaScriptexecutor> void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
        Actions action = new Actions(driver);
        action.moveToElement(sales).perform();
        action.moveToElement(leads).click().perform();
        Thread thread = new Thread();
        thread.sleep(1000);
        List<WebElement> leads_table_name_column= driver.findElements(By.xpath("(//td[@type='name'])"));
        for(WebElement column_name:leads_table_name_column)
        {
            System.out.println("names of the name columns are:"+column_name.getText());
        }
        thread.sleep(1000);
        List<WebElement> leads_table_users_column= driver.findElements(By.xpath("(//td[@type='relate'])"));
        for(WebElement column_user:leads_table_users_column)
        {
           System.out.println("names of the users are:"+column_user.getText());
        }
        driver.close();



    }
}