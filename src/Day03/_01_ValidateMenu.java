package Day03;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_ValidateMenu extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Validate that you see all menu options
     */

    @Test(groups = "MyGroup")
    void validateMenuTest() {
        List<WebElement> menuList = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

        for (WebElement element : menuList) {
            Assert.assertTrue(element.isDisplayed());
        }

        List<String> menuTextList = new ArrayList<>(List.of("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players"));

        for (WebElement element: menuList){
            Assert.assertTrue(menuTextList.contains(element.getText()));
        }
    }
}
