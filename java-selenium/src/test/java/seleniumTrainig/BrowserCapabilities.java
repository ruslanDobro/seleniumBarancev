package seleniumTrainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//Setting and getting capabilities of the browser


public class BrowserCapabilities {
    private WebDriver driver;


    @Before
    public void browserCapability() {
        //This function has been deprecated in Java
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen"); //"--start-maximized"
        options.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver(options);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void start() {
        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        System.out.println(capabilities);
    }
}

