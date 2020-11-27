package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class CountryZones extends TestBase {
    @Test
    public void checkZoneOrders() {
        adminLogin();
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Canada')]")).click();
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean inOrder;
        String previous = "";
        var list = driver.findElements(By.cssSelector("#table-zones td:nth-child(3)"));
        for (WebElement element : list) {
            String current =  element.getText();
            if (previous.compareToIgnoreCase(current) > 0) {
                System.out.println("Not in order");
            }
            System.out.println(current);
            previous = current;
        }

    }
    }

