package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;


public class SeleniumGrid {
    private WebDriverWait wait;
    InternetExplorerOptions options = new InternetExplorerOptions();
    ChromeOptions optionsChrome = new ChromeOptions();
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.235:4444/wd/hub"), options);
    WebDriver driverChrome = new RemoteWebDriver(new URL("http://192.168.1.235:4444/wd/hub"), optionsChrome);

    public SeleniumGrid() throws MalformedURLException {

    }


    @Before
    public void start() {
        options.setCapability("browserName","internet explorer");
        options.setCapability("platform", "WINDOWS");
        optionsChrome.setCapability("browserName","chrome");
        optionsChrome.setCapability("platform", "MAC");
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

        driverChrome.get("https://www.google.com/");
        wait.until(ExpectedConditions.titleIs("Google"));
        assertEquals(driverChrome.getTitle(), ("Google"));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
