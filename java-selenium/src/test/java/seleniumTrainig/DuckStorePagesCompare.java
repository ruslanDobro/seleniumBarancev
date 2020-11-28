package seleniumTrainig;

import com.google.common.base.CharMatcher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DuckStorePagesCompare extends TestBase {
    private static String mainPage;
    private static String productPage;

    @Test
    public void compareNames() {
        openStore();
        comparePages(By.cssSelector(".name"),By.cssSelector("h1"));
        assertTrue(mainPage.equals(productPage));
    }

    @Test
    public void comparePrices() {
        openStore();
        comparePages(By.cssSelector(".campaign-price"),By.cssSelector(".campaign-price"));
        assertTrue(mainPage.equals(productPage));
        comparePages(By.cssSelector(".regular-price"), By.cssSelector(".regular-price"));
        assertTrue(mainPage.equals(productPage));

    }

    @Test
    public void priceCrossedOut() {
        openStore();
        WebElement mainContainer = driver.findElement(By.cssSelector("#box-campaigns"));
        mainPage = mainContainer.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration-line");
        productPage ="line-through";
        assertTrue(mainPage.equals(productPage));
        mainPage = mainContainer.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String[] arrayOfStrings = mainPage.split(",", 5);
        String previous = CharMatcher.inRange('0', '9').retainFrom(arrayOfStrings[0]);
        for(String number : arrayOfStrings) {
            String current = CharMatcher.inRange('0', '9').retainFrom(number);
            if(!current.equals(previous)) continue;
            assertTrue(previous.equals(current));
            previous = current;
        }
    }

    @Test
    public void campaignPriceBoldColor() {
        openStore();
        /*check Bold*/
            WebElement mainContainer = driver.findElement(By.cssSelector("#box-campaigns"));
            mainPage = mainContainer.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
            if(Integer.parseInt(mainPage)>=600) assertTrue(true);
            else assertTrue(false);
        /*check color*/
            mainPage = mainContainer.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
            String[] arrayOfStrings = mainPage.split(",", 5);
            if(CharMatcher.inRange('0', '9').retainFrom(arrayOfStrings[1]).equals("0") && CharMatcher.inRange('0', '9').retainFrom(arrayOfStrings[2]).equals("0")) assertTrue(true);
            else assertTrue(false);
    }

    @Test
    public void comparePriceSize() {
        int smallPrice;
        int largePrice;

        /*main page price size compare*/
        WebElement mainContainer = driver.findElement(By.cssSelector("#box-campaigns"));
        mainPage = mainContainer.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String regularPriceMain = CharMatcher.inRange('0','9').retainFrom(mainPage);
        smallPrice  = Integer.parseInt(regularPriceMain);
        if(smallPrice > 100){ smallPrice /= 10;}
        productPage = mainContainer.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        String campaignPriceMain = CharMatcher.inRange('0', '9').retainFrom(productPage);
        largePrice  = Integer.parseInt(campaignPriceMain);
        if(largePrice > 100){ largePrice /= 10;}
        assertTrue(smallPrice < largePrice);
        mainContainer.findElement(By.cssSelector("a:not(.fancybox)")).click();
        /* Product page price size compare */
        WebElement productPageContainer = driver.findElement(By.cssSelector("#box-product"));
        mainPage = productPageContainer.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String regularPriceProduct = CharMatcher.inRange('0', '9').retainFrom(mainPage);
        smallPrice  = Integer.parseInt(regularPriceProduct);
        if(smallPrice > 100){ smallPrice /= 10;}
        productPage = productPageContainer.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        String campaignPriceProduct = CharMatcher.inRange('0', '9').retainFrom(productPage);
        largePrice  = Integer.parseInt(campaignPriceProduct);
        if(largePrice > 100){ largePrice /= 10;}
        assertTrue(smallPrice < largePrice);
    }

    private void comparePages(By homePage, By salePage) {
        WebElement mainContainer = driver.findElement(By.cssSelector("#box-campaigns"));
        mainPage = mainContainer.findElement(homePage).getText();
        mainContainer.findElement(By.cssSelector("a:not(.fancybox)")).click();
        WebElement productPageContainer = driver.findElement(By.cssSelector("#box-product"));
        productPage = productPageContainer.findElement(salePage).getText();
        driver.navigate().back();
    }
}
