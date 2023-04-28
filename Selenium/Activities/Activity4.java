package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/selenium/target-practice");
        driver.manage().window().maximize();
        System.out.println("title of the page is:"+driver.getTitle());
        String te=driver.findElement(By.xpath("//h3[text()= 'Third header']")).getText();
        System.out.println(te);
        String te1=driver.findElement(By.xpath("//h5[text()= 'Fifth header']")).getCssValue("color");
        System.out.println(te1);
        String btn=driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println(btn);
        String greybtn= driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println(greybtn);
        driver.close();


    }
}
