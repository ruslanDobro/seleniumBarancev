package seleniumTrainig.pageObjectModel.tests;

import org.junit.Test;
import seleniumTrainig.pageObjectModel.pages.TestBase;
import static org.junit.Assert.assertTrue;

public class AddRemoveItemsTest extends TestBase {
    @Test
    public void addRemoveItemsFromCart() {
        app.addItemsToCart();
        assertTrue(app.numberOfItems().equals(app.compareItemCounter()));
        app.removeAllItemsFromCart();
        assertTrue(app.isCartEmpty().equals("0"));

    }
}
