package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RemoteStartDriver {
    private WebDriverWait wait;
    InternetExplorerOptions options = new InternetExplorerOptions();
    //ChromeOptions options = new ChromeOptions();
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.159:4444/wd/hub"), options);

    public RemoteStartDriver() throws MalformedURLException {

    }


    @Before
    public void start() {
        options.setCapability("browserName","internet explorer");
        wait = new WebDriverWait(driver, 10);
    }
    @After
    public void stop() {
        driver.quit();
        driver =null;
    }

    @Test
    public void openPage() {
        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.titleIs("Google"));
        assertEquals(driver.getTitle(), ("Google"));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
