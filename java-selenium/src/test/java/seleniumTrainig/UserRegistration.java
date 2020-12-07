package seleniumTrainig;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserRegistration extends TestBase {
    String email;
    String password;
    @Test
    public void newUserRegistration() {
        openStore();
        driver.findElement(By.xpath("//a[contains(text(),'New customer')]")).click();
        isleep(300);
        registerNewUser();
        loginIntoAccount();
    }

    private void loginIntoAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=login]")));
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=login]")).click();

        /*logout*/
        isleep(500);
        driver.findElement(By.xpath("//*[text() = \"Logout\"]")).click();
        assertTrue(driver.findElements(By.cssSelector("[name=login]")).size()>0);
    }

    private void registerNewUser() {
        int random = (int)(Math.random() * 1000 + 1);
        String firstname = "John";
        String lastname = "Smith";
        String address1 = "115 New York Ave";
        String city = "New York";
        String postcode = "10004";
        String phone = "212-345-6789";
        email = "johnsmith"+random+"@selenium.com";
        password = "Automation123";
        String confirmed_password = "Automation123";

        HashMap<String,String> textInput = new HashMap<String, String>(){{
                    put("firstname",firstname); put("lastname", lastname);
                    put("address1",address1);put("postcode",postcode);
                    put("phone",phone); put("city", city);
                    put("email", email); put("password",password);
                    put("confirmed_password", confirmed_password);
                }};

        for(String text : textInput.keySet()) {
            var webText = driver.findElement(By.cssSelector("form [name="+text+"]"));
            webText.sendKeys(textInput.get(text));
        }
        driver.findElement(By.cssSelector("form .selection")).click();
        WebElement selectCountry = driver.findElement(By.cssSelector("[role=textbox]"));
        selectCountry.sendKeys("United States" + Keys.ENTER);

        Select selectZipcode = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        selectZipcode.selectByVisibleText("New York");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        /*logout*/
        WebElement logout = wait.until(presenceOfElementLocated(By.xpath("//*[text() = \"Logout\"]")));
        logout.click();
    }
}
