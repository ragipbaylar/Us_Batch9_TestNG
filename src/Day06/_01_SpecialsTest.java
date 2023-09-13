package Day06;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_SpecialsTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Click on Specials
     * Check if all products are on sale and new price is lower than the first price
     * Run this test with 2 different browsers in parallel
     * **/

    @Test
    void specialsTest(){

        WebElement specials = driver.findElement(By.xpath("//a[text()='Specials']"));
        specials.click();

        List<WebElement> productList = driver.findElements(By.xpath("//div[starts-with(@class,'product-layout')]"));
        List<WebElement> oldPriceList = driver.findElements(By.cssSelector("span[class='price-old']"));

        Assert.assertTrue(productList.size()==oldPriceList.size());

        for (WebElement biggerElement: productList){
            WebElement oldPriceElement = biggerElement.findElement(By.cssSelector("span[class='price-old']"));
            //div[starts-with(@class,'product-layout')]//span[@class='price-old'] -> above code works exactly the same way
            // If you are using another to locate an element never use xpath as locator. Because xpath scans the entire html document
            // to find that element. So there is a risk of locating wrong element

            WebElement newPrice = biggerElement.findElement(By.cssSelector("span[class='price-new']"));
            //div[starts-with(@class,'product-layout')]//span[@class='price-new'] -> above code works exactly the same way

            String oldPriceStr = oldPriceElement.getText().replaceAll("[^0-9.]","");
            System.out.println("oldPriceStr = " + oldPriceStr);
            String newPriceStr = newPrice.getText().replaceAll("[^0-9.]","");
            System.out.println("newPriceStr = " + newPriceStr);

            Assert.assertTrue(Double.parseDouble(oldPriceStr)>Double.parseDouble(newPriceStr));
        }
    }
}
