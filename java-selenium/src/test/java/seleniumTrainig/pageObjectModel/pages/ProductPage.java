package seleniumTrainig.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductPage extends Page {
    private Locators locators = new Locators();
    private MainPage mainPage = new MainPage(driver);
    public ProductPage(WebDriver driver){
        super(driver);
    }

    private int counter = 1;
    private String itemCounter;
    private WebElement numberOfItems;
    public void addItem() {
        itemCounter = Integer.toString(counter);
        if(areElementsPresent(locators.selectSizeMenu)) {
            new Select(driver.findElement(locators.selectProductSize)).selectByIndex(1);
        }
        wait.until(elementToBeClickable(locators.addToCartButton)).click();
        numberOfItems = driver.findElement(locators.numberOfProductsInCart);
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfItems,itemCounter));
        counter++;
        //assertTrue(numberOfItems.getText().equals(itemCounter)); //TODO Need to assert in test class
        mainPage.clickHomeButton();
    }
    public String getItemCounter() {
        return itemCounter;
    }
    public WebElement getNumberOfItems(){
        return numberOfItems;
    }

}
