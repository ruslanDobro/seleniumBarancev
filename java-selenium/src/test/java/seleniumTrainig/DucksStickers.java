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
        var listOfElements = container.findElements(By.xpath("//*[@class='image-wrapper']"));
        for (WebElement element:listOfElements) {
            int expected =1;
            int actual = element.findElements(By.cssSelector("[class*=sticker]")).size();
            assertEquals(expected,actual);
        }
    }
}
