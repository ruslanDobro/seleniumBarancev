package seleniumTrainig.pageObjectModel.tests;

import org.junit.Test;
import seleniumTrainig.pageObjectModel.pages.TestBase;
import seleniumTrainig.pageObjectModel.pages.app.Application;

import static org.junit.Assert.assertTrue;

public class AddRemoveItemsTest extends TestBase {
    @Test
    public void addRemoveItemsFromCart() {
        Application app = new Application();
        app.addItemsToCart();
        app.removeAllItemsFromCart();

    }
}
