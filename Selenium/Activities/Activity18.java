package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity18 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/selects");
        driver.manage().window().maximize();
        System.out.println("Home page title: " + driver.getTitle());
        WebElement multi_select = driver.findElement(By.id("multi-select"));
        Select drp_values = new Select(multi_select);
        drp_values.selectByVisibleText("Javascript");
        System.out.println(drp_values.getFirstSelectedOption().getText());
        for(int i=4;i<=6;i++)
        {
            drp_values.selectByIndex(i);
            
        }
        List<WebElement> selectedOptions= drp_values.getAllSelectedOptions();
        for(WebElement All_selected_options:selectedOptions)
        {
            System.out.println(All_selected_options.getText());
        }
        drp_values.selectByValue("node");
        drp_values.deselectByIndex(5);
        List <WebElement> selected_options= drp_values.getAllSelectedOptions();
        for(WebElement all_options_selected :selected_options)
        {
        System.out.println(all_options_selected.getText());
        }
        driver.quit();





    }
}