package seleniumTrainig;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void adminLogin() {
        driver.get("http://localhost:8080/litecart/admin/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }
    public void openStore() {
        driver.get("https://litecart.stqa.ru/en/");
    }
    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }
    @Before
    public void start() {
        if(driver != null){
            wait = new WebDriverWait(driver, 10);
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    }
}
