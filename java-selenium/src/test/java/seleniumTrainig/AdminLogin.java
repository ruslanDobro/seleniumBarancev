package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class AdminLogin {
    private  static WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @After
    public void stop() {
        driver.quit();
        driver =null;
    }

    @Test
    public void adminLogin() {
        driver.get("http://localhost:8080/litecart/admin/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
