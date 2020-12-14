package seleniumTrainig;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class BrowserLogs extends TestBase{
     static List<LogEntry> logs;
     boolean errorPresent = false;

    @Test
    public void productLogs() {
        adminLogin();
        openProductCatalogue();
        clickThroughProducts();
        assertFalse(errorPresent);
    }

    private void logsPrintOut(){
        if(logs.size()>0) {
            for(LogEntry l : logs) System.out.println("LOG MESSAGE: " + l);
            errorPresent = true;
        }

    }

    private void clickThroughProducts() {
        int size = 1;
        for(int i =0; i < size; i ++ ) {
            int numberOfElements = driver.findElements(By.cssSelector(".dataTable a:not([title=Edit])")).size();
            var list = driver.findElements(By.cssSelector(".dataTable a:not([title=Edit])"));
            list.get(i).click();
            logs = driver.manage().logs().get("browser").getAll();
            logsPrintOut();
            if(numberOfElements < size) i = 0;
            size = numberOfElements;
            if (areElementsPresent(By.cssSelector(".index"))) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".index")));
                driver.navigate().back();
            }
        }

    }

    private void openProductCatalogue() {
        isleep(300);
        driver.findElement(By.xpath("//span[contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Rubber Ducks')]")).click();
    }
}
