package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class AdminOptions extends TestBase {

    @Test
    public void adminMenuList() {
        adminLogin();
        if (areElementsPresent(By.xpath("//*[@id='box-apps-menu']"))) {
            int countTotalElements = 1;
            for (int i = 0; i < countTotalElements; i++) {
                WebElement containerElement = driver.findElement(By.xpath("//*[@id='box-apps-menu']"));
                countTotalElements = containerElement.findElements(By.xpath("//*[@id=\"app-\"]")).size();
                var listOfElements = containerElement.findElements(By.xpath("//*[@id=\"app-\"]"));
                wait.until(ExpectedConditions.elementToBeClickable(listOfElements.get(i)));
                listOfElements.get(i).click();
                assertTrue(areElementsPresent(By.tagName("h1")));
                if(areElementsPresent(By.xpath("//ul[@class='docs']"))) {
                    int listElements = 1;
                    for( int j = 0; j < listElements; j++ ) {
                    WebElement hasElement = driver.findElement(By.xpath("//ul[@class='docs']"));
                        listElements = hasElement.findElements(By.tagName("span")).size();
                        hasElement.findElements(By.tagName("span")).get(j).click();
                        assertTrue(areElementsPresent(By.tagName("h1")));
                }
                }
            }
        }
    }
}


