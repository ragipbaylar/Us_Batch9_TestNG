package Day08;

import Utilities.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class _02_WishListElements {

    public _02_WishListElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class^='product-layout']")
    private List<WebElement> productList;

    @FindBy(css = "li>a[href*='/wishlist']")
    private WebElement wishList;

    @FindBy(css = "td[class='text-left']>a")
    private WebElement productNameInWishList;

    @FindBy(css = "a[data-original-title='Remove']")
    private WebElement removeFromWishListButton;

    public List<WebElement> getProductList() {
        return productList;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getProductNameInWishList() {
        return productNameInWishList;
    }

    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }
}
