package Day07;

import Utilities.DriverClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _04_PlaceOrderElements {

    public _04_PlaceOrderElements() {
        PageFactory.initElements(DriverClass.driver,this); // initialize all elements with driver. driver.findElement(By...)
    }

    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(css = "button[type='button'][class='btn btn-default btn-lg']")
    public WebElement searchButton;

}
