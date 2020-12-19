package seleniumTrainig.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {
    private Locators locators = new Locators();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openStore() {
        driver.get(locators.homePage);
    }
    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable((locators.selectProduct))).click();

    }
    public void clickHomeButton() {
        driver.findElement(locators.homeButton).click();
    }
    public void clickCart(){
        driver.findElement(locators.cartButton).click();
    }

}
