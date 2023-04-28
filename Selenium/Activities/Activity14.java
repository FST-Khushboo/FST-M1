package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Activity14 {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/tables");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        List<WebElement> rows_count = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr"));
        System.out.println(rows_count.size());
        List<WebElement> column_count = driver.findElements(By.xpath("//*[@id='sortableTable']/thead/tr/th"));
        System.out.println(column_count.size());
         WebElement second_row_second_column= driver.findElement(By.xpath("(//td[@class='negative'])[1]"));
        System.out.println(second_row_second_column.getText());
        Thread thread = new Thread();
        thread.sleep(1000);
        WebElement header = driver.findElement(By.xpath("//*[@id=\"sortableTable\"]/thead/tr/th[1]"));
        header.click();
        List <WebElement> footer_row_cell_value = driver.findElements(By.xpath("//table[@id='sortableTable']//tfoot//tr"));
        for(WebElement footer_row_cell_text:footer_row_cell_value)
        {
            System.out.println(footer_row_cell_text.getText());
        }
        driver.close();
    }
}