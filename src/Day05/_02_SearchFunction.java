package Day05;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_SearchFunction extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for "mac" (send the keyword as a parameter from the xml file)
     * Check if all results contains mac key word
     */

    @Test
    @Parameters("searchKeyWord")
    void searchFunctionTest(@Optional("mac") String keyword) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class$='btn-lg']"));
        searchButton.click();

        List<WebElement> resultList = driver.findElements(By.xpath("//div[@class='caption']//h4"));

        for (WebElement element: resultList){
            Assert.assertTrue(element.getText().toLowerCase().contains(keyword.toLowerCase()));
        }
    }
}
