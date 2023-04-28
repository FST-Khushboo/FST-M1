package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Activity13 {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/tables");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
       List<WebElement> rows_count = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr"));
       System.out.println(rows_count.size());
        List<WebElement> column_count = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td"));
        System.out.println(column_count.size());
        WebElement third_row_text=driver.findElement(By.xpath("(//tr)[4]"));
        System.out.println(third_row_text.getText());
        WebElement second_row_second_column = driver.findElement(By.xpath("(//td[contains(text(),'Initial commit')])[2]"));
        System.out.println(second_row_second_column.getText());
        driver.close();

    }
}