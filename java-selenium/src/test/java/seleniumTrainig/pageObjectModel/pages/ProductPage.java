package seleniumTrainig.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductPage extends Page {
    private Locators locators = new Locators();
    private MainPage mainPage = new MainPage(driver);
    public ProductPage(WebDriver driver){
        super(driver);
    }

    private int counter = 1;
    private String itemCounter;
    public void addItem() {
        itemCounter = Integer.toString(counter);
        if(areElementsPresent(locators.selectSizeMenu)) {
            new Select(driver.findElement(locators.selectProductSize)).selectByIndex(1);
        }
        wait.until(elementToBeClickable(locators.addToCartButton)).click();
        WebElement numberOfItems = driver.findElement(locators.numberOfProductsInCart);
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfItems,itemCounter));
        counter++;
        mainPage.clickHomeButton();
    }
    public String getItemCounter() {
        return itemCounter;
    }
    public String getNumberOfItems(){
        return driver.findElement(locators.numberOfProductsInCart).getText();
    }

}
