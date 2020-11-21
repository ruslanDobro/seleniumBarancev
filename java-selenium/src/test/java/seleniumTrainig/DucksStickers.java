package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class DucksStickers extends TestBase {
    @Test
    public void checkStickers() {
        openStore();
        assertTrue(areElementsPresent(By.xpath("//*[@id='slider-wrapper']/..")));
        WebElement container = driver.findElement(By.xpath("//*[@id='slider-wrapper']/.."));
        var listOfElements = container.findElements(By.xpath("//*[@class='image-wrapper']")).size();
        var listOfStickers = container.findElements(By.xpath("//*[contains(@class,'sticker')]")).size();
        assertEquals(listOfElements,listOfStickers);
    }
}
