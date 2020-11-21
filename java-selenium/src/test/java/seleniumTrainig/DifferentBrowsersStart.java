package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentBrowsersStart {
    private  static WebDriver driver;
    private WebDriver driver1;
    private WebDriverWait wait;
    @Before
    public void start() {
        driver1 = new ChromeDriver();
        driver = new ChromeDriver();
//        driver = new SafariDriver();
//        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @After
    public void stop() {
        driver.quit();
        driver1.quit();
        driver =null;
    }
    @Test
    public void adminLogin(){
        driver.get("http://localhost:8080/litecart/admin/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test
    public void secondDriver() {
        driver1.get("https://www.google.com/");
    }
}
