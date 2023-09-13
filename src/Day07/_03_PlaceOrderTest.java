package Day07;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class _03_PlaceOrderTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     **/

    @Test(dataProvider = "product")
    void placeOrderTest(String productName) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(productName);

        WebElement searchButton = driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']"));
        searchButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[1]"));
        addToCartButton.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        shoppingCart.click();

        WebElement checkOutButton = driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkOutButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
        WebElement continue1 = driver.findElement(By.id("button-payment-address"));
        continue1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
        WebElement continue2 = driver.findElement(By.id("button-shipping-address"));
        continue2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
        WebElement continue3 = driver.findElement(By.id("button-shipping-method"));
        continue3.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("agree")));
        WebElement termsAndConditions = driver.findElement(By.name("agree"));
        termsAndConditions.click();

        WebElement continue4 = driver.findElement(By.id("button-payment-method"));
        continue4.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        WebElement confirmOrder = driver.findElement(By.id("button-confirm"));
        confirmOrder.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']")));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']"));
        System.out.println("successMessage.getText() = " + successMessage.getText());
        Assert.assertTrue(successMessage.getText().equals("Your order has been placed!"));
    }

    @DataProvider
    public Object[][] product(){

        Object[][] productList = {{"ipod"}};
        return productList;
    }
}
