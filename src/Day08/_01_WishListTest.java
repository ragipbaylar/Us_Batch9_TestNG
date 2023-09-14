package Day08;

import Day07._04_PlaceOrderElements;
import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_WishListTest extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for ipod (send "ipod" from xml file)
     * add one of the elements to the wish list randomly
     * Click on Wish List button
     * Check if the name of the element is the same with the name of the element you added.
     * Use POM
     * Perform non-parallel cross browser test
     */
    @Test
    @Parameters(value = "searchKeyword")
    void wishListTest(@Optional(value = "ipod") String search) {

        _04_PlaceOrderElements elements1 = new _04_PlaceOrderElements();
        _02_WishListElements elements2 = new _02_WishListElements();

        elements1.searchInput.sendKeys(search);
        elements1.searchButton.click();

        int randomIndex = (int) (Math.random() * elements2.getProductList().size());
//        Math.random(); // creates numbers 0-0.9999999999
//        Math.random()*5;// creates numbers 0-4.999999999
//        (int)(Math.random()*5) // creates numbers 0-4

        String productName = elements2.getProductList().get(randomIndex)
                .findElement(By.cssSelector("div[class='caption']>h4>a")).getText();

        elements2.getProductList().get(randomIndex)
                .findElement(By.cssSelector("button[data-original-title='Add to Wish List']>i")).click();

        elements2.getWishList().click();

        Assert.assertTrue(elements2.getProductNameInWishList().getText().equals(productName));
        elements2.getRemoveFromWishListButton().click();
    }

}
