package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        String ExpectedTitle = driver.getTitle();
        String actualTitle = "SuiteCRM";
        if (actualTitle.equals(ExpectedTitle)) {
            System.out.println(ExpectedTitle);
        }
        driver.close();
    }
}
