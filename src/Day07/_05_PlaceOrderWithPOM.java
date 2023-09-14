package Day07;

import Utilities.DriverClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _05_PlaceOrderWithPOM extends DriverClass {

    @Test
    void placeOrderTest(){

        _04_PlaceOrderElements elements = new _04_PlaceOrderElements();

        elements.searchInput.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCartButton.click();
        elements.shoppingCart.click();
        elements.checkOut.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue1));
        elements.continue1.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue2));
        elements.continue2.click();

        wait.until(ExpectedConditions.visibilityOf(elements.continue3));
        elements.continue3.click();

        wait.until(ExpectedConditions.visibilityOf(elements.termsAndConditions));
        elements.termsAndConditions.click();

        elements.continue4.click();

        wait.until(ExpectedConditions.visibilityOf(elements.confirmOrder));
        elements.confirmOrder.click();

        wait.until(ExpectedConditions.visibilityOf(elements.successMessage));
        Assert.assertTrue(elements.successMessage.getText().equals("Your order has been placed!"));
    }
}
