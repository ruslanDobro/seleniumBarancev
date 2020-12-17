package seleniumTrainig.pageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class CartPage extends Page {
    private MainPage mainPage = new MainPage(driver);
    private Locators locators = new Locators();
    public CartPage(WebDriver driver){
        super(driver);
    }

    private String itemCounter;
    private WebElement cartEmpty;

    public void removeItems() {
        isleep(300);
        mainPage.clickCart();
        if(areElementsPresent(locators.shortcutIcons)){
            wait.until(ExpectedConditions.elementToBeClickable(locators.shortcutIcons)).click();
        }

        while(!areElementsPresent(locators.cartEmptyMessage)){
            WebElement amountOfItems = wait.until(ExpectedConditions.elementToBeClickable(locators.numberOfProductItems));
            var numberOfItems = amountOfItems.getAttribute("value");
            int countItems = Integer.parseInt(numberOfItems);
            if(countItems<=0) continue;
            countItems -= 1;
            itemCounter = Integer.toString(countItems);
            amountOfItems.clear();
            amountOfItems.sendKeys(itemCounter);
            WebElement sumOfItem = driver.findElement(locators.elementToBeStale);
            WebElement updateCart = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.updateCartButton));
            updateCart.click();
            wait.until(ExpectedConditions.stalenessOf(sumOfItem));
        }
        clickEmptyCartBackButton();
        cartEmpty = wait.until(ExpectedConditions.visibilityOfElementLocated(locators.numberOfProductsInCart));
        //assertTrue(cartEmpty.getText().equals("0"));// TODO assert it in test class

    }
    public void clickEmptyCartBackButton(){
        driver.findElement(locators.emptyCartBackLink).click();
    }
    public String getIsCartEmpty() {
        return cartEmpty.getText();
    }

}
