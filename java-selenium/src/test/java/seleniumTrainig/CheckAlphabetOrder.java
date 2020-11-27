package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class CheckAlphabetOrder extends TestBase {
    @Test
    public void countryTab() {
        adminLogin();
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        areElementsPresent(By.cssSelector(".dataTable .row"));
        assertTrue(areElementsInOrder(By.cssSelector(".dataTable .row a:not([title=Edit])")));
        checkZoneIndex();
    }

    @Test
    public void geoZones() {
        //adminLogin();
        driver.findElement(By.xpath("//span[contains(text(),'Geo Zones')]")).click();
        checkGeoZones();
    }

    private void checkGeoZones() {
        int countTotalElements = 1;
        for (int i = 0; i < countTotalElements; i++) {
            countTotalElements = driver.findElements(By.cssSelector(".dataTable .row")).size();
            var listOfElements = driver.findElements(By.cssSelector(".dataTable td:nth-child(3)"));
            listOfElements.get(i).findElement(By.cssSelector(".dataTable td:nth-child(3)>a")).click();

            assertTrue(areElementsInOrder(By.cssSelector("#table-zones td:nth-child(3)>select option[selected]")));
            driver.navigate().back();
        }
    }
    private void checkZoneIndex() {
        int countTotalElements = 1;
        for (int i = 0; i < countTotalElements; i++) {
            countTotalElements = driver.findElements(By.cssSelector(".dataTable .row td:nth-child(6)")).size();
            var listOfElements = driver.findElements(By.cssSelector(".dataTable .row td:nth-child(6)"));
            String text = listOfElements.get(i).getText();
            int zoneNumber = Integer.parseInt(text);
            if (zoneNumber > 0) {
                listOfElements.get(i).findElement(By.xpath("../td/a")).click();
                assertTrue(areElementsInOrder(By.cssSelector("#table-zones td:nth-child(3)")));
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.navigate().back();
            }
        }
    }

    private boolean areElementsInOrder(By locator) {
        String previous = "";
        var list = driver.findElements(locator);
        for (WebElement element : list) {
            String current = element.getAttribute("textContent");
            if(current.isEmpty()) continue;
            if (previous.compareToIgnoreCase(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}

