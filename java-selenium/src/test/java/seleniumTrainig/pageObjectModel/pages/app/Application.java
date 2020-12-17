package seleniumTrainig.pageObjectModel.pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumTrainig.pageObjectModel.pages.CartPage;
import seleniumTrainig.pageObjectModel.pages.MainPage;
import seleniumTrainig.pageObjectModel.pages.ProductPage;


public class Application {
    private WebDriver driver;

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);


    }

    public void quit() {
        driver.quit();
    }



    public void addItemsToCart(){
        mainPage.openStore();
        mainPage.selectProduct();
        productPage.addItem();
        mainPage.selectProduct();
        productPage.addItem();
        mainPage.selectProduct();
        productPage.addItem();
    }
    public void removeAllItemsFromCart(){
        cartPage.removeItems();
    }
    public String numberOfItems(){
        return productPage.getNumberOfItems().getText();
    }
    public String compareItemCounter(){
        return productPage.getItemCounter();
    }
}
