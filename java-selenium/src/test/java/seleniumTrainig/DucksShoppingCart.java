package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DucksShoppingCart extends TestBase {
    int counter = 1;
    String itemCounter;
    @Test
    public void addItems() {
        addItemToCart();
        addItemToCart();
        addItemToCart();
        removeItemFromCart();
    }

    private void removeItemFromCart() {
        isleep(1000);
        driver.findElement(By.cssSelector("#cart")).click();
        if(areElementsPresent(By.cssSelector(".shortcuts>li"))){
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shortcuts>li"))).click();
        }

        while(!areElementsPresent(By.xpath("//*[contains(text(),'There are no items in your cart.')]"))){
            WebElement amountOfItems = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=quantity]")));
            var numberOfItems = amountOfItems.getAttribute("value");
            int countItems = Integer.parseInt(numberOfItems);
            if(countItems<=0) continue;
            countItems -= 1;
            itemCounter = Integer.toString(countItems);
            amountOfItems.clear();
            amountOfItems.sendKeys(itemCounter);
            WebElement sumOfItem = driver.findElement(By.cssSelector(".sum"));
            WebElement updateCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name=update_cart_item]")));
            updateCart.click();
            wait.until(ExpectedConditions.stalenessOf(sumOfItem));
        }
        driver.findElement(By.cssSelector("p>a")).click();
        WebElement cartEmpty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart .quantity")));
        assertTrue(cartEmpty.getText().equals("0"));

    }

    private void addItemToCart() {
        openStore();
        itemCounter = Integer.toString(counter);
        driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1)>a:not(.fancybox)")).click();
        if(areElementsPresent(By.cssSelector(".options"))) {
            Select selectSize = new Select(driver.findElement(By.cssSelector("select[required]")));
            selectSize.selectByIndex(1);
        }
        wait.until(presenceOfElementLocated(By.cssSelector("button[name=add_cart_product]"))).click();
        var numberOfItems = driver.findElement(By.cssSelector("#cart .quantity"));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfItems,itemCounter));
        counter++;
        assertTrue(numberOfItems.getText().equals(itemCounter));
        driver.findElement(By.cssSelector("[title=Home]")).click();
    }
}
