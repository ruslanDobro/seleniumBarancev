package seleniumTrainig.pageObjectModel.pages;

import org.openqa.selenium.By;

public class Locators {
    String homePage = "https://litecart.stqa.ru/en/";
    By selectProduct = By.cssSelector("#box-most-popular li:nth-child(1)>a");
    By selectSizeMenu = By.cssSelector(".options");
    By selectProductSize = By.cssSelector("select[required]");
    By addToCartButton = By.cssSelector("button[name=add_cart_product]");
    By numberOfProductsInCart = By.cssSelector("#cart .quantity");
    By homeButton = By.cssSelector("[title=Home]");
    By cartButton = By.cssSelector("#cart");
    By shortcutIcons = By.cssSelector(".shortcuts>li");
    By cartEmptyMessage = By.xpath("//*[contains(text(),'There are no items in your cart.')]");
    By numberOfProductItems = By.cssSelector("input[name=quantity]");
    By elementToBeStale = By.cssSelector(".sum");
    By updateCartButton = By.cssSelector("button[name=update_cart_item]");
    By emptyCartBackLink = By.cssSelector("p>a");

}
