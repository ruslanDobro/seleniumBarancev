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


public class CloudGrid {
    public static final String USERNAME = "rusland3";
    public static final String AUTOMATE_KEY = "eUqU93oUFrEEuY7xaxLq";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private WebDriverWait wait;
    InternetExplorerOptions options = new InternetExplorerOptions();
    WebDriver driver = new RemoteWebDriver(new URL(URL), options);

    public CloudGrid() throws MalformedURLException {

    }


    @Before
    public void start() {
        options.setCapability("os", "Windows");
        options.setCapability("os_version", "10");
        options.setCapability("browser", "Internet Explorer");
        options.setCapability("browser_version", "11");
        options.setCapability("name", "rusland3's First Test");
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
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
