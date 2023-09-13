package Day07;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _01_SearchFunctionWithDataProvider extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod by using data provider
     * Check all results contains these keywords
     * Run the same test with chrome and firefox
     */

    @Test(dataProvider = "searchKeyWord")
    void searchFunctionTest(String search) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(search);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class$='btn-lg']"));
        searchButton.click();

        List<WebElement> resultList = driver.findElements(By.xpath("//div[@class='caption']//h4"));

        for (WebElement element: resultList){
            Assert.assertTrue(element.getText().toLowerCase().contains(search.toLowerCase()));
        }
    }

    @DataProvider
    public Object[][] searchKeyWord(){
        Object[][] keyWord = {
                {"mac"},{"samsung"},{"ipod"}
        };
        return keyWord;
    }
}
