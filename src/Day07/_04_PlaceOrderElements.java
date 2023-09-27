package Day07;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _04_PlaceOrderElements { // We are going to locate our elements in this class and call them when we need

    public _04_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver, this); // initialize all elements with driver. driver.findElement(By...)
    }

    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(css = "button[type='button'][class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkOut;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

     @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirmOrder;

    @FindBy(name = "agree")
    public WebElement termsAndConditions;

    @FindBy(xpath = "//div[@id='content']/h1[text()='Your order has been placed!']")
    public WebElement successMessage;
}
