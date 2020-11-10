package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
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
    public void myFirstTest() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@name=\"q\"]")).sendKeys("webdriver");
        driver.findElement(By.xpath("//*[@value=\"Google Search\"]")).click();
        wait.until(titleIs("webdriver - Google Search"));
    }

    @Test
    public void openAmazon() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone x");
        driver.findElement(By.xpath("//*[@value='Go']")).click();
        wait.until(titleContains("iphone x"));

    }
}
