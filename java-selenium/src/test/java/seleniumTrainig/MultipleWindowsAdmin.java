package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.junit.Assert.assertTrue;

public class MultipleWindowsAdmin extends TestBase{
    @Test
    public void multipleWindows() {
        openCountryPage();
        switchingWindows();
        assertTrue(driver.getWindowHandles().size()<2);
    }

    private void switchingWindows() {
        var links = driver.findElements(By.cssSelector(".fa-external-link"));
        var originalWindow = driver.getWindowHandle();
        for(WebElement link : links) {
            link.click();
            var existingWindows = driver.getWindowHandles();
            int numberOfWindows = existingWindows.size();
            wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
            String newWindow = "";
            for (String windows : existingWindows) {
                if (!windows.equals(originalWindow)) newWindow = windows;
            }
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

    private void openCountryPage() {
        adminLogin();
        isleep(300);
        driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text() ='United States']"))).click();
    }
}
