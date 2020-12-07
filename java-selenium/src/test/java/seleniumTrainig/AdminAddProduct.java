package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class AdminAddProduct extends TestBase{
    String name;
    @Test
    public void addNewProduct() {
        openCatalogue();
        completeGeneralTab();
        completeInformationTab();
        completePricesTab();
        finishFormWith("save");
        assertTrue(areElementsPresent(By.linkText(name)));
    }

    private void completePricesTab() {
        String purchase_price = "10";
        String gross_prices = "15";
        isleep(300);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Prices"))).click();
        driver.findElement(By.cssSelector("input[type=number][name*=purchase_price]")).clear();
        driver.findElement(By.cssSelector("input[type=number][name*=purchase_price]")).sendKeys(purchase_price);
        new Select(driver.findElement(By.cssSelector("select[name*=purchase_price]"))).selectByIndex(1);
        driver.findElement(By.cssSelector("input[name='gross_prices[USD]']")).clear();
        driver.findElement(By.cssSelector("input[name='gross_prices[USD]']")).sendKeys(gross_prices);
    }

    private void completeInformationTab() {
        String keywords = "trying it out";
        String short_description = "Whistling Top";
        String description = "This is a toy toy toy";
        String head_title = "ula";
        String meta_description = "ula";
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Information"))).click();
        new Select(driver.findElement(By.cssSelector("select[name=manufacturer_id]"))).selectByIndex(1);
        driver.findElement(By.name("keywords")).sendKeys(keywords);
        driver.findElement(By.cssSelector("input[name*=short_description]")).sendKeys(short_description);
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(description);
        driver.findElement(By.cssSelector("input[name*= head_title]")).sendKeys(head_title);
        driver.findElement(By.cssSelector("input[name*= meta_description]")).sendKeys(meta_description);
    }

    private void completeGeneralTab() {
        driver.findElement(By.linkText("General")).click();
        name = "toy";
        String code = "12345";
        String quantity ="5";
        String dateFrom = "12/5/2020";
        String dateTo = "12/10/2020";
        File file = new File("toy.jpg");
        String absolutePath = file.getAbsolutePath();
        isleep(300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name*=name]"))).sendKeys(name);
        driver.findElement(By.cssSelector("input[type=radio]:not([checked])")).click();
        driver.findElement(By.cssSelector("input[name*=code]")).sendKeys(code);
        driver.findElement(By.cssSelector("input[data-name*=Subcategory]")).click();
        driver.findElement(By.xpath("//*[text()='Unisex']/..//input")).click();
        driver.findElement(By.cssSelector("input[name*=quantity]")).clear();
        driver.findElement(By.cssSelector("input[name*=quantity]")).sendKeys(quantity);
        driver.findElement(By.cssSelector("input[name*=images]")).sendKeys(absolutePath);
        driver.findElement(By.name("date_valid_from")).sendKeys(dateFrom);
        driver.findElement(By.name("date_valid_to")).sendKeys(dateTo);
    }

    private void finishFormWith(String action) {
        driver.findElement(By.cssSelector(".button-set button[name="+action+"]")).click();
    }

    private void openCatalogue() {
        adminLogin();
        isleep(300);
        driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td#content a.button:nth-child(2)"))).click();

    }
}
