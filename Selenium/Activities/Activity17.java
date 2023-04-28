package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/selects");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select drp_values = new Select(dropdown);
        drp_values.selectByVisibleText("Option 2");
        System.out.println(drp_values.getFirstSelectedOption().getText());
        drp_values.selectByIndex(3);
        System.out.println(drp_values.getFirstSelectedOption().getText());
        drp_values.selectByValue("4");
        System.out.println(drp_values.getFirstSelectedOption().getText());
        List<WebElement> options= drp_values.getOptions();
        for(WebElement allOptions:options)
        {
          System.out.println(allOptions.getText());
        }
        driver.quit();
    }
}